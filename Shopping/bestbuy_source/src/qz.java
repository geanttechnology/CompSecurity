// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class qz extends Handler
{

    final qw a;

    qz(qw qw1, Looper looper)
    {
        a = qw1;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            Log.w("GoogleApiClientImpl", (new StringBuilder()).append("Unknown message id: ").append(message.what).toString());
            return;

        case 1: // '\001'
            qw.i(a);
            return;

        case 2: // '\002'
            qw.j(a);
            break;
        }
    }
}
