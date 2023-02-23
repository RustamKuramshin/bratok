package com.infratech.bratok.bot

import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationContext
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class BotInitializr(
    private val applicationContext: ApplicationContext
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun botInit() = runBlocking {
        log.info("ApplicationReadyEvent: bot init")
        applicationContext.getBeansOfType(BotAddBehaviourService::class.java).forEach {
            log.info("Call addBehaviour() method on bean: ${it.key}")
            it.value.addBehaviour()
        }
    }
}