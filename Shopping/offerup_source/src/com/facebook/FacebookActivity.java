// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.aa;
import android.support.v4.app.an;
import android.support.v4.app.t;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginFragment;

public class FacebookActivity extends t
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
        super.onCreate(bundle);
        setContentView(R.layout.com_facebook_activity_layout);
        Intent intent = getIntent();
        if (PASS_THROUGH_CANCEL_ACTION.equals(intent.getAction()))
        {
            handlePassThroughError();
            return;
        }
        aa aa1 = getSupportFragmentManager();
        Fragment fragment = aa1.a(FRAGMENT_TAG);
        bundle = fragment;
        if (fragment == null)
        {
            if ("FacebookDialogFragment".equals(intent.getAction()))
            {
                bundle = new FacebookDialogFragment();
                bundle.setRetainInstance(true);
                bundle.show(aa1, FRAGMENT_TAG);
            } else
            {
                bundle = new LoginFragment();
                bundle.setRetainInstance(true);
                aa1.a().a(R.id.com_facebook_fragment_container, bundle, FRAGMENT_TAG).b();
            }
        }
        singleFragment = bundle;
    }

}
