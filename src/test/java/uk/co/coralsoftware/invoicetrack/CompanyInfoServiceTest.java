package uk.co.coralsoftware.invoicetrack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.coralsoftware.invoicetrack.classes.Tenant;
import uk.co.coralsoftware.invoicetrack.exception.NotFoundException;
import uk.co.coralsoftware.invoicetrack.repositories.TenantRepository;
import uk.co.coralsoftware.invoicetrack.services.TenantService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyInfoServiceTest {

    @Mock
    private TenantRepository companyInfoRepository;

    @InjectMocks
    private TenantService companyInfoService;

    @Test
    void shouldSave() {
        var companyInfo = new Tenant("Coral Software");
        var dbMock = new Tenant(null);
        dbMock.setId(1234);
        when(companyInfoRepository.save(companyInfo)).thenReturn(dbMock);
        int id = companyInfoService.save(companyInfo);
        verify(companyInfoRepository).save(new Tenant("Coral Software"));
        assertTrue(id == dbMock.getId());
    }

    @Test
    public void shouldUpdateWhenRecordFound() throws NotFoundException {
        var newCompanyInfo = new Tenant("Coral Software");
        newCompanyInfo.setId(1);
        var dbMock = new Tenant("");
        dbMock.setId(1);
        when(companyInfoRepository.findById(newCompanyInfo.getId())).thenReturn(Optional.of(dbMock));
        companyInfoService.update(newCompanyInfo);
        verify(companyInfoRepository).save(newCompanyInfo);
    }

    @Test
    public void shouldThrowExecptionWhenRecordNotFound() throws NotFoundException {
        var newCompanyInfo = new Tenant("Coral Software");
        newCompanyInfo.setId(1);

        when(companyInfoRepository.findById(newCompanyInfo.getId())).thenReturn(Optional.empty());
        assertThrows( NotFoundException.class,() -> companyInfoService.update(newCompanyInfo));
    }
    @Test
    public void shouldNotThrowExecptionWhenRecordIsFound() throws NotFoundException {
        var newCompanyInfo = new Tenant("Coral Software");
        newCompanyInfo.setId(1);

        when(companyInfoRepository.findById(newCompanyInfo.getId())).thenReturn(Optional.of(newCompanyInfo));
        assertDoesNotThrow(()->companyInfoService.update(newCompanyInfo));
    }

}

