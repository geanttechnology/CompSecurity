// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.ExponentialBackoffHelper;
import com.amazon.identity.platform.metric.MetricUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            WrappableHttpURLConnection, HttpURLConnectionBuilder, ResetableHttpURLConnection, RetryLogic, 
//            Tracer

class RetryableHttpURLConnection extends WrappableHttpURLConnection
{

    private static final int FIRST_RETRY_INTERVAL;
    private static final int MAX_INTERVAL;
    private static final String TAG = com/amazon/identity/auth/device/framework/RetryableHttpURLConnection.getName();
    private final Context mContext;
    private final ExponentialBackoffHelper mExpBackoffHelper;
    private final HttpURLConnectionBuilder mHttpUrlConnectionBuilder;
    private final RetryLogic mRetryLogic;
    private final Tracer mTracer;

    RetryableHttpURLConnection(HttpURLConnectionBuilder httpurlconnectionbuilder, RetryLogic retrylogic, Tracer tracer, Context context)
    {
        super(httpurlconnectionbuilder.getURL());
        mHttpUrlConnectionBuilder = httpurlconnectionbuilder;
        mRetryLogic = retrylogic;
        mExpBackoffHelper = new ExponentialBackoffHelper(FIRST_RETRY_INTERVAL, MAX_INTERVAL);
        mTracer = tracer;
        mContext = context;
    }

    RetryableHttpURLConnection(URL url, RetryLogic retrylogic, Tracer tracer, Context context)
        throws IOException
    {
        this(new HttpURLConnectionBuilder(url), retrylogic, tracer, context);
    }

    public void addRequestProperty(String s, String s1)
    {
        mHttpUrlConnectionBuilder.addRequestProperty(s, s1);
    }

    public boolean getAllowUserInteraction()
    {
        return mHttpUrlConnectionBuilder.getAllowUserInteraction();
    }

    public int getConnectTimeout()
    {
        return mHttpUrlConnectionBuilder.getConnectTimeout();
    }

    public boolean getDefaultUseCaches()
    {
        return mHttpUrlConnectionBuilder.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return mHttpUrlConnectionBuilder.getDoInput();
    }

    public boolean getDoOutput()
    {
        return mHttpUrlConnectionBuilder.getDoOutput();
    }

    public long getIfModifiedSince()
    {
        return mHttpUrlConnectionBuilder.getIfModifiedSince();
    }

    public boolean getInstanceFollowRedirects()
    {
        return mHttpUrlConnectionBuilder.getInstanceFollowRedirects();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return mHttpUrlConnectionBuilder.getOutputStream();
    }

    public int getReadTimeout()
    {
        return mHttpUrlConnectionBuilder.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return mHttpUrlConnectionBuilder.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return mHttpUrlConnectionBuilder.getRequestProperties();
    }

    public String getRequestProperty(String s)
    {
        return mHttpUrlConnectionBuilder.getRequestProperty(s);
    }

    public URL getURL()
    {
        return mHttpUrlConnectionBuilder.getURL();
    }

    public boolean getUseCaches()
    {
        return mHttpUrlConnectionBuilder.getUseCaches();
    }

    protected HttpURLConnection performOnConnectionRequested()
        throws IOException
    {
        do
        {
            Object obj;
            try
            {
                obj = new ResetableHttpURLConnection(mHttpUrlConnectionBuilder.createConnection());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                mTracer.incrementCounter(MetricUtils.getIOExceptionMetricName(url));
                mTracer.incrementCounter(MetricUtils.getIOExceptionWithSubClassMetricName(url, ((IOException) (obj)), mContext));
                throw obj;
            }
            if (!mRetryLogic.shouldRetry(((HttpURLConnection) (obj)), mExpBackoffHelper.numberOfRetryAttempts(), mTracer))
            {
                return ((HttpURLConnection) (obj));
            }
            ((HttpURLConnection) (obj)).disconnect();
            int i = mExpBackoffHelper.nextRetryInterval();
            MAPLog.e(TAG, String.format("Connection failed. We will attempt to the %d retry", new Object[] {
                Integer.valueOf(mExpBackoffHelper.numberOfRetryAttempts())
            }));
            long l = i;
            try
            {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedexception)
            {
                MAPLog.w(TAG, "Backoff wait interrupted", interruptedexception);
            }
        } while (mExpBackoffHelper.numberOfRetryAttempts() < 3);
        MAPLog.e(TAG, "All retries failed. Aborting request");
        mTracer.incrementCounter(MetricUtils.getRetriesFailedMetricName(((HttpURLConnection) (obj)).getURL()));
        throw new IOException("Could not get a connection");
    }

    public void setAllowUserInteraction(boolean flag)
    {
        mHttpUrlConnectionBuilder.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        mHttpUrlConnectionBuilder.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i)
    {
        mHttpUrlConnectionBuilder.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        mHttpUrlConnectionBuilder.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        mHttpUrlConnectionBuilder.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
    {
        mHttpUrlConnectionBuilder.setDoOutput(flag);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        mHttpUrlConnectionBuilder.setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        mHttpUrlConnectionBuilder.setFixedLengthStreamingMode(l);
    }

    public void setIfModifiedSince(long l)
    {
        mHttpUrlConnectionBuilder.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        mHttpUrlConnectionBuilder.setInstanceFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        mHttpUrlConnectionBuilder.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        mHttpUrlConnectionBuilder.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        mHttpUrlConnectionBuilder.setRequestProperty(s, s1);
    }

    public void setUseCaches(boolean flag)
    {
        mHttpUrlConnectionBuilder.setUseCaches(flag);
    }

    public String toString()
    {
        return mHttpUrlConnectionBuilder.toString();
    }

    public boolean usingProxy()
    {
        return mHttpUrlConnectionBuilder.usingProxy();
    }

    static 
    {
        FIRST_RETRY_INTERVAL = (int)TimeUnit.MILLISECONDS.convert(1L, TimeUnit.SECONDS);
        MAX_INTERVAL = (int)TimeUnit.MILLISECONDS.convert(10L, TimeUnit.SECONDS);
    }
}
