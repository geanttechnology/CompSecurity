// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.dao:
//            Dao, ObjectCache, CloseableIterator, CloseableWrappedIterableImpl, 
//            ReferenceObjectCache, ForeignCollection, CloseableWrappedIterable, RawRowMapper, 
//            GenericRawResults, CloseableIterable

public abstract class BaseDaoImpl
    implements Dao
{

    private static final ThreadLocal daoConfigLevelLocal = new ThreadLocal();
    private static ReferenceObjectCache defaultObjectCache;
    protected ConnectionSource connectionSource;
    protected final Class dataClass;
    protected DatabaseType databaseType;
    private boolean initialized;
    protected CloseableIterator lastIterator;
    private ObjectCache objectCache;
    protected StatementExecutor statementExecutor;
    protected DatabaseTableConfig tableConfig;
    protected TableInfo tableInfo;

    protected BaseDaoImpl(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        this(connectionsource, databasetableconfig.getDataClass(), databasetableconfig);
    }

    protected BaseDaoImpl(ConnectionSource connectionsource, Class class1)
    {
        this(connectionsource, class1, null);
    }

    private BaseDaoImpl(ConnectionSource connectionsource, Class class1, DatabaseTableConfig databasetableconfig)
    {
        initialized = false;
        objectCache = null;
        dataClass = class1;
        tableConfig = databasetableconfig;
        if (connectionsource != null)
        {
            connectionSource = connectionsource;
            initialize();
        }
    }

    protected BaseDaoImpl(Class class1)
    {
        this(null, class1, null);
    }

    public static Dao createDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        return new BaseDaoImpl(connectionsource, databasetableconfig) {

            public volatile Iterator iterator()
            {
                return iterator();
            }

        };
    }

    public static Dao createDao(ConnectionSource connectionsource, Class class1)
    {
        return new BaseDaoImpl(connectionsource, class1) {

            public volatile Iterator iterator()
            {
                return iterator();
            }

        };
    }

    private DaoConfigLevel getDaoConfigLevel()
    {
        DaoConfigLevel daoconfiglevel1 = (DaoConfigLevel)daoConfigLevelLocal.get();
        DaoConfigLevel daoconfiglevel = daoconfiglevel1;
        if (daoconfiglevel1 == null)
        {
            daoconfiglevel = new DaoConfigLevel();
            daoConfigLevelLocal.set(daoconfiglevel);
        }
        return daoconfiglevel;
    }

    private List queryForFieldValues(Map map, boolean flag)
    {
        checkForInitialized();
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        Object obj;
        java.util.Map.Entry entry;
        for (Iterator iterator1 = map.entrySet().iterator(); iterator1.hasNext(); where.eq((String)entry.getKey(), obj))
        {
            entry = (java.util.Map.Entry)iterator1.next();
            obj = entry.getValue();
            if (flag)
            {
                obj = new SelectArg(obj);
            }
        }

        if (map.size() == 0)
        {
            return Collections.emptyList();
        } else
        {
            where.and(map.size());
            return querybuilder.query();
        }
    }

    private List queryForMatching(Object obj, boolean flag)
    {
        checkForInitialized();
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        FieldType afieldtype[] = tableInfo.getFieldTypes();
        int k = afieldtype.length;
        int j = 0;
        int i = 0;
        for (; j < k; j++)
        {
            FieldType fieldtype = afieldtype[j];
            Object obj1 = fieldtype.getFieldValueIfNotDefault(obj);
            if (obj1 == null)
            {
                continue;
            }
            if (flag)
            {
                obj1 = new SelectArg(obj1);
            }
            where.eq(fieldtype.getDbColumnName(), obj1);
            i++;
        }

        if (i == 0)
        {
            return Collections.emptyList();
        } else
        {
            where.and(i);
            return querybuilder.query();
        }
    }

    public Object callBatchTasks(Callable callable)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadWriteConnection();
        boolean flag = connectionSource.saveSpecialConnection(databaseconnection);
        callable = ((Callable) (statementExecutor.callBatchTasks(databaseconnection, flag, callable)));
        connectionSource.clearSpecialConnection(databaseconnection);
        connectionSource.releaseConnection(databaseconnection);
        return callable;
        callable;
        connectionSource.clearSpecialConnection(databaseconnection);
        connectionSource.releaseConnection(databaseconnection);
        throw callable;
    }

    protected void checkForInitialized()
    {
        if (!initialized)
        {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        } else
        {
            return;
        }
    }

    public void clearObjectCache()
    {
        if (objectCache != null)
        {
            objectCache.clear(dataClass);
        }
    }

    public void closeLastIterator()
    {
        if (lastIterator != null)
        {
            lastIterator.close();
            lastIterator = null;
        }
    }

    public CloseableIterator closeableIterator()
    {
        lastIterator = seperateIterator();
        return lastIterator;
    }

    public long countOf()
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadOnlyConnection();
        long l = statementExecutor.queryForCountStar(databaseconnection);
        connectionSource.releaseConnection(databaseconnection);
        return l;
        Exception exception;
        exception;
        connectionSource.releaseConnection(databaseconnection);
        throw exception;
    }

    public long countOf(PreparedQuery preparedquery)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (preparedquery.getType() != com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT_LONG)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Prepared query is not of type ").append(com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT_LONG).append(", did you call QueryBuilder.setCountOf(true)?").toString());
        }
        databaseconnection = connectionSource.getReadOnlyConnection();
        long l = statementExecutor.queryForCountStar(databaseconnection, preparedquery);
        connectionSource.releaseConnection(databaseconnection);
        return l;
        preparedquery;
        connectionSource.releaseConnection(databaseconnection);
        throw preparedquery;
    }

    public int create(Object obj)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (obj == null)
        {
            return 0;
        }
        if (obj instanceof BaseDaoEnabled)
        {
            ((BaseDaoEnabled)obj).setDao(this);
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.create(databaseconnection, obj, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public Object createIfNotExists(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        Object obj1 = queryForSameId(obj);
        if (obj1 == null)
        {
            create(obj);
            return obj;
        } else
        {
            return obj1;
        }
    }

    public Dao.CreateOrUpdateStatus createOrUpdate(Object obj)
    {
        if (obj == null)
        {
            return new Dao.CreateOrUpdateStatus(false, false, 0);
        }
        if (queryForSameId(obj) == null)
        {
            return new Dao.CreateOrUpdateStatus(true, false, create(obj));
        } else
        {
            return new Dao.CreateOrUpdateStatus(false, true, update(obj));
        }
    }

    public int delete(PreparedDelete prepareddelete)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.delete(databaseconnection, prepareddelete);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        prepareddelete;
        connectionSource.releaseConnection(databaseconnection);
        throw prepareddelete;
    }

    public int delete(Object obj)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (obj == null)
        {
            return 0;
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.delete(databaseconnection, obj, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public int delete(Collection collection)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (collection == null || collection.isEmpty())
        {
            return 0;
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.deleteObjects(databaseconnection, collection, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        collection;
        connectionSource.releaseConnection(databaseconnection);
        throw collection;
    }

    public DeleteBuilder deleteBuilder()
    {
        checkForInitialized();
        return new DeleteBuilder(databaseType, tableInfo);
    }

    public int deleteById(Object obj)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (obj == null)
        {
            return 0;
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.deleteById(databaseconnection, obj, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public int deleteIds(Collection collection)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (collection == null || collection.isEmpty())
        {
            return 0;
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.deleteIds(databaseconnection, collection, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        collection;
        connectionSource.releaseConnection(databaseconnection);
        throw collection;
    }

    public transient int executeRaw(String s, String as[])
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.executeRaw(databaseconnection, s, as);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        as;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not run raw execute statement ").append(s).toString(), as);
        s;
        connectionSource.releaseConnection(databaseconnection);
        throw s;
    }

    public Object extractId(Object obj)
    {
        checkForInitialized();
        FieldType fieldtype = tableInfo.getIdField();
        if (fieldtype == null)
        {
            throw new SQLException((new StringBuilder()).append("Class ").append(dataClass).append(" does not have an id field").toString());
        } else
        {
            return fieldtype.extractJavaFieldValue(obj);
        }
    }

    public FieldType findForeignFieldType(Class class1)
    {
        checkForInitialized();
        FieldType afieldtype[] = tableInfo.getFieldTypes();
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            FieldType fieldtype = afieldtype[i];
            if (fieldtype.getFieldType() == class1)
            {
                return fieldtype;
            }
        }

        return null;
    }

    public Class getDataClass()
    {
        return dataClass;
    }

    public ForeignCollection getEmptyForeignCollection(String s)
    {
        checkForInitialized();
        FieldType afieldtype[] = tableInfo.getFieldTypes();
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            FieldType fieldtype = afieldtype[i];
            if (fieldtype.getDbColumnName().equals(s))
            {
                return fieldtype.buildForeignCollection(null, null, true);
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("Could not find a field named ").append(s).toString());
    }

    public ObjectCache getObjectCache()
    {
        return objectCache;
    }

    public DatabaseTableConfig getTableConfig()
    {
        return tableConfig;
    }

    public TableInfo getTableInfo()
    {
        return tableInfo;
    }

    public CloseableWrappedIterable getWrappedIterable()
    {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable() {

            final BaseDaoImpl this$0;

            public CloseableIterator closeableIterator()
            {
                CloseableIterator closeableiterator;
                try
                {
                    closeableiterator = seperateIterator();
                }
                catch (Exception exception)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Could not build iterator for ").append(dataClass).toString(), exception);
                }
                return closeableiterator;
            }

            public Iterator iterator()
            {
                return closeableIterator();
            }

            
            {
                this$0 = BaseDaoImpl.this;
                super();
            }
        });
    }

    public CloseableWrappedIterable getWrappedIterable(final PreparedQuery preparedQuery)
    {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable() {

            final BaseDaoImpl this$0;
            final PreparedQuery val$preparedQuery;

            public CloseableIterator closeableIterator()
            {
                CloseableIterator closeableiterator;
                try
                {
                    closeableiterator = seperateIterator(preparedQuery);
                }
                catch (Exception exception)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Could not build prepared-query iterator for ").append(dataClass).toString(), exception);
                }
                return closeableiterator;
            }

            public Iterator iterator()
            {
                return closeableIterator();
            }

            
            {
                this$0 = BaseDaoImpl.this;
                preparedQuery = preparedquery;
                super();
            }
        });
    }

    public void initialize()
    {
        DaoConfigLevel daoconfiglevel;
        if (initialized)
        {
            return;
        }
        if (connectionSource == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("connectionSource was never set on ").append(getClass().getSimpleName()).toString());
        }
        databaseType = connectionSource.getDatabaseType();
        if (databaseType == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("connectionSource is getting a null DatabaseType in ").append(getClass().getSimpleName()).toString());
        }
        if (tableConfig == null)
        {
            tableInfo = new TableInfo(connectionSource, this, dataClass);
        } else
        {
            tableConfig.extractFieldTypes(connectionSource);
            tableInfo = new TableInfo(databaseType, this, tableConfig);
        }
        statementExecutor = new StatementExecutor(databaseType, tableInfo, this);
        daoconfiglevel = getDaoConfigLevel();
        daoconfiglevel.level = daoconfiglevel.level + 1;
        if (daoconfiglevel.level <= 1) goto _L2; else goto _L1
