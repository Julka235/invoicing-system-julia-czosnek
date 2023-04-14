package pl.futurecollars.invoicing.controller.tax;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.futurecollars.invoicing.model.Company;
import pl.futurecollars.invoicing.service.TaxCalculatorResult;

@RequestMapping(value = "tax", produces = {"application/json;charset=UTF-8"})
@Api(tags = {"tax-controller"})
public interface TaxCalculatorApi {

  @ApiOperation(value = "Get incomes, costs, vat and taxes to pay")
  @PostMapping
  TaxCalculatorResult calculateTaxes(@RequestBody Company company);

}
