// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URLEncoder;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.millennialmedia.android:
//            MMRequest, MMSDK, HandShake, MMLog, 
//            HttpGetRequest

final class MMConversionTracker
{

    MMConversionTracker()
    {
    }

    protected static void a(Context context, String s, MMRequest mmrequest)
    {
        int i = 0;
        com/millennialmedia/android/MMConversionTracker;
        JVM INSTR monitorenter ;
        if (context == null || s == null) goto _L2; else goto _L1
_L1:
        int j = s.length();
        if (j != 0) goto _L3; else goto _L2
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
        flag = sharedpreferences.getBoolean((new StringBuilder("firstLaunch_")).append(s).toString(), true);
        s1 = sharedpreferences.getString("installReferrer", null);
        treemap = new TreeMap();
        if (mmrequest == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        mmrequest.a(treemap);
        MMRequest.b(treemap);
        if (s1 == null) goto _L5; else goto _L4
_L4:
        mmrequest = s1.split("&");
        j = mmrequest.length;
_L8:
        if (i >= j) goto _L5; else goto _L6
_L6:
        String as[] = mmrequest[i].split("=");
        if (as.length >= 2)
        {
            treemap.put(as[0], as[1]);
        }
        break MISSING_BLOCK_LABEL_379;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        mmrequest = sharedpreferences.edit();
        mmrequest.putBoolean((new StringBuilder("firstLaunch_")).append(s).toString(), false);
        mmrequest.commit();
        mmrequest = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        long l = mmrequest.getClass().getField("firstInstallTime").getLong(mmrequest);
_L7:
        long l1;
        l1 = l;
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        mmrequest = new GregorianCalendar();
        mmrequest.setTimeInMillis(l);
        mmrequest.setTimeZone(TimeZone.getTimeZone("GMT"));
        l1 = mmrequest.getTimeInMillis();
        if (!MMSDK.a(context))
        {
            break MISSING_BLOCK_LABEL_369;
        }
        treemap.put("ua", (new StringBuilder("Android:")).append(Build.MODEL).toString());
        treemap.put("apid", HandShake.a);
        MMSDK.a(context, treemap);
        Utils.ThreadUtils.a(new Runnable(s, flag, l1, treemap) {

            private String a;
            private boolean b;
            private long c;
            private TreeMap d;

            public final void run()
            {
                Object obj;
                int k;
                k = 1;
                obj = new HttpGetRequest();
                String s2;
                Object obj2;
                long l2;
                boolean flag1;
                s2 = a;
                flag1 = b;
                l2 = c;
                obj2 = d;
                Object obj1;
                if (!flag1)
                {
                    k = 0;
                }
                obj1 = new StringBuilder((new StringBuilder("http://cvt.mydas.mobi/handleConversion?firstlaunch=")).append(k).toString());
                if (s2 == null)
                {
                    break MISSING_BLOCK_LABEL_89;
                }
                ((StringBuilder) (obj1)).append((new StringBuilder("&goalId=")).append(s2).toString());
                if (l2 <= 0L)
                {
                    break MISSING_BLOCK_LABEL_122;
                }
                ((StringBuilder) (obj1)).append((new StringBuilder("&installtime=")).append(l2 / 1000L).toString());
                if (obj2 == null)
                {
                    break MISSING_BLOCK_LABEL_219;
                }
                for (Iterator iterator = ((TreeMap) (obj2)).entrySet().iterator(); iterator.hasNext(); ((StringBuilder) (obj1)).append(String.format("&%s=%s", new Object[] {
            ((java.util.Map.Entry) (obj2)).getKey(), URLEncoder.encode((String)((java.util.Map.Entry) (obj2)).getValue(), "UTF-8")
        })))
                {
                    obj2 = (java.util.Map.Entry)iterator.next();
                }

                break MISSING_BLOCK_LABEL_219;
                obj;
                try
                {
                    MMLog.a("HttpGetRequest", "Conversion tracking error: ", ((Throwable) (obj)));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MMLog.a("MMConversionTracker", "Problem doing conversion tracking.", ((Throwable) (obj)));
                }
                break MISSING_BLOCK_LABEL_329;
                obj1 = ((StringBuilder) (obj1)).toString();
                MMLog.b("HttpGetRequest", String.format("Sending conversion tracker report: %s", new Object[] {
                    obj1
                }));
                ((HttpGetRequest) (obj)).b.setURI(new URI(((String) (obj1))));
                obj = ((HttpGetRequest) (obj)).a.execute(((HttpGetRequest) (obj)).b);
                if (((HttpResponse) (obj)).getStatusLine().getStatusCode() == 200)
                {
                    MMLog.a("HttpGetRequest", String.format("Successful conversion tracking event: %d", new Object[] {
                        Integer.valueOf(((HttpResponse) (obj)).getStatusLine().getStatusCode())
                    }));
                    return;
                }
                break MISSING_BLOCK_LABEL_330;
                return;
                MMLog.e("HttpGetRequest", String.format("Conversion tracking error: %d", new Object[] {
                    Integer.valueOf(((HttpResponse) (obj)).getStatusLine().getStatusCode())
                }));
                return;
            }

            
            {
                a = s;
                b = flag;
                c = l;
                d = treemap;
                super();
            }
        });
          goto _L2
        context;
        throw context;
        mmrequest;
        MMLog.a("MMConversionTracker", "Error with firstInstallTime", mmrequest);
        l = 0L;
          goto _L7
        mmrequest;
        MMLog.a("MMConversionTracker", "Can't find packagename: ", mmrequest);
        l = 0L;
          goto _L7
        MMLog.d("MMConversionTracker", "No network available for conversion tracking.");
          goto _L2
        i++;
          goto _L8
    }
}
