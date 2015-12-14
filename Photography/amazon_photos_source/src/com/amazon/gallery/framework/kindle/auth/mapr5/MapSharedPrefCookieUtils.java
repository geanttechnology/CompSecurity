// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.CookieManager;
import com.amazon.gallery.thor.GalleryWebViewHelper;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapSharedPrefCookieUtils
{

    private final Context context;
    private final SharedPreferences prefs;

    public MapSharedPrefCookieUtils(Context context1)
    {
        context = context1;
        prefs = context1.getSharedPreferences("cookie_shared_prefs", 0);
    }

    public void putCookies(String s, String as[])
    {
        prefs.edit().putStringSet(s, Sets.newHashSet(as)).apply();
    }

    public void removeAllCookies()
    {
        CookieManager cookiemanager = CookieManager.getInstance();
        for (Iterator iterator = prefs.getAll().keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Iterator iterator1 = prefs.getStringSet(s, Collections.emptySet()).iterator();
            while (iterator1.hasNext()) 
            {
                cookiemanager.setCookie(s, String.format("%s=; Expires=Thu, 01 Jan 1970 00:00:00 GMT", new Object[] {
                    ((String)iterator1.next()).split("=")[0].trim()
                }));
            }
        }

        GalleryWebViewHelper.sync(context, cookiemanager);
        prefs.edit().clear().apply();
    }
}
