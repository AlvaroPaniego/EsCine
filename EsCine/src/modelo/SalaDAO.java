/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Pases;
import pojos.Salas;

/**
 *
 * @author alvaro.paniego
 */
public class SalaDAO {
    private Session sesion;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error en la capa de acceso a datos", he);
    }

    //Insert
    public int guardaSalas(Salas s) throws HibernateException {
        int id;
        try {
            iniciaOperacion();
            id = (int) sesion.save(s);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }

    //UPDATE
    public void actualizaSalas(Salas s) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(s);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    //DELETE FROM 
    public void eliminaSalas(Salas s) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(s);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    //CONSULTA DE UN OBJETO ESPECIFICO ((SELECET * FROM <TABLA> WHERE <CAMPO>) = <VALOR>)
    public Salas obtenSalas(int idSalas) throws HibernateException {
        Salas p = null;
        try {
            iniciaOperacion();
            p = (Salas) sesion.get(Salas.class, idSalas);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return p;
    }
    
    //CONSULTA QUE DEVUELVE VARIOS OBJETOS (SELECET * FROM <TABLA>)
    //Existen 3 tipos de listar posiblies:
    //  SQL Nativo
    //  HQL (Hibernarte Query Language)
    //  Usar Criteria
    public List<Salas> obtenListaSalas() throws HibernateException {
        List<Salas> listaSalas = null;
        try {
            iniciaOperacion();
            listaSalas = sesion.createQuery("from Disponible").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaSalas;
    }  
}
