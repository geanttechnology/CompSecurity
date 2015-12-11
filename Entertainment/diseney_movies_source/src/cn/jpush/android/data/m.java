// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.k;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.data:
//            l, o, p, d

final class m extends Thread
{

    private static final String z[];
    final l a;
    final Context b;
    final int c;
    final l d;

    m(l l1, l l2, Context context, int i)
    {
        d = l1;
        a = l2;
        b = context;
        c = i;
        super();
    }

    public final void run()
    {
        String s;
        String s1;
        String s2;
        int i;
        s1 = a.ad.j;
        s2 = a.c;
        if (!cn.jpush.android.data.p.a(s1))
        {
            ServiceInterface.a(a.c, 996, b);
            return;
        }
        if (!a.ad.i)
        {
            ServiceInterface.a(s2, c, b);
            cn.jpush.android.data.l.a(d, a, b);
            return;
        }
        s = null;
        i = 0;
        do
        {
            if (i >= 4)
            {
                break MISSING_BLOCK_LABEL_375;
            }
            s = n.a(s1, 5, 5000L);
            if (!n.a(s))
            {
                i = 1;
                break MISSING_BLOCK_LABEL_115;
            }
            i++;
        } while (true);
_L2:
        if (i == 0)
        {
            ServiceInterface.a(s2, 1014, b);
            ServiceInterface.a(s2, 1021, cn.jpush.android.util.a.b(b, s1), b);
            x.c();
            return;
        }
        s1 = s1.substring(0, s1.lastIndexOf("/") + 1);
        if (!cn.jpush.android.data.d.a(a.ad.k, b, s1, s2, a.f()))
        {
            x.c();
            ServiceInterface.a(s2, 1014, b);
            return;
        }
        if (a.f())
        {
            s1 = (new StringBuilder()).append(k.b(b, s2)).append(s2).append(z[1]).toString();
        } else
        {
            s1 = (new StringBuilder()).append(k.a(b, s2)).append(s2).toString();
        }
        if (cn.jpush.android.util.m.a(s1, s, b))
        {
            a.ad.n = (new StringBuilder(z[0])).append(s1).toString();
            ServiceInterface.a(s2, c, b);
            cn.jpush.android.data.l.a(d, a, b);
            return;
        } else
        {
            ServiceInterface.a(s2, 1014, b);
            return;
        }
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        Object obj1;
        String as2[];
        int i1;
        int j1;
        as2 = new String[2];
        obj1 = "'M[\rsn\013";
        i1 = -1;
        j1 = 0;
_L10:
        Object obj;
        String as[];
        int i;
        int j;
        int k1;
        int l1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        j = obj1.length;
        if (j > 1)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        i = 0;
        as = ((String []) (obj));
        k1 = j1;
        obj = obj1;
        l1 = i1;
_L9:
        j1 = i;
        i1 = i;
_L7:
        int i2;
        obj1 = obj;
        i2 = obj1[i1];
        j1 % 5;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 236
    //                   1 243
    //                   2 250
    //                   3 257;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 73;
_L11:
label0:
        {
            obj1[i1] = (char)(i ^ i2);
            j1++;
            if (j != 0)
            {
                break label0;
            }
            i1 = j;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int j2;
        i1 = j;
        as1 = as;
        j2 = k1;
        obj1 = obj;
        i2 = l1;
_L12:
        l1 = i2;
        obj = obj1;
        k1 = j2;
        as = as1;
        j = i1;
        i = j1;
        if (i1 > j1) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (i2)
        {
        default:
            as1[j2] = ((String) (obj));
            obj1 = "oLC\005%";
            j1 = 1;
            i1 = 0;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 65;
          goto _L11
_L3:
        i = 36;
          goto _L11
_L4:
        i = 55;
          goto _L11
_L5:
        i = 104;
          goto _L11
        boolean flag = false;
        i2 = i1;
        j2 = j1;
        as1 = ((String []) (obj));
        i1 = j;
        j1 = ((flag) ? 1 : 0);
          goto _L12
    }
}
