// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedDeleteCollection;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.mapped.MappedUpdateId;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper, QueryBuilder, PreparedStmt, SelectIterator, 
//            PreparedDelete, RawResultsImpl, PreparedUpdate, PreparedQuery

public class StatementExecutor
    implements GenericRowMapper
{

    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/stmt/StatementExecutor);
    private static final FieldType noFieldTypes[] = new FieldType[0];
    private final Dao dao;
    private final DatabaseType databaseType;
    private MappedDelete mappedDelete;
    private MappedCreate mappedInsert;
    private MappedQueryForId mappedQueryForId;
    private MappedRefresh mappedRefresh;
    private MappedUpdate mappedUpdate;
    private MappedUpdateId mappedUpdateId;
    private PreparedQuery preparedQueryForAll;
    private final TableInfo tableInfo;

    public StatementExecutor(DatabaseType databasetype, TableInfo tableinfo, Dao dao1)
    {
        databaseType = databasetype;
        tableInfo = tableinfo;
        dao = dao1;
    }

    private void assignStatementArguments(CompiledStatement compiledstatement, String as[])
    {
        int i = 0;
        while (i < as.length) 
        {
            if (as[i] == null)
            {
                compiledstatement.setNull(i, SqlType.STRING);
            } else
            {
                compiledstatement.setObject(i, as[i], SqlType.STRING);
            }
            i++;
        }
    }

    private String[] extractColumnNames(CompiledStatement compiledstatement)
    {
        int j = compiledstatement.getColumnCount();
        String as[] = new String[j];
        for (int i = 0; i < j; i++)
        {
            as[i] = compiledstatement.getColumnName(i);
        }

        return as;
    }

    private void prepareQueryForAll()
    {
        if (preparedQueryForAll == null)
        {
            preparedQueryForAll = (new QueryBuilder(databaseType, tableInfo, dao)).prepare();
        }
    }

    public SelectIterator buildIterator(BaseDaoImpl basedaoimpl, ConnectionSource connectionsource, ObjectCache objectcache)
    {
        prepareQueryForAll();
        return buildIterator(basedaoimpl, connectionsource, ((PreparedStmt) (preparedQueryForAll)), objectcache);
    }

    public SelectIterator buildIterator(BaseDaoImpl basedaoimpl, ConnectionSource connectionsource, PreparedStmt preparedstmt, ObjectCache objectcache)
    {
        DatabaseConnection databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = preparedstmt.compile(databaseconnection, StatementBuilder.StatementType.SELECT);
        basedaoimpl = new SelectIterator(tableInfo.getDataClass(), basedaoimpl, preparedstmt, connectionsource, databaseconnection, compiledstatement, preparedstmt.getStatement(), objectcache);
        if (false)
        {
            throw new NullPointerException();
        }
        if (false)
        {
            connectionsource.releaseConnection(null);
        }
        return basedaoimpl;
        basedaoimpl;
        compiledstatement = null;
_L2:
        if (compiledstatement != null)
        {
            compiledstatement.close();
        }
        if (databaseconnection != null)
        {
            connectionsource.releaseConnection(databaseconnection);
        }
        throw basedaoimpl;
        basedaoimpl;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Object callBatchTasks(DatabaseConnection databaseconnection, boolean flag, Callable callable)
    {
        if (!databaseType.isBatchUseTransaction()) goto _L2; else goto _L1
_L1:
        callable = ((Callable) (TransactionManager.callInTransaction(databaseconnection, flag, databaseType, callable)));
_L4:
        return callable;
_L2:
        if (!databaseconnection.isAutoCommitSupported())
        {
            break MISSING_BLOCK_LABEL_182;
        }
        flag = databaseconnection.getAutoCommit();
        boolean flag1;
        boolean flag2;
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        flag2 = flag;
        databaseconnection.setAutoCommit(false);
        flag2 = flag;
        logger.debug("disabled auto-commit on table {} before batch tasks", new Object[] {
            tableInfo.getTableName()
        });
        flag1 = flag;
_L7:
        flag2 = flag1;
        Object obj = callable.call();
        callable = ((Callable) (obj));
        if (!flag1) goto _L4; else goto _L3
_L3:
        databaseconnection.setAutoCommit(true);
        logger.debug("re-enabled auto-commit on table {} after batch tasks", new Object[] {
            tableInfo.getTableName()
        });
        return obj;
        callable;
        flag2 = false;
_L6:
        if (flag2)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("re-enabled auto-commit on table {} after batch tasks", new Object[] {
                tableInfo.getTableName()
            });
        }
        throw callable;
        callable;
        if (true) goto _L6; else goto _L5
_L5:
        flag1 = false;
          goto _L7
    }

    public int create(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (mappedInsert == null)
        {
            mappedInsert = MappedCreate.build(databaseType, tableInfo);
        }
        return mappedInsert.insert(databaseType, databaseconnection, obj, objectcache);
    }

    public int delete(DatabaseConnection databaseconnection, PreparedDelete prepareddelete)
    {
        databaseconnection = prepareddelete.compile(databaseconnection, StatementBuilder.StatementType.DELETE);
        int i = databaseconnection.runUpdate();
        databaseconnection.close();
        return i;
        prepareddelete;
        databaseconnection.close();
        throw prepareddelete;
    }

    public int delete(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (mappedDelete == null)
        {
            mappedDelete = MappedDelete.build(databaseType, tableInfo);
        }
        return mappedDelete.delete(databaseconnection, obj, objectcache);
    }

    public int deleteById(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (mappedDelete == null)
        {
            mappedDelete = MappedDelete.build(databaseType, tableInfo);
        }
        return mappedDelete.deleteById(databaseconnection, obj, objectcache);
    }

    public int deleteIds(DatabaseConnection databaseconnection, Collection collection, ObjectCache objectcache)
    {
        return MappedDeleteCollection.deleteIds(databaseType, tableInfo, databaseconnection, collection, objectcache);
    }

    public int deleteObjects(DatabaseConnection databaseconnection, Collection collection, ObjectCache objectcache)
    {
        return MappedDeleteCollection.deleteObjects(databaseType, tableInfo, databaseconnection, collection, objectcache);
    }

    public int executeRaw(DatabaseConnection databaseconnection, String s, String as[])
    {
        logger.debug("running raw execute statement: {}", new Object[] {
            s
        });
        if (as.length > 0)
        {
            logger.trace("execute arguments: {}", new Object[] {
                as
            });
        }
        databaseconnection = databaseconnection.compileStatement(s, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
        int i;
        assignStatementArguments(databaseconnection, as);
        i = databaseconnection.runExecute();
        databaseconnection.close();
        return i;
        s;
        databaseconnection.close();
        throw s;
    }

    public volatile Object mapRow(DatabaseResults databaseresults)
    {
        return mapRow(databaseresults);
    }

    public String[] mapRow(DatabaseResults databaseresults)
    {
        int j = databaseresults.getColumnCount();
        String as[] = new String[j];
        for (int i = 0; i < j; i++)
        {
            as[i] = databaseresults.getString(i);
        }

        return as;
    }

    public List query(ConnectionSource connectionsource, PreparedStmt preparedstmt, ObjectCache objectcache)
    {
        ConnectionSource connectionsource1 = null;
        connectionsource = buildIterator(null, connectionsource, preparedstmt, objectcache);
        connectionsource1 = connectionsource;
        objectcache = new ArrayList();
_L2:
        connectionsource1 = connectionsource;
        if (!connectionsource.hasNextThrow())
        {
            break; /* Loop/switch isn't completed */
        }
        connectionsource1 = connectionsource;
        objectcache.add(connectionsource.nextThrow());
        if (true) goto _L2; else goto _L1
        connectionsource;
        if (connectionsource1 != null)
        {
            connectionsource1.close();
        }
        throw connectionsource;
_L1:
        connectionsource1 = connectionsource;
        logger.debug("query of '{}' returned {} results", new Object[] {
            preparedstmt.getStatement(), Integer.valueOf(objectcache.size())
        });
        if (connectionsource != null)
        {
            connectionsource.close();
        }
        return objectcache;
    }

    public List queryForAll(ConnectionSource connectionsource, ObjectCache objectcache)
    {
        prepareQueryForAll();
        return query(connectionsource, preparedQueryForAll, objectcache);
    }

    public long queryForCountStar(DatabaseConnection databaseconnection)
    {
        Object obj = new StringBuilder(64);
        ((StringBuilder) (obj)).append("SELECT COUNT(*) FROM ");
        databaseType.appendEscapedEntityName(((StringBuilder) (obj)), tableInfo.getTableName());
        obj = ((StringBuilder) (obj)).toString();
        long l = databaseconnection.queryForLong(((String) (obj)));
        logger.debug("query of '{}' returned {}", new Object[] {
            obj, Long.valueOf(l)
        });
        return l;
    }

    public long queryForCountStar(DatabaseConnection databaseconnection, PreparedStmt preparedstmt)
    {
        databaseconnection = preparedstmt.compile(databaseconnection, StatementBuilder.StatementType.SELECT_LONG);
        long l;
        preparedstmt = databaseconnection.runQuery(null);
        if (!preparedstmt.next())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        l = preparedstmt.getLong(0);
        databaseconnection.close();
        return l;
        databaseconnection.close();
        return 0L;
        preparedstmt;
        databaseconnection.close();
        throw preparedstmt;
    }

    public Object queryForFirst(DatabaseConnection databaseconnection, PreparedStmt preparedstmt, ObjectCache objectcache)
    {
        databaseconnection = preparedstmt.compile(databaseconnection, StatementBuilder.StatementType.SELECT);
        objectcache = databaseconnection.runQuery(objectcache);
        if (!objectcache.next())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        logger.debug("query-for-first of '{}' returned at least 1 result", new Object[] {
            preparedstmt.getStatement()
        });
        preparedstmt = ((PreparedStmt) (preparedstmt.mapRow(objectcache)));
        databaseconnection.close();
        return preparedstmt;
        logger.debug("query-for-first of '{}' returned at 0 results", new Object[] {
            preparedstmt.getStatement()
        });
        databaseconnection.close();
        return null;
        preparedstmt;
        databaseconnection.close();
        throw preparedstmt;
    }

    public Object queryForId(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (mappedQueryForId == null)
        {
            mappedQueryForId = MappedQueryForId.build(databaseType, tableInfo);
        }
        return mappedQueryForId.execute(databaseconnection, obj, objectcache);
    }

    public GenericRawResults queryRaw(ConnectionSource connectionsource, String s, RawRowMapper rawrowmapper, String as[], ObjectCache objectcache)
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", new Object[] {
            s
        });
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", new Object[] {
                as
            });
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes);
        assignStatementArguments(compiledstatement, as);
        as = extractColumnNames(compiledstatement);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/String;, compiledstatement, as, new UserObjectRowMapper(rawrowmapper, as, this), objectcache);
        if (false)
        {
            throw new NullPointerException();
        }
        if (false)
        {
            connectionsource.releaseConnection(null);
        }
        return s;
        s;
        compiledstatement = null;
