package ddn.test.java_test.controller.impl;

import ddn.test.java_test.constant.ParamNameConstants;
import ddn.test.java_test.controller.PriceApi;
import ddn.test.java_test.dto.PriceDTO;
import ddn.test.java_test.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PriceController implements PriceApi {

  private final PriceService priceService;

  public ResponseEntity<List<PriceDTO>> getAll(
      Optional<String> productId, Optional<String> brandId, Optional<String> applicationDate) {
    Map<String, String> params = createParamMap(productId, brandId, applicationDate);
    List<PriceDTO> priceDTOList = priceService.findAllByParams(params);
    if (priceDTOList.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(priceDTOList);
  }

  private Map<String, String> createParamMap(
      Optional<String> productId, Optional<String> brandId, Optional<String> applicationDate) {

    Map<String, String> map = new HashMap<>();

    applicationDate.ifPresent(date -> map.put(ParamNameConstants.APPLICATION_DATE, date));
    brandId.ifPresent(id -> map.put(ParamNameConstants.BRAND_ID, id));
    productId.ifPresent(id -> map.put(ParamNameConstants.PRODUCT_ID, id));

    return map;
  }
}
