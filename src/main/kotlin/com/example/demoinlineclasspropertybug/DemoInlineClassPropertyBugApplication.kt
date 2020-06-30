package com.example.demoinlineclasspropertybug

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoInlineClassPropertyBugApplication

fun main(args: Array<String>) {
	runApplication<DemoInlineClassPropertyBugApplication>(*args)
}
