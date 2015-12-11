// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;

// Referenced classes of package com.target.ui.analytics.a:
//            a

class this._cls0 extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final a this$0;

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

    protected transient Void a(Void avoid[])
    {
        f();
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "a$1#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "a$1#doInBackground", null);
          goto _L1
    }

    cing.Trace()
    {
        this$0 = a.this;
        super();
    }
}
