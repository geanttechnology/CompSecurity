// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;
import java.util.StringTokenizer;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            BasicDomainHandler

public class NetscapeDomainHandler extends BasicDomainHandler
{

    public NetscapeDomainHandler()
    {
    }

    private static boolean isSpecialDomain(String s)
    {
        s = s.toUpperCase(Locale.ENGLISH);
        return s.endsWith(".COM") || s.endsWith(".EDU") || s.endsWith(".NET") || s.endsWith(".GOV") || s.endsWith(".MIL") || s.endsWith(".ORG") || s.endsWith(".INT");
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieorigin, "Cookie origin");
        cookieorigin = cookieorigin.getHost();
        cookie = cookie.getDomain();
        if (cookie == null)
        {
            return false;
        } else
        {
            return cookieorigin.endsWith(cookie);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        super.validate(cookie, cookieorigin);
        cookieorigin = cookieorigin.getHost();
        cookie = cookie.getDomain();
        if (cookieorigin.contains("."))
        {
            int i = (new StringTokenizer(cookie, ".")).countTokens();
            if (isSpecialDomain(cookie))
            {
                if (i < 2)
                {
                    throw new CookieRestrictionViolationException((new StringBuilder()).append("Domain attribute \"").append(cookie).append("\" violates the Netscape cookie specification for ").append("special domains").toString());
                }
            } else
            if (i < 3)
            {
                throw new CookieRestrictionViolationException((new StringBuilder()).append("Domain attribute \"").append(cookie).append("\" violates the Netscape cookie specification").toString());
            }
        }
    }
}
