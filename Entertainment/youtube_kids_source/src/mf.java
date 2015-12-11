// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class mf
    implements Runnable
{

    private String a;
    private long b;
    private me c;

    mf(me me1, String s, long l)
    {
        c = me1;
        a = s;
        b = l;
        super();
    }

    public final void run()
    {
        me.a(c).a(a, b);
        me.a(c).a(toString());
    }
}
