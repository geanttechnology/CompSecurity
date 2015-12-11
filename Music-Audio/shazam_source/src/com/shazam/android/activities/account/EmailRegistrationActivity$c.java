// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.android.analytics.event.factory.RegistrationEventFactory;
import com.shazam.android.j.g.j;
import com.shazam.android.persistence.n.b;
import com.shazam.android.widget.text.EmailValidEditText;

// Referenced classes of package com.shazam.android.activities.account:
//            EmailRegistrationActivity

private final class <init>
    implements android.view.ilRegistrationActivity.c, android.widget.ner
{

    final EmailRegistrationActivity a;

    private void a()
    {
        if (EmailRegistrationActivity.a(a))
        {
            EmailRegistrationActivity.c(a).logEvent(com.shazam.android.activities.account.EmailRegistrationActivity.b(a), AccountLoginEventFactory.done());
            j j1 = EmailRegistrationActivity.e(a);
            String s = EmailRegistrationActivity.d(a).getText().toString();
            j1.a.b("pk_re", s);
            EmailRegistrationActivity.f(a).a();
            EmailRegistrationActivity.g(a).logEvent(RegistrationEventFactory.createRegistrationEvent(com.shazam.android.analytics.event.factory.istrationAction.REGISTER));
            EmailRegistrationActivity.h(a);
        }
    }

    public final void onClick(View view)
    {
        a();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6)
        {
            a();
            return true;
        } else
        {
            return false;
        }
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
