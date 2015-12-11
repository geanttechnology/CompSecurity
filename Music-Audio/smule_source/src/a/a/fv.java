// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package a.a:
//            m, cj, ck, eq, 
//            en, g, t, f, 
//            q, da, db, dc

public final class fv extends InputStream
    implements m
{

    private f a;
    private cj b;
    private InputStream c;
    private eq d;
    private g e;

    public fv(f f1, InputStream inputstream, eq eq1)
    {
        if (f1 == null)
        {
            throw new NullPointerException("socket was null");
        }
        if (inputstream == null)
        {
            throw new NullPointerException("delegate was null");
        }
        if (eq1 == null)
        {
            throw new NullPointerException("dispatch was null");
        }
        a = f1;
        c = inputstream;
        d = eq1;
        e = b();
        if (e == null)
        {
            throw new NullPointerException("parser was null");
        } else
        {
            return;
        }
    }

    private void a(Exception exception)
    {
        try
        {
            cj cj1 = e();
            cj1.a(exception);
            d.a(cj1, ck.h);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            en.a(exception);
        }
    }

    private void a(byte abyte0[], int i, int j)
    {
        try
        {
            e.a(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw abyte0;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            e = t.d;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            e = t.d;
        }
        en.a(abyte0);
    }

    private cj e()
    {
        if (b == null)
        {
            b = a.b();
        }
        if (b == null)
        {
            throw new IllegalStateException("No statistics were queued up.");
        } else
        {
            return b;
        }
    }

    public final g a()
    {
        return e;
    }

    public final void a(int i)
    {
        cj cj1 = e();
        cj1.c();
        cj1.e = i;
    }

    public final void a(g g1)
    {
        e = g1;
    }

    public final void a(String s)
    {
    }

    public final void a(String s, String s1)
    {
    }

    public final boolean a(InputStream inputstream)
    {
        return c == inputstream;
    }

    public final int available()
    {
        return c.available();
    }

    public final g b()
    {
        return new q(this);
    }

    public final void b(int i)
    {
        cj cj1 = null;
        Object obj = null;
        cj cj2 = b;
        if (b != null)
        {
            int j = b.e;
            cj1 = obj;
            if (j >= 100)
            {
                cj1 = obj;
                if (j < 200)
                {
                    cj1 = new cj(b.a());
                    cj1.e(b.a);
                    cj1.d(b.d);
                    cj1.f = b.f;
                }
            }
            b.b(i);
            d.a(b, ck.g);
        }
        b = cj1;
    }

    public final String c()
    {
        return e().f;
    }

    public final void close()
    {
        try
        {
            e.f();
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            en.a(throwable);
        }
        c.close();
    }

    public final void d()
    {
        if (b != null)
        {
            db db1 = b.g;
            da da1 = da.a;
            boolean flag;
            if (db1.a == dc.d.ordinal() && db1.b == da1.a())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && e != null)
            {
                e.f();
            }
        }
    }

    public final void mark(int i)
    {
        c.mark(i);
    }

    public final boolean markSupported()
    {
        return c.markSupported();
    }

    public final int read()
    {
        int i;
        try
        {
            i = c.read();
        }
        catch (IOException ioexception)
        {
            a(ioexception);
            throw ioexception;
        }
        try
        {
            e.a(i);
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (IllegalStateException illegalstateexception)
        {
            e = t.d;
            return i;
        }
        catch (Throwable throwable)
        {
            e = t.d;
            en.a(throwable);
            return i;
        }
        return i;
    }

    public final int read(byte abyte0[])
    {
        int i;
        try
        {
            i = c.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a(abyte0);
            throw abyte0;
        }
        a(abyte0, 0, i);
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        try
        {
            j = c.read(abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a(abyte0);
            throw abyte0;
        }
        a(abyte0, i, j);
        return j;
    }

    public final void reset()
    {
        this;
        JVM INSTR monitorenter ;
        c.reset();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final long skip(long l)
    {
        return c.skip(l);
    }
}
