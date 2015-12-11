// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class z extends SQLiteOpenHelper
{

    public z(Context context)
    {
        super(context, "com.appdynamics.eumagent.runtime.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE metrics (timestamp INTEGER, data TEXT NOT NULL)");
        sqlitedatabase.execSQL("CREATE TABLE metric_stats (stat_name TEXT NOT NULL, stat_value INTEGER)");
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS metrics");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS metric_stats");
        onCreate(sqlitedatabase);
    }
}
