// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.weibo;

import android.app.Activity;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;

public class QQCallBackActivity extends Activity
{

    public QQCallBackActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c6);
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }
}
