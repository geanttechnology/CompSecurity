// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.util.Map;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthScheme, MalformedChallengeException, AuthChallengeParser

public abstract class RFC2617Scheme
    implements AuthScheme
{

    private Map params;

    public RFC2617Scheme()
    {
        params = null;
    }

    public RFC2617Scheme(String s)
        throws MalformedChallengeException
    {
        params = null;
        processChallenge(s);
    }

    public String getID()
    {
        return getRealm();
    }

    public String getParameter(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter name may not be null");
        }
        if (params == null)
        {
            return null;
        } else
        {
            return (String)params.get(s.toLowerCase());
        }
    }

    protected Map getParameters()
    {
        return params;
    }

    public String getRealm()
    {
        return getParameter("realm");
    }

    public void processChallenge(String s)
        throws MalformedChallengeException
    {
        if (!AuthChallengeParser.extractScheme(s).equalsIgnoreCase(getSchemeName()))
        {
            throw new MalformedChallengeException("Invalid " + getSchemeName() + " challenge: " + s);
        } else
        {
            params = AuthChallengeParser.extractParams(s);
            return;
        }
    }
}
