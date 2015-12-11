// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.xml;

import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

public abstract class AbstractXmlHttpMessageConverter extends AbstractHttpMessageConverter
{

    private final TransformerFactory transformerFactory = TransformerFactory.newInstance();

    protected AbstractXmlHttpMessageConverter()
    {
        super(new MediaType[] {
            MediaType.APPLICATION_XML, MediaType.TEXT_XML, new MediaType("application", "*+xml")
        });
    }

    protected abstract Object readFromSource(Class class1, HttpHeaders httpheaders, Source source)
        throws IOException;

    public final Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException
    {
        return readFromSource(class1, httpinputmessage.getHeaders(), new StreamSource(httpinputmessage.getBody()));
    }

    protected void transform(Source source, Result result)
        throws TransformerException
    {
        transformerFactory.newTransformer().transform(source, result);
    }

    protected final void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException
    {
        writeToResult(obj, httpoutputmessage.getHeaders(), new StreamResult(httpoutputmessage.getBody()));
    }

    protected abstract void writeToResult(Object obj, HttpHeaders httpheaders, Result result)
        throws IOException;
}
