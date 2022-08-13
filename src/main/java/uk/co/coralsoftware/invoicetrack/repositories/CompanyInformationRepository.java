package uk.co.coralsoftware.invoicetrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;

import java.util.List;

public interface CompanyInformationRepository extends JpaRepository<CompanyInformation,Integer> {

}