_L2:
        if (compiledstatement != null)
        {
            compiledstatement.close();
        }
        if (databaseconnection != null)
        {
            connectionsource.releaseConnection(databaseconnection);
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public GenericRawResults queryRaw(ConnectionSource connectionsource, String s, DataType adatatype[], String as[], ObjectCache objectcache)
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", new Object[] {
            s
        });
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", new Object[] {
                as
            });
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes);
        assignStatementArguments(compiledstatement, as);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/Object;, compiledstatement, extractColumnNames(compiledstatement), new ObjectArrayRowMapper(adatatype), objectcache);
        if (false)
        {
            throw new NullPointerException();
        }
        if (false)
        {
            connectionsource.releaseConnection(null);
        }
        return s;
        s;
        compiledstatement = null;
_L2:
        if (compiledstatement != null)
        {
            compiledstatement.close();
        }
        if (databaseconnection != null)
        {
            connectionsource.releaseConnection(databaseconnection);
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public GenericRawResults queryRaw(ConnectionSource connectionsource, String s, String as[], ObjectCache objectcache)
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", new Object[] {
            s
        });
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", new Object[] {
                as
            });
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes);
        assignStatementArguments(compiledstatement, as);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/String;, compiledstatement, extractColumnNames(compiledstatement), this, objectcache);
        if (false)
        {
            throw new NullPointerException();
        }
        if (false)
        {
            connectionsource.releaseConnection(null);
        }
        return s;
        s;
        compiledstatement = null;
