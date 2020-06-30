package com.example.demoinlineclasspropertybug

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoInlineClassPropertyBugApplicationTests : Neo4JTestBase() {
	@Autowired
	lateinit var userRepository: UserRepository

	@Test
	fun testCreateUser() {
		val saved = userRepository.save(User("corneil".toID(), "corneil.duplessis@gmail.com", "Corneil du Plessis"))
		val loadedById = userRepository.findByUserId("corneil".toID())
		assertNotNull(loadedById)
		assertEquals(loadedById!!.userId!!.v(), "corneil")
		val loadedByEmail = userRepository.findByEmailIgnoreCase("CORNEIL.DUPLESSIS@GMAIL.COM")
		assertNotNull(loadedByEmail)
		assertEquals(loadedByEmail!!.userId!!.v(), "corneil")
		assertEquals(loadedByEmail!!.email!!, "corneil.duplessis@gmail.com")
	}
}
