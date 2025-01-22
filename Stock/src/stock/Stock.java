/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stock;

import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
/**
 *
 * @author Eren
 */
public class Stock {

    private String urunAdi;
    private int gelenAdet;
    private int satilanAdet;
    private double gelisFiyati;
    private double satisFiyati;
    private static ArrayList<Stock> stokListesi = new ArrayList<>();
	    
	
	    public Stock(String urunAdi, int gelenAdet, int satilanAdet, double gelisFiyati, double satisFiyati) {
	        this.urunAdi = urunAdi;
	        this.gelenAdet = gelenAdet;
	        this.satilanAdet = satilanAdet;
	        this.gelisFiyati = gelisFiyati;
	        this.satisFiyati = satisFiyati;
	    }
	
	    public String getUrunAdi() {
	        return urunAdi;
	    }
	
	    public int getGelenAdet() {
	        return gelenAdet;
	    }
	
	    public void setGelenAdet(int gelenAdet) {
	        this.gelenAdet = gelenAdet;
	    }
	
	    public int getSatilanAdet() {
	        return satilanAdet;
	    }
	
	    public void setSatilanAdet(int satilanAdet) {
	        this.satilanAdet = satilanAdet;
	    }
	
	    public double getGelisFiyati() {
	        return gelisFiyati;
	    }
	
	    public void setGelisFiyati(double gelisFiyati) {
	        this.gelisFiyati = gelisFiyati;
	    }
	
	    public double getSatisFiyati() {
	        return satisFiyati;
	    }
	
	    public void setSatisFiyati(double satisFiyati) {
	        this.satisFiyati = satisFiyati;
	    }
	
	    public double calculateGelir() {
	        return satilanAdet * satisFiyati;
	    }
	
	    public double calculateKarOrani() {
	        if (satilanAdet == 0) {
	            return 0.0;
	        }
	        return ((satilanAdet * satisFiyati) - (satilanAdet * gelisFiyati)) / (satilanAdet * gelisFiyati) * 100;
	    }
	    
	    private static void UrunEkle() {
	    	Scanner scanner = new Scanner(System.in);  
	    	
	    	System.out.println("Urun Adi;");
	    	String urun = scanner.nextLine();
	    	
	    	System.out.println("Gelen Adet;");
	    	int Gelenadet = scanner.nextInt();
	    	
	    	System.out.println("Satilan Adet;");
	    	int SatilanAdet = scanner.nextInt();
	    	
	    	System.out.println("Gelis Fiyati;");
	    	double GelisFiyati= scanner.nextDouble();
	    	
	    	System.out.println("Satis Fiyati;");
	    	double SatisFiyati= scanner.nextDouble();
	    	
	    	Stock stokUrun = new Stock(urun, Gelenadet, SatilanAdet, GelisFiyati,SatisFiyati);
	    	 stokListesi.add(stokUrun);
	    	 
		}
	    
	    private static void UrunGoster() {
	    	
	    	
	    	
	    	for (Stock urun : stokListesi) {
	    		System.out.println("Urun Adi;");
	            System.out.println(urun.urunAdi);
	            
	            System.out.println("Gelen Adet;");
	            System.out.println(urun.gelenAdet);
	        	
	        	System.out.println("Satilan Adet;");
	        	System.out.println(urun.satilanAdet);
	        	
	        	System.out.println("Gelis Fiyati;");
	        	System.out.println(urun.gelisFiyati);
	        	
	        	System.out.println("Satis Fiyati;");
	        	System.out.println(urun.satisFiyati);
	        	
	        	 System.out.println("Toplam Gelir: " + urun.calculateGelir());
	             System.out.println("Kar Orani: " + urun.calculateKarOrani() + "%");
	             
	             System.out.println("----------------------");
	        }
	    	
		}
	private static void UrunCikar() {
	    	
		UrunGoster();
		Scanner scanner = new Scanner(System.in);  
		
		System.out.println("Cikarilacak Urun Adi;");
		String CikarilacakUrunAdi = scanner.next();
		
		   Iterator<Stock> iterator = stokListesi.iterator();
		   
		while (iterator.hasNext()) {
	        Stock urun = iterator.next();
	        if (urun.getUrunAdi().equals(CikarilacakUrunAdi)) {
	            System.out.println("Urun Cikarildi");
	            iterator.remove(); 
	            break; 
	        }
	    }
	    	
	    	
	    	
		}
	
	    public static void main(String[] args) {
	    	
	    	Scanner scanner = new Scanner(System.in);    	
	    	int secim;
	    	
	    	  do {
	              // Menüyü göster
	    		  System.out.println("----------");
	              System.out.println("VAR OLAN URUNLERI GORMEK ICIN: 1");
	              System.out.println("URUN EKLEMEK ICIN: 2");
	              System.out.println("URUN ÇIKARMAK ICIN: 3");             
	              System.out.println("CIKIS: 4 ");
	              System.out.println("----------");
	              System.out.print("SECIMINIZ:");
	
	              // Kullanıcının seçimini al
	              secim = scanner.nextInt();
	
	              // Kullanıcının seçimine göre işlemleri gerçekleştir
	              switch (secim) {
	                  case 1:
	                	  UrunGoster();
	                      break;
	                  case 2:
	                	  UrunEkle();
	                      break;
	                  case 3:
	                	  UrunCikar();
	                      break;
	                  case 4:
	                      System.out.println("Cikiliyor...");
	                      break;
	                  default:
	                      System.out.println("Gecersiz secenek.");
	                      break;
	              }
	
	          } 
	    	  while (secim != 4);
	          
	        	  scanner.close();
	          		
	       
	    }

    
}
