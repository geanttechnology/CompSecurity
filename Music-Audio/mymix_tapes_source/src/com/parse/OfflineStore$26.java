// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore

class this._cls0
    implements Continuation
{

    final OfflineStore this$0;

    public Task then(Task task)
        throws Exception
    {
        task = (String)task.getResult();
        if (task == null)
        {
            return Task.forResult(null);
        } else
        {
            return OfflineStore.access$1000(OfflineStore.this, task);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = OfflineStore.this;
        super();
    }
}
