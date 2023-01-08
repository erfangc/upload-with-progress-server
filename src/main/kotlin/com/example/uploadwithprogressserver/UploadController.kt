package com.example.uploadwithprogressserver

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@CrossOrigin
class UploadController {
    private val log = LoggerFactory.getLogger(UploadController::class.java)

    @PostMapping(value = ["upload"])
    fun upload(@RequestParam file: MultipartFile): UploadResponse {
        log.info(
            "Uploading file " + "contentType=${file.contentType} " + "size=${file.size} " + "originalFilename=${file.originalFilename} "
        )
        return UploadResponse(message = "Ok")
    }
}
