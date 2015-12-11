// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient, Dispatcher, Request, RequestBody, 
//            MediaType, Response, Interceptor

public class Call
{
    class ApplicationInterceptorChain
        implements Interceptor.Chain
    {

        private final boolean forWebSocket;
        private final int index;
        private final Request request;
        final Call this$0;

        public Response proceed(Request request1)
            throws IOException
        {
            if (index < client.interceptors().size())
            {
                request1 = new ApplicationInterceptorChain(index + 1, request1, forWebSocket);
                return ((Interceptor)client.interceptors().get(index)).intercept(request1);
            } else
            {
                return getResponse(request1, forWebSocket);
            }
        }

        ApplicationInterceptorChain(int i, Request request1, boolean flag)
        {
            this$0 = Call.this;
            super();
            index = i;
            request = request1;
            forWebSocket = flag;
        }
    }


    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    Call(OkHttpClient okhttpclient, Request request)
    {
        client = okhttpclient.copyWithDefaults();
        originalRequest = request;
    }

    private Response getResponseWithInterceptorChain(boolean flag)
        throws IOException
    {
        return (new ApplicationInterceptorChain(0, originalRequest, flag)).proceed(originalRequest);
    }

    public Response execute()
        throws IOException
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
        obj = getResponseWithInterceptorChain(false);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        throw new IOException("Canceled");
        obj;
        client.getDispatcher().finished(this);
        throw obj;
        client.getDispatcher().finished(this);
        return ((Response) (obj));
    }

    Response getResponse(Request request, boolean flag)
        throws IOException
    {
        RequestBody requestbody = request.body();
        Object obj = request;
        int i;
        if (requestbody != null)
        {
            request = request.newBuilder();
            obj = requestbody.contentType();
            if (obj != null)
            {
                request.header("Content-Type", ((MediaType) (obj)).toString());
            }
            long l = requestbody.contentLength();
            if (l != -1L)
            {
                request.header("Content-Length", Long.toString(l));
                request.removeHeader("Transfer-Encoding");
            } else
            {
                request.header("Transfer-Encoding", "chunked");
                request.removeHeader("Content-Length");
            }
            obj = request.build();
        }
        engine = new HttpEngine(client, ((Request) (obj)), false, false, flag, null, null, null, null);
        i = 0;
        do
        {
            if (canceled)
            {
                engine.releaseConnection();
                throw new IOException("Canceled");
            }
            Object obj1;
            try
            {
                engine.sendRequest();
                engine.readResponse();
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                throw request.getCause();
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                obj1 = engine.recover(request);
                if (obj1 != null)
                {
                    engine = ((HttpEngine) (obj1));
                } else
                {
                    throw request.getLastConnectException();
                }
                continue;
            }
            // Misplaced declaration of an exception variable
            catch (Request request)
            {
                obj1 = engine.recover(request, null);
                if (obj1 != null)
                {
                    engine = ((HttpEngine) (obj1));
                } else
                {
                    throw request;
                }
                continue;
            }
            request = engine.getResponse();
            obj1 = engine.followUpRequest();
            if (obj1 == null)
            {
                if (!flag)
                {
                    engine.releaseConnection();
                }
                return request;
            }
            i++;
            if (i > 20)
            {
                throw new ProtocolException((new StringBuilder()).append("Too many follow-up requests: ").append(i).toString());
            }
            if (!engine.sameConnection(((Request) (obj1)).url()))
            {
                engine.releaseConnection();
            }
            Connection connection = engine.close();
            engine = new HttpEngine(client, ((Request) (obj1)), false, false, flag, connection, null, null, request);
        } while (true);
    }

}
