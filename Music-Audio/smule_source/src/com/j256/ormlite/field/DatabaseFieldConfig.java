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

// Referenced classes of package com.j256.ormlite.field:
//            DataType, DatabaseField, DatabaseFieldSimple, DatabaseFieldOther, 
//            DatabaseFieldId, DatabaseFieldForeign, DatabaseFieldIndex, ForeignCollectionField, 
//            DataPersister

public class DatabaseFieldConfig
{

    private static final boolean DEFAULT_CAN_BE_NULL = true;
    private static final DataPersister DEFAULT_DATA_PERSISTER;
    private static final int DEFAULT_MAX_EAGER_FOREIGN_COLLECTION_LEVEL = 1;
    private static final int DEFAULT_MAX_FOREIGN_AUTO_REFRESH_LEVEL = 2;
    private static final Class DEFAULT_PERSISTER_CLASS = com/j256/ormlite/field/types/VoidType;
    private boolean allowGeneratedIdInsert;
    private boolean canBeNull;
    private String columnDefinition;
    private String columnName;
    private DataPersister dataPersister;
    private String defaultValue;
    private String fieldName;
    private boolean foreign;
    private boolean foreignAutoCreate;
    private boolean foreignAutoRefresh;
    private boolean foreignCollection;
    private boolean foreignCollectionEager;
    private String foreignCollectionOrderColumn;
    private DatabaseTableConfig foreignTableConfig;
    private String format;
    private boolean generatedId;
    private String generatedIdSequence;
    private boolean id;
    private String indexName;
    private int maxEagerForeignCollectionLevel;
    private int maxForeignAutoRefreshLevel;
    private Class persisterClass;
    private boolean throwIfNull;
    private boolean unique;
    private boolean uniqueCombo;
    private String uniqueIndexName;
    private Enum unknownEnumValue;
    private boolean useGetSet;
    private boolean version;
    private int width;

    public DatabaseFieldConfig()
    {
        dataPersister = DEFAULT_DATA_PERSISTER;
        canBeNull = true;
        maxForeignAutoRefreshLevel = 2;
        maxEagerForeignCollectionLevel = 1;
        persisterClass = DEFAULT_PERSISTER_CLASS;
    }

    public DatabaseFieldConfig(String s)
    {
        dataPersister = DEFAULT_DATA_PERSISTER;
        canBeNull = true;
        maxForeignAutoRefreshLevel = 2;
        maxEagerForeignCollectionLevel = 1;
        persisterClass = DEFAULT_PERSISTER_CLASS;
        fieldName = s;
    }

    public DatabaseFieldConfig(String s, String s1, DataPersister datapersister, String s2, int i, boolean flag, boolean flag1, 
            boolean flag2, String s3, boolean flag3, DatabaseTableConfig databasetableconfig, boolean flag4, Enum enum, boolean flag5, 
            String s4, boolean flag6, String s5, String s6, boolean flag7, int j, int k)
    {
        dataPersister = DEFAULT_DATA_PERSISTER;
        canBeNull = true;
        maxForeignAutoRefreshLevel = 2;
        maxEagerForeignCollectionLevel = 1;
        persisterClass = DEFAULT_PERSISTER_CLASS;
        fieldName = s;
        columnName = s1;
        dataPersister = datapersister;
        defaultValue = s2;
        width = i;
        canBeNull = flag;
        id = flag1;
        generatedId = flag2;
        generatedIdSequence = s3;
        foreign = flag3;
        foreignTableConfig = databasetableconfig;
        useGetSet = flag4;
        unknownEnumValue = enum;
        throwIfNull = flag5;
        format = s4;
        unique = flag6;
        indexName = s5;
        uniqueIndexName = s6;
        foreignAutoRefresh = flag7;
        maxForeignAutoRefreshLevel = j;
        maxEagerForeignCollectionLevel = k;
    }

    public DatabaseFieldConfig(String s, String s1, DataType datatype, String s2, int i, boolean flag, boolean flag1, 
            boolean flag2, String s3, boolean flag3, DatabaseTableConfig databasetableconfig, boolean flag4, Enum enum, boolean flag5, 
            String s4, boolean flag6, String s5, String s6, boolean flag7, int j, int k)
    {
        if (datatype == null)
        {
            datatype = null;
        } else
        {
            datatype = datatype.getDataPersister();
        }
        this(s, s1, ((DataPersister) (datatype)), s2, i, flag, flag1, flag2, s3, flag3, databasetableconfig, flag4, enum, flag5, s4, flag6, s5, s6, flag7, j, k);
    }

