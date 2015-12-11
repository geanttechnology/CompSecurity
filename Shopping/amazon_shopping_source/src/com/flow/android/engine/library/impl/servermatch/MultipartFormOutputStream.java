// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MultipartFormOutputStream
{

    private String boundary;
    private DataOutputStream out;

    public MultipartFormOutputStream(OutputStream outputstream, String s)
    {
        out = null;
        boundary = null;
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Output stream is required.");
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("Boundary stream is required.");
        } else
        {
            out = new DataOutputStream(outputstream);
            boundary = s;
            return;
        }
    }

    public static String createBoundary()
    {
        return (new StringBuilder()).append("--------------------").append(Long.toString(System.currentTimeMillis(), 16)).toString();
    }

    public static String getContentType(String s)
    {
        return (new StringBuilder()).append("multipart/form-data; boundary=").append(s).toString();
    }

    public void close()
        throws IOException
    {
        out.writeBytes("--");
        out.writeBytes(boundary);
        out.writeBytes("--");
        out.writeBytes("\r\n");
        out.flush();
        out.close();
    }

    public void flush()
        throws IOException
    {
    }

    public void writeField(String s, String s1)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        out.writeBytes("--");
        out.writeBytes(boundary);
        out.writeBytes("\r\n");
        out.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"").toString());
        out.writeBytes("\r\n");
        out.writeBytes("\r\n");
        out.writeBytes(s2);
        out.writeBytes("\r\n");
        out.flush();
    }

    public void writeField(String s, boolean flag)
        throws IOException
    {
        writeField(s, (new Boolean(flag)).toString());
    }

    public void writeFile(String s, String s1, String s2, InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Input stream cannot be null.");
        }
        if (s2 == null || s2.length() == 0)
        {
            throw new IllegalArgumentException("File name cannot be null or empty.");
        }
        out.writeBytes("--");
        out.writeBytes(boundary);
        out.writeBytes("\r\n");
        out.writeBytes((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s).append("\"; filename=\"").append(s2).append("\"").toString());
        out.writeBytes("\r\n");
        if (s1 != null)
        {
            out.writeBytes((new StringBuilder()).append("Content-Type: ").append(s1).toString());
            out.writeBytes("\r\n");
        }
        out.writeBytes("\r\n");
        s = new byte[1024];
        do
        {
            int i = inputstream.read(s, 0, s.length);
            if (i == -1)
            {
                break;
            }
            out.write(s, 0, i);
        } while (true);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        out.writeBytes("\r\n");
        out.flush();
    }
}
