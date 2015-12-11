// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.j256.ormlite.table:
//            TableInfo, DatabaseTableConfig

public class TableUtils
{

    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/table/TableUtils);
    private static final FieldType noFieldTypes[] = new FieldType[0];

    private TableUtils()
    {
    }

    private static void addCreateIndexStatements(DatabaseType databasetype, TableInfo tableinfo, List list, boolean flag, boolean flag1)
    {
        HashMap hashmap = new HashMap();
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int j = afieldtype.length;
        int i = 0;
        while (i < j) 
        {
            FieldType fieldtype = afieldtype[i];
            String s;
            if (flag1)
            {
                s = fieldtype.getUniqueIndexName();
            } else
            {
                s = fieldtype.getIndexName();
            }
            if (s != null)
            {
                List list1 = (List)hashmap.get(s);
                Object obj = list1;
                if (list1 == null)
                {
                    obj = new ArrayList();
                    hashmap.put(s, obj);
                }
                ((List) (obj)).add(fieldtype.getColumnName());
            }
            i++;
        }
        StringBuilder stringbuilder = new StringBuilder(128);
        for (Iterator iterator = hashmap.entrySet().iterator(); iterator.hasNext(); stringbuilder.setLength(0))
        {
            Object obj1 = (java.util.Map.Entry)iterator.next();
            logger.info("creating index '{}' for table '{}", ((java.util.Map.Entry) (obj1)).getKey(), tableinfo.getTableName());
            stringbuilder.append("CREATE ");
            if (flag1)
            {
                stringbuilder.append("UNIQUE ");
            }
            stringbuilder.append("INDEX ");
            if (flag && databasetype.isCreateIndexIfNotExistsSupported())
            {
                stringbuilder.append("IF NOT EXISTS ");
            }
            databasetype.appendEscapedEntityName(stringbuilder, (String)((java.util.Map.Entry) (obj1)).getKey());
            stringbuilder.append(" ON ");
            databasetype.appendEscapedEntityName(stringbuilder, tableinfo.getTableName());
            stringbuilder.append(" ( ");
            boolean flag2 = true;
            obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                String s1 = (String)((Iterator) (obj1)).next();
                if (flag2)
                {
                    flag2 = false;
                } else
                {
                    stringbuilder.append(", ");
                }
                databasetype.appendEscapedEntityName(stringbuilder, s1);
            }
            stringbuilder.append(" )");
            list.add(stringbuilder.toString());
        }

    }

    private static void addCreateTableStatements(DatabaseType databasetype, TableInfo tableinfo, List list, List list1, boolean flag)
        throws SQLException
    {
        StringBuilder stringbuilder = new StringBuilder(256);
        stringbuilder.append("CREATE TABLE ");
        if (flag && databasetype.isCreateIfNotExistsSupported())
        {
            stringbuilder.append("IF NOT EXISTS ");
        }
        databasetype.appendEscapedEntityName(stringbuilder, tableinfo.getTableName());
        stringbuilder.append(" (");
        Object obj = new ArrayList();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        boolean flag1 = true;
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int j = afieldtype.length;
        int i = 0;
        while (i < j) 
        {
            FieldType fieldtype = afieldtype[i];
            if (!fieldtype.isForeignCollection())
            {
                String s;
                if (flag1)
                {
                    flag1 = false;
                } else
                {
                    stringbuilder.append(", ");
                }
                s = fieldtype.getColumnDefinition();
                if (s == null)
                {
                    databasetype.appendColumnArg(tableinfo.getTableName(), stringbuilder, fieldtype, ((List) (obj)), arraylist, arraylist1, list1);
                } else
                {
                    databasetype.appendEscapedEntityName(stringbuilder, fieldtype.getColumnName());
                    stringbuilder.append(' ').append(s).append(' ');
                }
            }
            i++;
        }
        databasetype.addPrimaryKeySql(tableinfo.getFieldTypes(), ((List) (obj)), arraylist, arraylist1, list1);
        databasetype.addUniqueComboSql(tableinfo.getFieldTypes(), ((List) (obj)), arraylist, arraylist1, list1);
        for (list1 = ((List) (obj)).iterator(); list1.hasNext(); stringbuilder.append(", ").append(((String) (obj))))
        {
            obj = (String)list1.next();
        }

        stringbuilder.append(") ");
        databasetype.appendCreateTableSuffix(stringbuilder);
        list.addAll(arraylist);
        list.add(stringbuilder.toString());
        list.addAll(arraylist1);
        addCreateIndexStatements(databasetype, tableinfo, list, flag, false);
        addCreateIndexStatements(databasetype, tableinfo, list, flag, true);
    }

    public static int clearTable(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        String s = DatabaseTableConfig.extractTableName(class1);
        class1 = s;
        if (connectionsource.getDatabaseType().isEntityNamesMustBeUpCase())
        {
            class1 = s.toUpperCase();
        }
        return clearTable(connectionsource, ((String) (class1)));
    }

    private static int clearTable(ConnectionSource connectionsource, String s)
        throws SQLException
    {
        Object obj1;
        Object obj = connectionsource.getDatabaseType();
        obj1 = new StringBuilder(48);
        int i;
        if (((DatabaseType) (obj)).isTruncateSupported())
        {
            ((StringBuilder) (obj1)).append("TRUNCATE TABLE ");
        } else
        {
            ((StringBuilder) (obj1)).append("DELETE FROM ");
        }
        ((DatabaseType) (obj)).appendEscapedEntityName(((StringBuilder) (obj1)), s);
        obj = ((StringBuilder) (obj1)).toString();
        logger.info("clearing table '{}' with '{}", s, obj);
        s = null;
        obj1 = connectionsource.getReadWriteConnection();
        obj = ((DatabaseConnection) (obj1)).compileStatement(((String) (obj)), com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE, noFieldTypes);
        s = ((String) (obj));
        i = ((CompiledStatement) (obj)).runExecute();
        if (obj != null)
        {
            ((CompiledStatement) (obj)).close();
        }
        connectionsource.releaseConnection(((DatabaseConnection) (obj1)));
        return i;
        Exception exception;
        exception;
        if (s != null)
        {
            s.close();
        }
        connectionsource.releaseConnection(((DatabaseConnection) (obj1)));
        throw exception;
    }

    public static int createTable(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        return createTable(connectionsource, class1, false);
    }

    private static int createTable(ConnectionSource connectionsource, Class class1, boolean flag)
        throws SQLException
    {
        com.j256.ormlite.dao.Dao dao = DaoManager.createDao(connectionsource, class1);
        if (dao instanceof BaseDaoImpl)
        {
            return doCreateTable(connectionsource, ((BaseDaoImpl)dao).getTableInfo(), flag);
        } else
        {
            return doCreateTable(connectionsource, new TableInfo(connectionsource, null, class1), flag);
        }
    }

    private static int doCreateTable(ConnectionSource connectionsource, TableInfo tableinfo, boolean flag)
        throws SQLException
    {
        DatabaseType databasetype;
        ArrayList arraylist;
        ArrayList arraylist1;
        databasetype = connectionsource.getDatabaseType();
        logger.info("creating table '{}'", tableinfo.getTableName());
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        addCreateTableStatements(databasetype, tableinfo, arraylist, arraylist1, flag);
        tableinfo = connectionsource.getReadWriteConnection();
        int i;
        int j;
        i = doStatements(tableinfo, "create", arraylist, false, databasetype.isCreateTableReturnsNegative(), databasetype.isCreateTableReturnsZero());
        j = doCreateTestQueries(tableinfo, databasetype, arraylist1);
        connectionsource.releaseConnection(tableinfo);
        return i + j;
        Exception exception;
        exception;
        connectionsource.releaseConnection(tableinfo);
        throw exception;
    }

    private static int doCreateTestQueries(DatabaseConnection databaseconnection, DatabaseType databasetype, List list)
        throws SQLException
    {
        Iterator iterator;
        int i;
        i = 0;
        iterator = list.iterator();
_L4:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        list = null;
        databasetype = null;
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s, com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT, noFieldTypes);
        databasetype = compiledstatement;
        list = compiledstatement;
        DatabaseResults databaseresults = compiledstatement.runQuery(null);
        int j;
        j = 0;
        databasetype = compiledstatement;
        list = compiledstatement;
        boolean flag = databaseresults.first();
