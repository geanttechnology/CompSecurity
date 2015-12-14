// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import okio.BufferedSink;

// Referenced classes of package com.squareup.okhttp:
//            MediaType

public abstract class RequestBody
{

    public RequestBody()
    {
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

                public void writeTo(BufferedSink bufferedsink)
                    throws IOException
                {
                    bufferedsink.write(content, offset, byteCount);
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

    public abstract void writeTo(BufferedSink bufferedsink)
        throws IOException;
}
