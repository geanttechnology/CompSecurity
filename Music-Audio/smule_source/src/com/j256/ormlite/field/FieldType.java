// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.dao.LazyForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.mapped.MappedQueryForId;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableInfo;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.field:
//            DatabaseFieldConfig, DataPersisterManager, DataPersister, DataType, 
//            FieldConverter, SqlType

public class FieldType
{

    private static boolean DEFAULT_VALUE_BOOLEAN = false;
    private static byte DEFAULT_VALUE_BYTE = 0;
    private static char DEFAULT_VALUE_CHAR = 0;
    private static double DEFAULT_VALUE_DOUBLE = 0D;
    private static float DEFAULT_VALUE_FLOAT = 0F;
    private static int DEFAULT_VALUE_INT = 0;
    private static long DEFAULT_VALUE_LONG = 0L;
    private static short DEFAULT_VALUE_SHORT = 0;
    public static final String FOREIGN_ID_FIELD_SUFFIX = "_id";
    private static final ThreadLocal threadLevelCounters = new ThreadLocal();
    private final ConnectionSource connectionSource;
    private DataPersister dataPersister;
    private Object dataTypeConfigObj;
    private final String dbColumnName;
    private Object defaultValue;
    private final Field field;
    private final DatabaseFieldConfig fieldConfig;
    private FieldConverter fieldConverter;
    private final Method fieldGetMethod;
    private final Method fieldSetMethod;
    private Constructor foreignConstructor;
    private Dao foreignDao;
    private FieldType foreignFieldType;
    private FieldType foreignIdField;
    private final String generatedIdSequence;
    private final boolean isGeneratedId;
    private final boolean isId;
    private MappedQueryForId mappedQueryForId;

