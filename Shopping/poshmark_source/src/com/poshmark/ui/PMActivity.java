// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.application.PMApplication;
import com.poshmark.ui.fragments.PMFragment;
import java.util.List;
import java.util.Stack;

public abstract class PMActivity extends FragmentActivity
    implements TraceFieldInterface
{

    boolean bIsInForeground;
    boolean bSaveStateCalled;

    public PMActivity()
    {
        bIsInForeground = false;
        bSaveStateCalled = false;
    }

    public abstract Stack getFragmentStack();

    public abstract int getFragmentStackCount();

    public abstract List getScreenNavigationStack();

    public abstract PMFragment getVisibleFragment();

    public abstract boolean isActivityInForeground();

    public abstract void launchDialogFragmentForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i);

    public abstract void launchFragment(Bundle bundle, Class class1, Object obj);

    public abstract void launchFragmentForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i);

    public abstract void launchFragmentInNewActivity(Bundle bundle, Class class1, Object obj);

    public abstract void launchFragmentInNewActivityForResult(Bundle bundle, Class class1, Object obj, PMFragment pmfragment, int i);

    public abstract void launchSearchActivity();

    protected void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("PMActivity");
        TraceMachine.enterMethod(_nr_trace, "PMActivity#onCreate", null);
_L1:
        super.onCreate(bundle);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PMActivity#onCreate", null);
          goto _L1
    }

    protected void onDestroy()
    {
        super.onDestroy();
        bSaveStateCalled = true;
    }

    protected void onPause()
    {
        super.onPause();
        bIsInForeground = false;
    }

    protected void onResume()
    {
        super.onResume();
        bIsInForeground = true;
        PMApplication.getApplicationObject().setTopActivity(this);
        bSaveStateCalled = false;
    }

    protected void onStart()
    {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
    }

    protected void onStop()
    {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        bSaveStateCalled = true;
    }

    public abstract void popTopFragment();

    public abstract void popTopNFragments(int i, boolean flag);

    public abstract void replaceFragment(Bundle bundle, Class class1, Object obj);

    public abstract void setScreenNavigationStack(List list);

    public void startActivityForResult(Intent intent, int i)
    {
        intent.putExtra("requestCode", i);
        super.startActivityForResult(intent, i);
    }
}
