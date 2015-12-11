// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.amazon.device.crashmanager.CrashDetectionHelper;
import com.amazon.mShop.net.UrlLogger;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.web.MShopWebActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.util:
//            Util, BuildUtils, EmailComposer, ActivityUtils

public class WebUtils
{

    static final int EMAIL_NEEDS_CRASH_REPORT;
    static final int PROVIDE_BETA_FEEDBACK_ADDRESS_ID;
    static final int PROVIDE_BETA_FEEDBACK_SUBJECT_ID;
    static final int PROVIDE_FEEDBACK_ADDRESS_ID;

    public WebUtils()
    {
    }

    private static String buildFullUrl(String s, String s1)
    {
        String s2 = s;
        String s3 = s2;
        if (!Util.isEmpty(s1))
        {
            s3 = s2;
            if (!Util.isEmpty(s))
            {
                s = Uri.parse(s).buildUpon();
                s.appendPath((new StringBuilder()).append("ref=").append(s1).toString());
                s3 = s.build().toString();
            }
        }
        return s3;
    }

    private static String getCrashBody(Context context)
    {
        String s = AndroidPlatform.getInstance().getDeviceId();
        return String.format("\n\n\n\n\n\n--------------------------------------------------\n%s", new Object[] {
            context.getResources().getString(com.amazon.mShop.android.lib.R.string.do_not_remove_device_id, new Object[] {
                s
            })
        });
    }

    public static boolean handleMailtoLink(Context context, String s)
    {
        if (s.startsWith("mailto:"))
        {
            HashMap hashmap = new HashMap();
            Object obj = Uri.parse(s.substring("mailto:".length()));
            s = ((Uri) (obj)).getEncodedQuery();
            if (s != null)
            {
                String as[] = s.split("&");
                int j = as.length;
                int i = 0;
                while (i < j) 
                {
                    s = as[i].split("=");
                    if (s.length != 0)
                    {
                        String s2 = Uri.decode(s[0]).toLowerCase();
                        if (s.length > 1)
                        {
                            s = Uri.decode(s[1]);
                        } else
                        {
                            s = null;
                        }
                        hashmap.put(s2, s);
                    }
                    i++;
                }
            }
            Object obj2 = context.getResources();
            s = new HashSet(Arrays.asList(((Resources) (obj2)).getStringArray(EMAIL_NEEDS_CRASH_REPORT)));
            String s1 = ((Uri) (obj)).getPath();
            boolean flag = s.contains(s1);
            Object obj1 = (String)hashmap.get("subject");
            s = ((String) (obj1));
            obj = s1;
            if (s1.equals(Integer.valueOf(PROVIDE_FEEDBACK_ADDRESS_ID)))
            {
                s = ((String) (obj1));
                obj = s1;
                if (!TextUtils.isEmpty(BuildUtils.getBetaName(context)))
                {
                    obj = ((Resources) (obj2)).getString(PROVIDE_BETA_FEEDBACK_ADDRESS_ID);
                    s = ((Resources) (obj2)).getString(PROVIDE_BETA_FEEDBACK_SUBJECT_ID, new Object[] {
                        BuildUtils.getRevisionNumber(context)
                    });
                }
            }
            String as1[] = null;
            obj1 = (String)hashmap.get("to");
            if (!Util.isEmpty(((String) (obj1))))
            {
                as1 = ((String) (obj1)).split(",");
            }
            obj1 = new ArrayList();
            ((List) (obj1)).add(obj);
            obj2 = new ArrayList();
            if (!Util.isEmpty(as1))
            {
                Collections.addAll(((java.util.Collection) (obj1)), as1);
            }
            obj = (String)hashmap.get("cc");
            if (!Util.isEmpty(((String) (obj))))
            {
                Collections.addAll(((java.util.Collection) (obj2)), ((String) (obj)).split(","));
            }
            if (flag)
            {
                obj = getCrashBody(context);
            } else
            {
                obj = (String)hashmap.get("body");
            }
            if (flag && CrashDetectionHelper.getInstance() != null)
            {
                CrashDetectionHelper.getInstance().reportCrash(new RuntimeException("Contact Us Exception"));
            }
            (new EmailComposer(context, ((List) (obj1)), ((List) (obj2)), s, ((String) (obj)))).composeEmail();
            return true;
        } else
        {
            return false;
        }
    }

