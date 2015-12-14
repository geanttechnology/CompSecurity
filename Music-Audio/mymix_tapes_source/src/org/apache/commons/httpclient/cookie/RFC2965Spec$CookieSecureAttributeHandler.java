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
        return cookie.getSecure() == cookieorigin.isSecure();
    }

    public void parse(Cookie cookie, String s)
        throws MalformedCookieException
    {
        cookie.setSecure(true);
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
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
