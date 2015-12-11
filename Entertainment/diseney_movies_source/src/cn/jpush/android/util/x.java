// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.util.Log;
import cn.jpush.android.service.PushService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class x
{

    private static final SimpleDateFormat a;
    private static ArrayList b;
    private static boolean c;
    private static boolean d;
    private static final String z[];

    public static void a(String s, String s1)
    {
        if (PushService.b && a(2))
        {
            Log.v(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString());
        }
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        if (PushService.b && a(5))
        {
            Log.w(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString(), throwable);
        }
    }

    public static boolean a()
    {
        return false;
    }

    private static boolean a(int k)
    {
        return k >= PushService.d;
    }

    public static void b()
    {
    }

    public static void b(String s, String s1)
    {
        if (PushService.b && a(3))
        {
            Log.d(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString());
        }
    }

    public static void b(String s, String s1, Throwable throwable)
    {
        if (PushService.b && a(6))
        {
            Log.e(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString(), throwable);
        }
    }

    public static void c()
    {
    }

    public static void c(String s, String s1)
    {
        if (PushService.b && a(4))
        {
            Log.i(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString());
        }
    }

    public static void d()
    {
    }

    public static void d(String s, String s1)
    {
        if (PushService.b && a(5))
        {
            Log.w(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString());
        }
    }

    public static void e()
    {
    }

    public static void e(String s, String s1)
    {
        if (PushService.b && a(6))
        {
            Log.e(z[1], (new StringBuilder("[")).append(s).append(z[0]).append(s1).toString());
        }
    }

    public static void f()
    {
    }

    public static void g()
    {
    }

    public static void h()
    {
    }

    public static void i()
    {
    }

    public static void j()
    {
    }

    static 
    {
        Object obj1;
        String as2[];
        int k;
        int l;
        as2 = new String[3];
        obj1 = "gr";
        k = -1;
        l = 0;
_L10:
        Object obj;
        String as[];
        int i1;
        int j1;
        int k1;
        int l1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        i1 = obj1.length;
        if (i1 > 1)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        j1 = 0;
        as = ((String []) (obj));
        k1 = l;
        obj = obj1;
        l1 = k;
_L9:
        l = j1;
_L7:
        int i2;
        obj1 = obj;
        i2 = obj1[j1];
        l % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 286
    //                   1 293
    //                   2 300
    //                   3 307;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        k = 97;
_L11:
label0:
        {
            obj1[j1] = (char)(k ^ i2);
            l++;
            if (i1 != 0)
            {
                break label0;
            }
            j1 = i1;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int j2;
        k = i1;
        as1 = as;
        j2 = k1;
        obj1 = obj;
        i2 = l1;
_L12:
        l1 = i2;
        obj = obj1;
        k1 = j2;
        as = as1;
        i1 = k;
        j1 = l;
        if (k > l) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (i2)
        {
        default:
            as1[j2] = ((String) (obj));
            obj1 = "p\002jo\t";
            l = 1;
            k = 0;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            obj1 = "w\0371x\005e\032W&\fWhlo>i\001L";
            l = 2;
            k = 1;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            z = as2;
            a = new SimpleDateFormat(z[2]);
            b = new ArrayList();
            c = false;
            d = false;
            return;
        }
          goto _L10
_L6:
        k = 58;
          goto _L11
_L3:
        k = 82;
          goto _L11
_L4:
        k = 31;
          goto _L11
_L5:
        k = 28;
          goto _L11
        boolean flag = false;
        i2 = k;
        j2 = l;
        as1 = ((String []) (obj));
        k = i1;
        l = ((flag) ? 1 : 0);
          goto _L12
    }
}
