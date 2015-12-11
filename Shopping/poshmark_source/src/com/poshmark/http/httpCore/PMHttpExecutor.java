// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpCore;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.http.PMHttpError;
import com.poshmark.http.PMHttpRequest;
import com.poshmark.http.PMHttpResponse;
import com.poshmark.http.PMHttpResponseHandler;
import com.poshmark.http.httpUtils.PMHttpUtils;
import com.poshmark.utils.view_holders.MultiMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.poshmark.http.httpCore:
//            PMHttpClient

public class PMHttpExecutor
{
    private class MakeRequestTask extends AsyncTask
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
            HttpUriRequest httpurirequest = httpRequest;
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
            sendResponseMessage(avoid);
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

        private MakeRequestTask()
        {
            this$0 = PMHttpExecutor.this;
            super();
        }

    }


    private static final int RESPONSE_MESSAGE = 1;
    Handler handler;
    HttpUriRequest httpRequest;
    final PMHttpRequest pmHttpRequest;

    public PMHttpExecutor(PMHttpRequest pmhttprequest)
    {
        httpRequest = null;
        pmHttpRequest = pmhttprequest;
    }

    private void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            callResponseHandler((PMHttpResponse)message.obj);
            break;
        }
    }

    private Message obtainMessage(PMHttpResponse pmhttpresponse)
    {
        if (handler != null)
        {
            return handler.obtainMessage(1, pmhttpresponse);
        } else
        {
            Message message = Message.obtain();
            message.what = 1;
            message.obj = pmhttpresponse;
            return message;
        }
    }

    private void sendResponseMessage(PMHttpResponse pmhttpresponse)
    {
        pmhttpresponse = obtainMessage(pmhttpresponse);
        if (handler != null)
        {
            handler.sendMessage(pmhttpresponse);
            return;
        } else
        {
            handleMessage(pmhttpresponse);
            return;
        }
    }

    private void setupHandlerForCallingThread()
    {
        if (Looper.myLooper() != null)
        {
            handler = new Handler() {

                final PMHttpExecutor this$0;

                public void handleMessage(Message message)
                {
                    PMHttpExecutor.this.handleMessage(message);
                }

            
            {
                this$0 = PMHttpExecutor.this;
                super();
            }
            };
        }
    }

    protected void callResponseHandler(PMHttpResponse pmhttpresponse)
    {
        if (pmhttpresponse.httpRequest.responseHandler != null)
        {
            ((PMHttpResponseHandler)pmhttpresponse.httpRequest.responseHandler).handleResponse(pmhttpresponse);
        }
    }

    public void execute()
    {
        Object obj;
        if (pmHttpRequest.responseHandler != null)
        {
            setupHandlerForCallingThread();
        }
        obj = PMHttpUtils.getUrlWithQueryString(pmHttpRequest.url, pmHttpRequest.queryParams);
        static class _cls2
        {

            static final int $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE = new int[com.poshmark.http.PMHttpRequest.REQUEST_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_PUT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$http$PMHttpRequest$REQUEST_TYPE[com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_DELETE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.poshmark.http.PMHttpRequest.REQUEST_TYPE[pmHttpRequest.requestType.ordinal()];
        JVM INSTR tableswitch 1 4: default 76
    //                   1 150
    //                   2 165
    //                   3 180
    //                   4 195;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        java.util.Map.Entry entry;
        for (obj = pmHttpRequest.headers.entrySet().iterator(); ((Iterator) (obj)).hasNext(); httpRequest.addHeader(new BasicHeader((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        break; /* Loop/switch isn't completed */
_L2:
        httpRequest = new HttpGet(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L3:
        httpRequest = new HttpPost(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L4:
        httpRequest = new HttpPut(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L5:
        httpRequest = new HttpDelete(((String) (obj)));
        if (true) goto _L1; else goto _L6
_L6:
        if ((pmHttpRequest.formData != null && pmHttpRequest.formData.size() > 0 || pmHttpRequest.nestedFormData != null && pmHttpRequest.nestedFormData.size() > 0 || pmHttpRequest.multipartData != null && pmHttpRequest.multipartData.size() > 0) && (httpRequest instanceof HttpEntityEnclosingRequestBase))
        {
            ((HttpEntityEnclosingRequestBase)httpRequest).setEntity(PMHttpUtils.getEntityForRequest(pmHttpRequest));
        }
        Object obj1 = new BasicHttpParams();
        ((HttpParams) (obj1)).setParameter("http.protocol.handle-redirects", Boolean.valueOf(false));
        if (pmHttpRequest.timeoutMilliSeconds != -1)
        {
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj1)), pmHttpRequest.timeoutMilliSeconds);
        }
        httpRequest.setParams(((HttpParams) (obj1)));
        obj1 = new MakeRequestTask();
        java.util.concurrent.Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
        Void avoid[] = new Void[0];
        if (!(obj1 instanceof AsyncTask))
        {
            ((MakeRequestTask) (obj1)).executeOnExecutor(executor, avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask)obj1, executor, avoid);
            return;
        }
    }

    protected PMHttpResponse prepareResponse(int i, Header aheader[], String s, Throwable throwable)
    {
        PMHttpError pmhttperror = null;
        if (throwable != null)
        {
            pmhttperror = new PMHttpError(throwable);
        }
        return new PMHttpResponse(i, aheader, s, pmHttpRequest, pmhttperror);
    }


}
