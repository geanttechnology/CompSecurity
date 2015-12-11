// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.braintreepayments.api.dropin:
//            BraintreePaymentActivity

class this._cls0
    implements Runnable
{

    final BraintreePaymentActivity this$0;

    public void run()
    {
        class _cls1
            implements Runnable
        {

            final BraintreePaymentActivity._cls2 this$1;

            public void run()
            {
                BraintreePaymentActivity.access$100(this$0).set(true);
                showAddPaymentMethodView();
            }

            _cls1()
            {
                this$1 = BraintreePaymentActivity._cls2.this;
                super();
            }
        }

        if (!BraintreePaymentActivity.access$100(BraintreePaymentActivity.this).get())
        {
            runOnUiThread(new _cls1());
        }
    }

    _cls1()
    {
        this$0 = BraintreePaymentActivity.this;
        super();
    }
}
