
package AbstractProductC;

import AbstractProductA.EkranskaForma;
import AbstractProductB.BrokerBazePodataka;

import DomainClasses.DKPorudzbina;
import DomainClasses.GeneralDObject;

public abstract class Kontroler {
    EkranskaForma ef;
    BrokerBazePodataka bbp;
    DKPorudzbina ip;   // Promenljivo!!!
    String poruka;
    public GeneralDObject getDKObject(){return ip;}
    public abstract boolean promeniDomenskiObjekat();
    public void setPoruka(String poruka1){poruka = poruka1;}
    public abstract void prikaziPoruku(); 
    abstract public void napuniGrafickiObjekatIzDomenskogObjekta(DKPorudzbina ip);
    abstract public boolean nadjiDomenskiObjekat1();
}
