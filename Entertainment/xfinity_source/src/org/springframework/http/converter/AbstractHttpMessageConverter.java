// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.converter:
//            HttpMessageConverter, HttpMessageNotReadableException, HttpMessageNotWritableException

public abstract class AbstractHttpMessageConverter
    implements HttpMessageConverter
{

    private List supportedMediaTypes;

    protected AbstractHttpMessageConverter(MediaType mediatype)
    {
        supportedMediaTypes = Collections.emptyList();
        setSupportedMediaTypes(Collections.singletonList(mediatype));
    }

    protected transient AbstractHttpMessageConverter(MediaType amediatype[])
    {
        supportedMediaTypes = Collections.emptyList();
        setSupportedMediaTypes(Arrays.asList(amediatype));
    }

    public boolean canRead(Class class1, MediaType mediatype)
    {
        return supports(class1) && canRead(mediatype);
    }

    protected boolean canRead(MediaType mediatype)
    {
        if (mediatype == null)
        {
            return true;
        }
        for (Iterator iterator = getSupportedMediaTypes().iterator(); iterator.hasNext();)
        {
            if (((MediaType)iterator.next()).includes(mediatype))
            {
                return true;
            }
        }

        return false;
    }

    public boolean canWrite(Class class1, MediaType mediatype)
    {
        return supports(class1) && canWrite(mediatype);
    }

    protected boolean canWrite(MediaType mediatype)
    {
        if (mediatype == null || MediaType.ALL.equals(mediatype))
        {
            return true;
        }
        for (Iterator iterator = getSupportedMediaTypes().iterator(); iterator.hasNext();)
        {
            if (((MediaType)iterator.next()).isCompatibleWith(mediatype))
            {
                return true;
            }
        }

        return false;
    }

    protected Long getContentLength(Object obj, MediaType mediatype)
        throws IOException
    {
        return null;
    }

    protected MediaType getDefaultContentType(Object obj)
        throws IOException
    {
        obj = getSupportedMediaTypes();
        if (!((List) (obj)).isEmpty())
        {
            return (MediaType)((List) (obj)).get(0);
        } else
        {
            return null;
        }
    }

    public List getSupportedMediaTypes()
    {
        return Collections.unmodifiableList(supportedMediaTypes);
    }

    public final Object read(Class class1, HttpInputMessage httpinputmessage)
        throws IOException
    {
        return readInternal(class1, httpinputmessage);
    }

    protected abstract Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException;

    public void setSupportedMediaTypes(List list)
    {
        Assert.notEmpty(list, "'supportedMediaTypes' must not be empty");
        supportedMediaTypes = new ArrayList(list);
    }

    protected abstract boolean supports(Class class1);

    public final void write(Object obj, MediaType mediatype, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        HttpHeaders httpheaders;
label0:
        {
            MediaType mediatype1;
label1:
            {
                httpheaders = httpoutputmessage.getHeaders();
                if (httpheaders.getContentType() != null)
                {
                    break label0;
                }
                if (mediatype != null && !mediatype.isWildcardType())
                {
                    mediatype1 = mediatype;
                    if (!mediatype.isWildcardSubtype())
                    {
                        break label1;
                    }
                }
                mediatype1 = getDefaultContentType(obj);
            }
            if (mediatype1 != null)
            {
                httpheaders.setContentType(mediatype1);
            }
        }
        if (httpheaders.getContentLength() == -1L)
        {
            mediatype = getContentLength(obj, httpheaders.getContentType());
            if (mediatype != null)
            {
                httpheaders.setContentLength(mediatype.longValue());
            }
        }
        writeInternal(obj, httpoutputmessage);
        httpoutputmessage.getBody().flush();
    }

    protected abstract void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException;
}
