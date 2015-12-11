// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.content.Intent;
import android.view.View;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;

// Referenced classes of package com.shazam.android.activities.account:
//            CheckEmailActivity

private final class b
    implements android.view.unt.CheckEmailActivity.b
{

    final CheckEmailActivity a;
    private final Intent b;

    public final void onClick(View view)
    {
        CheckEmailActivity.a(a).logEvent(view, AccountLoginEventFactory.checkEmail());
        a.startActivity(b);
    }

    public tFactory(CheckEmailActivity checkemailactivity, Intent intent)
    {
        a = checkemailactivity;
        super();
        b = intent;
    }
}
