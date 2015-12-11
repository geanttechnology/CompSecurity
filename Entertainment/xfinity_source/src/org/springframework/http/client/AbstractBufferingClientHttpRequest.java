// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.springframework.http.HttpHeaders;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpRequest, ClientHttpResponse

abstract class AbstractBufferingClientHttpRequest extends AbstractClientHttpRequest
{

    private ByteArrayOutputStream bufferedOutput;

    AbstractBufferingClientHttpRequest()
    {
        bufferedOutput = new ByteArrayOutputStream();
    }

    protected ClientHttpResponse executeInternal(HttpHeaders httpheaders)
        throws IOException
    {
        byte abyte0[] = bufferedOutput.toByteArray();
        if (httpheaders.getContentLength() == -1L)
        {
            httpheaders.setContentLength(abyte0.length);
        }
        httpheaders = executeInternal(httpheaders, abyte0);
        bufferedOutput = null;
        return httpheaders;
    }

    protected abstract ClientHttpResponse executeInternal(HttpHeaders httpheaders, byte abyte0[])
        throws IOException;

    protected OutputStream getBodyInternal(HttpHeaders httpheaders)
        throws IOException
    {
        return bufferedOutput;
    }
}
