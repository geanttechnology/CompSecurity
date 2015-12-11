// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.bl;
import com.google.android.gms.b.bn;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

public class InAppPurchaseActivity extends Activity
    implements TraceFieldInterface
{

    private bl a;

    public InAppPurchaseActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        try
        {
            if (a != null)
            {
                a.a(i, j, intent);
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onActivityResult to in-app purchase manager:", remoteexception);
        }
        super.onActivityResult(i, j, intent);
    }

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("InAppPurchaseActivity");
        TraceMachine.enterMethod(_nr_trace, "InAppPurchaseActivity#onCreate", null);
_L2:
        super.onCreate(bundle);
        a = bn.a(this);
        if (a == null)
        {
            b.e("Could not create in-app purchase manager.");
            finish();
            TraceMachine.exitMethod();
            return;
        }
        break; /* Loop/switch isn't completed */
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "InAppPurchaseActivity#onCreate", null);
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            a.a();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            b.c("Could not forward onCreate to in-app purchase manager:", bundle);
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
                a.b();
            }
        }
        catch (RemoteException remoteexception)
        {
            b.c("Could not forward onDestroy to in-app purchase manager:", remoteexception);
        }
        super.onDestroy();
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
