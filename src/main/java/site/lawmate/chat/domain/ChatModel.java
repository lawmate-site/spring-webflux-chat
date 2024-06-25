package site.lawmate.chat.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("chats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatModel {
    @Id String userId;
    String question;
    String answer;

    @Override
    public String toString() {
        return "ChatModel [question=" + question +
                ", answer=" + answer +
                "]";
    }
}