_L1:
        daoconfiglevel.addDao(this);
_L6:
        daoconfiglevel.level = daoconfiglevel.level - 1;
        initialized = true;
        return;
_L2:
        FieldType afieldtype[];
        int j;
        afieldtype = tableInfo.getFieldTypes();
        j = afieldtype.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        afieldtype[i].configDaoInformation(connectionSource, dataClass);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        List list = daoconfiglevel.daoList;
        if (list == null) goto _L6; else goto _L5
_L5:
        i = 0;
_L11:
        if (i >= list.size()) goto _L8; else goto _L7
_L7:
        BaseDaoImpl basedaoimpl;
        FieldType afieldtype1[];
        int k;
        basedaoimpl = (BaseDaoImpl)list.get(i);
        afieldtype1 = basedaoimpl.getTableInfo().getFieldTypes();
        k = afieldtype1.length;
        j = 0;
_L10:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        afieldtype1[j].configDaoInformation(connectionSource, basedaoimpl.dataClass);
        j++;
        if (true) goto _L10; else goto _L9
_L8:
        list.clear();
          goto _L6
        Exception exception;
        exception;
        daoconfiglevel.level = daoconfiglevel.level - 1;
        throw exception;
_L9:
        i++;
          goto _L11
    }

    public boolean isTableExists()
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadOnlyConnection();
        boolean flag = databaseconnection.isTableExists(tableInfo.getTableName());
        connectionSource.releaseConnection(databaseconnection);
        return flag;
        Exception exception;
        exception;
        connectionSource.releaseConnection(databaseconnection);
        throw exception;
    }

    public boolean isUpdatable()
    {
        return tableInfo.isUpdatable();
    }

    public CloseableIterator iterator()
    {
        return closeableIterator();
    }

    public CloseableIterator iterator(PreparedQuery preparedquery)
    {
        lastIterator = seperateIterator(preparedquery);
        return lastIterator;
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public String objectToString(Object obj)
    {
        checkForInitialized();
        return tableInfo.objectToString(obj);
    }

    public boolean objectsEqual(Object obj, Object obj1)
    {
        checkForInitialized();
        FieldType afieldtype[] = tableInfo.getFieldTypes();
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            FieldType fieldtype = afieldtype[i];
            Object obj2 = fieldtype.extractJavaFieldValue(obj);
            Object obj3 = fieldtype.extractJavaFieldValue(obj1);
            if (!fieldtype.getDataPersister().dataIsEqual(obj2, obj3))
            {
                return false;
            }
        }

        return true;
    }

    public List query(PreparedQuery preparedquery)
    {
        checkForInitialized();
        return statementExecutor.query(connectionSource, preparedquery, objectCache);
    }

    public QueryBuilder queryBuilder()
    {
        checkForInitialized();
        return new QueryBuilder(databaseType, tableInfo, this);
    }

    public List queryForAll()
    {
        checkForInitialized();
        return statementExecutor.queryForAll(connectionSource, objectCache);
    }

    public List queryForEq(String s, Object obj)
    {
        return queryBuilder().where().eq(s, obj).query();
    }

    public List queryForFieldValues(Map map)
    {
        return queryForFieldValues(map, false);
    }

    public List queryForFieldValuesArgs(Map map)
    {
        return queryForFieldValues(map, true);
    }

    public Object queryForFirst(PreparedQuery preparedquery)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadOnlyConnection();
        preparedquery = ((PreparedQuery) (statementExecutor.queryForFirst(databaseconnection, preparedquery, objectCache)));
        connectionSource.releaseConnection(databaseconnection);
        return preparedquery;
        preparedquery;
        connectionSource.releaseConnection(databaseconnection);
        throw preparedquery;
    }

    public Object queryForId(Object obj)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadOnlyConnection();
        obj = statementExecutor.queryForId(databaseconnection, obj, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return obj;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public List queryForMatching(Object obj)
    {
        return queryForMatching(obj, false);
    }

    public List queryForMatchingArgs(Object obj)
    {
        return queryForMatching(obj, true);
    }

    public Object queryForSameId(Object obj)
    {
        checkForInitialized();
        if (obj != null)
        {
            if ((obj = extractId(obj)) != null)
            {
                return queryForId(obj);
            }
        }
        return null;
    }

    public transient GenericRawResults queryRaw(String s, RawRowMapper rawrowmapper, String as[])
    {
        checkForInitialized();
        try
        {
            rawrowmapper = statementExecutor.queryRaw(connectionSource, s, rawrowmapper, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (RawRowMapper rawrowmapper)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not build iterator for ").append(s).toString(), rawrowmapper);
        }
        return rawrowmapper;
    }

    public transient GenericRawResults queryRaw(String s, DataType adatatype[], String as[])
    {
        checkForInitialized();
        try
        {
            adatatype = statementExecutor.queryRaw(connectionSource, s, adatatype, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (DataType adatatype[])
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not build iterator for ").append(s).toString(), adatatype);
        }
        return adatatype;
    }

    public transient GenericRawResults queryRaw(String s, String as[])
    {
        checkForInitialized();
        try
        {
            as = statementExecutor.queryRaw(connectionSource, s, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not build iterator for ").append(s).toString(), as);
        }
        return as;
    }

    public int refresh(Object obj)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (obj == null)
        {
            return 0;
        }
        if (obj instanceof BaseDaoEnabled)
        {
            ((BaseDaoEnabled)obj).setDao(this);
        }
        databaseconnection = connectionSource.getReadOnlyConnection();
        int i = statementExecutor.refresh(databaseconnection, obj, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public CloseableIterator seperateIterator()
    {
        checkForInitialized();
        com.j256.ormlite.stmt.SelectIterator selectiterator;
        try
        {
            selectiterator = statementExecutor.buildIterator(this, connectionSource, objectCache);
        }
        catch (Exception exception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not build iterator for ").append(dataClass).toString(), exception);
        }
        return selectiterator;
    }

    public CloseableIterator seperateIterator(PreparedQuery preparedquery)
    {
        checkForInitialized();
        try
        {
            preparedquery = statementExecutor.buildIterator(this, connectionSource, preparedquery, objectCache);
            lastIterator = preparedquery;
        }
        // Misplaced declaration of an exception variable
        catch (PreparedQuery preparedquery)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not build prepared-query iterator for ").append(dataClass).toString(), preparedquery);
        }
        return preparedquery;
    }

    public void setConnectionSource(ConnectionSource connectionsource)
    {
        connectionSource = connectionsource;
    }

    public void setObjectCache(ObjectCache objectcache)
    {
        if (objectcache == null)
        {
            if (objectCache != null)
            {
                objectCache.clear(dataClass);
                objectCache = null;
            }
            return;
        }
        if (objectCache != null && objectCache != objectcache)
        {
            objectCache.clear(dataClass);
        }
        if (tableInfo.getIdField() == null)
        {
            throw new SQLException((new StringBuilder()).append("Class ").append(dataClass).append(" must have an id field to enable the object cache").toString());
        } else
        {
            objectCache = objectcache;
            return;
        }
    }

    public void setObjectCache(boolean flag)
    {
        if (flag)
        {
            if (objectCache == null)
            {
                if (tableInfo.getIdField() == null)
                {
                    throw new SQLException((new StringBuilder()).append("Class ").append(dataClass).append(" must have an id field to enable the object cache").toString());
                }
                if (defaultObjectCache == null)
                {
                    defaultObjectCache = ReferenceObjectCache.makeWeakCache();
                }
                objectCache = defaultObjectCache;
            }
        } else
        if (objectCache != null)
        {
            objectCache.clear(dataClass);
            objectCache = null;
            return;
        }
    }

    public void setTableConfig(DatabaseTableConfig databasetableconfig)
    {
        tableConfig = databasetableconfig;
    }

    public int update(PreparedUpdate preparedupdate)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.update(databaseconnection, preparedupdate);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        preparedupdate;
        connectionSource.releaseConnection(databaseconnection);
        throw preparedupdate;
    }

    public int update(Object obj)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (obj == null)
        {
            return 0;
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.update(databaseconnection, obj, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public UpdateBuilder updateBuilder()
    {
        checkForInitialized();
        return new UpdateBuilder(databaseType, tableInfo);
    }

    public int updateId(Object obj, Object obj1)
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (obj == null)
        {
            return 0;
        }
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.updateId(databaseconnection, obj, obj1, objectCache);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public transient int updateRaw(String s, String as[])
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.updateRaw(databaseconnection, s, as);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        as;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not run raw update statement ").append(s).toString(), as);
        s;
        connectionSource.releaseConnection(databaseconnection);
        throw s;
    }


    private class DaoConfigLevel
    {

        List daoList;
        int level;

        public void addDao(BaseDaoImpl basedaoimpl)
        {
            if (daoList == null)
            {
                daoList = new ArrayList();
            }
            daoList.add(basedaoimpl);
        }

        private DaoConfigLevel()
        {
        }

    }

}
