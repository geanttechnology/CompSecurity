// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.xml.sax.InputSource;

// Referenced classes of package org.springframework.http.converter.xml:
//            AbstractXmlHttpMessageConverter

public class SourceHttpMessageConverter extends AbstractXmlHttpMessageConverter
{
    private static class CountingOutputStream extends OutputStream
    {

        private long count;

        public void write(int i)
            throws IOException
        {
            count = count + 1L;
        }

        public void write(byte abyte0[])
            throws IOException
        {
            count = count + (long)abyte0.length;
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            count = count + (long)j;
        }


        private CountingOutputStream()
        {
            count = 0L;
        }

    }


    public SourceHttpMessageConverter()
    {
    }

    private ByteArrayInputStream transformToByteArrayInputStream(Source source)
        throws TransformerException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        transform(source, new StreamResult(bytearrayoutputstream));
        return new ByteArrayInputStream(bytearrayoutputstream.toByteArray());
    }

    protected volatile Long getContentLength(Object obj, MediaType mediatype)
        throws IOException
    {
        return getContentLength((Source)obj, mediatype);
    }

    protected Long getContentLength(Source source, MediaType mediatype)
    {
        mediatype = null;
        if (source instanceof DOMSource)
        {
            long l;
            try
            {
                mediatype = new CountingOutputStream();
                transform(source, new StreamResult(mediatype));
                l = ((CountingOutputStream) (mediatype)).count;
            }
            // Misplaced declaration of an exception variable
            catch (Source source)
            {
                return null;
            }
            mediatype = Long.valueOf(l);
        }
        return mediatype;
    }

    protected volatile Object readFromSource(Class class1, HttpHeaders httpheaders, Source source)
        throws IOException
    {
        return readFromSource(class1, httpheaders, source);
    }

    protected Source readFromSource(Class class1, HttpHeaders httpheaders, Source source)
        throws IOException
    {
label0:
        {
            try
            {
                if (javax/xml/transform/dom/DOMSource.equals(class1))
                {
                    httpheaders = new DOMResult();
                    transform(source, httpheaders);
                    return new DOMSource(httpheaders.getNode());
                }
                if (!javax/xml/transform/sax/SAXSource.equals(class1))
                {
                    break label0;
                }
                httpheaders = new SAXSource(new InputSource(transformToByteArrayInputStream(source)));
            }
            // Misplaced declaration of an exception variable
            catch (HttpHeaders httpheaders)
            {
                throw new HttpMessageNotReadableException((new StringBuilder()).append("Could not transform from [").append(source).append("] to [").append(class1).append("]").toString(), httpheaders);
            }
            return httpheaders;
        }
        if (javax/xml/transform/stream/StreamSource.equals(class1) || javax/xml/transform/Source.equals(class1))
        {
            return new StreamSource(transformToByteArrayInputStream(source));
        } else
        {
            throw new HttpMessageConversionException((new StringBuilder()).append("Could not read class [").append(class1).append("]. Only DOMSource, SAXSource, and StreamSource are supported.").toString());
        }
    }

    public boolean supports(Class class1)
    {
        return javax/xml/transform/dom/DOMSource.equals(class1) || javax/xml/transform/sax/SAXSource.equals(class1) || javax/xml/transform/stream/StreamSource.equals(class1) || javax/xml/transform/Source.equals(class1);
    }

    protected volatile void writeToResult(Object obj, HttpHeaders httpheaders, Result result)
        throws IOException
    {
        writeToResult((Source)obj, httpheaders, result);
    }

    protected void writeToResult(Source source, HttpHeaders httpheaders, Result result)
        throws IOException
    {
        try
        {
            transform(source, result);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpHeaders httpheaders)
        {
            throw new HttpMessageNotWritableException((new StringBuilder()).append("Could not transform [").append(source).append("] to [").append(result).append("]").toString(), httpheaders);
        }
    }
}
