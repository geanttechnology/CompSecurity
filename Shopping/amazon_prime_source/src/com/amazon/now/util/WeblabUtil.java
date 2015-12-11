// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amazon.now.account.SSO;
import com.amazon.now.platform.AndroidPlatform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.util:
//            DataStore, AppUtils

public class WeblabUtil
{

    private static final String TAG = com/amazon/now/util/WeblabUtil.getSimpleName();
    private static Map sWeblabTreatment;

    public WeblabUtil()
    {
    }

    public static void clearWeblabs()
    {
        DataStore.putString("weblabOverrides", null);
        CookieManager.getInstance().setCookie(AppUtils.getServiceDomain(), "experiment=;");
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            CookieSyncManager.getInstance().sync();
            return;
        } else
        {
            CookieManager.getInstance().flush();
            return;
        }
    }

    private static String getSavedWeblabOverrides()
    {
        return DataStore.getString("weblabOverrides");
    }

    public static String getTreatment(String s)
    {
        if (sWeblabTreatment == null)
        {
            saveTreatment(DataStore.getString("weblabString"));
        }
        if (!sWeblabTreatment.containsKey(s))
        {
            return "C";
        } else
        {
            return (String)sWeblabTreatment.get(s);
        }
    }

    public static String getWeblabString()
    {
        Object obj = parseWeblabString(getSavedWeblabOverrides());
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((String)entry.getKey()).append(":").append((String)entry.getValue()).append("\n"))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        return stringbuilder.toString();
    }

    private static Map parseWeblabString(String s)
    {
        HashMap hashmap = new HashMap();
        if (!TextUtils.isEmpty(s))
        {
            s = s.split("\\|");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                CharSequence charsequence = s[i];
                if (TextUtils.isEmpty(charsequence))
                {
                    continue;
                }
                String as[] = charsequence.split(":");
                if (as.length == 2)
                {
                    hashmap.put(as[0], as[1]);
                }
            }

        }
        return hashmap;
    }

    public static void saveTreatment(String s)
    {
        if (sWeblabTreatment == null)
        {
            sWeblabTreatment = new HashMap();
        }
        if (!TextUtils.isEmpty(s) && (sWeblabTreatment.isEmpty() || !s.equalsIgnoreCase(DataStore.getString("weblabString")))) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject;
        int i;
        int j;
        try
        {
            DataStore.putString("weblabString", s);
            sWeblabTreatment.clear();
            s = new JSONArray(s);
            j = s.length();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Error during store JSON parsing", s);
            return;
        }
        i = 0;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = s.optJSONObject(i);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        sWeblabTreatment.put(jsonobject.optString("weblabName"), jsonobject.optString("treatment", "C"));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_118;
_L4:
        break MISSING_BLOCK_LABEL_77;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static void saveWeblabs(String s)
    {
        String s2 = getSavedWeblabOverrides();
        String s1 = s;
        if (!TextUtils.isEmpty(s2))
        {
            if (TextUtils.isEmpty(s))
            {
                s1 = s2;
            } else
            {
                s1 = (new StringBuilder()).append(s2).append("|").append(s).toString();
            }
        }
        if (!TextUtils.isEmpty(s1))
        {
            DataStore.putString("weblabOverrides", s1);
            setCookie(parseWeblabString(s1));
        }
    }

    private static void setCookie(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder("experiment=");
        boolean flag = false;
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (flag)
            {
                stringbuilder.append('&');
            }
            stringbuilder.append((String)entry.getKey()).append(":").append((String)entry.getValue());
            flag = true;
        }

        stringbuilder.append(';');
        CookieManager.getInstance().setCookie(AppUtils.getServiceDomain(), stringbuilder.toString());
        map = SSO.getMAPDomain(AndroidPlatform.getInstance().getApplicationContext());
        if (!AppUtils.getServiceDomain().contains(map))
        {
            CookieManager.getInstance().setCookie(map, stringbuilder.toString());
        }
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            CookieSyncManager.getInstance().sync();
            return;
        } else
        {
            CookieManager.getInstance().flush();
            return;
        }
    }

}
