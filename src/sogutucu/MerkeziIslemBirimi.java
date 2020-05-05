package sogutucu;

import java.util.Random;

/**
 *
 * @author Oğulcan Hami Gül
 */
public class MerkeziIslemBirimi {
    

    
    private MerkeziIslemBirimi(){}
    
    private static MerkeziIslemBirimi instance = null;
    
    public boolean yetkili_mi;
    
    public static MerkeziIslemBirimi getInstance()
    {
		if(instance==null)
                {
			synchronized (MerkeziIslemBirimi.class) 
                        {
				if (instance==null)
                                {
					instance=new MerkeziIslemBirimi();
				}
			}
		}
		return instance;
    }
    
    
        
    
    public void sicaklik_goster(SicaklikAlgilayici algilayici,CihazDurumu c_durumu)
    {
        Random r = new Random(); 
        c_durumu.cihaz_kontrol();
        System.out.println(algilayici.sicaklikOku(r)+" Derece");
    }
    
    
    public void sogutucu_ac(Eyleyici eyleyici)
    {
        eyleyici.sogutucu_a();
    }
    
    public void sogutucu_kapat(Eyleyici eyleyici)
    {
        eyleyici.sogutucu_k();
    }
    public void cihazi_kapat(CihazDurumu c_durumu)
    {
        c_durumu.cihaz_kapat();
    }
    public void cihazi_ac(CihazDurumu c_durumu)
    {
        c_durumu.cihaz_bekleme();
    }
   
    
    
  
    
}
