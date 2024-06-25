package site.lawmate.chat.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import site.lawmate.chat.domain.Chat;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<Chat, ObjectId> {

}
