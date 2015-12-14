// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class val.conflictAlgorithm
    implements Continuation
{

    final ParseSQLiteDatabase this$0;
    final int val$conflictAlgorithm;
    final String val$table;
    final ContentValues val$values;

    public Task then(Task task)
        throws Exception
    {
        return Task.forResult(Long.valueOf(ParseSQLiteDatabase.access$300(ParseSQLiteDatabase.this).insertWithOnConflict(val$table, null, val$values, val$conflictAlgorithm)));
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
        val$values = contentvalues;
        val$conflictAlgorithm = I.this;
        super();
    }
}
