package ddn.test.java_test.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

  private Long productId;
  private Long brandId;
  private Long priceList;
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime startDate;
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime endDate;
  private Float price;
}
