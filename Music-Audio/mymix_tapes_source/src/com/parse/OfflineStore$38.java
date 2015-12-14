// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore

class val.uuid
    implements Continuation
{

    final OfflineStore this$0;
    final Capture val$uuid;

    public Task then(Task task)
        throws Exception
    {
        val$uuid.set(task.getResult());
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$uuid = Capture.this;
        super();
    }
}
