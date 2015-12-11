// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.smule.android.console:
//            d

class f extends SQLiteOpenHelper
{

    f(Context context)
    {
        super(context, "consoleSetting.db", null, 1);
    }

    private static String a(String s, String as[][])
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("CREATE TABLE ").append(s).append(" (");
        for (int i = 0; i < as.length; i++)
        {
            stringbuilder.append(as[i][0]).append(" ").append(as[i][1]);
            if (i < as.length - 1)
            {
                stringbuilder.append(",");
            }
        }

        stringbuilder.append(");");
        return stringbuilder.toString();
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(a("setting", d.b()));
        sqlitedatabase.execSQL(a("cmdhistory", d.c()));
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
