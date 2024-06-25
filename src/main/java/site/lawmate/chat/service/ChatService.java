package site.lawmate.chat.service;

import reactor.core.publisher.Mono;
import site.lawmate.chat.domain.Chat;
import site.lawmate.chat.domain.ChatDto;

public interface ChatService {
    Mono<Chat> save(ChatDto chatDto);

    Object findById(String id);

    Object findAll();

    Object update(String id, ChatDto chatDto);

    Object delete(String id);


}
