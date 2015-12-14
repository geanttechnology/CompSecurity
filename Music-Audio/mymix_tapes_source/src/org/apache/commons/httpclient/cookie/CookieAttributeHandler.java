// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            MalformedCookieException, CookieOrigin

public interface CookieAttributeHandler
{

    public abstract boolean match(Cookie cookie, CookieOrigin cookieorigin);

    public abstract void parse(Cookie cookie, String s)
        throws MalformedCookieException;

    public abstract void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException;
}
