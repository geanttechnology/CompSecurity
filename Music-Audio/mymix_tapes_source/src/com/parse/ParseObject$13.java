// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet

class et
    implements Continuation
{

    final ParseObject this$0;
    final ParseOperationSet val$operationSet;

    public Task then(Task task)
        throws Exception
    {
        task = (JSONObject)task.getResult();
        return handleSaveEventuallyResultAsync(task, val$operationSet);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    et()
    {
        this$0 = final_parseobject;
        val$operationSet = ParseOperationSet.this;
        super();
    }
}
