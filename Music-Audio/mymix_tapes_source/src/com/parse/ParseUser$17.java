// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements Continuation
{

    final ParseUser this$0;

    public ParseUser then(Task task)
        throws Exception
    {
        ParseUser parseuser;
        synchronized (mutex)
        {
            ParseUser.access$1502(ParseUser.this, false);
            parseuser = ParseUser.this;
        }
        return parseuser;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = ParseUser.this;
        super();
    }
}
