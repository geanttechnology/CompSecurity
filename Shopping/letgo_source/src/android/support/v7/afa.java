// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;

// Referenced classes of package android.support.v7:
//            aex, afd, aff, afc, 
//            agb

public abstract class afa
{

    public afa()
    {
    }

    public Number a()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String b()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long d()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int e()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean g()
    {
        return this instanceof aex;
    }

    public boolean h()
    {
        return this instanceof afd;
    }

    public boolean i()
    {
        return this instanceof aff;
    }

    public boolean j()
    {
        return this instanceof afc;
    }

    public afd k()
    {
        if (h())
        {
            return (afd)this;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Not a JSON Object: ").append(this).toString());
        }
    }

    public aex l()
    {
        if (g())
        {
            return (aex)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Array.");
        }
    }

    public aff m()
    {
        if (i())
        {
            return (aff)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Primitive.");
        }
    }

    Boolean n()
    {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString()
    {
        Object obj;
        try
        {
            obj = new StringWriter();
            JsonWriter jsonwriter = new JsonWriter(((java.io.Writer) (obj)));
            jsonwriter.setLenient(true);
            agb.a(this, jsonwriter);
            obj = ((StringWriter) (obj)).toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return ((String) (obj));
    }
}
