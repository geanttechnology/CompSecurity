// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class enHelper
    implements i
{

    final ParseSQLiteDatabase this$0;
    final SQLiteOpenHelper val$helper;

    public SQLiteDatabase then(j j)
        throws Exception
    {
        if ((ParseSQLiteDatabase.access$400(ParseSQLiteDatabase.this) & 1) == 1)
        {
            return val$helper.getReadableDatabase();
        } else
        {
            return val$helper.getWritableDatabase();
        }
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    enHelper()
    {
        this$0 = final_parsesqlitedatabase;
        val$helper = SQLiteOpenHelper.this;
        super();
    }
}
