// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.db.DatabaseType;
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
//            Dao, BaseDaoImpl

public class DaoManager
{
    private static class ClassConnectionSource
    {

        Class clazz;
        ConnectionSource connectionSource;

        public boolean equals(Object obj)
        {
            if (obj != null && getClass() == obj.getClass())
            {
                if (clazz.equals(((ClassConnectionSource) (obj = (ClassConnectionSource)obj)).clazz) && connectionSource.equals(((ClassConnectionSource) (obj)).connectionSource))
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

        public ClassConnectionSource(ConnectionSource connectionsource, Class class1)
        {
            connectionSource = connectionsource;
            clazz = class1;
        }
    }

    private static class TableConfigConnectionSource
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


    private static Map classMap = null;
    private static Map configMap = null;
    private static Logger logger = LoggerFactory.getLogger(com/j256/ormlite/dao/DaoManager);
    private static Map tableConfigMap = null;

    public DaoManager()
    {
    }

    public static void addCachedDatabaseConfigs(Collection collection)
    {
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        if (configMap != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        hashmap = new HashMap();
_L1:
        DatabaseTableConfig databasetableconfig;
        for (collection = collection.iterator(); collection.hasNext(); logger.info("Loaded configuration for {}", databasetableconfig.getDataClass()))
        {
            databasetableconfig = (DatabaseTableConfig)collection.next();
            hashmap.put(databasetableconfig.getDataClass(), databasetableconfig);
        }

        break MISSING_BLOCK_LABEL_90;
        collection;
        throw collection;
        hashmap = new HashMap(configMap);
          goto _L1
        configMap = hashmap;
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
    }

    private static void addDaoToClassMap(ClassConnectionSource classconnectionsource, Dao dao)
    {
        if (classMap == null)
        {
            classMap = new HashMap();
        }
        classMap.put(classconnectionsource, dao);
    }

    private static void addDaoToTableMap(TableConfigConnectionSource tableconfigconnectionsource, Dao dao)
    {
        if (tableConfigMap == null)
        {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(tableconfigconnectionsource, dao);
    }

    public static Dao createDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
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
        connectionsource = doCreateDao(connectionsource, databasetableconfig);
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return connectionsource;
    }

    public static Dao createDao(ConnectionSource connectionsource, Class class1)
        throws SQLException
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
        Object obj = lookupDao(new ClassConnectionSource(connectionsource, class1));
        if (obj == null) goto _L2; else goto _L1
_L1:
        connectionsource = ((ConnectionSource) (obj));
_L3:
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
        return connectionsource;
_L2:
        obj = (Dao)createDaoFromConfig(connectionsource, class1);
label0:
        {
            if (obj == null)
            {
                break label0;
            }
            connectionsource = ((ConnectionSource) (obj));
        }
          goto _L3
        obj = (DatabaseTable)class1.getAnnotation(com/j256/ormlite/table/DatabaseTable);
        if (obj == null) goto _L5; else goto _L4
_L4:
        if (((DatabaseTable) (obj)).daoClass() != java/lang/Void && ((DatabaseTable) (obj)).daoClass() != com/j256/ormlite/dao/BaseDaoImpl) goto _L6; else goto _L5
_L5:
        obj = connectionsource.getDatabaseType().extractDatabaseTableConfig(connectionsource, class1);
        if (obj != null) goto _L8; else goto _L7
_L7:
        obj = BaseDaoImpl.createDao(connectionsource, class1);
_L9:
        logger.debug("created dao for class {} with reflection", class1);
        class1 = ((Class) (obj));
_L10:
        registerDao(connectionsource, class1);
        connectionsource = class1;
          goto _L3
_L8:
        obj = BaseDaoImpl.createDao(connectionsource, ((DatabaseTableConfig) (obj)));
          goto _L9
_L6:
        Object aobj[];
        Class class2;
        class2 = ((DatabaseTable) (obj)).daoClass();
        aobj = new Object[2];
        aobj[0] = connectionsource;
        aobj[1] = class1;
        Constructor constructor1 = findConstructor(class2, aobj);
        Constructor constructor;
        constructor = constructor1;
        if (constructor1 != null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        aobj = new Object[1];
        aobj[0] = connectionsource;
        constructor1 = findConstructor(class2, aobj);
        constructor = constructor1;
        if (constructor1 != null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        throw new SQLException((new StringBuilder()).append("Could not find public constructor with ConnectionSource and optional Class parameters ").append(class2).append(".  Missing static on class?").toString());
        aobj = (Dao)constructor.newInstance(aobj);
        logger.debug("created dao for class {} from constructor", class1);
        class1 = ((Class) (aobj));
          goto _L10
        connectionsource;
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not call the constructor in class ").append(class2).toString(), connectionsource);
          goto _L3
    }

    private static Object createDaoFromConfig(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        if (configMap != null)
        {
            if ((class1 = (DatabaseTableConfig)configMap.get(class1)) != null)
            {
                return doCreateDao(connectionsource, class1);
            }
        }
        return null;
    }

    private static Dao doCreateDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        TableConfigConnectionSource tableconfigconnectionsource = new TableConfigConnectionSource(connectionsource, databasetableconfig);
        Object obj = lookupDao(tableconfigconnectionsource);
        if (obj != null)
        {
            return ((Dao) (obj));
        }
        obj = databasetableconfig.getDataClass();
        ClassConnectionSource classconnectionsource = new ClassConnectionSource(connectionsource, ((Class) (obj)));
        Object obj1 = lookupDao(classconnectionsource);
        if (obj1 != null)
        {
            addDaoToTableMap(tableconfigconnectionsource, ((Dao) (obj1)));
            return ((Dao) (obj1));
        }
        obj1 = (DatabaseTable)databasetableconfig.getDataClass().getAnnotation(com/j256/ormlite/table/DatabaseTable);
        if (obj1 == null || ((DatabaseTable) (obj1)).daoClass() == java/lang/Void || ((DatabaseTable) (obj1)).daoClass() == com/j256/ormlite/dao/BaseDaoImpl)
        {
            connectionsource = BaseDaoImpl.createDao(connectionsource, databasetableconfig);
        } else
        {
            obj1 = ((DatabaseTable) (obj1)).daoClass();
            Object aobj[] = new Object[2];
            aobj[0] = connectionsource;
            aobj[1] = databasetableconfig;
            connectionsource = findConstructor(((Class) (obj1)), aobj);
            if (connectionsource == null)
            {
                throw new SQLException((new StringBuilder()).append("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class ").append(obj1).toString());
            }
            try
            {
                connectionsource = (Dao)connectionsource.newInstance(aobj);
            }
            // Misplaced declaration of an exception variable
            catch (ConnectionSource connectionsource)
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("Could not call the constructor in class ").append(obj1).toString(), connectionsource);
            }
        }
        addDaoToTableMap(tableconfigconnectionsource, connectionsource);
        logger.debug("created dao for class {} from table config", obj);
        if (lookupDao(classconnectionsource) == null)
        {
            addDaoToClassMap(classconnectionsource, connectionsource);
        }
        return connectionsource;
    }

