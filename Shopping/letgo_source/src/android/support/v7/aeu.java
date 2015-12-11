// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
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

// Referenced classes of package android.support.v7:
//            afv, aes, afj, afu, 
//            agp, agk, agf, agn, 
//            agm, agd, age, agj, 
//            agg, agl, afb, afi, 
//            afm, afl, agq, aga, 
//            agh, afc, agb, aey, 
//            afg, aet, afa

public final class aeu
{
    static class a extends afl
    {

        private afl a;

        public void a(afl afl1)
        {
            if (a != null)
            {
                throw new AssertionError();
            } else
            {
                a = afl1;
                return;
            }
        }

        public void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            if (a == null)
            {
                throw new IllegalStateException();
            } else
            {
                a.a(jsonwriter, obj);
                return;
            }
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            if (a == null)
            {
                throw new IllegalStateException();
            } else
            {
                return a.b(jsonreader);
            }
        }

        a()
        {
        }
    }


    final aey a;
    final afg b;
    private final ThreadLocal c;
    private final Map d;
    private final List e;
    private final afu f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;

    public aeu()
    {
        this(afv.a, ((aet) (aes.a)), Collections.emptyMap(), false, false, false, true, false, false, afj.a, Collections.emptyList());
    }

    aeu(afv afv1, aet aet, Map map, boolean flag, boolean flag1, boolean flag2, boolean flag3, 
            boolean flag4, boolean flag5, afj afj1, List list)
    {
        c = new ThreadLocal();
        d = Collections.synchronizedMap(new HashMap());
        a = new aey() {

            final aeu a;

            
            {
                a = aeu.this;
                super();
            }
        };
        b = new afg() {

            final aeu a;

            
            {
                a = aeu.this;
                super();
            }
        };
        f = new afu(map);
        g = flag;
        i = flag2;
        h = flag3;
        j = flag4;
        map = new ArrayList();
        map.add(agp.Q);
        map.add(agk.a);
        map.add(afv1);
        map.addAll(list);
        map.add(agp.x);
        map.add(agp.m);
        map.add(agp.g);
        map.add(agp.i);
        map.add(agp.k);
        map.add(agp.a(Long.TYPE, java/lang/Long, a(afj1)));
        map.add(agp.a(Double.TYPE, java/lang/Double, a(flag5)));
        map.add(agp.a(Float.TYPE, java/lang/Float, b(flag5)));
        map.add(agp.r);
        map.add(agp.t);
        map.add(agp.z);
        map.add(agp.B);
        map.add(agp.a(java/math/BigDecimal, agp.v));
        map.add(agp.a(java/math/BigInteger, agp.w));
        map.add(agp.D);
        map.add(agp.F);
        map.add(agp.J);
        map.add(agp.O);
        map.add(agp.H);
        map.add(agp.d);
        map.add(agf.a);
        map.add(agp.M);
        map.add(agn.a);
        map.add(agm.a);
        map.add(agp.K);
        map.add(agd.a);
        map.add(agp.b);
        map.add(new age(f));
        map.add(new agj(f, flag1));
        map.add(new agg(f));
        map.add(agp.R);
        map.add(new agl(f, aet, afv1));
        e = Collections.unmodifiableList(map);
    }

    private afl a(afj afj1)
    {
        if (afj1 == afj.a)
        {
            return agp.n;
        } else
        {
            return new afl() {

                final aeu a;

                public Number a(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Long.valueOf(jsonreader.nextLong());
                    }
                }

                public void a(JsonWriter jsonwriter, Number number)
                    throws IOException
                {
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        jsonwriter.value(number.toString());
                        return;
                    }
                }

                public volatile void a(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    a(jsonwriter, (Number)obj);
                }

                public Object b(JsonReader jsonreader)
                    throws IOException
                {
                    return a(jsonreader);
                }

            
            {
                a = aeu.this;
                super();
            }
            };
        }
    }

    private afl a(boolean flag)
    {
        if (flag)
        {
            return agp.p;
        } else
        {
            return new afl() {

                final aeu a;

                public Double a(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Double.valueOf(jsonreader.nextDouble());
                    }
                }

                public void a(JsonWriter jsonwriter, Number number)
                    throws IOException
                {
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        double d1 = number.doubleValue();
                        aeu.a(a, d1);
                        jsonwriter.value(number);
                        return;
                    }
                }

                public volatile void a(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    a(jsonwriter, (Number)obj);
                }

                public Object b(JsonReader jsonreader)
                    throws IOException
                {
                    return a(jsonreader);
                }

            
            {
                a = aeu.this;
                super();
            }
            };
        }
    }

    private JsonWriter a(Writer writer)
        throws IOException
    {
        if (i)
        {
            writer.write(")]}'\n");
        }
        writer = new JsonWriter(writer);
        if (j)
        {
            writer.setIndent("  ");
        }
        writer.setSerializeNulls(g);
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

    static void a(aeu aeu1, double d1)
    {
        aeu1.a(d1);
    }

    private static void a(Object obj, JsonReader jsonreader)
    {
        if (obj != null)
        {
            try
            {
                if (jsonreader.peek() != JsonToken.END_DOCUMENT)
                {
                    throw new afb("JSON document was not fully consumed.");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new afi(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new afb(((Throwable) (obj)));
            }
        }
    }

    private afl b(boolean flag)
    {
        if (flag)
        {
            return agp.o;
        } else
        {
            return new afl() {

                final aeu a;

                public Float a(JsonReader jsonreader)
                    throws IOException
                {
                    if (jsonreader.peek() == JsonToken.NULL)
                    {
                        jsonreader.nextNull();
                        return null;
                    } else
                    {
                        return Float.valueOf((float)jsonreader.nextDouble());
                    }
                }

                public void a(JsonWriter jsonwriter, Number number)
                    throws IOException
                {
                    if (number == null)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        float f1 = number.floatValue();
                        aeu.a(a, f1);
                        jsonwriter.value(number);
                        return;
                    }
                }

                public volatile void a(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    a(jsonwriter, (Number)obj);
                }

                public Object b(JsonReader jsonreader)
                    throws IOException
                {
                    return a(jsonreader);
                }

            
            {
                a = aeu.this;
                super();
            }
            };
        }
    }

    public afl a(afm afm1, agq agq1)
    {
        boolean flag = false;
        if (!e.contains(afm1))
        {
            flag = true;
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            Object obj = (afm)iterator.next();
            if (!flag)
            {
                if (obj == afm1)
                {
                    flag = true;
                }
            } else
            {
                obj = ((afm) (obj)).a(this, agq1);
                if (obj != null)
                {
                    return ((afl) (obj));
                }
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("GSON cannot serialize ").append(agq1).toString());
    }

    public afl a(agq agq1)
    {
        Object obj = (afl)d.get(agq1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        return ((afl) (obj));
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
        obj2 = (a)((Map) (obj1)).get(agq1);
        obj = obj2;
        if (obj2 != null) goto _L1; else goto _L3
_L3:
        Iterator iterator;
        obj = new a();
        ((Map) (obj1)).put(agq1, obj);
        iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_184;
            }
            obj2 = ((afm)iterator.next()).a(this, agq1);
        } while (obj2 == null);
        ((a) (obj)).a(((afl) (obj2)));
        d.put(agq1, obj2);
        ((Map) (obj1)).remove(agq1);
        obj = obj2;
        if (!flag) goto _L1; else goto _L4
_L4:
        c.remove();
        return ((afl) (obj2));
        throw new IllegalArgumentException((new StringBuilder()).append("GSON cannot handle ").append(agq1).toString());
        Exception exception;
        exception;
        ((Map) (obj1)).remove(agq1);
        if (flag)
        {
            c.remove();
        }
        throw exception;
    }

    public afl a(Class class1)
    {
        return a(agq.b(class1));
    }

    public Object a(afa afa, Class class1)
        throws afi
    {
        afa = ((afa) (a(afa, ((Type) (class1)))));
        return aga.a(class1).cast(afa);
    }

    public Object a(afa afa, Type type)
        throws afi
    {
        if (afa == null)
        {
            return null;
        } else
        {
            return a(((JsonReader) (new agh(afa))), type);
        }
    }

    public Object a(JsonReader jsonreader, Type type)
        throws afb, afi
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = jsonreader.isLenient();
        jsonreader.setLenient(true);
        jsonreader.peek();
        flag = false;
        type = ((Type) (a(agq.a(type)).b(jsonreader)));
        jsonreader.setLenient(flag1);
        return type;
        type;
        if (flag)
        {
            jsonreader.setLenient(flag1);
            return null;
        }
        throw new afi(type);
        type;
        jsonreader.setLenient(flag1);
        throw type;
        type;
        throw new afi(type);
        type;
        throw new afi(type);
    }

    public Object a(Reader reader, Class class1)
        throws afi, afb
    {
        reader = new JsonReader(reader);
        Object obj = a(((JsonReader) (reader)), ((Type) (class1)));
        a(obj, ((JsonReader) (reader)));
        return aga.a(class1).cast(obj);
    }

    public Object a(Reader reader, Type type)
        throws afb, afi
    {
        reader = new JsonReader(reader);
        type = ((Type) (a(((JsonReader) (reader)), type)));
        a(type, ((JsonReader) (reader)));
        return type;
    }

    public Object a(String s, Class class1)
        throws afi
    {
        s = ((String) (a(s, ((Type) (class1)))));
        return aga.a(class1).cast(s);
    }

    public Object a(String s, Type type)
        throws afi
    {
        if (s == null)
        {
            return null;
        } else
        {
            return a(((Reader) (new StringReader(s))), type);
        }
    }

    public String a(afa afa)
    {
        StringWriter stringwriter = new StringWriter();
        a(afa, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    public String a(Object obj)
    {
        if (obj == null)
        {
            return a(((afa) (afc.a)));
        } else
        {
            return a(obj, ((Type) (obj.getClass())));
        }
    }

    public String a(Object obj, Type type)
    {
        StringWriter stringwriter = new StringWriter();
        a(obj, type, ((Appendable) (stringwriter)));
        return stringwriter.toString();
    }

    public void a(afa afa, JsonWriter jsonwriter)
        throws afb
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(h);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(g);
        agb.a(afa, jsonwriter);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        afa;
        throw new afb(afa);
        afa;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw afa;
    }

    public void a(afa afa, Appendable appendable)
        throws afb
    {
        try
        {
            a(afa, a(agb.a(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (afa afa)
        {
            throw new RuntimeException(afa);
        }
    }

    public void a(Object obj, Appendable appendable)
        throws afb
    {
        if (obj != null)
        {
            a(obj, ((Type) (obj.getClass())), appendable);
            return;
        } else
        {
            a(((afa) (afc.a)), appendable);
            return;
        }
    }

    public void a(Object obj, Type type, JsonWriter jsonwriter)
        throws afb
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        type = a(agq.a(type));
        flag = jsonwriter.isLenient();
        jsonwriter.setLenient(true);
        flag1 = jsonwriter.isHtmlSafe();
        jsonwriter.setHtmlSafe(h);
        flag2 = jsonwriter.getSerializeNulls();
        jsonwriter.setSerializeNulls(g);
        type.a(jsonwriter, obj);
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        return;
        obj;
        throw new afb(((Throwable) (obj)));
        obj;
        jsonwriter.setLenient(flag);
        jsonwriter.setHtmlSafe(flag1);
        jsonwriter.setSerializeNulls(flag2);
        throw obj;
    }

    public void a(Object obj, Type type, Appendable appendable)
        throws afb
    {
        try
        {
            a(obj, type, a(agb.a(appendable)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new afb(((Throwable) (obj)));
        }
    }

    public String toString()
    {
        return (new StringBuilder("{serializeNulls:")).append(g).append("factories:").append(e).append(",instanceCreators:").append(f).append("}").toString();
    }
}
