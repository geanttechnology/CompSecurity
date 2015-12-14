// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseInstallation

class val.toAwait
    implements Continuation
{

    final ParseInstallation this$0;
    final Task val$toAwait;

    public Task then(Task task)
        throws Exception
    {
        return ParseInstallation.access$001(ParseInstallation.this, val$toAwait);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parseinstallation;
        val$toAwait = Task.this;
        super();
    }
}
