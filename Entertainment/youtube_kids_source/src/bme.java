// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bme
{

    private long a;
    private final bmi b;

    public bme(bmi bmi1)
    {
        b = bmi1;
        a = -1L;
    }

    public final void a()
    {
        a = b.b();
    }

    public final long b()
    {
        if (a == -1L)
        {
            return -1L;
        } else
        {
            return b.b() - a;
        }
    }
}
