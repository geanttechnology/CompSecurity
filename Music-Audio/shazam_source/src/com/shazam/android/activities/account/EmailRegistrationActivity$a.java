// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.View;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailRegistrationActivity

private final class <init>
    implements android.view.ilRegistrationActivity.a
{

    final EmailRegistrationActivity a;

    public final void onClick(View view)
    {
        EmailRegistrationActivity.c(a).logEvent(view, AccountLoginEventFactory.skip());
        EmailRegistrationActivity.h(a);
    }

    private y(EmailRegistrationActivity emailregistrationactivity)
    {
        a = emailregistrationactivity;
        super();
    }

    a(EmailRegistrationActivity emailregistrationactivity, byte byte0)
    {
        this(emailregistrationactivity);
    }
}
