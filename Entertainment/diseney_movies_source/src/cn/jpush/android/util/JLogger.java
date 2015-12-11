// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.util.Log;
import cn.jpush.android.data.f;
import cn.jpush.android.service.PushService;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package cn.jpush.android.util:
//            r

public class JLogger
{

    private static final SimpleDateFormat a;
    private static r b;
    private static final String z;

    public JLogger()
    {
    }

    private static void a(int j, String s, String s1)
    {
        String s2 = "V";
        j;
        JVM INSTR lookupswitch 5: default 56
    //                   1: 72
    //                   2: 90
    //                   4: 108
    //                   8: 126
    //                   16: 144;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_144;
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        if (b != null && b.b && (b.a & j) != 0)
        {
            s = new f(j, s2, s, s1, a.format(new Date()));
            if (b != null)
            {
                b.a(s);
                return;
            }
        }
        return;
_L2:
        if (PushService.b)
        {
            Log.v(s, s1);
        }
        s2 = "V";
          goto _L7
_L3:
        if (PushService.b)
        {
            Log.d(s, s1);
        }
        s2 = "D";
          goto _L7
_L4:
        if (PushService.b)
        {
            Log.i(s, s1);
        }
        s2 = "I";
          goto _L7
_L5:
        if (PushService.b)
        {
            Log.w(s, s1);
        }
        s2 = "W";
          goto _L7
        if (PushService.b)
        {
            Log.e(s, s1);
        }
        s2 = "E";
          goto _L7
    }

    public static void d(String s, String s1)
    {
        a(2, s, s1);
    }

    public static void e(String s, String s1)
    {
        a(16, s, s1);
    }

    public static void i(String s, String s1)
    {
        a(4, s, s1);
    }

    public static void parseModalJson(String s, Context context)
    {
        while (context == null || b == null) 
        {
            return;
        }
        b.a(context, s);
    }

    public static void reportByHeartbeats()
    {
        if (b != null)
        {
            b.a();
        }
    }

    public static void v(String s, String s1)
    {
        a(1, s, s1);
    }

    public static void w(String s, String s1)
    {
        a(8, s, s1);
    }

    static 
    {
        char ac[];
        char ac1[];
        int j;
        int k;
        int l;
        int i1;
        ac = "\"\013j{r\026?>f;{:[826H`q".toCharArray();
        k = ac.length;
        i1 = 0;
        j = 0;
        ac1 = ac;
        l = k;
        if (k > 1) goto _L2; else goto _L1
_L1:
        i1 = j;
        l = j;
_L9:
        char c;
        ac1 = ac;
        c = ac1[l];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 158
    //                   1 164
    //                   2 170
    //                   3 176;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_176;
_L3:
        j = 95;
_L10:
label0:
        {
            ac1[l] = (char)(j ^ c);
            i1++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L9; else goto _L8
        l = k;
        ac1 = ac;
_L2:
        ac = ac1;
        k = l;
        j = i1;
        if (l <= i1)
        {
            z = (new String(ac1)).intern();
            a = new SimpleDateFormat(z);
            b = new r();
            return;
        }
          goto _L1
_L8:
        j = 91;
          goto _L10
_L5:
        j = 114;
          goto _L10
_L6:
        j = 19;
          goto _L10
        j = 2;
          goto _L10
    }
}
