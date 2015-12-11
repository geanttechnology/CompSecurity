// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.OutputStream;

// Referenced classes of package a.a:
//            m, g, en, t, 
//            f, cj, fg, o

public final class fu extends OutputStream
    implements m
{

    private f a;
    private OutputStream b;
    private cj c;
    private g d;

    public fu(f f1, OutputStream outputstream)
    {
        if (f1 == null)
        {
            throw new NullPointerException("socket was null");
        }
        if (outputstream == null)
        {
            throw new NullPointerException("output stream was null");
        }
        a = f1;
        b = outputstream;
        d = b();
        if (d == null)
        {
            throw new NullPointerException("parser was null");
        } else
        {
            return;
        }
    }

    private void a(byte abyte0[], int i, int j)
    {
        try
        {
            d.a(abyte0, i, j);
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
            en.a(abyte0);
        }
        d = t.d;
    }

    private cj d()
    {
        if (c == null)
        {
            c = a.a();
        }
        cj cj1 = c;
        return c;
    }

    public final g a()
    {
        return d;
    }

    public final void a(int i)
    {
    }

    public final void a(g g1)
    {
        d = g1;
    }

    public final void a(String s)
    {
        cj cj1 = d();
        if (cj1 != null)
        {
            cj1.b(s);
        }
    }

    public final void a(String s, String s1)
    {
        cj cj1 = d();
        cj1.b();
        cj1.f = s;
        cj1.i = null;
        s = cj1.h;
        if (s1 != null)
        {
            s.c = s1;
        }
        a.a(cj1);
    }

    public final boolean a(OutputStream outputstream)
    {
        return b == outputstream;
    }

    public final g b()
    {
        return new o(this);
    }

    public final void b(int i)
    {
        cj cj1 = c;
        c = null;
        if (cj1 != null)
        {
            cj1.d(i);
        }
    }

    public final String c()
    {
        cj cj1 = d();
        String s = null;
        if (cj1 != null)
        {
            s = cj1.f;
        }
        return s;
    }

    public final void close()
    {
        b.close();
    }

    public final void flush()
    {
        b.flush();
    }

    public final void write(int i)
    {
        b.write(i);
        try
        {
            d.a(i);
            return;
        }
        catch (ThreadDeath threaddeath)
        {
            throw threaddeath;
        }
        catch (Throwable throwable)
        {
            en.a(throwable);
        }
        d = t.d;
    }

    public final void write(byte abyte0[])
    {
        b.write(abyte0);
        if (abyte0 != null)
        {
            a(abyte0, 0, abyte0.length);
        }
    }

    public final void write(byte abyte0[], int i, int j)
    {
        b.write(abyte0, i, j);
        if (abyte0 != null)
        {
            a(abyte0, i, j);
        }
    }
}
