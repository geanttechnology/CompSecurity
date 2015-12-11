// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v7.jr;
import android.support.v7.jx;
import com.facebook.login.d;

public class FacebookActivity extends g
{

    public static String n = "PassThrough";
    private static String o = "SingleFragment";
    private Fragment p;

    public FacebookActivity()
    {
    }

    private void g()
    {
        Intent intent = getIntent();
        setResult(0, jx.a(intent, null, jx.a(jx.d(intent))));
        finish();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (p != null)
        {
            p.onConfigurationChanged(configuration);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(x.c.com_facebook_activity_layout);
        Intent intent = getIntent();
        if (n.equals(intent.getAction()))
        {
            g();
            return;
        }
        i j = f();
        Fragment fragment = j.a(o);
        bundle = fragment;
        if (fragment == null)
        {
            if ("FacebookDialogFragment".equals(intent.getAction()))
            {
                bundle = new jr();
                bundle.d(true);
                bundle.a(j, o);
            } else
            {
                bundle = new d();
                bundle.d(true);
                j.a().a(x.b.com_facebook_fragment_container, bundle, o).a();
            }
        }
        p = bundle;
    }

}
