// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Set;

// Referenced classes of package com.parse:
//            PushService, ManifestInfo, PLog, ParseInstallation, 
//            PushConnection

class 
    implements ct
{

    final PushService this$0;
    final PushConnection val$conn;
    final cs val$forceEnabledCapture;

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    public Void then(cu cu1)
        throws Exception
    {
        Boolean boolean1;
        boolean flag;
        boolean1 = (Boolean)val$forceEnabledCapture.a();
        flag = ManifestInfo.getPushUsesBroadcastReceivers();
        cu1 = (Set)cu1.e();
        if (flag) goto _L2; else goto _L1
_L1:
        if (cu1 == null || cu1.size() != 0) goto _L4; else goto _L3
_L3:
        cu1 = "Not starting PushService because this device has no subscriptions";
_L6:
        if (cu1 != null)
        {
            PLog.i("com.parse.PushService", cu1);
            stopSelf();
            return null;
        } else
        {
            PLog.d("com.parse.PushService", "Starting PushService.");
            val$conn.start();
            return null;
        }
_L2:
        if (ParseInstallation.getCurrentInstallation().getObjectId() == null)
        {
            cu1 = "Not starting PushService because this device is not registered for push notifications.";
            continue; /* Loop/switch isn't completed */
        }
        if (boolean1 != null && !boolean1.booleanValue())
        {
            cu1 = "Not starting PushService because push has been manually disabled.";
            continue; /* Loop/switch isn't completed */
        }
_L4:
        cu1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        this$0 = final_pushservice;
        val$forceEnabledCapture = cs1;
        val$conn = PushConnection.this;
        super();
    }
}
