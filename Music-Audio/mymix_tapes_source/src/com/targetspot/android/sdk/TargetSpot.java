// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;

import android.content.Context;
import com.targetspot.android.sdk.service.AdManager;

// Referenced classes of package com.targetspot.android.sdk:
//            AdSettings, AdClient

public class TargetSpot
{

    private TargetSpot()
    {
    }

    public static AdSettings getAdSettings()
    {
        return AdManager.getInstance().getAdSettings();
    }

    public static AdClient getClient(int i)
    {
        return AdManager.getInstance().getClient(i);
    }

    public static boolean isActive()
    {
        return AdManager.isActive();
    }

    public static void startAdSession(Context context, AdSettings adsettings)
    {
        AdManager.getInstance().startAdSession(context, adsettings);
    }

    public static void stopAdSession()
    {
        AdManager.getInstance().stopAdSession();
    }
}
