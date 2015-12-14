// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.Collection;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;

// Referenced classes of package org.apache.commons.httpclient.cookie:
//            MalformedCookieException

public interface CookieSpec
{

    public static final String PATH_DELIM = "/";
    public static final char PATH_DELIM_CHAR = "/".charAt(0);

    public abstract boolean domainMatch(String s, String s1);

    public abstract String formatCookie(Cookie cookie);

    public abstract Header formatCookieHeader(Cookie cookie)
        throws IllegalArgumentException;

    public abstract Header formatCookieHeader(Cookie acookie[])
        throws IllegalArgumentException;

    public abstract String formatCookies(Cookie acookie[])
        throws IllegalArgumentException;

    public abstract Collection getValidDateFormats();

    public abstract boolean match(String s, int i, String s1, boolean flag, Cookie cookie);

    public abstract Cookie[] match(String s, int i, String s1, boolean flag, Cookie acookie[]);

    public abstract Cookie[] parse(String s, int i, String s1, boolean flag, String s2)
        throws MalformedCookieException, IllegalArgumentException;

    public abstract Cookie[] parse(String s, int i, String s1, boolean flag, Header header)
        throws MalformedCookieException, IllegalArgumentException;

    public abstract void parseAttribute(NameValuePair namevaluepair, Cookie cookie)
        throws MalformedCookieException, IllegalArgumentException;

    public abstract boolean pathMatch(String s, String s1);

    public abstract void setValidDateFormats(Collection collection);

    public abstract void validate(String s, int i, String s1, boolean flag, Cookie cookie)
        throws MalformedCookieException, IllegalArgumentException;

}
