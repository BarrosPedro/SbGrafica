package BarrosPedro.conversores;


import BarrosPedro.controladores.ClienteController;
import BarrosPedro.negocio.Cliente;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
 

 
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ClienteController service = (ClienteController) fc.getExternalContext().getSessionMap().get("clienteController");
                return service.recuperarCliente(Integer.parseInt(value));
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
            return String.valueOf(((Cliente) object).getCodigo());
        }
        else {
            return null;
        }
    }   
}