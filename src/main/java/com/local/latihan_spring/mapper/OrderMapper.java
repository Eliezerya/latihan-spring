package com.local.latihan_spring.mapper;

import com.local.latihan_spring.model.OrderDetail;
import com.local.latihan_spring.model.dto.OrderDetailDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDetailDto toOrderDetailDTO(OrderDetail detail);

    List<OrderDetailDto> toDetailsDTO(List<OrderDetail> details);
}
