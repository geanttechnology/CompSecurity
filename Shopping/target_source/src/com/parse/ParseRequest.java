// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.parse:
//            ProgressCallback, ParseHttpClient, ParseException, PLog, 
//            ParseExecutors

abstract class ParseRequest
{
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
    com.parse.http.ParseHttpRequest.Method method;
    String url;

    public ParseRequest(com.parse.http.ParseHttpRequest.Method method1, String s)
    {
        maxRetries = 4;
        method = method1;
        url = s;
    }

    public ParseRequest(String s)
    {
        this(com.parse.http.ParseHttpRequest.Method.GET, s);
    }

    private j executeAsync(final ParseHttpClient client, final ParseHttpRequest request, final int attemptsMade, final long delay, final ProgressCallback downloadProgressCallback, final j cancellationToken)
    {
        if (cancellationToken != null && cancellationToken.c())
        {
            return j.h();
        } else
        {
            return sendOneRequestAsync(client, request, downloadProgressCallback).b(new i() {

                final ParseRequest this$0;
                final int val$attemptsMade;
                final j val$cancellationToken;
                final ParseHttpClient val$client;
                final long val$delay;
                final ProgressCallback val$downloadProgressCallback;
                final ParseHttpRequest val$request;

                public j then(j j1)
                    throws Exception
                {
                    j j2;
                    Exception exception;
                    exception = j1.f();
                    j2 = j1;
                    if (!j1.d()) goto _L2; else goto _L1
_L1:
                    j2 = j1;
                    if (!(exception instanceof ParseException)) goto _L2; else goto _L3
_L3:
                    if (cancellationToken == null || !cancellationToken.c()) goto _L5; else goto _L4
_L4:
                    j2 = j.h();
_L2:
                    return j2;
_L5:
                    if (!(exception instanceof ParseRequestException))
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    j2 = j1;
                    if (((ParseRequestException)exception).isPermanentFailure) goto _L2; else goto _L6
_L6:
                    j2 = j1;
                    if (attemptsMade < maxRetries)
                    {
                        com.parse.PLog.i("com.parse.ParseRequest", (new StringBuilder()).append("Request failed. Waiting ").append(delay).append(" milliseconds before attempt #").append(attemptsMade + 1).toString());
                        j1 = j.a();
                        ParseExecutors.scheduled().schedule(j1. new Runnable() {

                            final _cls4 this$1;
                            final a.j.a val$retryTask;

                            public void run()
                            {
                                executeAsync(client, request, attemptsMade + 1, delay * 2L, downloadProgressCallback, cancellationToken).b(new i() {

                                    final _cls1 this$2;

                                    public j then(j j1)
                                        throws Exception
                                    {
                                        if (j1.c())
                                        {
                                            retryTask.c();
                                        } else
                                        if (j1.d())
                                        {
                                            retryTask.b(j1.f());
                                        } else
                                        {
                                            retryTask.b(j1.e());
                                        }
                                        return null;
                                    }

                                    public volatile Object then(j j1)
                                        throws Exception
                                    {
                                        return then(j1);
                                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                });
                            }

            
            {
                this$1 = final__pcls4;
                retryTask = a.j.a.this;
                super();
            }
                        }, delay, TimeUnit.MILLISECONDS);
                        return j1.a();
                    }
                    if (true) goto _L2; else goto _L7
_L7:
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseRequest.this;
                cancellationToken = j1;
                attemptsMade = k;
                delay = l;
                client = parsehttpclient;
                request = parsehttprequest;
                downloadProgressCallback = progresscallback;
                super();
            }
            });
        }
    }

    private j executeAsync(ParseHttpClient parsehttpclient, ParseHttpRequest parsehttprequest, ProgressCallback progresscallback, j j1)
    {
        return executeAsync(parsehttpclient, parsehttprequest, 0, defaultInitialRetryDelay + (long)((double)defaultInitialRetryDelay * Math.random()), progresscallback, j1);
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

    private static ThreadPoolExecutor newThreadPoolExecutor(int i, int k, long l, TimeUnit timeunit, BlockingQueue blockingqueue, ThreadFactory threadfactory)
    {
        timeunit = new ThreadPoolExecutor(i, k, l, timeunit, blockingqueue, threadfactory);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            timeunit.allowCoreThreadTimeOut(true);
        }
        return timeunit;
    }

    private j sendOneRequestAsync(final ParseHttpClient client, final ParseHttpRequest request, final ProgressCallback downloadProgressCallback)
    {
        return j.a(null).d(new i() {

            final ParseRequest this$0;
            final ParseHttpClient val$client;
            final ProgressCallback val$downloadProgressCallback;
            final ParseHttpRequest val$request;

            public j then(j j1)
                throws Exception
            {
                j1 = client.execute(request);
                return onResponseAsync(j1, downloadProgressCallback);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseRequest.this;
                client = parsehttpclient;
                request = parsehttprequest;
                downloadProgressCallback = progresscallback;
                super();
            }
        }, NETWORK_EXECUTOR).b(new i() {

            final ParseRequest this$0;

            public j then(j j1)
                throws Exception
            {
                j j2 = j1;
                if (j1.d())
                {
                    Exception exception = j1.f();
                    j2 = j1;
                    if (exception instanceof IOException)
                    {
                        j2 = j.a(newTemporaryException("i/o failure", exception));
                    }
                }
                return j2;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseRequest.this;
                super();
            }
        }, j.a);
    }

    public static void setDefaultClient(ParseHttpClient parsehttpclient)
    {
        defaultClient = parsehttpclient;
    }

    public static void setDefaultInitialRetryDelay(long l)
    {
        defaultInitialRetryDelay = l;
    }

    public j executeAsync()
    {
        return executeAsync(getDefaultClient());
    }

    public j executeAsync(ParseHttpClient parsehttpclient)
    {
        return executeAsync(parsehttpclient, (ProgressCallback)null, null, null);
    }

    public j executeAsync(ParseHttpClient parsehttpclient, j j1)
    {
        return executeAsync(parsehttpclient, (ProgressCallback)null, null, j1);
    }

    public j executeAsync(ParseHttpClient parsehttpclient, ProgressCallback progresscallback, ProgressCallback progresscallback1)
    {
        return executeAsync(parsehttpclient, progresscallback, progresscallback1, null);
    }

    public j executeAsync(ParseHttpClient parsehttpclient, ProgressCallback progresscallback, ProgressCallback progresscallback1, j j1)
    {
        return executeAsync(parsehttpclient, newRequest(method, url, progresscallback), progresscallback1, j1);
    }

    public j executeAsync(ProgressCallback progresscallback, ProgressCallback progresscallback1, j j1)
    {
        return executeAsync(getDefaultClient(), progresscallback, progresscallback1, j1);
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

    protected ParseHttpRequest newRequest(com.parse.http.ParseHttpRequest.Method method1, String s, ProgressCallback progresscallback)
    {
        s = (new com.parse.http.ParseHttpRequest.Builder()).setMethod(method1).setUrl(s);
        static class _cls5
        {

            static final int $SwitchMap$com$parse$http$ParseHttpRequest$Method[];

            static 
            {
                $SwitchMap$com$parse$http$ParseHttpRequest$Method = new int[com.parse.http.ParseHttpRequest.Method.values().length];
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.DELETE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.POST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$http$ParseHttpRequest$Method[com.parse.http.ParseHttpRequest.Method.PUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5..SwitchMap.com.parse.http.ParseHttpRequest.Method[method1.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid method ").append(method1).toString());

        case 3: // '\003'
        case 4: // '\004'
            s.setBody(newBody(progresscallback));
            // fall through

        case 1: // '\001'
        case 2: // '\002'
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

    protected abstract j onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback);

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
