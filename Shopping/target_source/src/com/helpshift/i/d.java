// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

public class d
{

    public static boolean a(SQLiteDatabase sqlitedatabase, String s, String s1, String as[])
    {
        return DatabaseUtils.longForQuery(sqlitedatabase, (new StringBuilder()).append("SELECT COUNT(*) FROM ").append(s).append(" WHERE ").append(s1).append(" LIMIT 1").toString(), as) > 0L;
    }
}
