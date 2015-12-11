// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.bg;
import com.google.android.gms.b.bh;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

public class AdActivity extends Activity
    implements TraceFieldInterface
{

    private bh a;

    public AdActivity()
    {
    }

    private void a()
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        a.l();
        return;
        RemoteException remoteexception;
        remoteexception;
        b.c("Could not forward setContentViewSet to ad overlay:", remoteexception);
        return;
    }

    public void onBackPressed()
    {
        try
        {
            if (a != null)
            {
                a.e();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onBackPressed to ad overlay:", remoteexception);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("AdActivity");
        TraceMachine.enterMethod(_nr_trace, "AdActivity#onCreate", null);
_L2:
        super.onCreate(bundle);
        a = bg.a(this);
        if (a == null)
        {
            b.e("Could not create ad overlay.");
            finish();
            TraceMachine.exitMethod();
            return;
        }
        break; /* Loop/switch isn't completed */
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "AdActivity#onCreate", null);
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            a.a(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            b.c("Could not forward onCreate to ad overlay:", bundle);
            finish();
        }
        TraceMachine.exitMethod();
        return;
    }

    protected void onDestroy()
    {
        try
        {
            if (a != null)
            {
                a.k();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onDestroy to ad overlay:", remoteexception);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            if (a != null)
            {
                a.i();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onPause to ad overlay:", remoteexception);
            finish();
        }
        super.onPause();
    }

    protected void onRestart()
    {
        super.onRestart();
        try
        {
            if (a != null)
            {
                a.f();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onRestart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            if (a != null)
            {
                a.h();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onResume to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            if (a != null)
            {
                a.b(bundle);
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onSaveInstanceState to ad overlay:", remoteexception);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        try
        {
            if (a != null)
            {
                a.g();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onStart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        try
        {
            if (a != null)
            {
                a.j();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onStop to ad overlay:", remoteexception);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        a();
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        a();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        a();
    }
}
