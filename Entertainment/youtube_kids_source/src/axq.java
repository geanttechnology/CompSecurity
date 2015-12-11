// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;

final class axq extends Handler
{

    private axp a;

    public axq(axp axp1, Looper looper)
    {
        a = axp1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 1)
        {
            synchronized (a.b)
            {
                if (a.a.i_() && a.a.c() && a.b.contains(message.obj))
                {
                    android.os.Bundle bundle = a.a.h_();
                    ((awk)message.obj).a(bundle);
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
