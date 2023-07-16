package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pass;
        Integer odr;
        Scanner masuk = new Scanner(System.in);
        ATM BRI = new ATM("555913",1000000.0);
        ATM BNI = new ATM("123456",500000.0);
        ATM Mandiri = new ATM("558461", 756413123.10);
        ATM Syariah = new ATM("223122", 80000000.0);
        Nasabah Andrew = new Nasabah("Andrew Ikhtisar afiq", "2000018073");
        Nasabah Aldi = new Nasabah("Aldi","20000180117");
        Nasabah Aulia = new Nasabah("Aulia", "2000018020");
        Nasabah Desi = new Nasabah("Desi", "2000018044");
        Desi.bukaRekening(Syariah);
        Aulia.bukaRekening(Mandiri);
        Andrew.bukaRekening(BRI);
        Aldi.bukaRekening(BNI);
        System.out.println("--------ATM--------");
        System.out.println("Masukan PIN : ");
        pass = masuk.next();
        int i =0;
        boolean in = BRI.login(pass);
        if ( in = false){
            int cek = 0;
            while (cek<2){
                System.out.println("Masukan PIN : ");
                pass = masuk.next();
                cek++;
                if (BRI.login(pass)){
                    continue;
                }
            }
        }
        do {
            System.out.println("1.Informasi saldo");
            System.out.println("2.Tarik Uang");
            System.out.println("3.Transfer Uang");
            System.out.println("4.Selesai");
            System.out.println("--Masukan Keinginan anda dalam menggunakan atm--");
            odr = masuk.nextInt();
            if (odr == 1){
                System.out.println("Saldo anda tersisa");
                Andrew.Show_rekening();
            }if (odr == 2){
                double money;
                System.out.println("Banyak uang yang ingin ditarik");
                money = masuk.nextDouble();
                if (money > BRI.getSaldo()){
                    System.out.println("Saldo anda tidak cukup");
                }
                else {
                    BRI.Tarik(money);
                    Andrew.Show_rekening();
                }
            }
            if(odr == 3){
                if(i==3){
                    System.out.println("Anda telah melampaui batas transfer");
                }
                else{
                    double money;
                    String norek;
                    System.out.println("Banyak uang yang ingin ditarik");
                    money = masuk.nextDouble();
                    System.out.println("Nomor rekening tujuan");
                    norek = masuk.next();
                    if (norek.equals(Aldi.getNorek())){
                        BRI.Transfer(money,BNI);
                        System.out.println("Transfer berhasil");
                    }
                    if (norek.equals(Aulia.getNorek())){
                        BRI.Transfer(money,Mandiri);
                        System.out.println("Transfer berhasil");
                    }
                    if (norek.equals(Desi.getNorek())){
                        BRI.Transfer(money,Syariah);
                        System.out.println("Transfer berhasil");
                    }
                    else {
                        System.out.println("Nomor rekening tidak ditemukan");
                    }
                    i++;
                }
            }
        }while (odr != 4);
    }
}
