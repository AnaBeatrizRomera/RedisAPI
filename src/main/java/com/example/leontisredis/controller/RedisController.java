package com.example.leontisredis.controller;

import com.example.leontisredis.service.RedisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counter")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Operation(summary = "Incrementa o contador Redis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contador incrementado com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "500", description = "Erro ao incrementar o contador", content = @Content)
    })
    @PostMapping("/increment")
    public Long incrementCounter() {
        return redisService.incrementCounter();
    }

    @Operation(summary = "Decrementa o contador Redis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contador decrementado com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "500", description = "Erro ao decrementar o contador", content = @Content)
    })
    @PostMapping("/decrement")
    public Long decrementCounter() {
        return redisService.decrementCounter();
    }

    @Operation(summary = "Obtém o valor atual do contador Redis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Valor do contador obtido com sucesso", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o valor do contador", content = @Content)
    })
    @GetMapping("/buscar")
    public Long getCounterValue() {
        return redisService.getCounterValue();
    }
}
