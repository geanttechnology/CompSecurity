// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.mothership.b;
import com.target.mothership.services.e.h.b.i;
import com.target.mothership.services.w;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.cache:
//            d, i

class .b.i extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final .Trace this$0;
    final i val$result;

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

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "i$1$1#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "i$1$1#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        b.a().l().updateStores(val$result);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "i$1$1#onPostExecute", null);
_L1:
        onPostExecute((Void)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "i$1$1#onPostExecute", null);
          goto _L1
    }

    protected void onPostExecute(Void void1)
    {
        if (callback != null)
        {
            callback.UpdateComplete();
        }
    }

    .b.i()
    {
        this$0 = final_i;
        val$result = i.this;
        super();
    }

    // Unreferenced inner class com/target/mothership/cache/i$1

/* anonymous class */
    static final class i._cls1 extends w
    {

        final i.b val$callback;

        public String getTag()
        {
            return null;
        }

        public void onError(x x)
        {
            if (callback != null)
            {
                callback.onFailure(x);
            }
        }

        public void onResult(i j)
        {
            j = j. new i._cls1._cls1();
            Void avoid[] = new Void[0];
            if (!(j instanceof AsyncTask))
            {
                j.execute(avoid);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)j, avoid);
                return;
            }
        }

        public volatile void onResult(Object obj)
        {
            onResult((i)obj);
        }

            
            {
                callback = b1;
                super();
            }
    }

}
