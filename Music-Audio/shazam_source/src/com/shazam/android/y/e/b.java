// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.shazam.android.y.e:
//            c

public final class b extends SQLiteOpenHelper
{

    public b(Context context, String s)
    {
        this(context, s, new c());
    }

    private b(Context context, String s, c c1)
    {
        super(context, s, c1, 4);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE guaranteed_requests (_id INTEGER PRIMARY KEY AUTOINCREMENT, request TEXT)");
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS guaranteed_requests");
        sqlitedatabase.execSQL("CREATE TABLE guaranteed_requests (_id INTEGER PRIMARY KEY AUTOINCREMENT, request TEXT)");
    }
}
