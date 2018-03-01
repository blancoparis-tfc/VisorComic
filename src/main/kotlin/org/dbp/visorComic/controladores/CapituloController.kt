package org.dbp.visorComic.controladores

import org.dbp.visorComic.core.ComicPropiedades
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
class CapituloController(@Autowired val propiedades: ComicPropiedades){

    @GetMapping("/comic/{name}")
    fun capitulos(@PathVariable("name") comic:String):List<String>{
        System.out.println("Capitulos")
        return File(propiedades.path+"/"+comic)
                .listFiles()
                .filter { it.isDirectory }// && it.name.toUpperCase().endsWith(".JPEG")}
                .map {it.name}
                .sortedWith(Comparator { o1, o2 -> o1.toInt().compareTo(o2.toInt()) })
                .toList()
    }
}