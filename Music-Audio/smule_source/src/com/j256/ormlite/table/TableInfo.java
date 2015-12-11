// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.table;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.j256.ormlite.table:
//            DatabaseTableConfig

public class TableInfo
{

    private final Constructor constructor;
    private final Dao dao;
    private final Class dataClass;
    private Map fieldNameMap;
    private final FieldType fieldTypes[];
    private final boolean foreignAutoCreate;
    private final FieldType idField;
    private final String tableName;

    public TableInfo(DatabaseType databasetype, Dao dao1, DatabaseTableConfig databasetableconfig)
    {
        dao = dao1;
        dataClass = databasetableconfig.getDataClass();
        tableName = databasetableconfig.getTableName();
        fieldTypes = databasetableconfig.getFieldTypes(databasetype);
        FieldType afieldtype[] = fieldTypes;
        int j = afieldtype.length;
        int i = 0;
        boolean flag = false;
        for (databasetype = null; i < j; databasetype = dao1)
        {
            FieldType fieldtype;
label0:
            {
                fieldtype = afieldtype[i];
                if (!fieldtype.isId() && !fieldtype.isGeneratedId())
                {
                    dao1 = databasetype;
                    if (!fieldtype.isGeneratedIdSequence())
                    {
                        break label0;
                    }
                }
                if (databasetype != null)
                {
                    throw new SQLException((new StringBuilder()).append("More than 1 idField configured for class ").append(dataClass).append(" (").append(databasetype).append(",").append(fieldtype).append(")").toString());
                }
                dao1 = fieldtype;
            }
            if (fieldtype.isForeignAutoCreate())
            {
                flag = true;
            }
            i++;
        }

        idField = databasetype;
        constructor = databasetableconfig.getConstructor();
        foreignAutoCreate = flag;
    }

    public TableInfo(ConnectionSource connectionsource, Dao dao1, Class class1)
    {
        this(connectionsource.getDatabaseType(), dao1, DatabaseTableConfig.fromClass(connectionsource, class1));
    }

    public static Object createObject(Constructor constructor1, Dao dao1)
    {
        Object obj;
        try
        {
            obj = constructor1.newInstance(new Object[0]);
            if (obj instanceof BaseDaoEnabled)
            {
                ((BaseDaoEnabled)obj).setDao(dao1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Dao dao1)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not create object for ").append(constructor1.getDeclaringClass()).toString(), dao1);
        }
        return obj;
    }

    public Object createObject()
    {
        return createObject(constructor, dao);
    }

    public Constructor getConstructor()
    {
        return constructor;
    }

    public Class getDataClass()
    {
        return dataClass;
    }

    public FieldType getFieldTypeByColumnName(String s)
    {
        if (fieldNameMap == null)
        {
            HashMap hashmap = new HashMap();
            FieldType afieldtype[] = fieldTypes;
            int k = afieldtype.length;
            for (int i = 0; i < k; i++)
            {
                FieldType fieldtype1 = afieldtype[i];
                hashmap.put(fieldtype1.getDbColumnName(), fieldtype1);
            }

            fieldNameMap = hashmap;
        }
        Object obj = (FieldType)fieldNameMap.get(s);
        if (obj == null)
        {
            obj = fieldTypes;
            int l = obj.length;
            for (int j = 0; j < l; j++)
            {
                FieldType fieldtype = obj[j];
                if (fieldtype.getFieldName().equals(s))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("You should use columnName '").append(fieldtype.getDbColumnName()).append("' for table ").append(tableName).append(" instead of fieldName '").append(s).append("'").toString());
                }
            }

            throw new IllegalArgumentException((new StringBuilder()).append("Unknown column name '").append(s).append("' in table ").append(tableName).toString());
        } else
        {
            return ((FieldType) (obj));
        }
    }

    public FieldType[] getFieldTypes()
    {
        return fieldTypes;
    }

    public FieldType getIdField()
    {
        return idField;
    }

    public String getTableName()
    {
        return tableName;
    }

    public boolean isForeignAutoCreate()
    {
        return foreignAutoCreate;
    }

    public boolean isUpdatable()
    {
        return idField != null && fieldTypes.length > 1;
    }

    public String objectToString(Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append(obj.getClass().getSimpleName());
        FieldType afieldtype[] = fieldTypes;
        int j = afieldtype.length;
        int i = 0;
        while (i < j) 
        {
            FieldType fieldtype = afieldtype[i];
            stringbuilder.append(' ').append(fieldtype.getDbColumnName()).append("=");
            try
            {
                stringbuilder.append(fieldtype.extractJavaFieldValue(obj));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IllegalStateException((new StringBuilder()).append("Could not generate toString of field ").append(fieldtype).toString(), ((Throwable) (obj)));
            }
            i++;
        }
        return stringbuilder.toString();
    }
}
