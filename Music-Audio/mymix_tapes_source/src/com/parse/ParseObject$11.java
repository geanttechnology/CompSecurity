// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject

class val.sessionToken
    implements Continuation
{

    final ParseObject this$0;
    final String val$sessionToken;

    public Task then(Task task)
        throws Exception
    {
        Task task1;
        synchronized (mutex)
        {
            task1 = ParseObject.access$400(ParseObject.access$300(ParseObject.this), val$sessionToken);
        }
        return task1;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parseobject;
        val$sessionToken = String.this;
        super();
    }
}
