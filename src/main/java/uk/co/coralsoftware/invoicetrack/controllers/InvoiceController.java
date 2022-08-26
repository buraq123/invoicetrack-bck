package uk.co.coralsoftware.invoicetrack.controllers;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.coralsoftware.invoicetrack.classes.LineItem;
import uk.co.coralsoftware.invoicetrack.dto.InvoiceRequest;
import uk.co.coralsoftware.invoicetrack.dto.LineItemRequest;
import uk.co.coralsoftware.invoicetrack.services.InvoiceService;
import uk.co.coralsoftware.invoicetrack.services.TenantService;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;
import uk.co.coralsoftware.invoicetrack.classes.Invoice;
import uk.co.coralsoftware.invoicetrack.services.CompanyInformationService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class InvoiceController {

    private InvoiceService invoiceService;
    private CompanyInformationService companyInformationService;

    public InvoiceController(InvoiceService invoiceService,
                             CompanyInformationService companyInformationService) {
        this.invoiceService = invoiceService;
        this.companyInformationService = companyInformationService;
    }

    @PostMapping("/invoices")
    public void  save(@RequestBody InvoiceRequest invoiceRequest){
       Invoice invoice = new Invoice();
       CompanyInformation companyInformation = companyInformationService.findById(invoiceRequest.getClientId());
       invoice.setDate(invoiceRequest.getDate());
       invoice.setClient(companyInformation);
      
       for(LineItemRequest lineItemRequest: invoiceRequest.getLineItems()){
           LineItem lineItem = new LineItem();
           lineItem.setInvoice(invoice);
           lineItem.setPrice(lineItemRequest.getPrice());
           lineItem.setDescription(lineItemRequest.getDescription());
           lineItem.setQuantity(lineItemRequest.getQuantity());
           lineItem.setVat(lineItemRequest.getVat());
           invoice.getLineItems().add(lineItem);
       }

        invoiceService.save(invoice);        
      
    }

}
