// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls0
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;

    public Task then(Task task)
        throws Exception
    {
        EventuallyPin eventuallypin;
        for (Iterator iterator = ((List)task.getResult()).iterator(); iterator.hasNext(); ParsePinningEventuallyQueue.access$500(ParsePinningEventuallyQueue.this, eventuallypin))
        {
            eventuallypin = (EventuallyPin)iterator.next();
        }

        return task.makeVoid();
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
