package com.local.latihan_spring.mapper;


import com.local.latihan_spring.model.Product;
import com.local.latihan_spring.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "createdAt", expression = "java(formatInstant(product.getCreatedAt()))")
    ProductDto toProductDTO(Product product);
    Product toProduct(ProductDto productDto);


    default String formatInstant(Instant instant) {
        return instant == null ? null :
                instant.atZone(ZoneId.of("Asia/Jakarta"))
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
