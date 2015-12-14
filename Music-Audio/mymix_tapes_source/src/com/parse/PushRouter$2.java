// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements Continuation
{

    final String val$channel;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        PushRouter.access$000().unsubscribe(val$channel);
        return null;
    }

    (String s)
    {
        val$channel = s;
        super();
    }
}
