// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PaymentFinalConfirmationActivity, a

final class fa extends ClickableSpan
{

    private PaymentFinalConfirmationActivity a;

    private fa(PaymentFinalConfirmationActivity paymentfinalconfirmationactivity)
    {
        a = paymentfinalconfirmationactivity;
        super();
    }

    fa(PaymentFinalConfirmationActivity paymentfinalconfirmationactivity, byte byte0)
    {
        this(paymentfinalconfirmationactivity);
    }

    public final void onClick(View view)
    {
        a.c.b(true);
    }
}
