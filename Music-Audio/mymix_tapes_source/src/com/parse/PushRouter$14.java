// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PushRouter

static final class val.result
    implements Continuation
{

    final hListener val$finalListener;
    final JSONObject val$pushData;
    final dlePushResult val$result;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        val$finalListener.onPushHandled(val$pushData, val$result);
        return null;
    }

    dlePushResult(hListener hlistener, JSONObject jsonobject, dlePushResult dlepushresult)
    {
        val$finalListener = hlistener;
        val$pushData = jsonobject;
        val$result = dlepushresult;
        super();
    }
}
