// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.urbanairship:
//            Autopilot, Logger, CoreReceiver

public class CoreActivity extends Activity
{

    public CoreActivity()
    {
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Autopilot.automaticTakeOff(getApplication());
        bundle = getIntent();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        Logger.verbose((new StringBuilder("CoreActivity - Received intent: ")).append(bundle.getAction()).toString());
        if (!"com.urbanairship.ACTION_NOTIFICATION_OPENED_PROXY".equals(bundle.getAction())) goto _L4; else goto _L3
_L3:
        CoreReceiver.handleNotificationOpenedProxy(this, bundle);
_L2:
        finish();
        return;
_L4:
        if ("com.urbanairship.ACTION_NOTIFICATION_BUTTON_OPENED_PROXY".equals(bundle.getAction()))
        {
            CoreReceiver.handleNotificationButtonOpenedProxy(this, bundle);
        } else
        if ("com.urbanairship.ACTION_CHANNEL_CAPTURE".equals(bundle.getAction()))
        {
            CoreReceiver.handleChannelCapture(this, bundle);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
