// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.tagmanager:
//            bh

abstract class ca
    implements PendingResult
{
    public static class a extends Handler
    {

        public void a(ResultCallback resultcallback, Result result)
        {
            sendMessage(obtainMessage(1, new Pair(resultcallback, result)));
        }

        public void a(ca ca1, long l)
        {
            sendMessageDelayed(obtainMessage(2, ca1), l);
        }

        protected void b(ResultCallback resultcallback, Result result)
        {
            resultcallback.onResult(result);
        }

        public void dw()
        {
            removeMessages(2);
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                bh.t("Don't know how to handle this message.");
                return;

            case 1: // '\001'
                message = (Pair)message.obj;
                b((ResultCallback)((Pair) (message)).first, (Result)((Pair) (message)).second);
                return;

            case 2: // '\002'
                message = (ca)message.obj;
                break;
            }
            message.a(message.d(Status.zS));
        }

        public a()
        {
            this(Looper.getMainLooper());
        }

        public a(Looper looper)
        {
            super(looper);
        }
    }


    private a VK;
    private final Object zd = new Object();
    private final CountDownLatch zf = new CountDownLatch(1);
    private final ArrayList zg = new ArrayList();
    private ResultCallback zh;
    private volatile Result zi;
    private volatile boolean zj;

    public ca(Looper looper)
    {
        VK = new a(looper);
    }

    private Result ds()
    {
        Object obj = zd;
        obj;
        JVM INSTR monitorenter ;
        Result result;
        Exception exception;
        boolean flag;
        if (!zj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.a(flag, "Result has already been consumed.");
        er.a(isReady(), "Result is not ready.");
        result = zi;
        dt();
        obj;
        JVM INSTR monitorexit ;
        return result;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(Result result)
    {
label0:
        {
            synchronized (zd)
            {
                if (!isReady())
                {
                    break label0;
                }
            }
            return;
        }
        boolean flag;
        if (!zj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.a(flag, "Result has already been consumed");
        zi = result;
        zf.countDown();
        result = zi.getStatus();
        if (zh != null)
        {
            VK.dw();
            VK.a(zh, ds());
        }
        for (Iterator iterator = zg.iterator(); iterator.hasNext(); ((com.google.android.gms.common.api.PendingResult.a)iterator.next()).k(result)) { }
        break MISSING_BLOCK_LABEL_131;
        result;
        obj;
        JVM INSTR monitorexit ;
        throw result;
        zg.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public Result await()
    {
        boolean flag;
        if (!zj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.a(flag, "Results has already been consumed");
        try
        {
            zf.await();
        }
        catch (InterruptedException interruptedexception)
        {
            a(d(Status.zR));
        }
        er.a(isReady(), "Result is not ready.");
        return ds();
    }

    public Result await(long l, TimeUnit timeunit)
    {
        boolean flag;
        if (!zj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.a(flag, "Result has already been consumed.");
        try
        {
            if (!zf.await(l, timeunit))
            {
                a(d(Status.zS));
            }
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            a(d(Status.zR));
        }
        er.a(isReady(), "Result is not ready.");
        return ds();
    }

    protected abstract Result d(Status status);

    void dt()
    {
        zj = true;
        zi = null;
    }

    public boolean isReady()
    {
        return zf.getCount() == 0L;
    }

    public final void setResultCallback(ResultCallback resultcallback)
    {
        Object obj;
        boolean flag;
        if (!zj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.a(flag, "Result has already been consumed.");
        obj = zd;
        obj;
        JVM INSTR monitorenter ;
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        VK.a(resultcallback, ds());
_L2:
        return;
        zh = resultcallback;
        if (true) goto _L2; else goto _L1
_L1:
        resultcallback;
        obj;
        JVM INSTR monitorexit ;
        throw resultcallback;
    }

    public final void setResultCallback(ResultCallback resultcallback, long l, TimeUnit timeunit)
    {
        Object obj;
        boolean flag;
        if (!zj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.a(flag, "Result has already been consumed.");
        obj = zd;
        obj;
        JVM INSTR monitorenter ;
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        VK.a(resultcallback, ds());
_L2:
        return;
        zh = resultcallback;
        VK.a(this, timeunit.toMillis(l));
        if (true) goto _L2; else goto _L1
_L1:
        resultcallback;
        obj;
        JVM INSTR monitorexit ;
        throw resultcallback;
    }
}
