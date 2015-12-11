// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

// Referenced classes of package com.uplynk.media:
//            CaptionManager

protected class _channel extends Handler
{

    private sendEmptyMessageDelayed _channel;
    final CaptionManager this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 1 && access._mth0(_channel)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        message = _channel;
        message;
        JVM INSTR monitorenter ;
        m m;
        m m1;
        if (_channel.queue.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        m = (m)_channel.queue.removeFirst();
        m1 = ((CaptionManager)access._mth1(_channel).get()).getEventHandler();
        if (m1 == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        m1.sendMessage(m1.obtainMessage(2, access._mth2(_channel), 0, m));
        message;
        JVM INSTR monitorexit ;
        if (!access._mth0(_channel)) goto _L1; else goto _L3
_L3:
        sendEmptyMessageDelayed(1, 30L);
        return;
        Exception exception;
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public m(m m, Looper looper)
    {
        this$0 = CaptionManager.this;
        super(looper);
        _channel = m;
    }
}
