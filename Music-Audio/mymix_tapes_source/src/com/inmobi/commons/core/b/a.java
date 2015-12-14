// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper
{

    public a(Context context)
    {
        super(context, "com.im.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