    private static Constructor findConstructor(Class class1, Object aobj[])
    {
        class1 = class1.getConstructors();
        int k = class1.length;
label0:
        for (int i = 0; i < k; i++)
        {
            Constructor constructor = class1[i];
            Class aclass[] = constructor.getParameterTypes();
            if (aclass.length != aobj.length)
            {
                continue;
            }
            boolean flag1 = true;
            int j = 0;
            do
            {
label1:
                {
                    boolean flag = flag1;
                    if (j < aclass.length)
                    {
                        if (aclass[j].isAssignableFrom(aobj[j].getClass()))
                        {
                            break label1;
                        }
                        flag = false;
                    }
                    if (flag)
                    {
                        return constructor;
                    }
                    continue label0;
                }
                j++;
            } while (true);
        }

        return null;
    }

    private static Dao lookupDao(ClassConnectionSource classconnectionsource)
    {
        if (classMap == null)
        {
            classMap = new HashMap();
        }
        Dao dao = (Dao)classMap.get(classconnectionsource);
        classconnectionsource = dao;
        if (dao == null)
        {
            classconnectionsource = null;
        }
        return classconnectionsource;
    }

    private static Dao lookupDao(TableConfigConnectionSource tableconfigconnectionsource)
    {
        if (tableConfigMap == null)
        {
            tableConfigMap = new HashMap();
        }
        Dao dao = (Dao)tableConfigMap.get(tableconfigconnectionsource);
        tableconfigconnectionsource = dao;
        if (dao == null)
        {
            tableconfigconnectionsource = null;
        }
        return tableconfigconnectionsource;
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
        addDaoToClassMap(new ClassConnectionSource(connectionsource, dao.getDataClass()), dao);
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
    }

    private static void removeDaoToClassMap(ClassConnectionSource classconnectionsource, Dao dao)
    {
        if (classMap != null)
        {
            classMap.remove(classconnectionsource);
        }
    }

    public static void unregisterDao(ConnectionSource connectionsource, Dao dao)
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
        removeDaoToClassMap(new ClassConnectionSource(connectionsource, dao.getDataClass()), dao);
        com/j256/ormlite/dao/DaoManager;
        JVM INSTR monitorexit ;
    }

}
