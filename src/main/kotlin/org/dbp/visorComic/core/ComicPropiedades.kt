package org.dbp.visorComic.core

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "comic")
class ComicPropiedades(
        var path:String=""
) {
// Nota: Tenemos que usar el var, por que Spring lo exige :(, para poder cargar los datos.
}