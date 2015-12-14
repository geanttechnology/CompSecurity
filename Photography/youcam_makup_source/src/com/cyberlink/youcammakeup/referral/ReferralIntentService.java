// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.referral;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.cyberlink.youcammakeup.clflurry.b;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.referral:
//            ReferralReceiver

public class ReferralIntentService extends IntentService
{

    public ReferralIntentService()
    {
        super("ReferralIntentService");
    }

    protected void onHandleIntent(Intent intent)
    {
        m.b("ReferralIntentService", "ReferralIntentService::onHandleIntent in");
        Object obj = intent.getExtras();
        if (obj != null)
        {
            obj = ((Bundle) (obj)).getString("referrer");
            if (obj != null && !((String) (obj)).isEmpty())
            {
                m.b("ReferralIntentService", (new StringBuilder()).append("Referrer is: ").append(((String) (obj))).toString());
                b.a(new com.cyberlink.youcammakeup.clflurry.m(((String) (obj))));
            }
        }
        ReferralReceiver.completeWakefulIntent(intent);
        m.b("ReferralIntentService", "ReferralIntentService::onHandleIntent out");
    }
}
