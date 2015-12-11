// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.offerup.android.dto.PaymentMethod;

// Referenced classes of package com.offerup.android.activities:
//            PayCashlessActivity, a, PaymentFinalConfirmationActivity

final class es
    implements android.view.View.OnClickListener
{

    private PayCashlessActivity a;

    es(PayCashlessActivity paycashlessactivity)
    {
        a = paycashlessactivity;
        super();
    }

    public final void onClick(View view)
    {
label0:
        {
            if (PayCashlessActivity.a(a))
            {
                if (a.a != null)
                {
                    break label0;
                }
                PayCashlessActivity.b(a);
            }
            return;
        }
        if (a.a.isAndroidPay())
        {
            view = a.f;
            double d = a.l;
            Intent intent = new Intent(((a) (view)).a, com/offerup/android/activities/PaymentFinalConfirmationActivity);
            intent.putExtra("price", d);
            ((a) (view)).a.startActivityForResult(intent, 17);
            return;
        } else
        {
            view = a.f;
            PaymentMethod paymentmethod = a.a;
            double d1 = a.l;
            Intent intent1 = new Intent(((a) (view)).a, com/offerup/android/activities/PaymentFinalConfirmationActivity);
            intent1.putExtra("price", d1);
            intent1.putExtra("paymentMethod", paymentmethod);
            ((a) (view)).a.startActivityForResult(intent1, 10);
            return;
        }
    }
}
