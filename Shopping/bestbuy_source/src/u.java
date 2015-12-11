// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class u
{

    public final String a;
    public final long b;
    public final long c;

    u(String s, Long long1, Long long2)
    {
        a = s;
        b = long1.longValue();
        c = long2.longValue();
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("BT ID: ").append(a);
        if (b >= 0L)
        {
            stringbuilder.append(" Average Response Time: ").append(b);
        }
        if (c >= 0L)
        {
            stringbuilder.append(" Actual Response Time: ").append(c);
        }
        return stringbuilder.toString();
    }
}
