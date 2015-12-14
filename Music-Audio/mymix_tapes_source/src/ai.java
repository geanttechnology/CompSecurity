// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class ai extends w
{

    public ai(af af1)
    {
        super(af1);
    }

    public final void a()
    {
        try
        {
            a.u();
            m().b(a);
            return;
        }
        catch (l l1)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting RecordingState", l1);
        }
        a(3);
    }

    public final void b()
    {
        a.v();
        m().c(a);
    }

    public final void d()
    {
        a(5);
    }

    public final void g()
    {
        a(3);
    }

    public final void i()
    {
        a.p();
        a.a(new aj(a));
    }

    public final void j()
    {
        a.v();
    }
}
