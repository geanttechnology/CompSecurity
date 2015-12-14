// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteOpenHelper, ParseSQLiteDatabase

class val.db
    implements Continuation
{

    final ParseSQLiteOpenHelper this$0;
    final ParseSQLiteDatabase val$db;

    public Task then(Task task)
        throws Exception
    {
        return val$db.open(ParseSQLiteOpenHelper.access$000(ParseSQLiteOpenHelper.this));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parsesqliteopenhelper;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
