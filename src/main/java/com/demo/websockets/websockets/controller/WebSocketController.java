package com.demo.websockets.websockets.controller;

import com.demo.websockets.websockets.payload.Message;
import com.demo.websockets.websockets.payload.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message, SimpMessageHeaderAccessor headerAccessor)  {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.from(), message.text(), time);
    }
}
