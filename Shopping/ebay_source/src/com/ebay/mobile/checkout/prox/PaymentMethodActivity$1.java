// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.widget.ScrollView;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            PaymentMethodActivity

class val.scroll
    implements Runnable
{

    final PaymentMethodActivity this$0;
    final ScrollView val$scroll;

    public void run()
    {
        val$scroll.smoothScrollTo(0, val$scroll.getBottom());
    }

    ()
    {
        this$0 = final_paymentmethodactivity;
        val$scroll = ScrollView.this;
        super();
    }
}
