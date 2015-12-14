// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieAttributeHandler, RFC2965Spec, CookieOrigin, MalformedCookieException

private class <init>
    implements CookieAttributeHandler
{

    private final RFC2965Spec this$0;

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookieorigin == null)
        {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        cookieorigin = cookieorigin.getHost().toLowerCase();
        for (cookie = cookie.getDomain(); !domainMatch(cookieorigin, cookie) || cookieorigin.substring(0, cookieorigin.length() - cookie.length()).indexOf('.') != -1;)
        {
            return false;
        }

        return true;
    }

    public void parse(Cookie cookie, String s)
        throws MalformedCookieException
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (s.trim().equals(""))
        {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        String s1 = s.toLowerCase();
        s = s1;
        if (!s1.startsWith("."))
        {
            s = "." + s1;
        }
        cookie.setDomain(s);
        cookie.setDomainAttributeSpecified(true);
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookieorigin == null)
        {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        cookieorigin = cookieorigin.getHost().toLowerCase();
        if (cookie.getDomain() == null)
        {
            throw new MalformedCookieException("Invalid cookie state: domain not specified");
        }
        String s = cookie.getDomain().toLowerCase();
        if (cookie.isDomainAttributeSpecified())
        {
            if (!s.startsWith("."))
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
            }
            int i = s.indexOf('.', 1);
            if ((i < 0 || i == s.length() - 1) && !s.equals(".local"))
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
            }
            if (!domainMatch(cookieorigin, s))
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
            }
            if (cookieorigin.substring(0, cookieorigin.length() - s.length()).indexOf('.') != -1)
            {
                throw new MalformedCookieException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
            }
        } else
        if (!cookie.getDomain().equals(cookieorigin))
        {
            throw new MalformedCookieException("Illegal domain attribute: \"" + cookie.getDomain() + "\"." + "Domain of origin: \"" + cookieorigin + "\"");
        }
    }

    private ()
    {
        this$0 = RFC2965Spec.this;
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
