// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ReturningFunction1;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

class this._cls0
    implements ReturningFunction1
{

    final EditCreditCard this$0;

    public Boolean execute(Exception exception)
    {
        submitView.stopSpinning();
        return Boolean.valueOf(handleBillingRecordException(exception));
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$0 = EditCreditCard.this;
        super();
    }
}
