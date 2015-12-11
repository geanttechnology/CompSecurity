// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzrw

public final class zzsh
{

    public static final double zzbiA[] = new double[0];
    public static final boolean zzbiB[] = new boolean[0];
    public static final String zzbiC[] = new String[0];
    public static final byte zzbiD[][] = new byte[0][];
    public static final byte zzbiE[] = new byte[0];
    public static final int zzbix[] = new int[0];
    public static final long zzbiy[] = new long[0];
    public static final float zzbiz[] = new float[0];

    static int zzD(int i, int j)
    {
        return i << 3 | j;
    }

    public static boolean zzb(zzrw zzrw1, int i)
    {
        return zzrw1.zzlA(i);
    }

    public static final int zzc(zzrw zzrw1, int i)
    {
        int j = 1;
        int k = zzrw1.getPosition();
        zzrw1.zzlA(i);
        while (zzrw1.zzFo() == i) 
        {
            zzrw1.zzlA(i);
            j++;
        }
        zzrw1.zzlE(k);
        return j;
    }

    static int zzlU(int i)
    {
        return i & 7;
    }

    public static int zzlV(int i)
    {
        return i >>> 3;
    }

}
