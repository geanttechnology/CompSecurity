// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class ah extends w
{

    public ah(af af1)
    {
        super(af1);
    }

    public final void a()
    {
        try
        {
            a.d();
            a.a(a.k());
            a.j();
            a.s();
            a.t();
            return;
        }
        catch (Throwable throwable)
        {
            b.a(this, "Error starting RecordStartingState", throwable);
        }
        a.a(new x(a, 3, null, null, false));
    }

    public final void d()
    {
        a(5);
    }

    public final void g()
    {
        a(3);
    }

    public final void h()
    {
        a.a(new ae(a));
    }

    public final void i()
    {
        a(3);
    }

    public final void j()
    {
        a(3);
    }
}
