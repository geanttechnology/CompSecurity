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
    final JSONObject val$authData;
    final String val$authType;

    public Task then(Task task)
        throws Exception
    {
        return ParseUser.access$1700(ParseUser.this, val$authType, val$authData, task);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parseuser;
        val$authType = s;
        val$authData = JSONObject.this;
        super();
    }
}
