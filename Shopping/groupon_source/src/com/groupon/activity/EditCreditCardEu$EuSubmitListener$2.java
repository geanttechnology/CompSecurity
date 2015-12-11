// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ReturningFunction1;
import com.groupon.util.VolatileBillingInfoProvider;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

class this._cls1
    implements ReturningFunction1
{

    final execute this$1;

    public Boolean execute(Exception exception)
        throws RuntimeException
    {
        billingInfoProvider.clear();
        return Boolean.valueOf(handleBillingRecordException(exception));
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
