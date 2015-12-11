// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class clh
    implements Runnable
{

    private clg a;

    clh(clg clg1)
    {
        a = clg1;
        super();
    }

    public final void run()
    {
        a.removeView(clg.a(a));
        clg.b(a);
        a.addView(clg.a(a));
    }
}
