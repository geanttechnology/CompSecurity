// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.a.a;
import com.google.b.b.a.b;
import com.google.b.b.a.e;
import com.google.b.b.a.g;
import com.google.b.b.a.h;
import com.google.b.b.a.i;
import com.google.b.b.a.j;
import com.google.b.b.a.k;
import com.google.b.b.a.m;
import com.google.b.b.c;
import com.google.b.b.d;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
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

// Referenced classes of package com.google.b:
//            d, v, m, u, 
//            n, x, y, j, 
//            s, e, l

public final class f
{
    static final class a extends x
    {

        x a;

        public final Object a(com.google.b.d.a a1)
        {
            if (a == null)
            {
                throw new IllegalStateException();
            } else
            {
                return a.a(a1);
            }
        }

        public final void a(com.google.b.d.c c1, Object obj)
        {
            if (a == null)
            {
                throw new IllegalStateException();
            } else
            {
                a.a(c1, obj);
                return;
            }
        }

        a()
        {
        }
    }


    final com.google.b.j a;
    final s b;
    private final ThreadLocal c;
    private final Map d;
    private final List e;
    private final c f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public f()
    {
        this(d.a, ((com.google.b.e) (com.google.b.d.a)), Collections.emptyMap(), false, false, false, true, false, false, com.google.b.v.a, Collections.emptyList());
    }

    f(d d1, com.google.b.e e1, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, v v1, List list)
    {
        c = new ThreadLocal();
        d = Collections.synchronizedMap(new HashMap());
        a = new com.google.b.j() {

            final f a;

            public final Object a(l l, Type type)
            {
                return a.a(l, type);
            }

            
            {
                a = f.this;
                super();
            }
        };
        b = new s() {

            final f a;

            public final l a(Object obj)
            {
                return a.a(obj);
            }

            
            {
                a = f.this;
                super();
            }
        };
        f = new c(map);
        g = flag;
        i = flag2;
        h = flag3;
        j = flag4;
        ArrayList arraylist = new ArrayList();
        arraylist.add(m.Q);
        arraylist.add(h.a);
        arraylist.add(d1);
        arraylist.addAll(list);
        arraylist.add(m.x);
        arraylist.add(m.m);
        arraylist.add(m.g);
        arraylist.add(m.i);
        arraylist.add(m.k);
        list = Long.TYPE;
        if (v1 == com.google.b.v.a)
        {
            map = m.n;
        } else
        {
            map = new x() {

                final f a;

                public final Object a(com.google.b.d.a a1)
                {
                    if (a1.f() == com.google.b.d.b.i)
                    {
                        a1.k();
                        return null;
                    } else
                    {
                        return Long.valueOf(a1.m());
                    }
                }

                public final void a(com.google.b.d.c c1, Object obj)
                {
                    obj = (Number)obj;
                    if (obj == null)
                    {
                        c1.f();
                        return;
                    } else
                    {
                        c1.b(obj.toString());
                        return;
                    }
                }

            
            {
                a = f.this;
                super();
            }
            };
        }
        arraylist.add(m.a(list, java/lang/Long, map));
        v1 = Double.TYPE;
        if (flag5)
        {
            map = m.p;
        } else
        {
            map = new x() {

                final f a;

                public final Object a(com.google.b.d.a a1)
                {
                    if (a1.f() == com.google.b.d.b.i)
                    {
                        a1.k();
                        return null;
                    } else
                    {
                        return Double.valueOf(a1.l());
                    }
                }

                public final void a(com.google.b.d.c c1, Object obj)
                {
                    obj = (Number)obj;
                    if (obj == null)
                    {
                        c1.f();
                        return;
                    } else
                    {
                        com.google.b.f.a(((Number) (obj)).doubleValue());
                        c1.a(((Number) (obj)));
                        return;
                    }
                }

            
            {
                a = f.this;
                super();
            }
            };
        }
        arraylist.add(m.a(v1, java/lang/Double, map));
        v1 = Float.TYPE;
        if (flag5)
        {
            map = m.o;
        } else
        {
            map = new x() {

                final f a;

                public final Object a(com.google.b.d.a a1)
                {
                    if (a1.f() == com.google.b.d.b.i)
                    {
                        a1.k();
                        return null;
                    } else
                    {
                        return Float.valueOf((float)a1.l());
                    }
                }

                public final void a(com.google.b.d.c c1, Object obj)
                {
                    obj = (Number)obj;
                    if (obj == null)
                    {
                        c1.f();
                        return;
                    } else
                    {
                        com.google.b.f.a(((Number) (obj)).floatValue());
                        c1.a(((Number) (obj)));
                        return;
                    }
                }

            
            {
                a = f.this;
                super();
            }
            };
        }
        arraylist.add(m.a(v1, java/lang/Float, map));
        arraylist.add(m.r);
        arraylist.add(m.t);
        arraylist.add(m.z);
        arraylist.add(m.B);
        arraylist.add(m.a(java/math/BigDecimal, m.v));
        arraylist.add(m.a(java/math/BigInteger, m.w));
        arraylist.add(m.D);
        arraylist.add(m.F);
        arraylist.add(m.J);
        arraylist.add(m.O);
        arraylist.add(m.H);
        arraylist.add(m.d);
        arraylist.add(com.google.b.b.a.c.a);
        arraylist.add(m.M);
        arraylist.add(k.a);
        arraylist.add(j.a);
        arraylist.add(m.K);
        arraylist.add(com.google.b.b.a.a.a);
        arraylist.add(m.b);
        arraylist.add(new b(f));
        arraylist.add(new g(f, flag1));
        arraylist.add(new com.google.b.b.a.d(f));
        arraylist.add(m.R);
        arraylist.add(new i(f, e1, d1));
        e = Collections.unmodifiableList(arraylist);
    }

