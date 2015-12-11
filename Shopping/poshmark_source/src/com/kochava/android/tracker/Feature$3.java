// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.kochava.android.tracker:
//            Feature

class this._cls0 extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final Feature this$0;

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

    protected volatile transient Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "Feature$3#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "Feature$3#doInBackground", null);
          goto _L1
    }

    protected transient String doInBackground(Void avoid[])
    {
        return Feature.access$36(Feature.this);
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "Feature$3#onPostExecute", null);
_L1:
        onPostExecute((String)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "Feature$3#onPostExecute", null);
          goto _L1
    }

    protected void onPostExecute(String s)
    {
        Feature.access$37(s);
    }

    ce()
    {
        this$0 = Feature.this;
        super();
    }
}
