// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.IOException;
import java.io.StringWriter;

// Referenced classes of package com.flurry.sdk:
//            id, ij, il, ii, 
//            jz, jh

public abstract class ig
{

    public ig()
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
        return this instanceof id;
    }

    public boolean h()
    {
        return this instanceof ij;
    }

    public boolean i()
    {
        return this instanceof il;
    }

    public boolean j()
    {
        return this instanceof ii;
    }

    public ij k()
    {
        if (h())
        {
            return (ij)this;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Not a JSON Object: ").append(this).toString());
        }
    }

    public id l()
    {
        if (g())
        {
            return (id)this;
        } else
        {
            throw new IllegalStateException("This is not a JSON Array.");
        }
    }

    public il m()
    {
        if (i())
        {
            return (il)this;
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
            jz jz1 = new jz(((java.io.Writer) (obj)));
            jz1.b(true);
            jh.a(this, jz1);
            obj = ((StringWriter) (obj)).toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return ((String) (obj));
    }
}
