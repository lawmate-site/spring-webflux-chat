package site.lawmate.chat.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import site.lawmate.chat.domain.ChatModel;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<ChatModel, String> {

}
