// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.Collection;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            CookieSpec, MalformedCookieException

public class IgnoreCookiesSpec
    implements CookieSpec
{

    public IgnoreCookiesSpec()
    {
    }

    public boolean domainMatch(String s, String s1)
    {
        return false;
    }

    public String formatCookie(Cookie cookie)
    {
        return null;
    }

    public Header formatCookieHeader(Cookie cookie)
        throws IllegalArgumentException
    {
        return null;
    }

    public Header formatCookieHeader(Cookie acookie[])
        throws IllegalArgumentException
    {
        return null;
    }

    public String formatCookies(Cookie acookie[])
        throws IllegalArgumentException
    {
        return null;
    }

    public Collection getValidDateFormats()
    {
        return null;
    }

    public boolean match(String s, int i, String s1, boolean flag, Cookie cookie)
    {
        return false;
    }

    public Cookie[] match(String s, int i, String s1, boolean flag, Cookie acookie[])
    {
        return new Cookie[0];
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, String s2)
        throws MalformedCookieException
    {
        return new Cookie[0];
    }

    public Cookie[] parse(String s, int i, String s1, boolean flag, Header header)
        throws MalformedCookieException, IllegalArgumentException
    {
        return new Cookie[0];
    }

    public void parseAttribute(NameValuePair namevaluepair, Cookie cookie)
        throws MalformedCookieException, IllegalArgumentException
    {
    }

    public boolean pathMatch(String s, String s1)
    {
        return false;
    }

    public void setValidDateFormats(Collection collection)
    {
    }

    public void validate(String s, int i, String s1, boolean flag, Cookie cookie)
        throws MalformedCookieException, IllegalArgumentException
    {
    }
}
