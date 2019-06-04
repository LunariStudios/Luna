plugins {
    kotlin("jvm") version "1.3.31"
}

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://jitpack.io")

}

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
    api("com.discord4j:discord4j-core:3.0.6")
    api("com.xenomachina:kotlin-argparser:2.0.7")
    api("com.uchuhimo:konf:0.13.3")
}