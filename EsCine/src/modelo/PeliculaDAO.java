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
import pojos.Peliculas;

/**
 *
 * @author alvaro.paniego
 */
public class PeliculaDAO {
    

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
    public int guardaPeliculas(Peliculas p) throws HibernateException {
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
    public void actualizaPeliculas(Peliculas p) throws HibernateException {
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
    public void eliminaPeliculas(Peliculas p) throws HibernateException {
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
    public Peliculas obtenPeliculas(int idPersona) throws HibernateException {
        Peliculas p = null;
        try {
            iniciaOperacion();
            p = (Peliculas) sesion.get(Peliculas.class, idPersona);
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
    public List<Peliculas> obtenListaPeliculas() throws HibernateException {
        List<Peliculas> listaPersonas = null;
        try {
            iniciaOperacion();
            listaPersonas = sesion.createQuery("from Peliculas").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaPersonas;
    }  

    public int obtenIdPorTitulo(String tituloPelicula) {
        Object id;
        try {
            iniciaOperacion();
            id = (Object) sesion.createQuery("SELECT p.pid FROM Peliculas p WHERE p.titulo= '" +  tituloPelicula + "'").uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return Integer.parseInt(id.toString());
    }
}
