// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            bs, ca, cx

public final class bo
    implements bs
{

    private final StringWriter a = new StringWriter();
    private final ca b;

    public bo()
    {
        b = new ca(a);
    }

    public static String a(Object obj)
    {
        return (new bo()).b(obj).toString();
    }

    private bo b(Object obj)
    {
        try
        {
            b.a(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw cx.a(((Throwable) (obj)));
        }
        return this;
    }

    public final bo a()
    {
        try
        {
            b.a();
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return this;
    }

    public final bo a(double d1)
    {
        try
        {
            b.a(d1);
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return this;
    }

    public final bo a(long l)
    {
        try
        {
            b.a(l);
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return this;
    }

    public final bo a(bs bs1)
    {
        try
        {
            b.a(bs1);
        }
        // Misplaced declaration of an exception variable
        catch (bs bs1)
        {
            throw cx.a(bs1);
        }
        return this;
    }

    public final bo a(String s)
    {
        try
        {
            b.a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw cx.a(s);
        }
        return this;
    }

    public final bo a(Map map)
    {
        try
        {
            b.a(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            throw cx.a(map);
        }
        return this;
    }

    public final void a(Writer writer)
    {
        try
        {
            b.e();
            writer.write(a.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw cx.a(writer);
        }
    }

    public final bo b()
    {
        try
        {
            b.b();
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return this;
    }

    public final bo b(String s)
    {
        try
        {
            b.b(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw cx.a(s);
        }
        return this;
    }

    public final bo c()
    {
        try
        {
            b.c();
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return this;
    }

    public final bo d()
    {
        try
        {
            b.d();
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return this;
    }

    public final String toString()
    {
        String s;
        try
        {
            b.e();
            s = a.toString();
        }
        catch (IOException ioexception)
        {
            throw cx.a(ioexception);
        }
        return s;
    }
}
