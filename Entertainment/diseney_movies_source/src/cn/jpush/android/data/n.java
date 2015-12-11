// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ai;

// Referenced classes of package cn.jpush.android.data:
//            l, o, p, d

final class n extends Thread
{

    private static final String z[];
    final Context a;
    final int b;
    final l c;
    final l d;

    n(l l1, Context context, int i, l l2)
    {
        d = l1;
        a = context;
        b = i;
        c = l2;
        super();
    }

    public final void run()
    {
        if (p.a(d.ad.b))
        {
            d.ad.l = cn.jpush.android.data.d.a(d.ad.b, d.c, z[0], a);
        }
        if (p.a(d.ad.h))
        {
            d.ad.m = cn.jpush.android.data.d.a(d.ad.h, d.c, z[1], a);
        }
        if (ai.a(d.ad.l) || ai.a(d.ad.m))
        {
            ServiceInterface.a(d.c, 1014, a);
            return;
        } else
        {
            ServiceInterface.a(d.c, b, a);
            l.a(d, c, a);
            return;
        }
    }

    static 
    {
        Object obj1;
        String as2[];
        int k;
        int i1;
        as2 = new String[2];
        obj1 = "QS\020\\yNY";
        k = -1;
        i1 = 0;
_L10:
        Object obj;
        String as[];
        int i;
        int j;
        int j1;
        int k1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        j = obj1.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        i = 0;
        as = ((String []) (obj));
        j1 = i1;
        obj = obj1;
        k1 = k;
_L9:
        i1 = i;
        k = i;
_L7:
        int l1;
        obj1 = obj;
        l1 = obj1[k];
        i1 % 5;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 236
    //                   1 243
    //                   2 250
    //                   3 257;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 38;
_L11:
label0:
        {
            obj1[k] = (char)(i ^ l1);
            i1++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        k = j;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        j = k;
        i = i1;
        if (k > i1) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "QS\020\\yN]";
            i1 = 1;
            k = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 39;
          goto _L11
_L3:
        i = 58;
          goto _L11
_L4:
        i = 117;
          goto _L11
_L5:
        i = 43;
          goto _L11
        boolean flag = false;
        l1 = k;
        i2 = i1;
        as1 = ((String []) (obj));
        k = j;
        i1 = ((flag) ? 1 : 0);
          goto _L12
    }
}
