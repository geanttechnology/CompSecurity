// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class cfk extends Handler
{

    private final che a;

    cfk(Looper looper, che che1)
    {
        super(looper);
        a = che1;
    }

    private static void a(cfx cfx1, cgc cgc1)
    {
        if (cgc1 == null)
        {
            cfx1.a(3);
            return;
        } else
        {
            cfx1.a(cgc1);
            return;
        }
    }

    public final void a(cfl cfl1)
    {
        int i = cfl1.e;
        long al[] = cfl.a;
        cfl cfl2;
        if (i < 9)
        {
            cfl2 = new cfl(cfl1.e + 1, cfl1.c, cfl1.d);
        } else
        {
            cfl2 = cfl.b;
        }
        if (cfl2 == cfl.b)
        {
            a(cfl1.d, null);
            return;
        } else
        {
            sendMessageDelayed(Message.obtain(this, 1, cfl2), cfl.a[cfl2.e]);
            return;
        }
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        message = (cfl)message.obj;
        Object obj = ((cfl) (message)).c;
        cfx cfx1 = ((cfl) (message)).d;
        obj = (cgc)a.a(obj);
        boolean flag;
        if (obj != null)
        {
            cfi.b();
            Object obj1 = String.valueOf(((cgc) (obj)).c.toString());
            if (((String) (obj1)).length() != 0)
            {
                "Found screen with id: ".concat(((String) (obj1)));
            } else
            {
                new String("Found screen with id: ");
            }
            obj1 = cgn.b;
            a(cfx1, new cgc(((cgc) (obj)).c, ((cgc) (obj)).d, ((cgc) (obj)).e, ((cgc) (obj)).f, ((cgn) (obj1))));
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            a(message);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
