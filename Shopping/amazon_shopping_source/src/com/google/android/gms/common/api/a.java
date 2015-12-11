// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.common.api:
//            Releasable, Result, PendingResult, Status, 
//            ResultCallback

public class com.google.android.gms.common.api.a
{
    public static abstract class a
        implements PendingResult, d
    {

        private final Object Dp = new Object();
        private c Dq;
        private final ArrayList Dr = new ArrayList();
        private ResultCallback Ds;
        private volatile Result Dt;
        private volatile boolean Du;
        private boolean Dv;
        private boolean Dw;
        private hg Dx;
        private final CountDownLatch kK = new CountDownLatch(1);

        static void a(a a1)
        {
            a1.eF();
        }

        private void c(Result result)
        {
            Dt = result;
            Dx = null;
            kK.countDown();
            result = Dt.getStatus();
            if (Ds != null)
            {
                Dq.eH();
                if (!Dv)
                {
                    Dq.a(Ds, eC());
                }
            }
            for (Iterator iterator = Dr.iterator(); iterator.hasNext(); ((PendingResult.a)iterator.next()).n(result)) { }
            Dr.clear();
        }

        private Result eC()
        {
            Object obj = Dp;
            obj;
            JVM INSTR monitorenter ;
            Result result;
            Exception exception;
            boolean flag;
            if (!Du)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hm.a(flag, "Result has already been consumed.");
            hm.a(isReady(), "Result is not ready.");
            result = Dt;
            eD();
            obj;
            JVM INSTR monitorexit ;
            return result;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private void eE()
        {
            synchronized (Dp)
            {
                if (!isReady())
                {
                    b(c(Status.Eo));
                    Dw = true;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private void eF()
        {
            synchronized (Dp)
            {
                if (!isReady())
                {
                    b(c(Status.Eq));
                    Dw = true;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected void a(c c1)
        {
            Dq = c1;
        }

        public void a(Object obj)
        {
            b((Result)obj);
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
            hm.a(flag, "await must not be called on the UI thread");
            if (!Du)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            hm.a(flag, "Result has already been consumed");
            try
            {
                kK.await();
            }
            catch (InterruptedException interruptedexception)
            {
                eE();
            }
            hm.a(isReady(), "Result is not ready.");
            return eC();
        }

        public final void b(Result result)
        {
            boolean flag1;
label0:
            {
                flag1 = true;
                synchronized (Dp)
                {
                    if (!Dw && !Dv)
                    {
                        break label0;
                    }
                    com.google.android.gms.common.api.a.a(result);
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
            hm.a(flag, "Results have already been set");
            if (!Du)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            hm.a(flag, "Result has already been consumed");
            c(result);
            obj;
            JVM INSTR monitorexit ;
            return;
            result;
            obj;
            JVM INSTR monitorexit ;
            throw result;
        }

        protected abstract Result c(Status status);

        public void cancel()
        {
label0:
            {
                synchronized (Dp)
                {
                    if (!Dv && !Du)
                    {
                        break label0;
                    }
                }
                return;
            }
            hg hg1 = Dx;
            if (hg1 == null)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            try
            {
                Dx.cancel();
            }
            catch (RemoteException remoteexception) { }
            com.google.android.gms.common.api.a.a(Dt);
            Ds = null;
            Dv = true;
            c(c(Status.Er));
            obj;
            JVM INSTR monitorexit ;
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected void eD()
        {
            Du = true;
            Dt = null;
            Ds = null;
        }

        public boolean isCanceled()
        {
            boolean flag;
            synchronized (Dp)
            {
                flag = Dv;
            }
            return flag;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final boolean isReady()
        {
            return kK.getCount() == 0L;
        }

        public final void setResultCallback(ResultCallback resultcallback)
        {
label0:
            {
                boolean flag;
                if (!Du)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hm.a(flag, "Result has already been consumed.");
                synchronized (Dp)
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
            Dq.a(resultcallback, eC());
_L1:
            obj;
            JVM INSTR monitorexit ;
            return;
            resultcallback;
            obj;
            JVM INSTR monitorexit ;
            throw resultcallback;
            Ds = resultcallback;
              goto _L1
        }

        a()
        {
        }
    }

    public static abstract class b extends a
        implements c.c
    {

        private final Api.c Dn;
        private c.a Dy;

        private void a(RemoteException remoteexception)
        {
            m(new Status(8, remoteexception.getLocalizedMessage(), null));
        }

        protected abstract void a(Api.a a1)
            throws RemoteException;

        public void a(c.a a1)
        {
            Dy = a1;
        }

        public final void b(Api.a a1)
            throws DeadObjectException
        {
            a(new c(a1.getLooper()));
            try
            {
                a(a1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Api.a a1)
            {
                a(a1);
                throw a1;
            }
            // Misplaced declaration of an exception variable
            catch (Api.a a1)
            {
                a(a1);
            }
        }

        public final Api.c eB()
        {
            return Dn;
        }

        protected void eD()
        {
            super.eD();
            if (Dy != null)
            {
                Dy.b(this);
                Dy = null;
            }
        }

        public int eG()
        {
            return 0;
        }

        public final void m(Status status)
        {
            boolean flag;
            if (!status.isSuccess())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hm.b(flag, "Failed result must not be success");
            b(c(status));
        }

        protected b(Api.c c1)
        {
            Dn = (Api.c)hm.f(c1);
        }
    }

    public static class c extends Handler
    {

        public void a(ResultCallback resultcallback, Result result)
        {
            sendMessage(obtainMessage(1, new Pair(resultcallback, result)));
        }

        protected void b(ResultCallback resultcallback, Result result)
        {
            try
            {
                resultcallback.onResult(result);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ResultCallback resultcallback)
            {
                com.google.android.gms.common.api.a.a(result);
            }
            throw resultcallback;
        }

        public void eH()
        {
            removeMessages(2);
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.wtf("GoogleApi", "Don't know how to handle this message.");
                return;

            case 1: // '\001'
                message = (Pair)message.obj;
                b((ResultCallback)((Pair) (message)).first, (Result)((Pair) (message)).second);
                return;

            case 2: // '\002'
                a.a((a)message.obj);
                break;
            }
        }

        public c()
        {
            this(Looper.getMainLooper());
        }

        public c(Looper looper)
        {
            super(looper);
        }
    }

    public static interface d
    {

        public abstract void a(Object obj);
    }


    static void a(Result result)
    {
        if (!(result instanceof Releasable))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ((Releasable)result).release();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("GoogleApi", (new StringBuilder()).append("Unable to release ").append(result).toString(), runtimeexception);
        return;
    }
}
