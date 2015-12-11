// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

public class RFC2109DomainHandler
    implements CookieAttributeHandler
{

    public RFC2109DomainHandler()
    {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieorigin, "Cookie origin");
        cookieorigin = cookieorigin.getHost();
        for (cookie = cookie.getDomain(); cookie == null || !cookieorigin.equals(cookie) && (!cookie.startsWith(".") || !cookieorigin.endsWith(cookie));)
        {
            return false;
        }

        return true;
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        Args.notNull(setcookie, "Cookie");
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (s.trim().length() == 0)
        {
            throw new MalformedCookieException("Blank value for domain attribute");
        } else
        {
            setcookie.setDomain(s);
            return;
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieorigin, "Cookie origin");
        cookieorigin = cookieorigin.getHost();
        cookie = cookie.getDomain();
        if (cookie == null)
        {
            throw new CookieRestrictionViolationException("Cookie domain may not be null");
        }
        if (!cookie.equals(cookieorigin))
        {
            if (cookie.indexOf('.') == -1)
            {
                throw new CookieRestrictionViolationException((new StringBuilder()).append("Domain attribute \"").append(cookie).append("\" does not match the host \"").append(cookieorigin).append("\"").toString());
            }
            if (!cookie.startsWith("."))
            {
                throw new CookieRestrictionViolationException((new StringBuilder()).append("Domain attribute \"").append(cookie).append("\" violates RFC 2109: domain must start with a dot").toString());
            }
            int i = cookie.indexOf('.', 1);
            if (i < 0 || i == cookie.length() - 1)
            {
                throw new CookieRestrictionViolationException((new StringBuilder()).append("Domain attribute \"").append(cookie).append("\" violates RFC 2109: domain must contain an embedded dot").toString());
            }
            cookieorigin = cookieorigin.toLowerCase(Locale.ENGLISH);
            if (!cookieorigin.endsWith(cookie))
            {
                throw new CookieRestrictionViolationException((new StringBuilder()).append("Illegal domain attribute \"").append(cookie).append("\". Domain of origin: \"").append(cookieorigin).append("\"").toString());
            }
            if (cookieorigin.substring(0, cookieorigin.length() - cookie.length()).indexOf('.') != -1)
            {
                throw new CookieRestrictionViolationException((new StringBuilder()).append("Domain attribute \"").append(cookie).append("\" violates RFC 2109: host minus domain may not contain any dots").toString());
            }
        }
    }
}
