// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class jm
    implements Runnable
{

    private jl a;

    jm(jl jl1)
    {
        a = jl1;
        super();
    }

    public final void run()
    {
        jl.a(a);
    }
}
