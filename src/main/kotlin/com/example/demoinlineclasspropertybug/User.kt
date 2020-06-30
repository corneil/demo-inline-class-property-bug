package com.example.demoinlineclasspropertybug

import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.Index
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Property
import org.neo4j.ogm.annotation.Required
import org.springframework.data.neo4j.repository.Neo4jRepository

@NodeEntity("User")
class User {
    @Id
    @Property(name = "userId")
    var userId: StringID? = null

    @Index
    @Required
    var email: String? = null

    @Required
    var fullName: String? = null

    constructor()
    constructor(userId: StringID, email: String, fullName: String) {
        this.userId = userId
        this.email = email
        this.fullName = fullName
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (userId != other.userId) return false

        return true
    }

    override fun hashCode(): Int {
        return userId?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "User(userId=$userId, email=$email, fullName=$fullName)"
    }
}


interface UserRepository : Neo4jRepository<User, StringID> {
    fun findByUserId(userId: StringID): User?
    fun findByEmailIgnoreCase(email: String): User?
}