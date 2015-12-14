// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseInstallation

static final class val.installation
    implements Continuation
{

    final ParseInstallation val$installation;

    public Task then(Task task)
        throws Exception
    {
        ParseInstallation.access$200(val$installation);
        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (ParseInstallation parseinstallation)
    {
        val$installation = parseinstallation;
        super();
    }
}
