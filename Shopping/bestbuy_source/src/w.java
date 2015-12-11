// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class w
    implements Comparable
{

    private final Long a;
    private final String b;

    private w(Long long1, String s)
    {
        a = long1;
        b = s;
    }

    w(Long long1, String s, byte byte0)
    {
        this(long1, s);
    }

    static String a(w w1)
    {
        return w1.b;
    }

    public final volatile int compareTo(Object obj)
    {
        obj = (w)obj;
        return a.compareTo(((w) (obj)).a);
    }
}
