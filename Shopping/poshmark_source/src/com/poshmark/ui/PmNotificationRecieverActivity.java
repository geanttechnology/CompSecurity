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
import com.poshmark.application.PMApplication;

// Referenced classes of package com.poshmark.ui:
//            MainActivity

public class PmNotificationRecieverActivity extends Activity
    implements TraceFieldInterface
{

    public PmNotificationRecieverActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PmNotificationRecieverActivity");
        TraceMachine.enterMethod(_nr_trace, "PmNotificationRecieverActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        PMApplication.getApplicationObject().getTopActivity();
        bundle = getIntent();
        Bundle bundle1 = bundle.getBundleExtra("NOTIFICATION_BUNDLE");
        if (bundle1 != null)
        {
            Intent intent = new Intent(this, com/poshmark/ui/MainActivity);
            intent.putExtra("NOTIFICATION_BUNDLE", bundle1);
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(0x24000000);
            startActivity(intent);
        }
        removeStickyBroadcast(bundle);
        finish();
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PmNotificationRecieverActivity#onCreate", null);
          goto _L1
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
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
