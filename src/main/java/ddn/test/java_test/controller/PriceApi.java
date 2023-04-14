package ddn.test.java_test.controller;

import ddn.test.java_test.dto.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequestMapping("/price")
public interface PriceApi {

  @GetMapping
  ResponseEntity<List<PriceDTO>> getAll(
      @RequestParam Optional<String> productId,
      @RequestParam Optional<String> brandId,
      @RequestParam Optional<String> applicationDate);
}
