package uk.co.coralsoftware.invoicetrack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.coralsoftware.invoicetrack.classes.Invoice;
import uk.co.coralsoftware.invoicetrack.repositories.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }


}
