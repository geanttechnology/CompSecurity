// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.mobileapptracker:
//            f, MATResponse

final class b
{

    private static volatile b i;
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private MATResponse h;

    private b()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = 0;
        f = null;
        g = null;
        h = null;
    }

    public static void a()
    {
        i = new b();
    }

    public static void a(MATResponse matresponse)
    {
        i.h = matresponse;
    }

    public static void a(String s)
    {
        i.a = s;
    }

    public static void a(String s, int j)
    {
        i.d = s;
        i.e = j;
    }

    public static b b()
    {
        com/mobileapptracker/b;
        JVM INSTR monitorenter ;
        b b1 = i;
        com/mobileapptracker/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b(String s)
    {
        i.b = s;
    }

    public static String c()
    {
        return i.a;
    }

    public static void c(String s)
    {
        i.c = s;
    }

    public static String d()
    {
        return i.b;
    }

    public static void d(String s)
    {
        i.g = s;
    }

    public static String e()
    {
        return i.c;
    }

    public static void e(String s)
    {
        i.f = s;
    }

    public static String f()
    {
        return i.g;
    }

    public static String g()
    {
        return i.d;
    }

    public static int h()
    {
        return i.e;
    }

    public static String i()
    {
        return i.f;
    }

    public final String a(Context context, int j)
    {
        String s1;
        Object obj;
        s1 = "";
        obj = s1;
        if (i.a == null) goto _L2; else goto _L1
_L1:
        obj = s1;
        if (i.b == null) goto _L2; else goto _L3
_L3:
        if (i.c != null) goto _L5; else goto _L4
_L4:
        obj = s1;
_L2:
        return ((String) (obj));
_L5:
        if (i.d != null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s1;
        if (i.f == null) goto _L2; else goto _L6
_L6:
        String s = s1;
        try
        {
            obj = i;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return s;
        }
        s = s1;
        s1 = com.mobileapptracker.f.a(j);
        obj = s1;
        s = s1;
        if (s1.length() == 0) goto _L2; else goto _L7
_L7:
        s = s1;
        if (h == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        s = s1;
        h.didReceiveDeeplink(s1);
        s = s1;
        obj = new Intent("android.intent.action.VIEW");
        s = s1;
        ((Intent) (obj)).setData(Uri.parse(s1));
        s = s1;
        ((Intent) (obj)).setFlags(0x10000000);
        s = s1;
        context.startActivity(((Intent) (obj)));
        return s1;
    }
}
