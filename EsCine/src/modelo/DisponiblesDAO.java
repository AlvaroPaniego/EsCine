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

/**
 *
 * @author alvaro.paniego
 */
public class DisponiblesDAO {
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
    public int guardaDisponible(Disponible d) throws HibernateException {
        int id;
        try {
            iniciaOperacion();
            id = (int) sesion.save(d);
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
    public void actualizaPeliculas(Disponible d) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.update(d);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    //DELETE FROM 
    public void eliminaPeliculas(Disponible d) throws HibernateException {
        try {
            iniciaOperacion();
            sesion.delete(d);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }
    
    //CONSULTA DE UN OBJETO ESPECIFICO ((SELECET * FROM <TABLA> WHERE <CAMPO>) = <VALOR>)
    public Disponible obtenPeliculas(int idDisponible) throws HibernateException {
        Disponible d = null;
        try {
            iniciaOperacion();
            d = (Disponible) sesion.get(Disponible.class, idDisponible);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return d;
    }
    
    //CONSULTA QUE DEVUELVE VARIOS OBJETOS (SELECET * FROM <TABLA>)
    //Existen 3 tipos de listar posiblies:
    //  SQL Nativo
    //  HQL (Hibernarte Query Language)
    //  Usar Criteria
    public List<Disponible> obtenListaPeliculas() throws HibernateException {
        List<Disponible> listaPersonas = null;
        try {
            iniciaOperacion();
            listaPersonas = sesion.createQuery("from Disponible").list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaPersonas;
    }  
    
    public List<Disponible> obtenListaPeliculasPorSalaSesion(int sid, int tid) throws HibernateException {
        List<Disponible> listaPersonas = null;
        try {
            iniciaOperacion();
            listaPersonas = sesion.createQuery("FROM Disponible d WHERE d.salas.sid = " + sid + " AND d.pases = " + tid).list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return listaPersonas;
    }
    
    public int obtenPosicion(){
        Object pos;
        try {
            iniciaOperacion();
            pos = (Object) sesion.createQuery("SELECT MAX(d.pos) FROM Disponible d ").uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return Integer.parseInt(pos.toString());
    }
    
    public int combrobarButaca(int pid, int sid, String butaca){
        Object ocupada;
        try {
            iniciaOperacion();
            ocupada = (Object) sesion.createQuery("SELECT d.estado FROM Disponible d WHERE d.peliculas.pid = " + pid + " AND d.salas.sid = " + sid + " AND d.butacas = '" +  butaca + "'").uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        System.out.println(ocupada);
        return Integer.parseInt(ocupada.toString());
    }
}
