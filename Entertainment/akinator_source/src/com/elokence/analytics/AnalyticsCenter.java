// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.elokence.analytics.eventLogging.EAMessage;
import com.elokence.analytics.eventLogging.MessageTransmitter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

// Referenced classes of package com.elokence.analytics:
//            AnalyticsInitCallback

public class AnalyticsCenter
{

    public static final int BUSINESS_MODEL_FREE = 0;
    public static final int BUSINESS_MODEL_INAPP = 1;
    public static final int BUSINESS_MODEL_PAID = 2;
    public static final String NOM_SETTINGS_SHARED_PREFS = "AnalyticsCenterSettings";
    public static final String TAG = "ElokenceAnalytics";
    private static AnalyticsCenter instance = null;
    private boolean booted;
    private AnalyticsInitCallback callback;
    private final Map campaignSet = new TreeMap();
    private android.content.SharedPreferences.Editor editor;
    private String gcmToken;
    private String lang;
    private String locale;
    private String mApplication;
    private int paid;
    private SharedPreferences settings;
    private boolean tablet;
    private String uid;

    private AnalyticsCenter()
    {
        settings = null;
        editor = null;
        lang = null;
        locale = null;
        uid = null;
        gcmToken = null;
        paid = 0;
        tablet = false;
        booted = false;
        callback = null;
    }

    private String getDeviceId(Context context)
    {
        String s;
        String s1;
        String s2;
        s1 = "";
        s2 = "";
        s = s1;
        Object obj = (TelephonyManager)context.getSystemService("phone");
        s = s1;
        s1 = (new StringBuilder()).append("").append(((TelephonyManager) (obj)).getDeviceId()).toString();
        s = s1;
        obj = (new StringBuilder()).append("").append(((TelephonyManager) (obj)).getSimSerialNumber()).toString();
        s2 = ((String) (obj));
        s = s1;
_L2:
        return (new UUID((new StringBuilder()).append("").append(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id")).toString().hashCode(), (long)s.hashCode() << 32 | (long)s2.hashCode())).toString();
        SecurityException securityexception;
        securityexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static AnalyticsCenter getInstance()
    {
        if (instance == null)
        {
            instance = new AnalyticsCenter();
        }
        return instance;
    }

    private String getQuery(List list)
        throws UnsupportedEncodingException
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        list = list.iterator();
        while (list.hasNext()) 
        {
            Pair pair = (Pair)list.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(URLEncoder.encode((String)pair.first, "UTF-8"));
            stringbuilder.append("=");
            stringbuilder.append(URLEncoder.encode((String)pair.second, "UTF-8"));
        }
        return stringbuilder.toString();
    }

    private void restoreAttributes()
    {
        if (settings != null)
        {
            mApplication = settings.getString("mApplication", "");
            uid = settings.getString("uid", "");
            lang = settings.getString("lang", "");
            locale = settings.getString("locale", "");
            gcmToken = settings.getString("gcmToken", "");
            paid = settings.getInt("paid", 0);
        }
    }

    private void saveAttributes()
    {
        if (editor != null)
        {
            editor.putString("mApplication", mApplication);
            editor.putString("uid", uid);
            editor.putString("lang", lang);
            editor.putString("locale", locale);
            editor.putString("gcmToken", gcmToken);
            editor.putInt("paid", paid);
            editor.commit();
        }
    }

    public void addCampaign(String s, String s1)
    {
        synchronized (campaignSet)
        {
            campaignSet.put(s.toUpperCase(), s1);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void boot(Context context, String s, String s1, String s2, int i, AnalyticsInitCallback analyticsinitcallback)
    {
        mApplication = s;
        uid = getDeviceId(context);
        callback = analyticsinitcallback;
        lang = s1;
        locale = context.getResources().getConfiguration().locale.getCountry();
        gcmToken = s2;
        paid = i;
        MessageTransmitter.getInstance().init(context, uid);
        booted = true;
        settings = context.getSharedPreferences("AnalyticsCenterSettings", 0);
        editor = settings.edit();
        saveAttributes();
        (new _cls1(context, s)).start();
    }

    public String getCampaign(String s)
    {
        synchronized (campaignSet)
        {
            s = (String)campaignSet.get(s.toUpperCase());
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void logEvent(String s, Map map)
    {
        s = new EAMessage(s);
        if (map != null && !map.isEmpty())
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); s.addParam((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        MessageTransmitter.getInstance().commit(s);
    }

    public void push(Context context)
    {
        if (settings == null)
        {
            settings = context.getSharedPreferences("AnalyticsCenterSettings", 0);
            editor = settings.edit();
            restoreAttributes();
        }
        (new _cls2()).start();
    }









    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
