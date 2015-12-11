// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.interception;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.MASHUtil;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.mobile.mash.interception:
//            UrlIntercepterConfigManager, UrlIntercepterConfigEntry, UrlInterceptionHandler

public class MASHUrlIntercepter
{
    protected static final class UrlDestination extends Enum
    {

        private static final UrlDestination $VALUES[];
        public static final UrlDestination appstore;
        public static final UrlDestination browse;
        public static final UrlDestination cart;
        public static final UrlDestination checkout;
        public static final UrlDestination detail;
        public static final UrlDestination home;
        public static final UrlDestination search;

        public static UrlDestination valueOf(String s)
        {
            return (UrlDestination)Enum.valueOf(com/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination, s);
        }

        public static UrlDestination[] values()
        {
            return (UrlDestination[])$VALUES.clone();
        }

        static 
        {
            home = new UrlDestination("home", 0);
            search = new UrlDestination("search", 1);
            browse = new UrlDestination("browse", 2);
            cart = new UrlDestination("cart", 3);
            detail = new UrlDestination("detail", 4);
            checkout = new UrlDestination("checkout", 5);
            appstore = new UrlDestination("appstore", 6);
            $VALUES = (new UrlDestination[] {
                home, search, browse, cart, detail, checkout, appstore
            });
        }

        private UrlDestination(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/mobile/mash/interception/MASHUrlIntercepter.getSimpleName();
    private static boolean sShouldInterceptUrl = false;

    public MASHUrlIntercepter()
    {
    }

    public static void setShouldInterceptUrl(boolean flag)
    {
        com/amazon/mobile/mash/interception/MASHUrlIntercepter;
        JVM INSTR monitorenter ;
        sShouldInterceptUrl = flag;
        com/amazon/mobile/mash/interception/MASHUrlIntercepter;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean shouldInterceptUrl()
    {
        com/amazon/mobile/mash/interception/MASHUrlIntercepter;
        JVM INSTR monitorenter ;
        boolean flag = sShouldInterceptUrl;
        com/amazon/mobile/mash/interception/MASHUrlIntercepter;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public UrlInterceptionHandler buildHandler(String s, Context context)
    {
        return null;
    }

    public UrlIntercepterConfigEntry getConfigEntryForUri(Uri uri)
    {
        Object obj = UrlIntercepterConfigManager.getInstance().getUrlConfigList();
        String s = (new StringBuilder()).append(uri.getHost()).append(MASHUtil.removeEverythingAfterRefMarker(uri.getPath())).toString();
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            UrlIntercepterConfigEntry urlintercepterconfigentry = (UrlIntercepterConfigEntry)((Iterator) (obj)).next();
            if (urlintercepterconfigentry.matches(s))
            {
                if (MASHDebug.isEnabled())
                {
                    Log.i(TAG, (new StringBuilder()).append("Found entry for: ").append(uri.toString()).append(" Matched: ").append(urlintercepterconfigentry.getDestination().toString()).toString());
                }
                return urlintercepterconfigentry;
            }
        }

        return null;
    }

}
