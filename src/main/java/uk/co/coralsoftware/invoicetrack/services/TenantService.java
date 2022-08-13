package uk.co.coralsoftware.invoicetrack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.exception.NotFoundException;
import uk.co.coralsoftware.invoicetrack.repositories.TenantRepository;

import java.util.Optional;

@Component
public class TenantService {

    @Autowired
    private TenantRepository companyInfoRepository;

    public TenantService(TenantRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    public int save(Tenant companyInfo) {
        Tenant dbObject = companyInfoRepository.save(companyInfo);
        return dbObject.getId();
    }

    public void update(Tenant companyInfo) throws NotFoundException {
        Optional<Tenant> selectedCompanyOptional = companyInfoRepository.findById(companyInfo.getId());
        if(selectedCompanyOptional.isEmpty()){
            throw new NotFoundException("dss");
        }
        Tenant selectedCompany = selectedCompanyOptional.get();
        selectedCompany.setName(companyInfo.getName());
        companyInfoRepository.save(selectedCompany);
    }

    public Tenant findById(int id){
       return companyInfoRepository.findById(id).get();

    }

}
