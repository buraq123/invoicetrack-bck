package uk.co.coralsoftware.invoicetrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.coralsoftware.invoicetrack.dto.CompanyInformationRequest;
import uk.co.coralsoftware.invoicetrack.services.CompanyInformationService;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.services.TenantService;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;

@RestController
@CrossOrigin(origins ="*")
public class CompanyInformationController {

    @Autowired
    private CompanyInformationService companyInformationService;

    @Autowired
    private TenantService tenantService;

   
    @PostMapping("/tenant/{id}/clients")
    public void save(@PathVariable int id, @RequestBody CompanyInformationRequest companyInformationRequest) {
        CompanyInformation companyInformation = new CompanyInformation();
        companyInformation.setName(companyInformationRequest.getName());
        companyInformation.setNumber(companyInformationRequest.getNumber());
        Tenant tenant = tenantService.findById(id);
        companyInformation.setTenant(tenant);
        companyInformationService.save(companyInformation);
    }

    @GetMapping("/clients/{id}")
    public CompanyInformation getClient(@PathVariable int id) {
        return companyInformationService.findById(id);
    }

    @PostMapping("/clients/{id}")
    public void update(@PathVariable int id, @RequestBody CompanyInformation companyInformation) {
        CompanyInformation companyInformation1 = companyInformationService.findById(id);
        companyInformation1.setName(companyInformation.getName());
        companyInformation1.setNumber(companyInformation.getNumber());
        companyInformationService.save(companyInformation1);
    }


}
