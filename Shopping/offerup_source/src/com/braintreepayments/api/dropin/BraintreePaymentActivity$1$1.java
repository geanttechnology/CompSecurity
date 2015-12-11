// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;


// Referenced classes of package com.braintreepayments.api.dropin:
//            BraintreePaymentActivity

class this._cls1
    implements Runnable
{

    final l.paymentMethod this$1;

    public void run()
    {
        finalizeSelection(paymentMethod);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
