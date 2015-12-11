// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.h;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.target.mothership.util.o;
import com.target.ui.util.q;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

// Referenced classes of package com.target.ui.util.h:
//            b

public class com.target.ui.util.h.a
{
    private static class a extends AsyncTask
        implements TraceFieldInterface
    {

        public Trace _nr_trace;
        final b mListener;

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

        protected transient String a(URL aurl[])
        {
            if (aurl == null || aurl[0] == null)
            {
                return "";
            } else
            {
                return com.target.ui.util.h.a.b(aurl[0], mListener);
            }
        }

        protected void a(String s)
        {
            super.onPostExecute(s);
            if (mListener == null)
            {
                return;
            }
            if (!o.g(s))
            {
                mListener.a();
                return;
            } else
            {
                mListener.a(s);
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            TraceMachine.enterMethod(_nr_trace, "a$a#doInBackground", null);
_L1:
            aobj = a((URL[])aobj);
            TraceMachine.exitMethod();
            TraceMachine.unloadTraceContext(this);
            return ((Object) (aobj));
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "a$a#doInBackground", null);
              goto _L1
        }

        protected void onPostExecute(Object obj)
        {
            TraceMachine.enterMethod(_nr_trace, "a$a#onPostExecute", null);
_L1:
            a((String)obj);
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "a$a#onPostExecute", null);
              goto _L1
        }

        a(b b1)
        {
            mListener = b1;
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(String s);
    }


    private static final String ENCODE_TYPE = "UTF-8";
    private static final String TAG = com/target/ui/util/h/a.getSimpleName();

    public com.target.ui.util.h.a()
    {
    }

    public static void a(URL url, b b1)
    {
        b1 = new a(b1);
        URL aurl[] = new URL[1];
        aurl[0] = url;
        if (!(b1 instanceof AsyncTask))
        {
            b1.execute(aurl);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)b1, aurl);
            return;
        }
    }

    static String b(URL url, b b1)
    {
        return c(url, b1);
    }

    private static String c(URL url, b b1)
    {
        Object obj = new com.target.ui.util.h.b(new InputStreamReader(url.openStream(), "UTF-8"));
        url = "";
_L1:
        String s = ((com.target.ui.util.h.b) (obj)).readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        url = (new StringBuilder()).append(url).append(s).toString();
          goto _L1
        ((com.target.ui.util.h.b) (obj)).close();
        obj = url;
_L3:
        return ((String) (obj));
        IOException ioexception;
        ioexception;
        url = "";
_L4:
        q.a(TAG, (new StringBuilder()).append("Exception occurred while reading html content ").append(ioexception.getMessage()).toString());
        ioexception = url;
        if (b1 == null) goto _L3; else goto _L2
_L2:
        b1.a();
        return url;
        ioexception;
          goto _L4
    }

}
