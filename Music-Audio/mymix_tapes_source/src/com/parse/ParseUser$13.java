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

    public Task then(Task task)
        throws Exception
    {
label0:
        {
            Task task1;
            synchronized (mutex)
            {
                if (!ParseUser.access$900(ParseUser.this).has(val$authType))
                {
                    break label0;
                }
                ParseUser.access$900(ParseUser.this).put(val$authType, JSONObject.NULL);
                ParseUser.access$502(ParseUser.this, true);
                task1 = saveInBackground();
            }
            return task1;
        }
        Task task2 = Task.forResult(null);
        task;
        JVM INSTR monitorexit ;
        return task2;
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
        this$0 = final_parseuser;
        val$authType = String.this;
        super();
    }
}
