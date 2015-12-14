// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieAttributeHandler, RFC2965Spec, MalformedCookieException, Cookie2, 
//            CookieOrigin

private class <init>
    implements CookieAttributeHandler
{

    private final RFC2965Spec this$0;

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        return true;
    }

    public void parse(Cookie cookie, String s)
        throws MalformedCookieException
    {
        if (cookie instanceof Cookie2)
        {
            ((Cookie2)cookie).setDiscard(true);
        }
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
