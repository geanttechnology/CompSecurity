// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject

class val.object
    implements Continuation
{

    final OfflineStore this$0;
    final ParseObject val$object;
    final bolts.ionSource val$tcs;

    public Task then(Task task)
        throws Exception
    {
        if (task.isCancelled())
        {
            val$tcs.setCancelled();
        } else
        if (task.isFaulted())
        {
            val$tcs.setError(task.getError());
        } else
        {
            val$tcs.setResult(val$object);
        }
        return val$tcs.getTask();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ource()
    {
        this$0 = final_offlinestore;
        val$tcs = ionsource;
        val$object = ParseObject.this;
        super();
    }
}
