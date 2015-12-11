// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class apk
    implements Runnable
{

    private String a;
    private int b;
    private long c;
    private apd d;

    apk(apd apd1, String s, int i, long l)
    {
        d = apd1;
        a = s;
        b = i;
        c = l;
        super();
    }

    public final void run()
    {
        apm apm1 = d.b;
        int i = d.a;
        String s = a;
        int j = b;
        apd apd1 = d;
        long l = c;
        apm1.a(i, s, j);
    }
}
