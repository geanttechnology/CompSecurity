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
import com.j256.ormlite.stmt.GenericRowMapper;
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
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.dao:
//            Dao, ReferenceObjectCache, ObjectCache, CloseableIterator, 
//            CloseableWrappedIterableImpl, DaoManager, ForeignCollection, RawRowMapper, 
//            CloseableWrappedIterable, GenericRawResults, RawRowObjectMapper, CloseableIterable

public abstract class BaseDaoImpl
    implements Dao
{

    private static final ThreadLocal daoConfigLevelLocal = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected List initialValue()
        {
            return new ArrayList(10);
        }

    };
    private static ReferenceObjectCache defaultObjectCache;
    protected ConnectionSource connectionSource;
    protected final Class dataClass;
    protected DatabaseType databaseType;
    private boolean initialized;
    protected CloseableIterator lastIterator;
    private ObjectCache objectCache;
    protected ObjectFactory objectFactory;
    protected StatementExecutor statementExecutor;
    protected DatabaseTableConfig tableConfig;
    protected TableInfo tableInfo;

    protected BaseDaoImpl(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        this(connectionsource, databasetableconfig.getDataClass(), databasetableconfig);
    }

    protected BaseDaoImpl(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        this(connectionsource, class1, null);
    }

    private BaseDaoImpl(ConnectionSource connectionsource, Class class1, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        dataClass = class1;
        tableConfig = databasetableconfig;
        if (connectionsource != null)
        {
            connectionSource = connectionsource;
            initialize();
        }
    }

    protected BaseDaoImpl(Class class1)
        throws SQLException
    {
        this(null, class1, null);
    }

    public static void clearAllInternalObjectCaches()
    {
        com/j256/ormlite/dao/BaseDaoImpl;
        JVM INSTR monitorenter ;
        if (defaultObjectCache != null)
        {
            defaultObjectCache.clearAll();
            defaultObjectCache = null;
        }
        com/j256/ormlite/dao/BaseDaoImpl;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static Dao createDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        return new BaseDaoImpl(connectionsource, databasetableconfig) {

            public volatile Iterator iterator()
            {
                return iterator();
            }

        };
    }

    static Dao createDao(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        return new BaseDaoImpl(connectionsource, class1) {

            public volatile Iterator iterator()
            {
                return iterator();
            }

        };
    }

    private CloseableIterator createIterator(int i)
    {
        com.j256.ormlite.stmt.SelectIterator selectiterator;
        try
        {
            selectiterator = statementExecutor.buildIterator(this, connectionSource, i, objectCache);
        }
        catch (Exception exception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not build iterator for ").append(dataClass).toString(), exception);
        }
        return selectiterator;
    }

    private CloseableIterator createIterator(PreparedQuery preparedquery, int i)
        throws SQLException
    {
        try
        {
            preparedquery = statementExecutor.buildIterator(this, connectionSource, preparedquery, objectCache, i);
        }
        // Misplaced declaration of an exception variable
        catch (PreparedQuery preparedquery)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not build prepared-query iterator for ").append(dataClass).toString(), preparedquery);
        }
        return preparedquery;
    }

    private ForeignCollection makeEmptyForeignCollection(Object obj, String s)
        throws SQLException
    {
        checkForInitialized();
        Object obj1;
        FieldType afieldtype[];
        int j;
        if (obj == null)
        {
            obj1 = null;
        } else
        {
            obj1 = extractId(obj);
        }
        afieldtype = tableInfo.getFieldTypes();
        j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            FieldType fieldtype = afieldtype[i];
            if (fieldtype.getColumnName().equals(s))
            {
                s = fieldtype.buildForeignCollection(obj, obj1);
                if (obj != null)
                {
                    fieldtype.assignField(obj, s, true, null);
                }
                return s;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("Could not find a field named ").append(s).toString());
    }

    private List queryForFieldValues(Map map, boolean flag)
        throws SQLException
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
        throws SQLException
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
            where.eq(fieldtype.getColumnName(), obj1);
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

    public void assignEmptyForeignCollection(Object obj, String s)
        throws SQLException
    {
        makeEmptyForeignCollection(obj, s);
    }

    public Object callBatchTasks(Callable callable)
        throws SQLException
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
        throws SQLException
    {
        if (lastIterator != null)
        {
            lastIterator.close();
            lastIterator = null;
        }
    }

    public CloseableIterator closeableIterator()
    {
        return iterator(-1);
    }

    public void commit(DatabaseConnection databaseconnection)
        throws SQLException
    {
        databaseconnection.commit(null);
    }

    public long countOf()
        throws SQLException
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
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        if (preparedquery.getType() != com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT_LONG)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Prepared query is not of type ").append(com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT_LONG).append(", did you call QueryBuilder.setCountOf(true)?").toString());
        }
        databaseconnection = connectionSource.getReadOnlyConnection();
        long l = statementExecutor.queryForLong(databaseconnection, preparedquery);
        connectionSource.releaseConnection(databaseconnection);
        return l;
        preparedquery;
        connectionSource.releaseConnection(databaseconnection);
        throw preparedquery;
    }

    public int create(Object obj)
        throws SQLException
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
        throws SQLException
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
        throws SQLException
    {
        if (obj == null)
        {
            return new Dao.CreateOrUpdateStatus(false, false, 0);
        }
        Object obj1 = extractId(obj);
        if (obj1 == null || !idExists(obj1))
        {
            return new Dao.CreateOrUpdateStatus(true, false, create(obj));
        } else
        {
            return new Dao.CreateOrUpdateStatus(false, true, update(obj));
        }
    }

    public int delete(PreparedDelete prepareddelete)
        throws SQLException
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
        throws SQLException
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
        throws SQLException
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
        return new DeleteBuilder(databaseType, tableInfo, this);
    }

    public int deleteById(Object obj)
        throws SQLException
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
        throws SQLException
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

    public void endThreadConnection(DatabaseConnection databaseconnection)
        throws SQLException
    {
        connectionSource.clearSpecialConnection(databaseconnection);
        connectionSource.releaseConnection(databaseconnection);
    }

    public transient int executeRaw(String s, String as[])
        throws SQLException
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

    public int executeRawNoArgs(String s)
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadWriteConnection();
        int i = statementExecutor.executeRawNoArgs(databaseconnection, s);
        connectionSource.releaseConnection(databaseconnection);
        return i;
        SQLException sqlexception;
        sqlexception;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not run raw execute statement ").append(s).toString(), sqlexception);
        s;
        connectionSource.releaseConnection(databaseconnection);
        throw s;
    }

    public Object extractId(Object obj)
        throws SQLException
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
            if (fieldtype.getType() == class1)
            {
                return fieldtype;
            }
        }

        return null;
    }

    public ConnectionSource getConnectionSource()
    {
        return connectionSource;
    }

    public Class getDataClass()
    {
        return dataClass;
    }

    public ForeignCollection getEmptyForeignCollection(String s)
        throws SQLException
    {
        return makeEmptyForeignCollection(null, s);
    }

    public ObjectCache getObjectCache()
    {
        return objectCache;
    }

    public ObjectFactory getObjectFactory()
    {
        return objectFactory;
    }

    public RawRowMapper getRawRowMapper()
    {
        return statementExecutor.getRawRowMapper();
    }

    public GenericRowMapper getSelectStarRowMapper()
        throws SQLException
    {
        return statementExecutor.getSelectStarRowMapper();
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
                    closeableiterator = createIterator(-1);
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
                    closeableiterator = createIterator(preparedQuery, -1);
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

    public boolean idExists(Object obj)
        throws SQLException
    {
        DatabaseConnection databaseconnection = connectionSource.getReadOnlyConnection();
        boolean flag = statementExecutor.ifExists(databaseconnection, obj);
        connectionSource.releaseConnection(databaseconnection);
        return flag;
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
    }

    public void initialize()
        throws SQLException
    {
        if (!initialized) goto _L2; else goto _L1
_L1:
        return;
_L2:
        List list;
        Object obj;
        int i;
        if (connectionSource == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("connectionSource was never set on ").append(getClass().getSimpleName()).toString());
        }
        databaseType = connectionSource.getDatabaseType();
        if (databaseType == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("connectionSource is getting a null DatabaseType in ").append(getClass().getSimpleName()).toString());
        }
        FieldType afieldtype[];
        int j;
        int k;
        if (tableConfig == null)
        {
            tableInfo = new TableInfo(connectionSource, this, dataClass);
        } else
        {
            tableConfig.extractFieldTypes(connectionSource);
            tableInfo = new TableInfo(databaseType, this, tableConfig);
        }
        statementExecutor = new StatementExecutor(databaseType, tableInfo, this);
        list = (List)daoConfigLevelLocal.get();
        list.add(this);
        if (list.size() > 1) goto _L1; else goto _L3
