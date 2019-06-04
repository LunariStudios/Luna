package com.lunari.luna

import com.uchuhimo.konf.Config
import com.uchuhimo.konf.ConfigSpec
import java.io.File

object LunaConfig : ConfigSpec(kLunaPrefix) {
    val token by required<String>(name = kTokenKey, description = "The Discord Application token to use")
}

fun lunaConfigFromFile(p: File) = Config {
    this.addSpec(LunaConfig)
}.from.yaml.file(p)