// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ehl
{

    private static int a = 0x40000000;

    static int a(int i)
    {
        return 0x1b873593 * Integer.rotateLeft(0xcc9e2d51 * i, 15);
    }

    static int a(int i, double d)
    {
label0:
        {
            int k = Math.max(i, 2);
            int j = Integer.highestOneBit(k);
            i = j;
            if ((double)k / (double)j > 1.2D)
            {
                i = j << 1;
                if (i <= 0)
                {
                    break label0;
                }
            }
            return i;
        }
        return a;
    }

}
