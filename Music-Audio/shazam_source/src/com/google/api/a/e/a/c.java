// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e.a;

import com.google.api.a.e.f;
import com.google.api.a.e.i;
import com.google.api.a.g.w;
import com.google.b.d.a;
import com.google.b.d.b;
import java.io.EOFException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.api.a.e.a:
//            a

final class c extends f
{

    private final a a;
    private final com.google.api.a.e.a.a b;
    private List c;
    private i d;
    private String e;

    c(com.google.api.a.e.a.a a1, a a2)
    {
        c = new ArrayList();
        b = a1;
        a = a2;
        a2.b = true;
    }

    private void p()
    {
        boolean flag;
        if (d == i.g || d == i.h)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
    }

    public final void a()
    {
        a.close();
    }

    public final String b()
    {
        if (c.isEmpty())
        {
            return null;
        } else
        {
            return (String)c.get(c.size() - 1);
        }
    }

    public final i c()
    {
        return d;
    }

    public final com.google.api.a.e.c d()
    {
        return b;
    }

    public final byte e()
    {
        p();
        return Byte.valueOf(e).byteValue();
    }

    public final short f()
    {
        p();
        return Short.valueOf(e).shortValue();
    }

    public final int g()
    {
        p();
        return Integer.valueOf(e).intValue();
    }

    public final float h()
    {
        p();
        return Float.valueOf(e).floatValue();
    }

    public final BigInteger i()
    {
        p();
        return new BigInteger(e);
    }

    public final BigDecimal j()
    {
        p();
        return new BigDecimal(e);
    }

    public final double k()
    {
        p();
        return Double.valueOf(e).doubleValue();
    }

    public final long l()
    {
        p();
        return Long.valueOf(e).longValue();
    }

    public final String m()
    {
        return e;
    }

    public final i n()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        static final class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.google.b.d.b.values().length];
                try
                {
                    b[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    b[b.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[b.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    b[b.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[b.h.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[b.i.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[b.f.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[b.g.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    b[b.e.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                a = new int[com.google.api.a.e.i.values().length];
                try
                {
                    a[i.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[i.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.google.api.a.e.a._cls1.a[d.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 123
    //                   2 144;
           goto _L2 _L3 _L4
_L2:
        b b1;
        try
        {
            b1 = a.f();
        }
        catch (EOFException eofexception)
        {
            eofexception = b.j;
        }
        com.google.api.a.e.a._cls1.b[b1.ordinal()];
        JVM INSTR tableswitch 1 9: default 108
    //                   1 173
    //                   2 189
    //                   3 233
    //                   4 249
    //                   5 293
    //                   6 335
    //                   7 358
    //                   8 379
    //                   9 422;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_422;
_L5:
        e = null;
        d = null;
_L15:
        return d;
_L3:
        a.a();
        c.add(null);
          goto _L2
_L4:
        a.c();
        c.add(null);
          goto _L2
_L6:
        e = "[";
        d = i.a;
          goto _L15
_L7:
        e = "]";
        d = i.b;
        c.remove(c.size() - 1);
        a.b();
          goto _L15
_L8:
        e = "{";
        d = i.c;
          goto _L15
_L9:
        e = "}";
        d = i.d;
        c.remove(c.size() - 1);
        a.d();
          goto _L15
_L10:
        if (a.j())
        {
            e = "true";
            d = i.i;
        } else
        {
            e = "false";
            d = i.j;
        }
          goto _L15
_L11:
        e = "null";
        d = i.k;
        a.k();
          goto _L15
_L12:
        e = a.i();
        d = i.f;
          goto _L15
_L13:
        e = a.i();
        i i1;
        if (e.indexOf('.') == -1)
        {
            i1 = i.g;
        } else
        {
            i1 = i.h;
        }
        d = i1;
          goto _L15
        e = a.h();
        d = i.e;
        c.set(c.size() - 1, e);
          goto _L15
    }

    public final f o()
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        com.google.api.a.e.a._cls1.a[d.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 42
    //                   2 64;
           goto _L2 _L3 _L4
_L2:
        return this;
_L3:
        a.o();
        e = "]";
        d = i.b;
        return this;
_L4:
        a.o();
        e = "}";
        d = i.d;
        return this;
    }
}
