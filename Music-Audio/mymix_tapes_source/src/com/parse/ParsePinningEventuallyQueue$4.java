// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, ParseCommand, ParseObject

class val.tcs
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final ParseCommand val$command;
    final ParseObject val$object;
    final bolts.e val$tcs;

    public Task then(Task task)
        throws Exception
    {
        return ParsePinningEventuallyQueue.access$100(ParsePinningEventuallyQueue.this, val$command, val$object, task, val$tcs);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$command = parsecommand;
        val$object = parseobject;
        val$tcs = bolts.e._cls4.val.tcs.this;
        super();
    }
}
