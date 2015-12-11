// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.HeaderElementIterator;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectionKeepAliveStrategy;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeaderElementIterator;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;

public class DefaultConnectionKeepAliveStrategy
    implements ConnectionKeepAliveStrategy
{

    public DefaultConnectionKeepAliveStrategy()
    {
    }

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        httpresponse = new BasicHeaderElementIterator(httpresponse.headerIterator("Keep-Alive"));
_L2:
        Object obj;
        if (!httpresponse.hasNext())
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj = httpresponse.nextElement();
        httpcontext = ((HeaderElement) (obj)).getName();
        obj = ((HeaderElement) (obj)).getValue();
        if (obj == null || !httpcontext.equalsIgnoreCase("timeout"))
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = Long.parseLong(((String) (obj)));
        return l * 1000L;
        return -1L;
        httpcontext;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
