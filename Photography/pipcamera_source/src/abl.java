// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.fabric.sdk.android.services.concurrency.AsyncTask;

public class abl extends Handler
{

    public abl()
    {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message)
    {
        abk abk1 = (abk)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.c(abk1.a, abk1.b[0]);
            return;

        case 2: // '\002'
            abk1.a.b(abk1.b);
            break;
        }
    }
}
