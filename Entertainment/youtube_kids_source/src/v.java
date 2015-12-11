// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class v
    implements Runnable
{

    private int a;
    private int b;
    private t c;

    v(t t1, int i, int j)
    {
        c = t1;
        a = i;
        b = j;
        super();
    }

    public final void run()
    {
        t t1 = c;
        android.os.Handler handler = c.h.a;
        t1.a(null, a, b);
    }
}
