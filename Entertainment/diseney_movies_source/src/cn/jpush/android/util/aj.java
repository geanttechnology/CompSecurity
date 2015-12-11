// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import cn.jpush.android.service.PushService;

// Referenced classes of package cn.jpush.android.util:
//            x

public final class aj
{

    private static final String z[];
    private String a;
    private String b;
    private boolean c;
    private long d;

    public aj(String s, String s1)
    {
        c = false;
        if (PushService.b)
        {
            a = s;
            b = s1;
            d = System.currentTimeMillis();
        }
    }

    public final void a()
    {
        if (PushService.b)
        {
            String s = a;
            (new StringBuilder(z[0])).append(b).append(z[1]).append(System.currentTimeMillis() - d).append(z[2]).toString();
            x.c();
            if (!c)
            {
                d = System.currentTimeMillis();
            }
        }
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "tl|FU0,4Fv852\016d+a7\tsyf";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        l = 0;
        as = ((String []) (obj));
        i1 = j;
        obj = obj1;
        j1 = i;
_L9:
        j = l;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 1;
_L11:
label0:
        {
            obj1[l] = (char)(i ^ k1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            l = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        i = k;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "~{q";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            j = 2;
            obj1 = "42";
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 89;
          goto _L11
_L3:
        i = 65;
          goto _L11
_L4:
        i = 81;
          goto _L11
_L5:
        i = 102;
          goto _L11
        boolean flag = false;
        k1 = i;
        l1 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
