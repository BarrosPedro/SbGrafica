package BarrosPedro.conversores;


import BarrosPedro.controladores.ProdutoController;
import BarrosPedro.negocio.Produto;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
 

 
@FacesConverter("produtoConverter")
public class ProdutoConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ProdutoController service = (ProdutoController) fc.getExternalContext().getSessionMap().get("produtoController");
                return service.recuperarProduto(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Produto) object).getCodigo());
        }
        else {
            return null;
        }
    }   
}