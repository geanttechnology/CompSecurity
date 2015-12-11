// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;

public class af
{

    private static af c;
    private static final String z;
    private final String a;
    private SharedPreferences b;

    public af()
    {
        a = z;
        b = null;
    }

    private SharedPreferences a(Context context)
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        cn/jpush/android/util/af;
        JVM INSTR monitorenter ;
        b = context.getSharedPreferences(z, 0);
        cn/jpush/android/util/af;
        JVM INSTR monitorexit ;
_L2:
        return b;
        context;
        throw context;
    }

    public static af a()
    {
        if (c == null)
        {
            c = new af();
        }
        return c;
    }

    public final long a(Context context, String s, long l)
    {
        return a(context).getLong(s, l);
    }

    public final String a(Context context, String s, String s1)
    {
        return a(context).getString(s, null);
    }

    public final void b(Context context, String s, long l)
    {
        a(context).edit().putLong(s, l).commit();
    }

    public final void b(Context context, String s, String s1)
    {
        a(context).edit().putString(s, s1).commit();
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "+#\037*\177225\032x\017\025\003>".toCharArray();
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
        char c1;
        ac1 = ac;
        c1 = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 135
    //                   1 141
    //                   2 147
    //                   3 153;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_153;
_L3:
        i = 23;
_L10:
label0:
        {
            ac1[k] = (char)(i ^ c1);
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
            return;
        }
          goto _L1
_L8:
        i = 97;
          goto _L10
_L5:
        i = 115;
          goto _L10
_L6:
        i = 106;
          goto _L10
        i = 89;
          goto _L10
    }
}
