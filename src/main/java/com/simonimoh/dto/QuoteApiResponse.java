package com.simonimoh.dto;

import java.util.List;

public class QuoteApiResponse {

//    private List<QuoteDto> quoteDtos;
    private QuoteDto[] quoteDtos;

    public QuoteDto[] getQuoteDtos() {
        return quoteDtos;
    }

    public void setQuoteDtos(QuoteDto[] quoteDtos) {
        this.quoteDtos = quoteDtos;
    }
}
