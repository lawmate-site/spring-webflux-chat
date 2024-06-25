package site.lawmate.chat.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import site.lawmate.chat.domain.Chat;
import site.lawmate.chat.domain.ChatDto;
import site.lawmate.chat.repository.ChatRepository;
import site.lawmate.chat.service.ChatService;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public Mono<Chat> save(ChatDto chatDto) {
        Chat chat = Chat.builder()
                .userId(chatDto.getUserId())
                .chatId(chatDto.getChatId())
                .index(chatDto.getIndex())
                .timeStamp(chatDto.getTimeStamp())
                .question(chatDto.getQuestion())
                .answer(chatDto.getAnswer())
                .build();
        return chatRepository.save(chat);
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
    public Object delete(String id) {
        return null;
    }
}
