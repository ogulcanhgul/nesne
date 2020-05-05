package sogutucu;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author Oğulcan Hami Gül
 */
public class Veritabani 
{
    
    private static Veritabani instance = null;
    private Veritabani(){}
    
    public static Veritabani getInstance()
    {
		if(instance==null)
                {
			synchronized (Veritabani.class) 
                        {
				if (instance==null)
                                {
					instance=new Veritabani();
				}
			}
		}
		return instance;
    }
    
    
    
    
    static final String url = "jdbc:postgresql://localhost:5432/sogutucu";
    static final String user = "postgres";
    static final String password = "340835";
   
  
    private boolean veritabani_oku(String k_adi,String sifre,MerkeziIslemBirimi m)
    {
        java.sql.Connection conn = null;
        Statement stmt = null;
        boolean onay = false;
        try
        {
            Class.forName("org.postgresql.Driver");

            
            conn = DriverManager.getConnection(url, user, password);
          

            stmt = conn.createStatement();
            String sql = "SELECT user_name, pass_word,yetki FROM yetki";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                
                String id  = rs.getString("user_name");
                String pass = rs.getString("pass_word");
                boolean adi = rs.getBoolean("yetki");
               
                
                if(id.equals(k_adi) && pass.equals(sifre)){
                    onay = true;
                    m.yetkili_mi = adi;
                    break; 
                }
                
            }
            
            
            rs.close();
            
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null)
                    conn.close();
            }
            catch(SQLException se)
            {
            }
            try
            {
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }

        return onay;
    }
    
    
    public boolean veritabani_okuma(String k_adi,String pass,MerkeziIslemBirimi m)
    {
       return veritabani_oku(k_adi,pass,m);
       
    }
    
    public static boolean yetki = false;
    
    
    
}
