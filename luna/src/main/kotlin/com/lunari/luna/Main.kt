package com.lunari.luna

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default
import kotlin.concurrent.thread

class LunaArguments(parser: ArgParser) {
    val configFilePath by parser.storing("-N", "--name",
            help = "The path to the configuration file ")
            .default("config.yaml")
}

fun main(args: Array<String>) {
    val lunaArgs = LunaArguments(ArgParser(args))
    val luna = Luna(lunaArgs)
    luna.connect()
    Runtime.getRuntime().addShutdownHook(thread(false) {
        print("ggwp")
        luna.shutdown()
    })
}