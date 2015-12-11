// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.analytics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import java.util.Locale;
import java.util.TimeZone;

public class DeviceInfoUtil
{

    public DeviceInfoUtil()
    {
    }

    public static String getCarrier(Context context)
    {
        Object obj = (TelephonyManager)context.getSystemService("phone");
        String s = null;
        if (obj != null)
        {
            s = ((TelephonyManager) (obj)).getNetworkOperatorName();
        }
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = getNetworkType(context);
        }
        return ((String) (obj));
    }

    public static String getDeviceModel()
    {
        String s1 = Build.MODEL;
        String s = s1;
        if (s1 != null)
        {
            s = s1.replace(' ', '_').replace(',', '_');
        }
        return s;
    }

    public static String getMemorySize(Context context, boolean flag)
    {
label0:
        {
            Object obj = null;
            int i = getMemorySizeAsMegaBytes(context);
            context = obj;
            if (i != 0)
            {
                context = String.format(Locale.US, "%1.1f", new Object[] {
                    Float.valueOf(i)
                });
                if (!flag)
                {
                    break label0;
                }
                context = (new StringBuilder()).append(context).append("MB").toString();
            }
            return context;
        }
        return context;
    }

    public static int getMemorySizeAsMegaBytes(Context context)
    {
        int j;
        j = 0;
        context = (ActivityManager)context.getSystemService("activity");
        if (context == null) goto _L2; else goto _L1
_L1:
        double d;
        int i;
        int k;
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryinfo);
        d = (double)memoryinfo.availMem / 1024D / 1024D;
        i = 1;
        k = 0;
_L7:
        j = i;
        if (k >= 20) goto _L2; else goto _L3
_L3:
        i *= 2;
        if ((double)i <= d) goto _L5; else goto _L4
_L4:
        j = i;
_L2:
        return j;
_L5:
        k++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static String getMobileNetworkType(Context context)
    {
        NetworkInfo networkinfo = NetworkUtil.getConnectedNetworkInfo(context);
        if (networkinfo != null && networkinfo.getType() == 0)
        {
            if ((context = (TelephonyManager)context.getSystemService("phone")) != null)
            {
                switch (context.getNetworkType())
                {
                default:
                    return "Unknown";

                case 7: // '\007'
                    return "CDMA1x";

                case 4: // '\004'
                    return "CDMA";

                case 2: // '\002'
                    return "Edge";

                case 14: // '\016'
                    return "EHRPD";

                case 5: // '\005'
                    return "CDMAEVDORev0";

                case 6: // '\006'
                    return "CDMAEVDORevA";

                case 12: // '\f'
                    return "CDMAEVDORevB";

                case 1: // '\001'
                    return "GPRS";

                case 8: // '\b'
                    return "HSDPA";

                case 10: // '\n'
                    return "HSPA";

                case 15: // '\017'
                    return "HSPAP";

                case 9: // '\t'
                    return "HSUPA";

                case 11: // '\013'
                    return "IDEN";

                case 13: // '\r'
                    return "LTE";

                case 3: // '\003'
                    return "UMTS";
                }
            }
        }
        return "Unknown";
    }

    public static String getNetworkType(Context context)
    {
        context = NetworkUtil.getConnectedNetworkInfo(context);
        if (context == null)
        {
            return "Unknown";
        }
        switch (context.getType())
        {
        default:
            return "Unknown";

        case 0: // '\0'
            return "cell";

        case 1: // '\001'
            return "wifi";

        case 9: // '\t'
            return "ethernet";
        }
    }

    public static String getOsType()
    {
        return "Android";
    }

    public static String getPreferredLanguage()
    {
        Object obj = null;
        Object obj1 = Locale.getDefault();
        if (obj1 != null)
        {
            obj = new StringBuilder();
            String s = ((Locale) (obj1)).getLanguage();
            if (!TextUtils.isEmpty(s))
            {
                ((StringBuilder) (obj)).append(s);
            }
            obj1 = ((Locale) (obj1)).getCountry();
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                ((StringBuilder) (obj)).append('_').append(((String) (obj1)));
            }
            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

    public static String getScreenDpi(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return (new StringBuilder()).append(String.valueOf(((DisplayMetrics) (context)).xdpi)).append('x').append(((DisplayMetrics) (context)).ydpi).toString();
    }

    public static String getScreenResolution(Context context)
    {
        Object obj;
label0:
        {
            Object obj1 = null;
            Object obj2 = (WindowManager)context.getSystemService("window");
            obj = obj1;
            if (obj2 != null)
            {
                obj2 = ((WindowManager) (obj2)).getDefaultDisplay();
                obj = obj1;
                if (obj2 != null)
                {
                    obj = new Point();
                    ((Display) (obj2)).getSize(((Point) (obj)));
                    if (!isPortrait(context))
                    {
                        break label0;
                    }
                    obj = (new StringBuilder()).append(String.valueOf(((Point) (obj)).x)).append('x').append(((Point) (obj)).y).toString();
                }
            }
            return ((String) (obj));
        }
        return (new StringBuilder()).append(String.valueOf(((Point) (obj)).y)).append('x').append(((Point) (obj)).x).toString();
    }

    public static String getTimezone()
    {
        int j = TimeZone.getDefault().getOffset(System.currentTimeMillis());
        float f;
        int i;
        if (j == 0)
        {
            i = 0;
        } else
        if (j < 0)
        {
            i = -1;
        } else
        {
            i = 1;
        }
        f = (float)((j + i * 0xdbba0) / 0x1b7740) / 2.0F;
        return String.format(Locale.US, "%1.1f", new Object[] {
            Float.valueOf(f)
        });
    }

    public static String getTimezoneName()
    {
        return TimeZone.getDefault().getID();
    }

    public static boolean isPortrait(Context context)
    {
        return context.getResources().getConfiguration().orientation == 1;
    }
}
