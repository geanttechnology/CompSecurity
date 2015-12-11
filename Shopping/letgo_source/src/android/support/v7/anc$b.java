// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            anc

private static class Looper extends Handler
{

    public void handleMessage(Message message)
    {
        Looper looper = (Looper)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            anc.c(looper.a, looper.b[0]);
            return;

        case 2: // '\002'
            looper.a.b(looper.b);
            break;
        }
    }

    public ()
    {
        super(Looper.getMainLooper());
    }
}
