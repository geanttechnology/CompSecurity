// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseConfig

static final class 
    implements Continuation
{

    public Task then(Task task)
        throws Exception
    {
        return ParseConfig.access$000(task);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
    }
}
