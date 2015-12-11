// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.wishabi.flipp.content:
//            UserContentProvider, bk

final class bj extends SQLiteOpenHelper
{

    public bj(Context context)
    {
        super(context, "user.db", null, 4);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        onUpgrade(sqlitedatabase, 0, 4);
    }

    public final void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        for (i--; i >= j; i--)
        {
            UserContentProvider.a()[i].b(sqlitedatabase);
        }

    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        for (; i < j; i++)
        {
            UserContentProvider.a()[i].a(sqlitedatabase);
        }

    }
}
