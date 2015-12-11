// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;

public abstract class AbstractCookieAttributeHandler
    implements CookieAttributeHandler
{

    public AbstractCookieAttributeHandler()
    {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        return true;
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
    }
}
