// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class enHelper
    implements ct
{

    final ParseSQLiteDatabase this$0;
    final SQLiteOpenHelper val$helper;

    public SQLiteDatabase then(cu cu)
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

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    enHelper()
    {
        this$0 = final_parsesqlitedatabase;
        val$helper = SQLiteOpenHelper.this;
        super();
    }
}
