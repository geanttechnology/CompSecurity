// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject

class this._cls0
    implements Continuation
{

    final ParseObject this$0;

    public Task then(Task task)
        throws Exception
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        validateDelete();
        if (ParseObject.access$000(ParseObject.this) == null)
        {
            return null;
        }
        obj;
        JVM INSTR monitorexit ;
        return task;
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
        this$0 = ParseObject.this;
        super();
    }
}
