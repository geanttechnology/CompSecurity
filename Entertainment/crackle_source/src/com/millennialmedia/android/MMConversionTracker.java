// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.TreeMap;

// Referenced classes of package com.millennialmedia.android:
//            MMRequest, MMSDK, HandShake, HttpGetRequest

final class MMConversionTracker
{

    private static final String KEY_REFERRER = "installReferrer";

    MMConversionTracker()
    {
    }

    protected static void trackConversion(Context context, String s, MMRequest mmrequest)
    {
        com/millennialmedia/android/MMConversionTracker;
        JVM INSTR monitorenter ;
        long l = 0L;
        if (context == null || s == null) goto _L2; else goto _L1
_L1:
        int i = s.length();
        if (i != 0) goto _L3; else goto _L2
_L2:
        com/millennialmedia/android/MMConversionTracker;
        JVM INSTR monitorexit ;
        return;
_L3:
        TreeMap treemap;
        SharedPreferences sharedpreferences;
        String s1;
        boolean flag;
        sharedpreferences = context.getSharedPreferences("MillennialMediaSettings", 0);
        flag = sharedpreferences.getBoolean((new StringBuilder()).append("firstLaunch_").append(s).toString(), true);
        s1 = sharedpreferences.getString("installReferrer", null);
        treemap = new TreeMap();
        if (mmrequest == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        mmrequest.getUrlParams(treemap);
        MMRequest.insertLocation(treemap);
        if (s1 == null) goto _L5; else goto _L4
_L4:
        int j;
        mmrequest = s1.split("&");
        j = mmrequest.length;
        i = 0;
_L8:
        if (i >= j) goto _L5; else goto _L6
_L6:
        String as[] = mmrequest[i].split("=");
        if (as.length >= 2)
        {
            treemap.put(as[0], as[1]);
        }
        break MISSING_BLOCK_LABEL_371;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        mmrequest = sharedpreferences.edit();
        mmrequest.putBoolean((new StringBuilder()).append("firstLaunch_").append(s).toString(), false);
        mmrequest.commit();
        mmrequest = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        long l1 = mmrequest.getClass().getField("firstInstallTime").getLong(mmrequest);
        l = l1;
_L7:
        l1 = l;
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        mmrequest = new GregorianCalendar();
        mmrequest.setTimeInMillis(l);
        mmrequest.setTimeZone(TimeZone.getTimeZone("GMT"));
        l1 = mmrequest.getTimeInMillis();
        if (!MMSDK.isConnected(context))
        {
            break MISSING_BLOCK_LABEL_355;
        }
        treemap.put("ua", (new StringBuilder()).append("Android:").append(Build.MODEL).toString());
        treemap.put("apid", HandShake.apid);
        MMSDK.insertUrlCommonValues(context, treemap);
        Utils.ThreadUtils.execute(new Runnable(s, flag, l1, treemap) {

            final TreeMap val$extraParams;
            final String val$goalId;
            final long val$installTimeUTC;
            final boolean val$isFirstLaunch;

            public void run()
            {
                HttpGetRequest httpgetrequest = new HttpGetRequest();
                try
                {
                    httpgetrequest.trackConversion(goalId, isFirstLaunch, installTimeUTC, extraParams);
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }

            
            {
                goalId = s;
                isFirstLaunch = flag;
                installTimeUTC = l;
                extraParams = treemap;
                super();
            }
        });
          goto _L2
        context;
        throw context;
        MMSDK.Log.w("No network available for conversion tracking.");
          goto _L2
        mmrequest;
          goto _L7
        mmrequest;
          goto _L7
        i++;
          goto _L8
    }
}
