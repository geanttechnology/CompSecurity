// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushService, Parse

static final class 
    implements Continuation
{

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        if (((Set)task.getResult()).size() == 0)
        {
            PushService.stopPpnsService(Parse.applicationContext);
        }
        return null;
    }

    ()
    {
    }
}
