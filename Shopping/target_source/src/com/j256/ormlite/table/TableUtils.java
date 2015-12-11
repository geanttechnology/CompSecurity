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
import java.util.HashSet;
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
            obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
            boolean flag2 = true;
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

    private static List addCreateTableStatements(ConnectionSource connectionsource, TableInfo tableinfo, boolean flag)
        throws SQLException
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        addCreateTableStatements(connectionsource.getDatabaseType(), tableinfo, ((List) (arraylist)), ((List) (arraylist1)), flag);
        return arraylist;
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
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int j = afieldtype.length;
        int i = 0;
        boolean flag1 = true;
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

    private static void addDropIndexStatements(DatabaseType databasetype, TableInfo tableinfo, List list)
    {
        Object obj = new HashSet();
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            Object obj1 = afieldtype[i];
            String s1 = ((FieldType) (obj1)).getIndexName();
            if (s1 != null)
            {
                ((Set) (obj)).add(s1);
            }
            obj1 = ((FieldType) (obj1)).getUniqueIndexName();
            if (obj1 != null)
            {
                ((Set) (obj)).add(obj1);
            }
        }

        StringBuilder stringbuilder = new StringBuilder(48);
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.setLength(0))
        {
            String s = (String)((Iterator) (obj)).next();
            logger.info("dropping index '{}' for table '{}", s, tableinfo.getTableName());
            stringbuilder.append("DROP INDEX ");
            databasetype.appendEscapedEntityName(stringbuilder, s);
            list.add(stringbuilder.toString());
        }

    }

    private static void addDropTableStatements(DatabaseType databasetype, TableInfo tableinfo, List list)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        FieldType afieldtype[] = tableinfo.getFieldTypes();
        int j = afieldtype.length;
        for (int i = 0; i < j; i++)
        {
            databasetype.dropColumnArg(afieldtype[i], arraylist, arraylist1);
        }

        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("DROP TABLE ");
        databasetype.appendEscapedEntityName(stringbuilder, tableinfo.getTableName());
        stringbuilder.append(' ');
        list.addAll(arraylist);
        list.add(stringbuilder.toString());
        list.addAll(arraylist1);
    }

    public static int clearTable(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        return clearTable(connectionsource, databasetableconfig.getTableName());
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
        obj = ((DatabaseConnection) (obj1)).compileStatement(((String) (obj)), com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
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

    public static int createTable(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        return createTable(connectionsource, databasetableconfig, false);
    }

    private static int createTable(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig, boolean flag)
        throws SQLException
    {
        com.j256.ormlite.dao.Dao dao = DaoManager.createDao(connectionsource, databasetableconfig);
        if (dao instanceof BaseDaoImpl)
        {
            return doCreateTable(connectionsource, ((BaseDaoImpl)dao).getTableInfo(), flag);
        } else
        {
            databasetableconfig.extractFieldTypes(connectionsource);
            return doCreateTable(connectionsource, new TableInfo(connectionsource.getDatabaseType(), null, databasetableconfig), flag);
        }
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

    public static int createTableIfNotExists(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        return createTable(connectionsource, databasetableconfig, true);
    }

    public static int createTableIfNotExists(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        return createTable(connectionsource, class1, true);
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
        int i;
        list = list.iterator();
        i = 0;
_L3:
        String s;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)list.next();
        databasetype = databaseconnection.compileStatement(s, com.j256.ormlite.stmt.StatementBuilder.StatementType.SELECT, noFieldTypes, -1);
        DatabaseResults databaseresults;
        boolean flag;
        databaseresults = databasetype.runQuery(null);
        flag = databaseresults.first();
        int j = 0;
_L1:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        j++;
        flag = databaseresults.next();
          goto _L1
        logger.info("executing create table after-query got {} results: {}", Integer.valueOf(j), s);
        if (databasetype != null)
        {
            databasetype.close();
        }
        i++;
        if (true) goto _L3; else goto _L2
        databasetype;
        databaseconnection = null;
_L7:
        throw SqlExceptionUtil.create((new StringBuilder()).append("executing create table after-query failed: ").append(s).toString(), databasetype);
        list;
        databasetype = databaseconnection;
        databaseconnection = list;
_L5:
        if (databasetype != null)
        {
            databasetype.close();
        }
        throw databaseconnection;
_L2:
        return i;
        databaseconnection;
        databasetype = null;
        continue; /* Loop/switch isn't completed */
        databaseconnection;
        if (true) goto _L5; else goto _L4
_L4:
        list;
        databaseconnection = databasetype;
        databasetype = list;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static int doDropTable(DatabaseType databasetype, ConnectionSource connectionsource, TableInfo tableinfo, boolean flag)
        throws SQLException
    {
        ArrayList arraylist;
        logger.info("dropping table '{}'", tableinfo.getTableName());
        arraylist = new ArrayList();
        addDropIndexStatements(databasetype, tableinfo, arraylist);
        addDropTableStatements(databasetype, tableinfo, arraylist);
        tableinfo = connectionsource.getReadWriteConnection();
        int i = doStatements(tableinfo, "drop", arraylist, flag, databasetype.isCreateTableReturnsNegative(), false);
        connectionsource.releaseConnection(tableinfo);
        return i;
        databasetype;
        connectionsource.releaseConnection(tableinfo);
        throw databasetype;
    }

    private static int doStatements(DatabaseConnection databaseconnection, String s, Collection collection, boolean flag, boolean flag1, boolean flag2)
        throws SQLException
    {
        Iterator iterator;
        int j;
        iterator = collection.iterator();
        j = 0;
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        String s1;
        s1 = (String)iterator.next();
        collection = null;
        obj = null;
        CompiledStatement compiledstatement = databaseconnection.compileStatement(s1, com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE, noFieldTypes, -1);
        obj = compiledstatement;
        collection = compiledstatement;
        int i = compiledstatement.runExecute();
        collection = compiledstatement;
        logger.info("executed {} table statement changed {} rows: {}", s, Integer.valueOf(i), s1);
        int k;
        k = i;
        if (compiledstatement != null)
        {
            compiledstatement.close();
            k = i;
        }
        break MISSING_BLOCK_LABEL_111;
        collection;
        i = 0;
        compiledstatement = ((CompiledStatement) (obj));
        obj = collection;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        collection = compiledstatement;
        logger.info("ignoring {} error '{}' for statement: {}", s, obj, s1);
        k = i;
        if (compiledstatement != null)
        {
            compiledstatement.close();
            k = i;
        }
          goto _L3
        collection = compiledstatement;
        throw SqlExceptionUtil.create((new StringBuilder()).append("SQL statement failed: ").append(s1).toString(), ((Throwable) (obj)));
        databaseconnection;
        if (collection != null)
        {
            collection.close();
        }
        throw databaseconnection;
_L3:
        if (k < 0)
        {
            if (!flag1)
            {
                throw new SQLException((new StringBuilder()).append("SQL statement ").append(s1).append(" updated ").append(k).append(" rows, we were expecting >= 0").toString());
            }
            continue; /* Loop/switch isn't completed */
        }
        if (k > 0 && flag2)
        {
            throw new SQLException((new StringBuilder()).append("SQL statement updated ").append(k).append(" rows, we were expecting == 0: ").append(s1).toString());
        }
        j++;
          goto _L4
_L2:
        return j;
        obj;
          goto _L5
    }

    public static int dropTable(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig, boolean flag)
        throws SQLException
    {
        DatabaseType databasetype = connectionsource.getDatabaseType();
        com.j256.ormlite.dao.Dao dao = DaoManager.createDao(connectionsource, databasetableconfig);
        if (dao instanceof BaseDaoImpl)
        {
            return doDropTable(databasetype, connectionsource, ((BaseDaoImpl)dao).getTableInfo(), flag);
        } else
        {
            databasetableconfig.extractFieldTypes(connectionsource);
            return doDropTable(databasetype, connectionsource, new TableInfo(databasetype, null, databasetableconfig), flag);
        }
    }

    public static int dropTable(ConnectionSource connectionsource, Class class1, boolean flag)
        throws SQLException
    {
        DatabaseType databasetype = connectionsource.getDatabaseType();
        com.j256.ormlite.dao.Dao dao = DaoManager.createDao(connectionsource, class1);
        if (dao instanceof BaseDaoImpl)
        {
            return doDropTable(databasetype, connectionsource, ((BaseDaoImpl)dao).getTableInfo(), flag);
        } else
        {
            return doDropTable(databasetype, connectionsource, new TableInfo(connectionsource, null, class1), flag);
        }
    }

    public static List getCreateTableStatements(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        com.j256.ormlite.dao.Dao dao = DaoManager.createDao(connectionsource, databasetableconfig);
        if (dao instanceof BaseDaoImpl)
        {
            return addCreateTableStatements(connectionsource, ((BaseDaoImpl)dao).getTableInfo(), false);
        } else
        {
            databasetableconfig.extractFieldTypes(connectionsource);
            return addCreateTableStatements(connectionsource, new TableInfo(connectionsource.getDatabaseType(), null, databasetableconfig), false);
        }
    }

    public static List getCreateTableStatements(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        com.j256.ormlite.dao.Dao dao = DaoManager.createDao(connectionsource, class1);
        if (dao instanceof BaseDaoImpl)
        {
            return addCreateTableStatements(connectionsource, ((BaseDaoImpl)dao).getTableInfo(), false);
        } else
        {
            return addCreateTableStatements(connectionsource, new TableInfo(connectionsource, null, class1), false);
        }
    }

}
