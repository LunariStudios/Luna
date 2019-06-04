package com.lunari.luna.command

import com.lunari.luna.logger
import discord4j.core.event.domain.message.MessageCreateEvent

class CommandManager {
    fun process(e: MessageCreateEvent) {
        logger.info("$e @ ${e.guildId}, ${e.member}")
        e.guild.subscribe {
            e.message.channel.subscribe {
                it.createMessage("Received message: '$e'")
            }
        }
    }
}