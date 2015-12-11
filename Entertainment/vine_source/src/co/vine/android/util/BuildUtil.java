// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import co.vine.android.recorder.RecordConfigUtils;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.util:
//            CrashUtil, PlayerUtil, SystemUtil

public class BuildUtil
{

    public static final int APP_TYPE_EXPLORE = 2;
    public static final int APP_TYPE_REGULAR = 1;
    public static final int ENVIRONMENT_DEV = 2;
    public static final int ENVIRONMENT_PRODUCTION = 1;
    public static final boolean EPHEMERAL_ENABLED = false;
    public static final int MARKET_AMAZON = 2;
    public static final int MARKET_ASTAR = 3;
    public static final int MARKET_GOOGLE = 1;
    private static Boolean isOldDeviceOrLowEndDevice = null;
    private static int sAppType;
    private static String sAuthority = "co.vine.android";
    private static int sEnvironment;
    private static final boolean sIsHwEncodingEnabled;
    private static final boolean sIsSwEncodingEnabled;
    private static boolean sLogsOn;
    private static int sMarket;

    public BuildUtil()
    {
    }

    public static String getAmazonBucket(Context context)
    {
        return context.getString(0x7f0e004a);
    }

    public static String getAuthority()
    {
        return getAuthority("");
    }

    public static String getAuthority(String s)
    {
        return (new StringBuilder()).append(sAuthority).append(s).toString();
    }

    public static String getBaseUrl(Resources resources)
    {
        return resources.getString(0x7f0e0272);
    }

    public static String getConfigUrl(Resources resources)
    {
        return resources.getString(0x7f0e0274);
    }

    public static String getExplorePath(Resources resources)
    {
        return resources.getString(0x7f0e00d4);
    }

    public static String getExploreUrl(Resources resources)
    {
        return resources.getString(0x7f0e00d3);
    }

    public static int getMarket()
    {
        return sMarket;
    }

    public static String getMediaUrl(Resources resources)
    {
        return resources.getString(0x7f0e0275);
    }

    public static String getRtcUrl(Resources resources)
    {
        return resources.getString(0x7f0e01b4);
    }

    public static String getSenderId(Context context)
    {
        return context.getString(0x7f0e01c1);
    }

    public static String getStatusUrl(Context context)
    {
        return context.getString(0x7f0e022f);
    }

    public static String getWebsiteUrl(Context context)
    {
        return context.getString(0x7f0e0276);
    }

    public static boolean isAStar()
    {
        return sMarket == 3;
    }

    public static boolean isAmazon()
    {
        return sMarket == 2;
    }

    public static boolean isExplore()
    {
        return sAppType == 2;
    }

    public static boolean isGoogle()
    {
        return sMarket == 1;
    }

    public static boolean isI18nOn()
    {
        return sLogsOn;
    }

    public static boolean isIsHwEncodingEnabled()
    {
        return sIsHwEncodingEnabled;
    }

    public static boolean isLogsOn()
    {
        return sLogsOn;
    }

    public static boolean isOldDeviceOrLowEndDevice(Context context)
    {
label0:
        {
label1:
            {
                boolean flag1 = false;
                if (isOldDeviceOrLowEndDevice != null)
                {
                    break label0;
                }
                if (!isExplore())
                {
                    boolean flag;
                    if (!isExplore())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (SystemUtil.getMemoryRatio(context, flag) >= 1.0D)
                    {
                        break label1;
                    }
                }
                flag1 = true;
            }
            isOldDeviceOrLowEndDevice = Boolean.valueOf(flag1);
        }
        return isOldDeviceOrLowEndDevice.booleanValue();
    }

    public static boolean isProduction()
    {
        return sEnvironment == 1;
    }

    public static boolean isRegular()
    {
        return sAppType == 1;
    }

    public static void setup(String s, String s1, String s2, String s3, boolean flag, String s4)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 32
    //                   -1414265340: 103
    //                   93122099: 118;
           goto _L1 _L2 _L3
_L1:
        byte0;
        JVM INSTR tableswitch 0 1: default 56
    //                   0 133
    //                   1 140;
           goto _L4 _L5 _L6
_L4:
        sMarket = 1;
_L7:
        if ("production".equals(s3))
        {
            sEnvironment = 1;
        } else
        {
            sEnvironment = 2;
        }
        if ("explore".equals(s1))
        {
            sAppType = 2;
        } else
        {
            sAppType = 1;
        }
        if (!TextUtils.isEmpty(s2))
        {
            sAuthority = s2;
        }
        sLogsOn = flag;
        return;
_L2:
        if (s.equals("amazon"))
        {
            byte0 = 0;
        }
          goto _L1
_L3:
        if (s.equals("astar"))
        {
            byte0 = 1;
        }
          goto _L1
_L5:
        sMarket = 2;
          goto _L7
_L6:
        sMarket = 3;
          goto _L7
    }

    static 
    {
        sIsHwEncodingEnabled = RecordConfigUtils.HW_ENABLED;
        sIsSwEncodingEnabled = RecordConfigUtils.SW_ENABLED;
        setup("google", "regular", "co.vine.android", "production", false, "sw");
        CrashUtil.setup(false);
        PlayerUtil.setup("co.vine.android");
        SLog.setup(false, "amazon".equals("google"), "co.vine.android");
    }
}
