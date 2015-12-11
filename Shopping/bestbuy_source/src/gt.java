// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.webkit.CookieManager;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;

public class gt
{

    public static void a()
    {
        CookieManager cookiemanager = CookieManager.getInstance();
        Object obj = gw.a().getCookieStore().getCookies();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Cookie cookie = (Cookie)((Iterator) (obj)).next();
                String s = (new StringBuilder()).append(cookie.getName()).append("=").append(cookie.getValue()).append("; Domain=").append(cookie.getDomain()).toString();
                if (cookie != null && s != null && cookie.getName() != null)
                {
                    if (!cookie.getName().trim().equals("bby_rdp"))
                    {
                        cookiemanager.setCookie(".bestbuy.com", s);
                    } else
                    {
                        cookiemanager.setCookie(".bestbuy.com", (new StringBuilder()).append(cookie.getName()).append("=").append("s").append("; Domain=").append(cookie.getDomain()).toString());
                    }
                }
            } while (true);
        }
    }

    public static void a(DefaultHttpClient defaulthttpclient)
    {
        defaulthttpclient.setCookieStore(b());
    }

    public static BasicCookieStore b()
    {
        Object obj = CookieManager.getInstance();
        BasicCookieStore basiccookiestore = new BasicCookieStore();
        obj = ((CookieManager) (obj)).getCookie("http://www.bestbuy.com");
        if (obj != null)
        {
            String as[] = ((String) (obj)).split(";");
            int i = 0;
            while (i < as.length) 
            {
                Object obj1 = as[i].split("=");
                if (obj1.length == 2)
                {
                    if (obj1[0].trim().equals("bby_rdp"))
                    {
                        obj1 = new BasicClientCookie(obj1[0], "s");
                    } else
                    {
                        obj1 = new BasicClientCookie(obj1[0], obj1[1]);
                    }
                } else
                {
                    obj1 = new BasicClientCookie(obj1[0], null);
                }
                ((BasicClientCookie) (obj1)).setDomain(".bestbuy.com");
                basiccookiestore.addCookie(((Cookie) (obj1)));
                i++;
            }
        }
        return basiccookiestore;
    }
}
