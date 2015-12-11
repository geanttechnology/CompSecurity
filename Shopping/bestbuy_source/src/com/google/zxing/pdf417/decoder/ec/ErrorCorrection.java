// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.ChecksumException;

// Referenced classes of package com.google.zxing.pdf417.decoder.ec:
//            ModulusGF, ModulusPoly

public final class ErrorCorrection
{

    private final ModulusGF field;

    public ErrorCorrection()
    {
        field = ModulusGF.PDF417_GF;
    }

    private int[] findErrorLocations(ModulusPoly moduluspoly)
    {
        int l = moduluspoly.getDegree();
        int ai[] = new int[l];
        int j = 0;
        int k;
        for (int i = 1; i < field.getSize() && j < l; j = k)
        {
            k = j;
            if (moduluspoly.evaluateAt(i) == 0)
            {
                ai[j] = field.inverse(i);
                k = j + 1;
            }
            i++;
        }

        if (j != l)
        {
            throw ChecksumException.getChecksumInstance();
        } else
        {
            return ai;
        }
    }

    private int[] findErrorMagnitudes(ModulusPoly moduluspoly, ModulusPoly moduluspoly1, int ai[])
    {
        int k = moduluspoly1.getDegree();
        int ai1[] = new int[k];
        for (int i = 1; i <= k; i++)
        {
            ai1[k - i] = field.multiply(i, moduluspoly1.getCoefficient(i));
        }

        moduluspoly1 = new ModulusPoly(field, ai1);
        k = ai.length;
        ai1 = new int[k];
        for (int j = 0; j < k; j++)
        {
            int i1 = field.inverse(ai[j]);
            int l = field.subtract(0, moduluspoly.evaluateAt(i1));
            i1 = field.inverse(moduluspoly1.evaluateAt(i1));
            ai1[j] = field.multiply(l, i1);
        }

        return ai1;
    }

    private ModulusPoly[] runEuclideanAlgorithm(ModulusPoly moduluspoly, ModulusPoly moduluspoly1, int i)
    {
        ModulusPoly moduluspoly2;
        ModulusPoly moduluspoly4;
        if (moduluspoly.getDegree() >= moduluspoly1.getDegree())
        {
            ModulusPoly moduluspoly3 = moduluspoly;
            moduluspoly = moduluspoly1;
            moduluspoly1 = moduluspoly3;
        }
        moduluspoly4 = field.getZero();
        moduluspoly2 = field.getOne();
        while (moduluspoly.getDegree() >= i / 2) 
        {
            if (moduluspoly.isZero())
            {
                throw ChecksumException.getChecksumInstance();
            }
            ModulusPoly moduluspoly5 = field.getZero();
            int j = moduluspoly.getCoefficient(moduluspoly.getDegree());
            j = field.inverse(j);
            int k;
            int l;
            for (; moduluspoly1.getDegree() >= moduluspoly.getDegree() && !moduluspoly1.isZero(); moduluspoly1 = moduluspoly1.subtract(moduluspoly.multiplyByMonomial(k, l)))
            {
                k = moduluspoly1.getDegree() - moduluspoly.getDegree();
                l = field.multiply(moduluspoly1.getCoefficient(moduluspoly1.getDegree()), j);
                moduluspoly5 = moduluspoly5.add(field.buildMonomial(k, l));
            }

            moduluspoly4 = moduluspoly5.multiply(moduluspoly2).subtract(moduluspoly4).negative();
            moduluspoly5 = moduluspoly;
            moduluspoly = moduluspoly1;
            moduluspoly1 = moduluspoly4;
            moduluspoly4 = moduluspoly2;
            moduluspoly2 = moduluspoly1;
            moduluspoly1 = moduluspoly5;
        }
        i = moduluspoly2.getCoefficient(0);
        if (i == 0)
        {
            throw ChecksumException.getChecksumInstance();
        } else
        {
            i = field.inverse(i);
            return (new ModulusPoly[] {
                moduluspoly2.multiply(i), moduluspoly.multiply(i)
            });
        }
    }

    public int decode(int ai[], int i, int ai1[])
    {
        ModulusPoly moduluspoly = new ModulusPoly(field, ai);
        int ai2[] = new int[i];
        int j = i;
        boolean flag = false;
        for (; j > 0; j--)
        {
            int j1 = moduluspoly.evaluateAt(field.exp(j));
            ai2[i - j] = j1;
            if (j1 != 0)
            {
                flag = true;
            }
        }

        if (!flag)
        {
            return 0;
        }
        moduluspoly = field.getOne();
        int i1 = ai1.length;
        for (int k = 0; k < i1; k++)
        {
            int k1 = ai1[k];
            k1 = field.exp(ai.length - 1 - k1);
            moduluspoly = moduluspoly.multiply(new ModulusPoly(field, new int[] {
                field.subtract(0, k1), 1
            }));
        }

        ai1 = new ModulusPoly(field, ai2);
        Object aobj[] = runEuclideanAlgorithm(field.buildMonomial(i, 1), ai1, i);
        ai1 = aobj[0];
        ModulusPoly moduluspoly1 = aobj[1];
        aobj = findErrorLocations(ai1);
        ai1 = findErrorMagnitudes(moduluspoly1, ai1, ((int []) (aobj)));
        for (i = 0; i < aobj.length; i++)
        {
            int l = ai.length - 1 - field.log(aobj[i]);
            if (l < 0)
            {
                throw ChecksumException.getChecksumInstance();
            }
            ai[l] = field.subtract(ai[l], ai1[i]);
        }

        return aobj.length;
    }
}
