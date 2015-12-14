// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MTimerHandler extends Handler
{

    private static int av;
    private final boolean aG;
    private long aH;
    private final CallBack aI;
    private final int aw;

    public MTimerHandler(Looper looper, CallBack callback, boolean flag)
    {
        super(looper);
        aH = 0L;
        aI = callback;
        aw = d();
        aG = flag;
    }

    public MTimerHandler(CallBack callback, boolean flag)
    {
        aH = 0L;
        aI = callback;
        aw = d();
        aG = flag;
    }

    private static int d()
    {
        if (av >= 8192)
        {
            av = 0;
        }
        int i = av + 1;
        av = i;
        return i;
    }

    protected void finalize()
    {
        stopTimer();
        super.finalize();
    }

    public void handleMessage(Message message)
    {
        while (message.what != aw || aI == null || !aI.onTimerExpired() || !aG) 
        {
            return;
        }
        sendEmptyMessageDelayed(aw, aH);
    }

    public void startTimer(long l)
    {
        aH = l;
        stopTimer();
        sendEmptyMessageDelayed(aw, l);
    }

    public void stopTimer()
    {
        removeMessages(aw);
    }

    public boolean stopped()
    {
        return !hasMessages(aw);
    }

    private class CallBack
    {

        public abstract boolean onTimerExpired();
    }

}
