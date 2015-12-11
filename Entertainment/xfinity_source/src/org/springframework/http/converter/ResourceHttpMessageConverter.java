// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import java.io.IOException;
import java.io.OutputStream;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.http.converter:
//            AbstractHttpMessageConverter, HttpMessageNotReadableException, HttpMessageNotWritableException

public class ResourceHttpMessageConverter extends AbstractHttpMessageConverter
{

    public ResourceHttpMessageConverter()
    {
        super(MediaType.ALL);
    }

    protected volatile Long getContentLength(Object obj, MediaType mediatype)
        throws IOException
    {
        return getContentLength((Resource)obj, mediatype);
    }

    protected Long getContentLength(Resource resource, MediaType mediatype)
        throws IOException
    {
        return Long.valueOf(resource.contentLength());
    }

    protected volatile MediaType getDefaultContentType(Object obj)
        throws IOException
    {
        return getDefaultContentType((Resource)obj);
    }

    protected MediaType getDefaultContentType(Resource resource)
    {
        return MediaType.APPLICATION_OCTET_STREAM;
    }

    protected volatile Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        return readInternal(class1, httpinputmessage);
    }

    protected Resource readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        return new ByteArrayResource(FileCopyUtils.copyToByteArray(httpinputmessage.getBody()));
    }

    protected boolean supports(Class class1)
    {
        return org/springframework/core/io/Resource.isAssignableFrom(class1);
    }

    protected volatile void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        writeInternal((Resource)obj, httpoutputmessage);
    }

    protected void writeInternal(Resource resource, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        FileCopyUtils.copy(resource.getInputStream(), httpoutputmessage.getBody());
        httpoutputmessage.getBody().flush();
    }
}
