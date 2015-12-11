// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.a.b.b;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package org.a.a.a.a:
//            g, d, a

abstract class f
{

    private static final ByteArrayBuffer b;
    private static final ByteArrayBuffer c;
    private static final ByteArrayBuffer d;
    protected final Charset a;
    private final String e;
    private final String f;

    public f(String s, Charset charset, String s1)
    {
        org.a.a.a.a.b.b.a(s, "Multipart subtype");
        org.a.a.a.a.b.b.a(s1, "Multipart boundary");
        e = s;
        if (charset == null)
        {
            charset = g.a;
        }
        a = charset;
        f = s1;
    }

    private static ByteArrayBuffer a(Charset charset, String s)
    {
        charset = charset.encode(CharBuffer.wrap(s));
        s = new ByteArrayBuffer(charset.remaining());
        s.append(charset.array(), charset.position(), charset.remaining());
        return s;
    }

    private static void a(String s, OutputStream outputstream)
        throws IOException
    {
        a(a(g.a, s), outputstream);
    }

    private static void a(String s, Charset charset, OutputStream outputstream)
        throws IOException
    {
        a(a(charset, s), outputstream);
    }

    protected static void a(d d1, OutputStream outputstream)
        throws IOException
    {
        a(d1.a(), outputstream);
        a(b, outputstream);
        a(d1.b(), outputstream);
        a(c, outputstream);
    }

    protected static void a(d d1, Charset charset, OutputStream outputstream)
        throws IOException
    {
        a(d1.a(), charset, outputstream);
        a(b, outputstream);
        a(d1.b(), charset, outputstream);
        a(c, outputstream);
    }

    private static void a(ByteArrayBuffer bytearraybuffer, OutputStream outputstream)
        throws IOException
    {
        outputstream.write(bytearraybuffer.buffer(), 0, bytearraybuffer.length());
    }

    public abstract List a();

    public void a(OutputStream outputstream)
        throws IOException
    {
        a(outputstream, true);
    }

    void a(OutputStream outputstream, boolean flag)
        throws IOException
    {
        ByteArrayBuffer bytearraybuffer = a(a, b());
        for (Iterator iterator = a().iterator(); iterator.hasNext(); a(c, outputstream))
        {
            a a1 = (a)iterator.next();
            a(d, outputstream);
            a(bytearraybuffer, outputstream);
            a(c, outputstream);
            a(a1, outputstream);
            a(c, outputstream);
            if (flag)
            {
                a1.b().a(outputstream);
            }
        }

        a(d, outputstream);
        a(bytearraybuffer, outputstream);
        a(d, outputstream);
        a(c, outputstream);
    }

    protected abstract void a(a a1, OutputStream outputstream)
        throws IOException;

    public String b()
    {
        return f;
    }

    public long c()
    {
        Object obj = a().iterator();
        long l = 0L;
        while (((Iterator) (obj)).hasNext()) 
        {
            long l1 = ((a)((Iterator) (obj)).next()).b().d();
            if (l1 >= 0L)
            {
                l = l1 + l;
            } else
            {
                return -1L;
            }
        }
        obj = new ByteArrayOutputStream();
        int i;
        try
        {
            a(((OutputStream) (obj)), false);
            i = ((ByteArrayOutputStream) (obj)).toByteArray().length;
        }
        catch (IOException ioexception)
        {
            return -1L;
        }
        return (long)i + l;
    }

    static 
    {
        b = a(g.a, ": ");
        c = a(g.a, "\r\n");
        d = a(g.a, "--");
    }
}
