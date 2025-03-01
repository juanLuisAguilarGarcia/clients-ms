package com.pichincha.infra.api.router.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDto {
    @NotBlank
    @JsonProperty("type_id")
    private Integer typeId;
    @NotNull
    private Integer number;
}
