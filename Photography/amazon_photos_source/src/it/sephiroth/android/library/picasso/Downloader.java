// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public interface Downloader
{
    public static class Response
    {

        final Bitmap bitmap;
        final boolean cached;
        final long contentLength;
        final InputStream stream;

        public Bitmap getBitmap()
        {
            return bitmap;
        }

        public long getContentLength()
        {
            return contentLength;
        }

        public InputStream getInputStream()
        {
            return stream;
        }

        public Response(Bitmap bitmap1, boolean flag)
        {
            this(bitmap1, flag, -1L);
        }

        public Response(Bitmap bitmap1, boolean flag, long l)
        {
            if (bitmap1 == null)
            {
                throw new IllegalArgumentException("Bitmap may not be null.");
            } else
            {
                stream = null;
                bitmap = bitmap1;
                cached = flag;
                contentLength = l;
                return;
            }
        }

        public Response(InputStream inputstream, boolean flag)
        {
            this(inputstream, flag, -1L);
        }

        public Response(InputStream inputstream, boolean flag, long l)
        {
            if (inputstream == null)
            {
                throw new IllegalArgumentException("Stream may not be null.");
            } else
            {
                stream = inputstream;
                bitmap = null;
                cached = flag;
                contentLength = l;
                return;
            }
        }
    }

    public static class ResponseException extends IOException
    {

        public ResponseException(String s)
        {
            super(s);
        }
    }


    public abstract Response load(Uri uri, boolean flag)
        throws IOException;
}
