// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.database.Cursor;

public final class f
{

    public static Double a(Cursor cursor, int i)
    {
        if (cursor.isNull(i))
        {
            return null;
        } else
        {
            return Double.valueOf(cursor.getDouble(i));
        }
    }

    public static String a(String s, String as[])
    {
        if (as == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(s.length() + 6 + as.length * 2);
        stringbuilder.append(s);
        stringbuilder.append(" IN (");
        int i = 0;
        while (i < as.length) 
        {
            if (i == as.length - 1)
            {
                s = "?";
            } else
            {
                s = "?,";
            }
            stringbuilder.append(s);
            i++;
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public static String a(String s, String as[], boolean flag)
    {
        if (as == null || as.length == 0)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(s.length() + 6 + as.length * 13 + 3);
        stringbuilder.append("CASE ").append(s).append(" ");
        for (int i = 0; i < as.length; i++)
        {
            stringbuilder.append("WHEN ? THEN ").append(i).append(" ");
        }

        if (flag)
        {
            stringbuilder.append("ELSE 2147483647 ");
        }
        stringbuilder.append("END");
        return stringbuilder.toString();
    }

    public static int[] a(Cursor cursor, String s)
    {
        int ai[];
        int i;
        int j;
        int k;
        j = cursor.getPosition();
        ai = new int[cursor.getCount()];
        k = cursor.getColumnIndexOrThrow(s);
        i = 0;
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        ai[i] = cursor.getInt(k);
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L2:
        cursor.moveToPosition(j);
        return ai;
_L3:
        i++;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static Float b(Cursor cursor, int i)
    {
        if (cursor.isNull(i))
        {
            return null;
        } else
        {
            return Float.valueOf(cursor.getFloat(i));
        }
    }

    public static String b(String s, String as[])
    {
        if (as == null)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder(s.length() + 6 + as.length * 2);
        stringbuilder.append(s);
        stringbuilder.append(" NOT IN (");
        int i = 0;
        while (i < as.length) 
        {
            if (i == as.length - 1)
            {
                s = "?";
            } else
            {
                s = "?,";
            }
            stringbuilder.append(s);
            i++;
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public static String[] b(Cursor cursor, String s)
    {
        String as[];
        int i;
        int j;
        int k;
        j = cursor.getPosition();
        as = new String[cursor.getCount()];
        k = cursor.getColumnIndexOrThrow(s);
        i = 0;
        if (!cursor.moveToFirst()) goto _L2; else goto _L1
_L1:
        as[i] = Integer.toString(cursor.getInt(k));
        if (cursor.moveToNext()) goto _L3; else goto _L2
_L2:
        cursor.moveToPosition(j);
        return as;
_L3:
        i++;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static Integer c(Cursor cursor, int i)
    {
        if (cursor.isNull(i))
        {
            return null;
        } else
        {
            return Integer.valueOf(cursor.getInt(i));
        }
    }

    public static String d(Cursor cursor, int i)
    {
        if (cursor.isNull(i))
        {
            return null;
        } else
        {
            return cursor.getString(i);
        }
    }
}
