// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzse, zzsa, zzrx, 
//            zzrw

public final class zzDY extends zzry
{

    public long zzbai;
    public zzbaj zzbaj;
    public zzbaj zziR;

    public static zzDY zzw(byte abyte0[])
    {
        return (zzDY)zzse.zza(new <init>(), abyte0);
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
            if (zzbai != ((zzbai) (obj)).zzbai)
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
            if (zzbaj == null)
            {
                if (((zzbaj) (obj)).zzbaj != null)
                {
                    return false;
                }
            } else
            if (!zzbaj.equals(((equals) (obj)).zzbaj))
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
        int i1 = (int)(zzbai ^ zzbai >>> 32);
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
        if (zzbaj == null)
        {
            j = 0;
        } else
        {
            j = zzbaj.hashCode();
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
        int j = super.zzB() + zzrx.zzd(1, zzbai);
        int i = j;
        if (zziR != null)
        {
            i = j + zzrx.zzc(2, zziR);
        }
        j = i;
        if (zzbaj != null)
        {
            j = i + zzrx.zzc(3, zzbaj);
        }
        return j;
    }

    public final zzbaj zzDY()
    {
        zzbai = 0L;
        zziR = null;
        zzbaj = null;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        zzrx1.zzb(1, zzbai);
        if (zziR != null)
        {
            zzrx1.zza(2, zziR);
        }
        if (zzbaj != null)
        {
            zzrx1.zza(3, zzbaj);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzz(zzrw1);
    }

    public final zzz zzz(zzrw zzrw1)
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
                zzbai = zzrw1.zzFq();
                break;

            case 18: // '\022'
                if (zziR == null)
                {
                    zziR = new <init>();
                }
                zzrw1.zza(zziR);
                break;

            case 26: // '\032'
                if (zzbaj == null)
                {
                    zzbaj = new <init>();
                }
                zzrw1.zza(zzbaj);
                break;
            }
        } while (true);
    }

    public ()
    {
        zzDY();
    }
}
