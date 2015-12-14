// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, AdCache, HandShake, MMRequest, 
//            MMAdImpl, MMConversionTracker, CachedAd

public final class MMSDK
{

    public static final String DEFAULT_APID = "28911";
    public static final String DEFAULT_BANNER_APID = "28913";
    public static final String DEFAULT_RECT_APID = "28914";
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 0;
    public static final int LOG_LEVEL_INFO = 2;
    public static final int LOG_LEVEL_INTERNAL = 4;
    public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
    public static final int LOG_LEVEL_VERBOSE = 3;
    public static final String SDKLOG = "MMSDK";
    public static final String VERSION = "5.3.0-c3980670.a";
    static int a;
    static boolean b = false;
    static String c = ",";
    static String d;
    private static boolean e;
    private static int f = 0x711e41a1;
    private static Handler g = new Handler(Looper.getMainLooper());
    private static String h = null;
    private static boolean i = false;

    private MMSDK()
    {
    }

    private static AlertDialog a(Context context, String s)
    {
        context = (new android.app.AlertDialog.Builder(context)).create();
        context.setTitle("Whoops!");
        context.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", new Object[] {
            s
        }));
        context.setButton(-3, "OK", new android.content.DialogInterface.OnClickListener() {

            public final void onClick(DialogInterface dialoginterface, int i1)
            {
                dialoginterface.cancel();
            }

        });
        context.show();
        return context;
    }

    static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        for (int i1 = 0; i1 < abyte0.length; i1++)
        {
            stringbuilder.append(String.format("%02X", new Object[] {
                Byte.valueOf(abyte0[i1])
            }));
        }

        return stringbuilder.toString();
    }

    static void a(Context context, Map map)
    {
        Object obj2;
        obj2 = null;
        MMLog.b("MMSDK", "executing getIDThread");
        map.put("density", Float.toString(context.getResources().getDisplayMetrics().density));
        map.put("hpx", g(context));
        map.put("wpx", f(context));
        if (!i) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        String s;
        String s1;
        boolean flag;
        if (context.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        obj = "true";
_L14:
        map.put("sk", obj);
        map.put("mic", Boolean.toString(context.getPackageManager().hasSystemFeature("android.hardware.microphone")));
        s1 = "true";
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info = n(context);
        if (info == null)
        {
            break MISSING_BLOCK_LABEL_967;
        }
        float f1;
        if (info == null)
        {
            obj = null;
        } else
        {
            obj = info.getId();
        }
        obj1 = s1;
        s = ((String) (obj));
        if (obj != null)
        {
            obj1 = s1;
            s = ((String) (obj));
            if (info.isLimitAdTrackingEnabled())
            {
                obj1 = "false";
                s = ((String) (obj));
            }
        }
_L20:
        if (s != null)
        {
            map.put("aaid", s);
            map.put("ate", obj1);
        } else
        {
            obj = c(context);
            if (obj != null)
            {
                map.put("mmdid", obj);
            }
        }
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1 && (!android.os.Build.VERSION.SDK.equalsIgnoreCase("8") || Environment.getExternalStorageState().equals("mounted") && AdCache.a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            map.put("cachedvideo", "true");
        } else
        {
            map.put("cachedvideo", "false");
        }
        if (Build.MODEL != null)
        {
            map.put("dm", Build.MODEL);
        }
        if (android.os.Build.VERSION.RELEASE != null)
        {
            map.put("dv", (new StringBuilder("Android")).append(android.os.Build.VERSION.RELEASE).toString());
        }
        map.put("sdkversion", "5.3.0-c3980670.a");
        obj = context.getResources().getConfiguration();
        if (((Configuration) (obj)).mcc != 0) goto _L5; else goto _L4
_L4:
        obj1 = m(context);
        if (obj1 == null || ((String) (obj1)).length() < 6) goto _L5; else goto _L6
_L6:
        obj = ((String) (obj1)).substring(0, 3);
_L15:
        map.put("mcc", obj);
        obj = context.getResources().getConfiguration();
        if (((Configuration) (obj)).mnc != 0) goto _L8; else goto _L7
_L7:
        obj1 = m(context);
        if (obj1 == null || ((String) (obj1)).length() < 6) goto _L8; else goto _L9
_L9:
        obj = ((String) (obj1)).substring(3);
_L16:
        map.put("mnc", obj);
        obj = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            map.put("cn", obj);
        }
        obj = Locale.getDefault();
        if (obj != null)
        {
            map.put("language", ((Locale) (obj)).getLanguage());
            map.put("country", ((Locale) (obj)).getCountry());
        }
        try
        {
            obj = context.getPackageName();
            map.put("pkid", obj);
            obj1 = context.getPackageManager();
            map.put("pknm", ((PackageManager) (obj1)).getApplicationLabel(((PackageManager) (obj1)).getApplicationInfo(((String) (obj)), 0)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.a("MMSDK", "Can't insert package information", ((Throwable) (obj)));
        }
        obj = HandShake.a(context).b(context);
        if (obj != null)
        {
            map.put("appsids", obj);
        }
        obj = AdCache.a(context);
        if (obj != null)
        {
            map.put("vid", obj);
        }
        s = b(context);
        if (!AdCache.h(context)) goto _L11; else goto _L10
_L10:
        obj = new StatFs(AdCache.f(context).getAbsolutePath());
_L17:
        s1 = Long.toString((long)((StatFs) (obj)).getAvailableBlocks() * (long)((StatFs) (obj)).getBlockSize());
        obj = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (obj == null) goto _L13; else goto _L12
_L12:
        if (((Intent) (obj)).getIntExtra("plugged", 0) == 0)
        {
            context = "false";
        } else
        {
            context = "true";
        }
        f1 = 100F / (float)((Intent) (obj)).getIntExtra("scale", 100);
        obj1 = Integer.toString((int)((float)((Intent) (obj)).getIntExtra("level", 0) * f1));
        obj = context;
        context = ((Context) (obj1));
_L19:
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_735;
        }
        if (context.length() > 0)
        {
            map.put("bl", context);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_757;
        }
        if (((String) (obj)).length() > 0)
        {
            map.put("plugged", obj);
        }
        if (s1.length() > 0)
        {
            map.put("space", s1);
        }
        map.put("conn", s);
        context = URLEncoder.encode(e(), "UTF-8");
        if (!TextUtils.isEmpty(context))
        {
            map.put("pip", context);
        }
_L18:
        MMRequest.b(map);
        return;
_L2:
        obj = "false";
          goto _L14
_L5:
        obj = String.valueOf(((Configuration) (obj)).mcc);
          goto _L15
_L8:
        obj = String.valueOf(((Configuration) (obj)).mnc);
          goto _L16
_L11:
        obj = new StatFs(context.getFilesDir().getPath());
          goto _L17
        context;
        MMLog.a("MMSDK", "Exception inserting common parameters: ", context);
          goto _L18
_L13:
        context = null;
        obj = obj2;
          goto _L19
        s = null;
        obj1 = s1;
          goto _L20
    }

    static void a(MMAdImpl mmadimpl)
    {
        if (mmadimpl != null)
        {
            Context context = mmadimpl.i();
            MMLog.c("MMSDK", String.format("MMAd External ID: %d", new Object[] {
                Integer.valueOf(mmadimpl.e())
            }));
            MMLog.c("MMSDK", String.format("MMAd Internal ID: %d", new Object[] {
                Long.valueOf(mmadimpl.f)
            }));
            MMLog.c("MMSDK", String.format("APID: %s", new Object[] {
                mmadimpl.d
            }));
            if (AdCache.h(context))
            {
                mmadimpl = "";
            } else
            {
                mmadimpl = "not ";
            }
            MMLog.c("MMSDK", String.format("SD card is %savailable.", new Object[] {
                mmadimpl
            }));
            if (context != null)
            {
                MMLog.c("MMSDK", String.format("Package: %s", new Object[] {
                    context.getPackageName()
                }));
                MMLog.c("MMSDK", String.format("MMDID: %s", new Object[] {
                    c(context)
                }));
                MMLog.c("MMSDK", "Permissions:");
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
                {
                    mmadimpl = "not ";
                } else
                {
                    mmadimpl = "";
                }
                MMLog.c("MMSDK", String.format("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[] {
                    mmadimpl
                }));
                if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
                {
                    mmadimpl = "not ";
                } else
                {
                    mmadimpl = "";
                }
                MMLog.c("MMSDK", String.format("android.permission.INTERNET is %spresent", new Object[] {
                    mmadimpl
                }));
                if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1)
                {
                    mmadimpl = "not ";
                } else
                {
                    mmadimpl = "";
                }
                MMLog.c("MMSDK", String.format("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[] {
                    mmadimpl
                }));
                if (context.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1)
                {
                    mmadimpl = "not ";
                } else
                {
                    mmadimpl = "";
                }
                MMLog.c("MMSDK", String.format("android.permission.VIBRATE is %spresent", new Object[] {
                    mmadimpl
                }));
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1)
                {
                    mmadimpl = "not ";
                } else
                {
                    mmadimpl = "";
                }
                MMLog.c("MMSDK", String.format("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[] {
                    mmadimpl
                }));
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)
                {
                    mmadimpl = "not ";
                } else
                {
                    mmadimpl = "";
                }
                MMLog.c("MMSDK", String.format("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[] {
                    mmadimpl
                }));
                MMLog.c("MMSDK", "Cached Ads:");
                AdCache.a(context, 2, new AdCache.Iterator(context) {

                    private Context a;

                    final boolean a(CachedAd cachedad)
                    {
                        String s1 = cachedad.getTypeString();
                        String s2 = cachedad.getId();
                        String s;
                        if (cachedad.isOnDisk(a))
                        {
                            s = "";
                        } else
                        {
                            s = "not ";
                        }
                        if (cachedad.isExpired())
                        {
                            cachedad = "";
                        } else
                        {
                            cachedad = "not ";
                        }
                        MMLog.c("MMSDK", String.format("%s %s is %son disk. Is %sexpired.", new Object[] {
                            s1, s2, s, cachedad
                        }));
                        return true;
                    }

            
            {
                a = context;
                super();
            }
                });
                return;
            }
        }
    }

    static void a(Runnable runnable)
    {
        if (a())
        {
            runnable.run();
            return;
        } else
        {
            g.post(runnable);
            return;
        }
    }

    static void a(Runnable runnable, long l1)
    {
        g.postDelayed(runnable, l1);
    }

    static void a(String s)
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        h = s;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    static boolean a()
    {
        return g.getLooper() == Looper.myLooper();
    }

    static boolean a(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return false;
        }
        return context.getActiveNetworkInfo() != null && context.getActiveNetworkInfo().isConnected();
    }

    static String b(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return "unknown";
        }
        if (context.getActiveNetworkInfo() != null && context.getActiveNetworkInfo().isConnected())
        {
            int i1 = context.getActiveNetworkInfo().getType();
            int j1 = context.getActiveNetworkInfo().getSubtype();
            if (i1 == 1)
            {
                return "wifi";
            }
            if (i1 == 0)
            {
                switch (j1)
                {
                default:
                    return "unknown";

                case 7: // '\007'
                    return "1xrtt";

                case 4: // '\004'
                    return "cdma";

                case 2: // '\002'
                    return "edge";

                case 14: // '\016'
                    return "ehrpd";

                case 5: // '\005'
                    return "evdo_0";

                case 6: // '\006'
                    return "evdo_a";

                case 12: // '\f'
                    return "evdo_b";

                case 1: // '\001'
                    return "gprs";

                case 8: // '\b'
                    return "hsdpa";

                case 10: // '\n'
                    return "hspa";

                case 15: // '\017'
                    return "hspap";

                case 9: // '\t'
                    return "hsupa";

                case 11: // '\013'
                    return "iden";

                case 13: // '\r'
                    return "lte";

                case 3: // '\003'
                    return "umts";
                }
            } else
            {
                return "unknown";
            }
        } else
        {
            return "offline";
        }
    }

    static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    static String c(Context context)
    {
        Object obj = null;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        if (h == null) goto _L2; else goto _L1
_L1:
        context = h;
_L4:
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return context;
_L2:
        String s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        context = obj;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = new StringBuilder("mmh_");
        context.append(a(MessageDigest.getInstance("MD5").digest(s.getBytes())));
        context.append("_");
        context.append(a(MessageDigest.getInstance("SHA1").digest(s.getBytes())));
        context = context.toString();
        h = context;
        continue; /* Loop/switch isn't completed */
        context;
        throw context;
        context;
        MMLog.a("MMSDK", "Exception calculating hash: ", context);
        context = obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean c()
    {
        return Integer.parseInt(android.os.Build.VERSION.SDK) >= 11;
    }

    static void d(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
        {
            a(context, "INTERNET permission").show();
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            a(context, "ACCESS_NETWORK_STATE permission").show();
        }
    }

    static boolean d()
    {
        return e;
    }

    private static String e()
    {
        StringBuilder stringbuilder;
        Enumeration enumeration;
        stringbuilder = new StringBuilder();
        enumeration = NetworkInterface.getNetworkInterfaces();
_L6:
        Enumeration enumeration1;
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_145;
        }
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
_L3:
        Object obj;
        do
        {
            if (!enumeration1.hasMoreElements())
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (InetAddress)enumeration1.nextElement();
        } while (((InetAddress) (obj)).isLoopbackAddress());
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append(',');
        }
        obj = ((InetAddress) (obj)).getHostAddress().toUpperCase();
        if (!InetAddressUtils.isIPv4Address(((String) (obj)))) goto _L2; else goto _L1
