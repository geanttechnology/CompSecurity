// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.playhaven.android.cache.Cache;
import com.playhaven.android.compat.VendorCompat;
import com.playhaven.android.req.InstallRequest;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

// Referenced classes of package com.playhaven.android:
//            PlayHavenException, Version, DeviceId

public class PlayHaven
{
    public static final class Config extends Enum
    {

        private static final Config $VALUES[];
        public static final Config APIServer;
        public static final Config AppPkg;
        public static final Config AppVersion;
        public static final Config DeviceId;
        public static final Config DeviceModel;
        public static final Config FullScreen;
        public static final Config InstallReported;
        public static final Config OSName;
        public static final Config OSVersion;
        public static final Config OptOut;
        public static final Config PluginIdentifer;
        public static final Config PluginType;
        public static final Config PushProjectId;
        public static final Config SDKVersion;
        public static final Config Secret;
        public static final Config Token;

        public static Config valueOf(String s)
        {
            return (Config)Enum.valueOf(com/playhaven/android/PlayHaven$Config, s);
        }

        public static Config[] values()
        {
            return (Config[])$VALUES.clone();
        }

        static 
        {
            Token = new Config("Token", 0);
            Secret = new Config("Secret", 1);
            APIServer = new Config("APIServer", 2);
            SDKVersion = new Config("SDKVersion", 3);
            PluginIdentifer = new Config("PluginIdentifer", 4);
            PluginType = new Config("PluginType", 5);
            AppPkg = new Config("AppPkg", 6);
            AppVersion = new Config("AppVersion", 7);
            OSName = new Config("OSName", 8);
            OSVersion = new Config("OSVersion", 9);
            DeviceId = new Config("DeviceId", 10);
            PushProjectId = new Config("PushProjectId", 11);
            DeviceModel = new Config("DeviceModel", 12);
            FullScreen = new Config("FullScreen", 13);
            OptOut = new Config("OptOut", 14);
            InstallReported = new Config("InstallReported", 15);
            $VALUES = (new Config[] {
                Token, Secret, APIServer, SDKVersion, PluginIdentifer, PluginType, AppPkg, AppVersion, OSName, OSVersion, 
                DeviceId, PushProjectId, DeviceModel, FullScreen, OptOut, InstallReported
            });
        }

        private Config(String s, int j)
        {
            super(s, j);
        }
    }


    public static final String ACTION_ACTIVITY = "activity";
    public static final String ACTION_CONTENT_UNIT = "content_id";
    public static final String ACTION_PLACEMENT = "placement";
    private static final int SHARED_PREF_MODE = 0;
    private static final String SHARED_PREF_NAME = com/playhaven/android/PlayHaven.getName();
    public static final String TAG = com/playhaven/android/PlayHaven.getSimpleName();
    public static final String URI_SCHEME = "playhaven";
    private static Charset UTF8;
    private static VendorCompat cachedCompat;

    public PlayHaven()
    {
    }

    public static void configure(Context context, int j, int k)
        throws PlayHavenException
    {
        Resources resources = context.getResources();
        configure(context, resources.getString(j), resources.getString(k), ((String) (null)));
    }

    public static void configure(Context context, int j, int k, int l)
        throws PlayHavenException
    {
        Resources resources = context.getResources();
        configure(context, resources.getString(j), resources.getString(k), resources.getString(l));
    }

