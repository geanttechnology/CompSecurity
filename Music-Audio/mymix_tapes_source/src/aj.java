// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class aj extends w
{

    public aj(af af1)
    {
        super(af1);
    }

    public final void a()
    {
        try
        {
            a.f();
            return;
        }
        catch (l l1)
        {
            b.a(this, "Error ending command", l1);
        }
        a(3);
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
}
