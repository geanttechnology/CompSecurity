// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

final class t extends i
{

    private final p a;

    public t(p p1)
    {
        super(p1);
        a = p1;
    }

    public final void a()
    {
        try
        {
            a.d();
            a.a(a.j());
            a.i();
            a.f();
            return;
        }
        catch (Throwable throwable)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting PendingState", throwable);
        }
        a(0);
    }

    protected final void a(int j, String s, String s1)
    {
        a.a(new n(a, j, s, s1));
    }

    public final void a(cv cv)
    {
        bf bf1 = a.k();
        if (bf1 != null && bf1.a(cv) && !bf1.a())
        {
            a.a(new o(a));
            return;
        } else
        {
            a(0);
            return;
        }
    }

    public final void a(String s)
    {
        a(0, s);
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
        a(0);
    }

    public final void f()
    {
        a(1);
    }
}
