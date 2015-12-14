// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseRequest, ProgressCallback

class k
    implements Continuation
{

    final ParseRequest this$0;
    final ProgressCallback val$progressCallback;

    public Task then(Task task)
        throws Exception
    {
        long l = ParseRequest.access$200();
        long l1 = (long)((double)ParseRequest.access$200() * Math.random());
        if (ParseRequest.access$000(ParseRequest.this) == null)
        {
            ParseRequest.access$002(ParseRequest.this, newRequest());
        }
        return ParseRequest.access$300(ParseRequest.this, 0, l + l1, val$progressCallback);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    k()
    {
        this$0 = final_parserequest;
        val$progressCallback = ProgressCallback.this;
        super();
    }
}
