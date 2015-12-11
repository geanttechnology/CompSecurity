// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.shorturl.Data;
import com.groupon.models.shorturl.ShortUrlContainer;
import com.groupon.network.HttpResponseException;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function0;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            ShortUrlService

class val.onFinally extends Http
{

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
        if (val$onSuccess != null)
        {
            val$onSuccess.execute(val$longUrl);
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

    protected void onPreExecute()
        throws Exception
    {
        super.onPreExecute();
        if (val$onPreExecute != null)
        {
            val$onPreExecute.execute();
        }
    }

    protected void onSuccess(ShortUrlContainer shorturlcontainer)
        throws Exception
    {
        if (val$onSuccess != null)
        {
            String s = shorturlcontainer.data.url;
            int i = shorturlcontainer.statusCode;
            if (i != 200 || s.equals(val$longUrl))
            {
                logger.logGeneralEvent("short_url", "url_shortening", "exception", i, Logger.NULL_NST_FIELD);
            }
            val$onSuccess.execute(s);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((ShortUrlContainer)obj);
    }

    transient ntainer(Function0 function0, Function1 function1, 
            String s1, Function0 function0_1)
    {
        this$0 = final_shorturlservice;
        val$onPreExecute = function0;
        val$onSuccess = function1;
        val$longUrl = s1;
        val$onFinally = function0_1;
        super(final_context, final_class1, final_s, _5B_Ljava.lang.Object_3B_.this);
    }
}
