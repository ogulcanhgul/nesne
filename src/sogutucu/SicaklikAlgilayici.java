package sogutucu;

import java.util.Random;

/**
 *
 * @author Oğulcan Hami Gül
 */
public class SicaklikAlgilayici {
    
    private SicaklikAlgilayici(){}
    private static SicaklikAlgilayici instance = null;
    
    
    public static SicaklikAlgilayici getInstance()
    {
		if(instance==null)
                {
			synchronized (SicaklikAlgilayici.class) 
                        {
				if (instance==null)
                                {
					instance=new SicaklikAlgilayici();
				}
			}
		}
		return instance;
    }
    
   
    private int sıcaklık(Random rastgele)
    { 
       
        
        return rastgele.nextInt(101);
          
    }
    
    public int sicaklikOku(Random rastgele)
    {
            
        return sıcaklık(rastgele);
        
    }
    
    
    
    
}
