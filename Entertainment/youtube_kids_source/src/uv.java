// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class uv
    implements Runnable
{

    private final Exception a;
    private uq b;

    public uv(uq uq1, Exception exception)
    {
        b = uq1;
        super();
        a = exception;
    }

    public final void run()
    {
        b.i = null;
        b.d.c(new cse(csf.j, true, b.e.a(a), a));
    }
}
