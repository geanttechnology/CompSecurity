// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.j.a.a.a:
//            g, l, b

class k extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final l a;

    private k(l l)
    {
        a = l;
        super();
    }

    k(l l, b b)
    {
        this(l);
    }

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

    protected final Boolean a(ArrayList aarraylist[])
    {
        try
        {
            for (aarraylist = aarraylist[0].iterator(); aarraylist.hasNext(); ((g)aarraylist.next()).c()) { }
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList aarraylist[])
        {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "k#doInBackground", null);
_L1:
        aobj = a((ArrayList[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "k#doInBackground", null);
          goto _L1
    }
}
