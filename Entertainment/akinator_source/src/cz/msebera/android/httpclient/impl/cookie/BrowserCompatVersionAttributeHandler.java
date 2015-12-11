// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            AbstractCookieAttributeHandler

public class BrowserCompatVersionAttributeHandler extends AbstractCookieAttributeHandler
{

    public BrowserCompatVersionAttributeHandler()
    {
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        int i;
        Args.notNull(setcookie, "Cookie");
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for version attribute");
        }
        i = 0;
        int j = Integer.parseInt(s);
        i = j;
_L2:
        setcookie.setVersion(i);
        return;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
