// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.util.Function1;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

class this._cls1
    implements Function1
{

    final execute this$1;

    public void execute(com.groupon.models.billingrecord._07_ _p07_)
    {
        if (_p07_ != null && !_p07_..isEmpty())
        {
            setResultAndSaveToPrefs((BillingRecord)_p07_..get(0));
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((com.groupon.models.billingrecord.)obj);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
