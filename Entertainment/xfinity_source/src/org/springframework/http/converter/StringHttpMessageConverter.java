// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.http.converter:
//            AbstractHttpMessageConverter, HttpMessageNotReadableException, HttpMessageNotWritableException

public class StringHttpMessageConverter extends AbstractHttpMessageConverter
{

    private final List availableCharsets;
    private final Charset defaultCharset;
    private boolean writeAcceptCharset;

    public StringHttpMessageConverter()
    {
        this(Charset.forName("ISO-8859-1"));
    }

    public StringHttpMessageConverter(Charset charset)
    {
        this(charset, ((List) (new ArrayList(Charset.availableCharsets().values()))));
    }

    public StringHttpMessageConverter(Charset charset, List list)
    {
        super(new MediaType[] {
            new MediaType("text", "plain", charset), MediaType.ALL
        });
        writeAcceptCharset = true;
        defaultCharset = charset;
        availableCharsets = list;
    }

    private Charset getContentTypeCharset(MediaType mediatype)
    {
        if (mediatype != null && mediatype.getCharSet() != null)
        {
            return mediatype.getCharSet();
        } else
        {
            return getDefaultCharset();
        }
    }

    protected List getAcceptedCharsets()
    {
        return availableCharsets;
    }

    protected volatile Long getContentLength(Object obj, MediaType mediatype)
        throws IOException
    {
        return getContentLength((String)obj, mediatype);
    }

    protected Long getContentLength(String s, MediaType mediatype)
    {
        mediatype = getContentTypeCharset(mediatype);
        long l;
        try
        {
            l = s.getBytes(mediatype.displayName()).length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InternalError(s.getMessage());
        }
        return Long.valueOf(l);
    }

    public Charset getDefaultCharset()
    {
        return defaultCharset;
    }

    protected volatile Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        return readInternal(class1, httpinputmessage);
    }

    protected String readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException
    {
        class1 = getContentTypeCharset(httpinputmessage.getHeaders().getContentType());
        return FileCopyUtils.copyToString(new InputStreamReader(httpinputmessage.getBody(), class1));
    }

    public void setWriteAcceptCharset(boolean flag)
    {
        writeAcceptCharset = flag;
    }

    public boolean supports(Class class1)
    {
        return java/lang/String.equals(class1);
    }

    protected volatile void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        writeInternal((String)obj, httpoutputmessage);
    }

    protected void writeInternal(String s, HttpOutputMessage httpoutputmessage)
        throws IOException
    {
        if (writeAcceptCharset)
        {
            httpoutputmessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
        }
        Charset charset = getContentTypeCharset(httpoutputmessage.getHeaders().getContentType());
        FileCopyUtils.copy(s, new OutputStreamWriter(httpoutputmessage.getBody(), charset));
    }
}
