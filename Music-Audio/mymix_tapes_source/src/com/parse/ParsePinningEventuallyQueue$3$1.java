// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue, EventuallyPin

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        return Task.forResult(Integer.valueOf(((List)task.getResult()).size()));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$3

/* anonymous class */
    class ParsePinningEventuallyQueue._cls3
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;

        public Task then(Task task)
            throws Exception
        {
            return EventuallyPin.findAllPinned().continueWithTask(new ParsePinningEventuallyQueue._cls3._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }

}
