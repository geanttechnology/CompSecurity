// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity, a, TruYouInitActivity

final class cz
    implements android.view.View.OnClickListener
{

    private MyAccountActivity a;

    cz(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyAccount_JoinTruYou-Button_click");
        view = a.f;
        com.offerup.android.tracker.a.a("ou_account_tap_join_truyou", null);
        Intent intent = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/TruYouInitActivity);
        ((com.offerup.android.activities.a) (view)).a.startActivityForResult(intent, 5);
    }
}
