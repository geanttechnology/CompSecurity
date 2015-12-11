// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistence;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field:
//            DataType, DatabaseField, ForeignCollectionField, DataPersister

public class DatabaseFieldConfig
{

    public static final DataType DEFAULT_DATA_TYPE;
    public static final Class DEFAULT_PERSISTER_CLASS = com/j256/ormlite/field/types/VoidType;
    private boolean allowGeneratedIdInsert;
    private boolean canBeNull;
    private String columnDefinition;
    private String columnName;
    private DataPersister dataPersister;
    private DataType dataType;
    private String defaultValue;
    private String fieldName;
    private boolean foreign;
    private boolean foreignAutoCreate;
    private boolean foreignAutoRefresh;
    private boolean foreignCollection;
    private String foreignCollectionColumnName;
    private boolean foreignCollectionEager;
    private String foreignCollectionForeignFieldName;
    private int foreignCollectionMaxEagerLevel;
    private boolean foreignCollectionOrderAscending;
    private String foreignCollectionOrderColumnName;
    private String foreignColumnName;
    private DatabaseTableConfig foreignTableConfig;
    private String format;
    private boolean generatedId;
    private String generatedIdSequence;
    private boolean id;
    private boolean index;
    private String indexName;
    private int maxForeignAutoRefreshLevel;
    private boolean persisted;
    private Class persisterClass;
    private boolean readOnly;
    private boolean throwIfNull;
    private boolean unique;
    private boolean uniqueCombo;
    private boolean uniqueIndex;
    private String uniqueIndexName;
    private Enum unknownEnumValue;
    private boolean useGetSet;
    private boolean version;
    private int width;

    public DatabaseFieldConfig()
    {
        dataType = DEFAULT_DATA_TYPE;
        canBeNull = true;
        persisted = true;
        maxForeignAutoRefreshLevel = -1;
        persisterClass = DEFAULT_PERSISTER_CLASS;
        foreignCollectionMaxEagerLevel = 1;
        foreignCollectionOrderAscending = true;
    }

    public DatabaseFieldConfig(String s)
    {
        dataType = DEFAULT_DATA_TYPE;
        canBeNull = true;
        persisted = true;
        maxForeignAutoRefreshLevel = -1;
        persisterClass = DEFAULT_PERSISTER_CLASS;
        foreignCollectionMaxEagerLevel = 1;
        foreignCollectionOrderAscending = true;
        fieldName = s;
    }

    public static Method findGetMethod(Field field, boolean flag)
    {
        String s = methodFromField(field, "get");
        Method method = field.getDeclaringClass().getMethod(s, new Class[0]);
        Method method1 = method;
        Exception exception;
        if (method.getReturnType() != field.getType())
        {
            if (flag)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Return type of get method ").append(s).append(" does not return ").append(field.getType()).toString());
            } else
            {
                return null;
            }
        }
        break MISSING_BLOCK_LABEL_113;
        exception;
        if (flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find appropriate get method for ").append(field).toString());
        }
        method1 = null;
        return method1;
    }

    private String findIndexName(String s)
    {
        if (columnName == null)
        {
            return (new StringBuilder()).append(s).append("_").append(fieldName).append("_idx").toString();
        } else
        {
            return (new StringBuilder()).append(s).append("_").append(columnName).append("_idx").toString();
        }
    }

    public static Enum findMatchingEnumVal(Field field, String s)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        Enum enum = null;
_L4:
        return enum;
