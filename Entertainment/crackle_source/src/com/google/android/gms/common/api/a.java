// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            PendingResult, Result, Status, ResultCallback

public class com.google.android.gms.common.api.a
{
    public static abstract class a
        implements GoogleApiClient.b, PendingResult, c
    {

        private final Api.b mU;
        private final Object mV = new Object();
        private final b mW = new _cls1(this);
        private final CountDownLatch mX = new CountDownLatch(1);
        private final ArrayList mY = new ArrayList();
        private ResultCallback mZ;
        private Result na;
        private boolean nb;
        private GoogleApiClient.a nc;

        private Result bl()
        {
            Object obj = mV;
            obj;
            JVM INSTR monitorenter ;
            Result result;
            Exception exception;
            boolean flag;
            if (!nb)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.a(flag, "Result has already been consumed.");
            eg.a(isReady(), "Result is not ready.");
            result = na;
            bm();
            obj;
            JVM INSTR monitorexit ;
            return result;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected abstract void a(Api.a a1);

        public void a(GoogleApiClient.a a1)
        {
            nc = a1;
        }

        public final void a(Result result)
        {
            Object obj;
            boolean flag1 = true;
            Iterator iterator;
            boolean flag;
            if (!isReady())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.a(flag, "Results have already been set");
            if (!nb)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            eg.a(flag, "Result has already been consumed");
            obj = mV;
            obj;
            JVM INSTR monitorenter ;
            na = result;
            mX.countDown();
            result = na.getStatus();
            if (mZ != null)
            {
                mW.b(mZ, bl());
            }
            for (iterator = mY.iterator(); iterator.hasNext(); ((PendingResult.a)iterator.next()).l(result)) { }
            break MISSING_BLOCK_LABEL_141;
            result;
            obj;
            JVM INSTR monitorexit ;
            throw result;
            mY.clear();
            obj;
            JVM INSTR monitorexit ;
        }

        public volatile void a(Object obj)
        {
            a((Result)obj);
        }

        public final Result await()
        {
            boolean flag;
            if (!nb)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.a(flag, "Results has already been consumed");
            try
            {
                mX.await();
            }
            catch (InterruptedException interruptedexception)
            {
                a(e(Status.nB));
            }
            eg.a(isReady(), "Result is not ready.");
            return bl();
        }

        public final Result await(long l, TimeUnit timeunit)
        {
            boolean flag;
            if (!nb)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.a(flag, "Result has already been consumed.");
            try
            {
                if (!mX.await(l, timeunit))
                {
                    a(e(Status.nC));
                }
            }
            // Misplaced declaration of an exception variable
            catch (TimeUnit timeunit)
            {
                a(e(Status.nB));
            }
            eg.a(isReady(), "Result is not ready.");
            return bl();
        }

        public final void b(Api.a a1)
        {
            a(a1);
        }

        public final Api.b bj()
        {
            return mU;
        }

        void bm()
        {
            nb = true;
            na = null;
            if (nc != null)
            {
                nc.b(this);
            }
        }

        public final boolean isReady()
        {
            return mX.getCount() == 0L;
        }

        public final void setResultCallback(ResultCallback resultcallback)
        {
            Object obj;
            boolean flag;
            if (!nb)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.a(flag, "Result has already been consumed.");
            obj = mV;
            obj;
            JVM INSTR monitorenter ;
            if (!isReady())
            {
                break MISSING_BLOCK_LABEL_44;
            }
            mW.b(resultcallback, bl());
_L2:
            return;
            mZ = resultcallback;
            if (true) goto _L2; else goto _L1
_L1:
            resultcallback;
            obj;
            JVM INSTR monitorexit ;
            throw resultcallback;
        }

        public a(Api.b b1)
        {
            mU = b1;
        }
    }

    static abstract class b extends Handler
    {

        protected abstract void a(ResultCallback resultcallback, Result result);

        public void b(ResultCallback resultcallback, Result result)
        {
            sendMessage(obtainMessage(1, new Pair(resultcallback, result)));
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
                break;
            }
            a((ResultCallback)((Pair) (message)).first, (Result)((Pair) (message)).second);
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

        public abstract void a(Object obj);
    }


    // Unreferenced inner class com/google/android/gms/common/api/a$a$1

/* anonymous class */
    class a._cls1 extends b
    {

        final a nd;

        protected void a(ResultCallback resultcallback, Result result)
        {
            resultcallback.onResult(result);
        }

            
            {
                nd = a1;
                super();
            }
    }

}
