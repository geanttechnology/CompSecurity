// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HeaderElementIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.message.BasicHeaderElementIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

public class DefaultConnectionKeepAliveStrategy
    implements ConnectionKeepAliveStrategy
{

    public static final DefaultConnectionKeepAliveStrategy INSTANCE = new DefaultConnectionKeepAliveStrategy();

    public DefaultConnectionKeepAliveStrategy()
    {
    }

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        Args.notNull(httpresponse, "HTTP response");
        httpresponse = new BasicHeaderElementIterator(httpresponse.headerIterator("Keep-Alive"));
_L2:
        Object obj;
        if (!httpresponse.hasNext())
        {
            break MISSING_BLOCK_LABEL_79;
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