_L2:
        Enum aenum[] = (Enum[])(Enum[])field.getType().getEnumConstants();
        int j = aenum.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Enum enum1 = aenum[i];
                enum = enum1;
                if (enum1.name().equals(s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("Unknwown enum unknown name ").append(s).append(" for field ").append(field).toString());
    }

    public static Method findSetMethod(Field field, boolean flag)
    {
        String s = methodFromField(field, "set");
        Object obj = field.getDeclaringClass().getMethod(s, new Class[] {
            field.getType()
        });
        field = ((Field) (obj));
        obj = field;
        if (field.getReturnType() != Void.TYPE)
        {
            if (flag)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Return type of set method ").append(s).append(" returns ").append(field.getReturnType()).append(" instead of void").toString());
            } else
            {
                return null;
            }
        }
        break MISSING_BLOCK_LABEL_123;
        obj;
        if (flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find appropriate set method for ").append(field).toString());
        }
        obj = null;
        return ((Method) (obj));
    }

    public static DatabaseFieldConfig fromDatabaseField(DatabaseType databasetype, String s, Field field, DatabaseField databasefield)
    {
        s = new DatabaseFieldConfig();
        s.fieldName = field.getName();
        if (databasetype.isEntityNamesMustBeUpCase())
        {
            s.fieldName = ((DatabaseFieldConfig) (s)).fieldName.toUpperCase();
        }
        s.columnName = valueIfNotBlank(databasefield.columnName());
        s.dataType = databasefield.dataType();
        databasetype = databasefield.defaultValue();
        if (!databasetype.equals("__ormlite__ no default value string was specified"))
        {
            s.defaultValue = databasetype;
        }
        s.width = databasefield.width();
        s.canBeNull = databasefield.canBeNull();
        s.id = databasefield.id();
        s.generatedId = databasefield.generatedId();
        s.generatedIdSequence = valueIfNotBlank(databasefield.generatedIdSequence());
        s.foreign = databasefield.foreign();
        s.useGetSet = databasefield.useGetSet();
        s.unknownEnumValue = findMatchingEnumVal(field, databasefield.unknownEnumName());
        s.throwIfNull = databasefield.throwIfNull();
        s.format = valueIfNotBlank(databasefield.format());
        s.unique = databasefield.unique();
        s.uniqueCombo = databasefield.uniqueCombo();
        s.index = databasefield.index();
        s.indexName = valueIfNotBlank(databasefield.indexName());
        s.uniqueIndex = databasefield.uniqueIndex();
        s.uniqueIndexName = valueIfNotBlank(databasefield.uniqueIndexName());
        s.foreignAutoRefresh = databasefield.foreignAutoRefresh();
        s.maxForeignAutoRefreshLevel = databasefield.maxForeignAutoRefreshLevel();
        s.persisterClass = databasefield.persisterClass();
        s.allowGeneratedIdInsert = databasefield.allowGeneratedIdInsert();
        s.columnDefinition = valueIfNotBlank(databasefield.columnDefinition());
        s.foreignAutoCreate = databasefield.foreignAutoCreate();
        s.version = databasefield.version();
        s.foreignColumnName = valueIfNotBlank(databasefield.foreignColumnName());
        s.readOnly = databasefield.readOnly();
        return s;
    }

    public static DatabaseFieldConfig fromField(DatabaseType databasetype, String s, Field field)
        throws SQLException
    {
        DatabaseField databasefield = (DatabaseField)field.getAnnotation(com/j256/ormlite/field/DatabaseField);
        if (databasefield != null)
        {
            if (databasefield.persisted())
            {
                return fromDatabaseField(databasetype, s, field, databasefield);
            } else
            {
                return null;
            }
        }
        s = (ForeignCollectionField)field.getAnnotation(com/j256/ormlite/field/ForeignCollectionField);
        if (s != null)
        {
            return fromForeignCollection(databasetype, field, s);
        } else
        {
            return JavaxPersistence.createFieldConfig(databasetype, field);
        }
    }

    private static DatabaseFieldConfig fromForeignCollection(DatabaseType databasetype, Field field, ForeignCollectionField foreigncollectionfield)
    {
        databasetype = new DatabaseFieldConfig();
        databasetype.fieldName = field.getName();
        if (foreigncollectionfield.columnName().length() > 0)
        {
            databasetype.columnName = foreigncollectionfield.columnName();
        }
        databasetype.foreignCollection = true;
        databasetype.foreignCollectionEager = foreigncollectionfield.eager();
        int i = foreigncollectionfield.maxEagerForeignCollectionLevel();
        if (i != 1)
        {
            databasetype.foreignCollectionMaxEagerLevel = i;
        } else
        {
            databasetype.foreignCollectionMaxEagerLevel = foreigncollectionfield.maxEagerLevel();
        }
        databasetype.foreignCollectionOrderColumnName = valueIfNotBlank(foreigncollectionfield.orderColumnName());
        databasetype.foreignCollectionOrderAscending = foreigncollectionfield.orderAscending();
        databasetype.foreignCollectionColumnName = valueIfNotBlank(foreigncollectionfield.columnName());
        field = valueIfNotBlank(foreigncollectionfield.foreignFieldName());
        if (field == null)
        {
            databasetype.foreignCollectionForeignFieldName = valueIfNotBlank(valueIfNotBlank(foreigncollectionfield.foreignColumnName()));
            return databasetype;
        } else
        {
            databasetype.foreignCollectionForeignFieldName = field;
            return databasetype;
        }
    }

    private static String methodFromField(Field field, String s)
    {
        return (new StringBuilder()).append(s).append(field.getName().substring(0, 1).toUpperCase()).append(field.getName().substring(1)).toString();
    }

    private static String valueIfNotBlank(String s)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            s1 = null;
        }
        return s1;
    }

    public String getColumnDefinition()
    {
        return columnDefinition;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public DataPersister getDataPersister()
    {
        if (dataPersister == null)
        {
            return dataType.getDataPersister();
        } else
        {
            return dataPersister;
        }
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public String getForeignCollectionForeignFieldName()
    {
        return foreignCollectionForeignFieldName;
    }

    public int getForeignCollectionMaxEagerLevel()
    {
        return foreignCollectionMaxEagerLevel;
    }

    public String getForeignCollectionOrderColumnName()
    {
        return foreignCollectionOrderColumnName;
    }

    public String getForeignColumnName()
    {
        return foreignColumnName;
    }

    public DatabaseTableConfig getForeignTableConfig()
    {
        return foreignTableConfig;
    }

    public String getFormat()
    {
        return format;
    }

    public String getGeneratedIdSequence()
    {
        return generatedIdSequence;
    }

    public String getIndexName(String s)
    {
        if (index && indexName == null)
        {
            indexName = findIndexName(s);
        }
        return indexName;
    }

    public int getMaxForeignAutoRefreshLevel()
    {
        return maxForeignAutoRefreshLevel;
    }

    public Class getPersisterClass()
    {
        return persisterClass;
    }

    public String getUniqueIndexName(String s)
    {
        if (uniqueIndex && uniqueIndexName == null)
        {
            uniqueIndexName = findIndexName(s);
        }
        return uniqueIndexName;
    }

    public Enum getUnknownEnumValue()
    {
        return unknownEnumValue;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean isAllowGeneratedIdInsert()
    {
        return allowGeneratedIdInsert;
    }

    public boolean isCanBeNull()
    {
        return canBeNull;
    }

    public boolean isForeign()
    {
        return foreign;
    }

    public boolean isForeignAutoCreate()
    {
        return foreignAutoCreate;
    }

    public boolean isForeignAutoRefresh()
    {
        return foreignAutoRefresh;
    }

    public boolean isForeignCollection()
    {
        return foreignCollection;
    }

    public boolean isForeignCollectionEager()
    {
        return foreignCollectionEager;
    }

    public boolean isForeignCollectionOrderAscending()
    {
        return foreignCollectionOrderAscending;
    }

    public boolean isGeneratedId()
    {
        return generatedId;
    }

    public boolean isId()
    {
        return id;
    }

    public boolean isPersisted()
    {
        return persisted;
    }

    public boolean isReadOnly()
    {
        return readOnly;
    }

    public boolean isThrowIfNull()
    {
        return throwIfNull;
    }

    public boolean isUnique()
    {
        return unique;
    }

    public boolean isUniqueCombo()
    {
        return uniqueCombo;
    }

    public boolean isUseGetSet()
    {
        return useGetSet;
    }

    public boolean isVersion()
    {
        return version;
    }

    public void postProcess()
    {
        if (foreignColumnName != null)
        {
            foreignAutoRefresh = true;
        }
        if (foreignAutoRefresh && maxForeignAutoRefreshLevel == -1)
        {
            maxForeignAutoRefreshLevel = 2;
        }
    }

    public void setAllowGeneratedIdInsert(boolean flag)
    {
        allowGeneratedIdInsert = flag;
    }

    public void setCanBeNull(boolean flag)
    {
        canBeNull = flag;
    }

    public void setColumnDefinition(String s)
    {
        columnDefinition = s;
    }

    public void setColumnName(String s)
    {
        columnName = s;
    }

    public void setDataPersister(DataPersister datapersister)
    {
        dataPersister = datapersister;
    }

    public void setDataType(DataType datatype)
    {
        dataType = datatype;
    }

    public void setDefaultValue(String s)
    {
        defaultValue = s;
    }

    public void setFieldName(String s)
    {
        fieldName = s;
    }

    public void setForeign(boolean flag)
    {
        foreign = flag;
    }

    public void setForeignAutoCreate(boolean flag)
    {
        foreignAutoCreate = flag;
    }

    public void setForeignAutoRefresh(boolean flag)
    {
        foreignAutoRefresh = flag;
    }

    public void setForeignCollection(boolean flag)
    {
        foreignCollection = flag;
    }

    public void setForeignCollectionColumnName(String s)
    {
        foreignCollectionColumnName = s;
    }

    public void setForeignCollectionEager(boolean flag)
    {
        foreignCollectionEager = flag;
    }

    public void setForeignCollectionForeignFieldName(String s)
    {
        foreignCollectionForeignFieldName = s;
    }

    public void setForeignCollectionMaxEagerLevel(int i)
    {
        foreignCollectionMaxEagerLevel = i;
    }

    public void setForeignCollectionOrderAscending(boolean flag)
    {
        foreignCollectionOrderAscending = flag;
    }

    public void setForeignCollectionOrderColumnName(String s)
    {
        foreignCollectionOrderColumnName = s;
    }

    public void setForeignColumnName(String s)
    {
        foreignColumnName = s;
    }

    public void setFormat(String s)
    {
        format = s;
    }

    public void setGeneratedId(boolean flag)
    {
        generatedId = flag;
    }

    public void setGeneratedIdSequence(String s)
    {
        generatedIdSequence = s;
    }

    public void setId(boolean flag)
    {
        id = flag;
    }

    public void setIndex(boolean flag)
    {
        index = flag;
    }

    public void setIndexName(String s)
    {
        indexName = s;
    }

    public void setMaxForeignAutoRefreshLevel(int i)
    {
        maxForeignAutoRefreshLevel = i;
    }

    public void setPersisted(boolean flag)
    {
        persisted = flag;
    }

    public void setPersisterClass(Class class1)
    {
        persisterClass = class1;
    }

    public void setReadOnly(boolean flag)
    {
        readOnly = flag;
    }

    public void setThrowIfNull(boolean flag)
    {
        throwIfNull = flag;
    }

    public void setUnique(boolean flag)
    {
        unique = flag;
    }

    public void setUniqueCombo(boolean flag)
    {
        uniqueCombo = flag;
    }

    public void setUniqueIndex(boolean flag)
    {
        uniqueIndex = flag;
    }

    public void setUniqueIndexName(String s)
    {
        uniqueIndexName = s;
    }

    public void setUnknownEnumValue(Enum enum)
    {
        unknownEnumValue = enum;
    }

    public void setUseGetSet(boolean flag)
    {
        useGetSet = flag;
    }

    public void setVersion(boolean flag)
    {
        version = flag;
    }

    public void setWidth(int i)
    {
        width = i;
    }

    static 
    {
        DEFAULT_DATA_TYPE = DataType.UNKNOWN;
    }
}
