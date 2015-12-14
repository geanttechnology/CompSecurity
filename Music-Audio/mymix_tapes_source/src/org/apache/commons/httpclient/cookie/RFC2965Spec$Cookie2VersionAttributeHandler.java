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
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie instanceof Cookie2)
        {
            cookie = (Cookie2)cookie;
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
            }
            cookie.setVersion(i);
            cookie.setVersionAttributeSpecified(true);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if ((cookie instanceof Cookie2) && !((Cookie2)cookie).isVersionAttributeSpecified())
        {
            throw new MalformedCookieException("Violates RFC 2965. Version attribute is required.");
        } else
        {
            return;
        }
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
