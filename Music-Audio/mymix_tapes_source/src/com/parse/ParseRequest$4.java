// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseRequest

class Source
    implements Continuation
{

    final ParseRequest this$0;
    final bolts.tionSource val$tcs;

    public Task then(Task task)
        throws Exception
    {
        if (task.isCancelled())
        {
            val$tcs.trySetCancelled();
        } else
        if (task.isFaulted())
        {
            val$tcs.trySetError(task.getError());
        } else
        {
            val$tcs.trySetResult(task.getResult());
        }
        return null;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    Source()
    {
        this$0 = final_parserequest;
        val$tcs = bolts.tionSource.this;
        super();
    }
}
