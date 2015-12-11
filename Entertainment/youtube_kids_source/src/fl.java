// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class fl
{

    int a;
    int b;
    float c;
    float d;
    long e;
    long f;
    int g;
    int h;
    long i;
    float j;
    int k;

    public fl()
    {
        e = 0x8000000000000000L;
        i = -1L;
        f = 0L;
        g = 0;
        h = 0;
    }

    float a(long l)
    {
        if (l < e)
        {
            return 0.0F;
        }
        if (i < 0L || l < i)
        {
            return fk.a((float)(l - e) / (float)a, 0.0F, 1.0F) * 0.5F;
        } else
        {
            long l1 = i;
            float f1 = j;
            float f2 = j;
            return fk.a((float)(l - l1) / (float)k, 0.0F, 1.0F) * f2 + (1.0F - f1);
        }
    }
}
