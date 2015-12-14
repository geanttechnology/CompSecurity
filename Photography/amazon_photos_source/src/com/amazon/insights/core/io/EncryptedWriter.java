// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;

public class EncryptedWriter extends Writer
{

    private Cipher cipher;
    private final Writer writer;

    public EncryptedWriter(Writer writer1, SecretKey secretkey)
    {
        cipher = null;
        writer = writer1;
        try
        {
            cipher = Cipher.getInstance(secretkey.getAlgorithm());
            cipher.init(1, secretkey);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer1)
        {
            cipher = null;
            throw new IllegalArgumentException(writer1);
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer1)
        {
            cipher = null;
            throw new IllegalArgumentException(writer1);
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer1)
        {
            cipher = null;
        }
        throw new IllegalArgumentException(writer1);
    }

    public Writer append(char c)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(char) method");
    }

    public Writer append(CharSequence charsequence)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(CharSequence) method");
    }

    public Writer append(CharSequence charsequence, int i, int j)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(CharSequence,int,int) method");
    }

    public volatile Appendable append(char c)
        throws IOException
    {
        return append(c);
    }

    public volatile Appendable append(CharSequence charsequence)
        throws IOException
    {
        return append(charsequence);
    }

    public volatile Appendable append(CharSequence charsequence, int i, int j)
        throws IOException
    {
        return append(charsequence, i, j);
    }

    public void close()
        throws IOException
    {
        writer.close();
    }

    public void flush()
        throws IOException
    {
        writer.flush();
    }

    public void write(int i)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(int) method");
    }

    public void write(String s)
        throws IOException
    {
        GZIPOutputStream gzipoutputstream;
        GZIPOutputStream gzipoutputstream1;
        if (cipher == null)
        {
            throw new IOException("Could not build a Cipher to encrpyt the string");
        }
        gzipoutputstream1 = null;
        gzipoutputstream = null;
        Object obj = new ByteArrayOutputStream();
        gzipoutputstream1 = new GZIPOutputStream(((java.io.OutputStream) (obj)));
        gzipoutputstream1.write(s.getBytes("UTF-8"));
        gzipoutputstream1.close();
        s = Base64.encodeBase64(cipher.doFinal(((ByteArrayOutputStream) (obj)).toByteArray()));
        writer.write((new StringBuilder()).append(new String(s, "UTF-8")).append("\n").toString());
        if (obj != null)
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        if (gzipoutputstream1 != null)
        {
            gzipoutputstream1.close();
        }
        return;
        s;
        throw new IOException(s.toString());
        Exception exception1;
        exception1;
        gzipoutputstream = gzipoutputstream1;
        s = ((String) (obj));
        obj = exception1;
_L2:
        if (s != null)
        {
            s.close();
        }
        if (gzipoutputstream != null)
        {
            gzipoutputstream.close();
        }
        throw obj;
        obj;
        s = gzipoutputstream1;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        s = ((String) (obj));
        obj = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void write(String s, int i, int j)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(String,int,int) method");
    }

    public void write(char ac[])
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(char[]) method");
    }

    public void write(char ac[], int i, int j)
        throws IOException
    {
        throw new UnsupportedOperationException("This writer does not support the write(char[],int,int) method");
    }
}
