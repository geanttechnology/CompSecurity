// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import android.view.View;
import com.groupon.http.Http;
import com.groupon.models.shorturl.Data;
import com.groupon.models.shorturl.ShortUrlContainer;
import com.groupon.network.HttpResponseException;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

public class ShortUrlService
{

    Context context;
    Logger logger;

    public ShortUrlService()
    {
    }

    public String getShortUrl(String s, View view, Function0 function0, Function1 function1, Function1 function1_1, Function0 function0_1)
    {
        ((Http)(new Http(function0, function1, s, function0_1) {

            final ShortUrlService this$0;
            final String val$longUrl;
            final Function0 val$onFinally;
            final Function0 val$onPreExecute;
            final Function1 val$onSuccess;

            protected void onException(Exception exception)
                throws RuntimeException
            {
                int i = 0;
                if (exception instanceof HttpResponseException)
                {
                    i = ((HttpResponseException)exception).getStatusCode();
                }
                logger.logGeneralEvent("short_url", "url_shortening", "exception", i, Logger.NULL_NST_FIELD);
                if (onSuccess != null)
                {
                    onSuccess.execute(longUrl);
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

            protected void onPreExecute()
                throws Exception
            {
                super.onPreExecute();
                if (onPreExecute != null)
                {
                    onPreExecute.execute();
                }
            }

            protected void onSuccess(ShortUrlContainer shorturlcontainer)
                throws Exception
            {
                if (onSuccess != null)
                {
                    String s1 = shorturlcontainer.data.url;
                    int i = shorturlcontainer.statusCode;
                    if (i != 200 || s1.equals(longUrl))
                    {
                        logger.logGeneralEvent("short_url", "url_shortening", "exception", i, Logger.NULL_NST_FIELD);
                    }
                    onSuccess.execute(s1);
                }
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((ShortUrlContainer)obj);
            }

            transient 
            {
                this$0 = ShortUrlService.this;
                onPreExecute = function0;
                onSuccess = function1;
                longUrl = s1;
                onFinally = function0_1;
                super(final_context1, final_class1, final_s, final_aobj);
            }
        }).progressView(view)).execute();
        return null;
    }
}
