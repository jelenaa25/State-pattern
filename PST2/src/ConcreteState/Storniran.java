

package ConcreteState;

import AbstractProductC.Kontroler;
import State.Stanje;

public class Storniran extends Stanje{ 
    public Storniran(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {  kon.setPoruka("�� ���� �� �� ������ ���������� ��������!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     
    }
    @Override
    public void stornirajDomenskiObjekat()
    {  kon.setPoruka("�� ���� �� �� �������� ���������� ��������!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
    }
    
    @Override
    public void promeniDomenskiObjekat()
     { kon.setPoruka("�� ���� �� �� ������� ���������� ��������!");
       kon.prikaziPoruku();
       kon.nadjiDomenskiObjekat1();
     }
}
