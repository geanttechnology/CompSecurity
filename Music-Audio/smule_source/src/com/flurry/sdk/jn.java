// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            jx, jy, id, ij, 
//            il, ii

public final class jn extends jx
{

    private static final Reader a = new Reader() {

        public void close()
        {
            throw new AssertionError();
        }

        public int read(char ac[], int i1, int j1)
        {
            throw new AssertionError();
        }

    };
    private static final Object b = new Object();
    private final List c;

    private void a(jy jy1)
    {
        if (f() != jy1)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jy1).append(" but was ").append(f()).toString());
        } else
        {
            return;
        }
    }

    private Object r()
    {
        return c.get(c.size() - 1);
    }

    private Object s()
    {
        return c.remove(c.size() - 1);
    }

    public void a()
    {
        a(jy.a);
        id id1 = (id)r();
        c.add(id1.iterator());
    }

    public void b()
    {
        a(jy.b);
        s();
        s();
    }

    public void c()
    {
        a(jy.c);
        ij ij1 = (ij)r();
        c.add(ij1.o().iterator());
    }

    public void close()
    {
        c.clear();
        c.add(b);
    }

    public void d()
    {
        a(jy.d);
        s();
        s();
    }

    public boolean e()
    {
        jy jy1 = f();
        return jy1 != jy.d && jy1 != jy.b;
    }

    public jy f()
    {
        if (c.isEmpty())
        {
            return jy.j;
        }
        Object obj = r();
        if (obj instanceof Iterator)
        {
            boolean flag = c.get(c.size() - 2) instanceof ij;
            obj = (Iterator)obj;
            if (((Iterator) (obj)).hasNext())
            {
                if (flag)
                {
                    return jy.e;
                } else
                {
                    c.add(((Iterator) (obj)).next());
                    return f();
                }
            }
            if (flag)
            {
                return jy.d;
            } else
            {
                return jy.b;
            }
        }
        if (obj instanceof ij)
        {
            return jy.c;
        }
        if (obj instanceof id)
        {
            return jy.a;
        }
        if (obj instanceof il)
        {
            obj = (il)obj;
            if (((il) (obj)).q())
            {
                return jy.f;
            }
            if (((il) (obj)).o())
            {
                return jy.h;
            }
            if (((il) (obj)).p())
            {
                return jy.g;
            } else
            {
                throw new AssertionError();
            }
        }
        if (obj instanceof ii)
        {
            return jy.i;
        }
        if (obj == b)
        {
            throw new IllegalStateException("JsonReader is closed");
        } else
        {
            throw new AssertionError();
        }
    }

    public String g()
    {
        a(jy.e);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)r()).next();
        c.add(entry.getValue());
        return (String)entry.getKey();
    }

    public String h()
    {
        jy jy1 = f();
        if (jy1 != jy.f && jy1 != jy.g)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jy.f).append(" but was ").append(jy1).toString());
        } else
        {
            return ((il)s()).b();
        }
    }

    public boolean i()
    {
        a(jy.h);
        return ((il)s()).f();
    }

    public void j()
    {
        a(jy.i);
        s();
    }

    public double k()
    {
        jy jy1 = f();
        if (jy1 != jy.g && jy1 != jy.f)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jy.g).append(" but was ").append(jy1).toString());
        }
        double d1 = ((il)r()).c();
        if (!p() && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new NumberFormatException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(d1).toString());
        } else
        {
            s();
            return d1;
        }
    }

    public long l()
    {
        jy jy1 = f();
        if (jy1 != jy.g && jy1 != jy.f)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jy.g).append(" but was ").append(jy1).toString());
        } else
        {
            long l1 = ((il)r()).d();
            s();
            return l1;
        }
    }

    public int m()
    {
        jy jy1 = f();
        if (jy1 != jy.g && jy1 != jy.f)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jy.g).append(" but was ").append(jy1).toString());
        } else
        {
            int i1 = ((il)r()).e();
            s();
            return i1;
        }
    }

    public void n()
    {
        if (f() == jy.e)
        {
            g();
            return;
        } else
        {
            s();
            return;
        }
    }

    public void o()
    {
        a(jy.e);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)r()).next();
        c.add(entry.getValue());
        c.add(new il((String)entry.getKey()));
    }

    public String toString()
    {
        return getClass().getSimpleName();
    }

}
