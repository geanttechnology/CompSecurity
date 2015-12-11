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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.dao:
//            CloseableIterable, ForeignCollection, ObjectCache, CloseableWrappedIterable, 
//            CloseableIterator, RawRowMapper, GenericRawResults

public interface Dao
    extends CloseableIterable
{

    public abstract Object callBatchTasks(Callable callable);

    public abstract void clearObjectCache();

    public abstract void closeLastIterator();

    public abstract long countOf();

    public abstract long countOf(PreparedQuery preparedquery);

    public abstract int create(Object obj);

    public abstract Object createIfNotExists(Object obj);

    public abstract CreateOrUpdateStatus createOrUpdate(Object obj);

    public abstract int delete(PreparedDelete prepareddelete);

    public abstract int delete(Object obj);

    public abstract int delete(Collection collection);

    public abstract DeleteBuilder deleteBuilder();

    public abstract int deleteById(Object obj);

    public abstract int deleteIds(Collection collection);

    public transient abstract int executeRaw(String s, String as[]);

    public abstract Object extractId(Object obj);

    public abstract FieldType findForeignFieldType(Class class1);

    public abstract Class getDataClass();

    public abstract ForeignCollection getEmptyForeignCollection(String s);

    public abstract ObjectCache getObjectCache();

    public abstract CloseableWrappedIterable getWrappedIterable();

    public abstract CloseableWrappedIterable getWrappedIterable(PreparedQuery preparedquery);

    public abstract boolean isTableExists();

    public abstract boolean isUpdatable();

    public abstract CloseableIterator iterator();

    public abstract CloseableIterator iterator(PreparedQuery preparedquery);

    public abstract String objectToString(Object obj);

    public abstract boolean objectsEqual(Object obj, Object obj1);

    public abstract List query(PreparedQuery preparedquery);

    public abstract QueryBuilder queryBuilder();

    public abstract List queryForAll();

    public abstract List queryForEq(String s, Object obj);

    public abstract List queryForFieldValues(Map map);

    public abstract List queryForFieldValuesArgs(Map map);

    public abstract Object queryForFirst(PreparedQuery preparedquery);

    public abstract Object queryForId(Object obj);

    public abstract List queryForMatching(Object obj);

    public abstract List queryForMatchingArgs(Object obj);

    public abstract Object queryForSameId(Object obj);

    public transient abstract GenericRawResults queryRaw(String s, RawRowMapper rawrowmapper, String as[]);

    public transient abstract GenericRawResults queryRaw(String s, DataType adatatype[], String as[]);

    public transient abstract GenericRawResults queryRaw(String s, String as[]);

    public abstract int refresh(Object obj);

    public abstract void setObjectCache(ObjectCache objectcache);

    public abstract void setObjectCache(boolean flag);

    public abstract int update(PreparedUpdate preparedupdate);

    public abstract int update(Object obj);

    public abstract UpdateBuilder updateBuilder();

    public abstract int updateId(Object obj, Object obj1);

    public transient abstract int updateRaw(String s, String as[]);
}