    public static void configure(Context context, String s)
        throws PlayHavenException
    {
        android.content.SharedPreferences.Editor editor;
        if (s != null && s.startsWith("http"))
        {
            Cache cache = new Cache(context);
            context = new _cls1(context);
            try
            {
                cache.request(s, context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new PlayHavenException("Failed to configure PlayHaven", context);
            }
        }
        editor = defaultConfiguration(context);
label0:
        {
            Properties properties = new Properties();
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                properties.load(new FileReader(s));
                String s1;
                for (s = properties.stringPropertyNames().iterator(); s.hasNext(); editor.putString(Config.valueOf(s1).toString(), properties.getProperty(s1)))
                {
                    s1 = (String)s.next();
                }

                break label0;
            }
            try
            {
                properties.load(new BufferedInputStream(new FileInputStream(s)));
                String s2;
                for (s = properties.propertyNames(); s.hasMoreElements(); editor.putString(Config.valueOf(s2).toString(), properties.getProperty(s2)))
                {
                    s2 = (String)s.nextElement();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new PlayHavenException("Failed to configure PlayHaven", context);
            }
        }
        editor.commit();
        i("PlayHaven initialized: %s", new Object[] {
            Version.BANNER
        });
        debugConfig(context);
        requestApa(context);
        return;
    }

    public static void configure(Context context, String s, String s1)
        throws PlayHavenException
    {
        configure(context, s, s1, ((String) (null)));
    }

    public static void configure(Context context, String s, String s1, String s2)
        throws PlayHavenException
    {
        validateToken(s);
        validateSecret(s1);
        android.content.SharedPreferences.Editor editor = defaultConfiguration(context);
        editor.putString(Config.Token.toString(), s);
        editor.putString(Config.Secret.toString(), s1);
        editor.putString(Config.PushProjectId.toString(), s2);
        editor.commit();
        i("PlayHaven initialized: %s", new Object[] {
            Version.BANNER
        });
        debugConfig(context);
        requestApa(context);
    }

    private static VendorCompat createDefaultVendorCompat(Context context)
    {
        return new VendorCompat("android");
    }

    public static transient void d(String s, Object aobj[])
    {
        if (isLoggable(3))
        {
            Log.d(TAG, String.format(s, aobj));
        }
    }

    public static transient void d(Throwable throwable, String s, Object aobj[])
    {
        if (isLoggable(3))
        {
            Log.d(TAG, String.format(s, aobj), throwable);
        }
    }

    private static void debugConfig(Context context)
    {
        context = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, 0).getAll();
        d("Configuration Parameters", new Object[0]);
        Iterator iterator = context.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!s.equals(Config.Secret.toString()))
            {
                d("%s: %s", new Object[] {
                    s, context.get(s)
                });
            }
        } while (true);
    }

    private static android.content.SharedPreferences.Editor defaultConfiguration(Context context)
        throws PlayHavenException
    {
        android.content.SharedPreferences.Editor editor = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, 0).edit();
        int j = getVendorCompat(context).getResourceId(context, com.playhaven.android.compat.VendorCompat.ResourceType.string, "playhaven_public_api_server");
        editor.putString(Config.APIServer.toString(), context.getResources().getString(j));
        editor.putString(Config.SDKVersion.toString(), Version.PROJECT_VERSION);
        Object obj = context.getPackageName();
        try
        {
            obj = context.getPackageManager().getPackageInfo(((String) (obj)), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new PlayHavenException("Unable to obtain package inforamtion", context);
        }
        editor.putString(Config.AppPkg.toString(), ((PackageInfo) (obj)).packageName);
        editor.putString(Config.AppVersion.toString(), ((PackageInfo) (obj)).versionName);
        editor.putString(Config.OSName.toString(), android.os.Build.VERSION.RELEASE);
        editor.putInt(Config.OSVersion.toString(), android.os.Build.VERSION.SDK_INT);
        editor.putString(Config.DeviceId.toString(), (new DeviceId(context)).toString());
        editor.putString(Config.DeviceModel.toString(), Build.MODEL);
        editor.commit();
        return editor;
    }

    public static transient void e(String s, Object aobj[])
    {
        if (isLoggable(6))
        {
            Log.e(TAG, String.format(s, aobj));
        }
    }

    public static void e(Throwable throwable)
    {
        if (isLoggable(6))
        {
            Log.e(TAG, throwable.getMessage(), throwable);
        }
    }

    public static transient void e(Throwable throwable, String s, Object aobj[])
    {
        if (isLoggable(6))
        {
            Log.e(TAG, String.format(s, aobj), throwable);
        }
    }

    public static boolean getOptOut(Context context)
        throws PlayHavenException
    {
        return "1".equals(getPreferences(context).getString(Config.OptOut.name(), "0"));
    }

    public static SharedPreferences getPreferences(Context context)
    {
        return context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, 0);
    }

    public static Charset getUTF8()
    {
        if (UTF8 == null)
        {
            UTF8 = Charset.forName("UTF-8");
        }
        return UTF8;
    }

    public static VendorCompat getVendorCompat(Context context)
    {
        Object obj1;
        Class class1;
        String s;
        String s1;
        if (cachedCompat != null)
        {
            return cachedCompat;
        }
        SharedPreferences sharedpreferences = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, 0);
        s = sharedpreferences.getString(Config.PluginType.toString(), com/playhaven/android/compat/VendorCompat.getCanonicalName());
        s1 = sharedpreferences.getString(Config.PluginIdentifer.toString(), "android");
        if (s1 == null || s == null)
        {
            d("getVendorCompat: using default", new Object[0]);
            return createDefaultVendorCompat(context);
        }
        obj1 = null;
        class1 = null;
        Object obj = Class.forName(s);
        class1 = ((Class) (obj));
_L1:
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        obj = obj1;
        obj1 = (VendorCompat)class1.getConstructor(new Class[] {
            android/content/Context, java/lang/String
        }).newInstance(new Object[] {
            context, s1
        });
        obj = obj1;
        d("getVendorCompat: instantiated #1: %s/%s", new Object[] {
            s, s1
        });
        obj = obj1;
