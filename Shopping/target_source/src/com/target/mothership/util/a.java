// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.google.b.p;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.a.a.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.o;
import com.target.mothership.services.v;
import com.target.mothership.services.w;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.target.mothership.util:
//            f

public class com.target.mothership.util.a
{
    public static interface a
    {

        public abstract void runTask();
    }


    public static final String TAG = com/target/mothership/util/a.getSimpleName();
    private static ExecutorService mExecutor = Executors.newCachedThreadPool();

    public com.target.mothership.util.a()
    {
    }

    public static void a(v v, aa aa, w w, o o)
    {
        v = new TraceFieldInterface(aa, v, w, o) {

            public Trace _nr_trace;
            private boolean mSuccess;
            final w val$listener;
            final v val$response;
            final o val$retryable;
            final aa val$transformer;

            public void _nr_setTrace(Trace trace)
            {
                try
                {
                    _nr_trace = trace;
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Trace trace)
                {
                    return;
                }
            }

            protected transient Object a(Void avoid[])
            {
                avoid = ((Void []) (transformer.a(response)));
                mSuccess = true;
                return avoid;
                p p1;
                p1;
                avoid = null;
_L2:
                b.a(com.target.mothership.util.a.TAG, "Exception while parsing response", p1);
                return avoid;
                p1;
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected Object doInBackground(Object aobj[])
            {
                TraceMachine.enterMethod(_nr_trace, "a$2#doInBackground", null);
_L1:
                aobj = ((Object []) (a((Void[])aobj)));
                TraceMachine.exitMethod();
                TraceMachine.unloadTraceContext(this);
                return ((Object) (aobj));
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "a$2#doInBackground", null);
                  goto _L1
            }

            protected void onPostExecute(Object obj)
            {
                TraceMachine.enterMethod(_nr_trace, "a$2#onPostExecute", null);
_L1:
                NoSuchFieldError nosuchfielderror;
                if (mSuccess)
                {
                    listener.onResult(obj, response.b(), retryable);
                } else
                {
                    listener.onError(f.a(response), retryable);
                }
                TraceMachine.exitMethod();
                return;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "a$2#onPostExecute", null);
                  goto _L1
            }

            
            {
                transformer = aa1;
                response = v1;
                listener = w1;
                retryable = o;
                super();
                mSuccess = false;
            }
        };
        aa = mExecutor;
        w = new Void[0];
        if (!(v instanceof AsyncTask))
        {
            v.executeOnExecutor(aa, w);
            return;
        } else
        {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask)v, aa, w);
            return;
        }
    }

    public static void a(a a1)
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable(a1) {

            final a val$task;

            public void run()
            {
                task.runTask();
            }

            
            {
                task = a1;
                super();
            }
        });
    }

}
