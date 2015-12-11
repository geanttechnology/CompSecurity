// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.a.b:
//            ad, p, a, n, 
//            d, h, an

final class o extends Handler
{

    private final n a;

    public o(Looper looper, n n1)
    {
        super(looper);
        a = n1;
    }

    public final void handleMessage(Message message)
    {
        boolean flag = true;
        message.what;
        JVM INSTR tableswitch 1 10: default 60
    //                   1 77
    //                   2 185
    //                   3 60
    //                   4 293
    //                   5 350
    //                   6 414
    //                   7 431
    //                   8 60
    //                   9 476
    //                   10 692;
           goto _L1 _L2 _L3 _L1 _L4 _L5 _L6 _L7 _L1 _L8 _L9
_L1:
        ad.a.post(new p(this, message));
_L11:
        return;
_L2:
        Object obj;
        message = (a)message.obj;
        obj = a;
        d d1 = (d)((n) (obj)).e.get(((a) (message)).h);
        if (d1 != null)
        {
            d1.a(message);
            return;
        }
        if (((n) (obj)).c.isShutdown()) goto _L11; else goto _L10
_L10:
        d d2 = d.a(((n) (obj)).b, ((a) (message)).a, ((n) (obj)), ((n) (obj)).h, ((n) (obj)).i, message, ((n) (obj)).d);
        d2.k = ((n) (obj)).c.submit(d2);
        ((n) (obj)).e.put(((a) (message)).h, d2);
        return;
_L3:
        String s;
        d d3;
        message = (a)message.obj;
        obj = a;
        s = ((a) (message)).h;
        d3 = (d)((n) (obj)).e.get(s);
        if (d3 == null) goto _L11; else goto _L12
_L12:
        d3.h.remove(message);
        if (!d3.h.isEmpty() || d3.k == null || !d3.k.cancel(false))
        {
            flag = false;
        }
        if (!flag) goto _L11; else goto _L13
_L13:
        ((n) (obj)).e.remove(s);
        return;
_L4:
        message = (d)message.obj;
        obj = a;
        if (!((d) (message)).i)
        {
            ((n) (obj)).h.a(((d) (message)).f, ((d) (message)).j);
        }
        ((n) (obj)).e.remove(((d) (message)).f);
        ((n) (obj)).c(message);
        return;
_L5:
        message = (d)message.obj;
        obj = a;
        if (message.b()) goto _L11; else goto _L14
_L14:
        if (!((n) (obj)).c.isShutdown() && message.a(((n) (obj)).l))
        {
            message.k = ((n) (obj)).c.submit(message);
            return;
        } else
        {
            ((n) (obj)).b(message);
            return;
        }
_L6:
        message = (d)message.obj;
        a.b(message);
        return;
_L7:
        message = a;
        obj = new ArrayList(((n) (message)).j);
        ((n) (message)).j.clear();
        ((n) (message)).g.sendMessage(((n) (message)).g.obtainMessage(8, obj));
        return;
_L8:
        message = (NetworkInfo)message.obj;
        obj = a;
        obj.l = message;
        if (!(((n) (obj)).c instanceof an)) goto _L11; else goto _L15
_L15:
        obj = (an)((n) (obj)).c;
        if (message == null || !message.isConnectedOrConnecting())
        {
            ((an) (obj)).a(3);
            return;
        }
        switch (message.getType())
        {
        default:
            ((an) (obj)).a(3);
            return;

        case 1: // '\001'
        case 6: // '\006'
        case 9: // '\t'
            ((an) (obj)).a(4);
            return;

        case 0: // '\0'
            switch (message.getSubtype())
            {
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            default:
                ((an) (obj)).a(3);
                return;

            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
                ((an) (obj)).a(3);
                return;

            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 12: // '\f'
                ((an) (obj)).a(2);
                return;

            case 1: // '\001'
            case 2: // '\002'
                ((an) (obj)).a(1);
                return;
            }
        }
_L9:
        n n1 = a;
        boolean flag1;
        if (message.arg1 == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        n1.m = flag1;
        return;
    }
}