    private com.google.b.d.c a(Writer writer)
    {
        if (i)
        {
            writer.write(")]}'\n");
        }
        writer = new com.google.b.d.c(writer);
        if (j)
        {
            writer.c("  ");
        }
        writer.c = g;
        return writer;
    }

    static void a(double d1)
    {
        if (Double.isNaN(d1) || Double.isInfinite(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(d1).append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        } else
        {
            return;
        }
    }

    private static void a(Object obj, com.google.b.d.a a1)
    {
        if (obj != null)
        {
            try
            {
                if (a1.f() != com.google.b.d.b.j)
                {
                    throw new com.google.b.m("JSON document was not fully consumed.");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new u(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new com.google.b.m(((Throwable) (obj)));
            }
        }
    }

    public final l a(Object obj)
    {
        if (obj == null)
        {
            return com.google.b.n.a;
        } else
        {
            Class class1 = obj.getClass();
            com.google.b.b.a.f f1 = new com.google.b.b.a.f();
            a(obj, ((Type) (class1)), ((com.google.b.d.c) (f1)));
            return f1.a();
        }
    }

    public final x a(com.google.b.c.a a1)
    {
        Object obj = (x)d.get(a1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((x) (obj));
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
        obj2 = (a)((Map) (obj1)).get(a1);
        obj = obj2;
        if (obj2 != null) goto _L1; else goto _L3
_L3:
        Iterator iterator;
        obj = new a();
        ((Map) (obj1)).put(a1, obj);
        iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_222;
            }
            obj2 = ((y)iterator.next()).a(this, a1);
        } while (obj2 == null);
        if (((a) (obj)).a != null)
        {
            throw new AssertionError();
        }
        break MISSING_BLOCK_LABEL_177;
        obj;
        ((Map) (obj1)).remove(a1);
        if (flag)
        {
            c.remove();
        }
        throw obj;
        obj.a = ((x) (obj2));
        d.put(a1, obj2);
        ((Map) (obj1)).remove(a1);
        obj = obj2;
        if (!flag) goto _L1; else goto _L4
_L4:
        c.remove();
        return ((x) (obj2));
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(a1).toString());
    }

    public final x a(y y1, com.google.b.c.a a1)
    {
        boolean flag = false;
        if (!e.contains(y1))
        {
            flag = true;
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            Object obj = (y)iterator.next();
            if (!flag)
            {
                if (obj == y1)
                {
                    flag = true;
                }
            } else
            {
                obj = ((y) (obj)).a(this, a1);
                if (obj != null)
                {
                    return ((x) (obj));
                }
            }
        }

        throw new IllegalArgumentException((new StringBuilder("GSON cannot serialize ")).append(a1).toString());
    }

    public final x a(Class class1)
    {
        return a(com.google.b.c.a.a(class1));
    }

    public final Object a(com.google.b.d.a a1, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = a1.b;
        a1.b = true;
        a1.f();
        flag = false;
        type = ((Type) (a(com.google.b.c.a.a(type)).a(a1)));
        a1.b = flag1;
        return type;
        type;
        if (flag)
        {
            a1.b = flag1;
            return null;
        }
        throw new u(type);
        type;
        a1.b = flag1;
        throw type;
        type;
        throw new u(type);
        type;
        throw new u(type);
    }

    public final Object a(l l, Type type)
    {
        if (l == null)
        {
            return null;
        } else
        {
            return a(((com.google.b.d.a) (new e(l))), type);
        }
    }

    public final Object a(Reader reader, Class class1)
    {
        reader = new com.google.b.d.a(reader);
        Object obj = a(((com.google.b.d.a) (reader)), ((Type) (class1)));
        a(obj, ((com.google.b.d.a) (reader)));
        return com.google.b.b.i.a(class1).cast(obj);
    }

    public final Object a(Reader reader, Type type)
    {
        reader = new com.google.b.d.a(reader);
        type = ((Type) (a(((com.google.b.d.a) (reader)), type)));
        a(type, ((com.google.b.d.a) (reader)));
        return type;
    }

    public final Object a(String s, Class class1)
    {
        s = ((String) (a(s, ((Type) (class1)))));
        return com.google.b.b.i.a(class1).cast(s);
    }

    public final Object a(String s, Type type)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return a(((Reader) (new StringReader(s))), type);
        }
    }

    public final void a(l l, com.google.b.d.c c1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = c1.a;
        c1.a = true;
        flag1 = c1.b;
        c1.b = h;
        flag2 = c1.c;
        c1.c = g;
        com.google.b.b.j.a(l, c1);
        c1.a = flag;
        c1.b = flag1;
        c1.c = flag2;
        return;
        l;
        throw new com.google.b.m(l);
        l;
        c1.a = flag;
        c1.b = flag1;
        c1.c = flag2;
        throw l;
    }

    public final void a(l l, Appendable appendable)
    {
        try
        {
            a(l, a(com.google.b.b.j.a(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (l l)
        {
            throw new RuntimeException(l);
        }
    }

    public final void a(Object obj, Type type, com.google.b.d.c c1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        type = a(com.google.b.c.a.a(type));
        flag = c1.a;
        c1.a = true;
        flag1 = c1.b;
        c1.b = h;
        flag2 = c1.c;
        c1.c = g;
        type.a(c1, obj);
        c1.a = flag;
        c1.b = flag1;
        c1.c = flag2;
        return;
        obj;
        throw new com.google.b.m(((Throwable) (obj)));
        obj;
        c1.a = flag;
        c1.b = flag1;
        c1.c = flag2;
        throw obj;
    }

    public final void a(Object obj, Type type, Appendable appendable)
    {
        try
        {
            a(obj, type, a(com.google.b.b.j.a(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new com.google.b.m(((Throwable) (obj)));
        }
    }

    public final String b(Object obj)
    {
        if (obj == null)
        {
            obj = com.google.b.n.a;
            StringWriter stringwriter = new StringWriter();
            a(((l) (obj)), stringwriter);
            return stringwriter.toString();
        } else
        {
            Class class1 = obj.getClass();
            StringWriter stringwriter1 = new StringWriter();
            a(obj, class1, stringwriter1);
            return stringwriter1.toString();
        }
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(g).append("factories:").append(e).append(",instanceCreators:").append(f).append("}").toString();
    }
}
