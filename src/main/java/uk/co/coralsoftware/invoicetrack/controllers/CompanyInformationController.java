package uk.co.coralsoftware.invoicetrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.coralsoftware.invoicetrack.services.CompanyInformationService;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.services.TenantService;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;

@RestController
public class CompanyInformationController {

    @Autowired
    private CompanyInformationService companyInformationService;

    @Autowired
    private TenantService tenantService;

    @PostMapping("tenant/{id}/clients")
    public void save(@PathVariable int id, @RequestBody CompanyInformation companyInformation, @RequestBody String g){
        Tenant tenant = tenantService.findById(id);
        companyInformation.setTenant(tenant);
        companyInformationService.save(companyInformation);
        System.out.println(g);
    }





}
