// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.a;
import com.millennialmedia.google.gson.internal.k;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
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
import myobfuscated.ad.h;
import myobfuscated.ao.d;
import myobfuscated.ao.g;
import myobfuscated.ao.i;
import myobfuscated.ao.j;
import myobfuscated.ao.m;
import myobfuscated.ao.n;
import myobfuscated.ao.p;

// Referenced classes of package com.millennialmedia.google.gson:
//            FieldNamingPolicy, LongSerializationPolicy, i, JsonSyntaxException, 
//            c, j, JsonIOException, f, 
//            a

public final class b
{

    public final List a;
    private final ThreadLocal b;
    private final Map c;
    private final a d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;

    public b()
    {
        this(com.millennialmedia.google.gson.internal.b.a, ((com.millennialmedia.google.gson.a) (FieldNamingPolicy.IDENTITY)), Collections.emptyMap(), LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    private b(com.millennialmedia.google.gson.internal.b b1, com.millennialmedia.google.gson.a a1, Map map, LongSerializationPolicy longserializationpolicy, List list)
    {
        b = new ThreadLocal();
        c = Collections.synchronizedMap(new HashMap());
        new h() {

        };
        new h() {

        };
        d = new a(map);
        e = false;
        g = false;
        f = true;
        h = false;
        ArrayList arraylist = new ArrayList();
        arraylist.add(p.z);
        arraylist.add(i.a);
        arraylist.add(b1);
        arraylist.addAll(list);
        arraylist.add(p.o);
        arraylist.add(p.g);
        arraylist.add(p.d);
        arraylist.add(p.e);
        arraylist.add(p.f);
        list = Long.TYPE;
        if (longserializationpolicy == LongSerializationPolicy.DEFAULT)
        {
            map = p.h;
        } else
        {
            map = new com.millennialmedia.google.gson.i() {

                public final Object a(com.millennialmedia.google.gson.stream.a a2)
                {
                    if (a2.f() == JsonToken.NULL)
                    {
                        a2.k();
                        return null;
                    } else
                    {
                        return Long.valueOf(a2.m());
                    }
                }

                public final void a(com.millennialmedia.google.gson.stream.b b2, Object obj)
                {
                    obj = (Number)obj;
                    if (obj == null)
                    {
                        b2.e();
                        return;
                    } else
                    {
                        b2.b(obj.toString());
                        return;
                    }
                }

            };
        }
        arraylist.add(p.a(list, java/lang/Long, map));
        arraylist.add(p.a(Double.TYPE, java/lang/Double, new com.millennialmedia.google.gson.i() {

            private b a;

            public final Object a(com.millennialmedia.google.gson.stream.a a2)
            {
                if (a2.f() == JsonToken.NULL)
                {
                    a2.k();
                    return null;
                } else
                {
                    return Double.valueOf(a2.l());
                }
            }

            public final void a(com.millennialmedia.google.gson.stream.b b2, Object obj)
            {
                obj = (Number)obj;
                if (obj == null)
                {
                    b2.e();
                    return;
                } else
                {
                    com.millennialmedia.google.gson.b.a(((Number) (obj)).doubleValue());
                    b2.a(((Number) (obj)));
                    return;
                }
            }

            
            {
                a = b.this;
                super();
            }
        }));
        arraylist.add(p.a(Float.TYPE, java/lang/Float, new com.millennialmedia.google.gson.i() {

            private b a;

            public final Object a(com.millennialmedia.google.gson.stream.a a2)
            {
                if (a2.f() == JsonToken.NULL)
                {
                    a2.k();
                    return null;
                } else
                {
                    return Float.valueOf((float)a2.l());
                }
            }

            public final void a(com.millennialmedia.google.gson.stream.b b2, Object obj)
            {
                obj = (Number)obj;
                if (obj == null)
                {
                    b2.e();
                    return;
                } else
                {
                    com.millennialmedia.google.gson.b.a(((Number) (obj)).floatValue());
                    b2.a(((Number) (obj)));
                    return;
                }
            }

            
            {
                a = b.this;
                super();
            }
        }));
        arraylist.add(p.k);
        arraylist.add(p.l);
        arraylist.add(p.p);
        arraylist.add(p.q);
        arraylist.add(p.a(java/math/BigDecimal, p.m));
        arraylist.add(p.a(java/math/BigInteger, p.n));
        arraylist.add(p.r);
        arraylist.add(p.s);
        arraylist.add(p.u);
        arraylist.add(p.x);
        arraylist.add(p.t);
        arraylist.add(p.b);
        arraylist.add(d.a);
        arraylist.add(p.w);
        arraylist.add(n.a);
        arraylist.add(m.a);
        arraylist.add(p.v);
        arraylist.add(myobfuscated.ao.a.a);
        arraylist.add(p.A);
        arraylist.add(p.a);
        arraylist.add(new myobfuscated.ao.b(d));
        arraylist.add(new g(d, false));
        arraylist.add(new j(d, a1, b1));
        a = Collections.unmodifiableList(arraylist);
    }

    private com.millennialmedia.google.gson.stream.b a(Writer writer)
    {
        writer = new com.millennialmedia.google.gson.stream.b(writer);
        writer.g = false;
        return writer;
    }

    private Object a(com.millennialmedia.google.gson.stream.a a1, Type type)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = a1.b;
        a1.b = true;
        a1.f();
        flag = false;
        type = ((Type) (a(myobfuscated.ap.a.a(type)).a(a1)));
        a1.b = flag1;
        return type;
        type;
        if (flag)
        {
            a1.b = flag1;
            return null;
        }
        throw new JsonSyntaxException(type);
        type;
        a1.b = flag1;
        throw type;
        type;
        throw new JsonSyntaxException(type);
        type;
        throw new JsonSyntaxException(type);
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

    public final com.millennialmedia.google.gson.i a(Class class1)
    {
        return a(new myobfuscated.ap.a(class1));
    }

    public final com.millennialmedia.google.gson.i a(myobfuscated.ap.a a1)
    {
        Object obj = (com.millennialmedia.google.gson.i)c.get(a1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((com.millennialmedia.google.gson.i) (obj));
_L2:
        Object obj1;
        Object obj2;
        boolean flag;
        obj1 = (Map)b.get();
        flag = false;
        if (obj1 == null)
        {
            obj1 = new HashMap();
            b.set(obj1);
            flag = true;
        }
        obj2 = (c)((Map) (obj1)).get(a1);
        obj = obj2;
        if (obj2 != null) goto _L1; else goto _L3
_L3:
        Iterator iterator;
        obj = new c();
        ((Map) (obj1)).put(a1, obj);
        iterator = a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_222;
            }
            obj2 = ((com.millennialmedia.google.gson.j)iterator.next()).a(this, a1);
        } while (obj2 == null);
        if (((c) (obj)).a != null)
        {
            throw new AssertionError();
        }
        break MISSING_BLOCK_LABEL_177;
        obj;
        ((Map) (obj1)).remove(a1);
        if (flag)
        {
            b.remove();
        }
        throw obj;
        obj.a = ((com.millennialmedia.google.gson.i) (obj2));
        c.put(a1, obj2);
        ((Map) (obj1)).remove(a1);
        obj = obj2;
        if (!flag) goto _L1; else goto _L4
_L4:
        b.remove();
        return ((com.millennialmedia.google.gson.i) (obj2));
        throw new IllegalArgumentException((new StringBuilder("GSON cannot handle ")).append(a1).toString());
    }

    public final Object a(String s, Class class1)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return k.a(class1).cast(s);
_L2:
        Object obj;
        com.millennialmedia.google.gson.stream.a a1;
        a1 = new com.millennialmedia.google.gson.stream.a(new StringReader(s));
        obj = a(a1, ((Type) (class1)));
        s = ((String) (obj));
        if (obj == null) goto _L4; else goto _L3
_L3:
        s = ((String) (obj));
        if (a1.f() == JsonToken.END_DOCUMENT) goto _L4; else goto _L5
_L5:
        throw new JsonIOException("JSON document was not fully consumed.");
        s;
        throw new JsonSyntaxException(s);
        s;
        throw new JsonIOException(s);
    }

