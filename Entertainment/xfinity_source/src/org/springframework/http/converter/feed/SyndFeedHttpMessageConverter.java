// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.feed;

import com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed;
import com.google.code.rome.android.repackaged.com.sun.syndication.io.FeedException;
import com.google.code.rome.android.repackaged.com.sun.syndication.io.SyndFeedInput;
import com.google.code.rome.android.repackaged.com.sun.syndication.io.SyndFeedOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;

public class SyndFeedHttpMessageConverter extends AbstractHttpMessageConverter
{

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public SyndFeedHttpMessageConverter()
    {
        super(new MediaType[] {
            MediaType.APPLICATION_RSS_XML, MediaType.APPLICATION_ATOM_XML
        });
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        }
    }

    protected SyndFeed readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        SyndFeedInput syndfeedinput = new SyndFeedInput();
        class1 = httpinputmessage.getHeaders().getContentType();
        if (class1 != null && class1.getCharSet() != null)
        {
            class1 = class1.getCharSet();
        } else
        {
            class1 = DEFAULT_CHARSET;
        }
        try
        {
            class1 = syndfeedinput.build(new InputStreamReader(httpinputmessage.getBody(), class1));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new HttpMessageNotReadableException((new StringBuilder()).append("Could not read SyndFeed: ").append(class1.getMessage()).toString(), class1);
        }
        return class1;
    }

    protected volatile Object readInternal(Class class1, HttpInputMessage httpinputmessage)
        throws IOException, HttpMessageNotReadableException
    {
        return readInternal(class1, httpinputmessage);
    }

    protected boolean supports(Class class1)
    {
        return com/google/code/rome/android/repackaged/com/sun/syndication/feed/synd/SyndFeed.isAssignableFrom(class1);
    }

    protected void writeInternal(SyndFeed syndfeed, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        Object obj = syndfeed.getEncoding();
        String s = ((String) (obj));
        if (!StringUtils.hasLength(((String) (obj))))
        {
            s = DEFAULT_CHARSET.name();
        }
        obj = httpoutputmessage.getHeaders().getContentType();
        if (obj != null)
        {
            Charset charset = Charset.forName(s);
            obj = new MediaType(((MediaType) (obj)).getType(), ((MediaType) (obj)).getSubtype(), charset);
            httpoutputmessage.getHeaders().setContentType(((MediaType) (obj)));
        }
        obj = new SyndFeedOutput();
        try
        {
            ((SyndFeedOutput) (obj)).output(syndfeed, new OutputStreamWriter(httpoutputmessage.getBody(), s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SyndFeed syndfeed)
        {
            throw new HttpMessageNotWritableException((new StringBuilder()).append("Could not write SyndFeed: ").append(syndfeed.getMessage()).toString(), syndfeed);
        }
    }

    protected volatile void writeInternal(Object obj, HttpOutputMessage httpoutputmessage)
        throws IOException, HttpMessageNotWritableException
    {
        writeInternal((SyndFeed)obj, httpoutputmessage);
    }

}
