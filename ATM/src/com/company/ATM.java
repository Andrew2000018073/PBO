package com.company;

public class ATM implements Proses {
    private String PIN;
    private  Double saldo;


    public ATM(String A, Double B){
        this.PIN = A;
        this.saldo= B;
    }

    public Double kurang(Integer x){
        return saldo = saldo + x;
    }

    public void setSaldo(Double tarik) {
        this.saldo = saldo - tarik;
    }

    public String getnoPIN() {
        return PIN;
    }
    //2000018073
    public Double getSaldo() {
        return  saldo;
    }

    public double Tarik(double tarik){
        return saldo = saldo-tarik;
    }

    public Boolean login(String coba){
        if (PIN == coba){
            return  true;
        }
        else {
            return false;
        }
    }

    public double Transfer(double transfer, ATM tujuan){
        tujuan.saldo = transfer + tujuan.saldo;
        return  saldo = saldo-transfer;
    }
}
