// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            AidTask, MD5

public class Utility
{

    private static final String DEFAULT_CHARSET = "UTF-8";

    public Utility()
    {
    }

    public static Bundle decodeUrl(String s)
    {
        Bundle bundle = new Bundle();
        if (s == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        s = s.split("&");
        j = s.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return bundle;
_L3:
        String as[] = s[i].split("=");
        try
        {
            bundle.putString(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String generateGUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generateUA(Context context)
    {
        context = new StringBuilder();
        context.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        context.append("_");
        context.append(android.os.Build.VERSION.RELEASE);
        context.append("_");
        context.append("weibosdk");
        context.append("_");
        context.append("0031205000");
        context.append("_android");
        return context.toString();
    }

    public static String getAid(Context context, String s)
    {
        context = AidTask.getInstance(context).getAidSync(s);
        if (context != null)
        {
            return context.getAid();
        } else
        {
            return "";
        }
    }

    public static String getSign(Context context, String s)
    {
        int i;
        try
        {
            context = context.getPackageManager().getPackageInfo(s, 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        i = 0;
        do
        {
            if (i >= ((PackageInfo) (context)).signatures.length)
            {
                return null;
            }
            s = ((PackageInfo) (context)).signatures[i].toByteArray();
            if (s != null)
            {
                return MD5.hexdigest(s);
            }
            i++;
        } while (true);
    }

    public static boolean isChineseLocale(Context context)
    {
label0:
        {
label1:
            {
                boolean flag;
                try
                {
                    context = context.getResources().getConfiguration().locale;
                    if (Locale.CHINA.equals(context) || Locale.CHINESE.equals(context) || Locale.SIMPLIFIED_CHINESE.equals(context))
                    {
                        break label1;
                    }
                    flag = Locale.TAIWAN.equals(context);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return true;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public static Bundle parseUri(String s)
    {
        try
        {
            s = decodeUrl((new URI(s)).getQuery());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new Bundle();
        }
        return s;
    }

    public static Bundle parseUrl(String s)
    {
        Bundle bundle;
        try
        {
            s = new URL(s);
            bundle = decodeUrl(s.getQuery());
            bundle.putAll(decodeUrl(s.getRef()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new Bundle();
        }
        return bundle;
    }

    public static String safeString(String s)
    {
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = "";
        }
        return s1;
    }
}
