// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            AbstractCookieAttributeHandler

public class RFC2109VersionHandler extends AbstractCookieAttributeHandler
{

    public RFC2109VersionHandler()
    {
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        Args.notNull(setcookie, "Cookie");
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        if (s.trim().length() == 0)
        {
            throw new MalformedCookieException("Blank value for version attribute");
        }
        try
        {
            setcookie.setVersion(Integer.parseInt(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SetCookie setcookie)
        {
            throw new MalformedCookieException((new StringBuilder()).append("Invalid version: ").append(setcookie.getMessage()).toString());
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        Args.notNull(cookie, "Cookie");
        if (cookie.getVersion() < 0)
        {
            throw new CookieRestrictionViolationException("Cookie version may not be negative");
        } else
        {
            return;
        }
    }
}
