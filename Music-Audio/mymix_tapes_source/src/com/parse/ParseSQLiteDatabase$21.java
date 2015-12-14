// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.sqlite.SQLiteDatabase;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class val.args
    implements Continuation
{

    final ParseSQLiteDatabase this$0;
    final String val$args[];
    final String val$table;
    final String val$where;

    public Task then(Task task)
        throws Exception
    {
        return Task.forResult(Integer.valueOf(ParseSQLiteDatabase.access$300(ParseSQLiteDatabase.this).delete(val$table, val$where, val$args)));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    abase()
    {
        this$0 = final_parsesqlitedatabase;
        val$table = s;
        val$where = s1;
        val$args = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
