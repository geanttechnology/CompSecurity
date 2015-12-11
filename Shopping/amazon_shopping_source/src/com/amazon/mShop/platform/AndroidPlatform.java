// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.iface.client.trans.AndroidHttpServerConnection;
import com.amazon.mShop.mobileads.AdsHelper;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.net.MShopRioEventListener;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.AttributionUtils;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.rsc.AsynchronousServiceCallInvoker;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.MShopServiceImpl;
import com.amazon.rio.j2me.client.trans.IServiceConnection;
import com.amazon.rio.j2me.client.trans.ServerConnection;
import com.amazon.rio.j2me.client.trans.ServerConnectionFactory;
import com.amazon.rio.j2me.client.util.Logger;
import java.lang.reflect.Field;
import java.util.UUID;

// Referenced classes of package com.amazon.mShop.platform:
//            Platform, AndroidDataStore, AppLocale, AndroidResources, 
//            Resources

public class AndroidPlatform
    implements Platform
{
    private static class AndroidLogger
        implements Logger
    {

        private final String tag;

        public void error(String s)
        {
            Log.e(tag, s);
        }

        public void info(String s)
        {
            Log.i(tag, s);
        }

        public AndroidLogger(Class class1)
        {
            tag = class1.toString();
        }
    }


    private static volatile MShopService mShopService;
    private static String sApplicationName;
    private final Context applicationContext;
    private final AndroidDataStore dataStore;
    private final Handler handler;
    private String mApplicationId;
    private String mUserAgent;
    private Resources res;

    private AndroidPlatform(Context context)
    {
        if (context instanceof Activity)
        {
            applicationContext = context.getApplicationContext();
        } else
        {
            applicationContext = context;
        }
        dataStore = new AndroidDataStore(context);
        handler = new Handler(context.getMainLooper());
    }

    public static AndroidPlatform getInstance()
    {
        return (AndroidPlatform)Platform.Factory.getInstance();
    }

    private static void initLRUCacheSize(Context context)
    {
        LRUCache.setCacheLimit((((ActivityManager)context.getSystemService("activity")).getMemoryClass() * 1024 * 1024) / 4);
    }

    public static void setUp(Context context, String s)
    {
        if (Platform.Factory.getInstance() == null)
        {
            Platform.Factory.setInstance(new AndroidPlatform(context));
            sApplicationName = s;
            LocaleUtils.initLocale(context);
            initLRUCacheSize(context);
            AdsHelper.resetIfNecessary(context);
        }
    }

    public int getAppStartCountForAllLocales()
    {
        int j = 0;
        Object aobj[] = AppLocale.getInstance().getSupportedLocaleNameArray();
        for (int i = 0; i < aobj.length; i++)
        {
            String s = (String)aobj[i];
            j += dataStore.getInt("applicationStartCount", s);
        }

        return j;
    }

    public Context getApplicationContext()
    {
        return applicationContext;
    }

    public volatile Object getApplicationContext()
    {
        return getApplicationContext();
    }

    public String getApplicationId()
    {
        if (mApplicationId != null) goto _L2; else goto _L1
_L1:
        String s;
        if (Util.isEmpty(sApplicationName))
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
        String s6 = BuildUtils.getVersionName(applicationContext);
        String s7 = AttributionUtils.getAssociatesTag(applicationContext);
        String s3 = (new StringBuilder()).append("Android_").append(android.os.Build.VERSION.RELEASE).toString();
        String s2 = s3;
        if (18 < s3.length())
        {
            s2 = s3.substring(0, 18);
        }
        s3 = ConfigUtils.getString(getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_marketplace).toUpperCase();
        mApplicationId = (new StringBuilder()).append("name=").append(sApplicationName).append(";").append("ver=").append(s6).append(";").append("device=").append(Build.MODEL).append(";").append("os=").append(s2).append(";").append("UDID=").append(s4).append(";").append("network=").append(s5).append(";").append("tag=").append(s7).append(";").append("mp=").append(s3).append(";").toString();
        if (s != null)
        {
            mApplicationId = (new StringBuilder()).append(mApplicationId).append("DSN=").append(s).append(";").toString();
        }
        s = BuildUtils.getBetaName(getApplicationContext());
        if (!Util.isEmpty(s))
        {
            mApplicationId = (new StringBuilder()).append(mApplicationId).append("beta=").append(s).append(";").toString();
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
        return BuildUtils.getVersionName(applicationContext);
    }

    public DataStore getDataStore()
    {
        return dataStore;
    }

    public String getDeviceId()
    {
        String s3 = null;
        String s = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
        s3 = s;
_L2:
        String s1;
label0:
        {
            String s4 = android.provider.Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(s4))
            {
                s1 = s4;
                if (s4 != null)
                {
                    break label0;
                }
            }
            s1 = s3;
        }
        s3 = s1;
        if (s1 == null)
        {
            String s2 = dataStore.getString("UDID");
            s3 = s2;
            if (s2 == null)
            {
                s3 = UUID.randomUUID().toString();
                dataStore.putString("UDID", s3);
            }
        }
        return s3;
        Throwable throwable;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getDeviceName()
    {
        return Build.MODEL;
    }

    public Logger getLogger(Class class1)
    {
        return new AndroidLogger(class1);
    }

    public MShopService getMShopService()
    {
        this;
        JVM INSTR monitorenter ;
        MShopService mshopservice;
        if (mShopService == null)
        {
            AsynchronousServiceCallInvoker asynchronousservicecallinvoker = new AsynchronousServiceCallInvoker(new ServerConnectionFactory() {

                final AndroidPlatform this$0;

                public volatile IServiceConnection getServerConnection()
                {
                    return getServerConnection();
                }

                public ServerConnection getServerConnection()
                {
                    return new AndroidHttpServerConnection(getServiceUrl());
                }

            
            {
                this$0 = AndroidPlatform.this;
                super();
            }
            }, new ServerConnectionFactory() {

                final AndroidPlatform this$0;

                public volatile IServiceConnection getServerConnection()
                {
                    return getServerConnection();
                }

                public ServerConnection getServerConnection()
                {
                    return new AndroidHttpServerConnection(getSecureServiceUrl());
                }

            
            {
                this$0 = AndroidPlatform.this;
                super();
            }
            });
            mShopService = new MShopServiceImpl(getApplicationId(), asynchronousservicecallinvoker, MShopRioEventListener.getRioEventListener());
        }
        mshopservice = mShopService;
        this;
        JVM INSTR monitorexit ;
        return mshopservice;
        Exception exception;
        exception;
        throw exception;
    }

    public Resources getResources()
    {
        if (res == null)
        {
            res = new AndroidResources(applicationContext.getResources());
        }
        return res;
    }

    public String getSecureServiceUrl()
    {
        if (DebugSettings.isDebugEnabled())
        {
            String s1 = getDataStore().getString("currentServiceSecureUrl");
            String s = s1;
            if (Util.isEmpty(s1))
            {
                s = ConfigUtils.getString(applicationContext, com.amazon.mShop.android.lib.R.string.config_serviceSecureURL);
                getDataStore().putString("currentServiceSecureUrl", s);
            }
            return s;
        } else
        {
            return ConfigUtils.getString(applicationContext, com.amazon.mShop.android.lib.R.string.config_serviceSecureURL);
        }
    }

    public String getServiceUrl()
    {
        if (DebugSettings.isDebugEnabled())
        {
            String s1 = getDataStore().getString("currentServiceUrl");
            String s = s1;
            if (Util.isEmpty(s1))
            {
                s = ConfigUtils.getString(applicationContext, com.amazon.mShop.android.lib.R.string.config_serviceURL);
                getDataStore().putString("currentServiceUrl", s);
            }
            return s;
        } else
        {
            return ConfigUtils.getString(applicationContext, com.amazon.mShop.android.lib.R.string.config_serviceURL);
        }
    }

    public String getUserAgent()
    {
        if (mUserAgent != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (mUserAgent != null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = BuildUtils.getVersionName(applicationContext);
        if (Util.isEmpty(sApplicationName))
        {
            Log.e("Amazon", "Every application should provide an application name!!!!!");
            throw new RuntimeException("Every application should provide an application name!!!!!");
        }
        break MISSING_BLOCK_LABEL_56;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        mUserAgent = (new StringBuilder()).append(sApplicationName).append("/").append(((String) (obj))).append(" (Android/").append(android.os.Build.VERSION.RELEASE).append("/").append(Build.MODEL).append(")").toString();
        this;
        JVM INSTR monitorexit ;
_L2:
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

    public boolean isAmazonAppStoreSupported()
    {
        return ConfigUtils.isEnabled(applicationContext, com.amazon.mShop.android.lib.R.string.config_hasAmazonAppstore) && Integer.parseInt(android.os.Build.VERSION.SDK) >= 4;
    }

    public boolean isAmazonKindleSupported()
    {
        return ConfigUtils.isEnabled(applicationContext, com.amazon.mShop.android.lib.R.string.config_isAmazonKindleSupported);
    }

    public boolean isAmazonMp3Supported()
    {
        return ConfigUtils.isEnabled(applicationContext, com.amazon.mShop.android.lib.R.string.config_hasAmazonMp3) && Integer.parseInt(android.os.Build.VERSION.SDK) >= 4;
    }

    public boolean isAmazonVideoSupported()
    {
        return AppUtils.isAppInstalled(getApplicationContext(), "com.amazon.avod");
    }

    public void resetApplicationId()
    {
        mApplicationId = null;
        if (mShopService != null)
        {
            mShopService.setApplicationID(getApplicationId());
        }
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
