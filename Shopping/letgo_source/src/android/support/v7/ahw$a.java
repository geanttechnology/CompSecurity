// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package android.support.v7:
//            ahw

public final class <init>
{
    private class a extends FilterOutputStream
    {

        final ahw.a a;

        public void close()
        {
            try
            {
                out.close();
                return;
            }
            catch (IOException ioexception)
            {
                ahw.a.a(a, true);
            }
        }

        public void flush()
        {
            try
            {
                out.flush();
                return;
            }
            catch (IOException ioexception)
            {
                ahw.a.a(a, true);
            }
        }

        public void write(int i)
        {
            try
            {
                out.write(i);
                return;
            }
            catch (IOException ioexception)
            {
                ahw.a.a(a, true);
            }
        }

        public void write(byte abyte0[], int i, int j)
        {
            try
            {
                out.write(abyte0, i, j);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                ahw.a.a(a, true);
            }
        }

        private a(OutputStream outputstream)
        {
            a = ahw.a.this;
            super(outputstream);
        }

        a(OutputStream outputstream, ahw._cls1 _pcls1)
        {
            this(outputstream);
        }
    }


    final ahw a;
    private final a b;
    private final boolean c[];
    private boolean d;
    private boolean e;

    static a.a a(a.a a1)
    {
        return a1.b;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    static boolean[] b(d d1)
    {
        return d1.c;
    }

    public OutputStream a(int i)
        throws IOException
    {
        ahw ahw1 = a;
        ahw1;
        JVM INSTR monitorenter ;
        if (a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Object obj;
        obj;
        ahw1;
        JVM INSTR monitorexit ;
        throw obj;
        File file;
        if (!d(b))
        {
            c[i] = true;
        }
        file = b.b(i);
        Object obj1 = new FileOutputStream(file);
_L1:
        obj1 = new a(((OutputStream) (obj1)), null);
        ahw1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
        obj1;
        ahw.g(a).mkdirs();
        obj1 = new FileOutputStream(file);
          goto _L1
        obj1;
        obj1 = ahw.b();
        ahw1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
    }

    public void a()
        throws IOException
    {
        if (d)
        {
            ahw.a(a, this, false);
            a.c(c(b));
        } else
        {
            ahw.a(a, this, true);
        }
        e = true;
    }

    public void b()
        throws IOException
    {
        ahw.a(a, this, false);
    }

    private a(ahw ahw1, a a1)
    {
        a = ahw1;
        super();
        b = a1;
        if (d(a1))
        {
            ahw1 = null;
        } else
        {
            ahw1 = new boolean[ahw.f(ahw1)];
        }
        c = ahw1;
    }

    c(ahw ahw1, c c1, c c2)
    {
        this(ahw1, c1);
    }
}
