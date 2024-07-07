package com.marchuk.csv.processor.controllers;

import com.marchuk.csv.processor.annotations.GlobalApiResponses;
import com.marchuk.csv.processor.entities.SimpleCsv;
import com.marchuk.csv.processor.services.CsvService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/csv")
@GlobalApiResponses
@Tag(name = "CSV Operations")
public class CsvController {

    private final CsvService service;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Upload a CSV file", description = "Uploads a CSV file to the server")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Upload a CSV file"),
            @ApiResponse(responseCode = "400",
                    description = "Invalid request body"
            )
    })
    public void uploadCsv(@RequestParam("file") MultipartFile file) {
        service.saveCsv(file);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Search CSV data", description = "Searches CSV data based on a query string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Data is received",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = SimpleCsv.class))))
    })
    public List<SimpleCsv> searchCsv(@RequestParam("query") String query) {
        return service.search(query);
    }

}