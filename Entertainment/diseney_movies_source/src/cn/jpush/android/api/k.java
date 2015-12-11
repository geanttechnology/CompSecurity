// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.app.Application;
import java.util.HashMap;

// Referenced classes of package cn.jpush.android.api:
//            l

public final class k
{

    public static boolean a;
    private static boolean b;
    private static String c;
    private static HashMap d;
    private static String e;
    private static String f;
    private static String g;

    static String a(String s)
    {
        e = s;
        return s;
    }

    public static void a(Application application)
    {
        l l1 = new l();
        application.unregisterActivityLifecycleCallbacks(l1);
        application.registerActivityLifecycleCallbacks(l1);
    }

    static boolean a()
    {
        return b;
    }

    static boolean a(boolean flag)
    {
        b = false;
        return false;
    }

    static String b()
    {
        return f;
    }

    static String b(String s)
    {
        g = s;
        return s;
    }

    static String c(String s)
    {
        f = s;
        return s;
    }

    static HashMap c()
    {
        return d;
    }

    static String d()
    {
        return g;
    }

    static String e()
    {
        return c;
    }

    static String f()
    {
        return e;
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int i1;
        int j1;
        j1 = 0;
        i = 0;
        b = true;
        a = false;
        ac = "\u8BB2\u5738\u60CB\u6BBD\u4E32\004s\027\033n,d\032\u76F6w+B\006\001m(uK[\u5494*~3\023m6uK[\u769C6e\023\027jm9\u546D\u8C71\u7530\u76BD\u5163\u7EBC\u8BD3\u65A1\u6C90\uFF0A)\"m6x*\034l b\005\023{ >\f\034J c\026\037}m9C\u54FE8\017@\026\001p\f~\027\027j#q\000\0276*~3\023m6uK[".toCharArray();
        j = ac.length;
        ac1 = ac;
        i1 = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        j1 = i;
        i1 = i;
_L9:
        char c1;
        ac1 = ac;
        c1 = ac1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 80
    //                   0 108
    //                   1 114
    //                   2 120
    //                   3 126;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_126;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        i = 24;
_L10:
        ac1[i1] = (char)(i ^ c1);
        j1++;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        i1 = j;
        if (true) goto _L9; else goto _L8
_L8:
        i = 69;
          goto _L10
_L5:
        i = 16;
          goto _L10
_L6:
        i = 99;
          goto _L10
        i = 114;
          goto _L10
        i1 = j;
        ac1 = ac;
_L2:
        ac = ac1;
        j = i1;
        i = j1;
        if (i1 <= j1)
        {
            c = (new String(ac1)).intern();
            d = new HashMap();
            e = null;
            f = null;
            g = null;
        }
        if (true) goto _L1; else goto _L11
_L11:
    }
}
