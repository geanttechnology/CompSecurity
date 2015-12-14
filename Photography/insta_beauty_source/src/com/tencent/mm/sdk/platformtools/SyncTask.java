// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log, Util

public abstract class SyncTask
{

    private final long ba;
    private long bb;
    private long bc;
    private Runnable bd;
    private Object lock;
    private Object result;

    public SyncTask()
    {
        this(0L, null);
    }

    public SyncTask(long l, Object obj)
    {
        lock = new Object();
        bd = new _cls1();
        ba = l;
        result = obj;
    }

    static long a(SyncTask synctask)
    {
        return synctask.bb;
    }

    static long a(SyncTask synctask, long l)
    {
        synctask.bc = l;
        return l;
    }

    public Object exec(Handler handler)
    {
        if (handler == null)
        {
            Log.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        if (Thread.currentThread().getId() == handler.getLooper().getThread().getId())
        {
            Log.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        bb = Util.currentTicks();
        handler.post(bd);
        synchronized (lock)
        {
            lock.wait(ba);
        }
_L2:
        long l = Util.ticksToNow(bb);
        Log.v("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new Object[] {
            (new StringBuilder()).append(result).toString(), Long.valueOf(l), Long.valueOf(bc), Long.valueOf(l - bc)
        });
        return result;
        exception;
        handler;
        JVM INSTR monitorexit ;
        throw exception;
        handler;
        handler.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected abstract Object run();

    public void setResult(Object obj)
    {
        result = obj;
        synchronized (lock)
        {
            lock.notify();
        }
    }

    private class _cls1
        implements Runnable
    {

        final SyncTask be;

        public void run()
        {
            SyncTask.a(be, Util.ticksToNow(SyncTask.a(be)));
            be.setResult(be.run());
        }

        _cls1()
        {
            be = SyncTask.this;
            super();
        }
    }

}
