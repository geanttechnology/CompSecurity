// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, Result, Releasable, Status, 
//            ResultCallback

public abstract class AbstractPendingResult
    implements PendingResult
{

    protected final CallbackHandler mHandler;
    private boolean zzL;
    private final Object zzWb;
    private final ArrayList zzWc;
    private ResultCallback zzWd;
    private volatile Result zzWe;
    private volatile boolean zzWf;
    private boolean zzWg;
    private ICancelToken zzWh;
    private final CountDownLatch zzoD;

    public AbstractPendingResult(Looper looper)
    {
        zzWb = new Object();
        zzoD = new CountDownLatch(1);
        zzWc = new ArrayList();
        mHandler = new CallbackHandler(looper);
    }

    protected AbstractPendingResult(CallbackHandler callbackhandler)
    {
        zzWb = new Object();
        zzoD = new CountDownLatch(1);
        zzWc = new ArrayList();
        mHandler = (CallbackHandler)zzu.zzb(callbackhandler, "CallbackHandler must not be null");
    }

    private void zza(Result result)
    {
        zzWe = result;
        zzWh = null;
        zzoD.countDown();
        result = zzWe.getStatus();
        if (zzWd != null)
        {
            mHandler.removeTimeoutMessages();
            if (!zzL)
            {
                mHandler.sendResultCallback(zzWd, zzmo());
            }
        }
        for (Iterator iterator = zzWc.iterator(); iterator.hasNext(); ((PendingResult.BatchCallback)iterator.next()).zzs(result)) { }
        zzWc.clear();
    }

    static void zzb(Result result)
    {
        if (!(result instanceof Releasable))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ((Releasable)result).release();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("AbstractPendingResult", (new StringBuilder()).append("Unable to release ").append(result).toString(), runtimeexception);
        return;
    }

    private Result zzmo()
    {
        boolean flag = true;
        Object obj = zzWb;
        obj;
        JVM INSTR monitorenter ;
        Result result;
        if (zzWf)
        {
            flag = false;
        }
        zzu.zza(flag, "Result has already been consumed.");
        zzu.zza(isReady(), "Result is not ready.");
        result = zzWe;
        zzWe = null;
        zzWd = null;
        zzWf = true;
        onResultConsumed();
        return result;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void addBatchCallback(PendingResult.BatchCallback batchcallback)
    {
        Object obj;
        boolean flag;
        if (!zzWf)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "Result has already been consumed.");
        obj = zzWb;
        obj;
        JVM INSTR monitorenter ;
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        batchcallback.zzs(zzWe.getStatus());
_L2:
        return;
        zzWc.add(batchcallback);
        if (true) goto _L2; else goto _L1
_L1:
        batchcallback;
        obj;
        JVM INSTR monitorexit ;
        throw batchcallback;
    }

    public final Result await()
    {
        boolean flag1 = true;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "await must not be called on the UI thread");
        if (!zzWf)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "Result has already been consumed");
        try
        {
            zzoD.await();
        }
        catch (InterruptedException interruptedexception)
        {
            forceFailureUnlessReady(Status.zzXQ);
        }
        zzu.zza(isReady(), "Result is not ready.");
        return zzmo();
    }

    public final Result await(long l, TimeUnit timeunit)
    {
        boolean flag1 = true;
        boolean flag;
        if (l <= 0L || Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "await must not be called on the UI thread when time is greater than zero.");
        if (!zzWf)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "Result has already been consumed.");
        try
        {
            if (!zzoD.await(l, timeunit))
            {
                forceFailureUnlessReady(Status.zzXS);
            }
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            forceFailureUnlessReady(Status.zzXQ);
        }
        zzu.zza(isReady(), "Result is not ready.");
        return zzmo();
    }

    public void cancel()
    {
label0:
        {
            synchronized (zzWb)
            {
                if (!zzL && !zzWf)
                {
                    break label0;
                }
            }
            return;
        }
        ICancelToken icanceltoken = zzWh;
        if (icanceltoken == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        try
        {
            zzWh.cancel();
        }
        catch (RemoteException remoteexception) { }
        zzb(zzWe);
        zzWd = null;
        zzL = true;
        zza(createFailedResult(Status.zzXT));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract Result createFailedResult(Status status);

    public final void forceFailureUnlessReady(Status status)
    {
        synchronized (zzWb)
        {
            if (!isReady())
            {
                setResult(createFailedResult(status));
                zzWg = true;
            }
        }
        return;
        status;
        obj;
        JVM INSTR monitorexit ;
        throw status;
    }

    public boolean isCanceled()
    {
        boolean flag;
        synchronized (zzWb)
        {
            flag = zzL;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean isReady()
    {
        return zzoD.getCount() == 0L;
    }

    protected void onResultConsumed()
    {
    }

    protected final void setCancelToken(ICancelToken icanceltoken)
    {
        synchronized (zzWb)
        {
            zzWh = icanceltoken;
        }
        return;
        icanceltoken;
        obj;
        JVM INSTR monitorexit ;
        throw icanceltoken;
    }

    public final void setResult(Result result)
    {
        boolean flag1;
label0:
        {
            flag1 = true;
            synchronized (zzWb)
            {
                if (!zzWg && !zzL)
                {
                    break label0;
                }
                zzb(result);
            }
            return;
        }
        boolean flag;
        if (!isReady())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "Results have already been set");
        if (!zzWf)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzu.zza(flag, "Result has already been consumed");
        zza(result);
        obj;
        JVM INSTR monitorexit ;
        return;
        result;
        obj;
        JVM INSTR monitorexit ;
        throw result;
    }

    public final void setResultCallback(ResultCallback resultcallback)
    {
label0:
        {
            boolean flag;
            if (!zzWf)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzu.zza(flag, "Result has already been consumed.");
            synchronized (zzWb)
            {
                if (!isCanceled())
                {
                    break label0;
                }
            }
            return;
        }
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        mHandler.sendResultCallback(resultcallback, zzmo());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        resultcallback;
        obj;
        JVM INSTR monitorexit ;
        throw resultcallback;
        zzWd = resultcallback;
          goto _L1
    }

    public final void setResultCallback(ResultCallback resultcallback, long l, TimeUnit timeunit)
    {
label0:
        {
            boolean flag;
            if (!zzWf)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzu.zza(flag, "Result has already been consumed.");
            synchronized (zzWb)
            {
                if (!isCanceled())
                {
                    break label0;
                }
            }
            return;
        }
        if (!isReady())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        mHandler.sendResultCallback(resultcallback, zzmo());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        resultcallback;
        obj;
        JVM INSTR monitorexit ;
        throw resultcallback;
        zzWd = resultcallback;
        mHandler.sendTimeoutResultCallback(this, timeunit.toMillis(l));
          goto _L1
    }

    private class CallbackHandler extends Handler
    {

        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        protected void deliverResultCallback(ResultCallback resultcallback, Result result)
        {
            try
            {
                resultcallback.onResult(result);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ResultCallback resultcallback)
            {
                AbstractPendingResult.zzb(result);
            }
            throw resultcallback;
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                return;

            case 1: // '\001'
                message = (Pair)message.obj;
                deliverResultCallback((ResultCallback)((Pair) (message)).first, (Result)((Pair) (message)).second);
                return;

            case 2: // '\002'
                ((AbstractPendingResult)message.obj).forceFailureUnlessReady(Status.zzXS);
                break;
            }
        }

        public void removeTimeoutMessages()
        {
            removeMessages(2);
        }

        public void sendResultCallback(ResultCallback resultcallback, Result result)
        {
            sendMessage(obtainMessage(1, new Pair(resultcallback, result)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult abstractpendingresult, long l)
        {
            sendMessageDelayed(obtainMessage(2, abstractpendingresult), l);
        }

        public CallbackHandler()
        {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper)
        {
            super(looper);
        }
    }

}
