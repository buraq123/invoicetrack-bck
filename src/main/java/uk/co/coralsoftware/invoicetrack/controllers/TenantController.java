package uk.co.coralsoftware.invoicetrack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.coralsoftware.invoicetrack.classes.CompanyInformation;
import uk.co.coralsoftware.invoicetrack.services.TenantService;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.exception.NotFoundException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class TenantController {

    @Autowired
    TenantService companyInfoService;


    @PostMapping("/companyinfo")
    public void save(@RequestBody Tenant companyInfo){
        companyInfoService.save(companyInfo);
    }

    @PostMapping("/companyinfo/{id}")
    public void update(@PathVariable int id, @RequestBody Tenant companyInfo) throws NotFoundException {
        companyInfo.setId(id);
        companyInfoService.update(companyInfo);
    }
    
    @GetMapping("tenant/{id}/getclients")
    public Set<CompanyInformation> getClients(@PathVariable int id){
        Tenant tenant = companyInfoService.findById(id);
        return tenant.getClients();
   }
}
