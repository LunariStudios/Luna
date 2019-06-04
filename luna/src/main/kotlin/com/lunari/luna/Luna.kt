package com.lunari.luna

import com.lunari.luna.command.CommandManager
import com.uchuhimo.konf.Config
import discord4j.core.DiscordClient
import discord4j.core.DiscordClientBuilder
import discord4j.core.event.domain.message.MessageCreateEvent
import java.io.File

class Luna(args: LunaArguments) {


    val client: DiscordClient
    val commandManager: CommandManager

    init {
        val p = File(args.configFilePath)
        logger.info("Using config file '${p.path}' (${p.absolutePath}) ${LunaConfig.token.path}")
        val config = lunaConfigFromFile(p)
        printConfiguration(config)
        val token = config[LunaConfig.token]
        logger.info("Using token '$token'")
        client = DiscordClientBuilder(token).build()
        commandManager = CommandManager()
    }

    fun connect() {
        logger.info("Logging in..")
        client.login().block()
        logger.info("Logged")
        client.eventDispatcher.on(MessageCreateEvent::class.java).subscribe(commandManager::process)
        logger.info("Subscribed to events")
    }

    fun shutdown() {
        logger.info("Shutting down...")
        if (client.isConnected) {
            logger.info("Logging out...")
            client.logout().block()
            logger.info("Logged out")
        }
    }


}