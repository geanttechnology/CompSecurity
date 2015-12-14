// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import com.amazon.insights.core.log.Logger;

public final class LogInterceptor
    implements HttpClient.Interceptor
{

    private static Logger logger = Logger.getLogger(com/amazon/insights/core/http/LogInterceptor);

    public LogInterceptor()
    {
    }

    public void after(HttpClient.Response response)
    {
        if (logger.isLoggingEnabled(com.amazon.insights.core.log.Logger.LogLevel.VERBOSE))
        {
            logger.v(response.toString());
        }
    }

    public void before(HttpClient.Request request)
    {
        if (logger.isLoggingEnabled(com.amazon.insights.core.log.Logger.LogLevel.VERBOSE))
        {
            logger.v(request.toString());
        }
    }

}
