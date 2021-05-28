/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appcorreio;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Lucas Zaia
 */
public class AppCorreio {
    
    public static void main(String[] args) throws Exception {
        
        String Wurl = "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl";
        String serviceUrl = "http://cliente.bean.master.sigep.bsb.correios.com.br/";
        String servicesName = "AtendeClienteService";
        
        URL url = new URL(Wurl);  
        QName qname = new QName(serviceUrl,servicesName);
        
        Service servico = Service.create(url,qname);
        
        AtendeCliente servicoCliente = servico.getPort(AtendeCliente.class);
        
        
        System.out.println("---Buscar cidade por CEP -----");
        
        String cep = JOptionPane.showInputDialog("Informe o cep:");
        
        String cidade = "" + servicoCliente.consultaCEP(cep).getCidade();
        String uf = "" + servicoCliente.consultaCEP(cep).getUf();
        
        System.out.println("Cidade Encontrada: " + cidade + "-" + uf);
    
    }


}
