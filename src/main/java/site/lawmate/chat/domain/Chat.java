package site.lawmate.chat.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("chats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Long userId;
    @Id
    private ObjectId chatId;
    private Integer index;
    private Date timeStamp;
    private String question;
    private String answer;

}
