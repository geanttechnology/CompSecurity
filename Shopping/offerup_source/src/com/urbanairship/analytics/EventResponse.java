// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.http.Response;
import com.urbanairship.util.UAMathUtil;
import java.util.List;
import java.util.Map;

class EventResponse
{

    private final Response response;

    public EventResponse(Response response1)
    {
        response = response1;
    }

    int getMaxBatchSize()
    {
        if (response.getResponseHeaders() != null)
        {
            List list = (List)response.getResponseHeaders().get("X-UA-Max-Batch");
            if (list != null && list.size() > 0)
            {
                return UAMathUtil.constrain(Integer.parseInt((String)list.get(0)), 1024, 0x7d000);
            }
        }
        return 1024;
    }

    int getMaxTotalSize()
    {
        if (response.getResponseHeaders() != null)
        {
            List list = (List)response.getResponseHeaders().get("X-UA-Max-Total");
            if (list != null && list.size() > 0)
            {
                return UAMathUtil.constrain(Integer.parseInt((String)list.get(0)), 10240, 0x500000);
            }
        }
        return 10240;
    }

    int getMaxWait()
    {
        if (response.getResponseHeaders() != null)
        {
            List list = (List)response.getResponseHeaders().get("X-UA-Max-Wait");
            if (list != null && list.size() > 0)
            {
                return UAMathUtil.constrain(Integer.parseInt((String)list.get(0)), 0x240c8400, 0x48190800);
            }
        }
        return 0x240c8400;
    }

    int getMinBatchInterval()
    {
        if (response.getResponseHeaders() != null)
        {
            List list = (List)response.getResponseHeaders().get("X-UA-Min-Batch-Interval");
            if (list != null && list.size() > 0)
            {
                return UAMathUtil.constrain(Integer.parseInt((String)list.get(0)), 60000, 0x240c8400);
            }
        }
        return 60000;
    }

    public int getStatus()
    {
        return response.getStatus();
    }
}
