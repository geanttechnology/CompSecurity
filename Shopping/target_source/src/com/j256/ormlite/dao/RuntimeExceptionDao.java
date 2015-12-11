// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, DaoManager, Dao, CloseableIterator, 
//            ForeignCollection, ObjectCache, RawRowMapper, CloseableWrappedIterable, 
//            GenericRawResults, RawRowObjectMapper

public class RuntimeExceptionDao
    implements CloseableIterable
{

    private static final com.j256.ormlite.logger.Log.Level LOG_LEVEL;
    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/dao/RuntimeExceptionDao);
    private Dao dao;

    public RuntimeExceptionDao(Dao dao1)
    {
        dao = dao1;
    }

    public static RuntimeExceptionDao createDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        return new RuntimeExceptionDao(DaoManager.createDao(connectionsource, databasetableconfig));
    }

    public static RuntimeExceptionDao createDao(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        return new RuntimeExceptionDao(DaoManager.createDao(connectionsource, class1));
    }

    private void logMessage(Exception exception, String s)
    {
        logger.log(LOG_LEVEL, exception, s);
    }

    public void assignEmptyForeignCollection(Object obj, String s)
    {
        try
        {
            dao.assignEmptyForeignCollection(obj, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logMessage(((Exception) (obj)), (new StringBuilder()).append("assignEmptyForeignCollection threw exception on ").append(s).toString());
        }
        throw new RuntimeException(((Throwable) (obj)));
    }

    public Object callBatchTasks(Callable callable)
    {
        Object obj;
        try
        {
            obj = dao.callBatchTasks(callable);
        }
        catch (Exception exception)
        {
            logMessage(exception, (new StringBuilder()).append("callBatchTasks threw exception on: ").append(callable).toString());
            throw new RuntimeException(exception);
        }
        return obj;
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
            logMessage(sqlexception, "closeLastIterator threw exception");
            throw new RuntimeException(sqlexception);
        }
    }

    public CloseableIterator closeableIterator()
    {
        return dao.closeableIterator();
    }

    public void commit(DatabaseConnection databaseconnection)
    {
        try
        {
            dao.commit(databaseconnection);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("commit(").append(databaseconnection).append(") threw exception").toString());
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
            logMessage(sqlexception, "countOf threw exception");
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("countOf threw exception on ").append(preparedquery).toString());
            throw new RuntimeException(sqlexception);
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("create threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return i;
    }

    public Object createIfNotExists(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = dao.createIfNotExists(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("createIfNotExists threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return obj1;
    }

    public Dao.CreateOrUpdateStatus createOrUpdate(Object obj)
    {
        Dao.CreateOrUpdateStatus createorupdatestatus;
        try
        {
            createorupdatestatus = dao.createOrUpdate(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("createOrUpdate threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return createorupdatestatus;
    }

    public int delete(PreparedDelete prepareddelete)
    {
        int i;
        try
        {
            i = dao.delete(prepareddelete);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("delete threw exception on: ").append(prepareddelete).toString());
            throw new RuntimeException(sqlexception);
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("delete threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("delete threw exception on: ").append(collection).toString());
            throw new RuntimeException(sqlexception);
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("deleteById threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("deleteIds threw exception on: ").append(collection).toString());
            throw new RuntimeException(sqlexception);
        }
        return i;
    }

    public void endThreadConnection(DatabaseConnection databaseconnection)
    {
        try
        {
            dao.endThreadConnection(databaseconnection);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("endThreadConnection(").append(databaseconnection).append(") threw exception").toString());
            throw new RuntimeException(sqlexception);
        }
    }

    public transient int executeRaw(String s, String as[])
    {
        int i;
        try
        {
            i = dao.executeRaw(s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            logMessage(as, (new StringBuilder()).append("executeRaw threw exception on: ").append(s).toString());
            throw new RuntimeException(as);
        }
        return i;
    }

    public int executeRawNoArgs(String s)
    {
        int i;
        try
        {
            i = dao.executeRawNoArgs(s);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("executeRawNoArgs threw exception on: ").append(s).toString());
            throw new RuntimeException(sqlexception);
        }
        return i;
    }

    public Object extractId(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = dao.extractId(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("extractId threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return obj1;
    }

    public FieldType findForeignFieldType(Class class1)
    {
        return dao.findForeignFieldType(class1);
    }

    public ConnectionSource getConnectionSource()
    {
        return dao.getConnectionSource();
    }

    public Class getDataClass()
    {
        return dao.getDataClass();
    }

    public ForeignCollection getEmptyForeignCollection(String s)
    {
        ForeignCollection foreigncollection;
        try
        {
            foreigncollection = dao.getEmptyForeignCollection(s);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("getEmptyForeignCollection threw exception on ").append(s).toString());
            throw new RuntimeException(sqlexception);
        }
        return foreigncollection;
    }

    public ObjectCache getObjectCache()
    {
        return dao.getObjectCache();
    }

    public RawRowMapper getRawRowMapper()
    {
        return dao.getRawRowMapper();
    }

    public GenericRowMapper getSelectStarRowMapper()
    {
        GenericRowMapper genericrowmapper;
        try
        {
            genericrowmapper = dao.getSelectStarRowMapper();
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, "getSelectStarRowMapper threw exception");
            throw new RuntimeException(sqlexception);
        }
        return genericrowmapper;
    }

    public CloseableWrappedIterable getWrappedIterable()
    {
        return dao.getWrappedIterable();
    }

    public CloseableWrappedIterable getWrappedIterable(PreparedQuery preparedquery)
    {
        return dao.getWrappedIterable(preparedquery);
    }

    public boolean idExists(Object obj)
    {
        boolean flag;
        try
        {
            flag = dao.idExists(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("idExists threw exception on ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return flag;
    }

    public boolean isAutoCommit()
    {
        boolean flag;
        try
        {
            flag = dao.isAutoCommit();
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, "isAutoCommit() threw exception");
            throw new RuntimeException(sqlexception);
        }
        return flag;
    }

    public boolean isAutoCommit(DatabaseConnection databaseconnection)
    {
        boolean flag;
        try
        {
            flag = dao.isAutoCommit(databaseconnection);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("isAutoCommit(").append(databaseconnection).append(") threw exception").toString());
            throw new RuntimeException(sqlexception);
        }
        return flag;
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
            logMessage(sqlexception, "isTableExists threw exception");
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

    public CloseableIterator iterator(int i)
    {
        return dao.iterator(i);
    }

    public CloseableIterator iterator(PreparedQuery preparedquery)
    {
        CloseableIterator closeableiterator;
        try
        {
            closeableiterator = dao.iterator(preparedquery);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("iterator threw exception on: ").append(preparedquery).toString());
            throw new RuntimeException(sqlexception);
        }
        return closeableiterator;
    }

    public CloseableIterator iterator(PreparedQuery preparedquery, int i)
    {
        CloseableIterator closeableiterator;
        try
        {
            closeableiterator = dao.iterator(preparedquery, i);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("iterator threw exception on: ").append(preparedquery).toString());
            throw new RuntimeException(sqlexception);
        }
        return closeableiterator;
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public Object mapSelectStarRow(DatabaseResults databaseresults)
    {
        try
        {
            databaseresults = ((DatabaseResults) (dao.mapSelectStarRow(databaseresults)));
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseResults databaseresults)
        {
            logMessage(databaseresults, "mapSelectStarRow threw exception on results");
            throw new RuntimeException(databaseresults);
        }
        return databaseresults;
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("objectsEqual threw exception on: ").append(obj).append(" and ").append(obj1).toString());
            throw new RuntimeException(sqlexception);
        }
        return flag;
    }

    public List query(PreparedQuery preparedquery)
    {
        List list;
        try
        {
            list = dao.query(preparedquery);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("query threw exception on: ").append(preparedquery).toString());
            throw new RuntimeException(sqlexception);
        }
        return list;
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
            logMessage(sqlexception, "queryForAll threw exception");
            throw new RuntimeException(sqlexception);
        }
        return list;
    }

    public List queryForEq(String s, Object obj)
    {
        try
        {
            obj = dao.queryForEq(s, obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logMessage(((Exception) (obj)), (new StringBuilder()).append("queryForEq threw exception on: ").append(s).toString());
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((List) (obj));
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
            logMessage(map, "queryForFieldValues threw exception");
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
            logMessage(map, "queryForFieldValuesArgs threw exception");
            throw new RuntimeException(map);
        }
        return map;
    }

    public Object queryForFirst(PreparedQuery preparedquery)
    {
        Object obj;
        try
        {
            obj = dao.queryForFirst(preparedquery);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("queryForFirst threw exception on: ").append(preparedquery).toString());
            throw new RuntimeException(sqlexception);
        }
        return obj;
    }

    public Object queryForId(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = dao.queryForId(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("queryForId threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return obj1;
    }

    public List queryForMatching(Object obj)
    {
        List list;
        try
        {
            list = dao.queryForMatching(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("queryForMatching threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return list;
    }

    public List queryForMatchingArgs(Object obj)
    {
        List list;
        try
        {
            list = dao.queryForMatchingArgs(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("queryForMatchingArgs threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return list;
    }

    public Object queryForSameId(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = dao.queryForSameId(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("queryForSameId threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return obj1;
    }

    public transient GenericRawResults queryRaw(String s, RawRowMapper rawrowmapper, String as[])
    {
        try
        {
            rawrowmapper = dao.queryRaw(s, rawrowmapper, as);
        }
        // Misplaced declaration of an exception variable
        catch (RawRowMapper rawrowmapper)
        {
            logMessage(rawrowmapper, (new StringBuilder()).append("queryRaw threw exception on: ").append(s).toString());
            throw new RuntimeException(rawrowmapper);
        }
        return rawrowmapper;
    }

    public transient GenericRawResults queryRaw(String s, DataType adatatype[], RawRowObjectMapper rawrowobjectmapper, String as[])
    {
        try
        {
            adatatype = dao.queryRaw(s, adatatype, rawrowobjectmapper, as);
        }
        // Misplaced declaration of an exception variable
        catch (DataType adatatype[])
        {
            logMessage(adatatype, (new StringBuilder()).append("queryRaw threw exception on: ").append(s).toString());
            throw new RuntimeException(adatatype);
        }
        return adatatype;
    }

    public transient GenericRawResults queryRaw(String s, DataType adatatype[], String as[])
    {
        try
        {
            adatatype = dao.queryRaw(s, adatatype, as);
        }
        // Misplaced declaration of an exception variable
        catch (DataType adatatype[])
        {
            logMessage(adatatype, (new StringBuilder()).append("queryRaw threw exception on: ").append(s).toString());
            throw new RuntimeException(adatatype);
        }
        return adatatype;
    }

    public transient GenericRawResults queryRaw(String s, String as[])
    {
        try
        {
            as = dao.queryRaw(s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            logMessage(as, (new StringBuilder()).append("queryRaw threw exception on: ").append(s).toString());
            throw new RuntimeException(as);
        }
        return as;
    }

    public transient long queryRawValue(String s, String as[])
    {
        long l;
        try
        {
            l = dao.queryRawValue(s, as);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            logMessage(as, (new StringBuilder()).append("queryRawValue threw exception on: ").append(s).toString());
            throw new RuntimeException(as);
        }
        return l;
    }

    public int refresh(Object obj)
    {
        int i;
        try
        {
            i = dao.refresh(obj);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("refresh threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
        }
        return i;
    }

    public void rollBack(DatabaseConnection databaseconnection)
    {
        try
        {
            dao.rollBack(databaseconnection);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("rollBack(").append(databaseconnection).append(") threw exception").toString());
            throw new RuntimeException(sqlexception);
        }
    }

    public void setAutoCommit(DatabaseConnection databaseconnection, boolean flag)
    {
        try
        {
            dao.setAutoCommit(databaseconnection, flag);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("setAutoCommit(").append(databaseconnection).append(",").append(flag).append(") threw exception").toString());
            throw new RuntimeException(sqlexception);
        }
    }

    public void setAutoCommit(boolean flag)
    {
        try
        {
            dao.setAutoCommit(flag);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("setAutoCommit(").append(flag).append(") threw exception").toString());
            throw new RuntimeException(sqlexception);
        }
    }

    public void setObjectCache(ObjectCache objectcache)
    {
        try
        {
            dao.setObjectCache(objectcache);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("setObjectCache threw exception on ").append(objectcache).toString());
            throw new RuntimeException(sqlexception);
        }
    }

    public void setObjectCache(boolean flag)
    {
        try
        {
            dao.setObjectCache(flag);
            return;
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("setObjectCache(").append(flag).append(") threw exception").toString());
            throw new RuntimeException(sqlexception);
        }
    }

    public void setObjectFactory(ObjectFactory objectfactory)
    {
        dao.setObjectFactory(objectfactory);
    }

    public DatabaseConnection startThreadConnection()
    {
        DatabaseConnection databaseconnection;
        try
        {
            databaseconnection = dao.startThreadConnection();
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, "startThreadConnection() threw exception");
            throw new RuntimeException(sqlexception);
        }
        return databaseconnection;
    }

    public int update(PreparedUpdate preparedupdate)
    {
        int i;
        try
        {
            i = dao.update(preparedupdate);
        }
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("update threw exception on: ").append(preparedupdate).toString());
            throw new RuntimeException(sqlexception);
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
        catch (SQLException sqlexception)
        {
            logMessage(sqlexception, (new StringBuilder()).append("update threw exception on: ").append(obj).toString());
            throw new RuntimeException(sqlexception);
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
        catch (Object obj1)
        {
            logMessage(((Exception) (obj1)), (new StringBuilder()).append("updateId threw exception on: ").append(obj).toString());
            throw new RuntimeException(((Throwable) (obj1)));
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
        catch (String as[])
        {
            logMessage(as, (new StringBuilder()).append("updateRaw threw exception on: ").append(s).toString());
            throw new RuntimeException(as);
        }
        return i;
    }

    static 
    {
        LOG_LEVEL = com.j256.ormlite.logger.Log.Level.DEBUG;
    }
}
