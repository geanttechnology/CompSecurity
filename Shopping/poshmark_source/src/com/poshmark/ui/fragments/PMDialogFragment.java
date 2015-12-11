// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

public abstract class PMDialogFragment extends DialogFragment
    implements TraceFieldInterface
{

    private Object fragmentData;
    protected String viewNameForAnalytics;

    public PMDialogFragment()
    {
        fragmentData = null;
    }

    public Object getFragmentDataOfType(Class class1)
    {
        if (fragmentData != null && class1.isAssignableFrom(fragmentData.getClass()))
        {
            return fragmentData;
        } else
        {
            return null;
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PMDialogFragment");
        TraceMachine.enterMethod(_nr_trace, "PMDialogFragment#onCreate", null);
_L1:
        super.onCreate(bundle);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PMDialogFragment#onCreate", null);
          goto _L1
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        TraceMachine.enterMethod(_nr_trace, "PMDialogFragment#onCreateView", null);
_L1:
        setViewNameForAnalytics();
        TraceMachine.exitMethod();
        return null;
        layoutinflater;
        TraceMachine.enterMethod(null, "PMDialogFragment#onCreateView", null);
          goto _L1
    }

    public void onDestroy()
    {
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

    public void setFragmentData(Object obj)
    {
        fragmentData = obj;
    }

    public abstract void setViewNameForAnalytics();
}
