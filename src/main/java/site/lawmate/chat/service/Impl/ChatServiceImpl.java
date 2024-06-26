package site.lawmate.chat.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import site.lawmate.chat.domain.Chat;
import site.lawmate.chat.domain.ChatDto;
import site.lawmate.chat.repository.ChatRepository;
import site.lawmate.chat.service.ChatService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final AtomicInteger atomicInteger = new AtomicInteger(0); // messageOrder 증가를 위한 AtomicInteger


    @Override
    public Mono<Chat> save(ChatDto chatDto) {
        // userId와 chattingRoomId로 최대 messageOrder 조회
        Mono<Integer> maxOrderMono = chatRepository.findByUserIdAndChattingRoomId(chatDto.getUserId(), chatDto.getChattingRoomId())
                .sort(Comparator.comparing(Chat::getMessageOrder).reversed())
                .next()
                .map(Chat::getMessageOrder)
                .switchIfEmpty(Mono.just(0));

        // 최대 messageOrder가 없는 경우 1로 초기화
        return maxOrderMono.flatMap(maxOrder -> {
            // 조회된 최대 messageOrder에 1을 더하여 chatDto에 설정
            chatDto.setMessageOrder(maxOrder + 1);
            return chatRepository.save(Chat.builder()
                    .userId(chatDto.getUserId())
                    .chattingRoomId(chatDto.getChattingRoomId())
                    .question(chatDto.getQuestion())
                    .answer(chatDto.getAnswer())
                    .messageOrder(chatDto.getMessageOrder())
                    .chatDate(LocalDateTime.now())
                    .build());
                });
    }

    @Override
    public Mono<Long> createRoom(Long userId) {
        return chatRepository.findByUserId(userId)
                .sort(Comparator.comparing(Chat::getChattingRoomId).reversed())
                .next()
                .map(chat -> chat.getChattingRoomId() + 1)
                .switchIfEmpty(Mono.just(1L));
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object findAll() {
        return null;
    }

    @Override
    public Object update(String id, ChatDto chatDto) {
        return null;
    }

    @Override
    public Mono<Void> deleteByChatDto(ChatDto chatDto) {
        return chatRepository.deleteByUserIdAndChattingRoomId(chatDto.getUserId(), chatDto.getChattingRoomId());
    }




}
