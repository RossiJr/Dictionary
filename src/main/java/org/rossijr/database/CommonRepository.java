package org.rossijr.database;

import java.util.List;

public interface CommonRepository {
    Object create(Object object);
    Object getById(Object id);
    List<Object> getAll();
    Object update(Object object);
    boolean delete(Object id);
}
