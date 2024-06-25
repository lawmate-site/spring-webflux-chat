package site.lawmate.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import site.lawmate.chat.domain.Chat;
import site.lawmate.chat.domain.ChatDto;
import site.lawmate.chat.service.ChatService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/temp")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> temp(@RequestBody Mono<String> tempQuestion){
        return tempQuestion.doOnNext(question -> log.info("질문받은 메세지 : {}", question))
                .map(question -> "안녕하세요?");
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Chat> save(@RequestBody Mono<ChatDto> chatDtoMono){
        return chatDtoMono.doOnNext(chatDto -> log.info("컨트롤러단 save : {}", chatDto.getAnswer()))
                .flatMap(chatService::save);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object findById(@PathVariable String id){
        log.info("컨트롤러단 id : {}", id);
        return chatService.findById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Object findAll(){
        return chatService.findAll();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Object update(@PathVariable("id") String id,@RequestBody ChatDto chatDto){
        log.info("컨트롤러단 update : {}", chatDto.getAnswer());
        return chatService.update(id, chatDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Object delete(@PathVariable("id") String id){
        log.info("컨트롤러단 id : {}", id);
        return chatService.delete(id);
    }

}
