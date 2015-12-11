// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            jb, hy, ip, ja, 
//            jv, jq, jl, jt, 
//            js, jj, jk, jp, 
//            jm, jr, jz, ka, 
//            jx, jy, ih, io, 
//            is, ir, jw, jg, 
//            jh, ii, ie, im, 
//            hz, ig

public final class ia
{

    final ie a;
    final im b;
    private final ThreadLocal c;
    private final Map d;
    private final List e;
    private final ja f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public ia()
    {
        this(jb.a, ((hz) (hy.a)), Collections.emptyMap(), false, false, false, true, false, false, ip.a, Collections.emptyList());
    }

    ia(jb jb1, hz hz, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, ip ip1, List list)
    {
        c = new ThreadLocal();
        d = Collections.synchronizedMap(new HashMap());
        a = new ie() {

            final ia a;

            
            {
                a = ia.this;
                super();
            }
        };
        b = new im() {

            final ia a;

            
            {
                a = ia.this;
                super();
            }
        };
        f = new ja(map);
        g = flag;
        i = flag2;
        h = flag3;
        j = flag4;
        map = new ArrayList();
        map.add(jv.Q);
        map.add(jq.a);
        map.add(jb1);
        map.addAll(list);
        map.add(jv.x);
        map.add(jv.m);
        map.add(jv.g);
        map.add(jv.i);
        map.add(jv.k);
        map.add(jv.a(Long.TYPE, java/lang/Long, a(ip1)));
        map.add(jv.a(Double.TYPE, java/lang/Double, a(flag5)));
        map.add(jv.a(Float.TYPE, java/lang/Float, b(flag5)));
        map.add(jv.r);
        map.add(jv.t);
        map.add(jv.z);
        map.add(jv.B);
        map.add(jv.a(java/math/BigDecimal, jv.v));
        map.add(jv.a(java/math/BigInteger, jv.w));
        map.add(jv.D);
        map.add(jv.F);
        map.add(jv.J);
        map.add(jv.O);
        map.add(jv.H);
        map.add(jv.d);
        map.add(jl.a);
        map.add(jv.M);
        map.add(jt.a);
        map.add(js.a);
        map.add(jv.K);
        map.add(jj.a);
        map.add(jv.R);
        map.add(jv.b);
        map.add(new jk(f));
        map.add(new jp(f, flag1));
        map.add(new jm(f));
        map.add(new jr(f, hz, jb1));
        e = Collections.unmodifiableList(map);
    }

    private ir a(ip ip1)
    {
        if (ip1 == ip.a)
        {
            return jv.n;
        } else
        {
            return new ir() {

                final ia a;

                public Number a(jx jx1)
                {
                    if (jx1.f() == jy.i)
                    {
                        jx1.j();
                        return null;
                    } else
                    {
                        return Long.valueOf(jx1.l());
                    }
                }

                public void a(jz jz1, Number number)
                {
                    if (number == null)
                    {
                        jz1.f();
                        return;
                    } else
                    {
                        jz1.b(number.toString());
                        return;
                    }
                }

                public volatile void a(jz jz1, Object obj)
                {
                    a(jz1, (Number)obj);
                }

                public Object b(jx jx1)
                {
                    return a(jx1);
                }

            
            {
                a = ia.this;
                super();
            }
            };
        }
    }

    private ir a(boolean flag)
    {
        if (flag)
        {
            return jv.p;
        } else
        {
            return new ir() {

                final ia a;

                public Double a(jx jx1)
                {
                    if (jx1.f() == jy.i)
                    {
                        jx1.j();
                        return null;
                    } else
                    {
                        return Double.valueOf(jx1.k());
                    }
                }

                public void a(jz jz1, Number number)
                {
                    if (number == null)
                    {
                        jz1.f();
                        return;
                    } else
                    {
                        double d1 = number.doubleValue();
                        ia.a(a, d1);
                        jz1.a(number);
                        return;
                    }
                }

                public volatile void a(jz jz1, Object obj)
                {
                    a(jz1, (Number)obj);
                }

                public Object b(jx jx1)
                {
                    return a(jx1);
                }

            
            {
                a = ia.this;
                super();
            }
            };
        }
    }

    private jz a(Writer writer)
    {
        if (i)
        {
            writer.write(")]}'\n");
        }
        writer = new jz(writer);
        if (j)
        {
            writer.c("  ");
        }
        writer.d(g);
        return writer;
    }

    private void a(double d1)
    {
        if (Double.isNaN(d1) || Double.isInfinite(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d1).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        } else
        {
            return;
        }
    }

    static void a(ia ia1, double d1)
    {
        ia1.a(d1);
    }

