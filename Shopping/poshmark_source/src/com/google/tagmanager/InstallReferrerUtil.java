// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            SharedPreferencesUtil

class InstallReferrerUtil
{

    static final String INTENT_EXTRA_REFERRER = "referrer";
    static final String PREF_KEY_REFERRER = "referrer";
    static final String PREF_NAME_CLICK_REFERRERS = "gtm_click_referrers";
    static final String PREF_NAME_INSTALL_REFERRER = "gtm_install_referrer";
    static Map clickReferrers = new HashMap();
    private static String installReferrer;

    InstallReferrerUtil()
    {
    }

    static void addClickReferrer(Context context, String s)
    {
        String s1 = extractComponent(s, "conv");
        if (s1 != null && s1.length() > 0)
        {
            clickReferrers.put(s1, s);
            SharedPreferencesUtil.saveAsync(context, "gtm_click_referrers", s1, s);
        }
    }

    static void cacheInstallReferrer(String s)
    {
        com/google/tagmanager/InstallReferrerUtil;
        JVM INSTR monitorenter ;
        installReferrer = s;
        com/google/tagmanager/InstallReferrerUtil;
        JVM INSTR monitorexit ;
        return;
        s;
        com/google/tagmanager/InstallReferrerUtil;
        JVM INSTR monitorexit ;
        throw s;
    }

    static String extractComponent(String s, String s1)
    {
        if (s1 == null)
        {
            if (s.length() > 0)
            {
                return s;
            } else
            {
                return null;
            }
        } else
        {
            return Uri.parse((new StringBuilder()).append("http://hostname/?").append(s).toString()).getQueryParameter(s1);
        }
    }

    static String getClickReferrer(Context context, String s, String s1)
    {
        String s2 = (String)clickReferrers.get(s);
        Object obj = s2;
        if (s2 == null)
        {
            context = context.getSharedPreferences("gtm_click_referrers", 0);
            if (context != null)
            {
                context = context.getString(s, "");
            } else
            {
                context = "";
            }
            clickReferrers.put(s, context);
            obj = context;
        }
        return extractComponent(((String) (obj)), s1);
    }

    static String getInstallReferrer(Context context, String s)
    {
        if (installReferrer != null) goto _L2; else goto _L1
_L1:
        com/google/tagmanager/InstallReferrerUtil;
        JVM INSTR monitorenter ;
        if (installReferrer != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        context = context.getSharedPreferences("gtm_install_referrer", 0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        installReferrer = context.getString("referrer", "");
_L3:
        com/google/tagmanager/InstallReferrerUtil;
        JVM INSTR monitorexit ;
_L2:
        return extractComponent(installReferrer, s);
        installReferrer = "";
          goto _L3
        context;
        com/google/tagmanager/InstallReferrerUtil;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void saveInstallReferrer(Context context, String s)
    {
        SharedPreferencesUtil.saveAsync(context, "gtm_install_referrer", "referrer", s);
        addClickReferrer(context, s);
    }

}
