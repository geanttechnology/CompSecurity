// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.controllers.GetPopularItemsController;
import com.socialin.android.apiv3.controllers.GetRecentItemsController;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Utils
{

    public Utils()
    {
    }

    private static void clearCookiesForDomain(Context context, String s)
    {
        CookieSyncManager.createInstance(context).sync();
        context = CookieManager.getInstance();
        String s1 = context.getCookie(s);
        if (s1 == null)
        {
            return;
        }
        String as[] = s1.split(";");
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String as1[] = as[i].split("=");
            if (as1.length > 0)
            {
                context.setCookie(s, (new StringBuilder()).append(as1[0].trim()).append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;").toString());
            }
        }

        context.removeExpiredCookie();
    }

    public static void clearFacebookCookies(Context context)
    {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }

    public static String getCountryCode(Context context)
    {
        Object obj;
        Object obj1;
        obj1 = new File(context.getCacheDir(), "location.txt");
        obj = new StringBuilder();
        obj1 = new BufferedReader(new FileReader(((File) (obj1))));
_L1:
        String s = ((BufferedReader) (obj1)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        ((StringBuilder) (obj)).append(s);
          goto _L1
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            context = context.getResources().getConfiguration().locale;
            if (context != null)
            {
                return context.getCountry().toLowerCase();
            } else
            {
                return "";
            }
        } else
        {
            return ((StringBuilder) (obj)).toString();
        }
    }

    public static BaseSocialinApiRequestController getImageItemRequestControllerByCode(int i)
    {
        BaseSocialinApiRequestController basesocialinapirequestcontroller;
        switch (i)
        {
        default:
            return RequestControllerFactory.createSearchItemsController();

        case 2: // '\002'
            return new GetPopularItemsController();

        case 3: // '\003'
            return new GetRecentItemsController();

        case 1: // '\001'
            basesocialinapirequestcontroller = RequestControllerFactory.createSearchItemsController();
            break;
        }
        basesocialinapirequestcontroller.setCode(1);
        return basesocialinapirequestcontroller;
    }
}