    public static Method findGetMethod(Field field, boolean flag)
    {
        Object obj;
        String s;
        obj = null;
        s = methodFromField(field, "get");
        Object obj1 = field.getDeclaringClass().getMethod(s, new Class[0]);
        if (((Method) (obj1)).getReturnType() != field.getType())
        {
            if (flag)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Return type of get method ").append(s).append(" does not return ").append(field.getType()).toString());
            }
        } else
        {
            obj = obj1;
        }
        break MISSING_BLOCK_LABEL_113;
        obj1;
        if (flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find appropriate get method for ").append(field).toString());
        }
        return ((Method) (obj));
    }

    private static String findIndexName(String s, String s1, boolean flag, DatabaseFieldConfig databasefieldconfig)
    {
        if (s1.length() > 0)
        {
            return s1;
        }
        if (flag)
        {
            if (databasefieldconfig.columnName == null)
            {
                return (new StringBuilder()).append(s).append("_").append(databasefieldconfig.fieldName).append("_idx").toString();
            } else
            {
                return (new StringBuilder()).append(s).append("_").append(databasefieldconfig.columnName).append("_idx").toString();
            }
        } else
        {
            return null;
        }
    }

    private static Enum findMatchingEnumVal(Field field, String s)
    {
        Enum aenum[] = (Enum[])(Enum[])field.getType().getEnumConstants();
        int j = aenum.length;
        for (int i = 0; i < j; i++)
        {
            Enum enum = aenum[i];
            if (enum.name().equals(s))
            {
                return enum;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("Unknwown enum unknown name ").append(s).append(" for field ").append(field).toString());
    }

    public static Method findSetMethod(Field field, boolean flag)
    {
        Object obj;
        String s;
        obj = null;
        s = methodFromField(field, "set");
        Object obj1 = field.getDeclaringClass().getMethod(s, new Class[] {
            field.getType()
        });
        if (((Method) (obj1)).getReturnType() != Void.TYPE)
        {
            if (flag)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Return type of set method ").append(s).append(" returns ").append(((Method) (obj1)).getReturnType()).append(" instead of void").toString());
            }
        } else
        {
            obj = obj1;
        }
        break MISSING_BLOCK_LABEL_124;
        obj1;
        if (flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find appropriate set method for ").append(field).toString());
        }
        return ((Method) (obj));
    }

    public static DatabaseFieldConfig fromDatabaseField(DatabaseType databasetype, String s, Field field, DatabaseField databasefield)
    {
        DatabaseFieldConfig databasefieldconfig = new DatabaseFieldConfig();
        databasefieldconfig.fieldName = field.getName();
        if (databasetype.isEntityNamesMustBeUpCase())
        {
            databasefieldconfig.fieldName = databasefieldconfig.fieldName.toUpperCase();
        }
        databasetype = databasefield.columnName();
        if (databasetype.length() > 0)
        {
            databasefieldconfig.columnName = databasetype;
        }
        databasetype = databasefield.dataType();
        if (databasetype != null)
        {
            databasefieldconfig.dataPersister = databasetype.getDataPersister();
        }
        databasetype = databasefield.defaultValue();
        if (!databasetype.equals("__ormlite__ no default value string was specified"))
        {
            databasefieldconfig.defaultValue = databasetype;
        }
        databasefieldconfig.width = databasefield.width();
        databasefieldconfig.canBeNull = databasefield.canBeNull();
        databasefieldconfig.id = databasefield.id();
        databasefieldconfig.generatedId = databasefield.generatedId();
        databasetype = databasefield.generatedIdSequence();
        if (databasetype.length() > 0)
        {
            databasefieldconfig.generatedIdSequence = databasetype;
        }
        databasefieldconfig.foreign = databasefield.foreign();
        databasefieldconfig.useGetSet = databasefield.useGetSet();
        databasetype = databasefield.unknownEnumName();
        if (databasetype.length() > 0)
        {
            databasefieldconfig.unknownEnumValue = findMatchingEnumVal(field, databasetype);
        }
        databasefieldconfig.throwIfNull = databasefield.throwIfNull();
        databasetype = databasefield.format();
        if (databasetype.length() > 0)
        {
            databasefieldconfig.format = databasetype;
        }
        databasefieldconfig.unique = databasefield.unique();
        databasefieldconfig.uniqueCombo = databasefield.uniqueCombo();
        databasefieldconfig.indexName = findIndexName(s, databasefield.indexName(), databasefield.index(), databasefieldconfig);
        databasefieldconfig.uniqueIndexName = findIndexName(s, databasefield.uniqueIndexName(), databasefield.uniqueIndex(), databasefieldconfig);
        databasefieldconfig.foreignAutoRefresh = databasefield.foreignAutoRefresh();
        databasefieldconfig.maxForeignAutoRefreshLevel = databasefield.maxForeignAutoRefreshLevel();
        databasefieldconfig.persisterClass = databasefield.persisterClass();
        databasefieldconfig.allowGeneratedIdInsert = databasefield.allowGeneratedIdInsert();
        databasetype = databasefield.columnDefinition();
        if (databasetype.length() > 0)
        {
            databasefieldconfig.columnDefinition = databasetype;
        }
        databasefieldconfig.foreignAutoCreate = databasefield.foreignAutoCreate();
        databasefieldconfig.version = databasefield.version();
        return databasefieldconfig;
    }

    public static DatabaseFieldConfig fromDatabaseFieldAnnotations(DatabaseType databasetype, String s, Field field, DatabaseFieldSimple databasefieldsimple, DatabaseFieldId databasefieldid, DatabaseFieldForeign databasefieldforeign, DatabaseFieldIndex databasefieldindex, DatabaseFieldOther databasefieldother)
    {
        DatabaseFieldConfig databasefieldconfig = new DatabaseFieldConfig();
        databasefieldconfig.fieldName = field.getName();
        if (databasetype.isEntityNamesMustBeUpCase())
        {
            databasefieldconfig.fieldName = databasefieldconfig.fieldName.toUpperCase();
        }
        databasetype = databasefieldsimple.columnName();
        if (databasetype.length() > 0)
        {
            databasefieldconfig.columnName = databasetype;
        }
        if (databasefieldother != null)
        {
            databasetype = databasefieldother.dataType();
            if (databasetype != null)
            {
                databasefieldconfig.dataPersister = databasetype.getDataPersister();
            }
        }
        databasetype = databasefieldsimple.defaultValue();
        if (!databasetype.equals("__ormlite__ no default value string was specified"))
        {
            databasefieldconfig.defaultValue = databasetype;
        }
        databasefieldconfig.width = databasefieldsimple.width();
        databasefieldconfig.canBeNull = databasefieldsimple.canBeNull();
        if (databasefieldid != null)
        {
            databasefieldconfig.id = databasefieldid.id();
            databasefieldconfig.generatedId = databasefieldid.generatedId();
            databasetype = databasefieldid.generatedIdSequence();
            if (databasetype.length() > 0)
            {
                databasefieldconfig.generatedIdSequence = databasetype;
            }
        }
        if (databasefieldforeign != null)
        {
            databasefieldconfig.foreign = databasefieldforeign.foreign();
        }
        if (databasefieldother != null)
        {
            databasefieldconfig.useGetSet = databasefieldother.useGetSet();
            databasetype = databasefieldother.unknownEnumName();
            if (databasetype.length() > 0)
            {
                databasefieldconfig.unknownEnumValue = findMatchingEnumVal(field, databasetype);
            }
            databasefieldconfig.throwIfNull = databasefieldother.throwIfNull();
            databasetype = databasefieldother.format();
            if (databasetype.length() > 0)
            {
                databasefieldconfig.format = databasetype;
            }
        }
        if (databasefieldindex != null)
        {
            databasefieldconfig.unique = databasefieldindex.unique();
            databasefieldconfig.uniqueCombo = databasefieldindex.uniqueCombo();
            databasefieldconfig.indexName = findIndexName(s, databasefieldindex.indexName(), databasefieldindex.index(), databasefieldconfig);
            databasefieldconfig.uniqueIndexName = findIndexName(s, databasefieldindex.uniqueIndexName(), databasefieldindex.uniqueIndex(), databasefieldconfig);
        }
        if (databasefieldforeign != null)
        {
            databasefieldconfig.foreignAutoRefresh = databasefieldforeign.foreignAutoRefresh();
            databasefieldconfig.maxForeignAutoRefreshLevel = databasefieldforeign.maxForeignAutoRefreshLevel();
        }
        if (databasefieldother != null)
        {
            databasefieldconfig.persisterClass = databasefieldother.persisterClass();
        }
        if (databasefieldid != null)
        {
            databasefieldconfig.allowGeneratedIdInsert = databasefieldid.allowGeneratedIdInsert();
        }
        if (databasefieldother != null)
        {
            databasetype = databasefieldother.columnDefinition();
            if (databasetype.length() > 0)
            {
                databasefieldconfig.columnDefinition = databasetype;
            }
        }
        if (databasefieldforeign != null)
        {
            databasefieldconfig.foreignAutoCreate = databasefieldforeign.foreignAutoCreate();
        }
        if (databasefieldother != null)
        {
            databasefieldconfig.version = databasefieldother.version();
        }
        return databasefieldconfig;
    }

    public static DatabaseFieldConfig fromField(DatabaseType databasetype, String s, Field field)
    {
        DatabaseField databasefield = (DatabaseField)field.getAnnotation(com/j256/ormlite/field/DatabaseField);
        if (databasefield == null) goto _L2; else goto _L1
_L1:
        if (!databasefield.persisted()) goto _L4; else goto _L3
_L3:
        databasetype = fromDatabaseField(databasetype, s, field, databasefield);
_L6:
        return databasetype;
_L4:
        return null;
_L2:
        Object obj = (DatabaseFieldSimple)field.getAnnotation(com/j256/ormlite/field/DatabaseFieldSimple);
        if (obj != null)
        {
            return fromDatabaseFieldAnnotations(databasetype, s, field, ((DatabaseFieldSimple) (obj)), (DatabaseFieldId)field.getAnnotation(com/j256/ormlite/field/DatabaseFieldId), (DatabaseFieldForeign)field.getAnnotation(com/j256/ormlite/field/DatabaseFieldForeign), (DatabaseFieldIndex)field.getAnnotation(com/j256/ormlite/field/DatabaseFieldIndex), (DatabaseFieldOther)field.getAnnotation(com/j256/ormlite/field/DatabaseFieldOther));
        }
        obj = (ForeignCollectionField)field.getAnnotation(com/j256/ormlite/field/ForeignCollectionField);
        if (obj != null)
        {
            return fromForeignCollection(databasetype, s, field, ((ForeignCollectionField) (obj)));
        }
        s = JavaxPersistence.createFieldConfig(databasetype, field);
        databasetype = s;
        if (s == null)
        {
            return null;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static DatabaseFieldConfig fromForeignCollection(DatabaseType databasetype, String s, Field field, ForeignCollectionField foreigncollectionfield)
    {
        databasetype = new DatabaseFieldConfig();
        databasetype.fieldName = field.getName();
        if (foreigncollectionfield.columnName().length() > 0)
        {
            databasetype.columnName = foreigncollectionfield.columnName();
        } else
        {
            databasetype.columnName = field.getName();
        }
        databasetype.foreignCollection = true;
        databasetype.foreignCollectionEager = foreigncollectionfield.eager();
        databasetype.maxEagerForeignCollectionLevel = foreigncollectionfield.maxEagerForeignCollectionLevel();
        if (foreigncollectionfield.orderColumnName().length() > 0)
        {
            databasetype.foreignCollectionOrderColumn = foreigncollectionfield.orderColumnName();
            return databasetype;
        } else
        {
            databasetype.foreignCollectionOrderColumn = null;
            return databasetype;
        }
    }

    private static String methodFromField(Field field, String s)
    {
        return (new StringBuilder()).append(s).append(field.getName().substring(0, 1).toUpperCase()).append(field.getName().substring(1)).toString();
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
        return dataPersister;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public String getForeignCollectionOrderColumn()
    {
        return foreignCollectionOrderColumn;
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

    public String getIndexName()
    {
        return indexName;
    }

    public int getMaxEagerForeignCollectionLevel()
    {
        return maxEagerForeignCollectionLevel;
    }

    public int getMaxForeignAutoRefreshLevel()
    {
        return maxForeignAutoRefreshLevel;
    }

    public Class getPersisterClass()
    {
        return persisterClass;
    }

    public String getUniqueIndexName()
    {
        return uniqueIndexName;
    }

    public Enum getUnknownEnumValue()
    {
        return unknownEnumValue;
    }

    public Enum getUnknownEnumvalue()
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

    public boolean isGeneratedId()
    {
        return generatedId;
    }

    public boolean isId()
    {
        return id;
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
        dataPersister = datatype.getDataPersister();
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

    public void setForeignCollectionEager(boolean flag)
    {
        foreignCollectionEager = flag;
    }

    public void setForeignCollectionOrderColumn(String s)
    {
        foreignCollectionOrderColumn = s;
    }

    public void setForeignTableConfig(DatabaseTableConfig databasetableconfig)
    {
        foreignTableConfig = databasetableconfig;
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

    public void setIndexName(String s)
    {
        indexName = s;
    }

    public void setMaxEagerForeignCollectionLevel(int i)
    {
        maxEagerForeignCollectionLevel = i;
    }

    public void setMaxForeignAutoRefreshLevel(int i)
    {
        maxForeignAutoRefreshLevel = i;
    }

    public void setPersisterClass(Class class1)
    {
        persisterClass = class1;
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
        DEFAULT_DATA_PERSISTER = DataType.UNKNOWN.getDataPersister();
    }
}
