// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser, ParseOperationSet, ParseCommand

class 
    implements Continuation
{

    final ParseUser this$0;
    final Capture val$operations;

    public Task then(Task task)
        throws Exception
    {
        val$operations.set(task.getResult());
        return ParseUser.access$1100(ParseUser.this, (ParseOperationSet)val$operations.get()).executeAsync();
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    nSet()
    {
        this$0 = final_parseuser;
        val$operations = Capture.this;
        super();
    }
}
