// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.content.Context;
import android.util.Log;
import com.amazon.now.platform.AndroidPlatform;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

// Referenced classes of package com.amazon.now.util:
//            AppUtils

public class NetUtil
{

    public NetUtil()
    {
    }

    private static Proxy getProxy(String s)
    {
        Proxy proxy = Proxy.NO_PROXY;
        Object obj = proxy;
        if (!AppUtils.isAppDebuggable(AndroidPlatform.getInstance().getApplicationContext()))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = ProxySelector.getDefault();
        try
        {
            s = ((ProxySelector) (obj)).select(new URI(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(com/amazon/now/util/NetUtil.getSimpleName(), "unable to parse URI", s);
            return proxy;
        }
        obj = proxy;
        if (s.size() > 0)
        {
            obj = (Proxy)s.get(0);
        }
        return ((Proxy) (obj));
    }

    public static URLConnection getURLConnection(String s)
        throws IOException
    {
        if (haveInternetPermission())
        {
            return (new URL(s)).openConnection(getProxy(s));
        } else
        {
            throw new IOException("Internet Permission denied");
        }
    }

    public static boolean haveInternetPermission()
    {
        return AndroidPlatform.getInstance().getApplicationContext().checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }
}
