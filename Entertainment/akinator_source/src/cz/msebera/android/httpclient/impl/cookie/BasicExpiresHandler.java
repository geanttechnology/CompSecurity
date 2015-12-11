// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            AbstractCookieAttributeHandler

public class BasicExpiresHandler extends AbstractCookieAttributeHandler
{

    private final String datepatterns[];

    public BasicExpiresHandler(String as[])
    {
        Args.notNull(as, "Array of date patterns");
        datepatterns = as;
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        Args.notNull(setcookie, "Cookie");
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        java.util.Date date = DateUtils.parseDate(s, datepatterns);
        if (date == null)
        {
            throw new MalformedCookieException((new StringBuilder()).append("Unable to parse expires attribute: ").append(s).toString());
        } else
        {
            setcookie.setExpiryDate(date);
            return;
        }
    }
}
