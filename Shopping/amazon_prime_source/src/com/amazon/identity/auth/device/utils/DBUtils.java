// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.database.Cursor;

public final class DBUtils
{

    public static String getString(Cursor cursor, String s)
    {
        int i = cursor.getColumnIndex(s);
        if (i == -1)
        {
            return null;
        } else
        {
            return cursor.getString(i);
        }
    }
}
