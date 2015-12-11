// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            aff, afc, afa, afd, 
//            aex

public final class agi extends JsonWriter
{

    private static final Writer a = new Writer() {

        public void close()
            throws IOException
        {
            throw new AssertionError();
        }

        public void flush()
            throws IOException
        {
            throw new AssertionError();
        }

        public void write(char ac[], int i, int j)
        {
            throw new AssertionError();
        }

    };
    private static final aff b = new aff("closed");
    private final List c = new ArrayList();
    private String d;
    private afa e;

    public agi()
    {
        super(a);
        e = afc.a;
    }

    private void a(afa afa1)
    {
        if (d != null)
        {
            if (!afa1.j() || getSerializeNulls())
            {
                ((afd)b()).a(d, afa1);
            }
            d = null;
            return;
        }
        if (c.isEmpty())
        {
            e = afa1;
            return;
        }
        afa afa2 = b();
        if (afa2 instanceof aex)
        {
            ((aex)afa2).a(afa1);
            return;
        } else
        {
            throw new IllegalStateException();
        }
    }

    private afa b()
    {
        return (afa)c.get(c.size() - 1);
    }

    public afa a()
    {
        if (!c.isEmpty())
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected one JSON element but was ").append(c).toString());
        } else
        {
            return e;
        }
    }

    public JsonWriter beginArray()
        throws IOException
    {
        aex aex1 = new aex();
        a(aex1);
        c.add(aex1);
        return this;
    }

    public JsonWriter beginObject()
        throws IOException
    {
        afd afd1 = new afd();
        a(afd1);
        c.add(afd1);
        return this;
    }

    public void close()
        throws IOException
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

    public JsonWriter endArray()
        throws IOException
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (b() instanceof aex)
        {
            c.remove(c.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public JsonWriter endObject()
        throws IOException
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (b() instanceof afd)
        {
            c.remove(c.size() - 1);
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public void flush()
        throws IOException
    {
    }

    public JsonWriter name(String s)
        throws IOException
    {
        if (c.isEmpty() || d != null)
        {
            throw new IllegalStateException();
        }
        if (b() instanceof afd)
        {
            d = s;
            return this;
        } else
        {
            throw new IllegalStateException();
        }
    }

    public JsonWriter nullValue()
        throws IOException
    {
        a(afc.a);
        return this;
    }

    public JsonWriter value(double d1)
        throws IOException
    {
        if (!isLenient() && (Double.isNaN(d1) || Double.isInfinite(d1)))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(d1).toString());
        } else
        {
            a(new aff(Double.valueOf(d1)));
            return this;
        }
    }

    public JsonWriter value(long l)
        throws IOException
    {
        a(new aff(Long.valueOf(l)));
        return this;
    }

    public JsonWriter value(Number number)
        throws IOException
    {
        if (number == null)
        {
            return nullValue();
        }
        if (!isLenient())
        {
            double d1 = number.doubleValue();
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(number).toString());
            }
        }
        a(new aff(number));
        return this;
    }

    public JsonWriter value(String s)
        throws IOException
    {
        if (s == null)
        {
            return nullValue();
        } else
        {
            a(new aff(s));
            return this;
        }
    }

    public JsonWriter value(boolean flag)
        throws IOException
    {
        a(new aff(Boolean.valueOf(flag)));
        return this;
    }

}
