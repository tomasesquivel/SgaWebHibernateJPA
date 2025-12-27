package mx.com.gm.test;

import mx.com.gm.dao.DomicilioDAO;
import mx.com.gm.domain.Domicilio;

public class daoPrueba {
    public static void main(String[] args) {
        DomicilioDAO domicilioDao = new DomicilioDAO();
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("jadad");
        domicilio.setNoCalle("123");
        domicilio.setPais("Bolivia");
        domicilioDao.crear(domicilio);
        
    }
}
