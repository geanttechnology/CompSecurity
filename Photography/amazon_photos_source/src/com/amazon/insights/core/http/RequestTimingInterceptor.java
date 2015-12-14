// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import com.amazon.insights.Event;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.Connectivity;
import com.amazon.insights.core.util.DateUtil;
import com.amazon.insights.core.util.StringUtil;
import com.amazon.insights.event.InternalEventClient;
import java.text.DateFormat;
import java.util.Date;

public class RequestTimingInterceptor
    implements HttpClient.Interceptor
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/core/http/RequestTimingInterceptor);
    private final Connectivity connectivity;
    private DateFormat df;
    private final InternalEventClient eventClient;

    public RequestTimingInterceptor(Connectivity connectivity1, InternalEventClient internaleventclient)
    {
        df = DateUtil.createLocaleIndependentDateFormatter("Z");
        eventClient = internaleventclient;
        connectivity = connectivity1;
    }

    private String getTimeZone()
    {
        this;
        JVM INSTR monitorenter ;
        String s = df.format(new Date());
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    private void recordRequestTimeEvent(HttpClient.Response response)
    {
        if (response != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = response.getOriginatingRequest()) == null) goto _L1; else goto _L3
_L3:
        int i;
        boolean flag;
        long l;
        long l1;
        String s;
        Object obj1;
        int j;
        try
        {
            obj = ((HttpClient.Request) (obj)).getUrl();
            obj1 = response.getHeader("x-amzn-RequestTime");
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient.Response response)
        {
            logger.w("Unable to record _RequestTime event", response);
            return;
        }
        l1 = 0L;
        l = l1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        i = ((String) (obj1)).trim().length();
        l = l1;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        try
        {
            l = Long.parseLong(((String) (obj1)).trim());
        }
        catch (NumberFormatException numberformatexception1)
        {
            l = l1;
        }
        s = response.getHeader("x-amzn-RequestAttempts");
        flag = false;
        i = ((flag) ? 1 : 0);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        j = s.trim().length();
        i = ((flag) ? 1 : 0);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        try
        {
            i = Integer.parseInt(s.trim());
        }
        catch (NumberFormatException numberformatexception)
        {
            i = ((flag) ? 1 : 0);
        }
        s = response.getHeader("x-amzn-ServerInfo");
        if (StringUtil.isNullOrEmpty(((String) (obj1))) || eventClient == null) goto _L1; else goto _L4
_L4:
        obj1 = eventClient.createEvent("_httpRequestTiming").withAttribute("url", ((String) (obj))).withAttribute("responseCode", Integer.toString(response.getCode())).withAttribute("timeZone", getTimeZone()).withMetric("attempts", Integer.valueOf(i)).withMetric("totalTime", Long.valueOf(l)).withMetric("requestSize", Long.valueOf(response.getRequestSize())).withMetric("responseSize", Long.valueOf(response.getResponseSize()));
        obj = "UNKNOWN";
        response = ((HttpClient.Response) (obj));
        if (connectivity == null) goto _L6; else goto _L5
_L5:
        if (!connectivity.hasWired()) goto _L8; else goto _L7
_L7:
        response = "OTHER";
_L6:
        ((Event) (obj1)).withAttribute("network", response);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        ((Event) (obj1)).withAttribute("serverInfo", s);
        eventClient.recordEvent(((Event) (obj1)), false);
        return;
_L8:
        if (connectivity.hasWifi())
        {
            response = "WIFI";
            continue; /* Loop/switch isn't completed */
        }
        response = ((HttpClient.Response) (obj));
        if (connectivity.hasWAN())
        {
            response = "WAN";
        }
        if (true) goto _L6; else goto _L9
_L9:
    }

    public void after(HttpClient.Response response)
    {
        recordRequestTimeEvent(response);
    }

    public void before(HttpClient.Request request)
    {
    }

}