_L2:
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        obj1 = (VendorCompat)class1.getConstructor(new Class[] {
            java/lang/String
        }).newInstance(new Object[] {
            s1
        });
        obj = obj1;
        Exception exception;
        try
        {
            d("getVendorCompat: instantiated #2: %s/%s", new Object[] {
                s, s1
            });
        }
        catch (Exception exception1)
        {
            d(exception1, "getVendorCompat: failed to instantiate #2: %s/%s", new Object[] {
                s, s1
            });
            exception1 = ((Exception) (obj));
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = createDefaultVendorCompat(context);
        }
        setVendorCompat(context, ((VendorCompat) (obj)));
        return ((VendorCompat) (obj));
        obj;
        d(((Throwable) (obj)), "getVendorCompat: failed to find: %s/%s", new Object[] {
            s, s1
        });
        obj1 = createDefaultVendorCompat(context);
          goto _L1
        exception;
        d(exception, "getVendorCompat: failed to instantiate #1: %s/%s", new Object[] {
            s, s1
        });
          goto _L2
    }

    public static transient void i(String s, Object aobj[])
    {
        if (isLoggable(4))
        {
            Log.i(TAG, String.format(s, aobj));
        }
    }

    public static transient void i(Throwable throwable, String s, Object aobj[])
    {
        if (isLoggable(4))
        {
            Log.i(TAG, String.format(s, aobj), throwable);
        }
    }

    public static boolean isLoggable(int j)
    {
        while (Log.isLoggable(TAG, j) || Integer.parseInt(System.getProperty(TAG, "4")) <= j) 
        {
            return true;
        }
        return false;
    }

    protected static void requestApa(Context context)
    {
        long l = getPreferences(context).getLong(Config.InstallReported.toString(), 0L);
        if (l > 0L)
        {
            d("Install stamp detected: %s", new Object[] {
                new Date(l)
            });
            return;
        }
        try
        {
            (new InstallRequest()).send(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            w(context, "Failure to stamp install", new Object[0]);
        }
    }

    public static void setLogLevel(int j)
    {
        System.setProperty(TAG, (new StringBuilder()).append("").append(j).toString());
    }

    public static void setLogLevel(String s)
    {
    /* block-local class not found */
    class LogName {}

        setLogLevel(LogName.access._mth000(LogName.valueOf(s)));
    }

    public static void setOptOut(Context context, boolean flag)
        throws PlayHavenException
    {
        android.content.SharedPreferences.Editor editor = defaultConfiguration(context);
        String s = Config.OptOut.name();
        if (flag)
        {
            context = "1";
        } else
        {
            context = "0";
        }
        editor.putString(s, context);
        editor.commit();
    }

    public static void setVendorCompat(Context context, VendorCompat vendorcompat)
    {
        cachedCompat = vendorcompat;
        android.content.SharedPreferences.Editor editor = context.getApplicationContext().getSharedPreferences(SHARED_PREF_NAME, 0).edit();
        editor.putString(Config.PluginIdentifer.toString(), vendorcompat.getVendorId());
        editor.putString(Config.PluginType.toString(), vendorcompat.getClass().getCanonicalName());
        editor.commit();
        i("PlayHaven plugin identifier set: %s", new Object[] {
            vendorcompat.getVendorId()
        });
        debugConfig(context);
    }

    public static transient void v(String s, Object aobj[])
    {
        if (isLoggable(2))
        {
            Log.v(TAG, String.format(s, aobj));
        }
    }

    public static transient void v(Throwable throwable, String s, Object aobj[])
    {
        if (isLoggable(2))
        {
            Log.v(TAG, String.format(s, aobj), throwable);
        }
    }

    private static void validateHex(String s, String s1)
        throws PlayHavenException
    {
        if (s1 == null)
        {
            throw new PlayHavenException("%s must be set.", new Object[] {
                s
            });
        }
        if (s1.length() == 0)
        {
            throw new PlayHavenException("%s must not be empty.", new Object[] {
                s
            });
        }
        try
        {
            new BigInteger(s1, 16);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new PlayHavenException(s1, "%s must be a hex value", new Object[] {
                s
            });
        }
    }

    private static void validateSecret(String s)
        throws PlayHavenException
    {
    }

    private static void validateToken(String s)
        throws PlayHavenException
    {
    }

    public static transient void w(String s, Object aobj[])
    {
        if (isLoggable(5))
        {
            Log.w(TAG, String.format(s, aobj));
        }
    }

    public static void w(Throwable throwable)
    {
        if (isLoggable(5))
        {
            Log.w(TAG, throwable.getMessage(), throwable);
        }
    }

    public static transient void w(Throwable throwable, String s, Object aobj[])
    {
        if (isLoggable(5))
        {
            Log.w(TAG, String.format(s, aobj), throwable);
        }
    }


    // Unreferenced inner class com/playhaven/android/PlayHaven$ConnectionType
    /* block-local class not found */
    class ConnectionType {}


    /* member class not found */
    class _cls1 {}

}
