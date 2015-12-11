// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.Intent;
import android.os.Bundle;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.n.f;
import com.shazam.android.persistence.e.d;
import com.shazam.i.b.ah.c.b;
import com.shazam.i.b.g.b.a;

public class GooglePlusDeepLinkActivity extends AutoToolbarBaseAppCompatActivity
{

    private final EventAnalytics a;
    private final d b;
    private final com.shazam.android.n.d c;
    private com.shazam.android.e.b d;
    private Intent e;

    public GooglePlusDeepLinkActivity()
    {
        this(com.shazam.i.b.g.b.a.a(), com.shazam.i.b.ah.c.b.a(), ((com.shazam.android.n.d) (new f(com.shazam.i.b.q.a.a()))));
    }

    public GooglePlusDeepLinkActivity(EventAnalytics eventanalytics, d d1, com.shazam.android.n.d d2)
    {
        a = eventanalytics;
        b = d1;
        c = d2;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (b.a())
        {
            startActivity(com.shazam.android.activities.b.b.b(this, bundle));
            finish();
            return;
        } else
        {
            d = new com.shazam.android.e.f(a);
            e = c.a(this, bundle, d);
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        d.a();
        startActivity(e);
        finish();
    }
}
