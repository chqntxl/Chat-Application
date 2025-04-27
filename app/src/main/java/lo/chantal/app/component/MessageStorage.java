package lo.chantal.app.component;

import lo.chantal.app.model.ChatMessage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageStorage {

    private final List<ChatMessage> messages = new ArrayList<>();

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getAllMessages() {
        return new ArrayList<>(messages);
    }
}

