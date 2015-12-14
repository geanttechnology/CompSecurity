// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class acb
    implements abz
{

    private final long a;
    private final int b;

    public acb(long l, int i)
    {
        a = l;
        b = i;
    }

    public long getDelayMillis(int i)
    {
        return (long)((double)a * Math.pow(b, i));
    }
}
