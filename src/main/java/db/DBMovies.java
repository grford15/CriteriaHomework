package db;

import models.Movies;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMovies {

    private static Session session;
    private static Transaction transaction;

    public static void save(Movies movie) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Movies> getAll(){
        List<Movies> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Movies.class);
            results = criteria.list();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return results;
    }

    public static void update(Movies movie){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(movie);
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        }
    }

    public static void delete(Movies movie) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(movie);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Movies.class);
            List<Movies> results = criteria.list();
            transaction = session.beginTransaction();
            for(Movies movie : results){
                session.delete(movie);
            }
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        }
    }

    public static Movies find(int id){
        Movies result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Movies.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Movies)criteria.uniqueResult();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return result;
    }

    public static Movies findByTitle(String title){
        Movies result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Movies.class);
            criteria.add(Restrictions.eq("title", title));
            result = (Movies)criteria.uniqueResult();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return result;
    }
}
