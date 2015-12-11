// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import android.os.AsyncTask;
import com.google.b.p;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.a.a.b;
import com.target.mothership.services.aa;
import com.target.mothership.services.o;
import com.target.mothership.services.v;
import com.target.mothership.services.w;

// Referenced classes of package com.target.mothership.util:
//            a, f

static final class mSuccess extends AsyncTask
    implements TraceFieldInterface
{

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
        avoid = ((Void []) (val$transformer.a(val$response)));
        mSuccess = true;
        return avoid;
        p p1;
        p1;
        avoid = null;
_L2:
        b.a(a.TAG, "Exception while parsing response", p1);
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
            val$listener.onResult(obj, val$response.b(), val$retryable);
        } else
        {
            val$listener.onError(f.a(val$response), val$retryable);
        }
        TraceMachine.exitMethod();
        return;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "a$2#onPostExecute", null);
          goto _L1
    }

    o(aa aa1, v v1, w w1, o o)
    {
        val$transformer = aa1;
        val$response = v1;
        val$listener = w1;
        val$retryable = o;
        super();
        mSuccess = false;
    }
}
