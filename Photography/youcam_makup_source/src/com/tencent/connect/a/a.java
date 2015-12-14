// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.b.m;
import com.tencent.open.utils.g;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class a
{

    private static Class a = null;
    private static Class b = null;
    private static Method c = null;
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static boolean g = false;

    public static transient void a(Context context, m m1, String s, String as[])
    {
        if (!g)
        {
            return;
        }
        b(context, m1);
        try
        {
            d.invoke(b, new Object[] {
                context, s, as
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static boolean a(Context context, m m1)
    {
        return com.tencent.open.utils.g.a(context, m1.b()).b("Common_ta_enable");
    }

    public static void b(Context context, m m1)
    {
        if (a(context, m1))
        {
            f.invoke(a, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        }
        try
        {
            f.invoke(a, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
    }

    public static void c(Context context, m m1)
    {
        String s = m1.b();
        s = (new StringBuilder()).append("Aqc").append(s).toString();
        try
        {
            a = Class.forName("com.tencent.stat.StatConfig");
            b = Class.forName("com.tencent.stat.StatService");
            c = b.getMethod("reportQQ", new Class[] {
                android/content/Context, java/lang/String
            });
            d = b.getMethod("trackCustomEvent", new Class[] {
                android/content/Context, java/lang/String, [Ljava/lang/String;
            });
            e = b.getMethod("commitEvents", new Class[] {
                android/content/Context, Integer.TYPE
            });
            f = a.getMethod("setEnableStatService", new Class[] {
                Boolean.TYPE
            });
            b(context, m1);
            a.getMethod("setAutoExceptionCaught", new Class[] {
                Boolean.TYPE
            }).invoke(a, new Object[] {
                Boolean.valueOf(false)
            });
            a.getMethod("setEnableSmartReporting", new Class[] {
                Boolean.TYPE
            }).invoke(a, new Object[] {
                Boolean.valueOf(true)
            });
            a.getMethod("setSendPeriodMinutes", new Class[] {
                Integer.TYPE
            }).invoke(a, new Object[] {
                Integer.valueOf(1440)
            });
            m1 = Class.forName("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", new Class[] {
                m1
            }).invoke(a, new Object[] {
                m1.getField("PERIOD").get(null)
            });
            b.getMethod("startStatService", new Class[] {
                android/content/Context, java/lang/String, java/lang/String
            }).invoke(b, new Object[] {
                context, s, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null)
            });
            g = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void d(Context context, m m1)
    {
        if (g)
        {
            b(context, m1);
            if (m1.d() != null)
            {
                try
                {
                    c.invoke(b, new Object[] {
                        context, m1.d()
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                }
                return;
            }
        }
    }

}
