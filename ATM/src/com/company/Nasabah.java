package com.company;

public class Nasabah  extends  Bank{

    private String nama, norek;
    private Integer jumlahrekening = 0;
    private ATM[] rek= new ATM[10];

    //Andrew Ikhtisar Afiq
    public Nasabah(String a, String b){
        this.nama=a;
        this.norek=b;
    }
    public void bukaRekening(ATM r){
        this.rek[jumlahrekening] = r;
        jumlahrekening++;
    }

    public void Show_rekening() {
        int i;
        try {
            for (i=0;i<jumlahrekening;i++)
                System.out.println("Sisa Saldo: "+rek[i].getSaldo());
        }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Terlalu banyak nasabah");
       }
    }
    public String getNama() {
        return nama;
    }

    public String getNorek() {
        return norek;
    }

    public Integer getJumlahrekening() {
        return jumlahrekening;
    }
    @Override
    public ATM[] getRek() {
        return rek;
    }
    public boolean trans(String a){
        if (norek == a) return true;
        else  return  false;
    }
}
