// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser, ParseException

static final class 
    implements Continuation
{

    final Continuation val$logInWithTask;
    final ParseUser val$user;

    public Task then(Task task)
        throws Exception
    {
        if (task.isFaulted())
        {
            Exception exception = task.getError();
            if ((exception instanceof ParseException) && ((ParseException)exception).getCode() == 208)
            {
                return Task.forResult(null).continueWithTask(val$logInWithTask);
            }
        }
        if (task.isCancelled())
        {
            return Task.cancelled();
        } else
        {
            return Task.forResult(val$user);
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    n(Continuation continuation, ParseUser parseuser)
    {
        val$logInWithTask = continuation;
        val$user = parseuser;
        super();
    }
}
