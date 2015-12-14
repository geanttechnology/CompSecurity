// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            OfflineStore, ParseException

class this._cls0
    implements Continuation
{

    final OfflineStore this$0;

    public Task then(Task task)
        throws Exception
    {
        Task task1 = task;
        if (task.isFaulted())
        {
            task1 = task;
            if (task.getError() instanceof ParseException)
            {
                task1 = task;
                if (((ParseException)task.getError()).getCode() == 120)
                {
                    task1 = Task.forResult(null);
                }
            }
        }
        return task1;
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
