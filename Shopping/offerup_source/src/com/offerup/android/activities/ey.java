// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PaymentFinalConfirmationActivity

final class ey
    implements android.view.View.OnClickListener
{

    private PaymentFinalConfirmationActivity a;

    ey(PaymentFinalConfirmationActivity paymentfinalconfirmationactivity)
    {
        a = paymentfinalconfirmationactivity;
        super();
    }

    public final void onClick(View view)
    {
        view = new Intent();
        view.putExtra("submit", true);
        view.putExtra("price", a.a);
        view.putExtra("paymentMethod", a.b);
        a.setResult(-1, view);
        a.finish();
    }
}
