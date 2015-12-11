// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.an.m;
import com.shazam.android.an.n;
import com.shazam.android.an.s;
import com.shazam.android.an.t;
import com.shazam.android.an.u;
import com.shazam.android.an.v;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.rdio.RdioUser;
import com.shazam.model.streaming.SubscriptionType;

public final class k
    implements m, t, v
{

    private final s a;
    private final RdioConnectionState b;
    private final u c;
    private final EventAnalytics d;
    private n e;

    public k(s s1, RdioConnectionState rdioconnectionstate, u u1, EventAnalytics eventanalytics)
    {
        a = s1;
        b = rdioconnectionstate;
        c = u1;
        d = eventanalytics;
    }

    private void a(String s1)
    {
        d.logEvent(com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "streamingtrialsetup").putNotEmptyOrNullParameter(DefinedEventParameterKey.PROVIDER, "rdio").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, s1).build()).build());
    }

    public final void a()
    {
        e.f();
        b.a(SubscriptionType.TRIAL);
        a("success");
    }

    public final void a(n n1)
    {
        e = n1;
        c.a(this);
    }

    public final void a(Object obj)
    {
        boolean flag1 = true;
        obj = (RdioUser)obj;
        SubscriptionType subscriptiontype = ((RdioUser) (obj)).subscriptionType;
        boolean flag;
        if (((RdioUser) (obj)).is48hTrialAvailable && subscriptiontype == SubscriptionType.FREE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a.a(this);
            return;
        }
        if (subscriptiontype == SubscriptionType.FREE && b.g() != SubscriptionType.FREE)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            e.b();
            return;
        } else
        {
            e.f();
            return;
        }
    }

    public final void b()
    {
        e.f();
        a("error");
    }

    public final void c()
    {
        e.h();
    }
}
