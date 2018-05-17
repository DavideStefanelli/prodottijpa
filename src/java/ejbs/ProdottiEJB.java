package ejbs;

import beans.CategoriaBean;
import beans.ProdottoBean;
import entities.Categoria;
import entities.Prodotto; 
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class ProdottiEJB implements ProdottiEJBLocal {

    @PersistenceContext(unitName="ProdottiJpaPU")
    EntityManager em;
    
    @Override
    public boolean aggiungiProdotto(ProdottoBean p, int idCategoria) {
        
        Categoria cat = em.find(Categoria.class, idCategoria);
        
        if(cat != null){
            Prodotto prodotto = new Prodotto(p.getNome(), p.getDescrizione(), cat, p.getImmagine());
            em.persist(prodotto); 
            return em.contains(prodotto); 
        } else {
            return false;
        }
    }
    
    @Override
    public List<Prodotto> getProdotti() {
        
        return em.createNamedQuery("Prodotto.findAll", Prodotto.class).getResultList();
        
    }

    @Override
    public boolean aggiungiCategoria(CategoriaBean cBean) {
        
        Categoria categoria = new Categoria(cBean.getNome(), cBean.getDescrizione(), cBean.getImmagine());
        em.persist(categoria);
        
        return em.contains(categoria);
    }

    @Override
    public List<Categoria> getCategorie() { 
        return em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
        
    }



}
