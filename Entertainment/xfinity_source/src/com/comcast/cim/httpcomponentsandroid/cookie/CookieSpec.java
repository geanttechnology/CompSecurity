// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.cookie;

import com.comcast.cim.httpcomponentsandroid.Header;
import java.util.List;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.cookie:
//            MalformedCookieException, Cookie, CookieOrigin

public interface CookieSpec
{

    public abstract List formatCookies(List list);

    public abstract int getVersion();

    public abstract Header getVersionHeader();

    public abstract boolean match(Cookie cookie, CookieOrigin cookieorigin);

    public abstract List parse(Header header, CookieOrigin cookieorigin)
        throws MalformedCookieException;

    public abstract void validate(Cookie cookie, CookieOrigin cookieorigin)
        throws MalformedCookieException;
}
