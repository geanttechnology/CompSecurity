// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.qw;
import android.support.v7.qx;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

public class AdActivity extends Activity
    implements TraceFieldInterface
{

    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private qx zznJ;

    public AdActivity()
    {
    }

    private void zzaE()
    {
        if (zznJ == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        zznJ.zzaE();
        return;
        RemoteException remoteexception;
        remoteexception;
        zzb.zzd("Could not forward setContentViewSet to ad overlay:", remoteexception);
        return;
    }

    public void onBackPressed()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        try
        {
            if (zznJ != null)
            {
                flag = zznJ.zzez();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", remoteexception);
            flag = flag1;
        }
        if (flag)
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("AdActivity");
        TraceMachine.enterMethod(_nr_trace, "AdActivity#onCreate", null);
_L2:
        super.onCreate(bundle);
        zznJ = qw.a(this);
        if (zznJ == null)
        {
            zzb.zzaE("Could not create ad overlay.");
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
            zznJ.onCreate(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            zzb.zzd("Could not forward onCreate to ad overlay:", bundle);
            finish();
        }
        TraceMachine.exitMethod();
        return;
    }

    protected void onDestroy()
    {
        try
        {
            if (zznJ != null)
            {
                zznJ.onDestroy();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onDestroy to ad overlay:", remoteexception);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            if (zznJ != null)
            {
                zznJ.onPause();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onPause to ad overlay:", remoteexception);
            finish();
        }
        super.onPause();
    }

    protected void onRestart()
    {
        super.onRestart();
        try
        {
            if (zznJ != null)
            {
                zznJ.onRestart();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onRestart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            if (zznJ != null)
            {
                zznJ.onResume();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onResume to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        try
        {
            if (zznJ != null)
            {
                zznJ.onSaveInstanceState(bundle);
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", remoteexception);
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
            if (zznJ != null)
            {
                zznJ.onStart();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onStart to ad overlay:", remoteexception);
        }
        finish();
    }

    protected void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        try
        {
            if (zznJ != null)
            {
                zznJ.onStop();
            }
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Could not forward onStop to ad overlay:", remoteexception);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        zzaE();
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        zzaE();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        zzaE();
    }
}
