// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
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
import com.j256.ormlite.table.ObjectFactory;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, ForeignCollection, ObjectCache, RawRowMapper, 
//            CloseableWrappedIterable, CloseableIterator, GenericRawResults, RawRowObjectMapper

public interface Dao
    extends CloseableIterable
{
    public static class CreateOrUpdateStatus
    {

        private boolean created;
        private int numLinesChanged;
        private boolean updated;

        public int getNumLinesChanged()
        {
            return numLinesChanged;
        }

        public boolean isCreated()
        {
            return created;
        }

        public boolean isUpdated()
        {
            return updated;
        }

        public CreateOrUpdateStatus(boolean flag, boolean flag1, int i)
        {
            created = flag;
            updated = flag1;
            numLinesChanged = i;
        }
    }


    public abstract void assignEmptyForeignCollection(Object obj, String s)
        throws SQLException;

    public abstract Object callBatchTasks(Callable callable)
        throws Exception;

    public abstract void clearObjectCache();

    public abstract void closeLastIterator()
        throws SQLException;

    public abstract void commit(DatabaseConnection databaseconnection)
        throws SQLException;

    public abstract long countOf()
        throws SQLException;

    public abstract long countOf(PreparedQuery preparedquery)
        throws SQLException;

    public abstract int create(Object obj)
        throws SQLException;

    public abstract Object createIfNotExists(Object obj)
        throws SQLException;

    public abstract CreateOrUpdateStatus createOrUpdate(Object obj)
        throws SQLException;

    public abstract int delete(PreparedDelete prepareddelete)
        throws SQLException;

    public abstract int delete(Object obj)
        throws SQLException;

    public abstract int delete(Collection collection)
        throws SQLException;

    public abstract DeleteBuilder deleteBuilder();

    public abstract int deleteById(Object obj)
        throws SQLException;

    public abstract int deleteIds(Collection collection)
        throws SQLException;

    public abstract void endThreadConnection(DatabaseConnection databaseconnection)
        throws SQLException;

    public transient abstract int executeRaw(String s, String as[])
        throws SQLException;

    public abstract int executeRawNoArgs(String s)
        throws SQLException;

    public abstract Object extractId(Object obj)
        throws SQLException;

    public abstract FieldType findForeignFieldType(Class class1);

    public abstract ConnectionSource getConnectionSource();

    public abstract Class getDataClass();

    public abstract ForeignCollection getEmptyForeignCollection(String s)
        throws SQLException;

    public abstract ObjectCache getObjectCache();

    public abstract RawRowMapper getRawRowMapper();

    public abstract GenericRowMapper getSelectStarRowMapper()
        throws SQLException;

    public abstract CloseableWrappedIterable getWrappedIterable();

    public abstract CloseableWrappedIterable getWrappedIterable(PreparedQuery preparedquery);

    public abstract boolean idExists(Object obj)
        throws SQLException;

    public abstract boolean isAutoCommit()
        throws SQLException;

    public abstract boolean isAutoCommit(DatabaseConnection databaseconnection)
        throws SQLException;

    public abstract boolean isTableExists()
        throws SQLException;

    public abstract boolean isUpdatable();

    public abstract CloseableIterator iterator();

    public abstract CloseableIterator iterator(int i);

    public abstract CloseableIterator iterator(PreparedQuery preparedquery)
        throws SQLException;

    public abstract CloseableIterator iterator(PreparedQuery preparedquery, int i)
        throws SQLException;

    public abstract Object mapSelectStarRow(DatabaseResults databaseresults)
        throws SQLException;

    public abstract String objectToString(Object obj);

    public abstract boolean objectsEqual(Object obj, Object obj1)
        throws SQLException;

    public abstract List query(PreparedQuery preparedquery)
        throws SQLException;

    public abstract QueryBuilder queryBuilder();

    public abstract List queryForAll()
        throws SQLException;

    public abstract List queryForEq(String s, Object obj)
        throws SQLException;

    public abstract List queryForFieldValues(Map map)
        throws SQLException;

    public abstract List queryForFieldValuesArgs(Map map)
        throws SQLException;

    public abstract Object queryForFirst(PreparedQuery preparedquery)
        throws SQLException;

    public abstract Object queryForId(Object obj)
        throws SQLException;

    public abstract List queryForMatching(Object obj)
        throws SQLException;

    public abstract List queryForMatchingArgs(Object obj)
        throws SQLException;

    public abstract Object queryForSameId(Object obj)
        throws SQLException;

    public transient abstract GenericRawResults queryRaw(String s, RawRowMapper rawrowmapper, String as[])
        throws SQLException;

    public transient abstract GenericRawResults queryRaw(String s, DataType adatatype[], RawRowObjectMapper rawrowobjectmapper, String as[])
        throws SQLException;

    public transient abstract GenericRawResults queryRaw(String s, DataType adatatype[], String as[])
        throws SQLException;

    public transient abstract GenericRawResults queryRaw(String s, String as[])
        throws SQLException;

    public transient abstract long queryRawValue(String s, String as[])
        throws SQLException;

    public abstract int refresh(Object obj)
        throws SQLException;

    public abstract void rollBack(DatabaseConnection databaseconnection)
        throws SQLException;

    public abstract void setAutoCommit(DatabaseConnection databaseconnection, boolean flag)
        throws SQLException;

    public abstract void setAutoCommit(boolean flag)
        throws SQLException;

    public abstract void setObjectCache(ObjectCache objectcache)
        throws SQLException;

    public abstract void setObjectCache(boolean flag)
        throws SQLException;

    public abstract void setObjectFactory(ObjectFactory objectfactory);

    public abstract DatabaseConnection startThreadConnection()
        throws SQLException;

    public abstract int update(PreparedUpdate preparedupdate)
        throws SQLException;

    public abstract int update(Object obj)
        throws SQLException;

    public abstract UpdateBuilder updateBuilder();

    public abstract int updateId(Object obj, Object obj1)
        throws SQLException;

    public transient abstract int updateRaw(String s, String as[])
        throws SQLException;
}
