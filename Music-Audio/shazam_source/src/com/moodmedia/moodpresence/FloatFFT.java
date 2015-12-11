// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


class FloatFFT
{

    static final int a = (int)(Math.log(1024D) / Math.log(2D));
    private static boolean j = true;
    private final double b[];
    private final double c[];
    private final double d[];
    private final double e[];
    private final double f[];
    private final double g[];
    private final int h[];
    private final int i[];

    FloatFFT()
    {
        int k;
        boolean flag;
        flag = false;
        super();
        b = new double[1024];
        c = new double[1024];
        d = new double[1024];
        e = new double[1024];
        f = new double[2048];
        g = new double[2048];
        h = new int[2048];
        i = new int[2048];
        k = 0;
_L5:
        if (k < 1024) goto _L2; else goto _L1
_L1:
        k = 0;
_L6:
        if (k < 2048) goto _L4; else goto _L3
_L3:
        int l;
        l = a;
        k = ((flag) ? 1 : 0);
_L7:
        if (k >= 1024)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_186;
_L2:
        d[k] = Math.cos((double)k * 0.0061359231515425647D);
        e[k] = -Math.sin((double)k * 0.0061359231515425647D);
        k++;
          goto _L5
_L4:
        f[k] = Math.cos((double)k * 0.0030679615757712823D);
        g[k] = -Math.sin((double)k * 0.0030679615757712823D);
        k++;
          goto _L6
        h[k] = Integer.reverse(k) >>> 31 - l;
        i[k] = h[k] + 1;
        k++;
          goto _L7
    }

    native void nativeFFT(double ad[]);

    static 
    {
        try
        {
            System.loadLibrary("mp");
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            j = false;
        }
    }
}
