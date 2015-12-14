// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import okio.e;
import okio.l;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class RequestBody
{

    public RequestBody()
    {
    }

    public static RequestBody create(final MediaType contentType, final File file)
    {
        if (file == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            return new RequestBody() {

                final MediaType val$contentType;
                final File val$file;

                public long contentLength()
                {
                    return file.length();
                }

                public MediaType contentType()
                {
                    return contentType;
                }

                public void writeTo(e e1)
                {
                    okio.r r = null;
                    okio.r r1 = l.a(file);
                    r = r1;
                    e1.a(r1);
                    Util.closeQuietly(r1);
                    return;
                    e1;
                    Util.closeQuietly(r);
                    throw e1;
                }

            
            {
                contentType = mediatype;
                file = file1;
                super();
            }
            };
        }
    }

    public static RequestBody create(MediaType mediatype, String s)
    {
        java.nio.charset.Charset charset = Util.UTF_8;
        MediaType mediatype1 = mediatype;
        if (mediatype != null)
        {
            java.nio.charset.Charset charset1 = mediatype.charset();
            charset = charset1;
            mediatype1 = mediatype;
            if (charset1 == null)
            {
                charset = Util.UTF_8;
                mediatype1 = MediaType.parse((new StringBuilder()).append(mediatype).append("; charset=utf-8").toString());
            }
        }
        return create(mediatype1, s.getBytes(charset));
    }

    public static RequestBody create(final MediaType contentType, final byte content[])
    {
        if (content == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            return new RequestBody() {

                final byte val$content[];
                final MediaType val$contentType;

                public long contentLength()
                {
                    return (long)content.length;
                }

                public MediaType contentType()
                {
                    return contentType;
                }

                public void writeTo(e e1)
                {
                    e1.c(content);
                }

            
            {
                contentType = mediatype;
                content = abyte0;
                super();
            }
            };
        }
    }

    public long contentLength()
    {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(e e);
}
