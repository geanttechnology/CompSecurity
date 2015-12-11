// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ahd
{

    public static final int a[] = new int[0];
    public static final long b[] = new long[0];
    public static final float c[] = new float[0];
    public static final double d[] = new double[0];
    public static final boolean e[] = new boolean[0];
    public static final String f[] = new String[0];
    public static final byte g[][] = new byte[0][];
    public static final byte h[] = new byte[0];

    static int a(int i)
    {
        return i & 7;
    }

    static int a(int i, int j)
    {
        return i << 3 | j;
    }

    public static final int a(agr agr1, int i)
    {
        int j = 1;
        int k = agr1.q();
        agr1.b(i);
        while (agr1.a() == i) 
        {
            agr1.b(i);
            j++;
        }
        agr1.f(k);
        return j;
    }

    public static int b(int i)
    {
        return i >>> 3;
    }

}
