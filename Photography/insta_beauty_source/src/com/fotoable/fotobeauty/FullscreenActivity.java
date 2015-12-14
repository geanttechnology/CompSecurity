// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;

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
    }

    public void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    public void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }
}
