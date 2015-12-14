// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue

class this._cls1
    implements Continuation
{

    final then this$1;

    public Task then(Task task)
        throws Exception
    {
        int i = ((Integer)task.getResult()).intValue();
        tcs.ult(Integer.valueOf(i));
        return Task.forResult(null);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    l.tcs()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/ParsePinningEventuallyQueue$2

/* anonymous class */
    class ParsePinningEventuallyQueue._cls2
        implements Continuation
    {

        final ParsePinningEventuallyQueue this$0;
        final bolts.Task.TaskCompletionSource val$tcs;

        public Task then(Task task)
            throws Exception
        {
            return pendingCountAsync(task).continueWithTask(new ParsePinningEventuallyQueue._cls2._cls1());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parsepinningeventuallyqueue;
                tcs = bolts.Task.TaskCompletionSource.this;
                super();
            }
    }

}
