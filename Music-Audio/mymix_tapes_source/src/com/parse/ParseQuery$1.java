// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseQuery, ParseException

class 
    implements Continuation
{

    final ParseQuery this$0;
    final mmandDelegate val$c;

    public Task then(Task task)
        throws Exception
    {
        Task task1 = task;
        if (task.isFaulted())
        {
            task1 = task;
            if (task.getError() instanceof ParseException)
            {
                task1 = val$c.runOnNetworkAsync(true);
            }
        }
        return task1;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    mmandDelegate()
    {
        this$0 = final_parsequery;
        val$c = mmandDelegate.this;
        super();
    }
}
