// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.tapjoy.internal:
//            hp, hl, ho, ht, 
//            hm, hq

public final class hn
{

    private static final ByteArrayBuffer a;
    private static final ByteArrayBuffer b;
    private static final ByteArrayBuffer c;
    private final String d;
    private final Charset e;
    private final String f;
    private final List g;
    private final ho h;

    public hn(String s, String s1, ho ho1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Multipart boundary may not be null");
        } else
        {
            d = s;
            e = hp.a;
            f = s1;
            g = new ArrayList();
            h = ho1;
            return;
        }
    }

    private static ByteArrayBuffer a(Charset charset, String s)
    {
        charset = charset.encode(CharBuffer.wrap(s));
        s = new ByteArrayBuffer(charset.remaining());
        s.append(charset.array(), charset.position(), charset.remaining());
        return s;
    }

    private void a(ho ho1, OutputStream outputstream, boolean flag)
    {
        ByteArrayBuffer bytearraybuffer;
        Iterator iterator;
        bytearraybuffer = a(e, f);
        iterator = g.iterator();
_L2:
        hl hl1;
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_264;
        }
        hl1 = (hl)iterator.next();
        a(c, outputstream);
        a(bytearraybuffer, outputstream);
        a(b, outputstream);
        obj = hl1.a;
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[ho.values().length];
                try
                {
                    a[ho.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[ho.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[ho1.ordinal()])
        {
        default:
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        break MISSING_BLOCK_LABEL_200;
_L3:
        a(b, outputstream);
        if (flag)
        {
            hl1.b.a(outputstream);
        }
        a(b, outputstream);
        if (true) goto _L2; else goto _L1
_L1:
        obj = ((hm) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            hq hq1 = (hq)((Iterator) (obj)).next();
            a(hq1.a, outputstream);
            a(a, outputstream);
            a(hq1.b, outputstream);
            a(b, outputstream);
        }
          goto _L3
        Object obj1 = hl1.a.a("Content-Disposition");
        Charset charset = e;
        a(((hq) (obj1)).a, charset, outputstream);
        a(a, outputstream);
        a(((hq) (obj1)).b, charset, outputstream);
        a(b, outputstream);
        obj1 = hl1.b;
          goto _L3
        a(c, outputstream);
        a(bytearraybuffer, outputstream);
        a(c, outputstream);
        a(b, outputstream);
        return;
    }

    private static void a(String s, OutputStream outputstream)
    {
        a(a(hp.a, s), outputstream);
    }

    private static void a(String s, Charset charset, OutputStream outputstream)
    {
        a(a(charset, s), outputstream);
    }

    private static void a(ByteArrayBuffer bytearraybuffer, OutputStream outputstream)
    {
        outputstream.write(bytearraybuffer.buffer(), 0, bytearraybuffer.length());
    }

    public final List a()
    {
        return g;
    }

    public final void a(hl hl1)
    {
        if (hl1 == null)
        {
            return;
        } else
        {
            g.add(hl1);
            return;
        }
    }

    public final void a(OutputStream outputstream)
    {
        a(h, outputstream, true);
    }

    public final long b()
    {
        Object obj = g.iterator();
        long l = 0L;
        while (((Iterator) (obj)).hasNext()) 
        {
            long l1 = ((hl)((Iterator) (obj)).next()).b.d();
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
        a = a(hp.a, ": ");
        b = a(hp.a, "\r\n");
        c = a(hp.a, "--");
    }
}
