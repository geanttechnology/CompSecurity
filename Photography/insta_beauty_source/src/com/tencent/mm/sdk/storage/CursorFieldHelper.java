// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class CursorFieldHelper
{

    private static final Map bI;
    private static final Map bJ;
    private static final Map bK;

    CursorFieldHelper()
    {
    }

    public static Method get(Class class1, boolean flag)
    {
        if (flag)
        {
            return (Method)bJ.get(class1);
        } else
        {
            return (Method)bI.get(class1);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentvalues)
    {
        try
        {
            contentvalues.put(field.getName().substring(6), (byte[])field.get(obj));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentvalues)
    {
        String s = field.getName().substring(6);
        int i;
        if (field.getBoolean(obj))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            contentvalues.put(s, Integer.valueOf(i));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentvalues)
    {
        if (!field.getType().equals(Double.TYPE))
        {
            contentvalues.put(field.getName().substring(6), (Double)field.get(obj));
            return;
        }
        try
        {
            contentvalues.put(field.getName().substring(6), Double.valueOf(field.getDouble(obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentvalues)
    {
        if (!field.getType().equals(Float.TYPE))
        {
            contentvalues.put(field.getName().substring(6), (Float)field.get(obj));
            return;
        }
        try
        {
            contentvalues.put(field.getName().substring(6), Float.valueOf(field.getFloat(obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentvalues)
    {
        if (!field.getType().equals(Integer.TYPE))
        {
            contentvalues.put(field.getName().substring(6), (Integer)field.get(obj));
            return;
        }
        try
        {
            contentvalues.put(field.getName().substring(6), Integer.valueOf(field.getInt(obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentvalues)
    {
        if (!field.getType().equals(Long.TYPE))
        {
            contentvalues.put(field.getName().substring(6), (Long)field.get(obj));
            return;
        }
        try
        {
            contentvalues.put(field.getName().substring(6), Long.valueOf(field.getLong(obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentvalues)
    {
        try
        {
            contentvalues.put(field.getName().substring(6), Short.valueOf(field.getShort(obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentvalues)
    {
        try
        {
            contentvalues.put(field.getName().substring(6), (String)field.get(obj));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i)
    {
        try
        {
            field.set(obj, cursor.getBlob(i));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i)
    {
        if (field.getType().equals(Boolean.TYPE))
        {
            boolean flag;
            if (cursor.getInt(i) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            try
            {
                field.setBoolean(obj, flag);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Field field)
            {
                field.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_55;
        }
        field.set(obj, Integer.valueOf(cursor.getInt(i)));
        return;
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i)
    {
        if (field.getType().equals(Double.TYPE))
        {
            field.setDouble(obj, cursor.getDouble(i));
            return;
        }
        try
        {
            field.set(obj, Double.valueOf(cursor.getDouble(i)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i)
    {
        if (field.getType().equals(Float.TYPE))
        {
            field.setFloat(obj, cursor.getFloat(i));
            return;
        }
        try
        {
            field.set(obj, Float.valueOf(cursor.getFloat(i)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i)
    {
        if (field.getType().equals(Integer.TYPE))
        {
            field.setInt(obj, cursor.getInt(i));
            return;
        }
        try
        {
            field.set(obj, Integer.valueOf(cursor.getInt(i)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i)
    {
        if (field.getType().equals(Long.TYPE))
        {
            field.setLong(obj, cursor.getLong(i));
            return;
        }
        try
        {
            field.set(obj, Long.valueOf(cursor.getLong(i)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i)
    {
        if (field.getType().equals(Short.TYPE))
        {
            field.setShort(obj, cursor.getShort(i));
            return;
        }
        try
        {
            field.set(obj, Short.valueOf(cursor.getShort(i)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
        return;
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i)
    {
        try
        {
            field.set(obj, cursor.getString(i));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Field field)
        {
            field.printStackTrace();
        }
    }

    public static String type(Class class1)
    {
        return (String)bK.get(class1);
    }

    static 
    {
        bI = new HashMap();
        bJ = new HashMap();
        bK = new HashMap();
        try
        {
            bI.put([B, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setBlob", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(Short.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setShort", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/Short, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setShort", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(Boolean.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setBoolean", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/Boolean, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setBoolean", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(Integer.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setInt", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/Integer, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setInt", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(Float.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setFloat", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/Float, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setFloat", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(Double.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setDouble", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/Double, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setDouble", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(Long.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setLong", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/Long, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setLong", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bI.put(java/lang/String, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_setString", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/database/Cursor, Integer.TYPE
            }));
            bJ.put([B, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getBlob", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(Short.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getShort", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/Short, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getShort", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(Boolean.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getBoolean", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/Boolean, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getBoolean", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(Integer.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getInt", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/Integer, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getInt", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(Float.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getFloat", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/Float, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getFloat", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(Double.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getDouble", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/Double, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getDouble", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(Long.TYPE, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getLong", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/Long, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getLong", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bJ.put(java/lang/String, com/tencent/mm/sdk/storage/CursorFieldHelper.getMethod("keep_getString", new Class[] {
                java/lang/reflect/Field, java/lang/Object, android/content/ContentValues
            }));
            bK.put([B, "BLOB");
            bK.put(Short.TYPE, "SHORT");
            bK.put(java/lang/Short, "SHORT");
            bK.put(Boolean.TYPE, "INTEGER");
            bK.put(java/lang/Boolean, "INTEGER");
            bK.put(Integer.TYPE, "INTEGER");
            bK.put(java/lang/Integer, "INTEGER");
            bK.put(Float.TYPE, "FLOAT");
            bK.put(java/lang/Float, "FLOAT");
            bK.put(Double.TYPE, "DOUBLE");
            bK.put(java/lang/Double, "DOUBLE");
            bK.put(Long.TYPE, "LONG");
            bK.put(java/lang/Long, "LONG");
            bK.put(java/lang/String, "TEXT");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
