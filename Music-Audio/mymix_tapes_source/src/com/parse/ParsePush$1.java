// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParsePush, Parse, PushService

static final class >
    implements Continuation
{

    final boolean val$enabled;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        if (!val$enabled)
        {
            PushService.stopPpnsService(Parse.applicationContext);
        } else
        {
            PushService.startServiceIfRequired(Parse.applicationContext);
        }
        return null;
    }

    (boolean flag)
    {
        val$enabled = flag;
        super();
    }
}
