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
import com.amazon.clouddrive.exceptions.SystemFault;
import com.amazon.clouddrive.handlers.ProgressListener;
import com.amazon.clouddrive.internal.utils.Closer;
import com.amazon.clouddrive.internal.utils.StreamUtil;
import com.amazon.clouddrive.metrics.MetricListener;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.amazon.clouddrive.internal:
//            AbstractCloudDriveOperation, ProgressInputStream, AmazonCloudDriveLog, OperationFactory, 
//            SourceInfoGenerator

class DownloadFileOperation extends AbstractCloudDriveOperation
{

    private final int mBlockSize;
    private final OutputStream mOutputStream;
    private final ProgressListener mProgressListener;
    private final RequestPathGenerator.RequestPath mRequestPath;

    DownloadFileOperation(OperationFactory operationfactory, ClientConfiguration clientconfiguration, AccountConfiguration accountconfiguration, SourceInfoGenerator sourceinfogenerator, RequestPathGenerator.RequestPath requestpath, String s, MetricListener metriclistener, 
            ProgressListener progresslistener, Class class1, OutputStream outputstream, int i)
    {
        super(operationfactory, clientconfiguration, accountconfiguration, sourceinfogenerator, s, metriclistener, class1);
        mRequestPath = requestpath;
        mProgressListener = progresslistener;
        mOutputStream = outputstream;
        mBlockSize = i;
    }

    public volatile Object retryCall()
        throws CloudDriveException, InterruptedException
    {
        return retryCall();
    }

    public final Void retryCall()
        throws CloudDriveException, InterruptedException
    {
        Object obj1;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        obj5 = null;
        obj6 = null;
        obj7 = null;
        obj1 = null;
        obj4 = null;
        obj10 = null;
        obj8 = null;
        obj9 = null;
        obj3 = obj4;
        Object obj = setUpConnection(new URL(mRequestPath.getPath()));
        obj1 = obj;
        obj3 = obj4;
        obj5 = obj;
        obj6 = obj;
        obj7 = obj;
        ((HttpURLConnection) (obj)).connect();
        obj1 = obj;
        obj3 = obj4;
        obj5 = obj;
        obj6 = obj;
        obj7 = obj;
        assertSuccessResponseCode(((HttpURLConnection) (obj)));
        long l1;
        l1 = -1L;
        obj1 = obj;
        obj3 = obj4;
        obj5 = obj;
        obj6 = obj;
        obj7 = obj;
        String s = ((HttpURLConnection) (obj)).getHeaderField("Content-Length");
        long l;
        l = l1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        obj1 = obj;
        obj3 = obj4;
        obj5 = obj;
        obj6 = obj;
        obj7 = obj;
        l = Long.parseLong(s);
_L3:
        obj1 = obj;
        obj3 = obj4;
        obj5 = obj;
        obj6 = obj;
        obj7 = obj;
        obj4 = new ProgressInputStream(((HttpURLConnection) (obj)).getInputStream(), l, mProgressListener);
        l1 = StreamUtil.copyInputStreamToOutputStream(((java.io.InputStream) (obj4)), mOutputStream, mBlockSize, l);
        if (l1 == l) goto _L2; else goto _L1
_L1:
        throw new SystemFault((new StringBuilder()).append("Expected Content-Length [").append(l).append("] did not match bytes read [").append(l1).append("]").toString());
        obj1;
        obj3 = obj4;
_L4:
        obj1 = obj;
        throw new RebuildRequestException("Request requires new OutputStream instance to continue.");
        obj4;
        obj = obj1;
_L5:
        Closer.closeQuietly(((java.io.Closeable) (obj3)));
        Closer.closeQuietly(mOutputStream);
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw obj4;
        NumberFormatException numberformatexception;
        numberformatexception;
        obj1 = obj;
        obj3 = obj4;
        obj5 = obj;
        obj6 = obj;
        obj7 = obj;
        AmazonCloudDriveLog.w("Exception thrown while parsing the \"Content-Length\" header.", numberformatexception);
        l = l1;
          goto _L3
        obj;
        obj = obj5;
        obj3 = obj9;
          goto _L4
_L2:
        Closer.closeQuietly(((java.io.Closeable) (obj4)));
        Closer.closeQuietly(mOutputStream);
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        return null;
        obj;
        obj3 = obj10;
        obj = obj6;
_L7:
        obj1 = obj;
        throw new InterruptedException();
_L6:
        obj1 = obj;
        throw new ActionRequiredException("Failure in creating a connection", ((Throwable) (obj4)));
        Object obj2;
        obj2;
        obj3 = obj4;
        obj4 = obj2;
          goto _L5
        obj2;
        obj3 = obj4;
        obj4 = obj2;
          goto _L6
        obj2;
        obj3 = obj4;
          goto _L7
        obj4;
        obj = obj7;
        obj3 = obj8;
          goto _L6
    }
}
