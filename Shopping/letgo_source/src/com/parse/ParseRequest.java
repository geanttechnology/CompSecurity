// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.client.ClientProtocolException;

// Referenced classes of package com.parse:
//            ProgressCallback, ParseHttpClient, ParseHttpRequest, ParseHttpBody, 
//            ParseException, ParseHttpResponse, PLog, ParseExecutors

abstract class ParseRequest
{
    public static final class Method extends Enum
    {

        private static final Method $VALUES[];
        public static final Method DELETE;
        public static final Method GET;
        public static final Method POST;
        public static final Method PUT;

        public static Method fromString(String s)
        {
            byte byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 4: default 48
        //                       70454: 82
        //                       79599: 110
        //                       2461856: 96
        //                       2012838315: 124;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            break; /* Loop/switch isn't completed */
_L5:
            break MISSING_BLOCK_LABEL_124;
_L6:
            switch (byte0)
            {
            default:
                return null;

            case 0: // '\0'
                return GET;

            case 1: // '\001'
                return POST;

            case 2: // '\002'
                return PUT;

            case 3: // '\003'
                return DELETE;
            }
_L2:
            if (s.equals("GET"))
            {
                byte0 = 0;
            }
              goto _L6
_L4:
            if (s.equals("POST"))
            {
                byte0 = 1;
            }
              goto _L6
_L3:
            if (s.equals("PUT"))
            {
                byte0 = 2;
            }
              goto _L6
            if (s.equals("DELETE"))
            {
                byte0 = 3;
            }
              goto _L6
        }

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(com/parse/ParseRequest$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])$VALUES.clone();
        }

        public String toString()
        {
            static class _cls6
            {

                static final int $SwitchMap$com$parse$ParseRequest$Method[];

                static 
                {
                    $SwitchMap$com$parse$ParseRequest$Method = new int[Method.values().length];
                    try
                    {
                        $SwitchMap$com$parse$ParseRequest$Method[Method.GET.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$parse$ParseRequest$Method[Method.POST.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$parse$ParseRequest$Method[Method.PUT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$parse$ParseRequest$Method[Method.DELETE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls6..SwitchMap.com.parse.ParseRequest.Method[ordinal()])
            {
            default:
                return null;

            case 1: // '\001'
                return "GET";

            case 2: // '\002'
                return "POST";

            case 3: // '\003'
                return "PUT";

            case 4: // '\004'
                return "DELETE";
            }
        }

        static 
        {
            GET = new Method("GET", 0);
            POST = new Method("POST", 1);
            PUT = new Method("PUT", 2);
            DELETE = new Method("DELETE", 3);
            $VALUES = (new Method[] {
                GET, POST, PUT, DELETE
            });
        }

        private Method(String s, int i)
        {
            super(s, i);
        }
    }

    private static class ParseRequestException extends ParseException
    {

        boolean isPermanentFailure;

        public ParseRequestException(int i, String s)
        {
            super(i, s);
            isPermanentFailure = false;
        }

        public ParseRequestException(int i, String s, Throwable throwable)
        {
            super(i, s, throwable);
            isPermanentFailure = false;
        }
    }


    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    static final long DEFAULT_INITIAL_RETRY_DELAY = 1000L;
    protected static final int DEFAULT_MAX_RETRIES = 4;
    private static final long KEEP_ALIVE_TIME = 1L;
    private static final int MAX_POOL_SIZE;
    private static final int MAX_QUEUE_SIZE = 128;
    static final ExecutorService NETWORK_EXECUTOR;
    private static ParseHttpClient defaultClient = null;
    private static long defaultInitialRetryDelay = 1000L;
    private static final ThreadFactory sThreadFactory;
    private int maxRetries;
    Method method;
    String url;

    public ParseRequest(Method method1, String s)
    {
        maxRetries = 4;
        method = method1;
        url = s;
    }

    public ParseRequest(String s)
    {
        this(Method.GET, s);
    }

    private cu executeAsync(final ParseHttpClient client, final ParseHttpRequest request, final int attemptsMade, final long delay, final ProgressCallback downloadProgressCallback, final cu cancellationToken)
    {
        if (cancellationToken != null && cancellationToken.c())
        {
            return cu.h();
        } else
        {
            return sendOneRequestAsync(client, request, downloadProgressCallback).b(new ct() {

                final ParseRequest this$0;
                final int val$attemptsMade;
                final cu val$cancellationToken;
                final ParseHttpClient val$client;
                final long val$delay;
                final ProgressCallback val$downloadProgressCallback;
                final ParseHttpRequest val$request;

                public cu then(cu cu1)
                    throws Exception
                {
                    cu cu2;
                    Exception exception;
                    exception = cu1.f();
                    cu2 = cu1;
                    if (!cu1.d()) goto _L2; else goto _L1
_L1:
                    cu2 = cu1;
                    if (!(exception instanceof ParseException)) goto _L2; else goto _L3
_L3:
                    if (cancellationToken == null || !cancellationToken.c()) goto _L5; else goto _L4
_L4:
                    cu2 = cu.h();
_L2:
                    return cu2;
_L5:
                    if (!(exception instanceof ParseRequestException))
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    cu2 = cu1;
                    if (((ParseRequestException)exception).isPermanentFailure) goto _L2; else goto _L6
_L6:
                    if (attemptsMade < maxRetries)
                    {
                        PLog.i("com.parse.ParseRequest", (new StringBuilder()).append("Request failed. Waiting ").append(delay).append(" milliseconds before attempt #").append(attemptsMade + 1).toString());
                        cu1 = cu.a();
                        ParseExecutors.scheduled().schedule(cu1. new Runnable() {

                            final _cls5 this$1;
                            final android.support.v7.cu.a val$retryTask;

                            public void run()
                            {
                                executeAsync(client, request, attemptsMade + 1, delay * 2L, downloadProgressCallback, cancellationToken).b(new ct() {

                                    final _cls1 this$2;

                                    public cu then(cu cu1)
                                        throws Exception
                                    {
                                        if (cu1.c())
                                        {
                                            retryTask.c();
                                        } else
                                        if (cu1.d())
                                        {
                                            retryTask.b(cu1.f());
                                        } else
                                        {
                                            retryTask.b(cu1.e());
                                        }
                                        return null;
                                    }

                                    public volatile Object then(cu cu1)
                                        throws Exception
                                    {
                                        return then(cu1);
                                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                });
                            }

            
            {
                this$1 = final__pcls5;
                retryTask = android.support.v7.cu.a.this;
                super();
            }
                        }, delay, TimeUnit.MILLISECONDS);
                        return cu1.a();
                    }
                    cu2 = cu1;
                    if (!request.isCancelled())
                    {
                        PLog.i("com.parse.ParseRequest", "Request failed. Giving up.");
                        return cu1;
                    }
                    if (true) goto _L2; else goto _L7
_L7:
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseRequest.this;
                cancellationToken = cu1;
                attemptsMade = i;
                delay = l;
                client = parsehttpclient;
                request = parsehttprequest;
                downloadProgressCallback = progresscallback;
                super();
            }
            });
        }
    }

    private cu executeAsync(ParseHttpClient parsehttpclient, final ParseHttpRequest request, ProgressCallback progresscallback, cu cu1)
    {
        long l = defaultInitialRetryDelay;
        long l1 = (long)((double)defaultInitialRetryDelay * Math.random());
        if (cu1 != null)
        {
            cu1.a(new ct() {

                final ParseRequest this$0;
                final ParseHttpRequest val$request;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public Void then(cu cu2)
                    throws Exception
                {
                    request.cancel();
                    return null;
                }

            
            {
                this$0 = ParseRequest.this;
                request = parsehttprequest;
                super();
            }
            });
        }
        return executeAsync(parsehttpclient, request, 0, l + l1, progresscallback, cu1);
    }

    public static ParseHttpClient getDefaultClient()
    {
        if (defaultClient == null)
        {
            throw new IllegalStateException("Can't send Parse HTTPS request before Parse.initialize()");
        } else
        {
            return defaultClient;
        }
    }

    public static long getDefaultInitialRetryDelay()
    {
        return defaultInitialRetryDelay;
    }

    private static ThreadPoolExecutor newThreadPoolExecutor(int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue, ThreadFactory threadfactory)
    {
        timeunit = new ThreadPoolExecutor(i, j, l, timeunit, blockingqueue, threadfactory);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            timeunit.allowCoreThreadTimeOut(true);
        }
        return timeunit;
    }

    private cu sendOneRequestAsync(final ParseHttpClient client, final ParseHttpRequest request, final ProgressCallback downloadProgressCallback)
    {
        return cu.a(null).d(new ct() {

            final ParseRequest this$0;
            final ParseHttpClient val$client;
            final ProgressCallback val$downloadProgressCallback;
            final ParseHttpRequest val$request;

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = client.execute(request);
                return onResponseAsync(cu1, downloadProgressCallback);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseRequest.this;
                client = parsehttpclient;
                request = parsehttprequest;
                downloadProgressCallback = progresscallback;
                super();
            }
        }, NETWORK_EXECUTOR).b(new ct() {

            final ParseRequest this$0;

            public cu then(cu cu1)
                throws Exception
            {
                cu cu2 = cu1;
                if (cu1.d())
                {
                    Exception exception = cu1.f();
                    if (exception instanceof ClientProtocolException)
                    {
                        cu2 = cu.a(newTemporaryException("bad protocol", exception));
                    } else
                    {
                        cu2 = cu1;
                        if (exception instanceof IOException)
                        {
                            return cu.a(newTemporaryException("i/o failure", exception));
                        }
                    }
                }
                return cu2;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseRequest.this;
                super();
            }
        }, cu.a);
    }

    public static void setDefaultClient(ParseHttpClient parsehttpclient)
    {
        defaultClient = parsehttpclient;
    }

    public static void setDefaultInitialRetryDelay(long l)
    {
        defaultInitialRetryDelay = l;
    }

    public cu executeAsync()
    {
        return executeAsync(getDefaultClient());
    }

    public cu executeAsync(cu cu1)
    {
        return executeAsync(getDefaultClient(), (ProgressCallback)null, null, cu1);
    }

    public cu executeAsync(ParseHttpClient parsehttpclient)
    {
        return executeAsync(parsehttpclient, (ProgressCallback)null, null, null);
    }

    public cu executeAsync(ParseHttpClient parsehttpclient, cu cu1)
    {
        return executeAsync(parsehttpclient, (ProgressCallback)null, null, cu1);
    }

    public cu executeAsync(ParseHttpClient parsehttpclient, ProgressCallback progresscallback, ProgressCallback progresscallback1)
    {
        return executeAsync(parsehttpclient, progresscallback, progresscallback1, null);
    }

    public cu executeAsync(ParseHttpClient parsehttpclient, ProgressCallback progresscallback, ProgressCallback progresscallback1, cu cu1)
    {
        return executeAsync(parsehttpclient, newRequest(method, url, progresscallback), progresscallback1, cu1);
    }

    public cu executeAsync(ProgressCallback progresscallback, ProgressCallback progresscallback1, cu cu1)
    {
        return executeAsync(getDefaultClient(), progresscallback, progresscallback1, cu1);
    }

    protected ParseHttpBody newBody(ProgressCallback progresscallback)
    {
        return null;
    }

    protected ParseException newPermanentException(int i, String s)
    {
        s = new ParseRequestException(i, s);
        s.isPermanentFailure = true;
        return s;
    }

    protected ParseHttpRequest newRequest(Method method1, String s, ProgressCallback progresscallback)
    {
        s = (new ParseHttpRequest.Builder()).setMethod(method1).setUrl(s);
        switch (_cls6..SwitchMap.com.parse.ParseRequest.Method[method1.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid method ").append(method1).toString());

        case 2: // '\002'
        case 3: // '\003'
            s.setBody(newBody(progresscallback));
            // fall through

        case 1: // '\001'
        case 4: // '\004'
            return s.build();
        }
    }

    protected ParseException newTemporaryException(int i, String s)
    {
        s = new ParseRequestException(i, s);
        s.isPermanentFailure = false;
        return s;
    }

    protected ParseException newTemporaryException(String s, Throwable throwable)
    {
        s = new ParseRequestException(100, s, throwable);
        s.isPermanentFailure = false;
        return s;
    }

    protected abstract cu onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback);

    public void setMaxRetries(int i)
    {
        maxRetries = i;
    }

    static 
    {
        sThreadFactory = new ThreadFactory() {

            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("ParseRequest.NETWORK_EXECUTOR-thread-").append(mCount.getAndIncrement()).toString());
            }

        };
        CPU_COUNT = Runtime.getRuntime().availableProcessors();
        CORE_POOL_SIZE = CPU_COUNT * 2 + 1;
        MAX_POOL_SIZE = CPU_COUNT * 2 * 2 + 1;
        NETWORK_EXECUTOR = newThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), sThreadFactory);
    }


}
