// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.unity3d.ads.android;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;

// Referenced classes of package com.unity3d.ads.android:
//            UnityAdsDeviceLogLevel, m, UnityAdsDeviceLogEntry

public class UnityAdsDeviceLog
{

    public static int LOGLEVEL_DEBUG = 8;
    public static int LOGLEVEL_ERROR = 1;
    public static int LOGLEVEL_INFO = 4;
    public static int LOGLEVEL_NONE = 0;
    public static int LOGLEVEL_WARNING = 2;
    private static boolean a = true;
    private static boolean b = true;
    private static boolean c = true;
    private static boolean d = false;
    private static boolean e = true;
    private static HashMap f;

    public UnityAdsDeviceLog()
    {
    }

    private static String a(String s)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            s1 = "DO NOT USE EMPTY MESSAGES, use UnityAdsDeviceLog.entered() instead";
        }
        return s1;
    }

    private static void a(UnityAdsLogLevel unityadsloglevel, String s)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = false;
        flag2 = a;
        flag1 = flag2;
        if (!flag2) goto _L2; else goto _L1
_L1:
        m.a[unityadsloglevel.ordinal()];
        JVM INSTR tableswitch 1 4: default 56
    //                   1 149
    //                   2 157
    //                   3 165
    //                   4 173;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        flag1 = flag2;
_L2:
        if (!flag1) goto _L9; else goto _L8
_L8:
        UnityAdsDeviceLogLevel unityadsdeviceloglevel;
        StackTraceElement astacktraceelement[];
        astacktraceelement = Thread.currentThread().getStackTrace();
        unityadsdeviceloglevel = (UnityAdsDeviceLogLevel)f.get(unityadsloglevel);
        if (unityadsdeviceloglevel == null) goto _L11; else goto _L10
_L4:
        flag1 = e;
          goto _L2
_L5:
        flag1 = d;
          goto _L2
_L6:
        flag1 = c;
          goto _L2
_L7:
        flag1 = b;
          goto _L2
_L10:
        int i = 0;
        do
        {
            if (i >= astacktraceelement.length)
            {
                break;
            }
            unityadsloglevel = astacktraceelement[i];
            if (unityadsloglevel.getClassName().equals(com/unity3d/ads/android/UnityAdsDeviceLog.getName()))
            {
                flag = true;
            }
            if (!unityadsloglevel.getClassName().equals(com/unity3d/ads/android/UnityAdsDeviceLog.getName()) && flag)
            {
                break;
            }
            i++;
        } while (true);
        if (i < astacktraceelement.length)
        {
            unityadsloglevel = astacktraceelement[i];
        } else
        {
            unityadsloglevel = null;
        }
        if (unityadsloglevel == null) goto _L11; else goto _L12
_L12:
        unityadsloglevel = new UnityAdsDeviceLogEntry(unityadsdeviceloglevel, s, unityadsloglevel);
_L16:
        if (unityadsloglevel == null || unityadsloglevel.getLogLevel() == null) goto _L9; else goto _L13
_L13:
        try
        {
            s = android/util/Log.getMethod(unityadsloglevel.getLogLevel().getReceivingMethodName(), new Class[] {
                java/lang/String, java/lang/String
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = null;
        }
        if (s == null) goto _L9; else goto _L14
_L14:
        s.invoke(null, new Object[] {
            unityadsloglevel.getLogLevel().getLogTag(), unityadsloglevel.getParsedMessage()
        });
_L9:
        return;
        unityadsloglevel;
        return;
_L11:
        unityadsloglevel = null;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public static void debug(String s)
    {
label0:
        {
            for (; s.length() > 3072; s = s.substring(3072))
            {
                debug(s.substring(0, 3072));
                if (s.length() >= 30720)
                {
                    break label0;
                }
            }

            a(UnityAdsLogLevel.DEBUG, a(s));
        }
    }

    public static transient void debug(String s, Object aobj[])
    {
        debug(String.format(s, aobj));
    }

    public static void entered()
    {
        debug("ENTERED METHOD");
    }

    public static void error(String s)
    {
        a(UnityAdsLogLevel.ERROR, a(s));
    }

    public static transient void error(String s, Object aobj[])
    {
        error(String.format(s, aobj));
    }

    public static void info(String s)
    {
        a(UnityAdsLogLevel.INFO, a(s));
    }

    public static transient void info(String s, Object aobj[])
    {
        info(String.format(s, aobj));
    }

    public static void setLogLevel(int i)
    {
        if (i >= LOGLEVEL_DEBUG)
        {
            b = true;
            c = true;
            e = true;
            d = true;
            return;
        }
        if (i >= LOGLEVEL_INFO)
        {
            b = true;
            c = true;
            e = true;
            d = false;
            return;
        }
        if (i >= LOGLEVEL_WARNING)
        {
            b = true;
            c = true;
            e = false;
            d = false;
            return;
        }
        if (i >= LOGLEVEL_ERROR)
        {
            b = true;
            c = false;
            e = false;
            d = false;
            return;
        } else
        {
            b = false;
            c = false;
            e = false;
            d = false;
            return;
        }
    }

    public static void warning(String s)
    {
        a(UnityAdsLogLevel.WARNING, a(s));
    }

    public static transient void warning(String s, Object aobj[])
    {
        warning(String.format(s, aobj));
    }

    static 
    {
        f = null;
        HashMap hashmap = new HashMap();
        f = hashmap;
        hashmap.put(UnityAdsLogLevel.INFO, new UnityAdsDeviceLogLevel(UnityAdsLogLevel.INFO, "UnityAds", "i"));
        f.put(UnityAdsLogLevel.DEBUG, new UnityAdsDeviceLogLevel(UnityAdsLogLevel.DEBUG, "UnityAds", "d"));
        f.put(UnityAdsLogLevel.WARNING, new UnityAdsDeviceLogLevel(UnityAdsLogLevel.WARNING, "UnityAds", "w"));
        f.put(UnityAdsLogLevel.ERROR, new UnityAdsDeviceLogLevel(UnityAdsLogLevel.ERROR, "UnityAds", "e"));
    }

    /* member class not found */
    class UnityAdsLogLevel {}

}
