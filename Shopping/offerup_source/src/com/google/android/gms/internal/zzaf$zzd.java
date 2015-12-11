// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzsh, zzse

public final class zzG extends zzry
{

    public zzib zzhZ[];
    public zzib zzia[];
    public zzib zzib[];

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzG))
            {
                return false;
            }
            obj = (zzG)obj;
            if (!zzsc.equals(zzhZ, ((zzhZ) (obj)).zzhZ))
            {
                return false;
            }
            if (!zzsc.equals(zzia, ((zzia) (obj)).zzia))
            {
                return false;
            }
            if (!zzsc.equals(zzib, ((zzib) (obj)).zzib))
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
        int k = zzsc.hashCode(zzhZ);
        int l = zzsc.hashCode(zzia);
        int i1 = zzsc.hashCode(zzib);
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int i = super.zzB();
        int j = i;
        if (zzhZ != null)
        {
            j = i;
            if (zzhZ.length > 0)
            {
                for (j = 0; j < zzhZ.length;)
                {
                    Code code = zzhZ[j];
                    int i1 = i;
                    if (code != null)
                    {
                        i1 = i + zzrx.zzc(1, code);
                    }
                    j++;
                    i = i1;
                }

                j = i;
            }
        }
        i = j;
        if (zzia != null)
        {
            i = j;
            if (zzia.length > 0)
            {
                i = j;
                for (int k = 0; k < zzia.length;)
                {
                    Code code1 = zzia[k];
                    int j1 = i;
                    if (code1 != null)
                    {
                        j1 = i + zzrx.zzc(2, code1);
                    }
                    k++;
                    i = j1;
                }

            }
        }
        int k1 = i;
        if (zzib != null)
        {
            k1 = i;
            if (zzib.length > 0)
            {
                int l = ((flag) ? 1 : 0);
                do
                {
                    k1 = i;
                    if (l >= zzib.length)
                    {
                        break;
                    }
                    Code code2 = zzib[l];
                    k1 = i;
                    if (code2 != null)
                    {
                        k1 = i + zzrx.zzc(3, code2);
                    }
                    l++;
                    i = k1;
                } while (true);
            }
        }
        return k1;
    }

    public final zzib zzG()
    {
        zzhZ = zzQ();
        zzia = zzQ();
        zzib = zzE();
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        boolean flag = false;
        if (zzhZ != null && zzhZ.length > 0)
        {
            for (int i = 0; i < zzhZ.length; i++)
            {
                zzbiv zzbiv = zzhZ[i];
                if (zzbiv != null)
                {
                    zzrx1.zza(1, zzbiv);
                }
            }

        }
        if (zzia != null && zzia.length > 0)
        {
            for (int j = 0; j < zzia.length; j++)
            {
                zzbiv zzbiv1 = zzia[j];
                if (zzbiv1 != null)
                {
                    zzrx1.zza(2, zzbiv1);
                }
            }

        }
        if (zzib != null && zzib.length > 0)
        {
            for (int k = ((flag) ? 1 : 0); k < zzib.length; k++)
            {
                zzbiv zzbiv2 = zzib[k];
                if (zzbiv2 != null)
                {
                    zzrx1.zza(3, zzbiv2);
                }
            }

        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zze(zzrw1);
    }

    public final zze zze(zzrw zzrw1)
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
                int i1 = zzsh.zzc(zzrw1, 10);
                zze azze[];
                int j;
                if (zzhZ == null)
                {
                    j = 0;
                } else
                {
                    j = zzhZ.length;
                }
                azze = new zzhZ[i1 + j];
                i1 = j;
                if (j != 0)
                {
                    System.arraycopy(zzhZ, 0, azze, 0, j);
                    i1 = j;
                }
                for (; i1 < azze.length - 1; i1++)
                {
                    azze[i1] = new <init>();
                    zzrw1.zza(azze[i1]);
                    zzrw1.zzFo();
                }

                azze[i1] = new <init>();
                zzrw1.zza(azze[i1]);
                zzhZ = azze;
                break;

            case 18: // '\022'
                int j1 = zzsh.zzc(zzrw1, 18);
                zze azze1[];
                int k;
                if (zzia == null)
                {
                    k = 0;
                } else
                {
                    k = zzia.length;
                }
                azze1 = new zzia[j1 + k];
                j1 = k;
                if (k != 0)
                {
                    System.arraycopy(zzia, 0, azze1, 0, k);
                    j1 = k;
                }
                for (; j1 < azze1.length - 1; j1++)
                {
                    azze1[j1] = new <init>();
                    zzrw1.zza(azze1[j1]);
                    zzrw1.zzFo();
                }

                azze1[j1] = new <init>();
                zzrw1.zza(azze1[j1]);
                zzia = azze1;
                break;

            case 26: // '\032'
                int k1 = zzsh.zzc(zzrw1, 26);
                zze azze2[];
                int l;
                if (zzib == null)
                {
                    l = 0;
                } else
                {
                    l = zzib.length;
                }
                azze2 = new zzib[k1 + l];
                k1 = l;
                if (l != 0)
                {
                    System.arraycopy(zzib, 0, azze2, 0, l);
                    k1 = l;
                }
                for (; k1 < azze2.length - 1; k1++)
                {
                    azze2[k1] = new <init>();
                    zzrw1.zza(azze2[k1]);
                    zzrw1.zzFo();
                }

                azze2[k1] = new <init>();
                zzrw1.zza(azze2[k1]);
                zzib = azze2;
                break;
            }
        } while (true);
    }

    public ()
    {
        zzG();
    }
}
