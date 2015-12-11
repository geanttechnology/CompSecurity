// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;

class id.os.Looper extends Handler
{

    final sg a;

    public void handleMessage(Message message)
    {
        message = (Intent)message.obj;
        a.b.add(message);
    }

    >(sg sg1, Looper looper)
    {
        a = sg1;
        super(looper);
    }
}
