// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PaymentInitialConfirmationActivity, a, PayCashlessActivity

final class fc
    implements android.view.View.OnClickListener
{

    private PaymentInitialConfirmationActivity a;

    fc(PaymentInitialConfirmationActivity paymentinitialconfirmationactivity)
    {
        a = paymentinitialconfirmationactivity;
        super();
    }

    public final void onClick(View view)
    {
        view = a.c;
        com.offerup.android.dto.Item item = a.a;
        com.offerup.android.dto.BuyRequest buyrequest = a.b;
        Intent intent = new Intent(((a) (view)).a, com/offerup/android/activities/PayCashlessActivity);
        intent.putExtra("item", item);
        intent.putExtra("currentBuyRequest", buyrequest);
        ((a) (view)).a.startActivity(intent);
        a.finish();
    }
}
