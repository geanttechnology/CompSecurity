// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.logging.Log;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieAttributeHandler, RFC2965Spec, CookieOrigin, CookieSpecBase, 
//            MalformedCookieException

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
        String s = cookieorigin.getPath();
        if (cookie.getPath() == null)
        {
            CookieSpecBase.LOG.warn("Invalid cookie state: path attribute is null.");
        } else
        {
            cookieorigin = s;
            if (s.trim().equals(""))
            {
                cookieorigin = "/";
            }
            if (pathMatch(cookieorigin, cookie.getPath()))
            {
                return true;
            }
        }
        return false;
    }

    public void parse(Cookie cookie, String s)
        throws MalformedCookieException
    {
        if (cookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for path attribute");
        }
        if (s.trim().equals(""))
        {
            throw new MalformedCookieException("Blank value for path attribute");
        } else
        {
            cookie.setPath(s);
            cookie.setPathAttributeSpecified(true);
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
        if (cookieorigin == null)
        {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        String s = cookieorigin.getPath();
        if (s == null)
        {
            throw new IllegalArgumentException("Path of origin host may not be null.");
        }
        if (cookie.getPath() == null)
        {
            throw new MalformedCookieException("Invalid cookie state: path attribute is null.");
        }
        cookieorigin = s;
        if (s.trim().equals(""))
        {
            cookieorigin = "/";
        }
        if (!pathMatch(cookieorigin, cookie.getPath()))
        {
            throw new MalformedCookieException("Illegal path attribute \"" + cookie.getPath() + "\". Path of origin: \"" + cookieorigin + "\"");
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
