// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;

import com.braintreepayments.api.models.PaymentMethod;

// Referenced classes of package com.braintreepayments.api.dropin:
//            BraintreePaymentActivity

class val.paymentMethod
    implements Runnable
{

    final BraintreePaymentActivity this$0;
    final PaymentMethod val$paymentMethod;

    public void run()
    {
        class _cls1
            implements Runnable
        {

            final BraintreePaymentActivity._cls1 this$1;

            public void run()
            {
                finalizeSelection(paymentMethod);
            }

            _cls1()
            {
                this$1 = BraintreePaymentActivity._cls1.this;
                super();
            }
        }

        runOnUiThread(new _cls1());
    }

    _cls1()
    {
        this$0 = final_braintreepaymentactivity;
        val$paymentMethod = PaymentMethod.this;
        super();
    }
}
