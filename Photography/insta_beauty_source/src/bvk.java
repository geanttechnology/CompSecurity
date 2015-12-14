// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bvk
    implements bvi
{

    private final long a;
    private final int b;

    public bvk(long l, int i)
    {
        a = l;
        b = i;
    }

    public long getDelayMillis(int i)
    {
        return (long)((double)a * Math.pow(b, i));
    }
}
