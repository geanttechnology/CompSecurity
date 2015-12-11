// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package android.support.v4.view:
//            p

final class q extends Handler
{

    private p a;

    q(p p1)
    {
        a = p1;
        super();
    }

    q(p p1, Handler handler)
    {
        a = p1;
        super(handler.getLooper());
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 56
    //                   2 76
    //                   3 84;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new RuntimeException((new StringBuilder("Unknown message ")).append(message).toString());
_L2:
        p.b(a).onShowPress(p.a(a));
_L6:
        return;
_L3:
        p.c(a);
        return;
_L4:
        if (p.d(a) != null)
        {
            if (!p.e(a))
            {
                p.d(a).onSingleTapConfirmed(p.a(a));
                return;
            } else
            {
                p.a(a, true);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
