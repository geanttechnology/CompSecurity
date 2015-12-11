// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.views:
//            OverScrollView

class timer
{
    class MyTask extends TimerTask
    {

        private Handler handler;
        final OverScrollView.MyTimer this$1;

        public void run()
        {
            handler.obtainMessage().sendToTarget();
        }

        public MyTask(Handler handler1)
        {
            this$1 = OverScrollView.MyTimer.this;
            super();
            handler = handler1;
        }
    }


    private Handler handler;
    private MyTask mTask;
    final OverScrollView this$0;
    private Timer timer;

    public void cancel()
    {
        if (mTask != null)
        {
            mTask.cancel();
            mTask = null;
        }
    }

    public void schedule(long l)
    {
        if (mTask != null)
        {
            mTask.cancel();
            mTask = null;
        }
        mTask = new MyTask(handler);
        timer.schedule(mTask, 0L, l);
    }

    public MyTask.handler(Handler handler1)
    {
        this$0 = OverScrollView.this;
        super();
        handler = handler1;
        timer = new Timer();
    }
}
