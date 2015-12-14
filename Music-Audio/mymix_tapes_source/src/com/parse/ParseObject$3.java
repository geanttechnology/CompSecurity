// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject

static final class val.readyToStart
    implements Continuation
{

    final bolts.etionSource val$readyToStart;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        val$readyToStart.setResult(null);
        return null;
    }

    nSource(bolts.etionSource etionsource)
    {
        val$readyToStart = etionsource;
        super();
    }
}
