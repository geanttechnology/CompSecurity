// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            EventuallyPin

static final class val.pin
    implements Continuation
{

    final EventuallyPin val$pin;

    public EventuallyPin then(Task task)
        throws Exception
    {
        return val$pin;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (EventuallyPin eventuallypin)
    {
        val$pin = eventuallypin;
        super();
    }
}
