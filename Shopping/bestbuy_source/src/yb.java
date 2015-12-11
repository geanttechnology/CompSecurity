// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class yb extends SQLiteOpenHelper
{

    final ya a;

    public yb(ya ya1, Context context, String s)
    {
        a = ya1;
        super(context, s, null, 4);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(ya.d());
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        acb.c((new StringBuilder()).append("Database updated from version ").append(i).append(" to version ").append(j).toString());
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS InAppPurchase");
        onCreate(sqlitedatabase);
    }
}
