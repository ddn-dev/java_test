package ddn.test.java_test.service.impl;

import ddn.test.java_test.dto.PriceDTO;
import ddn.test.java_test.mapper.PriceMapper;
import ddn.test.java_test.model.PriceEntity;
import ddn.test.java_test.repository.PriceRepository;
import ddn.test.java_test.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;
  private final PriceMapper priceMapper;

  @Override
  public List<PriceDTO> findAllByParams(Map<String, String> params) {
    List<PriceEntity> priceEntities =
        priceRepository.findPriceByProductIdBrandIdAndApplicationDate(params);
    return priceEntities.stream().map(priceMapper::toDTO).collect(Collectors.toList());
  }
}