    public final String a(Object obj)
    {
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        f f1 = com.millennialmedia.google.gson.f.a;
        StringWriter stringwriter = new StringWriter();
        Object obj1;
        boolean flag;
        boolean flag2;
        boolean flag4;
        try
        {
            obj = a(myobfuscated.f.m.a(stringwriter));
            flag = ((com.millennialmedia.google.gson.stream.b) (obj)).e;
            obj.e = true;
            flag2 = ((com.millennialmedia.google.gson.stream.b) (obj)).f;
            obj.f = true;
            flag4 = ((com.millennialmedia.google.gson.stream.b) (obj)).g;
            obj.g = false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        myobfuscated.f.m.a(f1, ((com.millennialmedia.google.gson.stream.b) (obj)));
        obj.e = flag;
        obj.f = flag2;
        obj.g = flag4;
        return stringwriter.toString();
        obj1;
        throw new JsonIOException(((Throwable) (obj1)));
        obj1;
        obj.e = flag;
        obj.f = flag2;
        obj.g = flag4;
        throw obj1;
        Object obj2 = obj.getClass();
        StringWriter stringwriter1 = new StringWriter();
        com.millennialmedia.google.gson.stream.b b1;
        boolean flag1;
        boolean flag3;
        boolean flag5;
        try
        {
            b1 = a(myobfuscated.f.m.a(stringwriter1));
            obj2 = a(myobfuscated.ap.a.a(((Type) (obj2))));
            flag1 = b1.e;
            b1.e = true;
            flag3 = b1.f;
            b1.f = true;
            flag5 = b1.g;
            b1.g = false;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new JsonIOException(((Throwable) (obj)));
        }
        ((com.millennialmedia.google.gson.i) (obj2)).a(b1, obj);
        b1.e = flag1;
        b1.f = flag3;
        b1.g = flag5;
        return stringwriter1.toString();
        obj;
        throw new JsonIOException(((Throwable) (obj)));
        obj;
        b1.e = flag1;
        b1.f = flag3;
        b1.g = flag5;
        throw obj;
    }

    public final String toString()
    {
        return (new StringBuilder("{serializeNulls:false")).append("factories:").append(a).append(",instanceCreators:").append(d).append("}").toString();
    }
}
