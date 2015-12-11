// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.springframework.http.ContentCodingType;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequest, ClientHttpResponse

public abstract class AbstractClientHttpRequest
    implements ClientHttpRequest
{

    private OutputStream compressedBody;
    private boolean executed;
    private final HttpHeaders headers = new HttpHeaders();

    public AbstractClientHttpRequest()
    {
        executed = false;
    }

    private void checkExecuted()
    {
        boolean flag;
        if (!executed)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.state(flag, "ClientHttpRequest already executed");
    }

    private OutputStream getCompressedBody(OutputStream outputstream)
        throws IOException
    {
        if (compressedBody == null)
        {
            compressedBody = new GZIPOutputStream(outputstream);
        }
        return compressedBody;
    }

    private boolean shouldCompress()
    {
        for (Iterator iterator = headers.getContentEncoding().iterator(); iterator.hasNext();)
        {
            if (((ContentCodingType)iterator.next()).equals(ContentCodingType.GZIP))
            {
                return true;
            }
        }

        return false;
    }

    public final ClientHttpResponse execute()
        throws IOException
    {
        checkExecuted();
        if (compressedBody != null)
        {
            compressedBody.close();
        }
        ClientHttpResponse clienthttpresponse = executeInternal(headers);
        executed = true;
        return clienthttpresponse;
    }

    protected abstract ClientHttpResponse executeInternal(HttpHeaders httpheaders)
        throws IOException;

    public final OutputStream getBody()
        throws IOException
    {
        checkExecuted();
        OutputStream outputstream1 = getBodyInternal(headers);
        OutputStream outputstream = outputstream1;
        if (shouldCompress())
        {
            outputstream = getCompressedBody(outputstream1);
        }
        return outputstream;
    }

    protected abstract OutputStream getBodyInternal(HttpHeaders httpheaders)
        throws IOException;

    public final HttpHeaders getHeaders()
    {
        if (executed)
        {
            return HttpHeaders.readOnlyHttpHeaders(headers);
        } else
        {
            return headers;
        }
    }
}
