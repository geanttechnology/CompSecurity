// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls0
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;

    public Task then(Task task)
        throws Exception
    {
        return EventuallyPin.findAllPinned(ParsePinningEventuallyQueue.access$600(ParsePinningEventuallyQueue.this));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
