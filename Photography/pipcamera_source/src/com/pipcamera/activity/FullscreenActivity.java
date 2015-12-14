// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Window;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.pipcamera.application.PIPCameraApplication;

public class FullscreenActivity extends FragmentActivity
{

    public FullscreenActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
    }

    public void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
    }

    public void onStart()
    {
        super.onStart();
        Log.e("FullScreenActivity", FlurryAgent.getReleaseVersion());
        FlurryAgent.onStartSession(this, PIPCameraApplication.h);
        ApplicationState.checkAppStateAfterOnStart();
    }

    public void onStop()
    {
        ApplicationState.checkAppStateAfterOnStop();
        super.onStop();
        FlurryAgent.onEndSession(this);
    }
}
