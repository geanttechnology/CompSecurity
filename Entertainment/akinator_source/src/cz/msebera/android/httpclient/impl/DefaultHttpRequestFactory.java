// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.MethodNotSupportedException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.message.BasicHttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.util.Args;

public class DefaultHttpRequestFactory
    implements HttpRequestFactory
{

    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
    private static final String RFC2616_COMMON_METHODS[] = {
        "GET"
    };
    private static final String RFC2616_ENTITY_ENC_METHODS[] = {
        "POST", "PUT"
    };
    private static final String RFC2616_SPECIAL_METHODS[] = {
        "HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"
    };

    public DefaultHttpRequestFactory()
    {
    }

    private static boolean isOneOf(String as[], String s)
    {
        boolean flag1 = false;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!as[i].equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public HttpRequest newHttpRequest(RequestLine requestline)
        throws MethodNotSupportedException
    {
        Args.notNull(requestline, "Request line");
        String s = requestline.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, s))
        {
            return new BasicHttpRequest(requestline);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, s))
        {
            return new BasicHttpEntityEnclosingRequest(requestline);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, s))
        {
            return new BasicHttpRequest(requestline);
        } else
        {
            throw new MethodNotSupportedException((new StringBuilder()).append(s).append(" method not supported").toString());
        }
    }

    public HttpRequest newHttpRequest(String s, String s1)
        throws MethodNotSupportedException
    {
        if (isOneOf(RFC2616_COMMON_METHODS, s))
        {
            return new BasicHttpRequest(s, s1);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, s))
        {
            return new BasicHttpEntityEnclosingRequest(s, s1);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, s))
        {
            return new BasicHttpRequest(s, s1);
        } else
        {
            throw new MethodNotSupportedException((new StringBuilder()).append(s).append(" method not supported").toString());
        }
    }

}
