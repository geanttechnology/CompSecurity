// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements Continuation
{

    final boolean val$includeDefaultRoute;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Set then(Task task)
    {
        return PushRouter.access$000().getSubscriptions(val$includeDefaultRoute);
    }

    (boolean flag)
    {
        val$includeDefaultRoute = flag;
        super();
    }
}
