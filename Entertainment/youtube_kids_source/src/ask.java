// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;

final class ask extends Handler
    implements Runnable
{

    final asl a;
    volatile Thread b;
    private final asj c;
    private asi d;

    public ask(asi asi1, Looper looper, asl asl1, asj asj1)
    {
        d = asi1;
        super(looper);
        a = asl1;
        c = asj1;
    }

    public final void handleMessage(Message message)
    {
        d.c = false;
        d.b = null;
        if (a.e())
        {
            message = c;
            asl asl1 = a;
            message.f();
            return;
        }
        asj asj1;
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = c;
            asl asl2 = a;
            message.e();
            return;

        case 1: // '\001'
            asj1 = c;
            break;
        }
        asl asl3 = a;
        asj1.a((IOException)message.obj);
    }

    public final void run()
    {
        try
        {
            b = Thread.currentThread();
            if (!a.e())
            {
                a.f();
            }
            sendEmptyMessage(0);
            return;
        }
        catch (IOException ioexception)
        {
            obtainMessage(1, ioexception).sendToTarget();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            a.b(a.e());
            sendEmptyMessage(0);
            return;
        }
        catch (Exception exception)
        {
            Log.e("LoadTask", "Unexpected error loading stream", exception);
            obtainMessage(1, new arv(exception)).sendToTarget();
            return;
        }
    }
}
