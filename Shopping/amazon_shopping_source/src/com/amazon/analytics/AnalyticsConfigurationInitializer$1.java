// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import com.amazon.device.analytics.log.Logger;

// Referenced classes of package com.amazon.analytics:
//            AnalyticsConfigurationInitializer, AnalyticsConfiguration

class ngProcessPollInterval
    implements ConfigurationChangedListener
{

    BroadcastReceiver currentReceiver;
    final AnalyticsConfigurationInitializer this$0;

    public void onPropertyChanged(String s, Object obj)
    {
        if (obj == null) goto _L2; else goto _L1
_L1:
        int i;
        try
        {
            i = Integer.parseInt(obj.toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AnalyticsConfigurationInitializer.access$100().e("RunningProcessPollInterval is not a number", s);
            return;
        }
        this;
        JVM INSTR monitorenter ;
        AnalyticsConfigurationInitializer.access$200(AnalyticsConfigurationInitializer.this).unregisterReceiver(currentReceiver);
        currentReceiver = setUpPackageCheckMonitor(i);
        this;
        JVM INSTR monitorexit ;
_L2:
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    angedListener()
    {
        this$0 = AnalyticsConfigurationInitializer.this;
        super();
        currentReceiver = setUpPackageCheckMonitor(AnalyticsConfigurationInitializer.access$000(AnalyticsConfigurationInitializer.this).getInt(ngProcessPollInterval));
    }
}
