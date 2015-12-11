// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.wishabi.flipp.content:
//            FlyersContentProvider, x

final class w extends SQLiteOpenHelper
{

    public w(Context context)
    {
        super(context, "flyers.db", null, 7);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        onUpgrade(sqlitedatabase, 0, 7);
    }

    public final void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        for (i--; i >= j; i--)
        {
            FlyersContentProvider.a()[i].b(sqlitedatabase);
        }

    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        for (; i < j; i++)
        {
            FlyersContentProvider.a()[i].a(sqlitedatabase);
        }

    }
}
