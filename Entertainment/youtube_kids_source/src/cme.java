// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cme extends cmo
{

    private final int b;
    private final int c;
    private float d;

    public cme(bmi bmi, art art, int i, int j, int k, int l)
    {
        super(bmi, art, i, j);
        b = k;
        c = l;
    }

    protected final float a(long l)
    {
        d = d + (float)((long)c * l) / 1000F;
        return ((float)l * d) / 1000F;
    }

    public final long a(arx arx)
    {
        d = b;
        return super.a(arx);
    }

    protected final long b()
    {
        return (long)(((1.0F - super.a) * 1000F) / d);
    }
}
