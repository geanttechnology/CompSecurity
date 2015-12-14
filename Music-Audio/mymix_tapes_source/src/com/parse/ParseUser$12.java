// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser

static final class 
    implements Continuation
{

    final ParseUser val$user;

    public ParseUser then(Task task)
        throws Exception
    {
        Object obj = ParseUser.access$600();
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (!task.isFaulted())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ParseUser.access$702(flag);
        ParseUser.access$802(val$user);
        obj;
        JVM INSTR monitorexit ;
        return val$user;
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

    (ParseUser parseuser)
    {
        val$user = parseuser;
        super();
    }
}
