// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aok
    implements Runnable
{

    private int a;
    private long b;
    private aoh c;

    aok(aoh aoh1, int i, long l)
    {
        c = aoh1;
        a = i;
        b = l;
        super();
    }

    public final void run()
    {
        aol aol1 = c.a;
        int i = a;
        long l = b;
        aol1.a(i);
    }
}
