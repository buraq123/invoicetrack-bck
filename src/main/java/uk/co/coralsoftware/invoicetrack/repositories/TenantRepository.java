package uk.co.coralsoftware.invoicetrack.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;

public interface TenantRepository extends CrudRepository<Tenant,Integer> {

}
