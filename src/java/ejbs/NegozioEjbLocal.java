/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import beans.NegozioBean;
import javax.ejb.Local;

/**
 *
 * @author web4e
 */
@Local
public interface NegozioEjbLocal {
    
    public boolean creaNegozio(NegozioBean n, int idProprietario);
    
}
