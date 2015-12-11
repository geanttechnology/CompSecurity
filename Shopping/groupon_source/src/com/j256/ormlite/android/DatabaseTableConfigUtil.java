// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTableConfigUtil
{
    private static class DatabaseFieldSample
    {

        String field;

        private DatabaseFieldSample()
        {
        }
    }


    private static Class annotationFactoryClazz;
    private static Class annotationMemberClazz;
    private static final int configFieldNums[] = lookupClasses();
    private static Field elementsField;
    private static Field nameField;
    private static Field valueField;
    private static int workedC = 0;

    private static void assignConfigField(int i, DatabaseFieldConfig databasefieldconfig, Field field, Object obj)
    {
        i;
        JVM INSTR tableswitch 1 29: default 132
    //                   1 159
    //                   2 171
    //                   3 180
    //                   4 204
    //                   5 216
    //                   6 228
    //                   7 240
    //                   8 252
    //                   9 264
    //                   10 276
    //                   11 288
    //                   12 301
    //                   13 313
    //                   14 325
    //                   15 337
    //                   16 349
    //                   17 361
    //                   18 373
    //                   19 385
    //                   20 397
    //                   21 409
    //                   22 421
    //                   23 433
    //                   24 442
    //                   25 454
    //                   26 466
    //                   27 478
    //                   28 490
    //                   29 502;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Could not find support for DatabaseField number ").append(i).toString());
_L2:
        databasefieldconfig.setColumnName(valueIfNotBlank((String)obj));
_L32:
        return;
_L3:
        databasefieldconfig.setDataType((DataType)obj);
        return;
_L4:
        field = (String)obj;
        if (field == null || field.equals("__ormlite__ no default value string was specified")) goto _L32; else goto _L31
_L31:
        databasefieldconfig.setDefaultValue(field);
        return;
_L5:
        databasefieldconfig.setWidth(((Integer)obj).intValue());
        return;
_L6:
        databasefieldconfig.setCanBeNull(((Boolean)obj).booleanValue());
        return;
_L7:
        databasefieldconfig.setId(((Boolean)obj).booleanValue());
        return;
_L8:
        databasefieldconfig.setGeneratedId(((Boolean)obj).booleanValue());
        return;
_L9:
        databasefieldconfig.setGeneratedIdSequence(valueIfNotBlank((String)obj));
        return;
_L10:
        databasefieldconfig.setForeign(((Boolean)obj).booleanValue());
        return;
_L11:
        databasefieldconfig.setUseGetSet(((Boolean)obj).booleanValue());
        return;
_L12:
        databasefieldconfig.setUnknownEnumValue(DatabaseFieldConfig.findMatchingEnumVal(field, (String)obj));
        return;
_L13:
        databasefieldconfig.setThrowIfNull(((Boolean)obj).booleanValue());
        return;
_L14:
        databasefieldconfig.setPersisted(((Boolean)obj).booleanValue());
        return;
_L15:
        databasefieldconfig.setFormat(valueIfNotBlank((String)obj));
        return;
_L16:
        databasefieldconfig.setUnique(((Boolean)obj).booleanValue());
        return;
_L17:
        databasefieldconfig.setUniqueCombo(((Boolean)obj).booleanValue());
        return;
_L18:
        databasefieldconfig.setIndex(((Boolean)obj).booleanValue());
        return;
_L19:
        databasefieldconfig.setUniqueIndex(((Boolean)obj).booleanValue());
        return;
_L20:
        databasefieldconfig.setIndexName(valueIfNotBlank((String)obj));
        return;
_L21:
        databasefieldconfig.setUniqueIndexName(valueIfNotBlank((String)obj));
        return;
_L22:
        databasefieldconfig.setForeignAutoRefresh(((Boolean)obj).booleanValue());
        return;
_L23:
        databasefieldconfig.setMaxForeignAutoRefreshLevel(((Integer)obj).intValue());
        return;
_L24:
        databasefieldconfig.setPersisterClass((Class)obj);
        return;
_L25:
        databasefieldconfig.setAllowGeneratedIdInsert(((Boolean)obj).booleanValue());
        return;
_L26:
        databasefieldconfig.setColumnDefinition(valueIfNotBlank((String)obj));
        return;
_L27:
        databasefieldconfig.setForeignAutoCreate(((Boolean)obj).booleanValue());
        return;
_L28:
        databasefieldconfig.setVersion(((Boolean)obj).booleanValue());
        return;
_L29:
        databasefieldconfig.setForeignColumnName(valueIfNotBlank((String)obj));
        return;
_L30:
        databasefieldconfig.setReadOnly(((Boolean)obj).booleanValue());
        return;
    }

    private static DatabaseFieldConfig buildConfig(DatabaseField databasefield, String s, Field field)
        throws Exception
    {
        s = null;
        databasefield = Proxy.getInvocationHandler(databasefield);
        if (databasefield.getClass() == annotationFactoryClazz) goto _L2; else goto _L1
_L1:
        databasefield = s;
_L4:
        return databasefield;
_L2:
        Object obj = elementsField.get(databasefield);
        databasefield = s;
        if (obj == null)
        {
            continue;
        }
        s = new DatabaseFieldConfig(field.getName());
        Object aobj[] = (Object[])(Object[])obj;
        int i = 0;
        do
        {
            databasefield = s;
            if (i >= configFieldNums.length)
            {
                continue;
            }
            databasefield = ((DatabaseField) (valueField.get(aobj[i])));
            if (databasefield != null)
            {
                assignConfigField(configFieldNums[i], s, field, databasefield);
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static int configFieldNameToNum(String s)
    {
        if (s.equals("columnName"))
        {
            return 1;
        }
        if (s.equals("dataType"))
        {
            return 2;
        }
        if (s.equals("defaultValue"))
        {
            return 3;
        }
        if (s.equals("width"))
        {
            return 4;
        }
        if (s.equals("canBeNull"))
        {
            return 5;
        }
        if (s.equals("id"))
        {
            return 6;
        }
        if (s.equals("generatedId"))
        {
            return 7;
        }
        if (s.equals("generatedIdSequence"))
        {
            return 8;
        }
        if (s.equals("foreign"))
        {
            return 9;
        }
        if (s.equals("useGetSet"))
        {
            return 10;
        }
        if (s.equals("unknownEnumName"))
        {
            return 11;
        }
        if (s.equals("throwIfNull"))
        {
            return 12;
        }
        if (s.equals("persisted"))
        {
            return 13;
        }
        if (s.equals("format"))
        {
            return 14;
        }
        if (s.equals("unique"))
        {
            return 15;
        }
        if (s.equals("uniqueCombo"))
        {
            return 16;
        }
        if (s.equals("index"))
        {
            return 17;
        }
        if (s.equals("uniqueIndex"))
        {
            return 18;
        }
        if (s.equals("indexName"))
        {
            return 19;
        }
        if (s.equals("uniqueIndexName"))
        {
            return 20;
        }
        if (s.equals("foreignAutoRefresh"))
        {
            return 21;
        }
        if (s.equals("maxForeignAutoRefreshLevel"))
        {
            return 22;
        }
        if (s.equals("persisterClass"))
        {
            return 23;
        }
        if (s.equals("allowGeneratedIdInsert"))
        {
            return 24;
        }
        if (s.equals("columnDefinition"))
        {
            return 25;
        }
        if (s.equals("foreignAutoCreate"))
        {
            return 26;
        }
        if (s.equals("version"))
        {
            return 27;
        }
        if (s.equals("foreignColumnName"))
        {
            return 28;
        }
        if (s.equals("readOnly"))
        {
            return 29;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not find support for DatabaseField ").append(s).toString());
        }
    }

    private static DatabaseFieldConfig configFromField(DatabaseType databasetype, String s, Field field)
        throws SQLException
    {
        if (configFieldNums == null)
        {
            return DatabaseFieldConfig.fromField(databasetype, s, field);
        }
        DatabaseField databasefield = (DatabaseField)field.getAnnotation(com/j256/ormlite/field/DatabaseField);
        Object obj = null;
        DatabaseFieldConfig databasefieldconfig = obj;
        if (databasefield != null)
        {
            try
            {
                databasefieldconfig = buildConfig(databasefield, s, field);
            }
            catch (Exception exception)
            {
                exception = obj;
            }
        }
        if (databasefieldconfig == null)
        {
            return DatabaseFieldConfig.fromField(databasetype, s, field);
        } else
        {
            workedC++;
            return databasefieldconfig;
        }
    }

    public static DatabaseTableConfig fromClass(ConnectionSource connectionsource, Class class1)
        throws SQLException
    {
        DatabaseType databasetype = connectionsource.getDatabaseType();
        String s = DatabaseTableConfig.extractTableName(class1);
        ArrayList arraylist = new ArrayList();
        for (connectionsource = class1; connectionsource != null; connectionsource = connectionsource.getSuperclass())
        {
            Field afield[] = connectionsource.getDeclaredFields();
            int j = afield.length;
            for (int i = 0; i < j; i++)
            {
                DatabaseFieldConfig databasefieldconfig = configFromField(databasetype, s, afield[i]);
                if (databasefieldconfig != null && databasefieldconfig.isPersisted())
                {
                    arraylist.add(databasefieldconfig);
                }
            }

        }

        if (arraylist.size() == 0)
        {
            return null;
        } else
        {
            return new DatabaseTableConfig(class1, s, arraylist);
        }
    }

    private static int[] lookupClasses()
    {
        Object obj;
        Object obj1;
        try
        {
            annotationFactoryClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationFactory");
            annotationMemberClazz = Class.forName("org.apache.harmony.lang.annotation.AnnotationMember");
            obj = Class.forName("[Lorg.apache.harmony.lang.annotation.AnnotationMember;");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        try
        {
            elementsField = annotationFactoryClazz.getDeclaredField("elements");
            elementsField.setAccessible(true);
            nameField = annotationMemberClazz.getDeclaredField("name");
            nameField.setAccessible(true);
            valueField = annotationMemberClazz.getDeclaredField("value");
            valueField.setAccessible(true);
            obj1 = com/j256/ormlite/android/DatabaseTableConfigUtil$DatabaseFieldSample.getDeclaredField("field");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return null;
        }
        obj1 = Proxy.getInvocationHandler((DatabaseField)((Field) (obj1)).getAnnotation(com/j256/ormlite/field/DatabaseField));
        if (obj1.getClass() == annotationFactoryClazz) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((int []) (obj));
_L2:
        int ai[];
        Object aobj[];
        int i;
        try
        {
            obj1 = elementsField.get(obj1);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            return null;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (obj1.getClass() != obj)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        aobj = (Object[])(Object[])obj1;
        ai = new int[aobj.length];
        i = 0;
_L5:
        obj = ai;
        if (i >= aobj.length) goto _L4; else goto _L3
_L3:
        ai[i] = configFieldNameToNum((String)nameField.get(aobj[i]));
        i++;
          goto _L5
        return null;
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

}
