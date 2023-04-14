package ddn.test.java_test.mapper;

import ddn.test.java_test.dto.PriceDTO;
import ddn.test.java_test.model.PriceEntity;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    builder = @Builder(disableBuilder = true))
public interface PriceMapper {

  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "brandId", source = "brandId")
  @Mapping(target = "priceList", source = "priceList")
  @Mapping(target = "startDate", source = "startDate")
  @Mapping(target = "endDate", source = "endDate")
  @Mapping(target = "price", source = "price")
  PriceDTO toDTO(PriceEntity entity);
}
