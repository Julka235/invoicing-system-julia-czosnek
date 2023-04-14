package pl.futurecollars.invoicing.helpers

import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import pl.futurecollars.invoicing.model.InvoiceEntry
import pl.futurecollars.invoicing.model.Vat

import java.time.LocalDate

class TestHelpers {
    static company(int id) {
        Company.builder()
                .taxIdentificationNumber("$id")
                .address("ul. Bukowinska 24d/$id 02-703 Warszawa, Polska")
                .name("iCode Trust $id Sp. z o.o")
                .pensionInsurance(BigDecimal.TEN * BigDecimal.valueOf(id))
                .healthInsurance(BigDecimal.valueOf(100) * BigDecimal.valueOf(id))
                .build()
    }

    static product(int id) {
        InvoiceEntry.builder()
                .description("Programming course $id")
                .quantity(id)
                .netPrice(BigDecimal.valueOf(id * 1000))
                .vatValue(BigDecimal.valueOf(id * 1000 * 0.08))
                .vatRate(Vat.VAT_8)
                .build()
    }

    static invoice(int id) {
        Invoice.builder()
                .date(LocalDate.now())
                .buyer(company(id + 10))
                .seller(company(id))
                .entries((1..id).collect { product(it) })
                .build()
    }
}