    public FieldType(ConnectionSource connectionsource, String s, Field field1, DatabaseFieldConfig databasefieldconfig, Class class1)
    {
        DatabaseType databasetype;
        Object obj;
        connectionSource = connectionsource;
        databasetype = connectionsource.getDatabaseType();
        field = field1;
        obj = field1.getType();
        if (databasefieldconfig.getDataPersister() == null)
        {
            class1 = databasefieldconfig.getPersisterClass();
            if (class1 == null || class1 == com/j256/ormlite/field/types/VoidType)
            {
                connectionsource = DataPersisterManager.lookupForField(field1);
            } else
            {
                try
                {
                    connectionsource = class1.getDeclaredMethod("getSingleton", new Class[0]);
                }
                // Misplaced declaration of an exception variable
                catch (ConnectionSource connectionsource)
                {
                    throw SqlExceptionUtil.create((new StringBuilder()).append("Could not find getSingleton static method on class ").append(class1).toString(), connectionsource);
                }
                try
                {
                    connectionsource = ((ConnectionSource) (connectionsource.invoke(null, new Object[0])));
                }
                // Misplaced declaration of an exception variable
                catch (ConnectionSource connectionsource)
                {
                    throw SqlExceptionUtil.create((new StringBuilder()).append("Could not run getSingleton method on class ").append(class1).toString(), connectionsource.getTargetException());
                }
                // Misplaced declaration of an exception variable
                catch (ConnectionSource connectionsource)
                {
                    throw SqlExceptionUtil.create((new StringBuilder()).append("Could not run getSingleton method on class ").append(class1).toString(), connectionsource);
                }
                if (connectionsource == null)
                {
                    throw new SQLException((new StringBuilder()).append("Static getSingleton method should not return null on class ").append(class1).toString());
                }
                try
                {
                    connectionsource = (DataPersister)connectionsource;
                }
                // Misplaced declaration of an exception variable
                catch (ConnectionSource connectionsource)
                {
                    throw SqlExceptionUtil.create((new StringBuilder()).append("Could not cast result of static getSingleton method to DataPersister from class ").append(class1).toString(), connectionsource);
                }
            }
            class1 = connectionsource;
        } else
        {
            class1 = databasefieldconfig.getDataPersister();
            if (!class1.isValidForField(field1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Field class ").append(obj).append(" for field ").append(this).append(" is not valid for data persister ").append(class1).toString());
            }
        }
        connectionsource = field1.getName();
        if (!databasefieldconfig.isForeign() && !databasefieldconfig.isForeignAutoRefresh()) goto _L2; else goto _L1
_L1:
        if (class1 != null && class1.isPrimitive())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Field ").append(this).append(" is a primitive class ").append(obj).append(" but marked as foreign").toString());
        }
        connectionsource = (new StringBuilder()).append(connectionsource).append("_id").toString();
_L6:
        if (databasefieldconfig.getColumnName() == null)
        {
            dbColumnName = connectionsource;
        } else
        {
            dbColumnName = databasefieldconfig.getColumnName();
        }
        fieldConfig = databasefieldconfig;
        if (!databasefieldconfig.isId()) goto _L4; else goto _L3
_L2:
        if (!databasefieldconfig.isForeignCollection())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj != java/util/Collection && !com/j256/ormlite/dao/ForeignCollection.isAssignableFrom(((Class) (obj))))
        {
            throw new SQLException((new StringBuilder()).append("Field class for '").append(field1.getName()).append("' must be of class ").append(com/j256/ormlite/dao/ForeignCollection.getSimpleName()).append(" or Collection.").toString());
        }
        obj = field1.getGenericType();
        if (!(obj instanceof ParameterizedType))
        {
            throw new SQLException((new StringBuilder()).append("Field class for '").append(field1.getName()).append("' must be a parameterized Collection.").toString());
        }
        if (((ParameterizedType)obj).getActualTypeArguments().length != 0) goto _L6; else goto _L5
_L5:
        throw new SQLException((new StringBuilder()).append("Field class for '").append(field1.getName()).append("' must be a parameterized Collection with at least 1 type.").toString());
        if (class1 != null || databasefieldconfig.isForeignCollection()) goto _L6; else goto _L7
_L7:
        if ([B.isAssignableFrom(((Class) (obj))))
        {
            throw new SQLException((new StringBuilder()).append("ORMLite can't store unknown class ").append(obj).append(" for field '").append(field1.getName()).append("'. byte[] fields must specify dataType=DataType.BYTE_ARRAY or SERIALIZABLE").toString());
        }
        if (java/io/Serializable.isAssignableFrom(((Class) (obj))))
        {
            throw new SQLException((new StringBuilder()).append("ORMLite can't store unknown class ").append(obj).append(" for field '").append(field1.getName()).append("'. Serializable fields must specify dataType=DataType.SERIALIZABLE").toString());
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("ORMLite does not know how to store field class ").append(obj).append(" for field ").append(this).toString());
        }
_L3:
        if (databasefieldconfig.isGeneratedId() || databasefieldconfig.getGeneratedIdSequence() != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Must specify one of id, generatedId, and generatedIdSequence with ").append(field1.getName()).toString());
        }
        isId = true;
        isGeneratedId = false;
        generatedIdSequence = null;
_L9:
        if (isId && (databasefieldconfig.isForeign() || databasefieldconfig.isForeignAutoRefresh()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Id field ").append(field1.getName()).append(" cannot also be a foreign object").toString());
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (databasefieldconfig.isGeneratedId())
        {
            if (databasefieldconfig.getGeneratedIdSequence() != null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Must specify one of id, generatedId, and generatedIdSequence with ").append(field1.getName()).toString());
            }
            isId = true;
            isGeneratedId = true;
            if (databasetype.isIdSequenceNeeded())
            {
                generatedIdSequence = databasetype.generateIdSequenceName(s, this);
            } else
            {
                generatedIdSequence = null;
            }
        } else
        if (databasefieldconfig.getGeneratedIdSequence() != null)
        {
            isId = true;
            isGeneratedId = true;
            s = databasefieldconfig.getGeneratedIdSequence();
            connectionsource = s;
            if (databasetype.isEntityNamesMustBeUpCase())
            {
                connectionsource = s.toUpperCase();
            }
            generatedIdSequence = connectionsource;
        } else
        {
            isId = false;
            isGeneratedId = false;
            generatedIdSequence = null;
        }
        if (true) goto _L9; else goto _L8
_L8:
        if (databasefieldconfig.isUseGetSet())
        {
            fieldGetMethod = DatabaseFieldConfig.findGetMethod(field1, true);
            fieldSetMethod = DatabaseFieldConfig.findSetMethod(field1, true);
        } else
        {
            if (!field1.isAccessible())
            {
                try
                {
                    field.setAccessible(true);
                }
                // Misplaced declaration of an exception variable
                catch (ConnectionSource connectionsource)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Could not open access to field ").append(field1.getName()).append(".  You may have to set useGetSet=true to fix.").toString());
                }
            }
            fieldGetMethod = null;
            fieldSetMethod = null;
        }
        if (databasefieldconfig.isAllowGeneratedIdInsert() && !databasefieldconfig.isGeneratedId())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Field ").append(field1.getName()).append(" must be a generated-id if allowGeneratedIdInsert = true").toString());
        }
        if (databasefieldconfig.isForeignAutoRefresh() && !databasefieldconfig.isForeign())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Field ").append(field1.getName()).append(" must have foreign = true if foreignAutoRefresh = true").toString());
        }
        if (databasefieldconfig.isForeignAutoCreate() && !databasefieldconfig.isForeign())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Field ").append(field1.getName()).append(" must have foreign = true if foreignAutoCreate = true").toString());
        }
        if (databasefieldconfig.isVersion() && (class1 == null || !class1.isValidForVersion()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Field ").append(field1.getName()).append(" is not a valid type to be a version field").toString());
        } else
        {
            assignDataType(databasetype, class1);
            return;
        }
    }

    private void assignDataType(DatabaseType databasetype, DataPersister datapersister)
    {
        dataPersister = datapersister;
        if (datapersister == null)
        {
            return;
        }
        fieldConverter = databasetype.getFieldConverter(datapersister);
        if (isGeneratedId && !datapersister.isValidGeneratedType())
        {
            databasetype = new StringBuilder();
            databasetype.append("Generated-id field '").append(field.getName());
            databasetype.append("' in ").append(field.getDeclaringClass().getSimpleName());
            databasetype.append(" can't be type ").append(dataPersister.getSqlType());
            databasetype.append(".  Must be one of: ");
            datapersister = DataType.values();
            int j = datapersister.length;
            for (int i = 0; i < j; i++)
            {
                DataType datatype = datapersister[i];
                DataPersister datapersister1 = datatype.getDataPersister();
                if (datapersister1 != null && datapersister1.isValidGeneratedType())
                {
                    databasetype.append(datatype).append(' ');
                }
            }

            throw new IllegalArgumentException(databasetype.toString());
        }
        if (fieldConfig.isThrowIfNull() && !datapersister.isPrimitive())
        {
            throw new SQLException((new StringBuilder()).append("Field ").append(field.getName()).append(" must be a primitive if set with throwIfNull").toString());
        }
        if (isId && !datapersister.isAppropriateId())
        {
            throw new SQLException((new StringBuilder()).append("Field '").append(field.getName()).append("' is of data type ").append(datapersister).append(" which cannot be the ID field").toString());
        }
        dataTypeConfigObj = datapersister.makeConfigObject(this);
        databasetype = fieldConfig.getDefaultValue();
        if (databasetype == null || databasetype.equals(""))
        {
            defaultValue = null;
            return;
        }
        if (isGeneratedId)
        {
            throw new SQLException((new StringBuilder()).append("Field '").append(field.getName()).append("' cannot be a generatedId and have a default value '").append(databasetype).append("'").toString());
        } else
        {
            defaultValue = fieldConverter.parseDefaultString(this, databasetype);
            return;
        }
    }

    public static FieldType createFieldType(ConnectionSource connectionsource, String s, Field field1, Class class1)
    {
        DatabaseFieldConfig databasefieldconfig = DatabaseFieldConfig.fromField(connectionsource.getDatabaseType(), s, field1);
        if (databasefieldconfig == null)
        {
            return null;
        } else
        {
            return new FieldType(connectionsource, s, field1, databasefieldconfig, class1);
        }
    }

    private LevelCounters getLevelCounters()
    {
        LevelCounters levelcounters1 = (LevelCounters)threadLevelCounters.get();
        LevelCounters levelcounters = levelcounters1;
        if (levelcounters1 == null)
        {
            levelcounters = new LevelCounters();
            threadLevelCounters.set(levelcounters);
        }
        return levelcounters;
    }

    private boolean isFieldValueDefault(Object obj)
    {
        if (obj == null)
        {
            return true;
        } else
        {
            return obj.equals(getJavaDefaultValueDefault());
        }
    }

    public void assignField(Object obj, Object obj1, boolean flag, ObjectCache objectcache)
    {
        Object obj2 = obj1;
        if (foreignIdField == null) goto _L2; else goto _L1
_L1:
        obj2 = obj1;
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        obj2 = extractJavaFieldValue(obj);
        if (obj2 != null && obj2.equals(obj1))
        {
            return;
        }
        obj2 = obj1;
        if (flag) goto _L2; else goto _L4
_L4:
        obj2 = getLevelCounters();
        if (mappedQueryForId != null && ((LevelCounters) (obj2)).autoRefreshlevel < fieldConfig.getMaxForeignAutoRefreshLevel()) goto _L6; else goto _L5
_L5:
        obj2 = TableInfo.createObject(foreignConstructor, foreignDao);
        foreignIdField.assignField(obj2, obj1, false, objectcache);
        obj1 = obj2;
_L8:
        obj2 = obj1;
_L2:
        com.j256.ormlite.support.DatabaseConnection databaseconnection;
        if (fieldSetMethod == null)
        {
            try
            {
                field.set(obj, obj2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("Could not assign object '").append(obj2).append("' to field ").append(this).toString(), ((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("Could not assign object '").append(obj2).append("' to field ").append(this).toString(), ((Throwable) (obj)));
            }
        }
        break; /* Loop/switch isn't completed */
_L6:
        obj2.autoRefreshlevel = ((LevelCounters) (obj2)).autoRefreshlevel + 1;
        databaseconnection = connectionSource.getReadOnlyConnection();
        obj1 = mappedQueryForId.execute(databaseconnection, obj1, objectcache);
        connectionSource.releaseConnection(databaseconnection);
        obj2.autoRefreshlevel = ((LevelCounters) (obj2)).autoRefreshlevel - 1;
        if (true) goto _L8; else goto _L7
        obj;
        connectionSource.releaseConnection(databaseconnection);
        throw obj;
        obj;
        obj2.autoRefreshlevel = ((LevelCounters) (obj2)).autoRefreshlevel - 1;
        throw obj;
_L7:
        try
        {
            fieldSetMethod.invoke(obj, new Object[] {
                obj2
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not call ").append(fieldSetMethod).append(" on object with '").append(obj2).append("' for ").append(this).toString(), ((Throwable) (obj)));
        }
    }

    public Object assignIdValue(Object obj, Number number, ObjectCache objectcache)
    {
        number = ((Number) (dataPersister.convertIdNumber(number)));
        if (number == null)
        {
            throw new SQLException((new StringBuilder()).append("Invalid class ").append(dataPersister).append(" for sequence-id ").append(this).toString());
        } else
        {
            assignField(obj, number, false, objectcache);
            return number;
        }
    }

    public BaseForeignCollection buildForeignCollection(Object obj, Object obj1, boolean flag)
    {
        LevelCounters levelcounters;
        Dao dao;
        if (foreignFieldType == null)
        {
            return null;
        }
        dao = foreignDao;
        if (!fieldConfig.isForeignCollectionEager() && !flag)
        {
            return new LazyForeignCollection(dao, foreignFieldType.dbColumnName, obj1, fieldConfig.getForeignCollectionOrderColumn(), obj);
        }
        levelcounters = getLevelCounters();
        if (levelcounters.foreignCollectionLevel >= fieldConfig.getMaxEagerForeignCollectionLevel())
        {
            return new LazyForeignCollection(dao, foreignFieldType.dbColumnName, obj1, fieldConfig.getForeignCollectionOrderColumn(), obj);
        }
        levelcounters.foreignCollectionLevel = levelcounters.foreignCollectionLevel + 1;
        obj = new EagerForeignCollection(dao, obj, foreignFieldType, obj1, fieldConfig.getForeignCollectionOrderColumn());
        levelcounters.foreignCollectionLevel = levelcounters.foreignCollectionLevel - 1;
        return ((BaseForeignCollection) (obj));
        obj;
        levelcounters.foreignCollectionLevel = levelcounters.foreignCollectionLevel - 1;
        throw obj;
    }

    public void configDaoInformation(ConnectionSource connectionsource, Class class1)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        int i;
        i = 0;
        obj2 = null;
        obj3 = field.getType();
        DatabaseType databasetype = connectionsource.getDatabaseType();
        if (fieldConfig.isForeignAutoRefresh())
        {
            class1 = fieldConfig.getForeignTableConfig();
            if (class1 == null)
            {
                connectionsource = (BaseDaoImpl)DaoManager.createDao(connectionsource, ((Class) (obj3)));
                class1 = ((BaseDaoImpl)connectionsource).getTableInfo();
            } else
            {
                class1.extractFieldTypes(connectionsource);
                connectionsource = (BaseDaoImpl)DaoManager.createDao(connectionsource, class1);
                class1 = ((BaseDaoImpl)connectionsource).getTableInfo();
            }
            obj1 = class1.getIdField();
            if (obj1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Foreign field ").append(obj3).append(" does not have id field").toString());
            }
            obj3 = MappedQueryForId.build(databasetype, class1);
            class1 = class1.getConstructor();
            obj = connectionsource;
            connectionsource = ((ConnectionSource) (obj3));
        } else
        {
label0:
            {
                if (!fieldConfig.isForeign())
                {
                    break label0;
                }
                if (dataPersister != null && dataPersister.isPrimitive())
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Field ").append(this).append(" is a primitive class ").append(obj3).append(" but marked as foreign").toString());
                }
                class1 = fieldConfig.getForeignTableConfig();
                if (class1 != null)
                {
                    class1.extractFieldTypes(connectionsource);
                    connectionsource = (BaseDaoImpl)DaoManager.createDao(connectionsource, class1);
                    class1 = ((BaseDaoImpl)connectionsource).getTableInfo();
                    obj = class1.getIdField();
                    class1 = class1.getConstructor();
                } else
                if (com/j256/ormlite/misc/BaseDaoEnabled.isAssignableFrom(((Class) (obj3))) || fieldConfig.isForeignAutoCreate())
                {
                    connectionsource = (BaseDaoImpl)DaoManager.createDao(connectionsource, ((Class) (obj3)));
                    class1 = ((BaseDaoImpl)connectionsource).getTableInfo();
                    obj = class1.getIdField();
                    class1 = class1.getConstructor();
                } else
                {
                    obj = DatabaseTableConfig.extractIdFieldType(connectionsource, ((Class) (obj3)), DatabaseTableConfig.extractTableName(((Class) (obj3))));
                    class1 = DatabaseTableConfig.findNoArgConstructor(((Class) (obj3)));
                    connectionsource = null;
                }
                if (obj == null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Foreign field ").append(obj3).append(" does not have id field").toString());
                }
                obj1 = obj;
                obj = connectionsource;
                connectionsource = null;
            }
        }
_L6:
        mappedQueryForId = connectionsource;
        foreignConstructor = class1;
        foreignFieldType = ((FieldType) (obj2));
        foreignDao = ((Dao) (obj));
        foreignIdField = ((FieldType) (obj1));
        if (obj1 != null)
        {
            assignDataType(databasetype, ((FieldType) (obj1)).getDataPersister());
        }
        return;
        if (!fieldConfig.isForeignCollection()) goto _L2; else goto _L1
_L1:
        if (obj3 != java/util/Collection && !com/j256/ormlite/dao/ForeignCollection.isAssignableFrom(((Class) (obj3))))
        {
            throw new SQLException((new StringBuilder()).append("Field class for '").append(field.getName()).append("' must be of class ").append(com/j256/ormlite/dao/ForeignCollection.getSimpleName()).append(" or Collection.").toString());
        }
        obj = field.getGenericType();
        if (!(obj instanceof ParameterizedType))
        {
            throw new SQLException((new StringBuilder()).append("Field class for '").append(field.getName()).append("' must be a parameterized Collection.").toString());
        }
        obj = ((ParameterizedType)obj).getActualTypeArguments();
        if (obj.length == 0)
        {
            throw new SQLException((new StringBuilder()).append("Field class for '").append(field.getName()).append("' must be a parameterized Collection with at least 1 type.").toString());
        }
        obj1 = (Class)obj[0];
        obj = fieldConfig.getForeignTableConfig();
        int j;
        if (obj == null)
        {
            obj = DaoManager.createDao(connectionsource, ((Class) (obj1)));
        } else
        {
            obj = DaoManager.createDao(connectionsource, ((DatabaseTableConfig) (obj)));
        }
        obj2 = ((BaseDaoImpl)obj).getTableInfo().getFieldTypes();
        j = obj2.length;
_L5:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_873;
        }
        connectionsource = obj2[i];
        if (connectionsource.getFieldType() != class1) goto _L4; else goto _L3
_L4:
        i++;
          goto _L5
_L3:
        if (connectionsource == null)
        {
            throw new SQLException((new StringBuilder()).append("Foreign collection object ").append(obj1).append(" for field '").append(field.getName()).append("' does not contain a foreign field of class ").append(class1).toString());
        }
        if (!((FieldType) (connectionsource)).fieldConfig.isForeign() && !((FieldType) (connectionsource)).fieldConfig.isForeignAutoRefresh())
        {
            throw new SQLException((new StringBuilder()).append("Foreign collection object ").append(obj1).append(" for field '").append(field.getName()).append("' contains a field of class ").append(class1).append(" but it's not foreign").toString());
        }
        class1 = null;
        obj1 = null;
        obj2 = connectionsource;
        Object obj4 = null;
        connectionsource = class1;
        class1 = obj4;
          goto _L6
_L2:
        connectionsource = null;
        obj = null;
        class1 = null;
        obj1 = null;
          goto _L6
        connectionsource = null;
          goto _L3
    }

    public Object convertJavaFieldToSqlArgValue(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return fieldConverter.javaToSqlArg(this, obj);
        }
    }

    public int createWithForeignDao(Object obj)
    {
        return foreignDao.create(obj);
    }

    public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != getClass())
        {
            return false;
        } else
        {
            obj = (FieldType)obj;
            return field.equals(((FieldType) (obj)).field);
        }
    }

    public Object extractJavaFieldToSqlArgValue(Object obj)
    {
        return convertJavaFieldToSqlArgValue(extractJavaFieldValue(obj));
    }

    public Object extractJavaFieldValue(Object obj)
    {
        Object obj1 = extractRawJavaFieldValue(obj);
        obj = obj1;
        if (foreignIdField != null)
        {
            obj = obj1;
            if (obj1 != null)
            {
                obj = foreignIdField.extractRawJavaFieldValue(obj1);
            }
        }
        return obj;
    }

    public Object extractRawJavaFieldValue(Object obj)
    {
        if (fieldGetMethod == null)
        {
            try
            {
                obj = field.get(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw SqlExceptionUtil.create((new StringBuilder()).append("Could not get field value for ").append(this).toString(), ((Throwable) (obj)));
            }
            return obj;
        }
        try
        {
            obj = fieldGetMethod.invoke(obj, new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not call ").append(fieldGetMethod).append(" for ").append(this).toString(), ((Throwable) (obj)));
        }
        return obj;
    }

    public Object generateId()
    {
        return dataPersister.generateId();
    }

    public String getColumnDefinition()
    {
        return fieldConfig.getColumnDefinition();
    }

    public DataPersister getDataPersister()
    {
        return dataPersister;
    }

    public Object getDataTypeConfigObj()
    {
        return dataTypeConfigObj;
    }

    public String getDbColumnName()
    {
        return dbColumnName;
    }

    public Object getDefaultValue()
    {
        return defaultValue;
    }

    public Field getField()
    {
        return field;
    }

    public String getFieldName()
    {
        return field.getName();
    }

    public Class getFieldType()
    {
        return field.getType();
    }

    public Object getFieldValueIfNotDefault(Object obj)
    {
        Object obj1 = extractJavaFieldValue(obj);
        obj = obj1;
        if (isFieldValueDefault(obj1))
        {
            obj = null;
        }
        return obj;
    }

    public FieldType getForeignFieldType()
    {
        return foreignFieldType;
    }

    public FieldType getForeignIdField()
    {
        return foreignIdField;
    }

    public String getFormat()
    {
        return fieldConfig.getFormat();
    }

    public String getGeneratedIdSequence()
    {
        return generatedIdSequence;
    }

    public String getIndexName()
    {
        return fieldConfig.getIndexName();
    }

    public Object getJavaDefaultValueDefault()
    {
        if (field.getType() == Boolean.TYPE)
        {
            return Boolean.valueOf(DEFAULT_VALUE_BOOLEAN);
        }
        if (field.getType() == Byte.TYPE || field.getType() == java/lang/Byte)
        {
            return Byte.valueOf(DEFAULT_VALUE_BYTE);
        }
        if (field.getType() == Character.TYPE || field.getType() == java/lang/Character)
        {
            return Character.valueOf(DEFAULT_VALUE_CHAR);
        }
        if (field.getType() == Short.TYPE || field.getType() == java/lang/Short)
        {
            return Short.valueOf(DEFAULT_VALUE_SHORT);
        }
        if (field.getType() == Integer.TYPE || field.getType() == java/lang/Integer)
        {
            return Integer.valueOf(DEFAULT_VALUE_INT);
        }
        if (field.getType() == Long.TYPE || field.getType() == java/lang/Long)
        {
            return Long.valueOf(DEFAULT_VALUE_LONG);
        }
        if (field.getType() == Float.TYPE || field.getType() == java/lang/Float)
        {
            return Float.valueOf(DEFAULT_VALUE_FLOAT);
        }
        if (field.getType() == Double.TYPE || field.getType() == java/lang/Double)
        {
            return Double.valueOf(DEFAULT_VALUE_DOUBLE);
        } else
        {
            return null;
        }
    }

    public SqlType getSqlType()
    {
        return fieldConverter.getSqlType();
    }

    public String getUniqueIndexName()
    {
        return fieldConfig.getUniqueIndexName();
    }

    public Enum getUnknownEnumVal()
    {
        return fieldConfig.getUnknownEnumValue();
    }

    public int getWidth()
    {
        return fieldConfig.getWidth();
    }

    public int hashCode()
    {
        return field.hashCode();
    }

    public boolean isAllowGeneratedIdInsert()
    {
        return fieldConfig.isAllowGeneratedIdInsert();
    }

    public boolean isArgumentHolderRequired()
    {
        return dataPersister.isSelectArgRequired();
    }

    public boolean isCanBeNull()
    {
        return fieldConfig.isCanBeNull();
    }

    public boolean isComparable()
    {
        return dataPersister.isComparable();
    }

    public boolean isEscapedDefaultValue()
    {
        return dataPersister.isEscapedDefaultValue();
    }

    public boolean isEscapedValue()
    {
        return dataPersister.isEscapedValue();
    }

    public boolean isForeign()
    {
        return fieldConfig.isForeign();
    }

    public boolean isForeignAutoCreate()
    {
        return fieldConfig.isForeignAutoCreate();
    }

    public boolean isForeignCollection()
    {
        return fieldConfig.isForeignCollection();
    }

    public boolean isGeneratedId()
    {
        return isGeneratedId;
    }

    public boolean isGeneratedIdSequence()
    {
        return generatedIdSequence != null;
    }

    public boolean isId()
    {
        return isId;
    }

    public boolean isObjectsFieldValueDefault(Object obj)
    {
        return isFieldValueDefault(extractJavaFieldValue(obj));
    }

    public boolean isSelfGeneratedId()
    {
        return dataPersister.isSelfGeneratedId();
    }

    public boolean isUnique()
    {
        return fieldConfig.isUnique();
    }

    public boolean isUniqueCombo()
    {
        return fieldConfig.isUniqueCombo();
    }

    public boolean isVersion()
    {
        return fieldConfig.isVersion();
    }

    public Object moveToNextValue(Object obj)
    {
        if (dataPersister == null)
        {
            return null;
        } else
        {
            return dataPersister.moveToNextValue(obj);
        }
    }

    public Object resultToJava(DatabaseResults databaseresults, Map map)
    {
        Integer integer1 = (Integer)map.get(dbColumnName);
        Integer integer = integer1;
        if (integer1 == null)
        {
            integer = Integer.valueOf(databaseresults.findColumn(dbColumnName));
            map.put(dbColumnName, integer);
        }
        map = ((Map) (fieldConverter.resultToJava(this, databaseresults, integer.intValue())));
        if (dataPersister.isPrimitive())
        {
            if (fieldConfig.isThrowIfNull() && databaseresults.wasNull(integer.intValue()))
            {
                throw new SQLException((new StringBuilder()).append("Results value for primitive field '").append(field.getName()).append("' was an invalid null value").toString());
            }
        } else
        if (!fieldConverter.isStreamType() && databaseresults.wasNull(integer.intValue()))
        {
            return null;
        }
        return map;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(":name=").append(field.getName()).append(",class=").append(field.getDeclaringClass().getSimpleName()).toString();
    }


    private class LevelCounters
    {

        int autoRefreshlevel;
        int foreignCollectionLevel;

        private LevelCounters()
        {
        }

    }

}
