// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Intent;
import android.support.v4.b.l;
import com.google.android.gms.iid.InstanceIDListenerService;
import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.push:
//            PushService

public class UAInstanceIDListenerService extends InstanceIDListenerService
{

    public UAInstanceIDListenerService()
    {
    }

    public void onTokenRefresh()
    {
        super.onTokenRefresh();
        Logger.debug("GCM security tokens refreshed.");
        Intent intent = (new Intent(getApplicationContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION").putExtra("com.urbanairship.push.EXTRA_GCM_TOKEN_REFRESH", true);
        l.startWakefulService(getApplicationContext(), intent);
    }
}
