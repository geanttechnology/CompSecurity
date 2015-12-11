// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.xml;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

public class SimpleXmlHttpMessageConverter extends AbstractHttpMessageConverter
{

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Serializer serializer;

    public SimpleXmlHttpMessageConverter()
    {
        this(((Serializer) (new Persister())));
    }

    public SimpleXmlHttpMessageConverter(Serializer serializer1)
    {
        super(new MediaType[] {
            MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_WILDCARD_XML
        });
        setSerializer(serializer1);
    }

    private Charset getCharset(HttpHeaders httpheaders)
    {
        if (httpheaders != null && httpheaders.getContentType() != null && httpheaders.getContentType().getCharSet() != null)
        {
            return httpheaders.getContentType().getCharSet();
        } else
        {
            return DEFAULT_CHARSET;
        }
    }

    public boolean canRead(Class class1, MediaType mediatype)
    {
        return canRead(mediatype);
    }

    public boolean canWrite(Class class1, MediaType mediatype)
    {
        return class1.isAnnotationPresent(org/simpleframework/xml/Root) && canWrite(mediatype);
    }

    protected Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        httpinputmessage = new InputStreamReader(httpinputmessage.getBody(), getCharset(httpinputmessage.getHeaders()));
        try
        {
            httpinputmessage = ((HttpInputMessage) (serializer.read(class1, httpinputmessage)));
            if (!class1.isInstance(httpinputmessage))
            {
                throw new TypeMismatchException(httpinputmessage, class1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpInputMessage httpinputmessage)
        {
            throw new HttpMessageNotReadableException((new StringBuilder()).append("Could not read [").append(class1).append("]").toString(), httpinputmessage);
        }
        return httpinputmessage;
    }

    public void setSerializer(Serializer serializer1)
    {
        Assert.notNull(serializer1, "'serializer' must not be null");
        serializer = serializer1;
    }

    protected boolean supports(Class class1)
    {
        throw new UnsupportedOperationException();
    }

    protected void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        httpoutputmessage = new OutputStreamWriter(httpoutputmessage.getBody(), getCharset(httpoutputmessage.getHeaders()));
        try
        {
            serializer.write(obj, httpoutputmessage);
            httpoutputmessage.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpOutputMessage httpoutputmessage)
        {
            throw new HttpMessageNotWritableException((new StringBuilder()).append("Could not write [").append(obj).append("]").toString(), httpoutputmessage);
        }
    }

}
