// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;

public final class ah
{

    private static SharedPreferences a;
    private static final String z;

    public static long a(Context context, String s, long l)
    {
        a(context);
        return a.getLong(s, 0L);
    }

    private static SharedPreferences a(Context context)
    {
        if (a == null)
        {
            a = context.getSharedPreferences(z, 0);
        }
        return a;
    }

    public static void b(Context context, String s, long l)
    {
        context = a(context).edit();
        context.putLong(s, l);
        context.commit();
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "\024g\034n$\024g\024y>8p\022t+\016t".toCharArray();
        j = ac.length;
        l = 0;
        i = 0;
        ac1 = ac;
        k = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        l = i;
        k = i;
_L9:
        char c;
        ac1 = ac;
        c = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 139
    //                   1 145
    //                   2 151
    //                   3 157;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_157;
_L3:
        i = 77;
_L10:
label0:
        {
            ac1[k] = (char)(i ^ c);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        k = j;
        ac1 = ac;
_L2:
        ac = ac1;
        j = k;
        i = l;
        if (k <= l)
        {
            z = (new String(ac1)).intern();
            a = null;
            return;
        }
          goto _L1
_L8:
        i = 103;
          goto _L10
_L5:
        i = 19;
          goto _L10
_L6:
        i = 125;
          goto _L10
        i = 26;
          goto _L10
    }
}
