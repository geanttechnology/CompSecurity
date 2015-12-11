// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook:
//            k, o, GraphRequest

public class n extends AsyncTask
    implements TraceFieldInterface
{

    private static final String a = com/facebook/n.getCanonicalName();
    private static Method b;
    public Trace _nr_trace;
    private final HttpURLConnection c;
    private final o d;
    private Exception e;

    public n(o o1)
    {
        this(null, o1);
    }

    public n(HttpURLConnection httpurlconnection, o o1)
    {
        d = o1;
        c = httpurlconnection;
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

    n a()
    {
        if (b != null)
        {
            Void avoid[];
            try
            {
                b.invoke(this, new Object[] {
                    k.d(), null
                });
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                return this;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                return this;
            }
            return this;
        }
        avoid = new Void[0];
        if (!(this instanceof AsyncTask))
        {
            execute(avoid);
            return this;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)this, avoid);
            return this;
        }
    }

    protected transient List a(Void avoid[])
    {
        try
        {
            if (c == null)
            {
                return d.g();
            }
            avoid = GraphRequest.a(c, d);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            e = avoid;
            return null;
        }
        return avoid;
    }

    protected void a(List list)
    {
        super.onPostExecute(list);
        if (e != null)
        {
            Log.d(a, String.format("onPostExecute: exception encountered during request: %s", new Object[] {
                e.getMessage()
            }));
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "n#doInBackground", null);
_L1:
        aobj = a((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "n#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "n#onPostExecute", null);
_L1:
        a((List)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "n#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (k.b())
        {
            Log.d(a, String.format("execute async task: %s", new Object[] {
                this
            }));
        }
        if (d.c() == null)
        {
            d.a(new Handler());
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("{RequestAsyncTask: ").append(" connection: ").append(c).append(", requests: ").append(d).append("}").toString();
    }

    static 
    {
        Method amethod[] = android/os/AsyncTask.getMethods();
        int j = amethod.length;
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    Method method = amethod[i];
                    if (!"executeOnExecutor".equals(method.getName()))
                    {
                        break label0;
                    }
                    Class aclass[] = method.getParameterTypes();
                    if (aclass.length != 2 || aclass[0] != java/util/concurrent/Executor || !aclass[1].isArray())
                    {
                        break label0;
                    }
                    b = method;
                }
                return;
            }
            i++;
        } while (true);
    }
}
