// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.springframework.http.ContentCodingType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpResponse

public abstract class AbstractClientHttpResponse
    implements ClientHttpResponse
{

    private InputStream compressedBody;

    public AbstractClientHttpResponse()
    {
    }

    private InputStream getCompressedBody(InputStream inputstream)
        throws IOException
    {
        if (compressedBody == null)
        {
            compressedBody = new GZIPInputStream(inputstream);
        }
        return compressedBody;
    }

    private boolean isCompressed()
    {
        for (Iterator iterator = getHeaders().getContentEncoding().iterator(); iterator.hasNext();)
        {
            if (((ContentCodingType)iterator.next()).equals(ContentCodingType.GZIP))
            {
                return true;
            }
        }

        return false;
    }

    public void close()
    {
        if (compressedBody != null)
        {
            try
            {
                compressedBody.close();
            }
            catch (IOException ioexception) { }
        }
        closeInternal();
    }

    protected abstract void closeInternal();

    public InputStream getBody()
        throws IOException
    {
        InputStream inputstream1 = getBodyInternal();
        InputStream inputstream = inputstream1;
        if (isCompressed())
        {
            inputstream = getCompressedBody(inputstream1);
        }
        return inputstream;
    }

    protected abstract InputStream getBodyInternal()
        throws IOException;

    public HttpStatus getStatusCode()
        throws IOException
    {
        return HttpStatus.valueOf(getRawStatusCode());
    }
}
