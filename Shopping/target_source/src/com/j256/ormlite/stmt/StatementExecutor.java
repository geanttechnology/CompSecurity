// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper, QueryBuilder, PreparedStmt, SelectIterator, 
//            PreparedDelete, RawRowMapperImpl, SelectArg, Where, 
//            RawResultsImpl, PreparedUpdate, PreparedQuery

public class StatementExecutor
    implements GenericRowMapper
{
    private static class ObjectArrayRowMapper
        implements GenericRowMapper
    {

        private final DataType columnTypes[];

        public volatile Object mapRow(DatabaseResults databaseresults)
            throws SQLException
        {
            return ((Object) (mapRow(databaseresults)));
        }

        public Object[] mapRow(DatabaseResults databaseresults)
            throws SQLException
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

    private static class UserRawRowMapper
        implements GenericRowMapper
    {

        private String columnNames[];
        private final RawRowMapper mapper;
        private final GenericRowMapper stringRowMapper;

        private String[] getColumnNames(DatabaseResults databaseresults)
            throws SQLException
        {
            if (columnNames != null)
            {
                return columnNames;
            } else
            {
                columnNames = databaseresults.getColumnNames();
                return columnNames;
            }
        }

        public Object mapRow(DatabaseResults databaseresults)
            throws SQLException
        {
            String as[] = (String[])stringRowMapper.mapRow(databaseresults);
            return mapper.mapRow(getColumnNames(databaseresults), as);
        }

        public UserRawRowMapper(RawRowMapper rawrowmapper, GenericRowMapper genericrowmapper)
        {
            mapper = rawrowmapper;
            stringRowMapper = genericrowmapper;
        }
    }

    private static class UserRawRowObjectMapper
        implements GenericRowMapper
    {

        private String columnNames[];
        private final DataType columnTypes[];
        private final RawRowObjectMapper mapper;

        private String[] getColumnNames(DatabaseResults databaseresults)
            throws SQLException
        {
            if (columnNames != null)
            {
                return columnNames;
            } else
            {
                columnNames = databaseresults.getColumnNames();
                return columnNames;
            }
        }

        public Object mapRow(DatabaseResults databaseresults)
            throws SQLException
        {
            int j = databaseresults.getColumnCount();
            Object aobj[] = new Object[j];
            int i = 0;
            while (i < j) 
            {
                if (i >= columnTypes.length)
                {
                    aobj[i] = null;
                } else
                {
                    aobj[i] = columnTypes[i].getDataPersister().resultToJava(null, databaseresults, i);
                }
                i++;
            }
            return mapper.mapRow(getColumnNames(databaseresults), columnTypes, aobj);
        }

        public UserRawRowObjectMapper(RawRowObjectMapper rawrowobjectmapper, DataType adatatype[])
        {
            mapper = rawrowobjectmapper;
            columnTypes = adatatype;
        }
    }


    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/stmt/StatementExecutor);
    private static final FieldType noFieldTypes[] = new FieldType[0];
    private String countStarQuery;
    private final Dao dao;
    private final DatabaseType databaseType;
    private FieldType ifExistsFieldTypes[];
    private String ifExistsQuery;
    private MappedDelete mappedDelete;
    private MappedCreate mappedInsert;
    private MappedQueryForId mappedQueryForId;
    private MappedRefresh mappedRefresh;
    private MappedUpdate mappedUpdate;
    private MappedUpdateId mappedUpdateId;
    private PreparedQuery preparedQueryForAll;
    private RawRowMapper rawRowMapper;
    private final TableInfo tableInfo;

    public StatementExecutor(DatabaseType databasetype, TableInfo tableinfo, Dao dao1)
    {
        databaseType = databasetype;
        tableInfo = tableinfo;
        dao = dao1;
    }

    private void assignStatementArguments(CompiledStatement compiledstatement, String as[])
        throws SQLException
    {
        for (int i = 0; i < as.length; i++)
        {
            compiledstatement.setObject(i, as[i], SqlType.STRING);
        }

    }

    private void prepareQueryForAll()
        throws SQLException
    {
        if (preparedQueryForAll == null)
        {
            preparedQueryForAll = (new QueryBuilder(databaseType, tableInfo, dao)).prepare();
        }
    }

    public SelectIterator buildIterator(BaseDaoImpl basedaoimpl, ConnectionSource connectionsource, int i, ObjectCache objectcache)
        throws SQLException
    {
        prepareQueryForAll();
        return buildIterator(basedaoimpl, connectionsource, ((PreparedStmt) (preparedQueryForAll)), objectcache, i);
    }

    public SelectIterator buildIterator(BaseDaoImpl basedaoimpl, ConnectionSource connectionsource, PreparedStmt preparedstmt, ObjectCache objectcache, int i)
        throws SQLException
    {
        DatabaseConnection databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = preparedstmt.compile(databaseconnection, StatementBuilder.StatementType.SELECT, i);
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
        throws SQLException
    {
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        if (!databaseType.isBatchUseTransaction()) goto _L2; else goto _L1
_L1:
        callable = ((Callable) (TransactionManager.callInTransaction(databaseconnection, flag, databaseType, callable)));
_L4:
        return callable;
_L2:
        flag = flag1;
        flag1 = flag2;
        if (!databaseconnection.isAutoCommitSupported())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        flag1 = flag2;
        flag2 = databaseconnection.isAutoCommit();
        flag = flag2;
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        flag1 = flag2;
        databaseconnection.setAutoCommit(false);
        flag1 = flag2;
        logger.debug("disabled auto-commit on table {} before batch tasks", tableInfo.getTableName());
        flag = flag2;
        flag1 = flag;
        Object obj = callable.call();
        callable = ((Callable) (obj));
        if (flag)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("re-enabled auto-commit on table {} after batch tasks", tableInfo.getTableName());
            return obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
        callable;
        flag1 = flag;
        throw callable;
        callable;
        if (flag1)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("re-enabled auto-commit on table {} after batch tasks", tableInfo.getTableName());
        }
        throw callable;
        callable;
        flag1 = flag;
        throw SqlExceptionUtil.create("Batch tasks callable threw non-SQL exception", callable);
    }

    public int create(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        if (mappedInsert == null)
        {
            mappedInsert = MappedCreate.build(databaseType, tableInfo);
        }
        return mappedInsert.insert(databaseType, databaseconnection, obj, objectcache);
    }

    public int delete(DatabaseConnection databaseconnection, PreparedDelete prepareddelete)
        throws SQLException
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
        throws SQLException
    {
        if (mappedDelete == null)
        {
            mappedDelete = MappedDelete.build(databaseType, tableInfo);
        }
        return mappedDelete.delete(databaseconnection, obj, objectcache);
    }

    public int deleteById(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        if (mappedDelete == null)
        {
            mappedDelete = MappedDelete.build(databaseType, tableInfo);
        }
        return mappedDelete.deleteById(databaseconnection, obj, objectcache);
    }

    public int deleteIds(DatabaseConnection databaseconnection, Collection collection, ObjectCache objectcache)
        throws SQLException
    {
        return MappedDeleteCollection.deleteIds(databaseType, tableInfo, databaseconnection, collection, objectcache);
    }

    public int deleteObjects(DatabaseConnection databaseconnection, Collection collection, ObjectCache objectcache)
        throws SQLException
    {
        return MappedDeleteCollection.deleteObjects(databaseType, tableInfo, databaseconnection, collection, objectcache);
    }

    public int executeRaw(DatabaseConnection databaseconnection, String s, String as[])
        throws SQLException
    {
        logger.debug("running raw execute statement: {}", s);
        if (as.length > 0)
        {
            logger.trace("execute arguments: {}", as);
        }
        databaseconnection = databaseconnection.compileStatement(s, StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
        int i;
        assignStatementArguments(databaseconnection, as);
        i = databaseconnection.runExecute();
        databaseconnection.close();
        return i;
        s;
        databaseconnection.close();
        throw s;
    }

    public int executeRawNoArgs(DatabaseConnection databaseconnection, String s)
        throws SQLException
    {
        logger.debug("running raw execute statement: {}", s);
        return databaseconnection.executeStatement(s, -1);
    }

    public RawRowMapper getRawRowMapper()
    {
        if (rawRowMapper == null)
        {
            rawRowMapper = new RawRowMapperImpl(tableInfo);
        }
        return rawRowMapper;
    }

    public GenericRowMapper getSelectStarRowMapper()
        throws SQLException
    {
        prepareQueryForAll();
        return preparedQueryForAll;
    }

    public boolean ifExists(DatabaseConnection databaseconnection, Object obj)
        throws SQLException
    {
        if (ifExistsQuery == null)
        {
            QueryBuilder querybuilder = new QueryBuilder(databaseType, tableInfo, dao);
            querybuilder.selectRaw(new String[] {
                "COUNT(*)"
            });
            querybuilder.where().eq(tableInfo.getIdField().getColumnName(), new SelectArg());
            ifExistsQuery = querybuilder.prepareStatementString();
            ifExistsFieldTypes = (new FieldType[] {
                tableInfo.getIdField()
            });
        }
        String s = ifExistsQuery;
        FieldType afieldtype[] = ifExistsFieldTypes;
        long l = databaseconnection.queryForLong(s, new Object[] {
            obj
        }, afieldtype);
        logger.debug("query of '{}' returned {}", ifExistsQuery, Long.valueOf(l));
        return l != 0L;
    }

    public volatile Object mapRow(DatabaseResults databaseresults)
        throws SQLException
    {
        return mapRow(databaseresults);
    }

    public String[] mapRow(DatabaseResults databaseresults)
        throws SQLException
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
        throws SQLException
    {
        connectionsource = buildIterator(null, connectionsource, preparedstmt, objectcache, -1);
        objectcache = new ArrayList();
        for (; connectionsource.hasNextThrow(); objectcache.add(connectionsource.nextThrow())) { }
        break MISSING_BLOCK_LABEL_46;
        preparedstmt;
        connectionsource.close();
        throw preparedstmt;
        logger.debug("query of '{}' returned {} results", preparedstmt.getStatement(), Integer.valueOf(objectcache.size()));
        connectionsource.close();
        return objectcache;
    }

    public List queryForAll(ConnectionSource connectionsource, ObjectCache objectcache)
        throws SQLException
    {
        prepareQueryForAll();
        return query(connectionsource, preparedQueryForAll, objectcache);
    }

    public long queryForCountStar(DatabaseConnection databaseconnection)
        throws SQLException
    {
        if (countStarQuery == null)
        {
            StringBuilder stringbuilder = new StringBuilder(64);
            stringbuilder.append("SELECT COUNT(*) FROM ");
            databaseType.appendEscapedEntityName(stringbuilder, tableInfo.getTableName());
            countStarQuery = stringbuilder.toString();
        }
        long l = databaseconnection.queryForLong(countStarQuery);
        logger.debug("query of '{}' returned {}", countStarQuery, Long.valueOf(l));
        return l;
    }

    public Object queryForFirst(DatabaseConnection databaseconnection, PreparedStmt preparedstmt, ObjectCache objectcache)
        throws SQLException
    {
        CompiledStatement compiledstatement = preparedstmt.compile(databaseconnection, StatementBuilder.StatementType.SELECT);
        databaseconnection = compiledstatement.runQuery(objectcache);
        if (!databaseconnection.first())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        logger.debug("query-for-first of '{}' returned at least 1 result", preparedstmt.getStatement());
        preparedstmt = ((PreparedStmt) (preparedstmt.mapRow(databaseconnection)));
        if (databaseconnection != null)
        {
            databaseconnection.close();
        }
        compiledstatement.close();
        return preparedstmt;
        logger.debug("query-for-first of '{}' returned at 0 results", preparedstmt.getStatement());
        if (databaseconnection != null)
        {
            databaseconnection.close();
        }
        compiledstatement.close();
        return null;
        databaseconnection;
        objectcache = null;
        preparedstmt = databaseconnection;
_L2:
        if (objectcache != null)
        {
            objectcache.close();
        }
        compiledstatement.close();
        throw preparedstmt;
        preparedstmt;
        objectcache = databaseconnection;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Object queryForId(DatabaseConnection databaseconnection, Object obj, ObjectCache objectcache)
        throws SQLException
    {
        if (mappedQueryForId == null)
        {
            mappedQueryForId = MappedQueryForId.build(databaseType, tableInfo, null);
        }
        return mappedQueryForId.execute(databaseconnection, obj, objectcache);
    }

    public long queryForLong(DatabaseConnection databaseconnection, PreparedStmt preparedstmt)
        throws SQLException
    {
        CompiledStatement compiledstatement;
        Object obj = null;
        compiledstatement = preparedstmt.compile(databaseconnection, StatementBuilder.StatementType.SELECT_LONG);
        databaseconnection = obj;
        DatabaseResults databaseresults = compiledstatement.runQuery(null);
        databaseconnection = databaseresults;
        if (!databaseresults.first())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        databaseconnection = databaseresults;
        long l = databaseresults.getLong(0);
        if (databaseresults != null)
        {
            databaseresults.close();
        }
        compiledstatement.close();
        return l;
        databaseconnection = databaseresults;
        throw new SQLException((new StringBuilder()).append("No result found in queryForLong: ").append(preparedstmt.getStatement()).toString());
        preparedstmt;
        if (databaseconnection != null)
        {
            databaseconnection.close();
        }
        compiledstatement.close();
        throw preparedstmt;
    }

    public long queryForLong(DatabaseConnection databaseconnection, String s, String as[])
        throws SQLException
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        logger.debug("executing raw query for long: {}", s);
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", as);
        }
        databaseconnection = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        obj = databaseconnection;
        databaseconnection = obj1;
        assignStatementArguments(((CompiledStatement) (obj)), as);
        databaseconnection = obj1;
        as = ((CompiledStatement) (obj)).runQuery(null);
        databaseconnection = as;
        if (!as.first())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        databaseconnection = as;
        long l = as.getLong(0);
        if (as != null)
        {
            as.close();
        }
        if (obj != null)
        {
            ((CompiledStatement) (obj)).close();
        }
        return l;
        databaseconnection = as;
        throw new SQLException((new StringBuilder()).append("No result found in queryForLong: ").append(s).toString());
        as;
        s = databaseconnection;
        databaseconnection = as;
_L2:
        if (s != null)
        {
            s.close();
        }
        if (obj != null)
        {
            ((CompiledStatement) (obj)).close();
        }
        throw databaseconnection;
        databaseconnection;
        as = null;
        s = ((String) (obj));
        obj = as;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public GenericRawResults queryRaw(ConnectionSource connectionsource, String s, RawRowMapper rawrowmapper, String as[], ObjectCache objectcache)
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", s);
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", as);
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        assignStatementArguments(compiledstatement, as);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/String;, compiledstatement, new UserRawRowMapper(rawrowmapper, this), objectcache);
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

    public GenericRawResults queryRaw(ConnectionSource connectionsource, String s, DataType adatatype[], RawRowObjectMapper rawrowobjectmapper, String as[], ObjectCache objectcache)
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", s);
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", as);
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        assignStatementArguments(compiledstatement, as);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/String;, compiledstatement, new UserRawRowObjectMapper(rawrowobjectmapper, adatatype), objectcache);
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
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", s);
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", as);
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        assignStatementArguments(compiledstatement, as);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/Object;, compiledstatement, new ObjectArrayRowMapper(adatatype), objectcache);
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
        throws SQLException
    {
        DatabaseConnection databaseconnection;
        logger.debug("executing raw query for: {}", s);
        if (as.length > 0)
        {
            logger.trace("query arguments: {}", as);
        }
        databaseconnection = connectionsource.getReadOnlyConnection();
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        assignStatementArguments(compiledstatement, as);
        s = new RawResultsImpl(connectionsource, databaseconnection, s, [Ljava/lang/String;, compiledstatement, this, objectcache);
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
        throws SQLException
    {
        if (mappedRefresh == null)
        {
            mappedRefresh = MappedRefresh.build(databaseType, tableInfo);
        }
        return mappedRefresh.executeRefresh(databaseconnection, obj, objectcache);
    }

    public int update(DatabaseConnection databaseconnection, PreparedUpdate preparedupdate)
        throws SQLException
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
        throws SQLException
    {
        if (mappedUpdate == null)
        {
            mappedUpdate = MappedUpdate.build(databaseType, tableInfo);
        }
        return mappedUpdate.update(databaseconnection, obj, objectcache);
    }

    public int updateId(DatabaseConnection databaseconnection, Object obj, Object obj1, ObjectCache objectcache)
        throws SQLException
    {
        if (mappedUpdateId == null)
        {
            mappedUpdateId = MappedUpdateId.build(databaseType, tableInfo);
        }
        return mappedUpdateId.execute(databaseconnection, obj, obj1, objectcache);
    }

    public int updateRaw(DatabaseConnection databaseconnection, String s, String as[])
        throws SQLException
    {
        logger.debug("running raw update statement: {}", s);
        if (as.length > 0)
        {
            logger.trace("update arguments: {}", as);
        }
        databaseconnection = databaseconnection.compileStatement(s, StatementBuilder.StatementType.UPDATE, noFieldTypes, -1);
        int i;
        assignStatementArguments(databaseconnection, as);
        i = databaseconnection.runUpdate();
        databaseconnection.close();
        return i;
        s;
        databaseconnection.close();
        throw s;
    }

}
