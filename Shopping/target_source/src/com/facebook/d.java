// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.support.v4.app.h;
import android.support.v4.app.l;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.k;
import com.facebook.login.LoginFragment;

public class d extends f
{

    public static String a = "PassThrough";
    private static String b = "SingleFragment";
    private Fragment c;

    public d()
    {
    }

    private void g()
    {
        Intent intent = getIntent();
        setResult(0, k.a(intent, null, k.a(k.c(intent))));
        finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (c != null)
        {
            c.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(v.c.com_facebook_activity_layout);
        Intent intent = getIntent();
        if (a.equals(intent.getAction()))
        {
            g();
            return;
        }
        h h1 = f();
        Fragment fragment = h1.a(b);
        bundle = fragment;
        if (fragment == null)
        {
            if ("FacebookDialogFragment".equals(intent.getAction()))
            {
                bundle = new FacebookDialogFragment();
                bundle.setRetainInstance(true);
                bundle.show(h1, b);
            } else
            {
                bundle = new LoginFragment();
                bundle.setRetainInstance(true);
                h1.a().a(v.b.com_facebook_fragment_container, bundle, b).a();
            }
        }
        c = bundle;
    }

}
