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

public class BasicDomainHandler
    implements CookieAttributeHandler
{

    public BasicDomainHandler()
    {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieorigin, "Cookie origin");
        String s = cookieorigin.getHost();
        cookieorigin = cookie.getDomain();
        if (cookieorigin != null)
        {
            if (s.equals(cookieorigin))
            {
                return true;
            }
            cookie = cookieorigin;
            if (!cookieorigin.startsWith("."))
            {
                cookie = (new StringBuilder()).append('.').append(cookieorigin).toString();
            }
            if (s.endsWith(cookie) || s.equals(cookie.substring(1)))
            {
                return true;
            }
        }
        return false;
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
        String s = cookieorigin.getHost();
        cookieorigin = cookie.getDomain();
        if (cookieorigin == null)
        {
            throw new CookieRestrictionViolationException("Cookie domain may not be null");
        }
        if (s.contains("."))
        {
            if (!s.endsWith(cookieorigin))
            {
                cookie = cookieorigin;
                if (cookieorigin.startsWith("."))
                {
                    cookie = cookieorigin.substring(1, cookieorigin.length());
                }
                if (!s.equals(cookie))
                {
                    throw new CookieRestrictionViolationException((new StringBuilder()).append("Illegal domain attribute \"").append(cookie).append("\". Domain of origin: \"").append(s).append("\"").toString());
                }
            }
        } else
        if (!s.equals(cookieorigin))
        {
            throw new CookieRestrictionViolationException((new StringBuilder()).append("Illegal domain attribute \"").append(cookieorigin).append("\". Domain of origin: \"").append(s).append("\"").toString());
        }
    }
}
