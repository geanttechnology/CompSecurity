// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.cookie;

import com.comcast.cim.httpcomponentsandroid.cookie.Cookie;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieOrigin;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieRestrictionViolationException;
import com.comcast.cim.httpcomponentsandroid.cookie.MalformedCookieException;
import com.comcast.cim.httpcomponentsandroid.cookie.SetCookie;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.cookie:
//            AbstractCookieAttributeHandler

public class RFC2109VersionHandler extends AbstractCookieAttributeHandler
{

    public RFC2109VersionHandler()
    {
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        if (setcookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
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
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie.getVersion() < 0)
        {
            throw new CookieRestrictionViolationException("Cookie version may not be negative");
        } else
        {
            return;
        }
    }
}
