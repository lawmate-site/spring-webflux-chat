package site.lawmate.chat.service;

import io.micrometer.observation.ObservationFilter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import site.lawmate.chat.domain.Chat;
import site.lawmate.chat.domain.ChatDto;

public interface ChatService {

    Mono<Chat> save(ChatDto chatDto);

    Object findById(String id);
    Object findAll();
    Object update(String id, ChatDto chatDto);

    Mono<Void> deleteByChatDto(ChatDto chatDto);

    Mono<Long> createRoom(Long userId);
}
