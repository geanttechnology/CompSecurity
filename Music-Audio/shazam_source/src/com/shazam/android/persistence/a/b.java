// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.a;

import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.k.t;
import com.shazam.model.account.UserState;

public final class b
    implements t
{

    private final t b;
    private final EventAnalytics c;

    public b(t t1, EventAnalytics eventanalytics)
    {
        b = t1;
        c = eventanalytics;
    }

    public final UserState a()
    {
        return b.a();
    }

    public final void a(UserState userstate)
    {
        c.logEvent(AccountLoginEventFactory.userStateChanged());
        b.a(userstate);
    }

    public final boolean b()
    {
        return b.b();
    }
}
