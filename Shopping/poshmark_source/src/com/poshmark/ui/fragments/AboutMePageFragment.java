// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment

public class AboutMePageFragment extends MappPageFragment
    implements PMNotificationListener
{

    public AboutMePageFragment()
    {
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.PROFILE_UPDATED"))
        {
            fireJSCallback("pmapp_profile_updated()");
        } else
        if (intent.getAction().equals("com.poshmark.intents.BRAND_FOLLOW_STATUS_CHANGED"))
        {
            fireJSCallback("pmapp_following_brands_updated()");
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PROFILE_UPDATED", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.BRAND_FOLLOW_STATUS_CHANGED", this);
    }
}
