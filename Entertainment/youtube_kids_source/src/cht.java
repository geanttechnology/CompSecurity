// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.PrintStream;

public final class cht
    implements chq
{

    public cht()
    {
    }

    public final void a(String s)
    {
        System.out.println(String.format("%s: %s", new Object[] {
            "YouTube MDX", s
        }));
    }

    public final void a(String s, Exception exception)
    {
        b(s);
        exception.printStackTrace();
    }

    public final transient void a(String s, Object aobj[])
    {
    }

    public final void b(String s)
    {
        System.err.println(String.format("%s: %s", new Object[] {
            "YouTube MDX", s
        }));
    }

    public final transient void b(String s, Object aobj[])
    {
        a(String.format(s, aobj));
    }

    public final transient void c(String s, Object aobj[])
    {
        b(String.format(s, aobj));
    }
}
