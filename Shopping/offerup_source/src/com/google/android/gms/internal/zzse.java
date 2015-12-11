// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrx, zzsd, zzrw, zzsf

public abstract class zzse
{

    protected volatile int zzbiv;

    public zzse()
    {
        zzbiv = -1;
    }

    public static final zzse zza(zzse zzse1, byte abyte0[])
    {
        return zzb(zzse1, abyte0, 0, abyte0.length);
    }

    public static final void zza(zzse zzse1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = zzrx.zzb(abyte0, i, j);
            zzse1.zza(((zzrx) (abyte0)));
            abyte0.zzFE();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzse zzse1)
        {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", zzse1);
        }
    }

    public static final zzse zzb(zzse zzse1, byte abyte0[], int i, int j)
    {
        try
        {
            abyte0 = zzrw.zza(abyte0, i, j);
            zzse1.zzb(((zzrw) (abyte0)));
            abyte0.zzlz(0);
        }
        // Misplaced declaration of an exception variable
        catch (zzse zzse1)
        {
            throw zzse1;
        }
        // Misplaced declaration of an exception variable
        catch (zzse zzse1)
        {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
        return zzse1;
    }

    public static final byte[] zzf(zzse zzse1)
    {
        byte abyte0[] = new byte[zzse1.zzFR()];
        zza(zzse1, abyte0, 0, abyte0.length);
        return abyte0;
    }

    public Object clone()
    {
        return zzFG();
    }

    public String toString()
    {
        return zzsf.zzg(this);
    }

    protected int zzB()
    {
        return 0;
    }

    public zzse zzFG()
    {
        return (zzse)super.clone();
    }

    public int zzFQ()
    {
        if (zzbiv < 0)
        {
            zzFR();
        }
        return zzbiv;
    }

    public int zzFR()
    {
        int i = zzB();
        zzbiv = i;
        return i;
    }

    public void zza(zzrx zzrx1)
    {
    }

    public abstract zzse zzb(zzrw zzrw1);
}
