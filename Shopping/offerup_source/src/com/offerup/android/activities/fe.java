// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.utils.as;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

final class fe
    implements android.view.View.OnClickListener
{

    private PaymentMethodCaptureActivity a;

    fe(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        a = paymentmethodcaptureactivity;
        super();
    }

    public final void onClick(View view)
    {
        as.a(a.getApplicationContext(), a.w);
        if (PaymentMethodCaptureActivity.a(a))
        {
            PaymentMethodCaptureActivity.b(a);
            return;
        } else
        {
            as.a(a);
            return;
        }
    }
}
