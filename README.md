# Demonstration of Problem when using inline class for property

## Introduction

I tried to provide type-safe IDs that could be distinguished from normal types.

## `IdTypes.kt` 

```kotlin
inline class StringID(val value: String) : Serializable
inline class LongID(val value: Long) : Serializable

inline fun StringID.v() = this.value
inline fun LongID.v() = this.value
inline fun String.toID() = StringID(this)
inline fun Long.toID() = LongID(this)
```

The entity will be:
```kotlin
@NodeEntity("User")
class User {
    @Id
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
```

## Reproduce the Problem

`IdTypes.kt` contains 2 sections, by commenting the first section and using the second section it should work as expected.

This should work because the names aren't mangled lke with `inline class`

```kotlin
typealias StringID = String
typealias LongID = Long

inline fun StringID.v() = this
inline fun LongID.v() = this
inline fun String.toID() = this
inline fun Long.toID() = this
```
