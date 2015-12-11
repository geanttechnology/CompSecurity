// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodsActivity

final class fq
    implements android.content.DialogInterface.OnClickListener
{

    private PaymentMethodsActivity a;

    fq(PaymentMethodsActivity paymentmethodsactivity)
    {
        a = paymentmethodsactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        PaymentMethodsActivity.a(a);
    }
}
