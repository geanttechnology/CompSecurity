// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseObject, Parse, ParseEventuallyQueue, ParseCommand

class val.command
    implements Continuation
{

    final ParseObject this$0;
    final ParseCommand val$command;

    public Task then(Task task)
        throws Exception
    {
        return Parse.getEventuallyQueue().enqueueEventuallyAsync(val$command, ParseObject.this);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    Queue()
    {
        this$0 = final_parseobject;
        val$command = ParseCommand.this;
        super();
    }
}
