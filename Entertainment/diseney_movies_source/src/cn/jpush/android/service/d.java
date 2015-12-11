// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.app.NotificationManager;
import android.os.Handler;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.data.y;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package cn.jpush.android.service:
//            c, DownloadService, a, ServiceInterface

final class d
    implements c
{

    private static final String z[];
    final boolean a;
    final int b;
    final DownloadService c;

    d(DownloadService downloadservice, boolean flag, int i)
    {
        c = downloadservice;
        a = flag;
        b = i;
        super();
    }

    public final void a(int i)
    {
        DownloadService.c(c).cancel(b);
        if (cn.jpush.android.service.a.a(i))
        {
            cn.jpush.android.service.DownloadService.a(c).L = true;
            cn.jpush.android.service.ServiceInterface.a(cn.jpush.android.service.DownloadService.a(c).c, 1011, c);
            String s;
            try
            {
                s = ((l)cn.jpush.android.service.DownloadService.a(c)).ac;
            }
            catch (Exception exception)
            {
                exception = "";
            }
            cn.jpush.android.service.ServiceInterface.a(cn.jpush.android.service.DownloadService.a(c).c, 1022, cn.jpush.android.util.a.b(c, s), c);
        }
        cn.jpush.android.service.DownloadService.a(c).M = true;
        cn.jpush.android.service.DownloadService.a(c, b, cn.jpush.android.service.DownloadService.a(c), i);
    }

    public final void a(long l1, long l2)
    {
        int i = (int)(((float)l1 / (float)l2) * 100F);
        (new StringBuilder(z[0])).append(i).append(z[1]).append(l1).append(z[2]).append(l2).toString();
        x.c();
        if (!a)
        {
            cn.jpush.android.service.DownloadService.a(c, cn.jpush.android.service.DownloadService.a(c), b, l1, l2);
        }
    }

    public final void a(String s, boolean flag)
    {
        char c2;
        cn.jpush.android.service.DownloadService.a(c).N = true;
        cn.jpush.android.service.DownloadService.a.remove(cn.jpush.android.service.DownloadService.a(c));
        c2 = '\u03E9';
        if (!cn.jpush.android.service.DownloadService.a(c).a()) goto _L2; else goto _L1
_L1:
        char c1;
        l l1 = (l)cn.jpush.android.service.DownloadService.a(c);
        l1.ah = s;
        l1.ai = false;
        c1 = c2;
        if (p.a(l1.Y, l1.Z, c))
        {
            c1 = '\u03EB';
            l1.ai = true;
        }
_L4:
        if (flag)
        {
            c1 = '\u03F5';
        }
        cn.jpush.android.service.ServiceInterface.a(cn.jpush.android.service.DownloadService.a(c).c, c1, c);
        if (!cn.jpush.android.service.DownloadService.a(c).f())
        {
            DownloadService.b(c).sendEmptyMessageDelayed(b, 500L);
        }
        cn.jpush.android.service.DownloadService.a(c).M = true;
        cn.jpush.android.service.DownloadService.a(c, cn.jpush.android.service.DownloadService.a(c));
        return;
_L2:
        if (cn.jpush.android.service.DownloadService.a(c).b())
        {
            ((y)cn.jpush.android.service.DownloadService.a(c)).aa = s;
            c1 = '\u03EC';
        } else
        {
            c1 = c2;
            if (cn.jpush.android.service.DownloadService.a(c).f())
            {
                cn.jpush.android.service.DownloadService.a(c).U = s;
                c1 = c2;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "\032`\rK\001\036?";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int i1;
        int j1;
        int k1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_280;
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
    //                   2 266
    //                   3 273;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 111;
_L11:
label0:
        {
            obj1[i1] = (char)(i ^ l1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            i1 = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        i = k;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        k = i;
        i1 = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "F%\nA\030\004i\001O\013\017aT";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            j = 2;
            obj1 = "F%\032A\033\013iT";
            i = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 106;
          goto _L11
_L3:
        i = 5;
          goto _L11
_L4:
        i = 110;
          goto _L11
_L5:
        i = 46;
          goto _L11
        boolean flag = false;
        l1 = i;
        i2 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
