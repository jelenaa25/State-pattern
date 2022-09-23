

package ConcreteState;

import AbstractProductC.Kontroler;
import DomainClasses.DKPorudzbina;
import State.Stanje;

public class Neobradjen extends Stanje{ 
    public Neobradjen(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {  DKPorudzbina dk = (DKPorudzbina) kon.getDKObject();
       dk.setStanje("obradjen");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
    }
    @Override
    public void stornirajDomenskiObjekat()
     { DKPorudzbina dk = (DKPorudzbina) kon.getDKObject();
       dk.setStanje("storniran");
       kon.promeniDomenskiObjekat();
       kon.napuniGrafickiObjekatIzDomenskogObjekta(dk);
     }
    
    public void promeniDomenskiObjekat()
    {  kon.promeniDomenskiObjekat();
    }
    
}
