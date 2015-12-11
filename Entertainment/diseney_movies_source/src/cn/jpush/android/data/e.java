// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import cn.jpush.android.util.ai;

// Referenced classes of package cn.jpush.android.data:
//            d

public final class e
{

    private static final String z[];
    public String a;
    public String b;
    final d c;

    public e(d d1, d d2)
    {
        c = d1;
        super();
        a = d2.c;
        b = d2.d;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof e)
        {
            obj = (e)obj;
            if (!ai.a(a) && !ai.a(((e) (obj)).a) && ai.a(a, ((e) (obj)).a))
            {
                if (ai.a(b) && ai.a(((e) (obj)).b))
                {
                    return true;
                }
                if (!ai.a(b) && !ai.a(((e) (obj)).b) && ai.a(b, ((e) (obj)).b))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString()
    {
        return (new StringBuilder(z[1])).append(a).append(z[0]).append(b).toString();
    }

    static 
    {
        Object obj1;
        String as2[];
        int k;
        int l;
        as2 = new String[2];
        obj1 = "ql\026\034\0058>D\032\0278\023[\000\024\002%RSN}";
        k = -1;
        l = 0;
_L10:
        Object obj;
        String as[];
        int i;
        int j;
        int i1;
        int j1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        j = obj1.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        i = 0;
        as = ((String []) (obj));
        i1 = l;
        obj = obj1;
        j1 = k;
_L9:
        l = i;
        k = i;
_L7:
        int k1;
        obj1 = obj;
        k1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 236
    //                   1 243
    //                   2 250
    //                   3 257;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 115;
_L11:
label0:
        {
            obj1[k] = (char)(i ^ k1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int l1;
        k = j;
        as1 = as;
        l1 = i1;
        obj1 = obj;
        k1 = j1;
_L12:
        j1 = k1;
        obj = obj1;
        i1 = l1;
        as = as1;
        j = k;
        i = l;
        if (k > l) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj1 = "0?Q,\0329l\013S";
            l = 1;
            k = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 93;
          goto _L11
_L3:
        i = 76;
          goto _L11
_L4:
        i = 54;
          goto _L11
_L5:
        i = 115;
          goto _L11
        boolean flag = false;
        k1 = k;
        l1 = l;
        as1 = ((String []) (obj));
        k = j;
        l = ((flag) ? 1 : 0);
          goto _L12
    }
}
