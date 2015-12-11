// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.groupon.http.Http;
import com.groupon.http.synchronous.MarketRateSyncHttp;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CheckedReturningFunction1;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

public class MarketRateServiceBase
{

    protected Application application;
    protected CurrentCountryManager currentCountryManager;
    private SharedPreferences prefs;

    public MarketRateServiceBase()
    {
    }

    protected void execute(View view, Function1 function1, CheckedReturningFunction1 checkedreturningfunction1, Function0 function0, Function0 function0_1, Function0 function0_2)
    {
        MarketRateSyncHttp marketratesynchttp = new MarketRateSyncHttp(application, com/groupon/models/hotel/HotelSearchResponse, getEndpoint(), getParams());
        ((Http)(new Http(function0_1, function0_2) {

            final MarketRateServiceBase this$0;
            final Function0 val$onCancelRetry;
            final CheckedReturningFunction1 val$onException;
            final Function0 val$onFinally;
            final Function0 val$onRetry;
            final Function1 val$onSuccess;

            protected void onException(Exception exception)
            {
                if (onException != null && !((Boolean)onException.execute(exception)).booleanValue())
                {
                    super.onException(exception);
                }
            }

            protected void onFinally()
            {
                super.onFinally();
                if (onFinally != null)
                {
                    onFinally.execute();
                }
            }

            protected void onSuccess(HotelSearchResponse hotelsearchresponse)
                throws Exception
            {
                if (onSuccess != null)
                {
                    onSuccess.execute(hotelsearchresponse);
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
                if (onCancelRetry != null)
                {
                    onCancelRetry.execute();
                }
            }

            public void retry()
            {
                super.retry();
                if (onRetry != null)
                {
                    onRetry.execute();
                }
            }

            
            {
                this$0 = MarketRateServiceBase.this;
                onSuccess = function1;
                onException = checkedreturningfunction1;
                onRetry = function0;
                onCancelRetry = function0_1;
                onFinally = function0_2;
                super(final_context, final_synchttp);
            }
        }).progressView(view)).method(getMethod()).execute();
    }

    public String getCurrentBaseUrl()
    {
        return prefs.getString("base_url_market_rate", application.getString(0x7f0804c5));
    }

    protected String getEndpoint()
    {
        return null;
    }

    protected String getMethod()
    {
        return "GET";
    }

    protected Object[] getParams()
    {
        return null;
    }
}
