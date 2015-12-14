// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

public class DownloadResponse
{

    private byte mBytes[];
    private final long mContentLength;
    private final Header mHeaders[];
    private final int mStatusCode;

    public DownloadResponse(HttpResponse httpresponse)
        throws Exception
    {
        Object obj;
        Object obj1;
        ByteArrayOutputStream bytearrayoutputstream;
        mBytes = new byte[0];
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj1 = null;
        obj = null;
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = new BufferedInputStream(httpentity.getContent());
        Streams.copyContent(((java.io.InputStream) (obj)), bytearrayoutputstream);
        mBytes = bytearrayoutputstream.toByteArray();
        Streams.closeStream(((java.io.Closeable) (obj)));
        Streams.closeStream(bytearrayoutputstream);
        mStatusCode = httpresponse.getStatusLine().getStatusCode();
        mContentLength = mBytes.length;
        mHeaders = httpresponse.getAllHeaders();
        return;
        obj;
        httpresponse = obj1;
_L2:
        Streams.closeStream(httpresponse);
        Streams.closeStream(bytearrayoutputstream);
        throw obj;
        Exception exception;
        exception;
        httpresponse = ((HttpResponse) (obj));
        obj = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public byte[] getByteArray()
    {
        return mBytes;
    }

    public long getContentLength()
    {
        return mContentLength;
    }

    public String getFirstHeader(ResponseHeader responseheader)
    {
        Header aheader[] = mHeaders;
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Header header = aheader[i];
            if (header.getName().equalsIgnoreCase(responseheader.getKey()))
            {
                return header.getValue();
            }
        }

        return null;
    }

    public int getStatusCode()
    {
        return mStatusCode;
    }
}
