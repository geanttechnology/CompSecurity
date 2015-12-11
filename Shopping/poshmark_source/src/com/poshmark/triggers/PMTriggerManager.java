// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.triggers;

import android.content.Intent;
import android.content.SharedPreferences;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.triggers:
//            BrandShareTrigger, RateAppTrigger

public class PMTriggerManager
    implements PMNotificationListener
{

    private static PMTriggerManager triggerManager;
    BrandShareTrigger brandShareTrigger;
    RateAppTrigger rateAppTrigger;
    SharedPreferences savedTriggers;

    private PMTriggerManager()
    {
        brandShareTrigger = new BrandShareTrigger();
        rateAppTrigger = new RateAppTrigger();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
    }

    public static PMTriggerManager getGlobalTriggerManager()
    {
        com/poshmark/triggers/PMTriggerManager;
        JVM INSTR monitorenter ;
        PMTriggerManager pmtriggermanager;
        if (triggerManager == null)
        {
            triggerManager = new PMTriggerManager();
        }
        pmtriggermanager = triggerManager;
        com/poshmark/triggers/PMTriggerManager;
        JVM INSTR monitorexit ;
        return pmtriggermanager;
        Exception exception;
        exception;
        throw exception;
    }

    public BrandShareTrigger getBrandShareTrigger()
    {
        if (brandShareTrigger != null)
        {
            return brandShareTrigger;
        } else
        {
            return null;
        }
    }

    public RateAppTrigger getRateAppTrigger()
    {
        if (rateAppTrigger != null)
        {
            return rateAppTrigger;
        } else
        {
            return null;
        }
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equalsIgnoreCase("com.poshmark.intents.LOGIN_COMPLETE"))
        {
            brandShareTrigger.fetchTriggerFromPrefs();
            rateAppTrigger.fetchTriggerFromPrefs();
        } else
        if (intent.getAction().equalsIgnoreCase("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            return;
        }
    }
}
