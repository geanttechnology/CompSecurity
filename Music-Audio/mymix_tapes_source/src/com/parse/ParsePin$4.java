// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParsePin, OfflineStore

static final class e
    implements Continuation
{

    public Task then(Task task)
        throws Exception
    {
        if (task.isFaulted())
        {
            return task.makeVoid();
        } else
        {
            task = (ParsePin)task.getResult();
            return OfflineStore.getCurrent().unpinAsync(task);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    e()
    {
    }
}
