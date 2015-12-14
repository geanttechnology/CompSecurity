// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.util.ByteArrayBuffer;

public class aif
{

    private static final ByteArrayBuffer a;
    private static final ByteArrayBuffer b;
    private static final ByteArrayBuffer c;
    private final String d;
    private final Charset e;
    private final String f;
    private final List g = new ArrayList();
    private final HttpMultipartMode h;

    public aif(String s, Charset charset, String s1, HttpMultipartMode httpmultipartmode)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
        d = s;
        if (charset == null)
        {
            charset = aig.a;
        }
        e = charset;
        f = s1;
        h = httpmultipartmode;
    }

    private static ByteArrayBuffer a(Charset charset, String s)
    {
        charset = charset.encode(CharBuffer.wrap(s));
        s = new ByteArrayBuffer(charset.remaining());
        s.append(charset.array(), charset.position(), charset.remaining());
        return s;
    }

    private static void a(aih aih1, OutputStream outputstream)
    {
        a(aih1.a(), outputstream);
        a(a, outputstream);
        a(aih1.b(), outputstream);
        a(b, outputstream);
    }

    private static void a(aih aih1, Charset charset, OutputStream outputstream)
    {
        a(aih1.a(), charset, outputstream);
        a(a, outputstream);
        a(aih1.b(), charset, outputstream);
        a(b, outputstream);
    }

    private static void a(String s, OutputStream outputstream)
    {
        a(a(aig.a, s), outputstream);
    }

    private static void a(String s, Charset charset, OutputStream outputstream)
    {
        a(a(charset, s), outputstream);
    }

    private void a(HttpMultipartMode httpmultipartmode, OutputStream outputstream, boolean flag)
    {
        ByteArrayBuffer bytearraybuffer;
        Iterator iterator;
        bytearraybuffer = a(e, b());
        iterator = g.iterator();
_L2:
        aid aid1;
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_222;
        }
        aid1 = (aid)iterator.next();
        a(c, outputstream);
        a(bytearraybuffer, outputstream);
        a(b, outputstream);
        obj = aid1.c();
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[HttpMultipartMode.values().length];
                try
                {
                    a[HttpMultipartMode.STRICT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[httpmultipartmode.ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_170;
_L3:
        a(b, outputstream);
        if (flag)
        {
            aid1.b().a(outputstream);
        }
        a(b, outputstream);
        if (true) goto _L2; else goto _L1
_L1:
        obj = ((aie) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            a((aih)((Iterator) (obj)).next(), outputstream);
        }
          goto _L3
        a(aid1.c().a("Content-Disposition"), e, outputstream);
        if (aid1.b().b() != null)
        {
            a(aid1.c().a("Content-Type"), e, outputstream);
        }
          goto _L3
        a(c, outputstream);
        a(bytearraybuffer, outputstream);
        a(c, outputstream);
        a(b, outputstream);
        return;
    }

    private static void a(ByteArrayBuffer bytearraybuffer, OutputStream outputstream)
    {
        outputstream.write(bytearraybuffer.buffer(), 0, bytearraybuffer.length());
    }

    public List a()
    {
        return g;
    }

    public void a(aid aid1)
    {
        if (aid1 == null)
        {
            return;
        } else
        {
            g.add(aid1);
            return;
        }
    }

    public void a(OutputStream outputstream)
    {
        a(h, outputstream, true);
    }

    public String b()
    {
        return f;
    }

    public long c()
    {
        Object obj = g.iterator();
        long l = 0L;
        while (((Iterator) (obj)).hasNext()) 
        {
            long l1 = ((aid)((Iterator) (obj)).next()).b().e();
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
            a(h, ((OutputStream) (obj)), false);
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
        a = a(aig.a, ": ");
        b = a(aig.a, "\r\n");
        c = a(aig.a, "--");
    }
}
