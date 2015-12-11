// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package jumiomobile:
//            ba

class bb extends Handler
{

    final ba a;

    bb(ba ba1, Looper looper)
    {
        a = ba1;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 1: // '\001'
            ba.a(a);
            break;
        }
    }
}
