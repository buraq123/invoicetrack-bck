package uk.co.coralsoftware.invoicetrack.controllers;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;
import uk.co.coralsoftware.invoicetrack.classes.Invoice;
import uk.co.coralsoftware.invoicetrack.classes.LineItem;
import uk.co.coralsoftware.invoicetrack.dto.InvoiceRequest;
import uk.co.coralsoftware.invoicetrack.dto.LineItemRequest;
import uk.co.coralsoftware.invoicetrack.services.CompanyInformationService;
import uk.co.coralsoftware.invoicetrack.services.InvoiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceControllerTest
{

    @Mock
    InvoiceService invoiceService;

    @Mock
    CompanyInformationService companyInformationService;

    @InjectMocks
    InvoiceController invoiceController;

    @Captor
    ArgumentCaptor<Invoice> invoiceArgumentCaptor;


    @Test
    void shouldConvertAndSaveInvoice(){
        //given
        InvoiceRequest invoiceRequest = new InvoiceRequest();
        invoiceRequest.setDate(LocalDate.now());
        invoiceRequest.setClientId(1);

        List<LineItemRequest>  lineItemRequests = new ArrayList<>();
        lineItemRequests.add(new LineItemRequest(1,2,3,"sfsdf"));

        invoiceRequest.setLineItems(lineItemRequests);

        CompanyInformation companyInformation = new CompanyInformation();
       // companyInformation.setId(invoiceRequest.getClientId());
        when(companyInformationService.findById(invoiceRequest.getClientId())).thenReturn(companyInformation);
        //when
        invoiceController.save(invoiceRequest);
        //then
        verify(invoiceService).save(invoiceArgumentCaptor.capture());
        Invoice invoice = invoiceArgumentCaptor.getValue();
        assertEquals(invoice.getClient(),companyInformation);
        assertEquals(invoiceRequest.getDate(), invoice.getDate());
        assertEquals(invoiceRequest.getLineItems().size(),invoice.getLineItems().size());
        for(int i=0; i<invoice.getLineItems().size(); i++){
            assertEquals(invoice.getLineItems().get(i).getDescription(),invoiceRequest.getLineItems().get(i).getDescription());
            assertEquals(invoice.getLineItems().get(i).getPrice(),invoiceRequest.getLineItems().get(i).getPrice());
            assertEquals(invoice.getLineItems().get(i).getVat(),invoiceRequest.getLineItems().get(i).getVat());
            assertEquals(invoice.getLineItems().get(i).getQuantity(),invoiceRequest.getLineItems().get(i).getQuantity());
        }

    }
}