// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aff, aex, afd, afc, 
//            afa

public final class agh extends JsonReader
{

    private static final Reader a = new Reader() {

        public void close()
            throws IOException
        {
            throw new AssertionError();
        }

        public int read(char ac[], int i, int j)
            throws IOException
        {
            throw new AssertionError();
        }

    };
    private static final Object b = new Object();
    private final List c = new ArrayList();

    public agh(afa afa)
    {
        super(a);
        c.add(afa);
    }

    private void a(JsonToken jsontoken)
        throws IOException
    {
        if (peek() != jsontoken)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(jsontoken).append(" but was ").append(peek()).toString());
        } else
        {
            return;
        }
    }

    private Object b()
    {
        return c.get(c.size() - 1);
    }

    private Object c()
    {
        return c.remove(c.size() - 1);
    }

    public void a()
        throws IOException
    {
        a(JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)b()).next();
        c.add(entry.getValue());
        c.add(new aff((String)entry.getKey()));
    }

    public void beginArray()
        throws IOException
    {
        a(JsonToken.BEGIN_ARRAY);
        aex aex1 = (aex)b();
        c.add(aex1.iterator());
    }

    public void beginObject()
        throws IOException
    {
        a(JsonToken.BEGIN_OBJECT);
        afd afd1 = (afd)b();
        c.add(afd1.o().iterator());
    }

    public void close()
        throws IOException
    {
        c.clear();
        c.add(b);
    }

    public void endArray()
        throws IOException
    {
        a(JsonToken.END_ARRAY);
        c();
        c();
    }

    public void endObject()
        throws IOException
    {
        a(JsonToken.END_OBJECT);
        c();
        c();
    }

    public boolean hasNext()
        throws IOException
    {
        JsonToken jsontoken = peek();
        return jsontoken != JsonToken.END_OBJECT && jsontoken != JsonToken.END_ARRAY;
    }

    public boolean nextBoolean()
        throws IOException
    {
        a(JsonToken.BOOLEAN);
        return ((aff)c()).f();
    }

    public double nextDouble()
        throws IOException
    {
        JsonToken jsontoken = peek();
        if (jsontoken != JsonToken.NUMBER && jsontoken != JsonToken.STRING)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(jsontoken).toString());
        }
        double d = ((aff)b()).c();
        if (!isLenient() && (Double.isNaN(d) || Double.isInfinite(d)))
        {
            throw new NumberFormatException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(d).toString());
        } else
        {
            c();
            return d;
        }
    }

    public int nextInt()
        throws IOException
    {
        JsonToken jsontoken = peek();
        if (jsontoken != JsonToken.NUMBER && jsontoken != JsonToken.STRING)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(jsontoken).toString());
        } else
        {
            int i = ((aff)b()).e();
            c();
            return i;
        }
    }

    public long nextLong()
        throws IOException
    {
        JsonToken jsontoken = peek();
        if (jsontoken != JsonToken.NUMBER && jsontoken != JsonToken.STRING)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(JsonToken.NUMBER).append(" but was ").append(jsontoken).toString());
        } else
        {
            long l = ((aff)b()).d();
            c();
            return l;
        }
    }

    public String nextName()
        throws IOException
    {
        a(JsonToken.NAME);
        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator)b()).next();
        c.add(entry.getValue());
        return (String)entry.getKey();
    }

    public void nextNull()
        throws IOException
    {
        a(JsonToken.NULL);
        c();
    }

    public String nextString()
        throws IOException
    {
        JsonToken jsontoken = peek();
        if (jsontoken != JsonToken.STRING && jsontoken != JsonToken.NUMBER)
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected ").append(JsonToken.STRING).append(" but was ").append(jsontoken).toString());
        } else
        {
            return ((aff)c()).b();
        }
    }

    public JsonToken peek()
        throws IOException
    {
        if (c.isEmpty())
        {
            return JsonToken.END_DOCUMENT;
        }
        Object obj = b();
        if (obj instanceof Iterator)
        {
            boolean flag = c.get(c.size() - 2) instanceof afd;
            obj = (Iterator)obj;
            if (((Iterator) (obj)).hasNext())
            {
                if (flag)
                {
                    return JsonToken.NAME;
                } else
                {
                    c.add(((Iterator) (obj)).next());
                    return peek();
                }
            }
            if (flag)
            {
                return JsonToken.END_OBJECT;
            } else
            {
                return JsonToken.END_ARRAY;
            }
        }
        if (obj instanceof afd)
        {
            return JsonToken.BEGIN_OBJECT;
        }
        if (obj instanceof aex)
        {
            return JsonToken.BEGIN_ARRAY;
        }
        if (obj instanceof aff)
        {
            obj = (aff)obj;
            if (((aff) (obj)).q())
            {
                return JsonToken.STRING;
            }
            if (((aff) (obj)).o())
            {
                return JsonToken.BOOLEAN;
            }
            if (((aff) (obj)).p())
            {
                return JsonToken.NUMBER;
            } else
            {
                throw new AssertionError();
            }
        }
        if (obj instanceof afc)
        {
            return JsonToken.NULL;
        }
        if (obj == b)
        {
            throw new IllegalStateException("JsonReader is closed");
        } else
        {
            throw new AssertionError();
        }
    }

    public void skipValue()
        throws IOException
    {
        if (peek() == JsonToken.NAME)
        {
            nextName();
            return;
        } else
        {
            c();
            return;
        }
    }

    public String toString()
    {
        return getClass().getSimpleName();
    }

}
