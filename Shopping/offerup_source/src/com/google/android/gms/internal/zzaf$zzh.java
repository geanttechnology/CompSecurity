// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzrz, zzsc, zzsa, 
//            zzrx, zzsh, zzrw, zzse

public final class zzM extends zzry
{

    public static final zzrz zziE = zzrz.zza(11, com/google/android/gms/internal/zzaf$zzh, 810L);
    private static final  zziF[] = new [0];
    public int zziG[];
    public int zziH[];
    public int zziI[];
    public int zziJ;
    public int zziK[];
    public int zziL;
    public int zziM;

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzM))
            {
                return false;
            }
            obj = (zzM)obj;
            if (!zzsc.equals(zziG, ((zziG) (obj)).zziG))
            {
                return false;
            }
            if (!zzsc.equals(zziH, ((zziH) (obj)).zziH))
            {
                return false;
            }
            if (!zzsc.equals(zziI, ((zziI) (obj)).zziI))
            {
                return false;
            }
            if (zziJ != ((zziJ) (obj)).zziJ)
            {
                return false;
            }
            if (!zzsc.equals(zziK, ((zziK) (obj)).zziK))
            {
                return false;
            }
            if (zziL != ((zziL) (obj)).zziL)
            {
                return false;
            }
            if (zziM != ((zziM) (obj)).zziM)
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
        int k = zzsc.hashCode(zziG);
        int l = zzsc.hashCode(zziH);
        int i1 = zzsc.hashCode(zziI);
        int j1 = zziJ;
        int k1 = zzsc.hashCode(zziK);
        int l1 = zziL;
        int i2 = zziM;
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + ((((((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int l = super.zzB();
        int j;
        int k;
        if (zziG != null && zziG.length > 0)
        {
            int i = 0;
            k = 0;
            for (; i < zziG.length; i++)
            {
                k += zzrx.zzlJ(zziG[i]);
            }

            k = l + k + zziG.length * 1;
        } else
        {
            k = l;
        }
        j = k;
        if (zziH != null)
        {
            j = k;
            if (zziH.length > 0)
            {
                j = 0;
                l = 0;
                for (; j < zziH.length; j++)
                {
                    l += zzrx.zzlJ(zziH[j]);
                }

                j = k + l + zziH.length * 1;
            }
        }
        k = j;
        if (zziI != null)
        {
            k = j;
            if (zziI.length > 0)
            {
                k = 0;
                l = 0;
                for (; k < zziI.length; k++)
                {
                    l += zzrx.zzlJ(zziI[k]);
                }

                k = j + l + zziI.length * 1;
            }
        }
        j = k;
        if (zziJ != 0)
        {
            j = k + zzrx.zzA(4, zziJ);
        }
        k = j;
        if (zziK != null)
        {
            k = j;
            if (zziK.length > 0)
            {
                l = 0;
                for (k = ((flag) ? 1 : 0); k < zziK.length; k++)
                {
                    l += zzrx.zzlJ(zziK[k]);
                }

                k = j + l + zziK.length * 1;
            }
        }
        j = k;
        if (zziL != 0)
        {
            j = k + zzrx.zzA(6, zziL);
        }
        k = j;
        if (zziM != 0)
        {
            k = j + zzrx.zzA(7, zziM);
        }
        return k;
    }

    public final zziM zzM()
    {
        zziG = zzsh.zzbix;
        zziH = zzsh.zzbix;
        zziI = zzsh.zzbix;
        zziJ = 0;
        zziK = zzsh.zzbix;
        zziL = 0;
        zziM = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        boolean flag = false;
        if (zziG != null && zziG.length > 0)
        {
            for (int i = 0; i < zziG.length; i++)
            {
                zzrx1.zzy(1, zziG[i]);
            }

        }
        if (zziH != null && zziH.length > 0)
        {
            for (int j = 0; j < zziH.length; j++)
            {
                zzrx1.zzy(2, zziH[j]);
            }

        }
        if (zziI != null && zziI.length > 0)
        {
            for (int k = 0; k < zziI.length; k++)
            {
                zzrx1.zzy(3, zziI[k]);
            }

        }
        if (zziJ != 0)
        {
            zzrx1.zzy(4, zziJ);
        }
        if (zziK != null && zziK.length > 0)
        {
            for (int l = ((flag) ? 1 : 0); l < zziK.length; l++)
            {
                zzrx1.zzy(5, zziK[l]);
            }

        }
        if (zziL != 0)
        {
            zzrx1.zzy(6, zziL);
        }
        if (zziM != 0)
        {
            zzrx1.zzy(7, zziM);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzi(zzrw1);
    }

    public final zzi zzi(zzrw zzrw1)
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

            case 8: // '\b'
                int j2 = zzsh.zzc(zzrw1, 8);
                int ai[];
                int j;
                if (zziG == null)
                {
                    j = 0;
                } else
                {
                    j = zziG.length;
                }
                ai = new int[j2 + j];
                j2 = j;
                if (j != 0)
                {
                    System.arraycopy(zziG, 0, ai, 0, j);
                    j2 = j;
                }
                for (; j2 < ai.length - 1; j2++)
                {
                    ai[j2] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai[j2] = zzrw1.zzFr();
                zziG = ai;
                break;

            case 10: // '\n'
                int j4 = zzrw1.zzlC(zzrw1.zzFv());
                int k = zzrw1.getPosition();
                int k2;
                for (k2 = 0; zzrw1.zzFA() > 0; k2++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(k);
                int ai1[];
                if (zziG == null)
                {
                    k = 0;
                } else
                {
                    k = zziG.length;
                }
                ai1 = new int[k2 + k];
                k2 = k;
                if (k != 0)
                {
                    System.arraycopy(zziG, 0, ai1, 0, k);
                    k2 = k;
                }
                for (; k2 < ai1.length; k2++)
                {
                    ai1[k2] = zzrw1.zzFr();
                }

                zziG = ai1;
                zzrw1.zzlD(j4);
                break;

            case 16: // '\020'
                int l2 = zzsh.zzc(zzrw1, 16);
                int ai2[];
                int l;
                if (zziH == null)
                {
                    l = 0;
                } else
                {
                    l = zziH.length;
                }
                ai2 = new int[l2 + l];
                l2 = l;
                if (l != 0)
                {
                    System.arraycopy(zziH, 0, ai2, 0, l);
                    l2 = l;
                }
                for (; l2 < ai2.length - 1; l2++)
                {
                    ai2[l2] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai2[l2] = zzrw1.zzFr();
                zziH = ai2;
                break;

            case 18: // '\022'
                int k4 = zzrw1.zzlC(zzrw1.zzFv());
                int i1 = zzrw1.getPosition();
                int i3;
                for (i3 = 0; zzrw1.zzFA() > 0; i3++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(i1);
                int ai3[];
                if (zziH == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zziH.length;
                }
                ai3 = new int[i3 + i1];
                i3 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zziH, 0, ai3, 0, i1);
                    i3 = i1;
                }
                for (; i3 < ai3.length; i3++)
                {
                    ai3[i3] = zzrw1.zzFr();
                }

                zziH = ai3;
                zzrw1.zzlD(k4);
                break;

            case 24: // '\030'
                int j3 = zzsh.zzc(zzrw1, 24);
                int ai4[];
                int j1;
                if (zziI == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = zziI.length;
                }
                ai4 = new int[j3 + j1];
                j3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(zziI, 0, ai4, 0, j1);
                    j3 = j1;
                }
                for (; j3 < ai4.length - 1; j3++)
                {
                    ai4[j3] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai4[j3] = zzrw1.zzFr();
                zziI = ai4;
                break;

            case 26: // '\032'
                int l4 = zzrw1.zzlC(zzrw1.zzFv());
                int k1 = zzrw1.getPosition();
                int k3;
                for (k3 = 0; zzrw1.zzFA() > 0; k3++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(k1);
                int ai5[];
                if (zziI == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = zziI.length;
                }
                ai5 = new int[k3 + k1];
                k3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(zziI, 0, ai5, 0, k1);
                    k3 = k1;
                }
                for (; k3 < ai5.length; k3++)
                {
                    ai5[k3] = zzrw1.zzFr();
                }

                zziI = ai5;
                zzrw1.zzlD(l4);
                break;

            case 32: // ' '
                zziJ = zzrw1.zzFr();
                break;

            case 40: // '('
                int l3 = zzsh.zzc(zzrw1, 40);
                int ai6[];
                int l1;
                if (zziK == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = zziK.length;
                }
                ai6 = new int[l3 + l1];
                l3 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(zziK, 0, ai6, 0, l1);
                    l3 = l1;
                }
                for (; l3 < ai6.length - 1; l3++)
                {
                    ai6[l3] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai6[l3] = zzrw1.zzFr();
                zziK = ai6;
                break;

            case 42: // '*'
                int i5 = zzrw1.zzlC(zzrw1.zzFv());
                int i2 = zzrw1.getPosition();
                int i4;
                for (i4 = 0; zzrw1.zzFA() > 0; i4++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(i2);
                int ai7[];
                if (zziK == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = zziK.length;
                }
                ai7 = new int[i4 + i2];
                i4 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(zziK, 0, ai7, 0, i2);
                    i4 = i2;
                }
                for (; i4 < ai7.length; i4++)
                {
                    ai7[i4] = zzrw1.zzFr();
                }

                zziK = ai7;
                zzrw1.zzlD(i5);
                break;

            case 48: // '0'
                zziL = zzrw1.zzFr();
                break;

            case 56: // '8'
                zziM = zzrw1.zzFr();
                break;
            }
        } while (true);
    }


    public ()
    {
        zzM();
    }
}
