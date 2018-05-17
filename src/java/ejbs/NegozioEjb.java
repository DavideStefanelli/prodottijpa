package ejbs;

import beans.NegozioBean;
import entities.Negozio;
import entities.Proprietarionegozio;
import entities.Utente;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class NegozioEjb implements NegozioEjbLocal {

    @PersistenceContext(unitName="ProdottiJpaPU")
    EntityManager em;
    
    @Override
    public boolean creaNegozio(NegozioBean nBean, int idProprietario) {
        Negozio n = new Negozio(nBean.getNome(), nBean.getDescrizione());
        em.persist(n);
        if(em.contains(n)){
            Proprietarionegozio propreitario = new Proprietarionegozio();
            propreitario.setNegozio(n);
            Utente u = em.find(Utente.class, idProprietario);
            propreitario.setUtente(u);
            em.persist(propreitario);
            return em.contains(propreitario);
        }
        
        return false;
    }
    
    
    
}
