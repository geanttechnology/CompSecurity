// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient, Request, RequestBody, MediaType, 
//            Response, Dispatcher, Callback

public class Call
{

    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    private int redirectionCount;
    private Request request;

    protected Call(OkHttpClient okhttpclient, Request request1)
    {
        client = okhttpclient.copyWithDefaults();
        request = request1;
    }

    private Response getResponse()
    {
        RequestBody requestbody = request.body();
        if (requestbody != null)
        {
            Request.Builder builder = request.newBuilder();
            MediaType mediatype = requestbody.contentType();
            if (mediatype != null)
            {
                builder.header("Content-Type", mediatype.toString());
            }
            long l = requestbody.contentLength();
            if (l != -1L)
            {
                builder.header("Content-Length", Long.toString(l));
                builder.removeHeader("Transfer-Encoding");
            } else
            {
                builder.header("Transfer-Encoding", "chunked");
                builder.removeHeader("Content-Length");
            }
            request = builder.build();
        }
        engine = new HttpEngine(client, request, false, null, null, null, null);
        do
        {
            if (canceled)
            {
                return null;
            }
            Object obj;
            Object obj1;
            try
            {
                engine.sendRequest();
                if (request.body() != null)
                {
                    okio.e e = engine.getBufferedRequestBody();
                    request.body().writeTo(e);
                }
                engine.readResponse();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj1 = engine.recover(((IOException) (obj)), null);
                if (obj1 != null)
                {
                    engine = ((HttpEngine) (obj1));
                } else
                {
                    throw obj;
                }
                continue;
            }
            obj = engine.getResponse();
            obj1 = engine.followUpRequest();
            if (obj1 == null)
            {
                engine.releaseConnection();
                return ((Response) (obj)).newBuilder().body(new RealResponseBody(((Response) (obj)), engine.getResponseBody())).build();
            }
            if (engine.getResponse().isRedirect())
            {
                int i = redirectionCount + 1;
                redirectionCount = i;
                if (i > 20)
                {
                    throw new ProtocolException((new StringBuilder()).append("Too many redirects: ").append(redirectionCount).toString());
                }
            }
            if (!engine.sameConnection(((Request) (obj1)).url()))
            {
                engine.releaseConnection();
            }
            Connection connection = engine.close();
            request = ((Request) (obj1));
            engine = new HttpEngine(client, request, false, connection, null, null, ((Response) (obj)));
        } while (true);
    }

    private String toLoggableString()
    {
        String s;
        String s1;
        if (canceled)
        {
            s = "canceled call";
        } else
        {
            s = "call";
        }
        try
        {
            s1 = (new URL(request.url(), "/...")).toString();
            s1 = (new StringBuilder()).append(s).append(" to ").append(s1).toString();
        }
        catch (MalformedURLException malformedurlexception)
        {
            return s;
        }
        return s1;
    }

    public void cancel()
    {
        canceled = true;
        if (engine != null)
        {
            engine.disconnect();
        }
    }

    public void enqueue(Callback callback)
    {
        this;
        JVM INSTR monitorenter ;
        if (executed)
        {
            throw new IllegalStateException("Already Executed");
        }
        break MISSING_BLOCK_LABEL_24;
        callback;
        this;
        JVM INSTR monitorexit ;
        throw callback;
        executed = true;
        this;
        JVM INSTR monitorexit ;
        client.getDispatcher().enqueue(new AsyncCall(callback));
        return;
    }

    public Response execute()
    {
        this;
        JVM INSTR monitorenter ;
        if (executed)
        {
            throw new IllegalStateException("Already Executed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        executed = true;
        this;
        JVM INSTR monitorexit ;
        Object obj;
        client.getDispatcher().executed(this);
        obj = getResponse();
        engine.releaseConnection();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        throw new IOException("Canceled");
        obj;
        client.getDispatcher().finished(this);
        throw obj;
        client.getDispatcher().finished(this);
        return ((Response) (obj));
    }

    public boolean isCanceled()
    {
        return canceled;
    }

    Object tag()
    {
        return request.tag();
    }





    private class RealResponseBody extends ResponseBody
    {

        private final Response response;
        private final f source;

        public long contentLength()
        {
            return OkHeaders.contentLength(response);
        }

        public MediaType contentType()
        {
            String s = response.header("Content-Type");
            if (s != null)
            {
                return MediaType.parse(s);
            } else
            {
                return null;
            }
        }

        public f source()
        {
            return source;
        }

        RealResponseBody(Response response1, f f)
        {
            response = response1;
            source = f;
        }
    }


    private class AsyncCall extends NamedRunnable
    {

        private final Callback responseCallback;
        final Call this$0;

        void cancel()
        {
            Call.this.cancel();
        }

        protected void execute()
        {
            boolean flag = true;
            Response response;
            boolean flag1;
            response = getResponse();
            flag1 = canceled;
            if (!flag1) goto _L2; else goto _L1
_L1:
            responseCallback.onFailure(Call.this.request, new IOException("Canceled"));
_L4:
            client.getDispatcher().finished(this);
            return;
_L2:
            engine.releaseConnection();
            responseCallback.onResponse(response);
            if (true) goto _L4; else goto _L3
_L3:
            Object obj;
            obj;
_L10:
            if (!flag) goto _L6; else goto _L5
_L5:
            Internal.logger.log(Level.INFO, (new StringBuilder()).append("Callback failure for ").append(toLoggableString()).toString(), ((Throwable) (obj)));
_L8:
            client.getDispatcher().finished(this);
            return;
_L6:
            responseCallback.onFailure(Call.this.request, ((IOException) (obj)));
            if (true) goto _L8; else goto _L7
_L7:
            obj;
            client.getDispatcher().finished(this);
            throw obj;
            obj;
            flag = false;
            if (true) goto _L10; else goto _L9
_L9:
        }

        Call get()
        {
            return Call.this;
        }

        String host()
        {
            return Call.this.request.url().getHost();
        }

        Request request()
        {
            return Call.this.request;
        }

        Object tag()
        {
            return Call.this.request.tag();
        }

        private AsyncCall(Callback callback)
        {
            this$0 = Call.this;
            super("OkHttp %s", new Object[] {
                Call.this.request.urlString()
            });
            responseCallback = callback;
        }

    }

}
