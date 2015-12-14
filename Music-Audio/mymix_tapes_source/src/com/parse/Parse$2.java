// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            Parse, ParseInstallation, ParseConfig

static final class n
    implements Continuation
{

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        ParseInstallation.getCurrentInstallation();
        ParseConfig.getCurrentConfig();
        return null;
    }

    n()
    {
    }
}
