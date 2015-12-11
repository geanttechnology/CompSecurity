// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import android.support.v7.apw;
import android.support.v7.aqe;
import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class RequestBody
{

    public RequestBody()
    {
    }

    public static RequestBody create(MediaType mediatype, File file)
    {
        if (file == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            return new RequestBody(mediatype, file) {

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

                public void writeTo(apw apw1)
                    throws IOException
                {
                    android.support.v7.aqk aqk = null;
                    android.support.v7.aqk aqk1 = aqe.a(file);
                    aqk = aqk1;
                    apw1.a(aqk1);
                    Util.closeQuietly(aqk1);
                    return;
                    apw1;
                    Util.closeQuietly(aqk);
                    throw apw1;
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

    public static RequestBody create(MediaType mediatype, byte abyte0[])
    {
        return create(mediatype, abyte0, 0, abyte0.length);
    }

    public static RequestBody create(MediaType mediatype, byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("content == null");
        } else
        {
            Util.checkOffsetAndCount(abyte0.length, i, j);
            return new RequestBody(mediatype, j, abyte0, i) {

                final int val$byteCount;
                final byte val$content[];
                final MediaType val$contentType;
                final int val$offset;

                public long contentLength()
                {
                    return (long)byteCount;
                }

                public MediaType contentType()
                {
                    return contentType;
                }

                public void writeTo(apw apw1)
                    throws IOException
                {
                    apw1.c(content, offset, byteCount);
                }

            
            {
                contentType = mediatype;
                byteCount = i;
                content = abyte0;
                offset = j;
                super();
            }
            };
        }
    }

    public long contentLength()
        throws IOException
    {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(apw apw)
        throws IOException;
}
