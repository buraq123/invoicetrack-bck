package uk.co.coralsoftware.invoicetrack.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InvoiceRequest {

    private LocalDate date;

    private int clientId;

    private List<LineItemRequest> lineItems = new ArrayList<>();



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public List<LineItemRequest> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItemRequest> lineItems) {
        this.lineItems = lineItems;
    }
}
