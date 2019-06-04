package com.lunari.luna

import com.uchuhimo.konf.Config

fun printConfiguration(config: Config) {
    logger.info("Configuration: ${config.name}")
    val srcs = config.sources
    if (srcs.isNotEmpty()) {
        logger.info("Sources (${srcs.count()}): ")
        for (source in srcs) {
            logger.info("$source: ${source.description}")
        }
    } else {
        logger.info("No sources defined")
    }
}