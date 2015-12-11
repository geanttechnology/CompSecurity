// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.httpcomponentsandroid.FormattedHeader;
import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.auth.AuthenticationException;
import com.comcast.cim.httpcomponentsandroid.auth.ContextAwareAuthScheme;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.protocol.HTTP;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

public abstract class AuthSchemeBase
    implements ContextAwareAuthScheme
{

    private boolean proxy;

    public AuthSchemeBase()
    {
    }

    public Header authenticate(Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException
    {
        return authenticate(credentials, httprequest);
    }

    public boolean isProxy()
    {
        return proxy;
    }

    protected abstract void parseChallenge(CharArrayBuffer chararraybuffer, int i, int j)
        throws MalformedChallengeException;

    public void processChallenge(Header header)
        throws MalformedChallengeException
    {
        if (header == null)
        {
            throw new IllegalArgumentException("Header may not be null");
        }
        Object obj = header.getName();
        int i;
        if (((String) (obj)).equalsIgnoreCase("WWW-Authenticate"))
        {
            proxy = false;
        } else
        if (((String) (obj)).equalsIgnoreCase("Proxy-Authenticate"))
        {
            proxy = true;
        } else
        {
            throw new MalformedChallengeException((new StringBuilder()).append("Unexpected header name: ").append(((String) (obj))).toString());
        }
        if (header instanceof FormattedHeader)
        {
            obj = ((FormattedHeader)header).getBuffer();
            i = ((FormattedHeader)header).getValuePos();
        } else
        {
            obj = header.getValue();
            if (obj == null)
            {
                throw new MalformedChallengeException("Header value is null");
            }
            header = new CharArrayBuffer(((String) (obj)).length());
            header.append(((String) (obj)));
            i = 0;
        }
        for (header = ((Header) (obj)); i < header.length() && HTTP.isWhitespace(header.charAt(i)); i++) { }
        int j;
        for (j = i; j < header.length() && !HTTP.isWhitespace(header.charAt(j)); j++) { }
        obj = header.substring(i, j);
        if (!((String) (obj)).equalsIgnoreCase(getSchemeName()))
        {
            throw new MalformedChallengeException((new StringBuilder()).append("Invalid scheme identifier: ").append(((String) (obj))).toString());
        } else
        {
            parseChallenge(header, j, header.length());
            return;
        }
    }

    public String toString()
    {
        return getSchemeName();
    }
}
