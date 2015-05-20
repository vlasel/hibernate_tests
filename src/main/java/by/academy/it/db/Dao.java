package by.academy.it.db;

import by.academy.it.db.exceptions.DaoException;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface Dao<T> {
    List<T> getAll() throws DaoException;

    void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;
}




