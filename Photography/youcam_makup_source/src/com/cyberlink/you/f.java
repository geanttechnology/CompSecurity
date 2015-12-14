// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.you.utility.ULogUtility;

public class f
    implements DatabaseErrorHandler
{

    public f()
    {
    }

    public void onCorruption(SQLiteDatabase sqlitedatabase)
    {
        ULogUtility.a("Datbase", "Corruption ", sqlitedatabase.getPath(), (new StringBuilder()).append(" Version: ").append(sqlitedatabase.getVersion()).toString());
    }
}
