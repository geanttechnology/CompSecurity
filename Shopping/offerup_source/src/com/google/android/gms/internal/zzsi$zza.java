// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzsh, zzrw, zzse

public final class zzFS extends zzry
{

    public String zzbiF[];
    public String zzbiG[];
    public int zzbiH[];
    public long zzbiI[];

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzFS))
            {
                return false;
            }
            obj = (zzFS)obj;
            if (!zzsc.equals(zzbiF, ((zzbiF) (obj)).zzbiF))
            {
                return false;
            }
            if (!zzsc.equals(zzbiG, ((zzbiG) (obj)).zzbiG))
            {
                return false;
            }
            if (!zzsc.equals(zzbiH, ((zzbiH) (obj)).zzbiH))
            {
                return false;
            }
            if (!zzsc.equals(zzbiI, ((zzbiI) (obj)).zzbiI))
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
        int k = zzsc.hashCode(zzbiF);
        int l = zzsc.hashCode(zzbiG);
        int i1 = zzsc.hashCode(zzbiH);
        int j1 = zzsc.hashCode(zzbiI);
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + (((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int l2 = super.zzB();
        int i;
        int k;
        if (zzbiF != null && zzbiF.length > 0)
        {
            i = 0;
            int j = 0;
            int l;
            int l1;
            for (l = 0; i < zzbiF.length; l = l1)
            {
                String s = zzbiF[i];
                int j2 = j;
                l1 = l;
                if (s != null)
                {
                    l1 = l + 1;
                    j2 = j + zzrx.zzfA(s);
                }
                i++;
                j = j2;
            }

            i = l2 + j + l * 1;
        } else
        {
            i = l2;
        }
        k = i;
        if (zzbiG != null)
        {
            k = i;
            if (zzbiG.length > 0)
            {
                k = 0;
                int i1 = 0;
                int i2;
                int k2;
                for (i2 = 0; k < zzbiG.length; i2 = k2)
                {
                    String s1 = zzbiG[k];
                    l2 = i1;
                    k2 = i2;
                    if (s1 != null)
                    {
                        k2 = i2 + 1;
                        l2 = i1 + zzrx.zzfA(s1);
                    }
                    k++;
                    i1 = l2;
                }

                k = i + i1 + i2 * 1;
            }
        }
        i = k;
        if (zzbiH != null)
        {
            i = k;
            if (zzbiH.length > 0)
            {
                i = 0;
                int j1 = 0;
                for (; i < zzbiH.length; i++)
                {
                    j1 += zzrx.zzlJ(zzbiH[i]);
                }

                i = k + j1 + zzbiH.length * 1;
            }
        }
        k = i;
        if (zzbiI != null)
        {
            k = i;
            if (zzbiI.length > 0)
            {
                int k1 = 0;
                for (k = ((flag) ? 1 : 0); k < zzbiI.length; k++)
                {
                    k1 += zzrx.zzaa(zzbiI[k]);
                }

                k = i + k1 + zzbiI.length * 1;
            }
        }
        return k;
    }

    public final zzbiI zzFS()
    {
        zzbiF = zzsh.zzbiC;
        zzbiG = zzsh.zzbiC;
        zzbiH = zzsh.zzbix;
        zzbiI = zzsh.zzbiy;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final zzbiv zzG(zzrw zzrw1)
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
                int l1 = zzsh.zzc(zzrw1, 10);
                String as[];
                int j;
                if (zzbiF == null)
                {
                    j = 0;
                } else
                {
                    j = zzbiF.length;
                }
                as = new String[l1 + j];
                l1 = j;
                if (j != 0)
                {
                    System.arraycopy(zzbiF, 0, as, 0, j);
                    l1 = j;
                }
                for (; l1 < as.length - 1; l1++)
                {
                    as[l1] = zzrw1.readString();
                    zzrw1.zzFo();
                }

                as[l1] = zzrw1.readString();
                zzbiF = as;
                break;

            case 18: // '\022'
                int i2 = zzsh.zzc(zzrw1, 18);
                String as1[];
                int k;
                if (zzbiG == null)
                {
                    k = 0;
                } else
                {
                    k = zzbiG.length;
                }
                as1 = new String[i2 + k];
                i2 = k;
                if (k != 0)
                {
                    System.arraycopy(zzbiG, 0, as1, 0, k);
                    i2 = k;
                }
                for (; i2 < as1.length - 1; i2++)
                {
                    as1[i2] = zzrw1.readString();
                    zzrw1.zzFo();
                }

                as1[i2] = zzrw1.readString();
                zzbiG = as1;
                break;

            case 24: // '\030'
                int j2 = zzsh.zzc(zzrw1, 24);
                int ai[];
                int l;
                if (zzbiH == null)
                {
                    l = 0;
                } else
                {
                    l = zzbiH.length;
                }
                ai = new int[j2 + l];
                j2 = l;
                if (l != 0)
                {
                    System.arraycopy(zzbiH, 0, ai, 0, l);
                    j2 = l;
                }
                for (; j2 < ai.length - 1; j2++)
                {
                    ai[j2] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai[j2] = zzrw1.zzFr();
                zzbiH = ai;
                break;

            case 26: // '\032'
                int j3 = zzrw1.zzlC(zzrw1.zzFv());
                int i1 = zzrw1.getPosition();
                int k2;
                for (k2 = 0; zzrw1.zzFA() > 0; k2++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(i1);
                int ai1[];
                if (zzbiH == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzbiH.length;
                }
                ai1 = new int[k2 + i1];
                k2 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzbiH, 0, ai1, 0, i1);
                    k2 = i1;
                }
                for (; k2 < ai1.length; k2++)
                {
                    ai1[k2] = zzrw1.zzFr();
                }

                zzbiH = ai1;
                zzrw1.zzlD(j3);
                break;

            case 32: // ' '
                int l2 = zzsh.zzc(zzrw1, 32);
                long al[];
                int j1;
                if (zzbiI == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = zzbiI.length;
                }
                al = new long[l2 + j1];
                l2 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(zzbiI, 0, al, 0, j1);
                    l2 = j1;
                }
                for (; l2 < al.length - 1; l2++)
                {
                    al[l2] = zzrw1.zzFq();
                    zzrw1.zzFo();
                }

                al[l2] = zzrw1.zzFq();
                zzbiI = al;
                break;

            case 34: // '"'
                int k3 = zzrw1.zzlC(zzrw1.zzFv());
                int k1 = zzrw1.getPosition();
                int i3;
                for (i3 = 0; zzrw1.zzFA() > 0; i3++)
                {
                    zzrw1.zzFq();
                }

                zzrw1.zzlE(k1);
                long al1[];
                if (zzbiI == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = zzbiI.length;
                }
                al1 = new long[i3 + k1];
                i3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(zzbiI, 0, al1, 0, k1);
                    i3 = k1;
                }
                for (; i3 < al1.length; i3++)
                {
                    al1[i3] = zzrw1.zzFq();
                }

                zzbiI = al1;
                zzrw1.zzlD(k3);
                break;
            }
        } while (true);
    }

    public final void zza(zzrx zzrx1)
    {
        boolean flag = false;
        if (zzbiF != null && zzbiF.length > 0)
        {
            for (int i = 0; i < zzbiF.length; i++)
            {
                String s = zzbiF[i];
                if (s != null)
                {
                    zzrx1.zzb(1, s);
                }
            }

        }
        if (zzbiG != null && zzbiG.length > 0)
        {
            for (int j = 0; j < zzbiG.length; j++)
            {
                String s1 = zzbiG[j];
                if (s1 != null)
                {
                    zzrx1.zzb(2, s1);
                }
            }

        }
        if (zzbiH != null && zzbiH.length > 0)
        {
            for (int k = 0; k < zzbiH.length; k++)
            {
                zzrx1.zzy(3, zzbiH[k]);
            }

        }
        if (zzbiI != null && zzbiI.length > 0)
        {
            for (int l = ((flag) ? 1 : 0); l < zzbiI.length; l++)
            {
                zzrx1.zzb(4, zzbiI[l]);
            }

        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzG(zzrw1);
    }

    public ()
    {
        zzFS();
    }
}
