// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PaymentInitialConfirmationActivity

final class fb
    implements android.view.View.OnClickListener
{

    private PaymentInitialConfirmationActivity a;

    fb(PaymentInitialConfirmationActivity paymentinitialconfirmationactivity)
    {
        a = paymentinitialconfirmationactivity;
        super();
    }

    public final void onClick(View view)
    {
        view = new Intent();
        a.setResult(0, view);
        a.finish();
    }
}
