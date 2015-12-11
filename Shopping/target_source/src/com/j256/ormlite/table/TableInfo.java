// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
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
//            DatabaseTableConfig, ObjectFactory

public class TableInfo
{

    private static final FieldType NO_FOREIGN_COLLECTIONS[] = new FieldType[0];
    private final BaseDaoImpl baseDaoImpl;
    private final Constructor constructor;
    private final Class dataClass;
    private Map fieldNameMap;
    private final FieldType fieldTypes[];
    private final boolean foreignAutoCreate;
    private final FieldType foreignCollections[];
    private final FieldType idField;
    private final String tableName;

    public TableInfo(DatabaseType databasetype, BaseDaoImpl basedaoimpl, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        baseDaoImpl = basedaoimpl;
        dataClass = databasetableconfig.getDataClass();
        tableName = databasetableconfig.getTableName();
        fieldTypes = databasetableconfig.getFieldTypes(databasetype);
        databasetype = null;
        FieldType afieldtype[] = fieldTypes;
        int l = afieldtype.length;
        int j = 0;
        int i = 0;
        boolean flag = false;
        while (j < l) 
        {
            FieldType fieldtype;
label0:
            {
                fieldtype = afieldtype[j];
                if (!fieldtype.isId() && !fieldtype.isGeneratedId())
                {
                    basedaoimpl = databasetype;
                    if (!fieldtype.isGeneratedIdSequence())
                    {
                        break label0;
                    }
                }
                if (databasetype != null)
                {
                    throw new SQLException((new StringBuilder()).append("More than 1 idField configured for class ").append(dataClass).append(" (").append(databasetype).append(",").append(fieldtype).append(")").toString());
                }
                basedaoimpl = fieldtype;
            }
            if (fieldtype.isForeignAutoCreate())
            {
                flag = true;
            }
            if (fieldtype.isForeignCollection())
            {
                i++;
            }
            j++;
            databasetype = basedaoimpl;
        }
        idField = databasetype;
        constructor = databasetableconfig.getConstructor();
        foreignAutoCreate = flag;
        if (i == 0)
        {
            foreignCollections = NO_FOREIGN_COLLECTIONS;
        } else
        {
            foreignCollections = new FieldType[i];
            databasetype = fieldTypes;
            int j1 = databasetype.length;
            i = 0;
            int k = 0;
            while (i < j1) 
            {
                basedaoimpl = databasetype[i];
                int i1 = k;
                if (basedaoimpl.isForeignCollection())
                {
                    foreignCollections[k] = basedaoimpl;
                    i1 = k + 1;
                }
                i++;
                k = i1;
            }
        }
    }

    public TableInfo(ConnectionSource connectionsource, BaseDaoImpl basedaoimpl, Class class1)
        throws SQLException
    {
        this(connectionsource.getDatabaseType(), basedaoimpl, DatabaseTableConfig.fromClass(connectionsource, class1));
    }

    private static void wireNewInstance(BaseDaoImpl basedaoimpl, Object obj)
    {
        if (obj instanceof BaseDaoEnabled)
        {
            ((BaseDaoEnabled)obj).setDao(basedaoimpl);
        }
    }

    public Object createObject()
        throws SQLException
    {
        Object obj = null;
        try
        {
            if (baseDaoImpl != null)
            {
                obj = baseDaoImpl.getObjectFactory();
            }
        }
        catch (Exception exception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not create object for ").append(constructor.getDeclaringClass()).toString(), exception);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj = constructor.newInstance(new Object[0]);
_L1:
        wireNewInstance(baseDaoImpl, obj);
        return obj;
        obj = ((ObjectFactory) (obj)).createObject(constructor, baseDaoImpl.getDataClass());
          goto _L1
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
            FieldType afieldtype1[] = fieldTypes;
            int k = afieldtype1.length;
            for (int i = 0; i < k; i++)
            {
                FieldType fieldtype2 = afieldtype1[i];
                hashmap.put(fieldtype2.getColumnName().toLowerCase(), fieldtype2);
            }

            fieldNameMap = hashmap;
        }
        FieldType fieldtype = (FieldType)fieldNameMap.get(s.toLowerCase());
        if (fieldtype != null)
        {
            return fieldtype;
        }
        FieldType afieldtype[] = fieldTypes;
        int l = afieldtype.length;
        for (int j = 0; j < l; j++)
        {
            FieldType fieldtype1 = afieldtype[j];
            if (fieldtype1.getFieldName().equals(s))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("You should use columnName '").append(fieldtype1.getColumnName()).append("' for table ").append(tableName).append(" instead of fieldName '").append(fieldtype1.getFieldName()).append("'").toString());
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("Unknown column name '").append(s).append("' in table ").append(tableName).toString());
    }

    public FieldType[] getFieldTypes()
    {
        return fieldTypes;
    }

    public FieldType[] getForeignCollections()
    {
        return foreignCollections;
    }

    public FieldType getIdField()
    {
        return idField;
    }

    public String getTableName()
    {
        return tableName;
    }

    public boolean hasColumnName(String s)
    {
        boolean flag1 = false;
        FieldType afieldtype[] = fieldTypes;
        int j = afieldtype.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!afieldtype[i].getColumnName().equals(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
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
            stringbuilder.append(' ').append(fieldtype.getColumnName()).append("=");
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
