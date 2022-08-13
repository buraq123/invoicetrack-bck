package uk.co.coralsoftware.invoicetrack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.coralsoftware.invoicetrack.classes.LineItem;

public interface LineItemRepository extends JpaRepository<LineItem,Integer> {
}
