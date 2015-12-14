// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieAttributeHandler, RFC2965Spec, Cookie2, CookieOrigin, 
//            CookieSpecBase, MalformedCookieException

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
        if (!(cookie instanceof Cookie2)) goto _L2; else goto _L1
_L1:
        int i;
        cookie = (Cookie2)cookie;
        i = cookieorigin.getPort();
        if (!cookie.isPortAttributeSpecified()) goto _L4; else goto _L3
_L3:
        if (cookie.getPorts() != null) goto _L6; else goto _L5
_L5:
        CookieSpecBase.LOG.warn("Invalid cookie state: port not specified");
_L2:
        return false;
_L6:
        if (!RFC2965Spec.access$1000(RFC2965Spec.this, i, cookie.getPorts())) goto _L2; else goto _L4
_L4:
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
            if (s == null || s.trim().equals(""))
            {
                cookie.setPortAttributeBlank(true);
            } else
            {
                cookie.setPorts(RFC2965Spec.access$900(RFC2965Spec.this, s));
            }
            cookie.setPortAttributeSpecified(true);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookieorigin == null)
        {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        if (cookie instanceof Cookie2)
        {
            cookie = (Cookie2)cookie;
            int i = cookieorigin.getPort();
            if (cookie.isPortAttributeSpecified() && !RFC2965Spec.access$1000(RFC2965Spec.this, i, cookie.getPorts()))
            {
                throw new MalformedCookieException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
            }
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
