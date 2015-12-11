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
import com.google.android.gms.internal.er;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, Status, Releasable, Result, 
//            ResultCallback

public class com.google.android.gms.common.api.a
{
    public static abstract class a
        implements PendingResult, c, b.c
    {

        private final Api.b zc;
        private final Object zd;
        private b ze;
        private final CountDownLatch zf;
        private final ArrayList zg;
        private ResultCallback zh;
        private volatile Result zi;
        private volatile boolean zj;
        private boolean zk;
        private boolean zl;
        private b.a zm;

        private void a(RemoteException remoteexception)
        {
            a(d(new Status(8, remoteexception.getLocalizedMessage(), null)));
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

        private void dv()
        {
            if (zi == null || !(this instanceof Releasable))
            {
                break MISSING_BLOCK_LABEL_23;
            }
            ((Releasable)this).release();
            return;
            Exception exception;
            exception;
            Log.w("GoogleApi", (new StringBuilder()).append("Unable to release ").append(this).toString(), exception);
            return;
        }

        protected abstract void a(Api.a a1)
            throws RemoteException;

        public final void a(Result result)
        {
            boolean flag1;
label0:
            {
                flag1 = true;
                synchronized (zd)
                {
                    if (!zl)
                    {
                        break label0;
                    }
                    if (result instanceof Releasable)
                    {
                        ((Releasable)result).release();
                    }
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
            er.a(flag, "Results have already been set");
            if (!zj)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            er.a(flag, "Result has already been consumed");
            zi = result;
            if (!zk)
            {
                break MISSING_BLOCK_LABEL_107;
            }
            dv();
            obj;
            JVM INSTR monitorexit ;
            return;
            result;
            obj;
            JVM INSTR monitorexit ;
            throw result;
            zf.countDown();
            result = zi.getStatus();
            if (zh != null)
            {
                ze.dw();
                ze.a(zh, ds());
            }
            for (Iterator iterator = zg.iterator(); iterator.hasNext(); ((PendingResult.a)iterator.next()).k(result)) { }
            zg.clear();
            obj;
            JVM INSTR monitorexit ;
        }

        public void a(b.a a1)
        {
            zm = a1;
        }

        public final Result await()
        {
label0:
            {
                boolean flag1 = false;
                boolean flag;
                if (!zj)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                er.a(flag, "Results has already been consumed");
                if (!isReady())
                {
                    flag = flag1;
                    if (Looper.myLooper() == Looper.getMainLooper())
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            er.a(flag, "await must not be called on the UI thread");
            try
            {
                zf.await();
            }
            catch (InterruptedException interruptedexception)
            {
                synchronized (zd)
                {
                    a(d(Status.zR));
                    zl = true;
                }
            }
            er.a(isReady(), "Result is not ready.");
            return ds();
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final Result await(long l, TimeUnit timeunit)
        {
label0:
            {
                boolean flag1 = false;
                boolean flag;
                if (!zj)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                er.a(flag, "Result has already been consumed.");
                if (!isReady())
                {
                    flag = flag1;
                    if (Looper.myLooper() == Looper.getMainLooper())
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            er.a(flag, "await must not be called on the UI thread");
            if (!zf.await(l, timeunit))
            {
                synchronized (zd)
                {
                    a(d(Status.zS));
                    zl = true;
                }
            }
_L2:
            er.a(isReady(), "Result is not ready.");
            return ds();
            exception;
            timeunit;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (TimeUnit timeunit) { }
            synchronized (zd)
            {
                a(d(Status.zR));
                zl = true;
            }
            if (true) goto _L2; else goto _L1
_L1:
            exception1;
            timeunit;
            JVM INSTR monitorexit ;
            throw exception1;
        }

        public final void b(Api.a a1)
            throws DeadObjectException
        {
            ze = new b(a1.getLooper());
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

        public void b(Object obj)
        {
            a((Result)obj);
        }

        protected abstract Result d(Status status);

        public final Api.b dp()
        {
            return zc;
        }

        public int dr()
        {
            return 0;
        }

        void dt()
        {
            zj = true;
            zi = null;
            if (zm != null)
            {
                zm.b(this);
            }
        }

        public void du()
        {
            dv();
            zk = true;
        }

        public final boolean isReady()
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
            ze.a(resultcallback, ds());
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
            ze.a(resultcallback, ds());
_L2:
            return;
            zh = resultcallback;
            ze.a(this, timeunit.toMillis(l));
            if (true) goto _L2; else goto _L1
_L1:
            resultcallback;
            obj;
            JVM INSTR monitorexit ;
            throw resultcallback;
        }

        protected a()
        {
            this((Api.b)null);
        }

        protected a(Api.b b1)
        {
            zd = new Object();
            zf = new CountDownLatch(1);
            zg = new ArrayList();
            zc = b1;
        }
    }

    public static class b extends Handler
    {

        public void a(ResultCallback resultcallback, Result result)
        {
            sendMessage(obtainMessage(1, new Pair(resultcallback, result)));
        }

        public void a(a a1, long l)
        {
            sendMessageDelayed(obtainMessage(2, a1), l);
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
                Log.wtf("GoogleApi", "Don't know how to handle this message.");
                return;

            case 1: // '\001'
                message = (Pair)message.obj;
                b((ResultCallback)((Pair) (message)).first, (Result)((Pair) (message)).second);
                return;

            case 2: // '\002'
                message = (a)message.obj;
                break;
            }
            message.a(message.d(Status.zS));
        }

        public b()
        {
            this(Looper.getMainLooper());
        }

        public b(Looper looper)
        {
            super(looper);
        }
    }

    public static interface c
    {

        public abstract void b(Object obj);
    }

}
