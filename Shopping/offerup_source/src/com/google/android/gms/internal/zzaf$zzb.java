// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzsh, zzrw, zzse

public final class zzD extends zzry
{

    private static volatile  zzhP[];
    public int name;
    public int zzhQ[];
    public int zzhR;
    public boolean zzhS;
    public boolean zzhT;

    public static zzD[] zzC()
    {
        if (zzhP == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzhP == null)
                {
                    zzhP = new zzhP[0];
                }
            }
        }
        return zzhP;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzhP))
            {
                return false;
            }
            obj = (zzhP)obj;
            if (!zzsc.equals(zzhQ, ((zzhQ) (obj)).zzhQ))
            {
                return false;
            }
            if (zzhR != ((zzhR) (obj)).zzhR)
            {
                return false;
            }
            if (name != ((name) (obj)).name)
            {
                return false;
            }
            if (zzhS != ((zzhS) (obj)).zzhS)
            {
                return false;
            }
            if (zzhT != ((zzhT) (obj)).zzhT)
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
        char c1 = '\u04CF';
        int j = getClass().getName().hashCode();
        int k = zzsc.hashCode(zzhQ);
        int l = zzhR;
        int i1 = name;
        char c;
        int i;
        if (zzhS)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (!zzhT)
        {
            c1 = '\u04D5';
        }
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + ((c + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31) * 31 + c1) * 31;
    }

    protected final int zzB()
    {
        int j = 0;
        int k = super.zzB();
        int i = k;
        if (zzhT)
        {
            i = k + zzrx.zzc(1, zzhT);
        }
        k = zzrx.zzA(2, zzhR) + i;
        if (zzhQ != null && zzhQ.length > 0)
        {
            for (i = 0; i < zzhQ.length; i++)
            {
                j += zzrx.zzlJ(zzhQ[i]);
            }

            j = k + j + zzhQ.length * 1;
        } else
        {
            j = k;
        }
        i = j;
        if (name != 0)
        {
            i = j + zzrx.zzA(4, name);
        }
        j = i;
        if (zzhS)
        {
            j = i + zzrx.zzc(6, zzhS);
        }
        return j;
    }

    public final zzhS zzD()
    {
        zzhQ = zzsh.zzbix;
        zzhR = 0;
        name = 0;
        zzhS = false;
        zzhT = false;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        if (zzhT)
        {
            zzrx1.zzb(1, zzhT);
        }
        zzrx1.zzy(2, zzhR);
        if (zzhQ != null && zzhQ.length > 0)
        {
            for (int i = 0; i < zzhQ.length; i++)
            {
                zzrx1.zzy(3, zzhQ[i]);
            }

        }
        if (name != 0)
        {
            zzrx1.zzy(4, name);
        }
        if (zzhS)
        {
            zzrx1.zzb(6, zzhS);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzc(zzrw1);
    }

    public final zzc zzc(zzrw zzrw1)
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
                zzhT = zzrw1.zzFs();
                break;

            case 16: // '\020'
                zzhR = zzrw1.zzFr();
                break;

            case 24: // '\030'
                int l = zzsh.zzc(zzrw1, 24);
                int ai[];
                int j;
                if (zzhQ == null)
                {
                    j = 0;
                } else
                {
                    j = zzhQ.length;
                }
                ai = new int[l + j];
                l = j;
                if (j != 0)
                {
                    System.arraycopy(zzhQ, 0, ai, 0, j);
                    l = j;
                }
                for (; l < ai.length - 1; l++)
                {
                    ai[l] = zzrw1.zzFr();
                    zzrw1.zzFo();
                }

                ai[l] = zzrw1.zzFr();
                zzhQ = ai;
                break;

            case 26: // '\032'
                int j1 = zzrw1.zzlC(zzrw1.zzFv());
                int k = zzrw1.getPosition();
                int i1;
                for (i1 = 0; zzrw1.zzFA() > 0; i1++)
                {
                    zzrw1.zzFr();
                }

                zzrw1.zzlE(k);
                int ai1[];
                if (zzhQ == null)
                {
                    k = 0;
                } else
                {
                    k = zzhQ.length;
                }
                ai1 = new int[i1 + k];
                i1 = k;
                if (k != 0)
                {
                    System.arraycopy(zzhQ, 0, ai1, 0, k);
                    i1 = k;
                }
                for (; i1 < ai1.length; i1++)
                {
                    ai1[i1] = zzrw1.zzFr();
                }

                zzhQ = ai1;
                zzrw1.zzlD(j1);
                break;

            case 32: // ' '
                name = zzrw1.zzFr();
                break;

            case 48: // '0'
                zzhS = zzrw1.zzFs();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzD();
    }
}
