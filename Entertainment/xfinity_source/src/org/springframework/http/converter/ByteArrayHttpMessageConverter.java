// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.http.converter:
//            AbstractHttpMessageConverter, HttpMessageNotReadableException, HttpMessageNotWritableException

public class ByteArrayHttpMessageConverter extends AbstractHttpMessageConverter
{

    public ByteArrayHttpMessageConverter()
    {
        super(new MediaType[] {
            new MediaType("application", "octet-stream"), MediaType.ALL
        });
    }

    protected volatile Long getContentLength(Object obj, MediaType mediatype)
        throws IOException
    {
        return getContentLength((byte[])obj, mediatype);
    }

    protected Long getContentLength(byte abyte0[], MediaType mediatype)
    {
        return Long.valueOf(abyte0.length);
    }

    public volatile Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        return readInternal(class1, httpinputmessage);
    }

    public byte[] readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException
    {
        long l = httpinputmessage.getHeaders().getContentLength();
        if (l >= 0L)
        {
            class1 = new ByteArrayOutputStream((int)l);
            FileCopyUtils.copy(httpinputmessage.getBody(), class1);
            return class1.toByteArray();
        } else
        {
            return FileCopyUtils.copyToByteArray(httpinputmessage.getBody());
        }
    }

    public boolean supports(Class class1)
    {
        return [B.equals(class1);
    }

    protected volatile void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        writeInternal((byte[])obj, httpoutputmessage);
    }

    protected void writeInternal(byte abyte0[], HttpOutputMessage httpoutputmessage)
        throws IOException
    {
        FileCopyUtils.copy(abyte0, httpoutputmessage.getBody());
    }
}
