// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            jz, il, ii, ig, 
//            ij, id

public final class jo extends jz
{

    private static final Writer a = new Writer() {

        public void close()
        {
            throw new AssertionError();
        }

        public void flush()
        {
            throw new AssertionError();
        }

        public void write(char ac[], int i, int k)
        {
            throw new AssertionError();
        }

    };
    private static final il b = new il("closed");
    private final List c = new ArrayList();
    private String d;
    private ig e;

    public jo()
    {
        super(a);
        e = ii.a;
    }

    private void a(ig ig1)
    {
        if (d != null)
        {
            if (!ig1.j() || i())
            {
                ((ij)j()).a(d, ig1);
            }
            d = null;
            return;
        }
        if (c.isEmpty())
        {
            e = ig1;
            return;
        }
        ig ig2 = j();
        if (ig2 instanceof id)
        {
            ((id)ig2).a(ig1);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    private ig j()
    {
        return (ig)c.get(c.size() - 1);
    }

    public ig a()
    {
        if (!c.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected one JSON element but was ").append(c).toString());
        } else
        {
            return e;
        }
    }

    public jz a(long l)
    {
        a(((ig) (new il(Long.valueOf(l)))));
        return this;
    }

    public jz a(Number number)
    {
        if (number == null)
        {
            return f();
        }
        if (!g())
        {
            double d1 = number.doubleValue();
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(number).toString());
            }
        }
        a(((ig) (new il(number))));
        return this;
    }

    public jz a(String s)
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (j() instanceof ij)
        {
            d = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public jz a(boolean flag)
    {
        a(((ig) (new il(Boolean.valueOf(flag)))));
        return this;
    }

    public jz b()
    {
        id id1 = new id();
        a(id1);
        c.add(id1);
        return this;
    }

    public jz b(String s)
    {
        if (s == null)
        {
            return f();
        } else
        {
            a(new il(s));
            return this;
        }
    }

    public jz c()
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (j() instanceof id)
        {
            c.remove(c.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public void close()
    {
        if (!c.isEmpty())
        {
            throw new IOException("Incomplete document");
        } else
        {
            c.add(b);
            return;
        }
    }

    public jz d()
    {
        ij ij1 = new ij();
        a(ij1);
        c.add(ij1);
        return this;
    }

    public jz e()
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (j() instanceof ij)
        {
            c.remove(c.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public jz f()
    {
        a(ii.a);
        return this;
    }

    public void flush()
    {
    }

}
