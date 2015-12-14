// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            PushRouter, PushRoutes

static final class 
    implements Continuation
{

    final String val$channel;

    public ute then(Task task)
        throws Exception
    {
        ute ute = PushRouter.access$200(PushRouter.access$000()).get(val$channel);
        task = ute;
        if (ute == null)
        {
            task = ute;
            if (val$channel != null)
            {
                task = PushRouter.access$200(PushRouter.access$000()).get(null);
            }
        }
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ute(String s)
    {
        val$channel = s;
        super();
    }
}
