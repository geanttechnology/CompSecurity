// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.network.HttpResponseException;
import com.groupon.service.GoogleWalletService;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements ReturningFunction1
{

    final Purchase this$0;

    public Boolean execute(Exception exception)
    {
        if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 401)
        {
            return Boolean.valueOf(true);
        } else
        {
            hideProcessingFeedback();
            setIsOrdersCallInProgress(false);
            googleWalletService.setFullWallet(null);
            return Boolean.valueOf(true);
        }
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ervice()
    {
        this$0 = Purchase.this;
        super();
    }
}
