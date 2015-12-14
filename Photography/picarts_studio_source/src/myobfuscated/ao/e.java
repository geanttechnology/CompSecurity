// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.d;
import com.millennialmedia.google.gson.f;
import com.millennialmedia.google.gson.g;
import com.millennialmedia.google.gson.h;
import com.millennialmedia.google.gson.internal.LinkedHashTreeMap;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class e extends a
{

    private static final Object c = new Object();
    public final List a;

    private Object p()
    {
        return a.remove(a.size() - 1);
    }

    public final void a()
    {
        a(JsonToken.BEGIN_ARRAY);
        d d1 = (d)g();
        a.add(d1.iterator());
    }

    public final void a(JsonToken jsontoken)
    {
        if (f() != jsontoken)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(jsontoken).append(" but was ").append(f()).toString());
        } else
        {
            return;
        }
    }

    public final void b()
    {
        a(JsonToken.END_ARRAY);
        p();
        p();
    }

    public final void c()
    {
        a(JsonToken.BEGIN_OBJECT);
        g g1 = (g)g();
        a.add(g1.a.entrySet().iterator());
    }

    public final void close()
    {
        a.clear();
        a.add(c);
    }

    public final void d()
    {
        a(JsonToken.END_OBJECT);
        p();
        p();
    }

    public final boolean e()
    {
        JsonToken jsontoken = f();
        return jsontoken != JsonToken.END_OBJECT && jsontoken != JsonToken.END_ARRAY;
    }

    public final JsonToken f()
    {
        Object obj;
        do
        {
            if (a.isEmpty())
            {
                return JsonToken.END_DOCUMENT;
            }
            obj = g();
            if (!(obj instanceof Iterator))
            {
                break;
            }
            boolean flag = a.get(a.size() - 2) instanceof g;
            obj = (Iterator)obj;
            if (((Iterator) (obj)).hasNext())
            {
                if (flag)
                {
                    return JsonToken.NAME;
                }
                a.add(((Iterator) (obj)).next());
            } else
            if (flag)
            {
                return JsonToken.END_OBJECT;
            } else
            {
                return JsonToken.END_ARRAY;
            }
        } while (true);
        if (obj instanceof g)
        {
            return JsonToken.BEGIN_OBJECT;
        }
        if (obj instanceof d)
        {
            return JsonToken.BEGIN_ARRAY;
        }
        if (obj instanceof h)
        {
            obj = (h)obj;
            if (((h) (obj)).a instanceof String)
            {
                return JsonToken.STRING;
            }
            if (((h) (obj)).a instanceof Boolean)
            {
                return JsonToken.BOOLEAN;
            }
            if (((h) (obj)).a instanceof Number)
            {
                return JsonToken.NUMBER;
            } else
            {
                throw new AssertionError();
            }
        }
        if (obj instanceof f)
        {
            return JsonToken.NULL;
        }
        if (obj == c)
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
        a(JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)g()).next();
        a.add(entry.getValue());
        return (String)entry.getKey();
    }

    public final String i()
    {
        JsonToken jsontoken = f();
        if (jsontoken != JsonToken.STRING && jsontoken != JsonToken.NUMBER)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(JsonToken.STRING).append(" but was ").append(jsontoken).toString());
        } else
        {
            return ((h)p()).b();
        }
    }

    public final boolean j()
    {
        a(JsonToken.BOOLEAN);
        return ((h)p()).f();
    }

    public final void k()
    {
        a(JsonToken.NULL);
        p();
    }

    public final double l()
    {
        JsonToken jsontoken = f();
        if (jsontoken != JsonToken.NUMBER && jsontoken != JsonToken.STRING)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(JsonToken.NUMBER).append(" but was ").append(jsontoken).toString());
        }
        double d1 = ((h)g()).c();
        if (!super.b && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new NumberFormatException((new StringBuilder("JSON forbids NaN and infinities: ")).append(d1).toString());
        } else
        {
            p();
            return d1;
        }
    }

    public final long m()
    {
        JsonToken jsontoken = f();
        if (jsontoken != JsonToken.NUMBER && jsontoken != JsonToken.STRING)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(JsonToken.NUMBER).append(" but was ").append(jsontoken).toString());
        } else
        {
            long l1 = ((h)g()).d();
            p();
            return l1;
        }
    }

    public final int n()
    {
        JsonToken jsontoken = f();
        if (jsontoken != JsonToken.NUMBER && jsontoken != JsonToken.STRING)
        {
            throw new IllegalStateException((new StringBuilder("Expected ")).append(JsonToken.NUMBER).append(" but was ").append(jsontoken).toString());
        } else
        {
            int i1 = ((h)g()).e();
            p();
            return i1;
        }
    }

    public final void o()
    {
        if (f() == JsonToken.NAME)
        {
            h();
            return;
        } else
        {
            p();
            return;
        }
    }

    public final String toString()
    {
        return getClass().getSimpleName();
    }

    static 
    {
        new Reader() {

            public final void close()
            {
                throw new AssertionError();
            }

            public final int read(char ac[], int i1, int j1)
            {
                throw new AssertionError();
            }

        };
    }
}
