// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class aqp
{

    public final long a;
    public final app b;
    public final long c;
    public final aqo d;
    private String e;

    private aqp(long l, long l1, String s, long l2, 
            app app1, aqs aqs1)
    {
        c = l1;
        e = s;
        a = l2;
        b = app1;
        d = aqs1.a(this);
        l = aqs1.c;
        l = aqs1.b;
    }

    aqp(long l, long l1, String s, long l2, 
            app app1, aqs aqs1, byte byte0)
    {
        this(l, l1, s, l2, app1, aqs1);
    }

    public abstract aqo a();

    public final String b()
    {
        String s = e;
        String s1 = b.a;
        long l = a;
        return (new StringBuilder(String.valueOf(s).length() + 22 + String.valueOf(s1).length())).append(s).append(".").append(s1).append(".").append(l).toString();
    }
}
