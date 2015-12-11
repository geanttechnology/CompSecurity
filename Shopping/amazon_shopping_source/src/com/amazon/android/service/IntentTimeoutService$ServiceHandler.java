// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.android.service:
//            IntentTimeoutService

final class this._cls0 extends Handler
{

    final IntentTimeoutService this$0;

    public void handleMessage(Message message)
    {
label0:
        {
            IntentTimeoutService.access$000(IntentTimeoutService.this, (Intent)message.obj);
            synchronized (IntentTimeoutService.access$100(IntentTimeoutService.this))
            {
                if (!IntentTimeoutService.access$200(IntentTimeoutService.this))
                {
                    break label0;
                }
            }
            return;
        }
        IntentTimeoutService.access$300(IntentTimeoutService.this).set(message.arg1);
        if (IntentTimeoutService.access$400(IntentTimeoutService.this) != null)
        {
            IntentTimeoutService.access$400(IntentTimeoutService.this).ncel();
            IntentTimeoutService.access$100(IntentTimeoutService.this).purge();
            IntentTimeoutService.access$400(IntentTimeoutService.this).StopSelf();
        }
        IntentTimeoutService.access$402(IntentTimeoutService.this, new nit>(IntentTimeoutService.this, message.arg1));
        IntentTimeoutService.access$100(IntentTimeoutService.this).schedule(IntentTimeoutService.access$400(IntentTimeoutService.this), IntentTimeoutService.access$500(IntentTimeoutService.this));
        timer;
        JVM INSTR monitorexit ;
        return;
        message;
        timer;
        JVM INSTR monitorexit ;
        throw message;
    }

    public (Looper looper)
    {
        this$0 = IntentTimeoutService.this;
        super(looper);
    }
}
