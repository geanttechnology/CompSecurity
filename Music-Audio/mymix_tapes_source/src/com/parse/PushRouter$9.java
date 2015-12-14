// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PushRouter

static final class 
    implements Continuation
{

    final JSONObject val$pushPayload;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        if (val$pushPayload != null)
        {
            PushRouter.access$000().handlePpnsPush(val$pushPayload);
        }
        return null;
    }

    (JSONObject jsonobject)
    {
        val$pushPayload = jsonobject;
        super();
    }
}
