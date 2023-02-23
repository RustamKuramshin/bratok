package com.infratech.bratok.bot

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.bot.ktor.telegramBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BotConfiguration(
    @Value("\${telegram.bot.token}")
    private val telegramBotToken: String
) {

    @Bean
    fun getTelegramBot(): TelegramBot = telegramBot(telegramBotToken)
}