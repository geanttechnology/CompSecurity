// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpCore;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.http.httpUtils.PMHttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;

// Referenced classes of package com.poshmark.http.httpCore:
//            PMHttpExecutor, PMHttpClient

private class <init> extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final PMHttpExecutor this$0;

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
        TraceMachine.enterMethod(_nr_trace, "PMHttpExecutor$MakeRequestTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "PMHttpExecutor$MakeRequestTask#doInBackground", null);
          goto _L1
    }

    protected transient Void doInBackground(Void avoid[])
    {
        Throwable throwable;
        Object obj1;
        Object obj2;
        int i;
        int j;
        throwable = null;
        obj2 = null;
        obj1 = null;
        j = 0;
        avoid = throwable;
        i = j;
        Object obj = PMHttpClient.getInstance().httpClient;
        avoid = throwable;
        i = j;
        org.apache.http.client.methods.HttpUriRequest httpurirequest = httpRequest;
        avoid = throwable;
        i = j;
        if (obj instanceof HttpClient) goto _L2; else goto _L1
_L1:
        avoid = throwable;
        i = j;
        obj = ((HttpClient) (obj)).execute(httpurirequest);
_L3:
        avoid = throwable;
        i = j;
        throwable = ((HttpResponse) (obj)).getAllHeaders();
        avoid = throwable;
        i = j;
        j = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        avoid = throwable;
        i = j;
        obj = PMHttpUtils.getResponseString(((HttpResponse) (obj)));
        i = j;
        avoid = throwable;
        throwable = obj2;
_L4:
        avoid = prepareResponse(i, avoid, ((String) (obj)), throwable);
        PMHttpExecutor.access$100(PMHttpExecutor.this, avoid);
        return null;
_L2:
        avoid = throwable;
        i = j;
        obj = HttpInstrumentation.execute((HttpClient)obj, httpurirequest);
          goto _L3
        throwable;
        throwable.printStackTrace();
        obj = obj1;
          goto _L4
    }

    private tion()
    {
        this$0 = PMHttpExecutor.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
