// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.logging.MoPubLog;
import java.io.File;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.mopub.common.util:
//            Utils, VersionCode

public class DeviceUtils
{
    public static final class ForceOrientation extends Enum
    {

        private static final ForceOrientation $VALUES[];
        public static final ForceOrientation DEVICE_ORIENTATION;
        public static final ForceOrientation FORCE_LANDSCAPE;
        public static final ForceOrientation FORCE_PORTRAIT;
        public static final ForceOrientation UNDEFINED;
        private final String mKey;

        public static ForceOrientation getForceOrientation(String s)
        {
            ForceOrientation aforceorientation[] = values();
            int j = aforceorientation.length;
            for (int i = 0; i < j; i++)
            {
                ForceOrientation forceorientation = aforceorientation[i];
                if (forceorientation.mKey.equalsIgnoreCase(s))
                {
                    return forceorientation;
                }
            }

            return UNDEFINED;
        }

        public static ForceOrientation valueOf(String s)
        {
            return (ForceOrientation)Enum.valueOf(com/mopub/common/util/DeviceUtils$ForceOrientation, s);
        }

        public static ForceOrientation[] values()
        {
            return (ForceOrientation[])$VALUES.clone();
        }

        static 
        {
            FORCE_PORTRAIT = new ForceOrientation("FORCE_PORTRAIT", 0, "portrait");
            FORCE_LANDSCAPE = new ForceOrientation("FORCE_LANDSCAPE", 1, "landscape");
            DEVICE_ORIENTATION = new ForceOrientation("DEVICE_ORIENTATION", 2, "device");
            UNDEFINED = new ForceOrientation("UNDEFINED", 3, "");
            $VALUES = (new ForceOrientation[] {
                FORCE_PORTRAIT, FORCE_LANDSCAPE, DEVICE_ORIENTATION, UNDEFINED
            });
        }

        private ForceOrientation(String s, int i, String s1)
        {
            super(s, i);
            mKey = s1;
        }
    }

    public static final class IP extends Enum
    {

        private static final IP $VALUES[];
        public static final IP IPv4;
        public static final IP IPv6;

        private boolean matches(String s)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$mopub$common$util$DeviceUtils$IP[];

