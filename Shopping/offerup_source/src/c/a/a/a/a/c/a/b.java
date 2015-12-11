// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c.a;


// Referenced classes of package c.a.a.a.a.c.a:
//            a

public final class b
    implements a
{

    private final long a = 1000L;
    private final int b = 8;

    public b(long l, int i)
    {
    }

    public final long getDelayMillis(int i)
    {
        return (long)((double)a * Math.pow(b, i));
    }
}
