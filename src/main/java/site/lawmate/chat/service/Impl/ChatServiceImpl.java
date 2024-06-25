package site.lawmate.chat.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.lawmate.chat.domain.Chat;
import site.lawmate.chat.domain.ChatDto;
import site.lawmate.chat.repository.ChatRepository;
import site.lawmate.chat.service.ChatService;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public Object save(ChatDto chatDto) {
//        return chatRepository.save(new Chat(chatDto.getUserId(),chatDto.getChatId(),chatDto.getIndex(),chatDto.getQuestion(), chatDto.getAnswer()));
        return null;
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
