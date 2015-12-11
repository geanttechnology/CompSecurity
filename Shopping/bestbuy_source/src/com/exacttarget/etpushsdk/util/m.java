// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import com.exacttarget.etpushsdk.ETPush;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            ETLogger, d, o, n

public class m
{

    private static String a = null;

    public static int a(String s, String s1)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 3)
        {
            s = a(s);
            s1 = c(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[0]);
            i = Log.d(s, s1);
        }
        return i;
    }

    public static int a(String s, String s1, Throwable throwable)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 3)
        {
            s = a(s);
            s1 = c(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[] {
                throwable
            });
            i = Log.d(s, s1, throwable);
        }
        return i;
    }

    private static String a(String s)
    {
        return String.format("%-25s", new Object[] {
            s
        });
    }

    public static int b(String s, String s1)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 4)
        {
            s = a(s);
            s1 = c(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[0]);
            i = Log.i(s, s1);
        }
        return i;
    }

    public static int b(String s, String s1, Throwable throwable)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 5)
        {
            s = a(s);
            s1 = c(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[] {
                throwable
            });
            i = Log.w(s, s1, throwable);
        }
        return i;
    }

    private static String b(String s)
    {
        while (TextUtils.isEmpty(s) || ETPush.a() == null || com.exacttarget.etpushsdk.util.d.c() == null) 
        {
            return s;
        }
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append(s).append("\n").append(String.format("ET PUSH SDK VERSION: %1$s build %2$d", new Object[] {
            o.a(), Integer.valueOf(o.b())
        })).append("\n").append(String.format("APP VERSION: %1$s : %2$s", new Object[] {
            n.b(), Integer.valueOf(n.a())
        })).append("\n").append("readyAimFire() Initialized with: ").append("\n").append(String.format("Context: %1$s", new Object[] {
            ETPush.a().toString()
        })).append("\n").append(String.format("ET App Id: %1$s", new Object[] {
            com.exacttarget.etpushsdk.util.d.b()
        })).append("\n").append(String.format("Access Token: %1$s", new Object[] {
            com.exacttarget.etpushsdk.util.d.c()
        })).append("\n").append(String.format("GCM Sender ID: %1$s", new Object[] {
            com.exacttarget.etpushsdk.util.d.d()
        })).append("\n").append(String.format("Analytics: %1$s", new Object[] {
            Boolean.valueOf(com.exacttarget.etpushsdk.util.d.f())
        })).append("\n").append(String.format("PIAnalytics: %1$s", new Object[] {
            Boolean.valueOf(com.exacttarget.etpushsdk.util.d.g())
        })).append("\n").append(String.format("Location: %1$s", new Object[] {
            Boolean.valueOf(com.exacttarget.etpushsdk.util.d.h())
        })).append("\n").append(String.format("CloudPages: %1$s", new Object[] {
            Boolean.valueOf(com.exacttarget.etpushsdk.util.d.j())
        })).append("\n");
        return c(stringbuilder.toString());
    }

    public static int c(String s, String s1)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 5)
        {
            s = a(s);
            s1 = c(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[0]);
            i = Log.w(s, s1);
        }
        return i;
    }

    public static int c(String s, String s1, Throwable throwable)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 6)
        {
            s = a(s);
            s1 = b(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[] {
                throwable
            });
            i = Log.e(s, s1, throwable);
        }
        return i;
    }

    private static String c(String s)
    {
        com/exacttarget/etpushsdk/util/m;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        com/exacttarget/etpushsdk/util/m;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (a == null && ETPush.a() != null)
        {
            String s1 = ETPush.a().getPackageName();
            a = ETPush.a().getApplicationInfo().className.replace((new StringBuilder()).append(s1).append(".").toString(), "");
        }
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        String s2 = s;
_L3:
        String s3;
        String s4;
        String s5;
        s5 = com.exacttarget.etpushsdk.util.d.b();
        s4 = com.exacttarget.etpushsdk.util.d.c();
        s3 = com.exacttarget.etpushsdk.util.d.d();
        s = s2;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        s = s2;
        if (s2.contains(s5))
        {
            s = s2.replace(s5, "{et_app_id}");
        }
        s2 = s;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        s2 = s;
        if (s.contains(s4))
        {
            s2 = s.replace(s4, "{access_token}");
        }
        s = s2;
        if (s3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = s2;
        if (s2.contains(s3))
        {
            s = s2.replace(s3, "{gcm_sender_id}");
        }
        continue; /* Loop/switch isn't completed */
        s2 = String.format("%1$s : %2$s", new Object[] {
            a, s
        });
          goto _L3
        s;
        throw s;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static int d(String s, String s1)
    {
        int i = 0;
        if (ETPush.getLogLevel() <= 6)
        {
            s = a(s);
            s1 = b(s1);
            ETLogger.getInstance().captureLog(s, s1, new Object[0]);
            i = Log.e(s, s1);
        }
        return i;
    }

    public static int e(String s, String s1)
    {
label0:
        {
            int i = 0;
            if (ETPush.getLogLevel() <= 7)
            {
                s = a(s);
                s1 = b(s1);
                ETLogger.getInstance().captureLog(s, s1, new Object[0]);
                if (android.os.Build.VERSION.SDK_INT < 8)
                {
                    break label0;
                }
                i = Log.wtf(s, s1);
            }
            return i;
        }
        return Log.e(s, s1);
    }

}
