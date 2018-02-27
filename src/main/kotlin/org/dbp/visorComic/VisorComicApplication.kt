package org.dbp.visorComic

import org.dbp.visorComic.core.ComicPropiedades
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ComicPropiedades::class)
class VisorComicApplication

fun main(args: Array<String>) {
    runApplication<VisorComicApplication>(*args)
}
