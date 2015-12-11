// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api;

import com.braintreepayments.api.exceptions.BraintreeException;
import com.braintreepayments.api.exceptions.ErrorWithResponse;

// Referenced classes of package com.braintreepayments.api:
//            Braintree, BraintreeApi

class er
    implements Runnable
{

    final Braintree this$0;
    final com.braintreepayments.api.models..Builder val$paymentMethodBuilder;

    public void run()
    {
        try
        {
            String s = Braintree.access$200(Braintree.this).tokenize(val$paymentMethodBuilder);
            Braintree.access$800(Braintree.this, s);
            return;
        }
        catch (BraintreeException braintreeexception)
        {
            postUnrecoverableErrorToListeners(braintreeexception);
            return;
        }
        catch (ErrorWithResponse errorwithresponse)
        {
            Braintree.access$500(Braintree.this, errorwithresponse);
        }
    }

    er()
    {
        this$0 = final_braintree;
        val$paymentMethodBuilder = com.braintreepayments.api.models..Builder.this;
        super();
    }
}
