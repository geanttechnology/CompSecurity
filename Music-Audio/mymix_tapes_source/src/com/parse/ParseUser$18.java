// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, ParseObject

class 
    implements Continuation
{

    final ParseUser this$0;

    public Task then(Task task)
        throws Exception
    {
        Object obj = (JSONObject)task.getResult();
        task = ((Task) (mutex));
        task;
        JVM INSTR monitorenter ;
        ParseUser.access$502(ParseUser.this, false);
        if (!((JSONObject) (obj)).optBoolean("is_new"))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        ParseUser.access$1502(ParseUser.this, false);
        obj = Task.forResult(ParseUser.this);
        return ((Task) (obj));
        task;
        JVM INSTR monitorexit ;
        return ParseUser.access$100((ParseUser)ParseObject.fromJSON(((JSONObject) (obj)), "_User", true));
        Exception exception;
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
