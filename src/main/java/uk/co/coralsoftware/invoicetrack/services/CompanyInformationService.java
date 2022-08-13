package uk.co.coralsoftware.invoicetrack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;
import uk.co.coralsoftware.invoicetrack.repositories.CompanyInformationRepository;

import java.util.List;

@Component
public class CompanyInformationService {

    @Autowired
    private CompanyInformationRepository companyInformationRepository;


    public void save(CompanyInformation companyInformation){
        companyInformationRepository.save(companyInformation);
    }



    public CompanyInformation findById(int id){
        return companyInformationRepository.findById(id).get();
    }
}
