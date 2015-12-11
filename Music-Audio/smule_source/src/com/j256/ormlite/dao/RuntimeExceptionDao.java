// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.dao:
//            DaoManager, Dao, ForeignCollection, ObjectCache, 
//            CloseableWrappedIterable, CloseableIterator, RawRowMapper, GenericRawResults

public class RuntimeExceptionDao
{

    private Dao dao;

    public RuntimeExceptionDao(Dao dao1)
    {
        dao = dao1;
    }

    public static RuntimeExceptionDao createDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        return new RuntimeExceptionDao(DaoManager.createDao(connectionsource, databasetableconfig));
    }

    public static RuntimeExceptionDao createDao(ConnectionSource connectionsource, Class class1)
    {
        return new RuntimeExceptionDao(DaoManager.createDao(connectionsource, class1));
    }

    public Object callBatchTasks(Callable callable)
    {
        try
        {
            callable = ((Callable) (dao.callBatchTasks(callable)));
        }
        // Misplaced declaration of an exception variable
        catch (Callable callable)
        {
            throw new RuntimeException(callable);
        }
        return callable;
    }

    public void clearObjectCache()
    {
        dao.clearObjectCache();
    }

    public void closeLastIterator()
    {
        try
        {
            dao.closeLastIterator();
            return;
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
    }

    public long countOf()
    {
        long l;
        try
        {
            l = dao.countOf();
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return l;
    }

    public long countOf(PreparedQuery preparedquery)
    {
        long l;
        try
        {
            l = dao.countOf(preparedquery);
        }
        // Misplaced declaration of an exception variable
        catch (PreparedQuery preparedquery)
        {
            throw new RuntimeException(preparedquery);
        }
        return l;
    }

    public int create(Object obj)
    {
        int i;
        try
        {
            i = dao.create(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return i;
    }

    public Object createIfNotExists(Object obj)
    {
        try
        {
            obj = dao.createIfNotExists(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return obj;
    }

    public Dao.CreateOrUpdateStatus createOrUpdate(Object obj)
    {
        try
        {
            obj = dao.createOrUpdate(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((Dao.CreateOrUpdateStatus) (obj));
    }

    public int delete(PreparedDelete prepareddelete)
    {
        int i;
        try
        {
            i = dao.delete(prepareddelete);
        }
        // Misplaced declaration of an exception variable
        catch (PreparedDelete prepareddelete)
        {
            throw new RuntimeException(prepareddelete);
        }
        return i;
    }

    public int delete(Object obj)
    {
        int i;
        try
        {
            i = dao.delete(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return i;
    }

    public int delete(Collection collection)
    {
        int i;
        try
        {
            i = dao.delete(collection);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            throw new RuntimeException(collection);
        }
        return i;
    }

    public DeleteBuilder deleteBuilder()
    {
        return dao.deleteBuilder();
    }

    public int deleteById(Object obj)
    {
        int i;
        try
        {
            i = dao.deleteById(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return i;
    }

    public int deleteIds(Collection collection)
    {
        int i;
        try
        {
            i = dao.deleteIds(collection);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            throw new RuntimeException(collection);
        }
        return i;
    }

    public transient int executeRaw(String s, String as[])
    {
        int i;
        try
        {
            i = dao.executeRaw(s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return i;
    }

    public Object extractId(Object obj)
    {
        try
        {
            obj = dao.extractId(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return obj;
    }

    public FieldType findForeignFieldType(Class class1)
    {
        return dao.findForeignFieldType(class1);
    }

    public Class getDataClass()
    {
        return dao.getDataClass();
    }

    public ForeignCollection getEmptyForeignCollection(String s)
    {
        try
        {
            s = dao.getEmptyForeignCollection(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public ObjectCache getObjectCache()
    {
        return dao.getObjectCache();
    }

    public CloseableWrappedIterable getWrappedIterable()
    {
        return dao.getWrappedIterable();
    }

    public CloseableWrappedIterable getWrappedIterable(PreparedQuery preparedquery)
    {
        return dao.getWrappedIterable(preparedquery);
    }

    public boolean isTableExists()
    {
        boolean flag;
        try
        {
            flag = dao.isTableExists();
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return flag;
    }

    public boolean isUpdatable()
    {
        return dao.isUpdatable();
    }

    public CloseableIterator iterator()
    {
        return dao.iterator();
    }

    public CloseableIterator iterator(PreparedQuery preparedquery)
    {
        try
        {
            preparedquery = dao.iterator(preparedquery);
        }
        // Misplaced declaration of an exception variable
        catch (PreparedQuery preparedquery)
        {
            throw new RuntimeException(preparedquery);
        }
        return preparedquery;
    }

    public String objectToString(Object obj)
    {
        return dao.objectToString(obj);
    }

    public boolean objectsEqual(Object obj, Object obj1)
    {
        boolean flag;
        try
        {
            flag = dao.objectsEqual(obj, obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return flag;
    }

    public List query(PreparedQuery preparedquery)
    {
        try
        {
            preparedquery = dao.query(preparedquery);
        }
        // Misplaced declaration of an exception variable
        catch (PreparedQuery preparedquery)
        {
            throw new RuntimeException(preparedquery);
        }
        return preparedquery;
    }

    public QueryBuilder queryBuilder()
    {
        return dao.queryBuilder();
    }

    public List queryForAll()
    {
        List list;
        try
        {
            list = dao.queryForAll();
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return list;
    }

    public List queryForEq(String s, Object obj)
    {
        try
        {
            s = dao.queryForEq(s, obj);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public List queryForFieldValues(Map map)
    {
        try
        {
            map = dao.queryForFieldValues(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException(map);
        }
        return map;
    }

    public List queryForFieldValuesArgs(Map map)
    {
        try
        {
            map = dao.queryForFieldValuesArgs(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw new RuntimeException(map);
        }
        return map;
    }

    public Object queryForFirst(PreparedQuery preparedquery)
    {
        try
        {
            preparedquery = ((PreparedQuery) (dao.queryForFirst(preparedquery)));
        }
        // Misplaced declaration of an exception variable
        catch (PreparedQuery preparedquery)
        {
            throw new RuntimeException(preparedquery);
        }
        return preparedquery;
    }

    public Object queryForId(Object obj)
    {
        try
        {
            obj = dao.queryForId(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return obj;
    }

    public List queryForMatching(Object obj)
    {
        try
        {
            obj = dao.queryForMatching(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((List) (obj));
    }

    public List queryForMatchingArgs(Object obj)
    {
        try
        {
            obj = dao.queryForMatchingArgs(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((List) (obj));
    }

    public Object queryForSameId(Object obj)
    {
        try
        {
            obj = dao.queryForSameId(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return obj;
    }

    public transient GenericRawResults queryRaw(String s, RawRowMapper rawrowmapper, String as[])
    {
        try
        {
            s = dao.queryRaw(s, rawrowmapper, as);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public transient GenericRawResults queryRaw(String s, DataType adatatype[], String as[])
    {
        try
        {
            s = dao.queryRaw(s, adatatype, as);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public transient GenericRawResults queryRaw(String s, String as[])
    {
        try
        {
            s = dao.queryRaw(s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public int refresh(Object obj)
    {
        int i;
        try
        {
            i = dao.refresh(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return i;
    }

    public void setObjectCache(ObjectCache objectcache)
    {
        dao.setObjectCache(objectcache);
    }

    public void setObjectCache(boolean flag)
    {
        dao.setObjectCache(flag);
    }

    public int update(PreparedUpdate preparedupdate)
    {
        int i;
        try
        {
            i = dao.update(preparedupdate);
        }
        // Misplaced declaration of an exception variable
        catch (PreparedUpdate preparedupdate)
        {
            throw new RuntimeException(preparedupdate);
        }
        return i;
    }

    public int update(Object obj)
    {
        int i;
        try
        {
            i = dao.update(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return i;
    }

    public UpdateBuilder updateBuilder()
    {
        return dao.updateBuilder();
    }

    public int updateId(Object obj, Object obj1)
    {
        int i;
        try
        {
            i = dao.updateId(obj, obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return i;
    }

    public transient int updateRaw(String s, String as[])
    {
        int i;
        try
        {
            i = dao.updateRaw(s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return i;
    }
}
