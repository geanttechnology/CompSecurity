// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

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
        synchronized (ParseSQLiteDatabase.access$000(ParseSQLiteDatabase.this))
        {
            ParseSQLiteDatabase.access$102(ParseSQLiteDatabase.this, task);
        }
        return ParseSQLiteDatabase.access$200(ParseSQLiteDatabase.this).getTask();
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
