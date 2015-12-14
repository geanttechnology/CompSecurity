// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseCommandCache

class val.finished
    implements Continuation
{

    final ParseCommandCache this$0;
    final Capture val$finished;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        val$finished.set(Boolean.valueOf(true));
        synchronized (ParseCommandCache.access$100())
        {
            ParseCommandCache.access$100().notifyAll();
        }
        return null;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_parsecommandcache;
        val$finished = Capture.this;
        super();
    }
}
