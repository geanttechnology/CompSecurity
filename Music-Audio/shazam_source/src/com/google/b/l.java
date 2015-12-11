// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.j;
import com.google.b.d.c;
import java.io.IOException;
import java.io.StringWriter;

// Referenced classes of package com.google.b:
//            o, r

public abstract class l
{

    public l()
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

    public final o g()
    {
        if (this instanceof o)
        {
            return (o)this;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Not a JSON Object: ")).append(this).toString());
        }
    }

    public final r h()
    {
        if (this instanceof r)
        {
            return (r)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Primitive.");
        }
    }

    public String toString()
    {
        Object obj;
        try
        {
            obj = new StringWriter();
            c c1 = new c(((java.io.Writer) (obj)));
            c1.a = true;
            j.a(this, c1);
            obj = ((StringWriter) (obj)).toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return ((String) (obj));
    }
}
