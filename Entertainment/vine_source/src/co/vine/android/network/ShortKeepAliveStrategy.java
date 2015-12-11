// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HttpContext;

class ShortKeepAliveStrategy
    implements ConnectionKeepAliveStrategy
{

    private static final long DEFAULT_KEEP_ALIVE_DURATION = 60000L;

    ShortKeepAliveStrategy()
    {
    }

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        httpresponse = new BasicHeaderElementIterator(httpresponse.headerIterator("Keep-Alive"));
_L2:
        Object obj;
        if (!httpresponse.hasNext())
        {
            break MISSING_BLOCK_LABEL_83;
        }
        obj = httpresponse.nextElement();
        httpcontext = ((HeaderElement) (obj)).getName();
        obj = ((HeaderElement) (obj)).getValue();
        if (obj == null || !"timeout".equalsIgnoreCase(httpcontext))
        {
            continue; /* Loop/switch isn't completed */
        }
        long l = Long.parseLong(((String) (obj)));
        l *= 1000L;
        if (l > 0L)
        {
            return l;
        }
        continue; /* Loop/switch isn't completed */
        return 60000L;
        httpcontext;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
