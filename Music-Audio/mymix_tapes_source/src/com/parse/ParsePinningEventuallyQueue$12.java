// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;

// Referenced classes of package com.parse:
//            ParsePinningEventuallyQueue

class val.tcs
    implements Continuation
{

    final ParsePinningEventuallyQueue this$0;
    final bolts. val$tcs;
    final String val$uuid;

    public Task then(Task task)
        throws Exception
    {
        synchronized (ParsePinningEventuallyQueue.access$900(ParsePinningEventuallyQueue.this))
        {
            ParsePinningEventuallyQueue.access$1000(ParsePinningEventuallyQueue.this).remove(val$uuid);
            ParsePinningEventuallyQueue.access$1100(ParsePinningEventuallyQueue.this).remove(val$uuid);
            ParsePinningEventuallyQueue.access$1200(ParsePinningEventuallyQueue.this).remove(val$uuid);
        }
        obj = task.getError();
        if (obj != null)
        {
            val$tcs.tError(((Exception) (obj)));
        } else
        if (task.isCancelled())
        {
            val$tcs.tCancelled();
        } else
        {
            val$tcs.tResult(task.getResult());
        }
        return val$tcs.sk();
        task;
        obj;
        JVM INSTR monitorexit ;
        throw task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parsepinningeventuallyqueue;
        val$uuid = s;
        val$tcs = bolts.._cls12.val.tcs.this;
        super();
    }
}
