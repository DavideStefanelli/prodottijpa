package ejbs;

import beans.CategoriaBean;
import beans.ProdottoBean;
import entities.Categoria; 
import entities.Prodotto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProdottiEJBLocal {
    
    public boolean aggiungiCategoria(CategoriaBean c);
    public List<Categoria> getCategorie();
    
    public boolean aggiungiProdotto(ProdottoBean p, int idCategoria);
    public List<Prodotto> getProdotti();
}
