// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.unity3d.ads.android.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import com.unity3d.ads.android.UnityAds;
import com.unity3d.ads.android.UnityAdsDeviceLog;

public class UnityAdsFullscreenActivity extends Activity
{

    public UnityAdsFullscreenActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        UnityAdsDeviceLog.entered();
        super.onCreate(bundle);
        UnityAds.changeActivity(this);
    }

    protected void onDestroy()
    {
        UnityAdsDeviceLog.entered();
        super.onDestroy();
        UnityAds.handleFullscreenDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return false;
    }

    public void onPause()
    {
        UnityAdsDeviceLog.entered();
        super.onPause();
    }

    public void onRestart()
    {
        UnityAdsDeviceLog.entered();
        super.onRestart();
    }

    public void onResume()
    {
        UnityAdsDeviceLog.entered();
        super.onResume();
        UnityAds.changeActivity(this);
        UnityAds.checkMainview();
    }

    public void onStart()
    {
        UnityAdsDeviceLog.entered();
        super.onStart();
    }

    public void onStop()
    {
        UnityAdsDeviceLog.entered();
        super.onStop();
    }
}
