// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            ar, v, at, ah

public final class an extends ar
{

    public an()
    {
    }

    public final ah a(ah ah1, int i, int j, float f, float f1, float f2, float f3, 
            float f4, float f5, float f6, float f7, float f8, float f9, float f10, 
            float f11, float f12, float f13, float f14, float f15)
        throws v
    {
        return a(ah1, i, j, at.a(f, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15));
    }

    public final ah a(ah ah1, int i, int j, at at1)
        throws v
    {
        if (i <= 0 || j <= 0)
        {
            throw v.a();
        }
        ah ah2 = new ah(i, j);
        float af[] = new float[i << 1];
        int k = 0;
        do
        {
            if (k >= j)
            {
                break;
            }
            int i1 = af.length;
            float f = k;
            for (i = 0; i < i1; i += 2)
            {
                af[i] = (float)(i >> 1) + 0.5F;
                af[i + 1] = 0.5F + f;
            }

            at1.a(af);
            int j1 = ah1.a;
            int k1 = ah1.b;
            i = 1;
            int l = 0;
            while (l < af.length && i != 0) 
            {
                int j2 = (int)af[l];
                int l1 = (int)af[l + 1];
                if (j2 < -1 || j2 > j1 || l1 < -1 || l1 > k1)
                {
                    throw v.a();
                }
                i = 0;
                if (j2 == -1)
                {
                    af[l] = 0.0F;
                    i = 1;
                } else
                if (j2 == j1)
                {
                    af[l] = j1 - 1;
                    i = 1;
                }
                if (l1 == -1)
                {
                    af[l + 1] = 0.0F;
                    i = 1;
                } else
                if (l1 == k1)
                {
                    af[l + 1] = k1 - 1;
                    i = 1;
                }
                l += 2;
            }
            l = af.length;
            i = 1;
            l -= 2;
            while (l >= 0 && i != 0) 
            {
                int k2 = (int)af[l];
                int i2 = (int)af[l + 1];
                if (k2 < -1 || k2 > j1 || i2 < -1 || i2 > k1)
                {
                    throw v.a();
                }
                i = 0;
                if (k2 == -1)
                {
                    af[l] = 0.0F;
                    i = 1;
                } else
                if (k2 == j1)
                {
                    af[l] = j1 - 1;
                    i = 1;
                }
                if (i2 == -1)
                {
                    af[l + 1] = 0.0F;
                    i = 1;
                } else
                if (i2 == k1)
                {
                    af[l + 1] = k1 - 1;
                    i = 1;
                }
                l -= 2;
            }
            i = 0;
            while (i < i1) 
            {
                try
                {
                    if (ah1.a((int)af[i], (int)af[i + 1]))
                    {
                        ah2.b(i >> 1, k);
                    }
                }
                // Misplaced declaration of an exception variable
                catch (ah ah1)
                {
                    throw v.a();
                }
                i += 2;
            }
            k++;
        } while (true);
        return ah2;
    }
}
