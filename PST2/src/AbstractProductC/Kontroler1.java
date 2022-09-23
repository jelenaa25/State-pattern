

package AbstractProductC;


import ConcreteState.Obradjen;
import ConcreteState.Storniran;
import ConcreteState.Neobradjen;
import ConcreteState.NullStanje;
import AbstractProductA.*;
import AbstractProductB.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.DKPorudzbina;  // Promenljivo
import State.*;



public final class Kontroler1 extends Kontroler{
   
    
   
    
    public Kontroler1(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi();}
    
    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obradi = ef.getPanel().getObradi();
     javax.swing.JButton Storniraj = ef.getPanel().getStorniraj();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj(this));
     Promeni.addActionListener( new OsluskivacPromeni(this));
     Obradi.addActionListener( new OsluskivacObradi(this));
     Storniraj.addActionListener( new OsluskivacStorniraj(this));
     Nadji.addActionListener( new OsluskivacNadji(this));
     
     javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraPorudzbine1(); // Promenljivo!!!
     SifraPrijave.addFocusListener( new OsluskivacNadji1(this));
    }
    
// Promenljivo!!!  
void napuniDomenskiObjekatIzGrafickogObjekta()   {
       ip= new DKPorudzbina();
       ip.setSifraPorudzbine(getInteger(ef.getPanel().getSifraPorudzbine()));
       ip.setPalacinka(ef.getPanel().getPalacinka());
       ip.setPreliv(ef.getPanel().getPreliv());
       ip.setVoce(ef.getPanel().getVoce());
       ip.setStanje(ef.getPanel().getStanje()); 
    
    }

// Promenljivo!!!
public void napuniGrafickiObjekatIzDomenskogObjekta(DKPorudzbina ip1){
       DKPorudzbina ip = (DKPorudzbina)ip1;
       ef.getPanel().setSifraPorudzbine(Integer.toString(ip.getSifraPorudzbine()));
       ef.getPanel().setPalacinka(ip.getPalacinka());
       ef.getPanel().setPreliv(ip.getPreliv());
       ef.getPanel().setVoce(ip.getVoce());
       ef.getPanel().setStanje(ip.getStanje());
      
    }

// Promenljivo!!!
void isprazniGrafickiObjekat(){

 ef.getPanel().setSifraPorudzbine("");
 ef.getPanel().setPalacinka("nista");
 ef.getPanel().setPreliv("nista");
 ef.getPanel().setVoce("nista");
 ef.getPanel().setStanje("neobradjen");
}

public void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}

 public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}


 
boolean zapamtiDomenskiObjekat(){ 
    
    bbp.makeConnection();
    boolean signal = bbp.insertRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="Систем је запамтио нову поруџбину."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          poruka ="Систем не може да запамти нову поруџбину."; // Promenljivo!!!  
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
       
    }
    
boolean kreirajDomenskiObjekat(){
    boolean signal;
    ip= new DKPorudzbina(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(ip,counter)) return false;
    if (!bbp.increaseCounter(ip,counter)) return false;
          
    ip.setSifraPorudzbine(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(ip);
          poruka = "Систем је креирао нову поруџбину."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="Систем не може да креира нову поруџбину."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
}


Stanje odrediStanjeIspitnePrijave()
{
    bbp.makeConnection();
    Stanje st = null;
    DKPorudzbina ip1 = (DKPorudzbina)bbp.findRecord(ip);
    bbp.closeConnection();
    if (ip1 != null) 
        { if (ip1.getStanje().equals("obradjen")) {st = new Obradjen(this);} 
          if (ip1.getStanje().equals("neobradjen")) {st = new Neobradjen(this);}
          if (ip1.getStanje().equals("storniran")) {st = new Storniran(this);} 
        }
        else
        {  st = new NullStanje(this);
        }
    return st;
}

void obradiDomenskiObjekat(){
    Stanje st = odrediStanjeIspitnePrijave();
    st.obradiDomenskiObjekat();
}

void stornirajDomenskiObjekat(){
    Stanje st = odrediStanjeIspitnePrijave();
    st.stornirajDomenskiObjekat();
}


void promeniDomenskiObjekat1(){
   Stanje st = odrediStanjeIspitnePrijave();
   st.promeniDomenskiObjekat();
}


 @Override
 public boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(ip);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Систем je променио поруџбину."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "Систем не може да промени поруџбину."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}


public boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    ip = (DKPorudzbina)bbp.findRecord(ip); // Promenljivo!!!
    if (ip != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(ip);
          poruka = "Систем je нашао поруџбину."; // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="Систем не може да нађе поруџбину."; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}



 @Override
 public boolean nadjiDomenskiObjekat1(){
    boolean signal;
    bbp.makeConnection();
    ip = (DKPorudzbina)bbp.findRecord(ip); 
    if (ip != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(ip);
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          signal = false;
        }
    bbp.closeConnection();
    return signal;   
}

 

}



class OsluskivacZapamti implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacZapamti(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacKreiraj(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObradi implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacObradi(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obradiDomenskiObjekat();
        
    }
}

class OsluskivacStorniraj implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacStorniraj(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.stornirajDomenskiObjekat();
        
    }
}


class OsluskivacPromeni implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacPromeni(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat1();
        
    }
}

class OsluskivacNadji implements ActionListener
{   Kontroler1 kon;
 
    OsluskivacNadji(Kontroler1 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji1 implements FocusListener
{   Kontroler1 kon;
 
    OsluskivacNadji1(Kontroler1 kon1) {kon = kon1;}
    

    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }
}

