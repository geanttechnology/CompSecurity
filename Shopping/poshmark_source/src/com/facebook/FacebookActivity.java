// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;

public class FacebookActivity extends FragmentActivity
    implements TraceFieldInterface
{

    private static String FRAGMENT_TAG = "SingleFragment";
    public static String PASS_THROUGH_CANCEL_ACTION = "PassThrough";
    private Fragment singleFragment;

    public FacebookActivity()
    {
    }

    private void handlePassThroughError()
    {
        Intent intent = getIntent();
        setResult(0, NativeProtocol.createProtocolResultIntent(intent, null, NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(intent))));
        finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (singleFragment != null)
        {
            singleFragment.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle)
    {
        TraceMachine.startTracing("FacebookActivity");
        TraceMachine.enterMethod(_nr_trace, "FacebookActivity#onCreate", null);
_L2:
        Intent intent;
        super.onCreate(bundle);
        setContentView(R.layout.com_facebook_activity_layout);
        intent = getIntent();
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction()))
        {
            handlePassThroughError();
            TraceMachine.exitMethod();
            return;
        }
        break; /* Loop/switch isn't completed */
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "FacebookActivity#onCreate", null);
        if (true) goto _L2; else goto _L1
_L1:
        FragmentManager fragmentmanager = getSupportFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag(FRAGMENT_TAG);
        bundle = fragment;
        if (fragment == null)
        {
            if ("FacebookDialogFragment".equals(intent.getAction()))
            {
                bundle = new FacebookDialogFragment();
                bundle.setRetainInstance(true);
                bundle.show(fragmentmanager, FRAGMENT_TAG);
            } else
            {
                bundle = new LoginFragment();
                bundle.setRetainInstance(true);
                fragmentmanager.beginTransaction().add(R.id.com_facebook_fragment_container, bundle, FRAGMENT_TAG).commit();
            }
        }
        singleFragment = bundle;
        TraceMachine.exitMethod();
        return;
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
