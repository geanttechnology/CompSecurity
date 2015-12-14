// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseConfig, ParseCommand

static final class val.command
    implements Continuation
{

    final ParseCommand val$command;

    public Task then(Task task)
        throws Exception
    {
        return val$command.executeAsync().cast();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    (ParseCommand parsecommand)
    {
        val$command = parsecommand;
        super();
    }
}
