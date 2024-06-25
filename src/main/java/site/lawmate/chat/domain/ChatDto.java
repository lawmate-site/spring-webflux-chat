package site.lawmate.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {
    private Long userId;
    private ObjectId chatId;
    private Integer index;
    private Date timeStamp;
    private String question;
    private String answer;

}
