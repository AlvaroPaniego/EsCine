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
import pojos.Disponible;
import pojos.Pases;

/**
 *
 * @author alvaro.paniego
 */
public class PasesDAO {
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
    public int guardaPases(Pases p) throws HibernateException {
        int id;
        try {
            iniciaOperacion();
            id = (int) sesion.save(p);
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
    public void actualizaPases(Pases p) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    //DELETE FROM 
    public void eliminaPases(Pases p) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(p);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    //CONSULTA DE UN OBJETO ESPECIFICO ((SELECET * FROM <TABLA> WHERE <CAMPO>) = <VALOR>)
    public Pases obtenPases(int idPases) throws HibernateException {
        Pases p = null;
        try {
            iniciaOperacion();
            p = (Pases) sesion.get(Pases.class, idPases);
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
    public List<Pases> obtenListaPases() throws HibernateException {
        List<Pases> listaPases = null;
        try {
            iniciaOperacion();
            listaPases = sesion.createQuery("from Disponible").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaPases;
    }  
}
