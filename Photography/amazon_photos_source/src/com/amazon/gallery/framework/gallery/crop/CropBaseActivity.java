// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.crop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

public class CropBaseActivity extends Activity
{

    private ComponentProfiler profiler;

    public CropBaseActivity()
    {
    }

    protected ComponentProfiler getProfiler()
    {
        return profiler;
    }

    protected void logLaunchSource()
    {
        String s;
        LaunchSourceMetrics launchsourcemetrics;
        byte byte0;
        byte0 = 0;
        s = getIntent().getAction();
        launchsourcemetrics = (LaunchSourceMetrics)ThorGalleryApplication.getBean(Keys.LAUNCH_SOURCE_PROFILER);
        if (getIntent().getBooleanExtra("EXTRA_CROP_INTERNAL", false))
        {
            return;
        }
        s.hashCode();
        JVM INSTR lookupswitch 3: default 72
    //                   -1401676846: 109
    //                   -1329926037: 135
    //                   -526840448: 121;
           goto _L1 _L2 _L3 _L4
_L1:
        byte0 = -1;
          goto _L5
_L2:
        if (!s.equals("android.service.wallpaper.CROP_AND_SET_WALLPAPER")) goto _L1; else goto _L5
_L4:
        if (!s.equals("android.intent.action.SET_WALLPAPER")) goto _L1; else goto _L6
_L6:
        byte0 = 1;
          goto _L5
_L3:
        if (!s.equals("com.android.camera.action.CROP")) goto _L1; else goto _L7
_L7:
        byte0 = 2;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            launchsourcemetrics.trackEvent(com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics.MetricsEvent.WallpaperSetAndCrop);
            return;

        case 1: // '\001'
            launchsourcemetrics.trackEvent(com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics.MetricsEvent.WallpaperPicker);
            return;

        case 2: // '\002'
            launchsourcemetrics.trackEvent(com.amazon.gallery.framework.kindle.activity.LaunchSourceMetrics.MetricsEvent.Crop);
            break;
        }
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        profiler = new ComponentProfiler((Profiler)ThorGalleryApplication.getBean(Keys.PROFILER), getClass());
    }

    protected void onResume()
    {
        super.onResume();
        logLaunchSource();
    }
}
