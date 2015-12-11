// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util.d;

import android.database.Cursor;

public final class a
{

    public static String a(Cursor cursor, String s)
    {
        Object obj = null;
        String s1 = obj;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        int j;
        try
        {
            j = cursor.getColumnIndex(s);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return null;
        }
        s1 = obj;
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        s1 = cursor.getString(j);
        return s1;
    }

    public static long b(Cursor cursor, String s)
    {
        if (cursor != null) goto _L2; else goto _L1
_L1:
        int j;
        return -1L;
_L2:
        if ((j = cursor.getColumnIndex(s)) == -1) goto _L1; else goto _L3
_L3:
        long l;
        try
        {
            l = cursor.getLong(j);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return -1L;
        }
        return l;
    }

    public static Long c(Cursor cursor, String s)
    {
        if (cursor != null) goto _L2; else goto _L1
_L1:
        int j;
        return null;
_L2:
        if ((j = cursor.getColumnIndex(s)) == -1) goto _L1; else goto _L3
_L3:
        long l;
        try
        {
            l = cursor.getLong(j);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return null;
        }
        return Long.valueOf(l);
    }

    public static byte[] d(Cursor cursor, String s)
    {
        if (cursor != null) goto _L2; else goto _L1
_L1:
        int j;
        return null;
_L2:
        if ((j = cursor.getColumnIndex(s)) == -1) goto _L1; else goto _L3
_L3:
        try
        {
            cursor = cursor.getBlob(j);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return null;
        }
        return cursor;
    }

    public static double e(Cursor cursor, String s)
    {
        if (cursor != null) goto _L2; else goto _L1
_L1:
        int j;
        return (0.0D / 0.0D);
_L2:
        if ((j = cursor.getColumnIndex(s)) == -1) goto _L1; else goto _L3
_L3:
        double d1;
        try
        {
            d1 = cursor.getDouble(j);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return (0.0D / 0.0D);
        }
        return d1;
    }

    public static Double f(Cursor cursor, String s)
    {
        if (cursor != null) goto _L2; else goto _L1
_L1:
        int j;
        return null;
_L2:
        if ((j = cursor.getColumnIndex(s)) == -1) goto _L1; else goto _L3
_L3:
        double d1;
        try
        {
            d1 = cursor.getDouble(j);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return null;
        }
        return Double.valueOf(d1);
    }

    public static Integer g(Cursor cursor, String s)
    {
        Object obj = null;
        Integer integer = obj;
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        integer = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        int j;
        try
        {
            j = cursor.getColumnIndex(s);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor.getMessage();
            return null;
        }
        integer = obj;
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        integer = obj;
        if (cursor.isNull(j))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        j = cursor.getInt(j);
        integer = Integer.valueOf(j);
        return integer;
    }

    public static Boolean h(Cursor cursor, String s)
    {
        cursor = g(cursor, s);
        boolean flag;
        if (cursor != null && cursor.intValue() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public static boolean i(Cursor cursor, String s)
    {
        cursor = g(cursor, s);
        return cursor != null && cursor.intValue() > 0;
    }
}
