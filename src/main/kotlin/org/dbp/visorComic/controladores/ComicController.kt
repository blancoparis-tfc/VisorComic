package org.dbp.visorComic.controladores

import org.dbp.visorComic.core.ComicPropiedades
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class ComicController(@Autowired val propiedades:ComicPropiedades) {

    @GetMapping("/comics")
    fun comic():List<String>{
        System.out.println("comics")
        return File(propiedades.path).listFiles()
                .filter { it.isDirectory }
                .map { it.name }
                .toList()
    }

}