package br.com.olx.activation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ActivationApplication

fun main(args: Array<String>) {
	runApplication<ActivationApplication>(*args)
}
