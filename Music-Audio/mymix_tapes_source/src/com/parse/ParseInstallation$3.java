// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseInstallation, Parse, PushService

class this._cls0
    implements Continuation
{

    final ParseInstallation this$0;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        task = (Boolean)task.getResult();
        if (task == null || task.booleanValue())
        {
            PushService.startServiceIfRequired(Parse.applicationContext);
        }
        return null;
    }

    ()
    {
        this$0 = ParseInstallation.this;
        super();
    }
}
