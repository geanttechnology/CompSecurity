// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils.cookie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.utils.cookie:
//            IAndroidCookieStore

public class DummyAndroidCookieStore
    implements IAndroidCookieStore
{

    public static String MOCK_COOKIE_STRING = "_uid=b000_5511089179943706094;expires=Dec, 21 Aug 2012 06:40:41 GMT;domain=.fwmrm.net;path=/;";
    private Logger logger;
    private HashMap store;

    public DummyAndroidCookieStore()
    {
        logger = Logger.getLogger(this);
        store = new HashMap();
    }

    public String getCookie(String s)
    {
        return (String)store.get(s);
    }

    public void removeAllCookie()
    {
        String s;
        for (Iterator iterator = store.keySet().iterator(); iterator.hasNext(); store.remove(s))
        {
            s = (String)iterator.next();
        }

    }

    public void removeExpiredCookie()
    {
        removeAllCookie();
    }

    public void setCookie(String s, String s1)
    {
        store.put(s, s1);
        logger.debug((new StringBuilder()).append("got cookie: ").append(s1).append(", for url: ").append(s).toString());
    }

}
