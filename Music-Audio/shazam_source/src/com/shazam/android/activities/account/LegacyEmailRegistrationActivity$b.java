// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.View;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.event.factory.RegistrationEventFactory;
import com.shazam.android.persistence.a.c;
import com.shazam.android.service.a.b;

// Referenced classes of package com.shazam.android.activities.account:
//            LegacyEmailRegistrationActivity

private final class <init>
    implements android.view.ilRegistrationActivity.b
{

    final LegacyEmailRegistrationActivity a;

    public final void onClick(View view)
    {
        LegacyEmailRegistrationActivity.a(a).logEvent(view, AccountLoginEventFactory.done());
        view = a;
        if (((LegacyEmailRegistrationActivity) (view)).c.b())
        {
            ((LegacyEmailRegistrationActivity) (view)).b.a();
            ((LegacyEmailRegistrationActivity) (view)).a.logEvent(RegistrationEventFactory.createRegistrationEvent(com.shazam.android.analytics.event.factory.ionAction.REGISTER));
        }
        com.shazam.android.activities.account.LegacyEmailRegistrationActivity.b(a);
    }

    private strationAction(LegacyEmailRegistrationActivity legacyemailregistrationactivity)
    {
        a = legacyemailregistrationactivity;
        super();
    }

    a(LegacyEmailRegistrationActivity legacyemailregistrationactivity, byte byte0)
    {
        this(legacyemailregistrationactivity);
    }
}
