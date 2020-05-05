package sogutucu;

/**
 *
 * @author Oğulcan Hami Gül
 */
public class Eyleyici {
   
    private static Eyleyici instance = null;
    private Eyleyici(){}
    
    private void Sogutucu_kapat()
    {
        CihazDurumu.getInstance().sogutucu_durumu_kapali();
    }
    
    private void Sogutucu_Ac()
    {
        CihazDurumu.getInstance().sogutucu_durumu_acik();
    }
    
    public static Eyleyici getInstance()
    {
		if(instance==null)
                {
			synchronized (Eyleyici.class) 
                        {
				if (instance==null)
                                {
					instance=new Eyleyici();
				}
			}
		}
		return instance;
    }
    
    public void sogutucu_k()
    {
        Sogutucu_kapat();
    }
    public void sogutucu_a()
    {
        Sogutucu_Ac();
    }
    
      
    
}
