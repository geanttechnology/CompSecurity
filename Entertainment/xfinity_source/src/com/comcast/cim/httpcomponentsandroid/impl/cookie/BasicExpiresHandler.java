// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.cookie;

import com.comcast.cim.httpcomponentsandroid.cookie.MalformedCookieException;
import com.comcast.cim.httpcomponentsandroid.cookie.SetCookie;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.cookie:
//            AbstractCookieAttributeHandler, DateParseException, DateUtils

public class BasicExpiresHandler extends AbstractCookieAttributeHandler
{

    private final String datepatterns[];

    public BasicExpiresHandler(String as[])
    {
        if (as == null)
        {
            throw new IllegalArgumentException("Array of date patterns may not be null");
        } else
        {
            datepatterns = as;
            return;
        }
    }

    public void parse(SetCookie setcookie, String s)
        throws MalformedCookieException
    {
        if (setcookie == null)
        {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (s == null)
        {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        try
        {
            setcookie.setExpiryDate(DateUtils.parseDate(s, datepatterns));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SetCookie setcookie)
        {
            throw new MalformedCookieException((new StringBuilder()).append("Unable to parse expires attribute: ").append(s).toString());
        }
    }
}
