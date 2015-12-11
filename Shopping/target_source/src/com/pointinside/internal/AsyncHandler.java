// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

public abstract class AsyncHandler
{
    private class ReceiverHandler extends Handler
    {

        final AsyncHandler this$0;

        public void handleMessage(Message message)
        {
            onWorkComplete(message.what, message.obj);
        }

        private ReceiverHandler()
        {
            this$0 = AsyncHandler.this;
            super();
        }

    }

    private static class WorkerArgs
    {

        public Object params;
        public Handler receiver;

        public WorkerArgs(Handler handler, Object obj)
        {
            receiver = handler;
            params = obj;
        }
    }

    protected class WorkerHandler extends Handler
    {

        final AsyncHandler this$0;

        public void handleMessage(Message message)
        {
            int i = message.what;
            Object obj = (WorkerArgs)message.obj;
            message = ((Message) (doInWorkerThread(i, ((WorkerArgs) (obj)).params)));
            obj = ((WorkerArgs) (obj)).receiver.obtainMessage();
            obj.what = i;
            obj.obj = message;
            ((Message) (obj)).sendToTarget();
        }

        public WorkerHandler(Looper looper)
        {
            this$0 = AsyncHandler.this;
            super(looper);
        }
    }


    private static final HashMap sLoopers = new HashMap();
    private final ReceiverHandler mReceiverHandler = new ReceiverHandler();
    private final WorkerHandler mWorkerThreadHandler;

    public AsyncHandler()
    {
        Looper looper = acquireLooper(getClass());
        mWorkerThreadHandler = createWorkerHandler(looper);
    }

    private Looper acquireLooper(Class class1)
    {
        com/pointinside/internal/AsyncHandler;
        JVM INSTR monitorenter ;
        Looper looper;
        String s;
        s = class1.getName();
        looper = (Looper)sLoopers.get(s);
        class1 = looper;
        if (looper != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        class1 = createWorkerThread();
        class1.start();
        class1 = class1.getLooper();
        sLoopers.put(s, class1);
        com/pointinside/internal/AsyncHandler;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        com/pointinside/internal/AsyncHandler;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public void cancelWork(int i)
    {
        mWorkerThreadHandler.removeMessages(i);
    }

    protected WorkerHandler createWorkerHandler(Looper looper)
    {
        return new WorkerHandler(looper);
    }

    protected abstract HandlerThread createWorkerThread();

    protected abstract Object doInWorkerThread(int i, Object obj);

    protected abstract void onWorkComplete(int i, Object obj);

    protected void sendWork(int i, Object obj)
    {
        Message message = mWorkerThreadHandler.obtainMessage();
        message.what = i;
        message.obj = new WorkerArgs(mReceiverHandler, obj);
        message.sendToTarget();
    }

}
