// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.platform;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import com.amazon.now.util.AppUtils;
import java.lang.reflect.Field;

public class AndroidPlatform
{
    public static class Factory
    {

        private static AndroidPlatform instance;

        public static AndroidPlatform getInstance()
        {
            com/amazon/now/platform/AndroidPlatform$Factory;
            JVM INSTR monitorenter ;
            AndroidPlatform androidplatform = instance;
            com/amazon/now/platform/AndroidPlatform$Factory;
            JVM INSTR monitorexit ;
            return androidplatform;
            Exception exception;
            exception;
            throw exception;
        }

        public static void setInstance(AndroidPlatform androidplatform)
        {
            com/amazon/now/platform/AndroidPlatform$Factory;
            JVM INSTR monitorenter ;
            instance = androidplatform;
            com/amazon/now/platform/AndroidPlatform$Factory;
            JVM INSTR monitorexit ;
            return;
            androidplatform;
            throw androidplatform;
        }

        public Factory()
        {
        }
    }


    private static String sApplicationName;
    private final Context applicationContext;
    private final Handler handler;
    private String mApplicationId;
    private String mUserAgent;

    private AndroidPlatform(Context context)
    {
        if (context instanceof Activity)
        {
            applicationContext = context.getApplicationContext();
        } else
        {
            applicationContext = context;
        }
        handler = new Handler(context.getMainLooper());
    }

    public static AndroidPlatform getInstance()
    {
        return Factory.getInstance();
    }

    public static void setUp(Context context, String s)
    {
        if (Factory.getInstance() == null)
        {
            Factory.setInstance(new AndroidPlatform(context));
            sApplicationName = s;
        }
    }

    public Context getApplicationContext()
    {
        return applicationContext;
    }

    public String getApplicationId()
    {
        if (mApplicationId != null) goto _L2; else goto _L1
_L1:
        String s;
        if (TextUtils.isEmpty(sApplicationName))
        {
            Log.e("Amazon", "Every application should provide an application name!!!!!");
            throw new RuntimeException("Every application should provide an application name!!!!!");
        }
        s = null;
        String s1 = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
        s = s1;
_L4:
        String s4 = getDeviceId();
        String s5 = ((TelephonyManager)applicationContext.getSystemService("phone")).getNetworkOperatorName();
        String s6 = AppUtils.getVersionName(applicationContext);
        String s3 = (new StringBuilder()).append("Android_").append(android.os.Build.VERSION.RELEASE).toString();
        String s2 = s3;
        if (18 < s3.length())
        {
            s2 = s3.substring(0, 18);
        }
        mApplicationId = (new StringBuilder()).append("name=").append(sApplicationName).append(";").append("ver=").append(s6).append(";").append("device=").append(Build.MODEL).append(";").append("os=").append(s2).append(";").append("UDID=").append(s4).append(";").append("network=").append(s5).append(";").toString();
        if (s != null)
        {
            mApplicationId = (new StringBuilder()).append(mApplicationId).append("DSN=").append(s).append(";").toString();
        }
_L2:
        return mApplicationId;
        Throwable throwable;
        throwable;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getApplicationName()
    {
        return sApplicationName;
    }

    public String getApplicationVersion()
    {
        return AppUtils.getVersionName(applicationContext);
    }

    public String getDeviceId()
    {
        String s = null;
        String s1 = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
        s = s1;
_L2:
        String s2;
label0:
        {
            String s3 = android.provider.Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(s3))
            {
                s2 = s3;
                if (s3 != null)
                {
                    break label0;
                }
            }
            s2 = s;
        }
        return s2;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getDeviceName()
    {
        return Build.MODEL;
    }

    public String getSessionId()
    {
        String s = CookieManager.getInstance().getCookie(AppUtils.getServiceDomain());
        if (s != null) goto _L2; else goto _L1
_L1:
        String as[];
        return null;
_L2:
        if ((as = s.split(";")).length > 0)
        {
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String as1[] = as[i].trim().split("=");
                if (as1.length == 2 && "session-id".equalsIgnoreCase(as1[0]))
                {
                    return as1[1];
                }
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String getUserAgent()
    {
        if (mUserAgent == null)
        {
            String s = AppUtils.getVersionName(applicationContext);
            if (TextUtils.isEmpty(sApplicationName))
            {
                Log.e("Amazon", "Every application should provide an application name!!!!!");
                throw new RuntimeException("Every application should provide an application name!!!!!");
            }
            mUserAgent = (new StringBuilder()).append(sApplicationName).append("/").append(s).append(" (Android/").append(android.os.Build.VERSION.RELEASE).append("/").append(Build.MODEL).append(")").toString();
        }
        return mUserAgent;
    }

    public void invokeLater(Runnable runnable)
    {
        handler.post(runnable);
    }

    public void invokeLater(Runnable runnable, long l)
    {
        handler.postDelayed(runnable, l);
    }

    public void runOnUiThread(Runnable runnable)
    {
        if (Thread.currentThread() == handler.getLooper().getThread())
        {
            runnable.run();
            return;
        } else
        {
            handler.post(runnable);
            return;
        }
    }
}
