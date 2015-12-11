// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.c;
import com.google.b.i;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f extends c
{

    private static final Writer d = new Writer() {

        public final void close()
        {
            throw new AssertionError();
        }

        public final void flush()
        {
            throw new AssertionError();
        }

        public final void write(char ac[], int j, int k)
        {
            throw new AssertionError();
        }

    };
    private static final r e = new r("closed");
    private final List f = new ArrayList();
    private String g;
    private l h;

    public f()
    {
        super(d);
        h = n.a;
    }

    private void a(l l1)
    {
        if (g != null)
        {
            if (!(l1 instanceof n) || super.c)
            {
                ((o)g()).a(g, l1);
            }
            g = null;
            return;
        }
        if (f.isEmpty())
        {
            h = l1;
            return;
        }
        l l2 = g();
        if (l2 instanceof i)
        {
            ((i)l2).a(l1);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    private l g()
    {
        return (l)f.get(f.size() - 1);
    }

    public final c a(double d1)
    {
        if (!super.a && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(d1).toString());
        } else
        {
            a(((l) (new r(Double.valueOf(d1)))));
            return this;
        }
    }

    public final c a(long l1)
    {
        a(((l) (new r(Long.valueOf(l1)))));
        return this;
    }

    public final c a(Number number)
    {
        if (number == null)
        {
            return f();
        }
        if (!super.a)
        {
            double d1 = number.doubleValue();
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(number).toString());
            }
        }
        a(((l) (new r(number))));
        return this;
    }

    public final c a(String s)
    {
        if (f.isEmpty() || g != null)
        {
            throw new IllegalStateException();
        }
        if (g() instanceof o)
        {
            g = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final c a(boolean flag)
    {
        a(((l) (new r(Boolean.valueOf(flag)))));
        return this;
    }

    public final l a()
    {
        if (!f.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder("Expected one JSON element but was ")).append(f).toString());
        } else
        {
            return h;
        }
    }

    public final c b()
    {
        i j = new i();
        a(j);
        f.add(j);
        return this;
    }

    public final c b(String s)
    {
        if (s == null)
        {
            return f();
        } else
        {
            a(new r(s));
            return this;
        }
    }

    public final c c()
    {
        if (f.isEmpty() || g != null)
        {
            throw new IllegalStateException();
        }
        if (g() instanceof i)
        {
            f.remove(f.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final void close()
    {
        if (!f.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            f.add(e);
            return;
        }
    }

    public final c d()
    {
        o o1 = new o();
        a(o1);
        f.add(o1);
        return this;
    }

    public final c e()
    {
        if (f.isEmpty() || g != null)
        {
            throw new IllegalStateException();
        }
        if (g() instanceof o)
        {
            f.remove(f.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final c f()
    {
        a(n.a);
        return this;
    }

    public final void flush()
    {
    }

}
