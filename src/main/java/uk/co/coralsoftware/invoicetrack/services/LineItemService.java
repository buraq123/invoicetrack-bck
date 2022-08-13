package uk.co.coralsoftware.invoicetrack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.coralsoftware.invoicetrack.classes.LineItem;
import uk.co.coralsoftware.invoicetrack.repositories.LineItemRepository;

@Service
public class LineItemService {

    @Autowired
    private LineItemRepository lineItemRepository;

    public void save(LineItem lineItem){
        lineItemRepository.save(lineItem);
    }

}
