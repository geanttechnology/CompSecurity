// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.fabric.sdk.android.services.concurrency.AsyncTask;

public class bus extends Handler
{

    public bus()
    {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message)
    {
        bur bur1 = (bur)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.c(bur1.a, bur1.b[0]);
            return;

        case 2: // '\002'
            bur1.a.b(bur1.b);
            break;
        }
    }
}
