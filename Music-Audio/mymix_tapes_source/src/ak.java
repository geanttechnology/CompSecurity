// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class ak extends w
{

    public ak(af af1)
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
            a.f();
            return;
        }
        catch (Throwable throwable)
        {
            b.a(this, "Error starting WaitingWithoutRecordingState", throwable);
        }
        a.a(new x(a, 3, null, null, false));
    }

    public final void a(cv cv)
    {
        bf bf1 = a.i();
        if (bf1.a(cv))
        {
            m().d(a);
            if (!bf1.a())
            {
                a.a(new y(a));
            }
            return;
        } else
        {
            a(3);
            return;
        }
    }

    public final void d()
    {
        a(5);
    }

    public final void g()
    {
        a(3);
    }

    public final volatile void h()
    {
        super.h();
    }

    public final volatile void i()
    {
        super.i();
    }

    public final volatile void j()
    {
        super.j();
    }

    public final volatile void k()
    {
        super.k();
    }

    public final volatile void l()
    {
        super.l();
    }
}
