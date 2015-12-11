// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.Set;

public final class daz
{

    private final ehk a;
    private final String b;
    private final boolean c;
    private final dat d;
    private final boolean e;
    private Enum f;

    private daz(String s, Enum enum, boolean flag, dat dat, ehk ehk1, boolean flag1)
    {
        a = ehk1;
        b = (String)f.b(s);
        c = flag;
        d = dat;
        f = (Enum)f.b(enum);
        e = flag1;
    }

    daz(String s, Enum enum, boolean flag, boolean flag1, ehk ehk1, boolean flag2)
    {
        dat dat;
        if (flag1)
        {
            dat = a.H();
        } else
        {
            dat = a.I();
        }
        this(s, enum, flag, dat, ehk1, flag2);
        if (e)
        {
            s = b;
            (new StringBuilder("Init state ")).append(f);
        }
    }

    public static dba a(String s, Enum enum)
    {
        return new dba(s, enum);
    }

    private void a(String s)
    {
        if (c)
        {
            throw new IllegalStateException((new StringBuilder()).append(b).append(":  ").append(s).toString());
        } else
        {
            Log.e(b, s);
            return;
        }
    }

    public final void a(Enum enum)
    {
        dat dat = d;
        if (!a.a(f) || !a.c(f).contains(enum))
        {
            a((new StringBuilder("Illegal transation ")).append(f).append("->").append(enum).toString());
        }
        if (e)
        {
            String s = b;
            (new StringBuilder()).append(f).append("->").append(enum);
        }
        f = enum;
    }

    public final boolean b(Enum enum)
    {
        dat dat = d;
        return f == enum;
    }

    public final boolean c(Enum enum)
    {
        dat dat = d;
        return !b(enum);
    }

    public final void d(Enum enum)
    {
        dat dat = d;
        if (f != enum)
        {
            a((new StringBuilder("Current state is ")).append(f).append(", expected ").append(enum).toString());
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Current state=")).append(f).toString();
    }
}
