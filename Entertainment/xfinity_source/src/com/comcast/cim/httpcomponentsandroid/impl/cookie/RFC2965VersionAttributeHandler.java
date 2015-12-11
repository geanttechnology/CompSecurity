// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.cookie;

import com.comcast.cim.httpcomponentsandroid.cookie.ClientCookie;
import com.comcast.cim.httpcomponentsandroid.cookie.Cookie;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieAttributeHandler;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieOrigin;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieRestrictionViolationException;
import com.comcast.cim.httpcomponentsandroid.cookie.MalformedCookieException;
import com.comcast.cim.httpcomponentsandroid.cookie.SetCookie;
import com.comcast.cim.httpcomponentsandroid.cookie.SetCookie2;

public class RFC2965VersionAttributeHandler
    implements CookieAttributeHandler
{

    public RFC2965VersionAttributeHandler()
    {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        return true;
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
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            i = -1;
        }
        if (i < 0)
        {
            throw new MalformedCookieException("Invalid cookie version.");
        } else
        {
            setcookie.setVersion(i);
            return;
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if ((cookie instanceof SetCookie2) && (cookie instanceof ClientCookie) && !((ClientCookie)cookie).containsAttribute("version"))
        {
            throw new CookieRestrictionViolationException("Violates RFC 2965. Version attribute is required.");
        } else
        {
            return;
        }
    }
}
