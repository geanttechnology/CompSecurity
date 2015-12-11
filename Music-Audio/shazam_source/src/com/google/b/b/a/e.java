// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.g;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.i;
import com.google.b.l;
import com.google.b.n;
import com.google.b.o;
import com.google.b.r;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class e extends a
{

    private static final Reader c = new Reader() {

        public final void close()
        {
            throw new AssertionError();
        }

        public final int read(char ac[], int i1, int j1)
        {
            throw new AssertionError();
        }

    };
    private static final Object d = new Object();
    public final List a = new ArrayList();

    public e(l l1)
    {
        super(c);
        a.add(l1);
    }

    private Object q()
    {
        return a.remove(a.size() - 1);
    }

    public final void a()
    {
        a(b.a);
        i i1 = (i)g();
        a.add(i1.iterator());
    }

    public final void a(b b1)
    {
        if (f() != b1)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(b1).append(" but was ").append(f()).toString());
        } else
        {
            return;
        }
    }

    public final void b()
    {
        a(b.b);
        q();
        q();
    }

    public final void c()
    {
        a(b.c);
        o o1 = (o)g();
        a.add(o1.a.entrySet().iterator());
    }

    public final void close()
    {
        a.clear();
        a.add(d);
    }

    public final void d()
    {
        a(b.d);
        q();
        q();
    }

    public final boolean e()
    {
        b b1 = f();
        return b1 != b.d && b1 != b.b;
    }

    public final b f()
    {
        Object obj;
        do
        {
            if (a.isEmpty())
            {
                return b.j;
            }
            obj = g();
            if (!(obj instanceof Iterator))
            {
                break;
            }
            boolean flag = a.get(a.size() - 2) instanceof o;
            obj = (Iterator)obj;
            if (((Iterator) (obj)).hasNext())
            {
                if (flag)
                {
                    return b.e;
                }
                a.add(((Iterator) (obj)).next());
            } else
            if (flag)
            {
                return b.d;
            } else
            {
                return b.b;
            }
        } while (true);
        if (obj instanceof o)
        {
            return b.c;
        }
        if (obj instanceof i)
        {
            return b.a;
        }
        if (obj instanceof r)
        {
            obj = (r)obj;
            if (((r) (obj)).a instanceof String)
            {
                return b.f;
            }
            if (((r) (obj)).a instanceof Boolean)
            {
                return b.h;
            }
            if (((r) (obj)).a instanceof Number)
            {
                return b.g;
            } else
            {
                throw new AssertionError();
            }
        }
        if (obj instanceof n)
        {
            return b.i;
        }
        if (obj == d)
        {
            throw new IllegalStateException("JsonReader is closed");
        } else
        {
            throw new AssertionError();
        }
    }

    public final Object g()
    {
        return a.get(a.size() - 1);
    }

    public final String h()
    {
        a(b.e);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)g()).next();
        a.add(entry.getValue());
        return (String)entry.getKey();
    }

    public final String i()
    {
        b b1 = f();
        if (b1 != b.f && b1 != b.g)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(b.f).append(" but was ").append(b1).toString());
        } else
        {
            return ((r)q()).b();
        }
    }

    public final boolean j()
    {
        a(b.h);
        return ((r)q()).f();
    }

    public final void k()
    {
        a(b.i);
        q();
    }

    public final double l()
    {
        b b1 = f();
        if (b1 != b.g && b1 != b.f)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(b.g).append(" but was ").append(b1).toString());
        }
        double d1 = ((r)g()).c();
        if (!super.b && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new NumberFormatException((new StringBuilder("JSON forbids NaN and infinities: ")).append(d1).toString());
        } else
        {
            q();
            return d1;
        }
    }

    public final long m()
    {
        b b1 = f();
        if (b1 != b.g && b1 != b.f)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(b.g).append(" but was ").append(b1).toString());
        } else
        {
            long l1 = ((r)g()).d();
            q();
            return l1;
        }
    }

    public final int n()
    {
        b b1 = f();
        if (b1 != b.g && b1 != b.f)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(b.g).append(" but was ").append(b1).toString());
        } else
        {
            int i1 = ((r)g()).e();
            q();
            return i1;
        }
    }

    public final void o()
    {
        if (f() == b.e)
        {
            h();
            return;
        } else
        {
            q();
            return;
        }
    }

    public final String toString()
    {
        return getClass().getSimpleName();
    }

}
