// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.os.Binder;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalService

final class be extends Binder
{

    final PayPalService a;

    be(PayPalService paypalservice)
    {
        a = paypalservice;
        super();
    }
}
