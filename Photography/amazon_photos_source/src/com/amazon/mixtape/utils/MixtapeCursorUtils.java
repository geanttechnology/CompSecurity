// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;

import android.database.Cursor;

public class MixtapeCursorUtils
{

    public static boolean getBooleanFromCursor(Cursor cursor, String s)
    {
        return cursor.getLong(cursor.getColumnIndex(s)) == 1L;
    }

    public static long getLongFromCursor(Cursor cursor, String s)
    {
        return cursor.getLong(cursor.getColumnIndex(s));
    }

    public static String getStringFromCursor(Cursor cursor, String s)
    {
        return cursor.getString(cursor.getColumnIndex(s));
    }
}
