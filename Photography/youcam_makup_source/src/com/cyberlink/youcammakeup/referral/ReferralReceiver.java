// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.kochava.android.tracker.ReferralCapture;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.referral:
//            ReferralIntentService

public class ReferralReceiver extends WakefulBroadcastReceiver
{

    public ReferralReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getExtras().getString("referrer");
        m.b("ReferralReceiver", (new StringBuilder()).append("Referrer is: ").append(s).toString());
        (new ReferralCapture()).onReceive(context, intent);
        startWakefulService(context, intent.setComponent(new ComponentName(context.getPackageName(), com/cyberlink/youcammakeup/referral/ReferralIntentService.getName())));
        setResultCode(-1);
    }
}
