// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzsh, 
//            zzrx, zzrw, zzse

public final class zzFU extends zzry
{

    public byte zzbiL[];
    public byte zzbiM[][];
    public boolean zzbiN;

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzFU))
            {
                return false;
            }
            obj = (zzFU)obj;
            if (!Arrays.equals(zzbiL, ((zzbiL) (obj)).zzbiL))
            {
                return false;
            }
            if (!zzsc.zza(zzbiM, ((zzbiM) (obj)).zzbiM))
            {
                return false;
            }
            if (zzbiN != ((zzbiN) (obj)).zzbiN)
            {
                return false;
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                if (((pty) (obj)).zzbik != null && !((zzbik) (obj)).zzbik.isEmpty())
                {
                    return false;
                }
            } else
            {
                return zzbik.equals(((ls) (obj)).zzbik);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = Arrays.hashCode(zzbiL);
        int l = zzsc.zza(zzbiM);
        char c;
        int i;
        if (zzbiN)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + (c + (((j + 527) * 31 + k) * 31 + l) * 31) * 31;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int j = super.zzB();
        int i = j;
        if (!Arrays.equals(zzbiL, zzsh.zzbiE))
        {
            i = j + zzrx.zzb(1, zzbiL);
        }
        j = i;
        if (zzbiM != null)
        {
            j = i;
            if (zzbiM.length > 0)
            {
                int k = 0;
                int l = 0;
                for (j = ((flag) ? 1 : 0); j < zzbiM.length;)
                {
                    byte abyte0[] = zzbiM[j];
                    int j1 = k;
                    int i1 = l;
                    if (abyte0 != null)
                    {
                        i1 = l + 1;
                        j1 = k + zzrx.zzE(abyte0);
                    }
                    j++;
                    k = j1;
                    l = i1;
                }

                j = i + k + l * 1;
            }
        }
        i = j;
        if (zzbiN)
        {
            i = j + zzrx.zzc(3, zzbiN);
        }
        return i;
    }

    public final zzbiN zzFU()
    {
        zzbiL = zzsh.zzbiE;
        zzbiM = zzsh.zzbiD;
        zzbiN = false;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final zzbiv zzI(zzrw zzrw1)
    {
        do
        {
            int i = zzrw1.zzFo();
            switch (i)
            {
            default:
                if (zza(zzrw1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                zzbiL = zzrw1.readBytes();
                break;

            case 18: // '\022'
                int k = zzsh.zzc(zzrw1, 18);
                byte abyte0[][];
                int j;
                if (zzbiM == null)
                {
                    j = 0;
                } else
                {
                    j = zzbiM.length;
                }
                abyte0 = new byte[k + j][];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzbiM, 0, abyte0, 0, j);
                    k = j;
                }
                for (; k < abyte0.length - 1; k++)
                {
                    abyte0[k] = zzrw1.readBytes();
                    zzrw1.zzFo();
                }

                abyte0[k] = zzrw1.readBytes();
                zzbiM = abyte0;
                break;

            case 24: // '\030'
                zzbiN = zzrw1.zzFs();
                break;
            }
        } while (true);
    }

    public final void zza(zzrx zzrx1)
    {
        if (!Arrays.equals(zzbiL, zzsh.zzbiE))
        {
            zzrx1.zza(1, zzbiL);
        }
        if (zzbiM != null && zzbiM.length > 0)
        {
            for (int i = 0; i < zzbiM.length; i++)
            {
                byte abyte0[] = zzbiM[i];
                if (abyte0 != null)
                {
                    zzrx1.zza(2, abyte0);
                }
            }

        }
        if (zzbiN)
        {
            zzrx1.zzb(3, zzbiN);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzI(zzrw1);
    }

    public ()
    {
        zzFU();
    }
}
