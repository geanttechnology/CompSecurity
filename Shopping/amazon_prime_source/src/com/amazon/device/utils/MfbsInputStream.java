// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.zip.GZIPOutputStream;

public class MfbsInputStream extends InputStream
{
    private static class UnsafeByteArrayOutputStream extends ByteArrayOutputStream
    {

        byte[] getBuf()
        {
            return buf;
        }

        int getCount()
        {
            return count;
        }

        private UnsafeByteArrayOutputStream()
        {
        }

    }


    private ByteBuffer body;
    private UnsafeByteArrayOutputStream byteStream;
    private OutputStream compressedByteStream;
    private ByteBuffer header;
    private Writer logFileWriter;
    private BufferedReader mBufferedReader;

    private MfbsInputStream()
        throws IOException
    {
        byteStream = new UnsafeByteArrayOutputStream();
        compressedByteStream = new GZIPOutputStream(byteStream);
        logFileWriter = new BufferedWriter(new OutputStreamWriter(compressedByteStream));
    }

    public MfbsInputStream(BufferedReader bufferedreader)
        throws IOException
    {
        this();
        mBufferedReader = bufferedreader;
    }

    private static ByteBuffer headerBuffer(int i, String s)
    {
        return ByteBuffer.wrap((new StringBuilder()).append("\nFiles: messages.0\n------------------\nMFBS/1.0 1\n\nContent-Type: text/plain\nContent-Encoding: ").append(s).append("\nContent-Length: ").append(i).append("\nContent-Name: Content").append("\n\n").toString().getBytes());
    }

    public int available()
    {
        return header.remaining() + body.remaining();
    }

    public Writer getLogFileWriter()
    {
        return logFileWriter;
    }

    public void pump()
        throws IOException
    {
_L2:
        String s = mBufferedReader.readLine();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        logFileWriter.write((new StringBuilder()).append(s).append("\n").toString());
        if (true) goto _L2; else goto _L1
        Object obj;
        obj;
        Log.e("pump", "Error while writing to log/crash file. File with partial information would be uploaded", ((Throwable) (obj)));
        logFileWriter.flush();
        compressedByteStream.close();
        header = headerBuffer(byteStream.getCount(), "GZIP");
        body = ByteBuffer.wrap(byteStream.getBuf(), 0, byteStream.getCount());
        return;
_L1:
        logFileWriter.flush();
        compressedByteStream.close();
        header = headerBuffer(byteStream.getCount(), "GZIP");
        body = ByteBuffer.wrap(byteStream.getBuf(), 0, byteStream.getCount());
        return;
        obj;
        logFileWriter.flush();
        compressedByteStream.close();
        header = headerBuffer(byteStream.getCount(), "GZIP");
        body = ByteBuffer.wrap(byteStream.getBuf(), 0, byteStream.getCount());
        throw obj;
    }

    public int read()
    {
        if (header.hasRemaining())
        {
            return header.get() & 0xff;
        }
        if (body.hasRemaining())
        {
            return body.get() & 0xff;
        } else
        {
            return -1;
        }
    }

    public int read(byte abyte0[], int i, int j)
    {
        int k = Math.min(j, header.remaining());
        if (k > 0)
        {
            header.get(abyte0, i, k);
        }
        j = Math.min(j - k, body.remaining());
        if (j > 0)
        {
            body.get(abyte0, i + k, j);
        }
        i = k + j;
        if (i > 0)
        {
            return i;
        } else
        {
            return -1;
        }
    }
}
