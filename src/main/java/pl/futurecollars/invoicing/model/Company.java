package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

  @ApiModelProperty(value = "Tax identification number", required = true, example = "552-168-66-00")
  private String taxIdentificationNumber;

  @ApiModelProperty(value = "Company address", required = true, example = "ul. Mazowiecka 134, 32-525 Radzionkow")
  private String address;

  @ApiModelProperty(value = "Company name", required = true, example = "Invoice House Ltd.")
  private String name;

}
