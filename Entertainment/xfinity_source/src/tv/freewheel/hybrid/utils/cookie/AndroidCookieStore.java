// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils.cookie;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.URLLoader;

// Referenced classes of package tv.freewheel.hybrid.utils.cookie:
//            IAndroidCookieStore

public class AndroidCookieStore
    implements IAndroidCookieStore
{

    public static Context context;
    private Logger logger;

    public AndroidCookieStore()
        throws ClassNotFoundException
    {
        Class.forName("android.webkit.CookieManager", true, tv/freewheel/hybrid/utils/URLLoader.getClassLoader());
        logger = Logger.getLogger(this);
    }

    public static void initialize(Context context1)
    {
        context = context1;
        CookieSyncManager.createInstance(context1);
        CookieManager.getInstance().removeExpiredCookie();
    }

    public String getCookie(String s)
    {
        return CookieManager.getInstance().getCookie(s);
    }

    public void removeExpiredCookie()
    {
        CookieManager.getInstance().removeExpiredCookie();
    }

    public void setCookie(String s, String s1)
    {
        logger.verbose((new StringBuilder()).append("got cookie: ").append(s1).append(", for url: ").append(s).toString());
        CookieManager.getInstance().setCookie(s, s1);
        CookieSyncManager.getInstance().sync();
    }
}
