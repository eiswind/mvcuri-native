package com.example.mcvuri;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class McvuriApplicationTests {



	@Test
	void testPost(@Autowired WebTestClient client) {

		client.post().uri("/api1").exchange().expectStatus().isCreated();
	}



}