_L2:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        j++;
        databasetype = compiledstatement;
        list = compiledstatement;
        flag = databaseresults.next();
        if (true) goto _L2; else goto _L1
_L1:
        databasetype = compiledstatement;
        list = compiledstatement;
        logger.info("executing create table after-query got {} results: {}", Integer.valueOf(j), s);
        if (compiledstatement != null)
        {
            compiledstatement.close();
        }
        i++;
        if (true) goto _L4; else goto _L3
        databaseconnection;
        list = databasetype;
        throw SqlExceptionUtil.create((new StringBuilder()).append("executing create table after-query failed: ").append(s).toString(), databaseconnection);
        databaseconnection;
        if (list != null)
        {
            list.close();
        }
        throw databaseconnection;
_L3:
        return i;
    }

    private static int doStatements(DatabaseConnection databaseconnection, String s, Collection collection, boolean flag, boolean flag1, boolean flag2)
        throws SQLException
    {
        Iterator iterator;
        int j;
        j = 0;
        iterator = collection.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1;
        int i;
        int k;
        s1 = (String)iterator.next();
        k = 0;
        obj = null;
        collection = null;
        i = k;
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s1, com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE, noFieldTypes);
        collection = compiledstatement;
        i = k;
        obj = compiledstatement;
        k = compiledstatement.runExecute();
        collection = compiledstatement;
        i = k;
        obj = compiledstatement;
        logger.info("executed {} table statement changed {} rows: {}", s, Integer.valueOf(k), s1);
        int l;
        l = k;
        if (compiledstatement != null)
        {
            compiledstatement.close();
            l = k;
        }
_L4:
        if (l < 0)
        {
            if (!flag1)
            {
                throw new SQLException((new StringBuilder()).append("SQL statement ").append(s1).append(" updated ").append(l).append(" rows, we were expecting >= 0").toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_274;
        SQLException sqlexception;
        sqlexception;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = collection;
        logger.info("ignoring {} error '{}' for statement: {}", s, sqlexception, s1);
        l = i;
        if (collection != null)
        {
            collection.close();
            l = i;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = collection;
        throw SqlExceptionUtil.create((new StringBuilder()).append("SQL statement failed: ").append(s1).toString(), sqlexception);
        databaseconnection;
        if (obj != null)
        {
            ((CompiledStatement) (obj)).close();
        }
        throw databaseconnection;
        if (l > 0 && flag2)
        {
            throw new SQLException((new StringBuilder()).append("SQL statement updated ").append(l).append(" rows, we were expecting == 0: ").append(s1).toString());
        }
        j++;
          goto _L5
_L2:
        return j;
    }

}
