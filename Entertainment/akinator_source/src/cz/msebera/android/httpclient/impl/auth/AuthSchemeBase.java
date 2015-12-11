// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Locale;

public abstract class AuthSchemeBase
    implements ContextAwareAuthScheme
{

    private ChallengeState challengeState;

    public AuthSchemeBase()
    {
    }

    public AuthSchemeBase(ChallengeState challengestate)
    {
        challengeState = challengestate;
    }

    public Header authenticate(Credentials credentials, HttpRequest httprequest, HttpContext httpcontext)
        throws AuthenticationException
    {
        return authenticate(credentials, httprequest);
    }

    public ChallengeState getChallengeState()
    {
        return challengeState;
    }

    public boolean isProxy()
    {
        return challengeState != null && challengeState == ChallengeState.PROXY;
    }

    protected abstract void parseChallenge(CharArrayBuffer chararraybuffer, int i, int j)
        throws MalformedChallengeException;

    public void processChallenge(Header header)
        throws MalformedChallengeException
    {
        Args.notNull(header, "Header");
        Object obj = header.getName();
        int i;
        if (((String) (obj)).equalsIgnoreCase("WWW-Authenticate"))
        {
            challengeState = ChallengeState.TARGET;
        } else
        if (((String) (obj)).equalsIgnoreCase("Proxy-Authenticate"))
        {
            challengeState = ChallengeState.PROXY;
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
        String s = getSchemeName();
        if (s != null)
        {
            return s.toUpperCase(Locale.ENGLISH);
        } else
        {
            return super.toString();
        }
    }
}
