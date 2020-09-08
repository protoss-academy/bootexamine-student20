package com.protosstechnology.train.bootexamine.controller;

import com.protosstechnology.train.bootexamine.entity.Document;
import com.protosstechnology.train.bootexamine.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/document")
public class DocumentController {

    static final Logger LOGGER = LoggerFactory.getLogger(DocumentController.class);

    @Autowired
    DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> addDocument(@RequestBody Document document){
        LOGGER.info("addDocument");

        documentService.create(document);

        LOGGER.info("Document Id = {}",document.getId());
        return ResponseEntity.ok().body(document);

    }

    @Operation(summary = "Get Document by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Found the Document",
                        content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Document.class)) }),
            @ApiResponse(
                    responseCode = "400" , description = "Invalid id Document",
                    content = @Content),
            @ApiResponse(
                    responseCode = "404" , description = "Document not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable("id") String id){
        LOGGER.info("getDocument id={}",id);

        return ResponseEntity.ok().body(documentService.read(Integer.parseInt(id)));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable("id")String id,
                                                    @RequestBody Document document){
        document.setId(Integer.parseInt(id));
        documentService.update(document);
        LOGGER.info("updateDocument id={}",document.getId());
        return ResponseEntity.ok().body(document);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable("id")String id){
        String responseStr = new String();
        try{
            documentService.delete(Integer.parseInt(id));
            responseStr = "Delete Document{"+id+"} Successful";
        }catch (Exception e){
            responseStr = "Delete User{"+id+"} Fail!";
        }
        return ResponseEntity.ok().body(responseStr);
    }

}
