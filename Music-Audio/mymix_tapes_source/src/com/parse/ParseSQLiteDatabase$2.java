// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.sqlite.SQLiteDatabase;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class this._cls0
    implements Continuation
{

    final ParseSQLiteDatabase this$0;

    public Task then(Task task)
        throws Exception
    {
        ParseSQLiteDatabase.access$302(ParseSQLiteDatabase.this, (SQLiteDatabase)task.getResult());
        return task.makeVoid();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    tabase()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
