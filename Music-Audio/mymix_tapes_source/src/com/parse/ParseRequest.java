// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import bolts.Continuation;
import bolts.Task;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

// Referenced classes of package com.parse:
//            ParseException, ProgressCallback, Parse

abstract class ParseRequest
{
    public static interface Method
    {

        public static final int GET = 0;
        public static final int POST = 1;
    }


    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    protected static final int DEFAULT_MAX_RETRIES = 4;
    private static final long KEEP_ALIVE_TIME = 1L;
    private static final int MAX_POOL_SIZE;
    private static final int MAX_QUEUE_SIZE = 128;
    static final ExecutorService NETWORK_EXECUTOR;
    private static final int SOCKET_OPERATION_TIMEOUT = 10000;
    private static volatile String UserAgent;
    private static HttpClient defaultClient = null;
    private static long defaultInitialRetryDelay = 1000L;
    private static final ThreadFactory sThreadFactory;
    private HttpClient client;
    private AtomicReference currentTask;
    protected int maxRetries;
    protected int method;
    private HttpUriRequest request;
    protected String url;

    public ParseRequest(int i, String s)
    {
        maxRetries = 4;
        currentTask = new AtomicReference();
        client = defaultClient;
        method = i;
        url = s;
    }

    public ParseRequest(String s)
    {
        this(0, s);
    }

