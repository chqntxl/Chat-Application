package lo.chantal.app.controller;

import lo.chantal.app.model.ChatMessage;
import lo.chantal.app.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody ChatMessage chatMessage) {
        chatService.sendMessage(chatMessage.getSender(), chatMessage.getContent());
    }

    @GetMapping("/history")
    public List<ChatMessage> getHistory() {
        return chatService.getChatHistory();
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) {
        chatService.sendMessage(message.getSender(), message.getContent());
        return message;
    }
}

