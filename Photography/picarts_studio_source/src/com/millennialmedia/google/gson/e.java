// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.stream.b;
import java.io.IOException;
import java.io.StringWriter;
import myobfuscated.f.m;

// Referenced classes of package com.millennialmedia.google.gson:
//            h

public abstract class e
{

    public e()
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

    public final h g()
    {
        if (this instanceof h)
        {
            return (h)this;
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
            b b1 = new b(((java.io.Writer) (obj)));
            b1.e = true;
            m.a(this, b1);
            obj = ((StringWriter) (obj)).toString();
        }
        catch (IOException ioexception)
        {
            throw new AssertionError(ioexception);
        }
        return ((String) (obj));
    }
}
