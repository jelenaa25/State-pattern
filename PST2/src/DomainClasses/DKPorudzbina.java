

package DomainClasses;


import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Promenljivo!!!
public class DKPorudzbina implements Serializable, GeneralDObject {
  
    private int SifraPorudzbine;
    private String Palacinka;
    private String Preliv;
    private String Voce;
   // private java.util.Date Datum;
    private String Stanje;
    public DKPorudzbina() 
    {   SifraPorudzbine=0;			   
        Palacinka="000000";			   
        Preliv = "000";			   
        Voce = "000";	
        Stanje = "neobradjen";
        
    }

    public DKPorudzbina(int SifraPorudzbine, String Palacinka, String Preliv, String Voce, String Stanje)  	
    {   this.SifraPorudzbine = SifraPorudzbine;
        this.Palacinka=Palacinka;
        this.Preliv = Preliv;
        this.Voce = Voce;
        this.Stanje = Stanje;
    }   
    
    // Primarni kljuc		
    public DKPorudzbina(int SifraPorudzbine)  	
    {   this.SifraPorudzbine = SifraPorudzbine;
    }

    public int getSifraPorudzbine(){ return SifraPorudzbine;} 
    public String getPalacinka(){ return Palacinka;} 
    public String getPreliv(){ return Preliv;} 
    public String getVoce(){ return Voce;} 
   // public Date getDatum(){ return Datum;} 
    public String getStanje(){ return Stanje;}

    public void setSifraPorudzbine(int SifraPorudzbine){this.SifraPorudzbine = SifraPorudzbine;}
    public void setPalacinka(String palacinka){this.Palacinka = palacinka;}
    public void setPreliv(String preliv){this.Preliv = preliv;}
    public void setVoce(String voce){this.Voce = voce;}
    //public void setDatum(Date Datum){this.Datum = Datum;}

    public void setStanje(String Stanje) {
        this.Stanje = Stanje;
    }
    
    @Override
    public String getNameByColumn(int column)
        { String names[] = {"SifraPorudzbine","Palacinka","Preliv","Voce", "Stanje"}; 
          return names[column];
        }		
 
    @Override
    public GeneralDObject getNewRecord(ResultSet rs)  throws SQLException
    {return new DKPorudzbina(rs.getInt("SifraPorudzbine"),rs.getString("Palacinka"),rs.getString("Preliv"),rs.getString("Voce"), rs.getString("Stanje"));} 
    @Override
    public String getAtrValue() {return SifraPorudzbine + ", " + (Palacinka == null ? null : "'" + Palacinka + "'") + ", " + (Preliv == null ? null : "'" + Preliv + "'") + ", " + (Voce == null ? null : "'" + Voce + "'") + ""+", "+"'"+ Stanje + "'";}
    @Override
    public String setAtrValue(){return "SifraPorudzbine=" + SifraPorudzbine + ", " + "Palacinka=" + (Palacinka == null ? null : "'" + Palacinka + "'") + ", " + "Preliv=" + (Preliv == null ? null : "'" + Preliv + "'") + ", " + "Voce=" + (Voce == null ? null : "'" + Voce + "'") + ""+", " + "Stanje = '" + Stanje + "'";}
    @Override
    public String getClassName(){return "DKPorudzbina";}
    @Override
    public String getWhereCondition(){return "SifraPorudzbine = " + SifraPorudzbine;}
}



    
    
    
