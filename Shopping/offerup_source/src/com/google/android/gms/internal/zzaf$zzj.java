// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzse, zzsc, zzsa, 
//            zzrx, zzrw, zzsh

public final class zzP extends zzry
{

    public String zziQ[];
    public String zziR;
    public String zziS;

    public static zzP zzd(byte abyte0[])
    {
        return (zzP)zzse.zza(new <init>(), abyte0);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof <init>))
            {
                return false;
            }
            obj = (<init>)obj;
            if (!zzsc.equals(zziQ, ((zziQ) (obj)).zziQ))
            {
                return false;
            }
            if (zziR == null)
            {
                if (((zziR) (obj)).zziR != null)
                {
                    return false;
                }
            } else
            if (!zziR.equals(((equals) (obj)).zziR))
            {
                return false;
            }
            if (zziS == null)
            {
                if (((zziS) (obj)).zziS != null)
                {
                    return false;
                }
            } else
            if (!zziS.equals(((zziS) (obj)).zziS))
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
        boolean flag = false;
        int l = getClass().getName().hashCode();
        int i1 = zzsc.hashCode(zziQ);
        int i;
        int j;
        int k;
        if (zziR == null)
        {
            i = 0;
        } else
        {
            i = zziR.hashCode();
        }
        if (zziS == null)
        {
            j = 0;
        } else
        {
            j = zziS.hashCode();
        }
        k = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                k = ((flag) ? 1 : 0);
            } else
            {
                k = zzbik.hashCode();
            }
        }
        return (j + (i + ((l + 527) * 31 + i1) * 31) * 31) * 31 + k;
    }

    protected final int zzB()
    {
        int i = super.zzB();
        int j = i;
        if (zziQ != null)
        {
            j = i;
            if (zziQ.length > 0)
            {
                int k = 0;
                do
                {
                    j = i;
                    if (k >= zziQ.length)
                    {
                        break;
                    }
                    Code code = zziQ[k];
                    j = i;
                    if (code != null)
                    {
                        j = i + zzrx.zzc(1, code);
                    }
                    k++;
                    i = j;
                } while (true);
            }
        }
        i = j;
        if (zziR != null)
        {
            i = j + zzrx.zzc(2, zziR);
        }
        j = i;
        if (!zziS.equals(""))
        {
            j = i + zzrx.zzn(3, zziS);
        }
        return j;
    }

    public final zziS zzP()
    {
        zziQ = zzN();
        zziR = null;
        zziS = "";
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        if (zziQ != null && zziQ.length > 0)
        {
            for (int i = 0; i < zziQ.length; i++)
            {
                zzbiv zzbiv = zziQ[i];
                if (zzbiv != null)
                {
                    zzrx1.zza(1, zzbiv);
                }
            }

        }
        if (zziR != null)
        {
            zzrx1.zza(2, zziR);
        }
        if (!zziS.equals(""))
        {
            zzrx1.zzb(3, zziS);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzk(zzrw1);
    }

    public final zzk zzk(zzrw zzrw1)
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
                int k = zzsh.zzc(zzrw1, 10);
                zzk azzk[];
                int j;
                if (zziQ == null)
                {
                    j = 0;
                } else
                {
                    j = zziQ.length;
                }
                azzk = new zziQ[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zziQ, 0, azzk, 0, j);
                    k = j;
                }
                for (; k < azzk.length - 1; k++)
                {
                    azzk[k] = new <init>();
                    zzrw1.zza(azzk[k]);
                    zzrw1.zzFo();
                }

                azzk[k] = new <init>();
                zzrw1.zza(azzk[k]);
                zziQ = azzk;
                break;

            case 18: // '\022'
                if (zziR == null)
                {
                    zziR = new <init>();
                }
                zzrw1.zza(zziR);
                break;

            case 26: // '\032'
                zziS = zzrw1.readString();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzP();
    }
}
