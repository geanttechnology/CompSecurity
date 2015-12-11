// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.cookie;

import com.comcast.cim.httpcomponentsandroid.cookie.Cookie;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieAttributeHandler;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieOrigin;
import com.comcast.cim.httpcomponentsandroid.cookie.MalformedCookieException;
import com.comcast.cim.httpcomponentsandroid.cookie.SetCookie;
import com.comcast.cim.httpcomponentsandroid.cookie.SetCookie2;

public class RFC2965CommentUrlAttributeHandler
    implements CookieAttributeHandler
{

    public RFC2965CommentUrlAttributeHandler()
    {
    }

    public boolean match(Cookie cookie, CookieOrigin cookieorigin)
    {
        return true;
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        if (setcookie instanceof SetCookie2)
        {
            ((SetCookie2)setcookie).setCommentURL(s);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
    }
}
