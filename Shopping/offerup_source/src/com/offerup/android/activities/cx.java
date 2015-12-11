// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.as;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity, a, OfferUpWebViewActivity

final class cx
    implements android.view.View.OnClickListener
{

    private MyAccountActivity a;

    cx(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyAccount_About-Button_click");
        view = a.f;
        com.offerup.android.tracker.a.a("ou_account_tap_about_us", null);
        Intent intent = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/OfferUpWebViewActivity);
        intent.putExtra("uri", as.b("about/"));
        intent.putExtra("title", "About");
        ((com.offerup.android.activities.a) (view)).a.startActivity(intent);
    }
}
