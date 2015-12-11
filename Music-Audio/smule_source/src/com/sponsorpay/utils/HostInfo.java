// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.sponsorpay.utils:
//            SponsorPayLogger

public class HostInfo
{

    private static final String ANDROID_OS_PREFIX = "Android OS ";
    private static final String CONNECTION_TYPE_CELLULAR = "cellular";
    private static final String CONNECTION_TYPE_WIFI = "wifi";
    private static final String SCREEN_DENSITY_CATEGORY_VALUE_EXTRA_HIGH = "EXTRA_HIGH";
    private static final String SCREEN_DENSITY_CATEGORY_VALUE_HIGH = "HIGH";
    private static final String SCREEN_DENSITY_CATEGORY_VALUE_LOW = "LOW";
    private static final String SCREEN_DENSITY_CATEGORY_VALUE_MEDIUM = "MEDIUM";
    private static final String SCREEN_DENSITY_CATEGORY_VALUE_TV = "TV";
    private static final String TAG = "HostInfo";
    private static final String UNDEFINED_VALUE = "undefined";
    private static HostInfo hostInfoInstance;
    protected static boolean sSimulateNoAccessNetworkState = false;
    protected static boolean sSimulateNoReadPhoneStatePermission = false;
    private String mAdvertisingId;
    private boolean mAdvertisingIdLimitedTrackingEnabled;
    private String mAppVersion;
    private String mBundleName;
    private String mCarrierCountry;
    private String mCarrierName;
    private String mConnectionType;
    private DisplayMetrics mDisplayMetrics;
    private CountDownLatch mIdLatch;
    private String mLanguageSetting;
    private String mOsVersion;
    private String mPhoneVersion;
    private String mScreenDensityCategory;
    private float mScreenDensityX;
    private float mScreenDensityY;
    private int mScreenHeight;
    private int mScreenWidth;

