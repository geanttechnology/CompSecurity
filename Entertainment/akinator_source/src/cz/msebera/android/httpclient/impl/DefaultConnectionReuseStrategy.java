// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.TokenIterator;
import cz.msebera.android.httpclient.message.BasicTokenIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

public class DefaultConnectionReuseStrategy
    implements ConnectionReuseStrategy
{

    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    public DefaultConnectionReuseStrategy()
    {
    }

    private boolean canResponseHaveBody(HttpResponse httpresponse)
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        return i >= 200 && i != 204 && i != 304 && i != 205;
    }

    protected TokenIterator createTokenIterator(HeaderIterator headeriterator)
    {
        return new BasicTokenIterator(headeriterator);
    }

    public boolean keepAlive(HttpResponse httpresponse, HttpContext httpcontext)
    {
        ProtocolVersion protocolversion;
        Args.notNull(httpresponse, "HTTP response");
        Args.notNull(httpcontext, "HTTP context");
        protocolversion = httpresponse.getStatusLine().getProtocolVersion();
        httpcontext = httpresponse.getFirstHeader("Transfer-Encoding");
        if (httpcontext != null)
        {
            if (!"chunked".equalsIgnoreCase(httpcontext.getValue()))
            {
                return false;
            }
        } else
        if (canResponseHaveBody(httpresponse))
        {
            httpcontext = httpresponse.getHeaders("Content-Length");
            if (httpcontext.length == 1)
            {
                httpcontext = httpcontext[0];
                int i;
                try
                {
                    i = Integer.parseInt(httpcontext.getValue());
                }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse)
                {
                    return false;
                }
                if (i < 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        HeaderIterator headeriterator = httpresponse.headerIterator("Connection");
        httpcontext = headeriterator;
        if (!headeriterator.hasNext())
        {
            httpcontext = httpresponse.headerIterator("Proxy-Connection");
        }
        if (!httpcontext.hasNext())
        {
            break MISSING_BLOCK_LABEL_209;
        }
        boolean flag;
        boolean flag1;
        try
        {
            httpresponse = createTokenIterator(httpcontext);
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            return false;
        }
        flag = false;
        if (!httpresponse.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        httpcontext = httpresponse.nextToken();
        if ("Close".equalsIgnoreCase(httpcontext))
        {
            return false;
        }
        flag1 = "Keep-Alive".equalsIgnoreCase(httpcontext);
        if (flag1)
        {
            flag = true;
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_153;
_L1:
        if (flag)
        {
            return true;
        }
        return !protocolversion.lessEquals(HttpVersion.HTTP_1_0);
    }

}
