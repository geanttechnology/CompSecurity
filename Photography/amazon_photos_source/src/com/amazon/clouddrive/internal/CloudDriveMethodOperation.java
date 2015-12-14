// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.exceptions.ActionRequiredException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.internal.utils.Closer;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.clouddrive.internal:
//            AbstractCloudDriveOperation, CloudDriveObjectMapper, OperationFactory, SourceInfoGenerator

class CloudDriveMethodOperation extends AbstractCloudDriveOperation
{

    private final JsonDeserializer mDeserializer;
    private boolean mIsHeadRequest;
    private final String mLanguage;
    private final String mMethod;
    private final RequestPathGenerator.RequestPath mRequestPath;

    CloudDriveMethodOperation(OperationFactory operationfactory, ClientConfiguration clientconfiguration, AccountConfiguration accountconfiguration, SourceInfoGenerator sourceinfogenerator, String s, RequestPathGenerator.RequestPath requestpath, JsonDeserializer jsondeserializer, 
            String s1, MetricListener metriclistener, Class class1)
    {
        this(operationfactory, clientconfiguration, accountconfiguration, sourceinfogenerator, s, requestpath, jsondeserializer, s1, metriclistener, class1, null);
    }

    CloudDriveMethodOperation(OperationFactory operationfactory, ClientConfiguration clientconfiguration, AccountConfiguration accountconfiguration, SourceInfoGenerator sourceinfogenerator, String s, RequestPathGenerator.RequestPath requestpath, JsonDeserializer jsondeserializer, 
            String s1, MetricListener metriclistener, Class class1, String s2)
    {
        super(operationfactory, clientconfiguration, accountconfiguration, sourceinfogenerator, s1, metriclistener, class1);
        mIsHeadRequest = false;
        mMethod = s;
        mRequestPath = requestpath;
        mDeserializer = jsondeserializer;
        mLanguage = s2;
    }

    public final Object retryCall()
        throws CloudDriveException, InterruptedException
    {
        Object obj;
        Object obj1;
        HttpURLConnection httpurlconnection1;
        java.io.InputStream inputstream;
        HttpURLConnection httpurlconnection2;
        java.io.InputStream inputstream1;
        java.io.InputStream inputstream2;
        Object obj3;
        Object obj4;
        obj = null;
        httpurlconnection2 = null;
        httpurlconnection1 = null;
        obj3 = null;
        obj4 = null;
        inputstream2 = null;
        inputstream = inputstream2;
        obj1 = obj3;
        inputstream1 = obj4;
        HttpURLConnection httpurlconnection = setUpConnection(new URL(mRequestPath.getPath()));
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        httpurlconnection.setRequestMethod(mMethod);
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        if (!mIsHeadRequest)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        httpurlconnection.addRequestProperty("Accept-Encoding", "");
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        if (mLanguage == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        httpurlconnection.addRequestProperty("Accept-Language", mLanguage);
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        httpurlconnection.connect();
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        assertSuccessResponseCode(httpurlconnection);
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        JsonDeserializer jsondeserializer = mDeserializer;
        if (jsondeserializer != null) goto _L2; else goto _L1
_L1:
        obj1 = null;
        Closer.closeQuietly(null);
        obj = obj1;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            obj = obj1;
        }
_L4:
        return obj;
_L2:
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = obj4;
        inputstream2 = httpurlconnection.getInputStream();
        httpurlconnection1 = httpurlconnection;
        inputstream = inputstream2;
        obj = httpurlconnection;
        obj1 = inputstream2;
        httpurlconnection2 = httpurlconnection;
        inputstream1 = inputstream2;
        obj3 = CloudDriveObjectMapper.readStream(inputstream2, mDeserializer);
        obj1 = obj3;
        Closer.closeQuietly(inputstream2);
        obj = obj1;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            return obj1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        obj = httpurlconnection1;
        obj1 = inputstream;
        throw new InterruptedException();
        Object obj2;
        obj2;
        Closer.closeQuietly(((java.io.Closeable) (obj1)));
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw obj2;
        obj2;
        obj = httpurlconnection2;
        obj1 = inputstream1;
        throw new ActionRequiredException("Failure in creating a connection", ((Throwable) (obj2)));
    }
}
