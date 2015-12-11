// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity, a, PaymentMethodsActivity

final class cy
    implements android.view.View.OnClickListener
{

    private MyAccountActivity a;

    cy(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyAccount_Payments-Button_click");
        view = a.f;
        Intent intent = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/PaymentMethodsActivity);
        intent.putExtra("comingFrom", "fromProfile");
        ((com.offerup.android.activities.a) (view)).a.startActivity(intent);
    }
}
