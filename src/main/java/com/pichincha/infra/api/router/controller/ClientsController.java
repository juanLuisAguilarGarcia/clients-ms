package com.pichincha.infra.api.router.controller;

import com.pichincha.infra.api.router.RouterConsts;
import com.pichincha.infra.api.router.controller.dto.GenericResponseDTO;
import com.pichincha.infra.api.router.controller.dto.request.CreateClientDto;
import com.pichincha.infra.api.router.controller.dto.response.client.ClientDto;
import com.pichincha.infra.api.router.controller.mapper.ClientDtoMapper;
import com.pichincha.infra.api.router.facade.ClientsFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import static com.pichincha.infra.api.router.RouterConsts.MSG_CONFIRMATION_DELETE;
import static com.pichincha.infra.api.router.RouterConsts.PARAM_CLIENT_ID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(RouterConsts.CROSS_ORIGIN)
@RestController
@RequestMapping(path = RouterConsts.CONTROLLER_PATH)
@Tag(name = RouterConsts.API)
public class ClientsController {

    @Autowired
    private ClientDtoMapper clientDtoMapper;

    @Autowired
    private ClientsFacade clientsFacade;

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = RouterConsts.API_OPERATION_CREATE_CLIENT, description = RouterConsts.NOTE_API_OPERATION_CREATE_CLIENT)
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = RouterConsts.API_RESPONSE_COD_200,
                    content =  { @Content( schema = @Schema(implementation =  ClientDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = RouterConsts.API_RESPONSE_COD_400,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = RouterConsts.API_RESPONSE_COD_404,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = RouterConsts.API_RESPONSE_COD_422,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = RouterConsts.API_RESPONSE_COD_500,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<ClientDto> createClient(
            @Parameter(description = RouterConsts.API_PARAM_REQUEST_CREATE_CLIENT, required = true) @Validated @RequestBody(required = true) CreateClientDto clientDto){
        ClientDto response = clientsFacade.createClient(clientDtoMapper.toEntity(clientDto));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{client_id}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = RouterConsts.API_OPERATION_GET_CLIENT_BY_ID, description = RouterConsts.NOTE_API_OPERATION_CREATE_CLIENT)
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = RouterConsts.API_RESPONSE_COD_200,
            content =  { @Content( schema = @Schema(implementation =  ClientDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = RouterConsts.API_RESPONSE_COD_400,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = RouterConsts.API_RESPONSE_COD_404,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = RouterConsts.API_RESPONSE_COD_422,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = RouterConsts.API_RESPONSE_COD_500,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<ClientDto> getClientById(
            @Parameter(description = RouterConsts.API_PARAM_REQUEST_GET_CLIENT, required = true) @PathVariable(name = PARAM_CLIENT_ID ) Integer clientId){
        ClientDto response = clientsFacade.getClientById(clientId);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{client_id}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = RouterConsts.API_OPERATION_DELETE_CLIENT, description = RouterConsts.NOTE_API_OPERATION_CREATE_CLIENT)
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = RouterConsts.API_RESPONSE_COD_200,
            content =  { @Content( schema = @Schema(implementation =  GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = RouterConsts.API_RESPONSE_COD_400,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = RouterConsts.API_RESPONSE_COD_404,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = RouterConsts.API_RESPONSE_COD_422,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = RouterConsts.API_RESPONSE_COD_500,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<GenericResponseDTO> deleteClient(
            @Parameter(description = RouterConsts.API_PARAM_REQUEST_GET_CLIENT, required = true) @PathVariable(name = PARAM_CLIENT_ID) Integer clientId){
        clientsFacade.deleteClient(clientId);

        return ResponseEntity.ok(GenericResponseDTO.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(MSG_CONFIRMATION_DELETE).build());
    }

    @PutMapping(value = "/{client_id}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = RouterConsts.API_OPERATION_CREATE_CLIENT, description = RouterConsts.NOTE_API_OPERATION_CREATE_CLIENT)
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = RouterConsts.API_RESPONSE_COD_200,
            content =  { @Content( schema = @Schema(implementation =  ClientDto.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = RouterConsts.API_RESPONSE_COD_400,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "404", description = RouterConsts.API_RESPONSE_COD_404,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "422", description = RouterConsts.API_RESPONSE_COD_422,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = RouterConsts.API_RESPONSE_COD_500,
                    content =  { @Content( schema = @Schema(implementation = GenericResponseDTO.class), mediaType = APPLICATION_JSON_VALUE)})
    })
    public ResponseEntity<ClientDto> updateClient(
            @Parameter(description = RouterConsts.API_OPERATION_UPDATE_CLIENT, required = true) @PathVariable(name = PARAM_CLIENT_ID) Integer clientId,
            @Parameter(description = RouterConsts.API_PARAM_REQUEST_UPDATE_CLIENT, required = true) @Validated @RequestBody(required = true) CreateClientDto clientDto){
        ClientDto response = clientsFacade.updateClient(clientDtoMapper.toEntityWithId(clientDto, clientId));

        return ResponseEntity.ok(response);
    }
}
