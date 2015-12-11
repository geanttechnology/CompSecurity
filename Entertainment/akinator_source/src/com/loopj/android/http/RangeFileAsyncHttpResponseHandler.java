// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.loopj.android.http:
//            FileAsyncHttpResponseHandler, AsyncHttpClient, LogInterface

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler
{

    private static final String LOG_TAG = "RangeFileAsyncHttpRH";
    private boolean append;
    private long current;

    public RangeFileAsyncHttpResponseHandler(File file)
    {
        super(file);
        current = 0L;
        append = false;
    }

    protected byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        InputStream inputstream;
        long l;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength() + current;
        httpentity = new FileOutputStream(getTargetFile(), append);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        byte abyte0[] = new byte[4096];
_L1:
        int i;
        if (current >= l)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_130;
        }
        current = current + (long)i;
        httpentity.write(abyte0, 0, i);
        sendProgressMessage(current, l);
          goto _L1
        Exception exception;
        exception;
        inputstream.close();
        httpentity.flush();
        httpentity.close();
        throw exception;
        inputstream.close();
        httpentity.flush();
        httpentity.close();
        return null;
    }

    public void sendResponseMessage(HttpResponse httpresponse)
        throws IOException
    {
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L1
_L1:
        StatusLine statusline = httpresponse.getStatusLine();
        if (statusline.getStatusCode() != 416) goto _L4; else goto _L3
_L3:
        if (!Thread.currentThread().isInterrupted())
        {
            sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null);
        }
_L2:
        return;
_L4:
        if (statusline.getStatusCode() < 300)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L5
_L5:
        sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()));
        return;
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L6
_L6:
        Header header = httpresponse.getFirstHeader("Content-Range");
        if (header == null)
        {
            append = false;
            current = 0L;
        } else
        {
            AsyncHttpClient.log.v("RangeFileAsyncHttpRH", (new StringBuilder()).append("Content-Range: ").append(header.getValue()).toString());
        }
        sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), getResponseData(httpresponse.getEntity()));
        return;
    }

    public void updateRequestHeaders(HttpUriRequest httpurirequest)
    {
        if (file.exists() && file.canWrite())
        {
            current = file.length();
        }
        if (current > 0L)
        {
            append = true;
            httpurirequest.setHeader("Range", (new StringBuilder()).append("bytes=").append(current).append("-").toString());
        }
    }
}
