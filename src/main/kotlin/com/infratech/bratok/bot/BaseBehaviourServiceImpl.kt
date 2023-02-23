package com.infratech.bratok.bot

import dev.inmo.tgbotapi.bot.TelegramBot
import dev.inmo.tgbotapi.extensions.api.bot.deleteMyCommands
import dev.inmo.tgbotapi.extensions.api.bot.getMe
import dev.inmo.tgbotapi.extensions.api.bot.getMyCommands
import dev.inmo.tgbotapi.extensions.api.bot.setMyCommands
import dev.inmo.tgbotapi.extensions.api.send.reply
import dev.inmo.tgbotapi.extensions.behaviour_builder.buildBehaviourWithLongPolling
import dev.inmo.tgbotapi.extensions.behaviour_builder.triggers_handling.onCommand
import dev.inmo.tgbotapi.extensions.utils.extensions.raw.from
import dev.inmo.tgbotapi.types.BotCommand
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BaseBehaviourServiceImpl(
    private val bot: TelegramBot
) : BotAddBehaviourService {

    private val log = LoggerFactory.getLogger(javaClass)

    override suspend fun addBehaviour() {

        bot.buildBehaviourWithLongPolling {

            log.info("getMe=${getMe()}")

            if (bot.getMyCommands().isNotEmpty()) {
                bot.deleteMyCommands()
            }

            bot.setMyCommands(
                BotCommand("get_bazar", "Пояснить базар"),
                BotCommand("top", "Передать братку инвайт-код")
            )

            onCommand("start") {
                log.info("chat.id=${it.chat.id}, messageId=${it.messageId}, from=${it.from}")
                reply(it, "Здорова ёпта, оп оп оп!")
            }

            onCommand("help") {
                log.info("chat.id=${it.chat.id}, messageId=${it.messageId}, from=${it.from}")
                reply(it, "Чё не алё базар ёпта?")
            }

        }.join()
    }
}