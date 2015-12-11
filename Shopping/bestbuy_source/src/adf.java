// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;

final class adf extends Handler
{

    final ade a;

    public adf(ade ade1, Looper looper)
    {
        a = ade1;
        super(looper);
    }

    public void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            synchronized (ade.a(a))
            {
                if (ade.b(a).d_() && ade.b(a).c() && ade.a(a).contains(message.obj))
                {
                    android.os.Bundle bundle = ade.b(a).c_();
                    ((qo)message.obj).onConnected(bundle);
                }
            }
            return;
        } else
        {
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
            return;
        }
        message;
        arraylist;
        JVM INSTR monitorexit ;
        throw message;
    }
}
