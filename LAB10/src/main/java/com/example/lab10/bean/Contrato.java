package com.example.lab10.bean;

public class Contrato {
    private String nroContrato;
    private Cliente cliente;
    private String divisa;
    private String estado;
    private int mesesEnEstado;

    public String getNroContrato() {
        return nroContrato;
    }

    public void setNroContrato(String nroContrato) {
        this.nroContrato = nroContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMesesEnEstado() {
        return mesesEnEstado;
    }

    public void setMesesEnEstado(int mesesEnEstado) {
        this.mesesEnEstado = mesesEnEstado;
    }
}
