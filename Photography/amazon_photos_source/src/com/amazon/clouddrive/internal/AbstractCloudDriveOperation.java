// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.auth.AuthenticatedURLConnectionFactory;
import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.NoRetryException;
import com.amazon.clouddrive.internal.utils.Closer;
import com.amazon.clouddrive.metrics.MetricEvent;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.clouddrive.model.GetAccountEndpointRequest;
import com.amazon.clouddrive.model.SetupSourceRequest;
import com.amazon.clouddrive.utils.Optional;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.clouddrive.internal:
//            CloudDriveOperation, SourceInfoGenerator, BasicSourceInfo, ErrorDeserializer, 
//            OperationFactory, BackoffWaitTime, AmazonCloudDriveLog

abstract class AbstractCloudDriveOperation
    implements CloudDriveOperation
{

    private static final AtomicBoolean SKIP_SETUP_SOURCE = new AtomicBoolean(false);
    private final AccountConfiguration mAccountConfiguration;
    private final ClientConfiguration mConfiguration;
    private final String mMetricId;
    private final MetricListener mMetricListener;
    private final OperationFactory mOperationFactory;
    private final Class mRequestClass;
    private final SourceInfoGenerator mSourceInfoGenerator;

    protected AbstractCloudDriveOperation(OperationFactory operationfactory, ClientConfiguration clientconfiguration, AccountConfiguration accountconfiguration, SourceInfoGenerator sourceinfogenerator, String s, MetricListener metriclistener, Class class1)
    {
        mOperationFactory = operationfactory;
        mConfiguration = clientconfiguration;
        mAccountConfiguration = accountconfiguration;
        mSourceInfoGenerator = sourceinfogenerator;
        mMetricId = s;
        mMetricListener = metriclistener;
        mRequestClass = class1;
    }

    private void initializeSourceInfo(HttpURLConnection httpurlconnection)
    {
        if (shouldUseSourceInfo(mRequestClass)) goto _L2; else goto _L1
_L1:
        BasicSourceInfo basicsourceinfo;
        return;
_L2:
        if ((basicsourceinfo = mSourceInfoGenerator.createSourceInfo()) == null) goto _L1; else goto _L3
_L3:
        if (basicsourceinfo.getSourceId() == null) goto _L1; else goto _L4
_L4:
        httpurlconnection.addRequestProperty("x-amzn-clouddrive-source", basicsourceinfo.getSourceId());
        return;
        httpurlconnection;
        SKIP_SETUP_SOURCE.set(true);
        return;
        httpurlconnection;
        SKIP_SETUP_SOURCE.set(true);
        return;
    }

    private void notifyMetricListener(long l, int i, CloudDriveException clouddriveexception)
    {
        if (mMetricListener != null)
        {
            long l1 = System.currentTimeMillis();
            mMetricListener.onMetricEvent(new MetricEvent(mMetricId, l1 - l, i, clouddriveexception));
        }
    }

    private boolean shouldUseSourceInfo(Class class1)
    {
        return !SKIP_SETUP_SOURCE.get() && class1 != com/amazon/clouddrive/model/SetupSourceRequest && class1 != com/amazon/clouddrive/model/GetAccountEndpointRequest;
    }

    protected final void assertSuccessResponseCode(HttpURLConnection httpurlconnection)
        throws CloudDriveException
    {
        assertSuccessResponseCodeWithTimer(httpurlconnection, Optional.absent());
    }

    protected final void assertSuccessResponseCodeWithTimer(HttpURLConnection httpurlconnection, Optional optional)
        throws CloudDriveException
    {
        HttpURLConnection httpurlconnection1;
        HttpURLConnection httpurlconnection2;
        Object obj;
        Object obj1;
        long l;
        long l1;
        long l2;
        long l3;
        l2 = -1L;
        l3 = System.currentTimeMillis();
        obj1 = null;
        obj = null;
        httpurlconnection1 = obj;
        l1 = l2;
        httpurlconnection2 = obj1;
        l = l2;
        int i = httpurlconnection.getResponseCode();
        httpurlconnection1 = obj;
        l1 = l2;
        httpurlconnection2 = obj1;
        l = l2;
        l2 = System.currentTimeMillis();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        httpurlconnection1 = obj;
        l1 = l2;
        httpurlconnection2 = obj1;
        l = l2;
        httpurlconnection = httpurlconnection.getErrorStream();
        httpurlconnection1 = httpurlconnection;
        l1 = l2;
        httpurlconnection2 = httpurlconnection;
        l = l2;
        try
        {
            throw ErrorDeserializer.getCloudDriveException(httpurlconnection, i);
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            httpurlconnection2 = httpurlconnection1;
        }
        finally
        {
            Closer.closeQuietly(httpurlconnection2);
        }
        l = l1;
        throw new NoRetryException("Failed to read response code from the connection.");
        if (optional.isPresent() && mMetricListener != null)
        {
            if (l <= 0L)
            {
                l = System.currentTimeMillis();
            }
            mMetricListener.onMetricEvent(new MetricEvent((String)optional.get(), l - l3, 0, null));
        }
        throw httpurlconnection;
        Closer.closeQuietly(null);
        if (optional.isPresent() && mMetricListener != null)
        {
            if (l2 <= 0L)
            {
                l2 = System.currentTimeMillis();
            }
            mMetricListener.onMetricEvent(new MetricEvent((String)optional.get(), l2 - l3, 0, null));
        }
        return;
    }

    public final Object call()
        throws CloudDriveException, InterruptedException
    {
        int i;
        boolean flag;
        long l;
        l = mOperationFactory.getOperationDelay();
        if (l > 0L)
        {
            Thread.sleep(l);
        }
        l = System.currentTimeMillis();
        flag = true;
        i = 0;
_L3:
        Object obj;
        obj = retryCall();
        BackoffWaitTime.addSuccess(mRequestClass);
        notifyMetricListener(l, i, null);
        return obj;
        Object obj1;
        obj1;
        flag = false;
_L1:
        int j;
        if (flag && i < mConfiguration.getMaxErrorRetry() - 1)
        {
            AmazonCloudDriveLog.w((new StringBuilder()).append("Failure occurred. Retrying request ").append(mRequestClass).toString(), ((Throwable) (obj1)));
        }
        if (flag)
        {
            try
            {
                Thread.sleep(BackoffWaitTime.getNextWaitTime(i, mRequestClass));
            }
            catch (InterruptedException interruptedexception)
            {
                notifyMetricListener(l, i, ((CloudDriveException) (obj1)));
                throw interruptedexception;
            }
        }
        j = i + 1;
        if (i >= mConfiguration.getMaxErrorRetry() || !flag)
        {
            notifyMetricListener(l, j - 1, ((CloudDriveException) (obj1)));
            throw obj1;
        }
        break MISSING_BLOCK_LABEL_166;
        obj1;
          goto _L1
        i = j;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected String createUserAgentString()
    {
        return (new StringBuilder()).append("android-sdk/1.1.0 ").append(mConfiguration.getUserAgent()).toString();
    }

    protected abstract Object retryCall()
        throws CloudDriveException, InterruptedException;

    protected final HttpURLConnection setUpConnection(URL url)
        throws IOException, CloudDriveException, InterruptedException
    {
        url = mAccountConfiguration.getAuthenticatedURLConnectionFactory().createHttpURLConnection(url);
        url.setReadTimeout(mConfiguration.getReadTimeOutMillis());
        url.setConnectTimeout(mConfiguration.getConnectionTimeOutMillis());
        url.addRequestProperty("user-agent", createUserAgentString());
        initializeSourceInfo(url);
        return url;
    }

}
