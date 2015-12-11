// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

// Referenced classes of package com.google.ads.conversiontracking:
//            i

public class sorFactory extends SQLiteOpenHelper
{

    final i a;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        String s = i.e();
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL(s);
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, s);
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
    {
        Log.i("GoogleConversionReporter", (new StringBuilder(64)).append("Database updated from version ").append(j).append(" to version ").append(k).toString());
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS conversiontracking");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS conversiontracking");
        }
        onCreate(sqlitedatabase);
    }

    public sorFactory(i j, Context context, String s)
    {
        a = j;
        super(context, s, null, 5);
    }
}
