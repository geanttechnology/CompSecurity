// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements Continuation
{

    final ParseUser this$0;
    final String val$authType;
    final JSONObject val$oldAnonymousData;

    public Task then(Task task)
        throws Exception
    {
label0:
        {
            synchronized (mutex)
            {
                if (!task.isFaulted() && !task.isCancelled())
                {
                    break label0;
                }
                ParseUser.access$1200(ParseUser.this, val$oldAnonymousData);
            }
            return task;
        }
        ParseUser.access$1600(ParseUser.this, val$authType);
        obj;
        JVM INSTR monitorexit ;
        return task;
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
        this$0 = final_parseuser;
        val$oldAnonymousData = jsonobject;
        val$authType = String.this;
        super();
    }
}
