// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.shazam.android.ac.c;
import com.shazam.android.activities.d;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import com.shazam.i.b.ad.a.a;
import com.shazam.i.k.a.b;
import com.shazam.k.t;
import com.shazam.model.account.UserStateDecider;

public final class i extends c
{

    private final UserStateDecider a = com.shazam.i.k.a.b.a();
    private final t b = com.shazam.i.b.ad.a.a.a();
    private final EventAnalytics c = com.shazam.i.b.g.b.a.a();

    public i()
    {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle)
    {
        boolean flag;
        if (!(activity instanceof d) && !(activity instanceof FacebookActivity))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && a.d())
        {
            c.logEvent(AccountLoginEventFactory.signUpLaunched(a.e()));
            (new StringBuilder("Launching SignUpActivity, user state is: ")).append(b.a());
            com.shazam.android.activities.b.b.a(activity);
            activity.finish();
        }
    }
}
