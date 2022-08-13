package uk.co.coralsoftware.invoicetrack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.controllers.TenantController;
import uk.co.coralsoftware.invoicetrack.services.TenantService;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CompanyInfoControllerTest {

    @Mock
    private TenantService companyInfoService;

    @InjectMocks
    private TenantController companyInfoController;

    @Test
    void shouldSave() {
        var companyInfo = new Tenant("Coral Software");
        companyInfoController.save(companyInfo);
        verify(companyInfoService).save(companyInfo);
    }



}