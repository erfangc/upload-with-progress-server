package com.example.uploadwithprogressserver

import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile

data class UploadResponse(val message: String)

@Controller
class UploadController {
    private val log = LoggerFactory.getLogger(UploadController::class.java)

    @RequestMapping(
        value = ["upload"],
        method = [RequestMethod.POST],
        consumes = ["multipart/form-data"],
        produces = ["application/json"],
    )
    fun upload(@RequestParam file: MultipartFile): ResponseEntity<UploadResponse> {
        log.info(
            "Uploading file bytes=${file.bytes} " +
                    "contentType=${file.contentType} " +
                    "size=${file.size} " +
                    "originalFilename=${file.originalFilename} "
        )
        return ResponseEntity
            .status(200)
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*")
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*")
            .body(UploadResponse(message = "Ok"))
    }
     @RequestMapping(
        value = ["upload"],
        method = [RequestMethod.OPTIONS],
        consumes = ["*/*"],
    )
    fun uploadPreflight(): ResponseEntity<String> {
        return ResponseEntity
            .status(200)
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*")
            .header(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*")
            .body("Ok")
    }
    
}
