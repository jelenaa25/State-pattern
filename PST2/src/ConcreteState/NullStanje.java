

package ConcreteState;

import AbstractProductC.Kontroler;
import State.Stanje;

public class NullStanje extends Stanje{ 
    public NullStanje(Kontroler kon1) {kon = kon1;}
    @Override
    public void obradiDomenskiObjekat()
    {
       kon.setPoruka("�� ���� �� �� ������ ��������� ��������!");
       kon.prikaziPoruku();
    }
    @Override
    public void stornirajDomenskiObjekat()
    {
       kon.setPoruka("�� ���� �� �� �������� ��������� ��������!");
       kon.prikaziPoruku();
    }
    
    @Override
    public void promeniDomenskiObjekat()
    {
       kon.setPoruka("�� ���� �� �� ������� ��������� ��������!");
       kon.prikaziPoruku();
    }
    
}
