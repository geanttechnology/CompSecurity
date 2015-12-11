// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.util.CheckedReturningFunction1;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service.marketrate:
//            MarketRateServiceBase

class val.onFinally extends Http
{

    final MarketRateServiceBase this$0;
    final Function0 val$onCancelRetry;
    final CheckedReturningFunction1 val$onException;
    final Function0 val$onFinally;
    final Function0 val$onRetry;
    final Function1 val$onSuccess;

    protected void onException(Exception exception)
    {
        if (val$onException != null && !((Boolean)val$onException.execute(exception)).booleanValue())
        {
            super.onException(exception);
        }
    }

    protected void onFinally()
    {
        super.onFinally();
        if (val$onFinally != null)
        {
            val$onFinally.execute();
        }
    }

    protected void onSuccess(HotelSearchResponse hotelsearchresponse)
        throws Exception
    {
        if (val$onSuccess != null)
        {
            val$onSuccess.execute(hotelsearchresponse);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((HotelSearchResponse)obj);
    }

    public void onUserCancelRetry()
    {
        super.onUserCancelRetry();
        if (val$onCancelRetry != null)
        {
            val$onCancelRetry.execute();
        }
    }

    public void retry()
    {
        super.retry();
        if (val$onRetry != null)
        {
            val$onRetry.execute();
        }
    }

    (Function0 function0_1, 
            Function0 function0_2)
    {
        this$0 = final_marketrateservicebase;
        val$onSuccess = function1;
        val$onException = checkedreturningfunction1;
        val$onRetry = Function0.this;
        val$onCancelRetry = function0_1;
        val$onFinally = function0_2;
        super(final_context, final_synchttp);
    }
}
