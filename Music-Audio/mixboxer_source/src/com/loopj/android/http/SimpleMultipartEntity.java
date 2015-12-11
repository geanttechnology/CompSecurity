// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class SimpleMultipartEntity
    implements HttpEntity
{

    private static final char MULTIPART_CHARS[] = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String boundary;
    boolean isSetFirst;
    boolean isSetLast;
    ByteArrayOutputStream out;

    public SimpleMultipartEntity()
    {
        int i = 0;
        super();
        boundary = null;
        out = new ByteArrayOutputStream();
        isSetLast = false;
        isSetFirst = false;
        StringBuffer stringbuffer = new StringBuffer();
        Random random = new Random();
        for (; i < 30; i++)
        {
            stringbuffer.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }

        boundary = stringbuffer.toString();
    }

    public void addPart(String s, File file, boolean flag)
    {
        try
        {
            addPart(s, file.getName(), ((InputStream) (new FileInputStream(file))), flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void addPart(String s, String s1)
    {
        writeFirstBoundaryIfNeeds();
        try
        {
            out.write((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"\r\n\r\n").toString().getBytes());
            out.write(s1.getBytes());
            out.write((new StringBuilder()).append("\r\n--").append(boundary).append("\r\n").toString().getBytes());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void addPart(String s, String s1, InputStream inputstream, String s2, boolean flag)
    {
        writeFirstBoundaryIfNeeds();
        s2 = (new StringBuilder()).append("Content-Type: ").append(s2).append("\r\n").toString();
        out.write((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"; filename=\"").append(s1).append("\"\r\n").toString().getBytes());
        out.write(s2.getBytes());
        out.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
        s = new byte[4096];
_L1:
        int i = inputstream.read(s);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        out.write(s, 0, i);
          goto _L1
        s;
        s.printStackTrace();
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_206;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        out.write((new StringBuilder()).append("\r\n--").append(boundary).append("\r\n").toString().getBytes());
        out.flush();
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        return;
        return;
        s;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
        }
        throw s;
    }

    public void addPart(String s, String s1, InputStream inputstream, boolean flag)
    {
        addPart(s, s1, inputstream, "application/octet-stream", flag);
    }

    public void consumeContent()
        throws IOException, UnsupportedOperationException
    {
        if (isStreaming())
        {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        } else
        {
            return;
        }
    }

    public InputStream getContent()
        throws IOException, UnsupportedOperationException
    {
        return new ByteArrayInputStream(out.toByteArray());
    }

    public Header getContentEncoding()
    {
        return null;
    }

    public long getContentLength()
    {
        writeLastBoundaryIfNeeds();
        return (long)out.toByteArray().length;
    }

    public Header getContentType()
    {
        return new BasicHeader("Content-Type", (new StringBuilder()).append("multipart/form-data; boundary=").append(boundary).toString());
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public boolean isStreaming()
    {
        return false;
    }

    public void writeFirstBoundaryIfNeeds()
    {
        if (!isSetFirst)
        {
            try
            {
                out.write((new StringBuilder()).append("--").append(boundary).append("\r\n").toString().getBytes());
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        isSetFirst = true;
    }

    public void writeLastBoundaryIfNeeds()
    {
        if (isSetLast)
        {
            return;
        }
        try
        {
            out.write((new StringBuilder()).append("\r\n--").append(boundary).append("--\r\n").toString().getBytes());
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        isSetLast = true;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(out.toByteArray());
    }

}
