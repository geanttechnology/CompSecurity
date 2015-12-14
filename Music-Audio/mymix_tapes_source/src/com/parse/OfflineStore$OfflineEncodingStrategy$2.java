// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineStore

class val.result
    implements Continuation
{

    final val.result this$1;
    final JSONObject val$result;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        val$result.put("uuid", task.getResult());
        return null;
    }

    ()
    {
        this$1 = final_;
        val$result = JSONObject.this;
        super();
    }
}
