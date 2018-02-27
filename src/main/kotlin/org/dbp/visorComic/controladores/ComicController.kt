package org.dbp.visorComic.controladores

import org.dbp.visorComic.core.ComicPropiedades
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ComicController(@Autowired val propiedades:ComicPropiedades) {
    //@Value("\${comic.path}")  lateinit var path:String;

    @GetMapping("/comics")
    fun comic():List<String>{
        return ArrayList<String>()
    }

    @GetMapping("/{comic}/capitulos")
    fun capitulos(@PathVariable comic:String):List<String>{
        System.out.println("Path ${propiedades.path}")
        return ArrayList<String>()
    }

}