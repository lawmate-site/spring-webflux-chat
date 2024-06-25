package site.lawmate.chat.service;

import site.lawmate.chat.domain.ChatDto;

public interface ChatService {
    Object save(ChatDto chatDto);

    Object findById(String id);

    Object findAll();

    Object update(String id, ChatDto chatDto);

    Object delete(String id);


}
