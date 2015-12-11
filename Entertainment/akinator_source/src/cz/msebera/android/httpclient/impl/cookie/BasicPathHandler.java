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
import cz.msebera.android.httpclient.util.TextUtils;

public class BasicPathHandler
    implements CookieAttributeHandler
{

    public BasicPathHandler()
    {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
label0:
        {
            Args.notNull(cookie, "Cookie");
            Args.notNull(cookieorigin, "Cookie origin");
            String s = cookieorigin.getPath();
            cookieorigin = cookie.getPath();
            cookie = cookieorigin;
            if (cookieorigin == null)
            {
                cookie = "/";
            }
            cookieorigin = cookie;
            if (cookie.length() > 1)
            {
                cookieorigin = cookie;
                if (cookie.endsWith("/"))
                {
                    cookieorigin = cookie.substring(0, cookie.length() - 1);
                }
            }
            boolean flag1 = s.startsWith(cookieorigin);
            boolean flag = flag1;
            if (flag1)
            {
                flag = flag1;
                if (s.length() != cookieorigin.length())
                {
                    flag = flag1;
                    if (!cookieorigin.endsWith("/"))
                    {
                        if (s.charAt(cookieorigin.length()) != '/')
                        {
                            break label0;
                        }
                        flag = true;
                    }
                }
            }
            return flag;
        }
        return false;
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        Args.notNull(setcookie, "Cookie");
        if (TextUtils.isBlank(s))
        {
            s = "/";
        }
        setcookie.setPath(s);
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        if (!match(cookie, cookieorigin))
        {
            throw new CookieRestrictionViolationException((new StringBuilder()).append("Illegal path attribute \"").append(cookie.getPath()).append("\". Path of origin: \"").append(cookieorigin.getPath()).append("\"").toString());
        } else
        {
            return;
        }
    }
}
