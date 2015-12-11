// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.service;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.b;
import cn.jpush.android.api.d;
import cn.jpush.android.util.x;

// Referenced classes of package cn.jpush.android.service:
//            PushService, n, ServiceInterface

final class m extends Handler
{

    private static final String z[];
    final PushService a;

    m(PushService pushservice)
    {
        a = pushservice;
        super();
    }

    public final void handleMessage(Message message)
    {
        int i;
        i = 0;
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 1001 1008: default 56
    //                   1001 83
    //                   1002 122
    //                   1003 114
    //                   1004 153
    //                   1005 162
    //                   1006 256
    //                   1007 171
    //                   1008 182;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        (new StringBuilder(z[0])).append(message.what).toString();
        x.b();
_L11:
        return;
_L2:
        x.c();
        PushService.c(a);
        a.stopSelf();
        a.a(0, z[3]);
        return;
_L4:
        a.stopSelf();
        return;
_L3:
        if (cn.jpush.android.service.PushService.d(a) != null && cn.jpush.android.service.PushService.d(a).isAlive())
        {
            PushService.e(a);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        cn.jpush.android.service.PushService.b(a, true);
        return;
_L6:
        cn.jpush.android.service.PushService.b(a, false);
        return;
_L8:
        x.f();
        PushService.f(a);
        return;
_L9:
        try
        {
            i = ((Integer)message.obj).intValue();
        }
        catch (Exception exception)
        {
            i = 0;
        }
        if (PushService.c(a, i))
        {
            (new StringBuilder(z[2])).append(i).append(z[1]).append(message.what).toString();
            x.f();
            PushService.f(a);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        int j = ((Integer)message.obj).intValue();
        i = j;
_L12:
        if (i != 0)
        {
            message = ServiceInterface.a(i);
            if (message != null)
            {
                TagAliasCallback tagaliascallback = ((b) (message)).c;
                if (tagaliascallback != null)
                {
                    tagaliascallback.gotResult(d.b, ((b) (message)).a, ((b) (message)).b);
                }
            }
            cn.jpush.android.service.ServiceInterface.b(i);
            return;
        }
        if (true) goto _L11; else goto _L10
_L10:
        message;
          goto _L12
    }

    static 
    {
        Object obj;
        String as2[];
        int i;
        int j;
        as2 = new String[4];
        obj = "u4\000\020\035E9\021\r\t\032z\020\006\005A4\001\004\bDz\b\033\n\000wE";
        i = -1;
        j = 0;
_L10:
        String as[];
        int k;
        int l;
        int i1;
        int j1;
        as = as2;
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        l = 0;
        i1 = j;
        j1 = i;
_L9:
        j = l;
_L7:
        char ac[];
        int k1;
        ac = ((char []) (obj));
        k1 = ac[l];
        j % 5;
        JVM INSTR tableswitch 0 3: default 92
    //                   0 270
    //                   1 277
    //                   2 284
    //                   3 291;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 109;
_L11:
label0:
        {
            ac[l] = (char)(i ^ k1);
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
        ac = ((char []) (obj));
        k1 = j1;
_L12:
        j1 = k1;
        obj = ac;
        i1 = l1;
        as = as1;
        k = i;
        l = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(ac)).intern();
        switch (k1)
        {
        default:
            as1[l1] = ((String) (obj));
            obj = "W2\004\034M\035z";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[l1] = ((String) (obj));
            obj = "t;\002)\001I;\026H\fC1E\016\fI6\000\fC\000)\000\031$DzXH";
            j = 2;
            i = 1;
            break;

        case 1: // '\001'
            as1[l1] = ((String) (obj));
            j = 3;
            obj = "C4K\002\035U)\rF\fN>\027\007\004Dt\f\006\031E4\021F.o\024+-.t\023*&";
            i = 2;
            break;

        case 2: // '\002'
            as1[l1] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 32;
          goto _L11
_L3:
        i = 90;
          goto _L11
_L4:
        i = 101;
          goto _L11
_L5:
        i = 104;
          goto _L11
        boolean flag = false;
        k1 = i;
        ac = ((char []) (obj));
        l1 = j;
        as1 = as;
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
