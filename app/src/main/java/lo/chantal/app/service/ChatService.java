package lo.chantal.app.service;

import lo.chantal.app.component.MessageStorage;
import lo.chantal.app.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MessageStorage messageStorage;

    public void sendMessage(String sender, String content) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        ChatMessage message = new ChatMessage(sender, content, timestamp);
        messageStorage.addMessage(message);
    }

    public List<ChatMessage> getChatHistory() {
        return messageStorage.getAllMessages();
    }
}
