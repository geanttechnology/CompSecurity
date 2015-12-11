// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import com.exacttarget.etpushsdk.ETPush;
import java.util.HashMap;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            a, f, e, m, 
//            n, g

public class d
{

    private static String a;
    private static String b;
    private static String c;
    private static String d = null;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static Boolean i = null;
    private static HashMap j = new HashMap();
    private static boolean k;

    public static transient Object a(Context context, String s, Object obj, Object aobj[])
    {
        Object obj1 = null;
        SharedPreferences sharedpreferences1 = context.getSharedPreferences("ETPush", 0);
        SharedPreferences sharedpreferences = obj1;
        if (aobj.length > 0)
        {
            sharedpreferences = (SharedPreferences)aobj[0];
            if (!sharedpreferences.contains(s))
            {
                sharedpreferences = obj1;
            }
        }
        if (sharedpreferences != null)
        {
            if (obj instanceof Boolean)
            {
                context = Boolean.valueOf(sharedpreferences.getBoolean(s, ((Boolean)obj).booleanValue()));
            } else
            if (obj instanceof Float)
            {
                context = Float.valueOf(sharedpreferences.getFloat(s, ((Float)obj).floatValue()));
            } else
            if (obj instanceof Integer)
            {
                context = Integer.valueOf(sharedpreferences.getInt(s, ((Integer)obj).intValue()));
            } else
            if (obj instanceof Long)
            {
                context = Long.valueOf(sharedpreferences.getLong(s, ((Long)obj).longValue()));
            } else
            {
                context = sharedpreferences.getString(s, (String)obj);
            }
            sharedpreferences.edit().remove(s).commit();
            return context;
        }
        if (j.containsKey(s) || sharedpreferences1.contains(d(s)))
        {
            if (j.containsKey(s))
            {
                context = (String)j.get(s);
            } else
            {
                context = com.exacttarget.etpushsdk.util.a.b(context, d(s), String.valueOf(obj));
                j.put(s, context);
            }
            if (obj instanceof Boolean)
            {
                return Boolean.valueOf(context);
            }
            if (obj instanceof Float)
            {
                return Float.valueOf(context);
            }
            if (obj instanceof Integer)
            {
                return Integer.valueOf(context);
            }
            if (obj instanceof Long)
            {
                return Long.valueOf(context);
            } else
            {
                return String.valueOf(context);
            }
        }
        if (sharedpreferences1.contains(s))
        {
            if (obj instanceof Boolean)
            {
                aobj = Boolean.valueOf(sharedpreferences1.getBoolean(s, ((Boolean)obj).booleanValue()));
            } else
            if (obj instanceof Float)
            {
                aobj = Float.valueOf(sharedpreferences1.getFloat(s, ((Float)obj).floatValue()));
            } else
            if (obj instanceof Integer)
            {
                aobj = Integer.valueOf(sharedpreferences1.getInt(s, ((Integer)obj).intValue()));
            } else
            if (obj instanceof Long)
            {
                aobj = Long.valueOf(sharedpreferences1.getLong(s, ((Long)obj).longValue()));
            } else
            {
                aobj = sharedpreferences1.getString(s, (String)obj);
            }
        } else
        {
            return obj;
        }
        sharedpreferences1.edit().remove(s).commit();
        if (obj instanceof Boolean)
        {
            a(context, s, (Boolean)aobj);
        } else
        if (obj instanceof Float)
        {
            a(context, s, (Float)obj);
        } else
        if (obj instanceof Integer)
        {
            a(context, s, (Integer)obj);
        } else
        if (obj instanceof Long)
        {
            a(context, s, (Long)obj);
        } else
        {
            a(context, s, (String)obj);
        }
        sharedpreferences1.edit().commit();
        return ((Object) (aobj));
    }

    public static void a()
    {
        e();
    }

    public static void a(Context context, String s)
    {
        (new Thread(new f(s, context))).start();
    }

    public static void a(Context context, String s, Boolean boolean1)
    {
        a(context, s, String.valueOf(boolean1));
    }

    public static void a(Context context, String s, Float float1)
    {
        a(context, s, String.valueOf(float1));
    }

    public static void a(Context context, String s, Integer integer)
    {
        a(context, s, String.valueOf(integer));
    }

    public static void a(Context context, String s, Long long1)
    {
        a(context, s, String.valueOf(long1));
    }

    public static void a(Context context, String s, String s1)
    {
        j.put(s, s1);
        (new Thread(new e(context, s, s1))).start();
    }

    public static void a(String s)
    {
        a = s;
    }

    public static void a(boolean flag)
    {
        e = flag;
    }

    public static boolean a(Context context)
    {
        if (i == null)
        {
            try
            {
                i = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("etpush_readonly", false));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                m.c("~!ud", context.getMessage(), context);
                return false;
            }
        }
        return i.booleanValue();
    }

    public static String b()
    {
        return a;
    }

    public static void b(String s)
    {
        b = s;
    }

    public static void b(boolean flag)
    {
        f = flag;
    }

    public static String c()
    {
        return b;
    }

    public static void c(String s)
    {
        c = s;
    }

    public static void c(boolean flag)
    {
        g = flag;
    }

    public static String d()
    {
        return c;
    }

    public static String d(String s)
    {
        return (new StringBuilder()).append(s).append("_enc").toString();
    }

    public static void d(boolean flag)
    {
        k = flag;
    }

    protected static String e()
    {
        com/exacttarget/etpushsdk/util/d;
        JVM INSTR monitorenter ;
        String s;
        if (d == null)
        {
            d = Base64.encodeToString(n.b((new StringBuilder()).append(b()).append("--").append(n.b(c())).append("__").append(n.b(com.exacttarget.etpushsdk.util.g.uniqueDeviceIdentifier(ETPush.a()))).toString()).getBytes(), 2);
        }
        s = d;
        com/exacttarget/etpushsdk/util/d;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static void e(boolean flag)
    {
        h = flag;
    }

    public static boolean f()
    {
        return e;
    }

    public static boolean g()
    {
        return f;
    }

    public static boolean h()
    {
        return g;
    }

    public static boolean i()
    {
        return k;
    }

    public static boolean j()
    {
        return h;
    }

    static HashMap k()
    {
        return j;
    }

}
