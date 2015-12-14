// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.ActionRequiredException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.InvalidParameter;
import com.amazon.clouddrive.exceptions.RebuildRequestException;
import com.amazon.clouddrive.handlers.ProgressListener;
import com.amazon.clouddrive.internal.utils.Closer;
import com.amazon.clouddrive.internal.utils.StreamUtil;
import com.amazon.clouddrive.internal.utils.ThreadUtil;
import com.amazon.clouddrive.model.UploadFileRequest;
import com.amazon.clouddrive.model.serializer.PostNodeRequestSerializer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.clouddrive.internal:
//            PostRequestWriter, RequestAssertUtils, MultiPartPostBodyWriterHelper, ProgressInputStream

class MultiPartPostBodyWriter
    implements PostRequestWriter
{

    private ByteArrayOutputStream mBodyAfterFileContents;
    private ByteArrayOutputStream mBodyBeforeFileContents;
    private final ProgressListener mProgressListener;
    private final UploadFileRequest mRequest;

    MultiPartPostBodyWriter(UploadFileRequest uploadfilerequest, ProgressListener progresslistener)
    {
        mRequest = uploadfilerequest;
        mProgressListener = progresslistener;
    }

    private void enableStreamingMode(HttpURLConnection httpurlconnection, long l, UploadFileRequest uploadfilerequest)
        throws InvalidParameter
    {
        if (mRequest.useChunkedStreaming())
        {
            httpurlconnection.setChunkedStreamingMode(mRequest.getChunkSize());
            httpurlconnection.setRequestProperty("Transfer-Encoding", "chunked");
            return;
        }
        if (l > 0x7fffffffL)
        {
            throw new InvalidParameter("The file is too large to be uploaded through the fixed length streaming mode. Use the chunked mode instead.");
        } else
        {
            httpurlconnection.setFixedLengthStreamingMode((int)l);
            return;
        }
    }

    public void writeHeaders(HttpURLConnection httpurlconnection)
        throws CloudDriveException, InterruptedException
    {
        RequestAssertUtils.assertNotNull(mRequest.getName(), "The file name is required when posting to Cloud Drive.");
        Object obj;
        boolean flag;
        long l;
        if (mRequest.getInputStream() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            httpurlconnection.addRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            httpurlconnection.addRequestProperty("Content-MD5", mRequest.getMD5());
            obj = (new MultiPartPostBodyWriterHelper.Builder()).withName(mRequest.getName()).addMetadata(mRequest, PostNodeRequestSerializer.INSTANCE);
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            throw new ActionRequiredException("Failed to write request to the service.", httpurlconnection);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        ((MultiPartPostBodyWriterHelper.Builder) (obj)).addContent();
        obj = ((MultiPartPostBodyWriterHelper.Builder) (obj)).build();
        mBodyBeforeFileContents = ((MultiPartPostBodyWriterHelper) (obj)).getBodyBeforeFileContents();
        mBodyAfterFileContents = ((MultiPartPostBodyWriterHelper) (obj)).getBodyAfterFileContents();
        l = mRequest.getContentLength() + (long)mBodyBeforeFileContents.size() + (long)mBodyAfterFileContents.size();
        enableStreamingMode(httpurlconnection, l, mRequest);
        httpurlconnection.setRequestProperty("Content-Length", Long.toString(l));
        return;
    }

    public void writeRequest(OutputStream outputstream)
        throws CloudDriveException, InterruptedException
    {
        RequestAssertUtils.assertNotNull(mBodyBeforeFileContents, "The writeHeaders method was not called or did not successfully complete.");
        RequestAssertUtils.assertNotNull(mBodyAfterFileContents, "The writeHeaders method was not called or did not successfully complete.");
        ThreadUtil.checkIfInterrupted();
        mBodyBeforeFileContents.writeTo(outputstream);
        if (mRequest.getInputStream() != null && StreamUtil.copyInputStreamToOutputStream(new ProgressInputStream(mRequest.getInputStream(), mRequest.getContentLength(), mProgressListener), outputstream, mRequest.getBlockSize(), mRequest.getContentLength()) != mRequest.getContentLength())
        {
            throw new InvalidParameter((new StringBuilder()).append("InputStream was longer than declared contentLength [").append(mRequest.getContentLength()).append("].").toString());
        }
        break MISSING_BLOCK_LABEL_155;
        outputstream;
        throw new InterruptedException("Interrupted while writing to the post body.");
        outputstream;
        Closer.closeQuietly(mRequest.getInputStream());
        throw outputstream;
        ThreadUtil.checkIfInterrupted();
        mBodyAfterFileContents.writeTo(outputstream);
        Closer.closeQuietly(mRequest.getInputStream());
        return;
        outputstream;
        throw new RebuildRequestException("Failed to write request to the service.", outputstream);
    }
}
