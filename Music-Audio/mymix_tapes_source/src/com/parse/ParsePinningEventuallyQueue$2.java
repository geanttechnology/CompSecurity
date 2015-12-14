// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue

class val.tcs
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final bolts.e val$tcs;

    public Task then(Task task)
        throws Exception
    {
        return pendingCountAsync(task).continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue._cls2 this$1;

            public Task then(Task task1)
                throws Exception
            {
                int i = ((Integer)task1.getResult()).intValue();
                tcs.setResult(Integer.valueOf(i));
                return Task.forResult(null);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$1 = ParsePinningEventuallyQueue._cls2.this;
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
        this$0 = final_parsepinningeventuallyqueue;
        val$tcs = bolts.e._cls2.val.tcs.this;
        super();
    }
}
