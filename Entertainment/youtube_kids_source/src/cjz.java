// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cjz
    implements Runnable
{

    private int a;
    private int b;
    private cjy c;

    cjz(cjy cjy1, int i, int j)
    {
        c = cjy1;
        a = i;
        b = j;
        super();
    }

    public final void run()
    {
        cjx.e(c.a).a(a, b);
    }
}
