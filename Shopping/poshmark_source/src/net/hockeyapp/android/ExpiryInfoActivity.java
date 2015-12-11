// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import net.hockeyapp.android.views.ExpiryInfoView;

// Referenced classes of package net.hockeyapp.android:
//            UpdateManager, Strings

public class ExpiryInfoActivity extends Activity
    implements TraceFieldInterface
{

    public ExpiryInfoActivity()
    {
    }

    protected View getLayoutView()
    {
        return new ExpiryInfoView(this, getStringResource(14));
    }

    protected String getStringResource(int i)
    {
        return Strings.get(UpdateManager.getLastListener(), i);
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("ExpiryInfoActivity");
        TraceMachine.enterMethod(_nr_trace, "ExpiryInfoActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        setTitle(getStringResource(13));
        setContentView(getLayoutView());
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "ExpiryInfoActivity#onCreate", null);
          goto _L1
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
