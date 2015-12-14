// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseInstallation, ParseObject

static final class 
    implements Continuation
{

    public Task then(Task task)
        throws Exception
    {
        task = (List)task.getResult();
        if (task != null)
        {
            if (task.size() == 1)
            {
                return Task.forResult(task.get(0));
            } else
            {
                return ParseObject.unpinAllInBackground("_currentInstallation").cast();
            }
        } else
        {
            return Task.forResult(null);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
    }
}