    public static void initializeCookiesForDevoHost(String s, String s1)
    {
        s = Uri.parse(s).getHost();
        if (isDevoHost(s))
        {
            s1 = CookieManager.getInstance().getCookie((new StringBuilder()).append("https://www").append(s1).toString()).split(";");
            int j = s1.length;
            for (int i = 0; i < j; i++)
            {
                String s2 = s1[i];
                CookieManager.getInstance().setCookie(s, s2.trim());
            }

        }
    }

    public static boolean isBaseUrlEqual(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            int i = s.indexOf("#");
            int j = s1.indexOf("#");
            if (i < 0)
            {
                i = s.length();
            }
            if (j < 0)
            {
                j = s1.length();
            }
            if (i == j && s.substring(0, i).equalsIgnoreCase(s1.substring(0, j)))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isDefined(String s)
    {
        return s != null && s.length() != 0 && !"undefined".equalsIgnoreCase(s);
    }

    public static boolean isDevoHost(String s)
    {
        while (Util.isEmpty(s) || s.endsWith("www.amazon.com") || !s.endsWith(".amazonpmi.com") && !s.endsWith(".amazon.com")) 
        {
            return false;
        }
        return true;
    }

    public static boolean isFragmentUrl(String s)
    {
        return !Util.isEmpty(s) && !Util.isEmpty(Uri.parse(s).getFragment());
    }

    public static void logRefMarkerForWebPage(Uri uri)
    {
        try
        {
            uri = uri.getPathSegments().iterator();
            do
            {
                if (!uri.hasNext())
                {
                    break;
                }
                String s = (String)uri.next();
                if (s.indexOf("ref=") == 0)
                {
                    UrlLogger.logURL((new StringBuilder()).append("/").append(s).toString());
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri) { }
    }

    public static void openWebview(Context context, String s)
    {
        context.startActivity(ActivityUtils.getStartWebActivityIntent(context, com/amazon/mShop/web/MShopWebActivity, s, -1));
    }

    public static void openWebview(Context context, String s, String s1)
    {
        context.startActivity(ActivityUtils.getStartWebActivityIntent(context, com/amazon/mShop/web/MShopWebActivity, buildFullUrl(s, s1), -1));
    }

    public static String parseQueryToJsObject(Uri uri)
    {
        StringBuilder stringbuilder = new StringBuilder("{");
        uri = uri.getEncodedQuery();
        if (!Util.isEmpty(uri))
        {
            uri = uri.split("&");
            int l = uri.length;
            int j = 0;
            int i = 0;
            while (j < l) 
            {
                String as[] = uri[j].split("=");
                if (as.length == 2)
                {
                    String s = Uri.decode(as[0]).trim();
                    String s1 = Uri.decode(as[1]).trim();
                    if (!"app-action".equals(s))
                    {
                        int k = i + 1;
                        if (i != 0)
                        {
                            stringbuilder.append(",");
                        }
                        stringbuilder.append("'");
                        stringbuilder.append(s);
                        stringbuilder.append("':'");
                        stringbuilder.append(s1);
                        stringbuilder.append("'");
                        i = k;
                    }
                }
                j++;
            }
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    static 
    {
        PROVIDE_FEEDBACK_ADDRESS_ID = com.amazon.mShop.android.lib.R.string.provide_feedback_to_address_android;
        PROVIDE_BETA_FEEDBACK_ADDRESS_ID = com.amazon.mShop.android.lib.R.string.provide_beta_feedback_to_address_android;
        PROVIDE_BETA_FEEDBACK_SUBJECT_ID = com.amazon.mShop.android.lib.R.string.provide_beta_feedback_subject_android;
        EMAIL_NEEDS_CRASH_REPORT = com.amazon.mShop.android.lib.R.array.needsCrashEmailList;
    }
}
