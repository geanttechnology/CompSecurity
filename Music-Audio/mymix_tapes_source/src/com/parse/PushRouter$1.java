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
    final Class val$cls;
    final int val$iconId;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        PushRouter.access$000().subscribe(val$channel, val$cls, val$iconId);
        return null;
    }

    (String s, Class class1, int i)
    {
        val$channel = s;
        val$cls = class1;
        val$iconId = i;
        super();
    }
}
