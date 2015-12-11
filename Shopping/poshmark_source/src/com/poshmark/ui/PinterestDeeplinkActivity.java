// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.notifications.PMNotificationManager;

public class PinterestDeeplinkActivity extends Activity
    implements TraceFieldInterface
{

    public PinterestDeeplinkActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PinterestDeeplinkActivity");
        TraceMachine.enterMethod(_nr_trace, "PinterestDeeplinkActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        bundle = new Bundle();
        bundle.putString("PDKCLIENT_EXTRA_RESULT", getIntent().getDataString());
        PMNotificationManager.fireNotification("com.poshmark.intents.PINTEREST_DEEPLINK", bundle);
        setContentView(0x7f030005);
        onBackPressed();
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PinterestDeeplinkActivity#onCreate", null);
          goto _L1
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
