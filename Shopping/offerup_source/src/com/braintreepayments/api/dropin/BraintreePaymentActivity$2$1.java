// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.dropin;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.braintreepayments.api.dropin:
//            BraintreePaymentActivity

class this._cls1
    implements Runnable
{

    final AddPaymentMethodView this$1;

    public void run()
    {
        BraintreePaymentActivity.access$100(_fld0).set(true);
        showAddPaymentMethodView();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
