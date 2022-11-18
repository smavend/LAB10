package com.example.lab10.dto;

public class ExpectedLossMax {
    private String nroContrato;
    private float expectedLoss;

    public String getNroContrato() {
        return nroContrato;
    }

    public void setNroContrato(String nroContrato) {
        this.nroContrato = nroContrato;
    }

    public float getExpectedLoss() {
        return expectedLoss;
    }

    public void setExpectedLoss(float expectedLoss) {
        this.expectedLoss = expectedLoss;
    }
}
