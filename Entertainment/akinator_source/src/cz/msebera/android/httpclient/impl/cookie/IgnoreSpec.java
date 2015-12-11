// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import java.util.Collections;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            CookieSpecBase

public class IgnoreSpec extends CookieSpecBase
{

    public IgnoreSpec()
    {
    }

    public List formatCookies(List list)
    {
        return Collections.emptyList();
    }

    public int getVersion()
    {
        return 0;
    }

    public Header getVersionHeader()
    {
        return null;
    }

    public List parse(Header header, CookieOrigin cookieorigin)
        throws MalformedCookieException
    {
        return Collections.emptyList();
    }
}
