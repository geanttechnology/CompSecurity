// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

// Referenced classes of package android.support.v7:
//            ahz

class ahy
    implements Closeable
{

    private final InputStream a;
    private final Charset b;
    private byte c[];
    private int d;
    private int e;

    public ahy(InputStream inputstream, int i, Charset charset)
    {
        if (inputstream == null || charset == null)
        {
            throw new NullPointerException();
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(ahz.a))
        {
            throw new IllegalArgumentException("Unsupported encoding");
        } else
        {
            a = inputstream;
            b = charset;
            c = new byte[i];
            return;
        }
    }

    public ahy(InputStream inputstream, Charset charset)
    {
        this(inputstream, 8192, charset);
    }

    static Charset a(ahy ahy1)
    {
        return ahy1.b;
    }

    private void b()
        throws IOException
    {
        int i = a.read(c, 0, c.length);
        if (i == -1)
        {
            throw new EOFException();
        } else
        {
            d = 0;
            e = i;
            return;
        }
    }

    public String a()
        throws IOException
    {
        InputStream inputstream = a;
        inputstream;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            throw new IOException("LineReader is closed");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
        int i;
        if (d >= e)
        {
            b();
        }
        i = d;
_L9:
        if (i == e) goto _L2; else goto _L1
_L1:
        if (c[i] != 10)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        Object obj;
        int j;
        if (i != d && c[i - 1] == 13)
        {
            j = i - 1;
        } else
        {
            j = i;
        }
        obj = new String(c, d, j - d, b.name());
        d = i + 1;
        inputstream;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L2:
        obj = new ByteArrayOutputStream((e - d) + 80) {

            final ahy a;

            public String toString()
            {
                String s;
                int k;
                if (count > 0 && buf[count - 1] == 13)
                {
                    k = count - 1;
                } else
                {
                    k = count;
                }
                try
                {
                    s = new String(buf, 0, k, ahy.a(a).name());
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    throw new AssertionError(unsupportedencodingexception);
                }
                return s;
            }

            
            {
                a = ahy.this;
                super(i);
            }
        };
_L8:
        ((ByteArrayOutputStream) (obj)).write(c, d, e - d);
        e = -1;
        b();
        i = d;
_L6:
        if (i == e)
        {
            break; /* Loop/switch isn't completed */
        }
        if (c[i] != 10) goto _L4; else goto _L3
_L3:
        if (i != d)
        {
            ((ByteArrayOutputStream) (obj)).write(c, d, i - d);
        }
        d = i + 1;
        obj = ((ByteArrayOutputStream) (obj)).toString();
        inputstream;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        i++;
          goto _L9
    }

    public void close()
        throws IOException
    {
        synchronized (a)
        {
            if (c != null)
            {
                c = null;
                a.close();
            }
        }
        return;
        exception;
        inputstream;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
