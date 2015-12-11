// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import com.databerries.DataBerries;
import com.digidust.elokence.akinator.activities.SplashscreenActivity;

public class SplashScreenProcessing
{

    private SplashscreenActivity activity;

    public SplashScreenProcessing(SplashscreenActivity splashscreenactivity)
    {
        activity = splashscreenactivity;
    }

    public boolean initDataBerries()
    {
        if (android.os.Build.VERSION.SDK_INT >= 15 && !DataBerries.checkLocationPermission(activity).booleanValue())
        {
            DataBerries.initialize(activity);
            return false;
        } else
        {
            return true;
        }
    }

    public void initDataBerriesPermissions(int i, String as[], int ai[])
    {
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            DataBerries.onRequestPermissionsResult(i, as, ai);
        }
    }
}
