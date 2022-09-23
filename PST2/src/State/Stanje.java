

package State;

import AbstractProductC.Kontroler;

public abstract class Stanje { 
    protected Kontroler kon;
    abstract public void obradiDomenskiObjekat();
    abstract public void stornirajDomenskiObjekat();
    abstract public void promeniDomenskiObjekat();
    
}
