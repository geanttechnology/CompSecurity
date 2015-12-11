// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl;

import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestFactory;
import com.comcast.cim.httpcomponentsandroid.MethodNotSupportedException;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.message.BasicHttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.message.BasicHttpRequest;

public class DefaultHttpRequestFactory
    implements HttpRequestFactory
{

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
        for (int i = 0; i < as.length; i++)
        {
            if (as[i].equalsIgnoreCase(s))
            {
                return true;
            }
        }

        return false;
    }

    public HttpRequest newHttpRequest(RequestLine requestline)
        throws MethodNotSupportedException
    {
        if (requestline == null)
        {
            throw new IllegalArgumentException("Request line may not be null");
        }
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
            throw new MethodNotSupportedException(s + " method not supported");
        }
    }

}
