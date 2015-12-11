// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.os.Bundle;
import com.shazam.android.analytics.AgofReportingDisabler;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.service.unsubmitted.l;
import com.shazam.i.b.aa.a;

public class SplashActivity extends BaseAppCompatActivity
    implements AgofReportingDisabler
{

    private final com.shazam.android.service.a a[];
    private final com.shazam.android.aa.a b;

    public SplashActivity()
    {
        l l1 = new l();
        com.shazam.android.aa.a a1 = com.shazam.i.b.aa.a.a();
        this(new com.shazam.android.service.a[] {
            l1
        }, a1);
    }

    public SplashActivity(com.shazam.android.service.a aa[], com.shazam.android.aa.a a1)
    {
        a = aa;
        b = a1;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b.b();
        bundle = a;
        int j = bundle.length;
        for (int i = 0; i < j; i++)
        {
            bundle[i].a(this);
        }

    }

    protected void onStart()
    {
        super.onStart();
        com.shazam.android.activities.b.a.a(this, true);
        finish();
    }
}
