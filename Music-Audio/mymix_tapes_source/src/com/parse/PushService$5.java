// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushService, ManifestInfo, Parse, ParseInstallation, 
//            PushConnection

class 
    implements Continuation
{

    final PushService this$0;
    final PushConnection val$conn;
    final Capture val$forceEnabledCapture;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        Boolean boolean1 = (Boolean)val$forceEnabledCapture.get();
        boolean flag = ManifestInfo.getPushUsesBroadcastReceivers();
        Set set = (Set)task.getResult();
        Object obj = null;
        if (!flag)
        {
            task = obj;
            if (set != null)
            {
                task = obj;
                if (set.size() == 0)
                {
                    task = "Not starting PushService because this device has no subscriptions";
                }
            }
        } else
        if (ParseInstallation.getCurrentInstallation().getObjectId() == null)
        {
            task = "Not starting PushService because this device is not registered for push notifications.";
        } else
        {
            task = obj;
            if (boolean1 != null)
            {
                task = obj;
                if (!boolean1.booleanValue())
                {
                    task = "Not starting PushService because push has been manually disabled.";
                }
            }
        }
        if (task != null)
        {
            Parse.logI("com.parse.PushService", task);
            stopSelf();
        } else
        {
            Parse.logD("com.parse.PushService", "Starting PushService.");
            val$conn.start();
        }
        return null;
    }

    ()
    {
        this$0 = final_pushservice;
        val$forceEnabledCapture = capture;
        val$conn = PushConnection.this;
        super();
    }
}
