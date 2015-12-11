// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.tapjoy.internal:
//            bx, bs, by, ab

public final class ca
    implements Closeable
{

    private final Writer a;
    private final List b = new ArrayList();
    private String c;
    private String d;
    private boolean e;

    public ca(Writer writer)
    {
        b.add(bx.f);
        d = ":";
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            a = writer;
            return;
        }
    }

    private ca a(bx bx1, bx bx2, String s)
    {
        bx bx3 = f();
        if (bx3 != bx2 && bx3 != bx1)
        {
            throw new IllegalStateException((new StringBuilder("Nesting problem: ")).append(b).toString());
        }
        b.remove(b.size() - 1);
        if (bx3 == bx2)
        {
            h();
        }
        a.write(s);
        return this;
    }

    private ca a(bx bx1, String s)
    {
        a(true);
        b.add(bx1);
        a.write(s);
        return this;
    }

    private ca a(Collection collection)
    {
        if (collection == null)
        {
            return g();
        }
        a();
        for (collection = collection.iterator(); collection.hasNext(); a(collection.next())) { }
        b();
        return this;
    }

    private ca a(Object aobj[])
    {
        if (aobj == null)
        {
            return g();
        }
        a();
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            a(aobj[i]);
        }

        b();
        return this;
    }

    private void a(bx bx1)
    {
        b.set(b.size() - 1, bx1);
    }

    private void a(boolean flag)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[bx.values().length];
                try
                {
                    a[bx.f.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[bx.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[bx.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[bx.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[bx.g.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[f().ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Nesting problem: ")).append(b).toString());

        case 1: // '\001'
            if (!e && !flag)
            {
                throw new IllegalStateException("JSON must start with an array or an object.");
            } else
            {
                a(bx.g);
                return;
            }

        case 2: // '\002'
            a(bx.b);
            h();
            return;

        case 3: // '\003'
            a.append(',');
            h();
            return;

        case 4: // '\004'
            a.append(d);
            a(bx.e);
            return;

        case 5: // '\005'
            throw new IllegalStateException("JSON must have only one top-level value.");
        }
    }

    private void c(String s)
    {
        int i;
        int j;
        a.write("\"");
        j = s.length();
        i = 0;
_L11:
        char c1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        c1 = s.charAt(i);
        c1;
        JVM INSTR lookupswitch 9: default 112
    //                   8: 183
    //                   9: 171
    //                   10: 195
    //                   12: 219
    //                   13: 207
    //                   34: 150
    //                   92: 150
    //                   8232: 231
    //                   8233: 231;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L8 _L8
_L8:
        break MISSING_BLOCK_LABEL_231;
_L1:
        if (c1 > '\037') goto _L10; else goto _L9
_L9:
        a.write(String.format("\\u%04x", new Object[] {
            Integer.valueOf(c1)
        }));
_L12:
        i++;
          goto _L11
_L7:
        a.write(92);
_L10:
        a.write(c1);
          goto _L12
_L3:
        a.write("\\t");
          goto _L12
_L2:
        a.write("\\b");
          goto _L12
_L4:
        a.write("\\n");
          goto _L12
_L6:
        a.write("\\r");
          goto _L12
_L5:
        a.write("\\f");
          goto _L12
        a.write(String.format("\\u%04x", new Object[] {
            Integer.valueOf(c1)
        }));
          goto _L12
        a.write("\"");
        return;
    }

    private bx f()
    {
        return (bx)b.get(b.size() - 1);
    }

    private ca g()
    {
        a(false);
        a.write("null");
        return this;
    }

    private void h()
    {
        if (c != null)
        {
            a.write("\n");
            int i = 1;
            while (i < b.size()) 
            {
                a.write(c);
                i++;
            }
        }
    }

    public final ca a()
    {
        return a(bx.a, "[");
    }

    public final ca a(double d1)
    {
        if (!e && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(d1).toString());
        } else
        {
            a(false);
            a.append(Double.toString(d1));
            return this;
        }
    }

    public final ca a(long l)
    {
        a(false);
        a.write(Long.toString(l));
        return this;
    }

    public final ca a(bs bs1)
    {
        a(false);
        bs1.a(a);
        return this;
    }

    public final ca a(Object obj)
    {
        ca ca1;
        if (obj == null)
        {
            ca1 = g();
        } else
        if (obj instanceof by)
        {
            int i = b.size();
            ca1 = this;
            if (b.size() != i)
            {
                throw new IllegalStateException((new StringBuilder()).append(obj.getClass().getName()).append(".writeToJson(JsonWriter) wrote incomplete value").toString());
            }
        } else
        {
            if (obj instanceof Boolean)
            {
                boolean flag = ((Boolean)obj).booleanValue();
                a(false);
                Writer writer = a;
                if (flag)
                {
                    obj = "true";
                } else
                {
                    obj = "false";
                }
                writer.write(((String) (obj)));
                return this;
            }
            if (obj instanceof Number)
            {
                if (obj instanceof Long)
                {
                    return a(((Number)obj).longValue());
                }
                if (obj instanceof Double)
                {
                    return a(((Number)obj).doubleValue());
                }
                obj = (Number)obj;
                if (obj == null)
                {
                    return g();
                }
                String s = obj.toString();
                if (!e && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
                {
                    throw new IllegalArgumentException((new StringBuilder("Numeric values must be finite, but was ")).append(obj).toString());
                } else
                {
                    a(false);
                    a.append(s);
                    return this;
                }
            }
            if (obj instanceof String)
            {
                return b((String)obj);
            }
            if (obj instanceof bs)
            {
                return a((bs)obj);
            }
            if (obj instanceof Collection)
            {
                return a((Collection)obj);
            }
            if (obj instanceof Map)
            {
                return a((Map)obj);
            }
            if (obj instanceof Date)
            {
                obj = (Date)obj;
                if (obj == null)
                {
                    return g();
                } else
                {
                    return b(ab.a(((Date) (obj))));
                }
            }
            if (obj instanceof Object[])
            {
                return a((Object[])(Object[])obj);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder("Unknown type: ")).append(obj.getClass().getName()).toString());
            }
        }
        return ca1;
    }

    public final ca a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        bx bx1 = f();
        if (bx1 == bx.e)
        {
            a.write(44);
        } else
        if (bx1 != bx.c)
        {
            throw new IllegalStateException((new StringBuilder("Nesting problem: ")).append(b).toString());
        }
        h();
        a(bx.d);
        c(s);
        return this;
    }

    public final ca a(Map map)
    {
        if (map == null)
        {
            return g();
        }
        c();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); a(entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            a(String.valueOf(entry.getKey()));
        }

        d();
        return this;
    }

    public final ca b()
    {
        return a(bx.a, bx.b, "]");
    }

    public final ca b(String s)
    {
        if (s == null)
        {
            return g();
        } else
        {
            a(false);
            c(s);
            return this;
        }
    }

    public final ca c()
    {
        return a(bx.c, "{");
    }

    public final void close()
    {
        a.close();
        if (f() != bx.g)
        {
            throw new IOException("Incomplete document");
        } else
        {
            return;
        }
    }

    public final ca d()
    {
        return a(bx.c, bx.e, "}");
    }

    public final void e()
    {
        a.flush();
    }
}