    private static void a(Object obj, jx jx1)
    {
        if (obj != null)
        {
            try
            {
                if (jx1.f() != jy.j)
                {
                    throw new ih("JSON document was not fully consumed.");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new io(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ih(((Throwable) (obj)));
            }
        }
    }

    private ir b(boolean flag)
    {
        if (flag)
        {
            return jv.o;
        } else
        {
            return new ir() {

                final ia a;

                public Float a(jx jx1)
                {
                    if (jx1.f() == jy.i)
                    {
                        jx1.j();
                        return null;
                    } else
                    {
                        return Float.valueOf((float)jx1.k());
                    }
                }

                public void a(jz jz1, Number number)
                {
                    if (number == null)
                    {
                        jz1.f();
                        return;
                    } else
                    {
                        float f1 = number.floatValue();
                        ia.a(a, f1);
                        jz1.a(number);
                        return;
                    }
                }

                public volatile void a(jz jz1, Object obj)
                {
                    a(jz1, (Number)obj);
                }

                public Object b(jx jx1)
                {
                    return a(jx1);
                }

            
            {
                a = ia.this;
                super();
            }
            };
        }
    }

    public ir a(is is1, jw jw1)
    {
        Iterator iterator = e.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            Object obj = (is)iterator.next();
            if (!flag)
            {
                if (obj == is1)
                {
                    flag = true;
                }
            } else
            {
                obj = ((is) (obj)).a(this, jw1);
                if (obj != null)
                {
                    return ((ir) (obj));
                }
            }
        }
        throw new IllegalArgumentException((new StringBuilder()).append("GSON cannot serialize ").append(jw1).toString());
    }

    public ir a(jw jw1)
    {
        Object obj = (ir)d.get(jw1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((ir) (obj));
_L2:
        Object obj1;
        Object obj2;
        boolean flag;
        obj1 = (Map)c.get();
        flag = false;
        if (obj1 == null)
        {
            obj1 = new HashMap();
            c.set(obj1);
            flag = true;
        }
        obj2 = (a)((Map) (obj1)).get(jw1);
        obj = obj2;
        if (obj2 != null) goto _L1; else goto _L3
_L3:
        Iterator iterator;
        obj = new a();
        ((Map) (obj1)).put(jw1, obj);
        iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_184;
            }
            obj2 = ((is)iterator.next()).a(this, jw1);
        } while (obj2 == null);
        ((a) (obj)).a(((ir) (obj2)));
        d.put(jw1, obj2);
        ((Map) (obj1)).remove(jw1);
        obj = obj2;
        if (!flag) goto _L1; else goto _L4
_L4:
        c.remove();
        return ((ir) (obj2));
        throw new IllegalArgumentException((new StringBuilder()).append("GSON cannot handle ").append(jw1).toString());
        Exception exception;
        exception;
        ((Map) (obj1)).remove(jw1);
        if (flag)
        {
            c.remove();
        }
        throw exception;
    }

    public ir a(Class class1)
    {
        return a(jw.b(class1));
    }

    public Object a(jx jx1, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = jx1.p();
        jx1.a(true);
        jx1.f();
        flag = false;
        type = ((Type) (a(jw.a(type)).b(jx1)));
        jx1.a(flag1);
        return type;
        type;
        if (flag)
        {
            jx1.a(flag1);
            return null;
        }
        throw new io(type);
        type;
        jx1.a(flag1);
        throw type;
        type;
        throw new io(type);
        type;
        throw new io(type);
    }

    public Object a(Reader reader, Class class1)
    {
        reader = new jx(reader);
        Object obj = a(((jx) (reader)), ((Type) (class1)));
        a(obj, ((jx) (reader)));
        return jg.a(class1).cast(obj);
    }

    public void a(ig ig, jz jz1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = jz1.g();
        jz1.b(true);
        flag1 = jz1.h();
        jz1.c(h);
        flag2 = jz1.i();
        jz1.d(g);
        jh.a(ig, jz1);
        jz1.b(flag);
        jz1.c(flag1);
        jz1.d(flag2);
        return;
        ig;
        throw new ih(ig);
        ig;
        jz1.b(flag);
        jz1.c(flag1);
        jz1.d(flag2);
        throw ig;
    }

    public void a(ig ig, Appendable appendable)
    {
        try
        {
            a(ig, a(jh.a(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ig ig)
        {
            throw new RuntimeException(ig);
        }
    }

    public void a(Object obj, Appendable appendable)
    {
        if (obj != null)
        {
            a(obj, ((Type) (obj.getClass())), appendable);
            return;
        } else
        {
            a(((ig) (ii.a)), appendable);
            return;
        }
    }

    public void a(Object obj, Type type, jz jz1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        type = a(jw.a(type));
        flag = jz1.g();
        jz1.b(true);
        flag1 = jz1.h();
        jz1.c(h);
        flag2 = jz1.i();
        jz1.d(g);
        type.a(jz1, obj);
        jz1.b(flag);
        jz1.c(flag1);
        jz1.d(flag2);
        return;
        obj;
        throw new ih(((Throwable) (obj)));
        obj;
        jz1.b(flag);
        jz1.c(flag1);
        jz1.d(flag2);
        throw obj;
    }

    public void a(Object obj, Type type, Appendable appendable)
    {
        try
        {
            a(obj, type, a(jh.a(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ih(((Throwable) (obj)));
        }
    }

    public String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(g).append("factories:").append(e).append(",instanceCreators:").append(f).append("}").toString();
    }

    private class a extends ir
    {

        private ir a;

        public void a(ir ir1)
        {
            if (a != null)
            {
                throw new AssertionError();
            } else
            {
                a = ir1;
                return;
            }
        }

        public void a(jz jz1, Object obj)
        {
            if (a == null)
            {
                throw new IllegalStateException();
            } else
            {
                a.a(jz1, obj);
                return;
            }
        }

        public Object b(jx jx1)
        {
            if (a == null)
            {
                throw new IllegalStateException();
            } else
            {
                return a.b(jx1);
            }
        }

        a()
        {
        }
    }

}
