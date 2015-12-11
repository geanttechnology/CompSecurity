// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsa, zzrx, zzrw, 
//            zzse

public final class zzwi extends zzry
{

    public boolean zzaDb;
    public long zzaDc;
    public double zzaDd;
    public zzbiv zzaDe;
    public String zzagS;

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzwi))
            {
                return false;
            }
            obj = (zzwi)obj;
            if (zzaDb != ((zzaDb) (obj)).zzaDb)
            {
                return false;
            }
            if (zzagS == null)
            {
                if (((zzagS) (obj)).zzagS != null)
                {
                    return false;
                }
            } else
            if (!zzagS.equals(((zzagS) (obj)).zzagS))
            {
                return false;
            }
            if (zzaDc != ((zzaDc) (obj)).zzaDc)
            {
                return false;
            }
            if (Double.doubleToLongBits(zzaDd) != Double.doubleToLongBits(((zzaDd) (obj)).zzaDd))
            {
                return false;
            }
            if (zzaDe == null)
            {
                if (((zzaDe) (obj)).zzaDe != null)
                {
                    return false;
                }
            } else
            if (!zzaDe.equals(((equals) (obj)).zzaDe))
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
        char c;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        long l1;
        if (zzaDb)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (zzagS == null)
        {
            i = 0;
        } else
        {
            i = zzagS.hashCode();
        }
        i1 = (int)(zzaDc ^ zzaDc >>> 32);
        l1 = Double.doubleToLongBits(zzaDd);
        j1 = (int)(l1 ^ l1 >>> 32);
        if (zzaDe == null)
        {
            j = 0;
        } else
        {
            j = zzaDe.hashCode();
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
        return (j + (((i + (c + (l + 527) * 31) * 31) * 31 + i1) * 31 + j1) * 31) * 31 + k;
    }

    protected final int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (zzaDb)
        {
            i = j + zzrx.zzc(1, zzaDb);
        }
        j = i;
        if (!zzagS.equals(""))
        {
            j = i + zzrx.zzn(2, zzagS);
        }
        i = j;
        if (zzaDc != 0L)
        {
            i = j + zzrx.zzd(3, zzaDc);
        }
        j = i;
        if (Double.doubleToLongBits(zzaDd) != Double.doubleToLongBits(0.0D))
        {
            j = i + zzrx.zzb(4, zzaDd);
        }
        i = j;
        if (zzaDe != null)
        {
            i = j + zzrx.zzc(5, zzaDe);
        }
        return i;
    }

    public final void zza(zzrx zzrx1)
    {
        if (zzaDb)
        {
            zzrx1.zzb(1, zzaDb);
        }
        if (!zzagS.equals(""))
        {
            zzrx1.zzb(2, zzagS);
        }
        if (zzaDc != 0L)
        {
            zzrx1.zzb(3, zzaDc);
        }
        if (Double.doubleToLongBits(zzaDd) != Double.doubleToLongBits(0.0D))
        {
            zzrx1.zza(4, zzaDd);
        }
        if (zzaDe != null)
        {
            zzrx1.zza(5, zzaDe);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzt(zzrw1);
    }

    public final zzt zzt(zzrw zzrw1)
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
                zzaDb = zzrw1.zzFs();
                break;

            case 18: // '\022'
                zzagS = zzrw1.readString();
                break;

            case 24: // '\030'
                zzaDc = zzrw1.zzFq();
                break;

            case 33: // '!'
                zzaDd = zzrw1.readDouble();
                break;

            case 42: // '*'
                if (zzaDe == null)
                {
                    zzaDe = new <init>();
                }
                zzrw1.zza(zzaDe);
                break;
            }
        } while (true);
    }

    public final zzaDe zzwi()
    {
        zzaDb = false;
        zzagS = "";
        zzaDc = 0L;
        zzaDd = 0.0D;
        zzaDe = null;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public ()
    {
        zzwi();
    }
}