                static 
                {
                    $SwitchMap$com$mopub$common$util$DeviceUtils$IP = new int[IP.values().length];
                    try
                    {
                        $SwitchMap$com$mopub$common$util$DeviceUtils$IP[IP.IPv4.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$mopub$common$util$DeviceUtils$IP[IP.IPv6.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.mopub.common.util.DeviceUtils.IP[ordinal()])
            {
            default:
                return false;

            case 1: // '\001'
                return InetAddressUtils.isIPv4Address(s);

            case 2: // '\002'
                return InetAddressUtils.isIPv6Address(s);
            }
        }

        private String toString(String s)
        {
            String s1 = s;
            switch (_cls1..SwitchMap.com.mopub.common.util.DeviceUtils.IP[ordinal()])
            {
            default:
                s1 = null;
                // fall through

            case 1: // '\001'
                return s1;

            case 2: // '\002'
                return s.split("%")[0];
            }
        }

        public static IP valueOf(String s)
        {
            return (IP)Enum.valueOf(com/mopub/common/util/DeviceUtils$IP, s);
        }

        public static IP[] values()
        {
            return (IP[])$VALUES.clone();
        }

        static 
        {
            IPv4 = new IP("IPv4", 0);
            IPv6 = new IP("IPv6", 1);
            $VALUES = (new IP[] {
                IPv4, IPv6
            });
        }



        private IP(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int MAX_DISK_CACHE_SIZE = 0x6400000;
    private static final int MAX_MEMORY_CACHE_SIZE = 0x1e00000;
    private static final int MIN_DISK_CACHE_SIZE = 0x1e00000;

    private DeviceUtils()
    {
    }

    public static long diskCacheSizeBytes(File file)
    {
        return diskCacheSizeBytes(file, 0x1e00000L);
    }

    public static long diskCacheSizeBytes(File file, long l)
    {
        long l1;
        file = new StatFs(file.getAbsolutePath());
        l1 = ((long)file.getBlockCount() * (long)file.getBlockSize()) / 50L;
        l = l1;
_L2:
        return Math.max(Math.min(l, 0x6400000L), 0x1e00000L);
        file;
        MoPubLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Point getDeviceDimensions(Context context)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj = null;
        obj3 = null;
        obj1 = obj3;
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L2; else goto _L1
_L1:
        obj1 = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        if (android.os.Build.VERSION.SDK_INT < 17) goto _L4; else goto _L3
_L3:
        obj2 = new Point();
        ((Display) (obj1)).getRealSize(((Point) (obj2)));
        obj = Integer.valueOf(((Point) (obj2)).x);
        obj1 = Integer.valueOf(((Point) (obj2)).y);
_L2:
label0:
        {
            if (obj != null)
            {
                obj2 = obj1;
                if (obj1 != null)
                {
                    break label0;
                }
            }
            context = context.getResources().getDisplayMetrics();
            obj = Integer.valueOf(((DisplayMetrics) (context)).widthPixels);
            obj2 = Integer.valueOf(((DisplayMetrics) (context)).heightPixels);
        }
        return new Point(((Integer) (obj)).intValue(), ((Integer) (obj2)).intValue());
_L4:
        obj = obj2;
        obj2 = (Integer)(new Reflection.MethodBuilder(obj1, "getRawWidth")).execute();
        obj = obj2;
        obj1 = (Integer)(new Reflection.MethodBuilder(obj1, "getRawHeight")).execute();
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        MoPubLog.v("Display#getRawWidth/Height failed.", exception);
        exception = obj3;
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static String getHashedUdid(Context context)
    {
        if (context == null)
        {
            return null;
        } else
        {
            return Utils.sha1(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
        }
    }

    public static String getIpAddress(IP ip)
        throws SocketException
    {
        Iterator iterator = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
_L2:
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        iterator1 = Collections.list(((NetworkInterface)iterator.next()).getInetAddresses()).iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (InetAddress)iterator1.next();
        if (((InetAddress) (obj)).isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        obj = ((InetAddress) (obj)).getHostAddress().toUpperCase(Locale.US);
        if (!ip.matches(((String) (obj)))) goto _L4; else goto _L5
_L5:
        return ip.toString(((String) (obj)));
        return null;
    }

    public static int getScreenOrientation(Activity activity)
    {
        return getScreenOrientationFromRotationAndOrientation(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
    }

    static int getScreenOrientationFromRotationAndOrientation(int i, int j)
    {
        byte byte0 = 9;
        if (1 == j)
        {
            j = byte0;
            switch (i)
            {
            default:
                j = 1;
                // fall through

            case 1: // '\001'
            case 2: // '\002'
                return j;
            }
        }
        if (2 == j)
        {
            switch (i)
            {
            default:
                return 0;

            case 2: // '\002'
            case 3: // '\003'
                return 8;
            }
        } else
        {
            MoPubLog.d("Unknown screen orientation. Defaulting to portrait.");
            return 9;
        }
    }

    public static boolean isNetworkAvailable(Context context)
    {
        while (context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) 
        {
            return false;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
        {
            return true;
        }
        boolean flag;
        try
        {
            flag = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return flag;
    }

    public static void lockOrientation(Activity activity, CreativeOrientation creativeorientation)
    {
        if (com.mopub.common.Preconditions.NoThrow.checkNotNull(creativeorientation) && com.mopub.common.Preconditions.NoThrow.checkNotNull(activity)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = getScreenOrientationFromRotationAndOrientation(((WindowManager)activity.getSystemService("window")).getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
        if (CreativeOrientation.PORTRAIT != creativeorientation)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (9 == i)
        {
            i = 9;
        } else
        {
            i = 1;
        }
_L4:
        activity.setRequestedOrientation(i);
        return;
        if (CreativeOrientation.LANDSCAPE != creativeorientation) goto _L1; else goto _L3
_L3:
        if (8 == i)
        {
            i = 8;
        } else
        {
            i = 0;
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static int memoryCacheSizeBytes(Context context)
    {
        ActivityManager activitymanager;
        long l;
        long l1;
        activitymanager = (ActivityManager)context.getSystemService("activity");
        l1 = activitymanager.getMemoryClass();
        l = l1;
        if (!VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        int i = android/content/pm/ApplicationInfo.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
        l = l1;
        if (!Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, i))
        {
            break MISSING_BLOCK_LABEL_88;
        }
        i = ((Integer)(new Reflection.MethodBuilder(activitymanager, "getLargeMemoryClass")).execute()).intValue();
        l = i;
_L2:
        return (int)Math.min(0x1e00000L, (l / 8L) * 1024L * 1024L);
        context;
        MoPubLog.d("Unable to reflectively determine large heap size on Honeycomb and above.");
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
