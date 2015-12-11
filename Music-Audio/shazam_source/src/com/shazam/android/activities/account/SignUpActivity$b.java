// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.View;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.k.t;
import com.shazam.l.a.c;
import com.shazam.model.account.UserState;
import com.shazam.model.configuration.EmailRegistrationConfiguration;
import com.shazam.model.configuration.EmailRegistrationStyleConfiguration;
import com.shazam.p.i.b;

// Referenced classes of package com.shazam.android.activities.account:
//            SignUpActivity

private final class <init>
    implements android.view.ner
{

    final SignUpActivity a;

    public final void onClick(View view)
    {
        SignUpActivity.a(a).logEvent(view, AccountLoginEventFactory.cancel());
        view = com.shazam.android.activities.account.SignUpActivity.b(a);
        ((c) (view)).g.a(UserState.ANONYMOUS);
        if (((c) (view)).e.a() && !((c) (view)).f.a() && ((c) (view)).l)
        {
            ((c) (view)).a.d();
            return;
        } else
        {
            ((c) (view)).a.c();
            return;
        }
    }

    private nfiguration(SignUpActivity signupactivity)
    {
        a = signupactivity;
        super();
    }

    a(SignUpActivity signupactivity, byte byte0)
    {
        this(signupactivity);
    }
}
