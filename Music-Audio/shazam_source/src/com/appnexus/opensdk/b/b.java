// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.content.Context;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.appnexus.opensdk.b:
//            c

public final class b
{

    public static boolean a = false;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    private static WeakReference l = new WeakReference(null);
    private static String m = "";
    private static String n = "";
    private static final ArrayList o = new ArrayList();

    public static String a(int i1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1);
        }
    }

    public static String a(int i1, int j1, int k1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Integer.valueOf(j1), Integer.valueOf(k1)
            });
        }
    }

    public static String a(int i1, int j1, int k1, int l1, int i2)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(i2)
            });
        }
    }

    public static String a(int i1, int j1, int k1, int l1, int i2, String s, boolean flag)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(i2), s, Boolean.valueOf(flag)
            });
        }
    }

    public static String a(int i1, int j1, String s)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Integer.valueOf(j1), s
            });
        }
    }

    public static String a(int i1, int j1, String s, String s1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Integer.valueOf(j1), s, s1
            });
        }
    }

    public static String a(int i1, long l1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Long.valueOf(l1)
            });
        }
    }

    public static String a(int i1, String s)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                s
            });
        }
    }

    public static String a(int i1, String s, int j1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                s, Integer.valueOf(j1)
            });
        }
    }

    public static String a(int i1, String s, int j1, String s1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                s, Integer.valueOf(j1), s1
            });
        }
    }

    public static String a(int i1, String s, String s1)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                s, s1
            });
        }
    }

    public static String a(int i1, boolean flag)
    {
        Context context = (Context)l.get();
        if (context == null)
        {
            return null;
        } else
        {
            return context.getString(i1, new Object[] {
                Boolean.valueOf(flag)
            });
        }
    }

    public static void a()
    {
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorenter ;
        n = "";
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void a(Context context)
    {
        l = new WeakReference(context);
    }

    private static void a(c.a a1)
    {
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorenter ;
        b(a1);
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    public static void a(String s)
    {
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorenter ;
        m = s;
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void a(String s, String s1)
    {
        if (s1 != null)
        {
            a(c.a.a);
            a(s, s1, 2, ((Throwable) (null)));
        }
    }

    private static void a(String s, String s1, int i1, Throwable throwable)
    {
        if (!Log.isLoggable(s, i1) && !Log.isLoggable(b, i1)) goto _L2; else goto _L1
_L1:
        if (throwable == null) goto _L4; else goto _L3
_L3:
        i1;
        JVM INSTR tableswitch 2 6: default 56
    //                   2 56
    //                   3 56
    //                   4 56
    //                   5 56
    //                   6 57;
           goto _L2 _L2 _L2 _L2 _L2 _L5
_L2:
        return;
_L5:
        Log.e(s, s1, throwable);
        return;
_L4:
        switch (i1)
        {
        default:
            return;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            continue; /* Loop/switch isn't completed */

        case 6: // '\006'
            Log.e(s, s1);
            break;
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        b(c.a.d);
        a(s, s1, 5, throwable);
    }

    private static void b(c.a a1)
    {
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorenter ;
        c c1;
        for (Iterator iterator = o.iterator(); iterator.hasNext(); c1.a().ordinal())
        {
            c1 = (c)iterator.next();
            a1.ordinal();
        }

        break MISSING_BLOCK_LABEL_51;
        a1;
        throw a1;
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorexit ;
    }

    public static void b(String s)
    {
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorenter ;
        n = s;
        com/appnexus/opensdk/b/b;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void b(String s, String s1)
    {
        if (s1 != null)
        {
            a(c.a.b);
            a(s, s1, 3, ((Throwable) (null)));
        }
    }

    public static void b(String s, String s1, Throwable throwable)
    {
        if (s1 != null)
        {
            b(c.a.e);
            a(s, s1, 6, throwable);
        }
    }

    public static void c(String s, String s1)
    {
        if (s1 != null)
        {
            a(c.a.c);
            a(s, s1, 4, ((Throwable) (null)));
        }
    }

    public static void d(String s, String s1)
    {
        if (s1 != null)
        {
            a(c.a.d);
            a(s, s1, 5, ((Throwable) (null)));
        }
    }

    public static void e(String s, String s1)
    {
        if (s1 != null)
        {
            a(c.a.e);
            a(s, s1, 6, ((Throwable) (null)));
        }
    }

    static 
    {
        b = "OPENSDK";
        c = (new StringBuilder()).append(b).append("-MEDIATION").toString();
        d = (new StringBuilder()).append(b).append("-INTERFACE").toString();
        e = (new StringBuilder()).append(b).append("-REQUEST").toString();
        f = (new StringBuilder()).append(b).append("-RESPONSE").toString();
        g = (new StringBuilder()).append(b).append("-XML").toString();
        h = (new StringBuilder()).append(b).append("-JS").toString();
        i = (new StringBuilder()).append(b).append("-MRAID").toString();
        j = (new StringBuilder()).append(b).append("-APPBROWSER").toString();
        k = (new StringBuilder()).append(b).append("-NATIVE").toString();
    }
}
