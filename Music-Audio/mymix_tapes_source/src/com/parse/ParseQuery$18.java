// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseQuery

class this._cls0
    implements Continuation
{

    final ParseQuery this$0;

    public Integer then(Task task)
        throws Exception
    {
        return Integer.valueOf(((JSONObject)task.getResult()).optInt("count"));
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = ParseQuery.this;
        super();
    }
}