    private Task executeAsync(final int attemptsMade, final long delay, final ProgressCallback progressCallback)
    {
        return sendOneRequestAsync(progressCallback).continueWithTask(new Continuation() {

            final ParseRequest this$0;
            final int val$attemptsMade;
            final long val$delay;
            final ProgressCallback val$progressCallback;

            public Task then(Task task)
                throws Exception
            {
                Task task1 = task;
                if (task.isFaulted())
                {
                    task1 = task;
                    if (task.getError() instanceof ParseException)
                    {
                        if (((bolts.Task.TaskCompletionSource)currentTask.get()).getTask().isCancelled())
                        {
                            task1 = Task.cancelled();
                        } else
                        {
                            if (attemptsMade < maxRetries)
                            {
                                Parse.logI("com.parse.ParseRequest", (new StringBuilder()).append("Request failed. Waiting ").append(delay).append(" milliseconds before attempt #").append(attemptsMade + 1).toString());
                                task = Task.create();
                                Parse.getScheduledExecutor().schedule(task. new Runnable() {

                                    final _cls8 this$1;
                                    final bolts.Task.TaskCompletionSource val$retryTask;

                                    public void run()
                                    {
                                        executeAsync(attemptsMade + 1, delay * 2L, progressCallback).continueWithTask(new Continuation() {

                                            final _cls1 this$2;

                                            public Task then(Task task)
                                                throws Exception
                                            {
                                                if (task.isCancelled())
                                                {
                                                    retryTask.setCancelled();
                                                } else
                                                if (task.isFaulted())
                                                {
                                                    retryTask.setError(task.getError());
                                                } else
                                                {
                                                    retryTask.setResult(task.getResult());
                                                }
                                                return null;
                                            }

                                            public volatile Object then(Task task)
                                                throws Exception
                                            {
                                                return then(task);
                                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                        });
                                    }

            
            {
                this$1 = final__pcls8;
                retryTask = bolts.Task.TaskCompletionSource.this;
                super();
            }
                                }, delay, TimeUnit.MILLISECONDS);
                                return task.getTask();
                            }
                            task1 = task;
                            if (!request.isAborted())
                            {
                                Parse.logI("com.parse.ParseRequest", "Request failed. Giving up.");
                                return task;
                            }
                        }
                    }
                }
                return task1;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseRequest.this;
                attemptsMade = i;
                delay = l;
                progressCallback = progresscallback;
                super();
            }
        });
    }

    public static HttpClient getDefaultClient()
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

    private static String getUserAgent(Context context)
    {
        if (UserAgent == null)
        {
            String s = "unknown";
            try
            {
                String s1 = context.getPackageName();
                int i = context.getPackageManager().getPackageInfo(s1, 0).versionCode;
                context = (new StringBuilder()).append(s1).append("/").append(i).toString();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = s;
            }
            UserAgent = (new StringBuilder()).append("Parse Android SDK 1.8.0 (").append(context).append(") API Level ").append(android.os.Build.VERSION.SDK_INT).toString();
        }
        return UserAgent;
    }

    public static void initialize(Context context)
    {
        if (defaultClient == null)
        {
            defaultClient = newHttpClient(context);
        }
    }

    private static HttpClient newHttpClient(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context passed to newHttpClient should not be null.");
        }
        Object obj = context.getApplicationContext();
        context = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(context, false);
        HttpConnectionParams.setConnectionTimeout(context, 10000);
        HttpConnectionParams.setSoTimeout(context, 10000);
        HttpConnectionParams.setSocketBufferSize(context, 8192);
        HttpClientParams.setRedirecting(context, false);
        Object obj1 = new SSLSessionCache(((Context) (obj)));
        HttpProtocolParams.setUserAgent(context, getUserAgent(((Context) (obj))));
        obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) (obj)).register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(10000, ((SSLSessionCache) (obj1))), 443));
        ConnManagerParams.setMaxConnectionsPerRoute(context, new ConnPerRouteBean(20));
        ConnManagerParams.setMaxTotalConnections(context, 20);
        obj1 = System.getProperty("http.proxyHost");
        String s = System.getProperty("http.proxyPort");
        if (obj1 != null && ((String) (obj1)).length() != 0 && s != null && s.length() != 0)
        {
            context.setParameter("http.route.default-proxy", new HttpHost(((String) (obj1)), Integer.parseInt(s), "http"));
        }
        return new DefaultHttpClient(new ThreadSafeClientConnManager(context, ((SchemeRegistry) (obj))), context);
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

    private Task sendOneRequestAsync(final ProgressCallback progressCallback)
    {
        if (((bolts.Task.TaskCompletionSource)currentTask.get()).getTask().isCancelled())
        {
            return Task.cancelled();
        } else
        {
            return Task.call(new Callable() {

                final ParseRequest this$0;
                final ProgressCallback val$progressCallback;

                public Object call()
                    throws Exception
                {
                    Object obj;
                    try
                    {
                        obj = client.execute(request);
                        obj = onResponse(((HttpResponse) (obj)), progressCallback);
                    }
                    catch (ClientProtocolException clientprotocolexception)
                    {
                        throw connectionFailed("bad protocol", clientprotocolexception);
                    }
                    catch (IOException ioexception)
                    {
                        throw connectionFailed("i/o failure", ioexception);
                    }
                    return obj;
                }

            
            {
                this$0 = ParseRequest.this;
                progressCallback = progresscallback;
                super();
            }
            }, NETWORK_EXECUTOR).continueWithTask(new Continuation() {

                final ParseRequest this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseRequest.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
    }

    public static void setDefaultClient(HttpClient httpclient)
    {
        defaultClient = httpclient;
    }

    public static void setDefaultInitialRetryDelay(long l)
    {
        defaultInitialRetryDelay = l;
    }

    public void cancel()
    {
        bolts.Task.TaskCompletionSource taskcompletionsource = (bolts.Task.TaskCompletionSource)currentTask.get();
        if (taskcompletionsource != null)
        {
            taskcompletionsource.trySetCancelled();
        }
        if (request != null)
        {
            request.abort();
        }
    }

    protected ParseException connectionFailed(String s, Exception exception)
    {
        return new ParseException(100, (new StringBuilder()).append(s).append(": ").append(exception.getClass().getName()).append(": ").append(exception.getMessage()).toString());
    }

    public Task executeAsync()
    {
        return executeAsync(null);
    }

    public Task executeAsync(final ProgressCallback progressCallback)
    {
        final bolts.Task.TaskCompletionSource tcs = Task.create();
        currentTask.set(tcs);
        Task.forResult(null).continueWithTask(new Continuation() {

            final ParseRequest this$0;

            public Task then(Task task)
                throws Exception
            {
                return onPreExecute(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseRequest.this;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseRequest this$0;
            final ProgressCallback val$progressCallback;

            public Task then(Task task)
                throws Exception
            {
                long l = ParseRequest.defaultInitialRetryDelay;
                long l1 = (long)((double)ParseRequest.defaultInitialRetryDelay * Math.random());
                if (request == null)
                {
                    request = newRequest();
                }
                return executeAsync(0, l + l1, progressCallback);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseRequest.this;
                progressCallback = progresscallback;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParseRequest this$0;

            public Task then(Task task)
                throws Exception
            {
                return onPostExecute(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseRequest.this;
                super();
            }
        }).continueWithTask(new Continuation() {

            final ParseRequest this$0;
            final bolts.Task.TaskCompletionSource val$tcs;

            public Task then(Task task)
                throws Exception
            {
                if (task.isCancelled())
                {
                    tcs.trySetCancelled();
                } else
                if (task.isFaulted())
                {
                    tcs.trySetError(task.getError());
                } else
                {
                    tcs.trySetResult(task.getResult());
                }
                return null;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseRequest.this;
                tcs = taskcompletionsource;
                super();
            }
        });
        return tcs.getTask();
    }

    protected HttpEntity newEntity()
    {
        return null;
    }

    protected HttpUriRequest newRequest()
        throws ParseException
    {
        Object obj;
        if (method == 0)
        {
            obj = new HttpGet(url);
        } else
        if (method == 1)
        {
            HttpPost httppost = null;
            obj = httppost;
            if (url.contains(".s3.amazonaws.com"))
            {
                Matcher matcher = Pattern.compile("^https://([a-zA-Z0-9.]*\\.s3\\.amazonaws\\.com)/?.*").matcher(url);
                obj = httppost;
                if (matcher.matches())
                {
                    obj = matcher.group(1);
                    url = url.replace(((CharSequence) (obj)), "s3.amazonaws.com");
                }
            }
            httppost = new HttpPost(url);
            httppost.setEntity(newEntity());
            if (obj != null)
            {
                httppost.addHeader("Host", ((String) (obj)));
            }
            obj = httppost;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Invalid method ").append(method).toString());
        }
        AndroidHttpClient.modifyRequestToAcceptGzipResponse(((org.apache.http.HttpRequest) (obj)));
        return ((HttpUriRequest) (obj));
    }

    protected Task onPostExecute(Task task)
        throws ParseException
    {
        return task.cast();
    }

    protected Task onPreExecute(Task task)
    {
        return null;
    }

    protected abstract Object onResponse(HttpResponse httpresponse, ProgressCallback progresscallback)
        throws IOException, ParseException;

    public void setClient(HttpClient httpclient)
    {
        client = httpclient;
    }

    public void setMaxRetries(int i)
    {
        maxRetries = i;
    }

    public void setMethod(int i)
    {
        method = i;
    }

    public void setUrl(String s)
    {
        url = s;
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



/*
    static HttpUriRequest access$002(ParseRequest parserequest, HttpUriRequest httpurirequest)
    {
        parserequest.request = httpurirequest;
        return httpurirequest;
    }

*/




}
