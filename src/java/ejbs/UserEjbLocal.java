package ejbs;

import beans.UtenteBean;
import entities.Utente;
import javax.ejb.Local;

@Local
public interface UserEjbLocal {
    
    public Utente eseguiLogin(String email, String password);
    public boolean registraUtente(UtenteBean utente);
    
}
