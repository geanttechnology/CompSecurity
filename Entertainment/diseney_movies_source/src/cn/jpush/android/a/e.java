// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import cn.jpush.android.util.x;
import java.util.List;

// Referenced classes of package cn.jpush.android.a:
//            d, i, f

final class e extends BroadcastReceiver
{

    private static final String z[];
    final d a;

    private e(d d1)
    {
        a = d1;
        super();
    }

    e(d d1, byte byte0)
    {
        this(d1);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (d.i(a) && d.a(d.a(a))) goto _L2; else goto _L1
_L1:
        if (intent.getIntExtra(z[2], 4) != 3) goto _L4; else goto _L3
_L3:
        long l;
        boolean flag;
        flag = d.e(a).b().startScan();
        l = System.currentTimeMillis();
_L5:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            if (intent.getIntExtra(z[2], 4) != 3)
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            x.j();
            return;
        }
        context = d.e(a).b().getScanResults();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (context.size() != 0)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (System.currentTimeMillis() - l <= 10000L)
        {
            continue; /* Loop/switch isn't completed */
        }
        d.a(a, d.e(a).c());
        d.a(a).unregisterReceiver(d.j(a));
        if (!d.i(a))
        {
            a.d();
            return;
        }
        break; /* Loop/switch isn't completed */
        d.a(a, d.e(a).c());
        d.a(a).unregisterReceiver(d.j(a));
        if (!d.i(a))
        {
            a.d();
        }
        flag = false;
        if (true) goto _L5; else goto _L4
_L2:
        if (d.d(a) == 2)
        {
            context = intent.getAction();
            if (z[0].equals(context))
            {
                d.c(a).removeMessages(5);
                if (System.currentTimeMillis() - d.k(a) > 4000L)
                {
                    d.c(a).sendEmptyMessageDelayed(5, 4000L);
                    return;
                } else
                {
                    d.c(a).sendEmptyMessage(5);
                    return;
                }
            }
            if (d.l(a))
            {
                context = intent.getAction();
                if (z[1].equals(context) && intent.getIntExtra(z[2], 4) == 2)
                {
                    a.d = true;
                    d.a(a, false);
                    x.c();
                }
            }
        }
_L4:
    }

    static 
    {
        Object obj1;
        String as2[];
        int j;
        int k;
        as2 = new String[3];
        obj1 = "m`\036jxejTvrx \rqqe )[VBQ(]DYB.K";
        j = -1;
        k = 0;
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
        j1 = k;
        obj = obj1;
        k1 = j;
_L9:
        k = i1;
_L7:
        int l1;
        obj1 = obj;
        l1 = obj1[i1];
        k % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 260
    //                   2 267
    //                   3 274;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        j = 23;
_L11:
label0:
        {
            obj1[i1] = (char)(j ^ l1);
            k++;
            if (l != 0)
            {
                break label0;
            }
            i1 = l;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        j = l;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        l = j;
        i1 = k;
        if (j > k) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "m`\036jxejTvrx \rqqe -QQEQ)LVXK%[_M@=]S";
            k = 1;
            j = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            k = 2;
            obj1 = "{g\034qH\177z\033lr";
            j = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        j = 12;
          goto _L11
_L3:
        j = 14;
          goto _L11
_L4:
        j = 122;
          goto _L11
_L5:
        j = 24;
          goto _L11
        boolean flag = false;
        l1 = j;
        i2 = k;
        as1 = ((String []) (obj));
        j = l;
        k = ((flag) ? 1 : 0);
          goto _L12
    }
}
