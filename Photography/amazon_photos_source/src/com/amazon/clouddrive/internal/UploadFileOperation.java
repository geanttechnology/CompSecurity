// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.exceptions.ActionRequiredException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.RebuildRequestException;
import com.amazon.clouddrive.exceptions.RetryException;
import com.amazon.clouddrive.internal.utils.Closer;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.utils.Optional;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.clouddrive.internal:
//            AbstractCloudDriveOperation, BodyConnectionHelper, PostRequestWriter, CloudDriveObjectMapper, 
//            OperationFactory, SourceInfoGenerator

class UploadFileOperation extends AbstractCloudDriveOperation
{

    private JsonDeserializer mDeserializer;
    private String mMethod;
    private RequestPathGenerator.RequestPath mRequestPath;
    private final PostRequestWriter mRequestWriter;

    UploadFileOperation(OperationFactory operationfactory, ClientConfiguration clientconfiguration, AccountConfiguration accountconfiguration, SourceInfoGenerator sourceinfogenerator, PostRequestWriter postrequestwriter, JsonDeserializer jsondeserializer, RequestPathGenerator.RequestPath requestpath, 
            String s, MetricListener metriclistener, Class class1, String s1)
    {
        super(operationfactory, clientconfiguration, accountconfiguration, sourceinfogenerator, s, metriclistener, class1);
        mRequestWriter = postrequestwriter;
        mDeserializer = jsondeserializer;
        mRequestPath = requestpath;
        mMethod = s1;
    }

    public final Object retryCall()
        throws CloudDriveException, InterruptedException
    {
        Object obj;
        Object obj1;
        java.io.InputStream inputstream;
        HttpURLConnection httpurlconnection1;
        java.io.InputStream inputstream1;
        HttpURLConnection httpurlconnection2;
        java.io.InputStream inputstream2;
        HttpURLConnection httpurlconnection3;
        java.io.InputStream inputstream3;
        Object obj3;
        Object obj4;
        Object obj5;
        obj3 = null;
        obj4 = null;
        obj5 = null;
        inputstream = null;
        obj = null;
        httpurlconnection2 = null;
        httpurlconnection3 = null;
        httpurlconnection1 = null;
        inputstream1 = inputstream;
        obj1 = obj3;
        inputstream2 = obj4;
        inputstream3 = obj5;
        HttpURLConnection httpurlconnection = setUpConnection(new URL(mRequestPath.getPath()));
        httpurlconnection1 = httpurlconnection;
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = obj4;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = obj5;
        BodyConnectionHelper.setConnectionParameters(httpurlconnection, mMethod);
        httpurlconnection1 = httpurlconnection;
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = obj4;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = obj5;
        mRequestWriter.writeHeaders(httpurlconnection);
        httpurlconnection1 = httpurlconnection;
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = obj4;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = obj5;
        BodyConnectionHelper.addPostInput(httpurlconnection, mRequestWriter);
        httpurlconnection1 = httpurlconnection;
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = obj4;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = obj5;
        assertSuccessResponseCodeWithTimer(httpurlconnection, Optional.of("uploadFileResponse"));
        httpurlconnection1 = httpurlconnection;
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = obj4;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = obj5;
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
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = obj3;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = obj4;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = obj5;
        inputstream = httpurlconnection.getInputStream();
        httpurlconnection1 = httpurlconnection;
        inputstream1 = inputstream;
        obj = httpurlconnection;
        obj1 = inputstream;
        httpurlconnection2 = httpurlconnection;
        inputstream2 = inputstream;
        httpurlconnection3 = httpurlconnection;
        inputstream3 = inputstream;
        obj3 = CloudDriveObjectMapper.readStream(inputstream, mDeserializer);
        obj1 = obj3;
        Closer.closeQuietly(inputstream);
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
        obj1 = inputstream1;
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
        obj1 = inputstream2;
        throw new ActionRequiredException("Failure creating a connection", ((Throwable) (obj2)));
        RetryException retryexception;
        retryexception;
        retryexception = httpurlconnection3;
        obj1 = inputstream3;
        throw new RebuildRequestException("Request requires new OutputStream instance to continue.");
    }
}
