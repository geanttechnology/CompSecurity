// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.d;
import com.millennialmedia.google.gson.e;
import com.millennialmedia.google.gson.g;
import com.millennialmedia.google.gson.h;
import com.millennialmedia.google.gson.stream.b;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f extends b
{

    private static final Writer h = new Writer() {

        public final void close()
        {
            throw new AssertionError();
        }

        public final void flush()
        {
            throw new AssertionError();
        }

        public final void write(char ac[], int k, int l)
        {
            throw new AssertionError();
        }

    };
    private static final h i = new h("closed");
    public final List a = new ArrayList();
    public e b;
    private String j;

    public f()
    {
        super(h);
        b = com.millennialmedia.google.gson.f.a;
    }

    private void a(e e1)
    {
        if (j != null)
        {
            if (!(e1 instanceof com.millennialmedia.google.gson.f) || super.g)
            {
                ((g)f()).a(j, e1);
            }
            j = null;
            return;
        }
        if (a.isEmpty())
        {
            b = e1;
            return;
        }
        e e2 = f();
        if (e2 instanceof d)
        {
            ((d)e2).a(e1);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    private e f()
    {
        return (e)a.get(a.size() - 1);
    }

    public final b a()
    {
        d d1 = new d();
        a(((e) (d1)));
        a.add(d1);
        return this;
    }

    public final b a(long l)
    {
        a(((e) (new h(Long.valueOf(l)))));
        return this;
    }

    public final b a(Number number)
    {
        if (number == null)
        {
            return e();
        }
        if (!super.e)
        {
            double d1 = number.doubleValue();
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                throw new IllegalArgumentException((new StringBuilder("JSON forbids NaN and infinities: ")).append(number).toString());
            }
        }
        a(((e) (new h(number))));
        return this;
    }

    public final b a(String s)
    {
        if (a.isEmpty() || j != null)
        {
            throw new IllegalStateException();
        }
        if (f() instanceof g)
        {
            j = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final b a(boolean flag)
    {
        a(((e) (new h(Boolean.valueOf(flag)))));
        return this;
    }

    public final b b()
    {
        if (a.isEmpty() || j != null)
        {
            throw new IllegalStateException();
        }
        if (f() instanceof d)
        {
            a.remove(a.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final b b(String s)
    {
        if (s == null)
        {
            return e();
        } else
        {
            a(new h(s));
            return this;
        }
    }

    public final b c()
    {
        g g1 = new g();
        a(g1);
        a.add(g1);
        return this;
    }

    public final void close()
    {
        if (!a.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            a.add(i);
            return;
        }
    }

    public final b d()
    {
        if (a.isEmpty() || j != null)
        {
            throw new IllegalStateException();
        }
        if (f() instanceof g)
        {
            a.remove(a.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public final b e()
    {
        a(com.millennialmedia.google.gson.f.a);
        return this;
    }

    public final void flush()
    {
    }

}
