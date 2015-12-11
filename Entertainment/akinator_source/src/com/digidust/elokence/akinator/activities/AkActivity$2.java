// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class counterInactivity extends TimerTask
{

    private int counterInactivity;
    final AkActivity this$0;

    public void run()
    {
        if (AkActivity.nbActivities == 0)
        {
            counterInactivity = counterInactivity + 1;
        } else
        {
            counterInactivity = 0;
        }
        if (AkConfigFactory.sharedInstance().canSendAnalytics() && counterInactivity >= 2)
        {
            AkLog.d("Akinator", "Send Push");
            AkActivity.access$000().cancel();
            Timer _tmp = AkActivity.access$002(null);
            cancel();
            AkActivity.access$100(AkActivity.this);
        }
    }

    y()
    {
        this$0 = AkActivity.this;
        super();
        counterInactivity = 0;
    }
}
