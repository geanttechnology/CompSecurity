// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;


// Referenced classes of package cn.jpush.android.util:
//            f

public final class ab extends f
{

    private static final String z;

    public static String a(String s)
    {
        return b((new StringBuilder(z)).append(s).toString(), "");
    }

    public static void c(String s, String s1)
    {
        a((new StringBuilder(z)).append(s).toString(), s1);
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "\036!{{\"+\"o~/+2{{>\033<Qj?\035=jm8".toCharArray();
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
        i = 74;
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
        i = 116;
          goto _L10
_L5:
        i = 81;
          goto _L10
_L6:
        i = 14;
          goto _L10
        i = 8;
          goto _L10
    }
}
