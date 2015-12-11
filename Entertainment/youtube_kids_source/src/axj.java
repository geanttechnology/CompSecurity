// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class axj extends Handler
{

    private axi a;

    public axj(axi axi1, Looper looper)
    {
        a = axi1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 1 && !a.g())
        {
            ((axk)message.obj).b();
            return;
        }
        if (message.what == 3)
        {
            axi.a(a).a(new avq(((Integer)message.obj).intValue(), null));
            return;
        }
        if (message.what == 4)
        {
            axi.a(a, 1);
            axi.a(a, null);
            axi.a(a).a(((Integer)message.obj).intValue());
            return;
        }
        if (message.what == 2 && !a.c())
        {
            ((axk)message.obj).b();
            return;
        }
        if (message.what == 2 || message.what == 1)
        {
            ((axk)message.obj).a();
            return;
        } else
        {
            Log.wtf("GmsClient", "Don't know how to handle this message.");
            return;
        }
    }
}
