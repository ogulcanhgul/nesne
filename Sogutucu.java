package sogutucu;

import java.util.Scanner;

public class Sogutucu
{

    public static void main(String[] args) 
    {
       
        int sicaklik = 0;
        System.out.println("***************************************************************");
        System.out.println("\t\tSoğutucu Kontrol Modülüne Hoşgeldiniz");
        System.out.println("***************************************************************\n\n\n");
        
        System.out.print("Kullanıcı Adı : ");
        Scanner girdi = new Scanner(System.in);
        String k_adi = girdi.next();
        System.out.print("\nŞifre : ");
        String pass = girdi.next();
        
        
        if(Veritabani.getInstance().veritabani_okuma(k_adi, pass, MerkeziIslemBirimi.getInstance()))
        {
            while(true)
            {
                
                
                System.out.println("\n1-) Cihazı Aç\n\n2-) Sıcaklık Görüntüle\n\n3-) Soğutucu Aç\n\n4-) Soğutucu Kapat\n\n5-) Cihazı Kapat\n\n6-) Kullanıcı Çıkışı\n\n");
                Scanner girilen = new Scanner(System.in);
                int secim = girilen.nextInt();
                
                if(secim==1)
                {
                    if(MerkeziIslemBirimi.getInstance().yetkili_mi)
                    {
                        MerkeziIslemBirimi.getInstance().cihazi_ac(CihazDurumu.getInstance());
                    }
                    else
                    {
                        System.out.println("Bu işlem için yetkiniz bulunmamaktadır.");
                    }
                    
                }
                else if(secim==2)
                {
                    if(MerkeziIslemBirimi.getInstance().yetkili_mi)
                    {
                        if(CihazDurumu.getInstance().cihaz_acik_mi())
                        {
                            MerkeziIslemBirimi.getInstance().sicaklik_goster(SicaklikAlgilayici.getInstance(), CihazDurumu.getInstance());
                        }
                        else
                        {
                            System.out.println("Cihaz kapalı durumdayken işlem yapamazsınız.");
                        }
                    }
                    else
                    {
                        System.out.println("Bu işlem için yetkiniz bulunmamaktadır.");
                    }
                }
                else if(secim==3)
                {
                    if(MerkeziIslemBirimi.getInstance().yetkili_mi)
                    {
                        
                        if(CihazDurumu.getInstance().cihaz_acik_mi())
                        {
                            MerkeziIslemBirimi.getInstance().sogutucu_ac(Eyleyici.getInstance());
                        }
                        else
                        {
                            System.out.println("Cihaz kapalı durumdayken işlem yapamazsınız.");
                        }
                    }
                    else
                    {
                        System.out.println("Bu işlem için yetkiniz bulunmamaktadır.");
                    }
                }
                else if(secim==4)
                {
                    if(MerkeziIslemBirimi.getInstance().yetkili_mi)
                    {
                        
                        if(CihazDurumu.getInstance().cihaz_acik_mi())
                        {
                            MerkeziIslemBirimi.getInstance().sogutucu_kapat(Eyleyici.getInstance());
                        }
                        else
                        {
                            System.out.println("Cihaz kapalı durumdayken işlem yapamazsınız.");
                        }
                    }
                    else
                    {
                        System.out.println("Bu işlem için yetkiniz bulunmamaktadır.");
                    }
                }
                else if(secim==5)
                {
                    if(MerkeziIslemBirimi.getInstance().yetkili_mi)
                    {
                        if(CihazDurumu.getInstance().cihaz_acik_mi())
                        {
                            MerkeziIslemBirimi.getInstance().cihazi_kapat(CihazDurumu.getInstance());
                        }
                        else
                        {
                            System.out.println("Cihaz zaten kapalı");
                        }
                    }
                    else
                    {
                        System.out.println("Bu işlem için yetkiniz bulunmamaktadır.");
                    }
                }
                
                else if(secim==6)
                {
                    break;
                }
            
            
            
            
            
            
            }
        }
        else
        {
            System.out.println("Sistemde kullanıcı kaydınız bulunmamaktadır.");
        }
        
        
        
        
        
    }
}