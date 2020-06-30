package com.example.demoinlineclasspropertybug

import java.io.Serializable
// ### Uncomment below for tests to fail
//inline class StringID(val value: String) : Serializable
//inline class LongID(val value: Long) : Serializable
//
//inline fun StringID.v() = this.value
//inline fun LongID.v() = this.value
//inline fun String.toID() = StringID(this)
//inline fun Long.toID() = LongID(this)

// ### Uncomment below for tests to pass
typealias StringID = String
typealias LongID = Long

inline fun StringID.v() = this
inline fun LongID.v() = this
inline fun String.toID() = this
inline fun Long.toID() = this
