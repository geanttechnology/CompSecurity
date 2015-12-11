// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a.a.a;


public final class a.a.a.a.a
{
    public static final class a
    {

        Throwable a;
        String b;
        String c;
        String d;
        String e;
        String f;
        int g;

        public a(Throwable throwable)
        {
            a = throwable;
        }
    }


    public Throwable a;
    public String b;
    public String c;
    public final int d;
    private String e;
    private String f;
    private final String g;

    private a.a.a.a.a(a a1)
    {
        a = a1.a;
        e = a1.b;
        b = a1.c;
        c = a1.d;
        f = a1.e;
        d = a1.g;
        g = a1.f;
    }

    a.a.a.a.a(a a1, byte byte0)
    {
        this(a1);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(c).append(" - ").append(b).append("(").append(d).append(")").toString();
    }
}