_L1:
        stringbuilder.append(((String) (obj)));
          goto _L3
_L2:
        int i1;
        try
        {
            i1 = ((String) (obj)).indexOf('%');
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.a("MMSDK", "Exception getting ip information: ", ((Throwable) (obj)));
            return "";
        }
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_134;
        }
_L4:
        stringbuilder.append(((String) (obj)));
          goto _L3
        continue; /* Loop/switch isn't completed */
        obj = ((String) (obj)).substring(0, i1);
          goto _L4
        obj = stringbuilder.toString();
        return ((String) (obj));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void e(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            packagemanager.getActivityInfo(new ComponentName(context, "com.millennialmedia.android.MMActivity"), 128);
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            MMLog.a("MMSDK", "Activity MMActivity not declared in AndroidManifest.xml", namenotfoundexception);
            namenotfoundexception.printStackTrace();
            a(context, "MMActivity class").show();
            return;
        }
    }

    static String f(Context context)
    {
        return Integer.toString(context.getResources().getDisplayMetrics().widthPixels);
    }

    static String g(Context context)
    {
        return Integer.toString(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static boolean getBroadcastEvents()
    {
        return e;
    }

    public static int getDefaultAdId()
    {
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorenter ;
        int i1;
        i1 = f + 1;
        f = i1;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        com/millennialmedia/android/MMSDK;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int getLogLevel()
    {
        return MMLog.getLogLevel();
    }

    static int h(Context context)
    {
        return ((AudioManager)context.getApplicationContext().getSystemService("audio")).getStreamVolume(3);
    }

    static String i(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    public static void initialize(Context context)
    {
        context = HandShake.a(context);
        context.a(true);
        if (!TextUtils.isEmpty(((HandShake) (context)).e))
        {
            Utils.HttpUtils.a(((HandShake) (context)).e);
        }
    }

    static String j(Context context)
    {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String k(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return "default";

        case 1: // '\001'
            return "portrait";

        case 2: // '\002'
            return "landscape";

        case 3: // '\003'
            return "square";
        }
    }

    static final String l(Context context)
    {
        if (android.provider.Settings.System.getString(context.getContentResolver(), "accelerometer_rotation").equals("1"))
        {
            return "false";
        } else
        {
            return "true";
        }
    }

    private static String m(Context context)
    {
        return ((TelephonyManager)context.getSystemService("phone")).getNetworkOperator();
    }

    private static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info n(Context context)
    {
        try
        {
            context = AdvertisingIdClient.getAdvertisingIdInfo(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("MMSDK", "Unrecoverable error connecting to Google Play services (e.g.,the old version of the service doesnt support getting AdvertisingId", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("MMSDK", "Google Play services is not available entirely.", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("MMSDK", "IllegalStateException: ", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MMLog.a("MMSDK", "Google Play Services is not installed, up-to-date, or enabled", context);
            return null;
        }
        return context;
    }

    public static void resetCache(Context context)
    {
        AdCache.e(context);
    }

    public static void setBroadcastEvents(boolean flag)
    {
        e = flag;
    }

    public static void setLogLevel(int i1)
    {
        switch (i1)
        {
        default:
            MMLog.setLogLevel(4);
            return;

        case 1: // '\001'
            MMLog.setLogLevel(3);
            return;

        case 2: // '\002'
            MMLog.setLogLevel(4);
            return;

        case 3: // '\003'
            MMLog.setLogLevel(2);
            return;

        case 0: // '\0'
            MMLog.setLogLevel(6);
            return;
        }
    }

    public static void trackConversion(Context context, String s)
    {
        MMConversionTracker.a(context, s, null);
    }

    public static void trackConversion(Context context, String s, MMRequest mmrequest)
    {
        MMConversionTracker.a(context, s, mmrequest);
    }

    public static void trackEvent(Context context, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            context = c(context);
            if (!TextUtils.isEmpty(context))
            {
                Utils.HttpUtils.a((new StringBuilder("http://ads.mp.mydas.mobi/pixel?id=")).append(s).append("&mmdid=").append(context).toString());
            }
        }
    }

    static 
    {
        try
        {
            System.loadLibrary("nmsp_speex");
            i = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror) { }
    }
}
