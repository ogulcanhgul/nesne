package sogutucu;

/**
 *
 * @author Oğulcan Hami Gül
 */
public class CihazDurumu {
    
    
    private CihazDurumu(){}
     
    
    private String cihaz_durumu="Cihaz açık ve beklemede";;
    private String sogutucu_durumu;
    
    
    private static CihazDurumu instance = null;
    
    public static CihazDurumu getInstance()
    {
		if(instance==null)
                {
			synchronized (CihazDurumu.class) 
                        {
				if (instance==null)
                                {
					instance=new CihazDurumu();
				}
			}
		}
		return instance;
    }
    
    
    public void cihaz_kapat()
    {
       cihaz_durumu = "Cihaz Kapatıldı";
       System.out.println(cihaz_durumu);
    }
    
    public void cihaz_bekleme()
    {
        cihaz_durumu = "Cihaz açık ve beklemede";
        System.out.println(cihaz_durumu);
    }
    
    public void cihaz_kontrol()
    {
        cihaz_durumu = "Cihaz kontrol durumunda";
        System.out.println(cihaz_durumu);
    }
    
    public void cihaz_algılama()
    {
        cihaz_durumu = "Cihaz algılama durumunda";
        System.out.println(cihaz_durumu);
    }
    
    
    public void sogutucu_durumu_kapali()
    {
       sogutucu_durumu = "Soğutucu Kapatıldı"; 
       System.out.println(sogutucu_durumu);
    }
    public void sogutucu_durumu_acik()
    {
       sogutucu_durumu = "Soğutucu Açıldı";
       System.out.println(sogutucu_durumu);
    }
    public boolean cihaz_acik_mi()
    {
        if(cihaz_durumu.equals("Cihaz Kapatıldı"))
        {
            return false;
        }
        else
        {
           return true;
        }
        
    }
   
    
      
}
