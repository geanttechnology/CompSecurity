// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            kb

public final class <init>
{

    final kb a;
    private final a b;
    private final boolean c[];
    private boolean d;
    private boolean e;

    static <init> a(<init> <init>1)
    {
        return <init>1.b;
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
    {
        kb kb1 = a;
        kb1;
        JVM INSTR monitorenter ;
        if (a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Object obj;
        obj;
        kb1;
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
        class a extends FilterOutputStream
        {

            final kb.a a;

            public void close()
            {
                try
                {
                    out.close();
                    return;
                }
                catch (IOException ioexception)
                {
                    kb.a.a(a, true);
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
                    kb.a.a(a, true);
                }
            }

            public void write(int j)
            {
                try
                {
                    out.write(j);
                    return;
                }
                catch (IOException ioexception)
                {
                    kb.a.a(a, true);
                }
            }

            public void write(byte abyte0[], int j, int k)
            {
                try
                {
                    out.write(abyte0, j, k);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    kb.a.a(a, true);
                }
            }

            private a(OutputStream outputstream)
            {
                a = kb.a.this;
                super(outputstream);
            }

            a(OutputStream outputstream, kb._cls1 _pcls1)
            {
                this(outputstream);
            }
        }

        obj1 = new a(((OutputStream) (obj1)), null);
        kb1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
        obj1;
        kb.f(a).mkdirs();
        obj1 = new FileOutputStream(file);
          goto _L1
        obj1;
        obj1 = kb.b();
        kb1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
    }

    public void a()
    {
        if (d)
        {
            kb.a(a, this, false);
            a.c(c(b));
        } else
        {
            kb.a(a, this, true);
        }
        e = true;
    }

    public void b()
    {
        kb.a(a, this, false);
    }

    private Exception(kb kb1, Exception exception)
    {
        a = kb1;
        super();
        b = exception;
        if (d(exception))
        {
            kb1 = null;
        } else
        {
            kb1 = new boolean[kb.e(kb1)];
        }
        c = kb1;
    }

    c(kb kb1, c c1, c c2)
    {
        this(kb1, c1);
    }
}
