// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.crashlytics.android.Crashlytics;
import java.util.HashMap;
import java.util.Locale;
import yn;

public class FotoAdCenter
{

    private static boolean mRefreshed = false;

    public FotoAdCenter()
    {
    }

    public static String getVersion(Context context)
    {
        String s = null;
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            context = null;
        }
        if (context != null)
        {
            s = ((PackageInfo) (context)).versionName;
        }
        return s;
    }

    public static boolean isAdRefreshed()
    {
        return mRefreshed;
    }

    public static void loadAdOnMainActivityResume(final Context ctx)
    {
        long l = ctx.getSharedPreferences("FotoAdCenter", 32768).getLong("LastRefreshTime", 0L);
        if (System.currentTimeMillis() - l < 60000L)
        {
            return;
        } else
        {
            ctx.getSharedPreferences("FotoAdCenter", 32768).edit().putLong("LastSessionStoppedTime", System.currentTimeMillis()).apply();
            (new Thread(new _cls1())).start();
            return;
        }
    }

    public static HashMap sysInfo(Context context)
    {
        HashMap hashmap = new HashMap();
        try
        {
            hashmap.put("openuuid", yn.a(((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress()));
            hashmap.put("uuid", null);
            hashmap.put("os", "android");
            String s = Locale.getDefault().getLanguage();
            String s1 = Locale.getDefault().getLanguage();
            String s2 = Locale.getDefault().getCountry();
            hashmap.put("langcode", s);
            hashmap.put("countrycode", s2);
            hashmap.put("prelang", s1);
            hashmap.put("devicetype", Build.MODEL);
            hashmap.put("deviceVersion", android.os.Build.VERSION.RELEASE);
            hashmap.put("ver", getVersion(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            Crashlytics.logException(context);
            return hashmap;
        }
        return hashmap;
    }


    private class _cls1
        implements Runnable
    {

        final Context val$ctx;

        public void run()
        {
            Object obj;
            HttpPost httppost;
            ArrayList arraylist;
            obj = new DefaultHttpClient();
            httppost = new HttpPost("http://ad2.fotoable.com/ads/");
            arraylist = new ArrayList();
            java.util.Map.Entry entry;
            for (Iterator iterator = FotoAdCenter.sysInfo(ctx).entrySet().iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

              goto _L1
            obj;
            Crashlytics.logException(((Throwable) (obj)));
            ((Exception) (obj)).printStackTrace();
_L3:
            return;
_L1:
            int i;
            arraylist.add(new BasicNameValuePair("fotouuid", FotoCustomReport.getFOTOUUID(ctx)));
            arraylist.add(new BasicNameValuePair("md5i", FotoCustomReport.getImeiMd5(ctx)));
            httppost.setEntity(new UrlEncodedFormEntity(arraylist));
            obj = ((HttpClient) (obj)).execute(httppost);
            if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = (new JSONObject(EntityUtils.toString(((HttpResponse) (obj)).getEntity(), "UTF-8"))).getInt("status");
            if (i == 1)
            {
                return;
            }
            if (true) goto _L3; else goto _L2
_L2:
        }

        _cls1()
        {
            ctx = context;
            super();
        }
    }

}
