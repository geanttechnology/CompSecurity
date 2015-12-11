// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.dao:
//            BaseDaoImpl, Dao

public class DaoManager
{

    private static Map classMap = null;
    private static Map configMap = null;
    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/dao/DaoManager);
    private static Map tableMap = null;

    public DaoManager()
    {
    }

    public static void addCachedDatabaseConfigs(Collection collection)
    {
        HashMap hashmap;
        DatabaseTableConfig databasetableconfig;
        if (configMap == null)
        {
            hashmap = new HashMap();
        } else
        {
            hashmap = new HashMap(configMap);
        }
        for (collection = collection.iterator(); collection.hasNext(); logger.info("Loaded configuration for {}", new Object[] {
    databasetableconfig.getDataClass()
}))
        {
            databasetableconfig = (DatabaseTableConfig)collection.next();
            hashmap.put(databasetableconfig.getDataClass(), databasetableconfig);
        }

        configMap = hashmap;
    }

    public static void clearCache()
    {
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        if (classMap != null)
        {
            classMap.clear();
            classMap = null;
        }
        if (tableMap != null)
        {
            tableMap.clear();
            tableMap = null;
        }
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static Dao createDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        if (connectionsource != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("connectionSource argument cannot be null");
        connectionsource;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        throw connectionsource;
        Object obj;
        TableConfigConnectionSource tableconfigconnectionsource;
        tableconfigconnectionsource = new TableConfigConnectionSource(connectionsource, databasetableconfig);
        obj = lookupDao(tableconfigconnectionsource);
        if (obj == null) goto _L2; else goto _L1
_L1:
        connectionsource = ((ConnectionSource) (obj));
_L6:
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return connectionsource;
_L2:
        obj = (DatabaseTable)databasetableconfig.getDataClass().getAnnotation(com/j256/ormlite/table/DatabaseTable);
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((DatabaseTable) (obj)).daoClass() != java/lang/Void && ((DatabaseTable) (obj)).daoClass() != com/j256/ormlite/dao/BaseDaoImpl) goto _L5; else goto _L4
_L4:
        connectionsource = BaseDaoImpl.createDao(connectionsource, databasetableconfig);
_L7:
        tableMap.put(tableconfigconnectionsource, connectionsource);
          goto _L6
_L5:
        obj = ((DatabaseTable) (obj)).daoClass();
        Constructor constructor = ((Class) (obj)).getConstructor(new Class[] {
            com/j256/ormlite/support/ConnectionSource, com/j256/ormlite/table/DatabaseTableConfig
        });
        connectionsource = (Dao)constructor.newInstance(new Object[] {
            connectionsource, databasetableconfig
        });
          goto _L7
        connectionsource;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class ").append(obj).toString(), connectionsource);
        connectionsource;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not call the constructor in class ").append(obj).toString(), connectionsource);
    }

    public static Dao createDao(ConnectionSource connectionsource, Class class1)
    {
        Constructor constructor = null;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        if (connectionsource != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        throw new IllegalArgumentException("connectionSource argument cannot be null");
        connectionsource;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        throw connectionsource;
        Object obj;
        ClazzConnectionSource clazzconnectionsource;
        clazzconnectionsource = new ClazzConnectionSource(connectionsource, class1);
        obj = lookupDao(clazzconnectionsource);
        if (obj == null) goto _L2; else goto _L1
_L1:
        connectionsource = ((ConnectionSource) (obj));
_L3:
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return connectionsource;
_L2:
        if (configMap == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        obj = (DatabaseTableConfig)configMap.get(class1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        connectionsource = createDao(connectionsource, ((DatabaseTableConfig) (obj)));
        logger.debug("created dao for class {} from loaded config", new Object[] {
            class1
        });
        classMap.put(clazzconnectionsource, connectionsource);
          goto _L3
        obj = (DatabaseTable)class1.getAnnotation(com/j256/ormlite/table/DatabaseTable);
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (((DatabaseTable) (obj)).daoClass() != java/lang/Void && ((DatabaseTable) (obj)).daoClass() != com/j256/ormlite/dao/BaseDaoImpl) goto _L6; else goto _L5
_L5:
        connectionsource = BaseDaoImpl.createDao(connectionsource, class1);
        logger.debug("created dao for class {} with reflection", new Object[] {
            class1
        });
_L18:
        classMap.put(clazzconnectionsource, connectionsource);
          goto _L3
_L6:
        Class class2;
        Constructor aconstructor[];
        int j;
        class2 = ((DatabaseTable) (obj)).daoClass();
        aconstructor = class2.getConstructors();
        j = aconstructor.length;
        int i = 0;
_L16:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        obj = aconstructor[i];
        Class aclass[] = ((Constructor) (obj)).getParameterTypes();
        if (aclass.length != 2 || aclass[0] != com/j256/ormlite/support/ConnectionSource || aclass[1] != java/lang/Class) goto _L8; else goto _L7
_L7:
        aclass = ((Class []) (new Object[2]));
        Object aobj[];
        aclass[0] = connectionsource;
        aclass[1] = class1;
        constructor = ((Constructor) (obj));
        aobj = aclass;
_L20:
        if (constructor != null) goto _L10; else goto _L9
_L9:
        j = aconstructor.length;
        i = 0;
_L17:
        if (i >= j) goto _L10; else goto _L11
_L11:
        Constructor constructor1 = aconstructor[i];
        Class aclass1[] = constructor1.getParameterTypes();
        if (aclass1.length != 1 || aclass1[0] != com/j256/ormlite/support/ConnectionSource) goto _L13; else goto _L12
_L12:
        aobj = new Object[1];
        aobj[0] = connectionsource;
        connectionsource = constructor1;
_L19:
        if (connectionsource != null) goto _L15; else goto _L14
_L14:
        throw new SQLException((new StringBuilder()).append("Could not find public constructor with ConnectionSource parameter in class ").append(class2).toString());
_L8:
        i++;
          goto _L16
_L13:
        i++;
          goto _L17
_L15:
        connectionsource = (Dao)connectionsource.newInstance(aobj);
        logger.debug("created dao for class {} from constructor", new Object[] {
            class1
        });
          goto _L18
        connectionsource;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not call the constructor in class ").append(class2).toString(), connectionsource);
_L10:
        connectionsource = constructor;
          goto _L19
        aobj = null;
          goto _L20
    }

    private static Dao lookupDao(ClazzConnectionSource clazzconnectionsource)
    {
        if (classMap == null)
        {
            classMap = new HashMap();
        }
        Dao dao = (Dao)classMap.get(clazzconnectionsource);
        clazzconnectionsource = dao;
        if (dao == null)
        {
            clazzconnectionsource = null;
        }
        return clazzconnectionsource;
    }

    private static Dao lookupDao(TableConfigConnectionSource tableconfigconnectionsource)
    {
        if (tableMap == null)
        {
            tableMap = new HashMap();
        }
        Dao dao = (Dao)tableMap.get(tableconfigconnectionsource);
        tableconfigconnectionsource = dao;
        if (dao == null)
        {
            tableconfigconnectionsource = null;
        }
        return tableconfigconnectionsource;
    }

    public static Dao lookupDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        if (connectionsource != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("connectionSource argument cannot be null");
        connectionsource;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        throw connectionsource;
        connectionsource = lookupDao(new TableConfigConnectionSource(connectionsource, databasetableconfig));
        databasetableconfig = connectionsource;
        if (connectionsource == null)
        {
            databasetableconfig = null;
        }
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return databasetableconfig;
    }

    public static Dao lookupDao(ConnectionSource connectionsource, Class class1)
    {
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        if (connectionsource != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("connectionSource argument cannot be null");
        connectionsource;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        throw connectionsource;
        connectionsource = lookupDao(new ClazzConnectionSource(connectionsource, class1));
        class1 = connectionsource;
        if (connectionsource == null)
        {
            class1 = null;
        }
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return class1;
    }

    public static void registerDao(ConnectionSource connectionsource, Dao dao)
    {
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        if (connectionsource != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("connectionSource argument cannot be null");
        connectionsource;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        throw connectionsource;
        DatabaseTableConfig databasetableconfig;
        if (!(dao instanceof BaseDaoImpl))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        databasetableconfig = ((BaseDaoImpl)dao).getTableConfig();
        if (databasetableconfig == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        tableMap.put(new TableConfigConnectionSource(connectionsource, databasetableconfig), dao);
_L1:
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return;
        classMap.put(new ClazzConnectionSource(connectionsource, dao.getDataClass()), dao);
          goto _L1
    }


    private class TableConfigConnectionSource
    {

        ConnectionSource connectionSource;
        DatabaseTableConfig tableConfig;

        public boolean equals(Object obj)
        {
            if (obj != null && getClass() == obj.getClass())
            {
                if (tableConfig.equals(((TableConfigConnectionSource) (obj = (TableConfigConnectionSource)obj)).tableConfig) && connectionSource.equals(((TableConfigConnectionSource) (obj)).connectionSource))
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return (tableConfig.hashCode() + 31) * 31 + connectionSource.hashCode();
        }

        public TableConfigConnectionSource(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        {
            connectionSource = connectionsource;
            tableConfig = databasetableconfig;
        }
    }


    private class ClazzConnectionSource
    {

        Class clazz;
        ConnectionSource connectionSource;

        public boolean equals(Object obj)
        {
            if (obj != null && getClass() == obj.getClass())
            {
                if (clazz.equals(((ClazzConnectionSource) (obj = (ClazzConnectionSource)obj)).clazz) && connectionSource.equals(((ClazzConnectionSource) (obj)).connectionSource))
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return (clazz.hashCode() + 31) * 31 + connectionSource.hashCode();
        }

        public ClazzConnectionSource(ConnectionSource connectionsource, Class class1)
        {
            connectionSource = connectionsource;
            clazz = class1;
        }
    }

}
