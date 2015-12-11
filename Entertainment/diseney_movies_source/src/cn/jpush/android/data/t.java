// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.api.m;
import cn.jpush.android.api.q;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.k;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.data:
//            s, p, d

final class t extends Thread
{

    private static final String z[];
    final Context a;
    final s b;
    final s c;

    t(s s1, Context context, s s2)
    {
        c = s1;
        a = context;
        b = s2;
        super();
    }

    public final void run()
    {
        String s2;
        String s3;
        if (c.W == 1)
        {
            ServiceInterface.a(c.c, 995, a);
            m.a(a, c);
        } else
        {
            if (c.W != 2)
            {
                continue;
            }
            x.c();
            q.a(a, b);
        }
_L2:
        s3 = b.c;
        s2 = b.a;
        if (c.X)
        {
            break; /* Loop/switch isn't completed */
        }
        ServiceInterface.a(s3, 995, a);
        m.a(a, b);
_L3:
        do
        {
            return;
        } while (c.S.equals("0") || c.S.length() > 1);
        if (c.W != 0)
        {
            (new StringBuilder(z[0])).append(c.W).toString();
            x.c();
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        String s1;
        int i;
        if (!cn.jpush.android.data.p.a(s2))
        {
            ServiceInterface.a(s3, 996, a);
            return;
        }
        s1 = null;
        i = 0;
        do
        {
            if (i >= 4)
            {
                break MISSING_BLOCK_LABEL_507;
            }
            s1 = n.a(s2, 5, 5000L);
            if (!n.a(s1))
            {
                i = 1;
                break MISSING_BLOCK_LABEL_234;
            }
            i++;
        } while (true);
_L4:
        if (i == 0)
        {
            x.c();
            ServiceInterface.a(s3, 1014, a);
            ServiceInterface.a(s3, 1021, cn.jpush.android.util.a.b(a, s2), a);
            return;
        }
        s2 = s2.substring(0, s2.lastIndexOf("/") + 1);
        boolean flag = cn.jpush.android.data.d.a(b.Y, a, s2, s3, b.f());
        if (c.q && !flag)
        {
            x.c();
            ServiceInterface.a(s3, 1014, a);
            return;
        }
        if (b.f())
        {
            s2 = (new StringBuilder()).append(k.b(a, s3)).append(s3).append(z[1]).toString();
        } else
        {
            s2 = (new StringBuilder()).append(k.a(a, s3)).append(s3).toString();
        }
        if (cn.jpush.android.util.m.a(s2, s1, a))
        {
            b.ab = (new StringBuilder(z[2])).append(s2).toString();
            ServiceInterface.a(s3, 995, a);
            if (c.W == 0)
            {
                m.a(a, b);
                return;
            }
        } else
        {
            ServiceInterface.a(s3, 1014, a);
            return;
        }
          goto _L3
        i = 0;
          goto _L4
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "0;'1Z\00066,N_u7'A\013:5'\n\026=->\nE8--OExb";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int l;
        int i1;
        int j1;
        int k1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        l = obj1.length;
        if (l > 1)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        i1 = 0;
        as = ((String []) (obj));
        j1 = j;
        obj = obj1;
        k1 = i;
_L9:
        j = i1;
_L7:
        int l1;
        obj1 = obj;
        l1 = obj1[i1];
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
        i = 42;
_L11:
label0:
        {
            obj1[i1] = (char)(i ^ l1);
            j++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        i = l;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        l = i;
        i1 = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "K=6$F";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            j = 2;
            obj1 = "\003<.,\020Jz";
            i = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 101;
          goto _L11
_L3:
        i = 85;
          goto _L11
_L4:
        i = 66;
          goto _L11
_L5:
        i = 73;
          goto _L11
        boolean flag = false;
        l1 = i;
        i2 = j;
        as1 = ((String []) (obj));
        i = l;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