_L2:
        if (compiledstatement != null)
        {
            compiledstatement.close();
        }
        if (databaseconnection != null)
        {
            connectionsource.releaseConnection(databaseconnection);
        }
        throw s;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int refresh(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (mappedRefresh == null)
        {
            mappedRefresh = MappedRefresh.build(databaseType, tableInfo);
        }
        return mappedRefresh.executeRefresh(databaseconnection, obj, objectcache);
    }

    public int update(DatabaseConnection databaseconnection, PreparedUpdate preparedupdate)
    {
        databaseconnection = preparedupdate.compile(databaseconnection, StatementBuilder.StatementType.UPDATE);
        int i = databaseconnection.runUpdate();
        databaseconnection.close();
        return i;
        preparedupdate;
        databaseconnection.close();
        throw preparedupdate;
    }

    public int update(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
    {
        if (mappedUpdate == null)
        {
            mappedUpdate = MappedUpdate.build(databaseType, tableInfo);
        }
        return mappedUpdate.update(databaseconnection, obj, objectcache);
    }

    public int updateId(DatabaseConnection databaseconnection, Object obj, Object obj1, ObjectCache objectcache)
    {
        if (mappedUpdateId == null)
        {
            mappedUpdateId = MappedUpdateId.build(databaseType, tableInfo);
        }
        return mappedUpdateId.execute(databaseconnection, obj, obj1, objectcache);
    }

    public int updateRaw(DatabaseConnection databaseconnection, String s, String as[])
    {
        logger.debug("running raw update statement: {}", new Object[] {
            s
        });
        if (as.length > 0)
        {
            logger.trace("update arguments: {}", new Object[] {
                as
            });
        }
        databaseconnection = databaseconnection.compileStatement(s, StatementBuilder.StatementType.UPDATE, noFieldTypes);
        int i;
        assignStatementArguments(databaseconnection, as);
        i = databaseconnection.runUpdate();
        databaseconnection.close();
        return i;
        s;
        databaseconnection.close();
        throw s;
    }


    private class UserObjectRowMapper
        implements GenericRowMapper
    {

        private final String columnNames[];
        private final RawRowMapper mapper;
        private final GenericRowMapper stringRowMapper;

        public Object mapRow(DatabaseResults databaseresults)
        {
            databaseresults = (String[])stringRowMapper.mapRow(databaseresults);
            return mapper.mapRow(columnNames, databaseresults);
        }

        public UserObjectRowMapper(RawRowMapper rawrowmapper, String as[], GenericRowMapper genericrowmapper)
        {
            mapper = rawrowmapper;
            columnNames = as;
            stringRowMapper = genericrowmapper;
        }
    }


    private class ObjectArrayRowMapper
        implements GenericRowMapper
    {

        private final DataType columnTypes[];

        public volatile Object mapRow(DatabaseResults databaseresults)
        {
            return ((Object) (mapRow(databaseresults)));
        }

        public Object[] mapRow(DatabaseResults databaseresults)
        {
            int j = databaseresults.getColumnCount();
            Object aobj[] = new Object[j];
            int i = 0;
            while (i < j) 
            {
                DataType datatype;
                if (i >= columnTypes.length)
                {
                    datatype = DataType.STRING;
                } else
                {
                    datatype = columnTypes[i];
                }
                aobj[i] = datatype.getDataPersister().resultToJava(null, databaseresults, i);
                i++;
            }
            return aobj;
        }

        public ObjectArrayRowMapper(DataType adatatype[])
        {
            columnTypes = adatatype;
        }
    }

}
