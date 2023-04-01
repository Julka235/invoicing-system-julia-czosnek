package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntry {

  @ApiModelProperty(value = "Product/service description", required = true, example = "Laptop Lenovo IdeaPad S540")
  private String description;

  @ApiModelProperty(value = "Number of items", required = true, example = "20")
  private int quantity;

  @ApiModelProperty(value = "Product/service net price", required = true, example = "3549.99")
  private BigDecimal price;

  @ApiModelProperty(value = "Product/service tax value", required = true, example = "354.95")
  private BigDecimal vatValue;

  @ApiModelProperty(value = "Tax rate", required = true)
  private Vat vatRate;

}
