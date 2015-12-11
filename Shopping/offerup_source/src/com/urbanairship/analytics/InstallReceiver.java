// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;

// Referenced classes of package com.urbanairship.analytics:
//            InstallAttributionEvent, Analytics

public class InstallReceiver extends BroadcastReceiver
{

    private static final String ACTION_INSTALL_REFERRER = "com.android.vending.INSTALL_REFERRER";
    private static final String EXTRA_INSTALL_REFERRER = "referrer";

    public InstallReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Autopilot.automaticTakeOff(context);
        if (!UAirship.isTakingOff() && !UAirship.isFlying())
        {
            Logger.error("InstallReceiver - unable to track install referrer, takeOff not called.");
            return;
        }
        context = intent.getStringExtra("referrer");
        if (UAStringUtil.isEmpty(context) || !"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            Logger.debug("InstallReceiver - missing referrer or invalid action.");
            return;
        } else
        {
            context = new InstallAttributionEvent(context);
            UAirship.shared().getAnalytics().addEvent(context);
            return;
        }
    }
}
