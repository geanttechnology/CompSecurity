// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity;

import com.newrelic.agent.android.NewRelic;
import com.pointinside.PIMapsAccessor;
import com.target.mothership.services.g;
import com.target.ui.analytics.b;
import com.target.ui.analytics.c;
import com.target.ui.service.h;
import com.target.ui.service.k;
import com.target.ui.service.m;

public class a
{

    private static final String POINTINSIDE_BASE_URL = "https://api-target.pointinside.com";
    private boolean mIsInitialized;

    public a()
    {
    }

    private void b(com.target.a.a.a a1)
    {
        android.content.Context context = a1.a();
        NewRelic.withApplicationToken("AA952d1b7cbc0fc45b665d25fb1975a0e422236e1f").start(context);
        com.target.ui.analytics.c.a(a1);
        com.target.ui.analytics.c.a().a();
        com.target.ui.service.a.b();
        g.a(a1);
        k.a(a1);
        com.target.ui.util.t.a.a(context, new com.target.mothership.model.coupons.c());
        com.target.ui.analytics.a.g.a(a1);
        h.a();
        com.target.ui.analytics.d.b.a();
        m.a(context);
        PIMapsAccessor.init(context, "https://api-target.pointinside.com", "364ba7734ed21e1e866757378e96b1e1");
        PIMapsAccessor.getInstance().setMapViewMultiSamplingEnabled(4);
        c(a1);
        com.target.ui.l.a.a(context);
        com.target.ui.h.a.a();
        mIsInitialized = true;
    }

    private void c(com.target.a.a.a a1)
    {
        if (com.target.ui.util.g.a.a(a1.a()))
        {
            com.target.ui.j.c.a(a1);
        }
    }

    public void a(com.target.a.a.a a1)
    {
        if (mIsInitialized)
        {
            return;
        } else
        {
            b(a1);
            return;
        }
    }
}
