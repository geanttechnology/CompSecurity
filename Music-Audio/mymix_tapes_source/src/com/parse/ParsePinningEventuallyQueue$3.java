// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
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
        return EventuallyPin.findAllPinned().continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls3 this$1;

            public Task then(Task task1)
                throws Exception
            {
                return Task.forResult(Integer.valueOf(((List)task1.getResult()).size()));
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls3.this;
                super();
            }
        });
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.this._cls1()
    {
        this$0 = ParsePinningEventuallyQueue.this;
        super();
    }
}
