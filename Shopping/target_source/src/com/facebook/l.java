// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.net.HttpURLConnection;
import java.util.List;

// Referenced classes of package com.facebook:
//            m, GraphRequest, i

public class l extends AsyncTask
    implements TraceFieldInterface
{

    private static final String a = com/facebook/l.getCanonicalName();
    public Trace _nr_trace;
    private final HttpURLConnection b;
    private final m c;
    private Exception d;

    public l(m m1)
    {
        this(null, m1);
    }

    public l(HttpURLConnection httpurlconnection, m m1)
    {
        c = m1;
        b = httpurlconnection;
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

    protected transient List a(Void avoid[])
    {
        try
        {
            if (b == null)
            {
                return c.g();
            }
            avoid = GraphRequest.a(b, c);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            d = avoid;
            return null;
        }
        return avoid;
    }

    protected void a(List list)
    {
        super.onPostExecute(list);
        if (d != null)
        {
            Log.d(a, String.format("onPostExecute: exception encountered during request: %s", new Object[] {
                d.getMessage()
            }));
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "l#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "l#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "l#onPostExecute", null);
_L1:
        a((List)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "l#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (i.b())
        {
            Log.d(a, String.format("execute async task: %s", new Object[] {
                this
            }));
        }
        if (c.c() == null)
        {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread)
            {
                handler = new Handler();
            } else
            {
                handler = new Handler(Looper.getMainLooper());
            }
            c.a(handler);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("{RequestAsyncTask: ").append(" connection: ").append(b).append(", requests: ").append(c).append("}").toString();
    }

}
