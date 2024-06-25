package site.lawmate.chat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import site.lawmate.chat.domain.ChatDto;
import site.lawmate.chat.service.ChatService;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Object save(@RequestBody ChatDto chatDto){
        log.info("컨트롤러단 save : {}", chatDto.getAnswer());
        return chatService.save(chatDto);
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
