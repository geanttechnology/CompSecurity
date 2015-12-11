// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.j.a.a.a:
//            g

public class e extends SQLiteOpenHelper
{

    private g a;

    public e(Context context, String s, int i, g g1)
    {
        super(context, s, null, i);
        a = g1;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        a.a(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        a.a(sqlitedatabase);
    }
}
