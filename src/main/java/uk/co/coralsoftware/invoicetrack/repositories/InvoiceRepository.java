package uk.co.coralsoftware.invoicetrack.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.coralsoftware.invoicetrack.classes.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice,Integer> {


}
