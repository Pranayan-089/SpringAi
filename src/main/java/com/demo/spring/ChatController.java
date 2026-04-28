package com.demo.spring;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	
	private ChatClient chatClient;
	
	public ChatController(ChatClient.Builder builder) {
		this.chatClient=builder.build();
	}
	
	@GetMapping("/chat/{ques}")
	public String getResponse(@PathVariable String ques) {
		String response=chatClient.prompt(ques).call().content();
		return response;
	}
	
}
