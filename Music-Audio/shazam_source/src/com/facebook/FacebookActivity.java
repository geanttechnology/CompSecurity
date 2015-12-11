// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import com.facebook.b.j;
import com.facebook.b.p;
import com.facebook.login.d;

public class FacebookActivity extends i
{

    public static String a = "PassThrough";
    private static String b = "SingleFragment";
    private Fragment c;

    public FacebookActivity()
    {
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
        setContentView(x.c.com_facebook_activity_layout);
        Intent intent = getIntent();
        if (a.equals(intent.getAction()))
        {
            bundle = getIntent();
            setResult(0, p.a(bundle, null, p.a(p.a(bundle))));
            finish();
            return;
        }
        k k1 = getSupportFragmentManager();
        Fragment fragment = k1.a(b);
        bundle = fragment;
        if (fragment == null)
        {
            if ("FacebookDialogFragment".equals(intent.getAction()))
            {
                bundle = new j();
                bundle.setRetainInstance(true);
                bundle.a(k1, b);
            } else
            {
                bundle = new d();
                bundle.setRetainInstance(true);
                k1.a().a(x.b.com_facebook_fragment_container, bundle, b).a();
            }
        }
        c = bundle;
    }

}
