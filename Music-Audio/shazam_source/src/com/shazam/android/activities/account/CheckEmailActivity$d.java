// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.view.View;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.i.b.v.b;
import com.shazam.k.a;
import com.shazam.model.Factory;
import com.shazam.model.account.Account;

// Referenced classes of package com.shazam.android.activities.account:
//            CheckEmailActivity

private final class <init>
    implements android.view.unt.CheckEmailActivity.d
{

    final CheckEmailActivity a;

    public final void onClick(View view)
    {
        com.shazam.android.activities.account.CheckEmailActivity.a(a).logEvent(view, AccountLoginEventFactory.sendAgain("checkemail"));
        view = CheckEmailActivity.c(a).a().email;
        view = (com.shazam.g.a)b.a(a.getSupportLoaderManager(), a).create(view);
        view.a(new <init>(a, (byte)0));
        view.a();
        com.shazam.android.activities.account.CheckEmailActivity.a(a, true);
    }

    private tFactory(CheckEmailActivity checkemailactivity)
    {
        a = checkemailactivity;
        super();
    }

    a(CheckEmailActivity checkemailactivity, byte byte0)
    {
        this(checkemailactivity);
    }
}
