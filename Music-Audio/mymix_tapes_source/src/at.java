// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class at extends av
{

    private boolean c;
    private boolean d;

    public at(au au1)
    {
        super(au1);
        c = false;
        d = false;
    }

    public final void a()
    {
        try
        {
            a.d();
            a.a(a.i());
            a.a(a.k(), a.j(), a.n());
            a.f();
            a.l();
            return;
        }
        catch (Throwable throwable)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting PlayingState", throwable);
        }
        a(4);
    }

    public final void a(cv cv)
    {
        c = true;
        if (d)
        {
            a.a(new ap(a));
        }
    }

    public final void a(String s)
    {
        a(4, s);
    }

    public final void b()
    {
        a.m();
    }

    public final void b(String s)
    {
        a(2, null, s);
    }

    public final void d()
    {
        a(5);
    }

    public final void e()
    {
        a(4, "createCommandFailed");
    }

    public final void f()
    {
        a(1);
    }

    public final void g()
    {
        a(4, "audioError");
    }

    public final void h()
    {
        j().b(a);
    }

    public final void i()
    {
        d = true;
        if (c)
        {
            a.a(new ap(a));
        }
    }
}