    public HostInfo(Context context)
    {
        mAdvertisingIdLimitedTrackingEnabled = true;
        mIdLatch = new CountDownLatch(1);
        if (context == null)
        {
            throw new RuntimeException("A context is required to initialize HostInfo");
        }
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            (new Thread(context) {

                final HostInfo this$0;
                private final Context val$context;

                public void run()
                {
                    retrieveAdvertisingId(context);
                }

            
            {
                this$0 = HostInfo.this;
                context = context1;
                super(final_s);
            }
            }).start();
        } else
        {
            retrieveAdvertisingId(context);
        }
        retrieveTelephonyManagerValues(context);
        retrieveAccessNetworkValues(context);
        retrieveDisplayMetrics(context);
        retrieveAppVersion(context);
        mLanguageSetting = Locale.getDefault().toString();
        mOsVersion = (new StringBuilder("Android OS ")).append(android.os.Build.VERSION.RELEASE).toString();
        mPhoneVersion = (new StringBuilder(String.valueOf(Build.MANUFACTURER))).append("_").append(Build.MODEL).toString();
        mBundleName = context.getPackageName();
    }

    public static HostInfo getHostInfo(Context context)
    {
        if (hostInfoInstance == null)
        {
            hostInfoInstance = new HostInfo(context);
        }
        return hostInfoInstance;
    }

    private String getScreenDensityCategoryFromModernAndroidDevice(int i)
    {
        String s;
        String as[];
        String as1[];
        int j;
        int k;
        as = new String[2];
        as[0] = "DENSITY_XHIGH";
        as[1] = "DENSITY_TV";
        as1 = new String[2];
        as1[0] = "EXTRA_HIGH";
        as1[1] = "TV";
        k = Math.min(as.length, as1.length);
        s = null;
        j = 0;
_L4:
        if (j < k) goto _L2; else goto _L1
_L1:
        String s1 = s;
        if (s == null)
        {
            s1 = "undefined";
        }
        return s1;
_L2:
        String s2 = s;
        if (i == android/util/DisplayMetrics.getField(as[j]).getInt(null))
        {
            s2 = as1[j];
        }
_L5:
        s = s2;
        if (s2 != null) goto _L1; else goto _L3
_L3:
        j++;
        s = s2;
          goto _L4
        Exception exception;
        exception;
        exception = s;
          goto _L5
    }

    public static boolean isDeviceSupported()
    {
        return android.os.Build.VERSION.SDK_INT >= 10;
    }

    private void retrieveAccessNetworkValues(Context context)
    {
        mConnectionType = "";
        if (sSimulateNoAccessNetworkState)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (context.getType() == 1)
        {
            context = "wifi";
        } else
        {
            context = "cellular";
        }
        try
        {
            mConnectionType = context;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
    }

    private void retrieveAppVersion(Context context)
    {
        try
        {
            mAppVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mAppVersion = "";
        }
    }

    private DisplayMetrics retrieveDisplayMetrics(Context context)
    {
        if (mDisplayMetrics == null)
        {
            mDisplayMetrics = new DisplayMetrics();
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(mDisplayMetrics);
        }
        return mDisplayMetrics;
    }

    private void retrieveTelephonyManagerValues(Context context)
    {
        mCarrierName = "";
        mCarrierCountry = "";
        if (sSimulateNoReadPhoneStatePermission)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        context = (TelephonyManager)context.getSystemService("phone");
        mCarrierName = context.getNetworkOperatorName();
        mCarrierCountry = context.getNetworkCountryIso();
        return;
        context;
    }

    public static void setSimulateNoAccessNetworkState(boolean flag)
    {
        sSimulateNoAccessNetworkState = flag;
    }

    public static void setSimulateNoReadPhoneStatePermission(boolean flag)
    {
        sSimulateNoReadPhoneStatePermission = flag;
    }

    public String getAdvertisingId()
    {
        try
        {
            mIdLatch.await(5L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedexception) { }
        return mAdvertisingId;
    }

    public String getAppBundleName()
    {
        return mBundleName;
    }

    public String getAppVersion()
    {
        return mAppVersion;
    }

    public String getCarrierCountry()
    {
        return mCarrierCountry;
    }

    public String getCarrierName()
    {
        return mCarrierName;
    }

    public String getConnectionType()
    {
        return mConnectionType;
    }

    public String getLanguageSetting()
    {
        return mLanguageSetting;
    }

    public String getManufacturer()
    {
        return Build.MANUFACTURER;
    }

    public String getOsVersion()
    {
        return mOsVersion;
    }

    public String getPhoneVersion()
    {
        return mPhoneVersion;
    }

    public String getScreenDensityCategory()
    {
        if (mScreenDensityCategory != null) goto _L2; else goto _L1
_L1:
        int i = mDisplayMetrics.densityDpi;
        i;
        JVM INSTR lookupswitch 4: default 60
    //                   120: 92
    //                   160: 74
    //                   240: 83
    //                   320: 101;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        mScreenDensityCategory = getScreenDensityCategoryFromModernAndroidDevice(i);
_L2:
        return mScreenDensityCategory;
_L5:
        mScreenDensityCategory = "MEDIUM";
        continue; /* Loop/switch isn't completed */
_L6:
        mScreenDensityCategory = "HIGH";
        continue; /* Loop/switch isn't completed */
_L4:
        mScreenDensityCategory = "LOW";
        continue; /* Loop/switch isn't completed */
_L7:
        mScreenDensityCategory = "EXTRA_HIGH";
        if (true) goto _L2; else goto _L8
_L8:
    }

    public String getScreenDensityX()
    {
        if (0.0F == mScreenDensityX)
        {
            mScreenDensityX = mDisplayMetrics.xdpi;
        }
        return Integer.toString(Math.round(mScreenDensityX));
    }

    public String getScreenDensityY()
    {
        if (0.0F == mScreenDensityY)
        {
            mScreenDensityY = mDisplayMetrics.ydpi;
        }
        return Integer.toString(Math.round(mScreenDensityY));
    }

    public String getScreenHeight()
    {
        if (mScreenHeight == 0)
        {
            mScreenHeight = mDisplayMetrics.heightPixels;
        }
        return Integer.toString(mScreenHeight);
    }

    public String getScreenWidth()
    {
        if (mScreenWidth == 0)
        {
            mScreenWidth = mDisplayMetrics.widthPixels;
        }
        return Integer.toString(mScreenWidth);
    }

    public Boolean isAdvertisingIdLimitedTrackingEnabled()
    {
        return Boolean.valueOf(mAdvertisingIdLimitedTrackingEnabled);
    }

    protected void retrieveAdvertisingId(Context context)
    {
        try
        {
            context = ((Context) (Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                context
            })));
            Method method = context.getClass().getMethod("getId", new Class[0]);
            Method method1 = context.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
            mAdvertisingId = method.invoke(context, new Object[0]).toString();
            mAdvertisingIdLimitedTrackingEnabled = ((Boolean)method1.invoke(context, new Object[0])).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            SponsorPayLogger.e("HostInfo", context.getLocalizedMessage(), context);
        }
        mIdLatch.countDown();
    }

}
