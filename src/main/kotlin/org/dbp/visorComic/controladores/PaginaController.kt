package org.dbp.visorComic.controladores

import org.dbp.visorComic.core.ComicPropiedades
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.io.IOException
import org.springframework.web.bind.annotation.ResponseBody



@RestController
class PaginaController(@Autowired val propiedades: ComicPropiedades){
    @GetMapping("/comic/{name}/{capitulo}")
    fun capitulos(@PathVariable("name") comic:String,@PathVariable("capitulo") capitulo:String):List<String>{
        System.out.println("Capitulos")
        return File(propiedades.path+"/"+comic+"/"+capitulo)
                .listFiles()
                .filter { it.isFile  && it.name.toUpperCase().endsWith(".JPEG")}
                .map {it.name.replace(".JPEG","",true)}
                .sortedWith(Comparator { o1, o2 -> o1.toInt().compareTo(o2.toInt()) })
                .sorted()
                .toList()
    }

    @GetMapping(value = "/comic/{name}/{capitulo}/{pagina}", produces = [MediaType.IMAGE_JPEG_VALUE])
    @ResponseBody
    @Throws(IOException::class)
    fun getImageWithMediaType(
            @PathVariable("name") comic:String,
            @PathVariable("capitulo") capitulo:String,
            @PathVariable("pagina") pagina:String): ByteArray {

        return File(propiedades.path+"/"+comic+"/"+capitulo+"/"+pagina+".jpeg").readBytes()
    }

}