_L3:
        i = 0;
_L7:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (BaseDaoImpl)list.get(i);
        DaoManager.registerDao(connectionSource, ((Dao) (obj)));
        afieldtype = ((BaseDaoImpl) (obj)).getTableInfo().getFieldTypes();
        k = afieldtype.length;
        j = 0;
_L5:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        afieldtype[j].configDaoInformation(connectionSource, ((BaseDaoImpl) (obj)).getDataClass());
        j++;
        if (true) goto _L5; else goto _L4
        SQLException sqlexception;
        sqlexception;
        DaoManager.unregisterDao(connectionSource, ((Dao) (obj)));
        throw sqlexception;
        obj;
        list.clear();
        daoConfigLevelLocal.remove();
        throw obj;
_L4:
        obj.initialized = true;
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        list.clear();
        daoConfigLevelLocal.remove();
        return;
    }

    public boolean isAutoCommit()
        throws SQLException
    {
        DatabaseConnection databaseconnection = connectionSource.getReadWriteConnection();
        boolean flag = isAutoCommit(databaseconnection);
        connectionSource.releaseConnection(databaseconnection);
        return flag;
        Exception exception;
        exception;
        connectionSource.releaseConnection(databaseconnection);
        throw exception;
    }

    public boolean isAutoCommit(DatabaseConnection databaseconnection)
        throws SQLException
    {
        return databaseconnection.isAutoCommit();
    }

    public boolean isTableExists()
        throws SQLException
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
        return iterator(-1);
    }

    public CloseableIterator iterator(int i)
    {
        checkForInitialized();
        lastIterator = createIterator(i);
        return lastIterator;
    }

    public CloseableIterator iterator(PreparedQuery preparedquery)
        throws SQLException
    {
        return iterator(preparedquery, -1);
    }

    public CloseableIterator iterator(PreparedQuery preparedquery, int i)
        throws SQLException
    {
        checkForInitialized();
        lastIterator = createIterator(preparedquery, i);
        return lastIterator;
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public Object mapSelectStarRow(DatabaseResults databaseresults)
        throws SQLException
    {
        return statementExecutor.getSelectStarRowMapper().mapRow(databaseresults);
    }

    public String objectToString(Object obj)
    {
        checkForInitialized();
        return tableInfo.objectToString(obj);
    }

    public boolean objectsEqual(Object obj, Object obj1)
        throws SQLException
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
        throws SQLException
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
        throws SQLException
    {
        checkForInitialized();
        return statementExecutor.queryForAll(connectionSource, objectCache);
    }

    public List queryForEq(String s, Object obj)
        throws SQLException
    {
        return queryBuilder().where().eq(s, obj).query();
    }

    public List queryForFieldValues(Map map)
        throws SQLException
    {
        return queryForFieldValues(map, false);
    }

    public List queryForFieldValuesArgs(Map map)
        throws SQLException
    {
        return queryForFieldValues(map, true);
    }

    public Object queryForFirst(PreparedQuery preparedquery)
        throws SQLException
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
        throws SQLException
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
        throws SQLException
    {
        return queryForMatching(obj, false);
    }

    public List queryForMatchingArgs(Object obj)
        throws SQLException
    {
        return queryForMatching(obj, true);
    }

    public Object queryForSameId(Object obj)
        throws SQLException
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
        throws SQLException
    {
        checkForInitialized();
        try
        {
            rawrowmapper = statementExecutor.queryRaw(connectionSource, s, rawrowmapper, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (RawRowMapper rawrowmapper)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not perform raw query for ").append(s).toString(), rawrowmapper);
        }
        return rawrowmapper;
    }

    public transient GenericRawResults queryRaw(String s, DataType adatatype[], RawRowObjectMapper rawrowobjectmapper, String as[])
        throws SQLException
    {
        checkForInitialized();
        try
        {
            adatatype = statementExecutor.queryRaw(connectionSource, s, adatatype, rawrowobjectmapper, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (DataType adatatype[])
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not perform raw query for ").append(s).toString(), adatatype);
        }
        return adatatype;
    }

    public transient GenericRawResults queryRaw(String s, DataType adatatype[], String as[])
        throws SQLException
    {
        checkForInitialized();
        try
        {
            adatatype = statementExecutor.queryRaw(connectionSource, s, adatatype, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (DataType adatatype[])
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not perform raw query for ").append(s).toString(), adatatype);
        }
        return adatatype;
    }

    public transient GenericRawResults queryRaw(String s, String as[])
        throws SQLException
    {
        checkForInitialized();
        try
        {
            as = statementExecutor.queryRaw(connectionSource, s, as, objectCache);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not perform raw query for ").append(s).toString(), as);
        }
        return as;
    }

    public transient long queryRawValue(String s, String as[])
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        checkForInitialized();
        databaseconnection = connectionSource.getReadOnlyConnection();
        long l = statementExecutor.queryForLong(databaseconnection, s, as);
        connectionSource.releaseConnection(databaseconnection);
        return l;
        as;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not perform raw value query for ").append(s).toString(), as);
        s;
        connectionSource.releaseConnection(databaseconnection);
        throw s;
    }

    public int refresh(Object obj)
        throws SQLException
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

    public void rollBack(DatabaseConnection databaseconnection)
        throws SQLException
    {
        databaseconnection.rollback(null);
    }

    public void setAutoCommit(DatabaseConnection databaseconnection, boolean flag)
        throws SQLException
    {
        databaseconnection.setAutoCommit(flag);
    }

    public void setAutoCommit(boolean flag)
        throws SQLException
    {
        DatabaseConnection databaseconnection = connectionSource.getReadWriteConnection();
        setAutoCommit(databaseconnection, flag);
        connectionSource.releaseConnection(databaseconnection);
        return;
        Exception exception;
        exception;
        connectionSource.releaseConnection(databaseconnection);
        throw exception;
    }

    public void setConnectionSource(ConnectionSource connectionsource)
    {
        connectionSource = connectionsource;
    }

    public void setObjectCache(ObjectCache objectcache)
        throws SQLException
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
            objectCache.registerClass(dataClass);
            return;
        }
    }

    public void setObjectCache(boolean flag)
        throws SQLException
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (objectCache != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        if (tableInfo.getIdField() == null)
        {
            throw new SQLException((new StringBuilder()).append("Class ").append(dataClass).append(" must have an id field to enable the object cache").toString());
        }
        com/j256/ormlite/dao/BaseDaoImpl;
        JVM INSTR monitorenter ;
        if (defaultObjectCache == null)
        {
            defaultObjectCache = ReferenceObjectCache.makeWeakCache();
        }
        objectCache = defaultObjectCache;
        com/j256/ormlite/dao/BaseDaoImpl;
        JVM INSTR monitorexit ;
        objectCache.registerClass(dataClass);
_L4:
        return;
        Exception exception;
        exception;
        com/j256/ormlite/dao/BaseDaoImpl;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (objectCache != null)
        {
            objectCache.clear(dataClass);
            objectCache = null;
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setObjectFactory(ObjectFactory objectfactory)
    {
        checkForInitialized();
        objectFactory = objectfactory;
    }

    public void setTableConfig(DatabaseTableConfig databasetableconfig)
    {
        tableConfig = databasetableconfig;
    }

    public DatabaseConnection startThreadConnection()
        throws SQLException
    {
        DatabaseConnection databaseconnection = connectionSource.getReadWriteConnection();
        connectionSource.saveSpecialConnection(databaseconnection);
        return databaseconnection;
    }

    public int update(PreparedUpdate preparedupdate)
        throws SQLException
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
        throws SQLException
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
        return new UpdateBuilder(databaseType, tableInfo, this);
    }

    public int updateId(Object obj, Object obj1)
        throws SQLException
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
        throws SQLException
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



}
