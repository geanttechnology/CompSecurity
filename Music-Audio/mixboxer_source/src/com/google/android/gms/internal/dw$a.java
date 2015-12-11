// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.internal:
//            dw, dx

final class pl extends Handler
{

    final dw pl;

    public void handleMessage(Message message)
    {
        if (message.what == 1 && !pl.isConnecting())
        {
            message = (Connecting)message.obj;
            message.aL();
            message.unregister();
            return;
        }
        synchronized (dw.b(pl))
        {
            pl.pi = false;
        }
        if (message.what == 3)
        {
            dw.a(pl).a(new ConnectionResult(((Integer)message.obj).intValue(), null));
            return;
        }
        break MISSING_BLOCK_LABEL_97;
        message;
        obj;
        JVM INSTR monitorexit ;
        throw message;
        if (message.what == 4)
        {
            dw.a(pl).J(((Integer)message.obj).intValue());
            return;
        }
        if (message.what == 2 && !pl.isConnected())
        {
            message = (Connected)message.obj;
            message.aL();
            message.unregister();
            return;
        }
        if (message.what == 2 || message.what == 1)
        {
            ((unregister)message.obj).bR();
            return;
        } else
        {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
            return;
        }
    }

    public ionResult(dw dw1, Looper looper)
    {
        pl = dw1;
        super(looper);
    }
}
