// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzse

public final class zzO extends zzry
{

    private static volatile zziP zziN[];
    public String name;
    public zziP zziO;
    public zziP zziP;

    public static zzO[] zzN()
    {
        if (zziN == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zziN == null)
                {
                    zziN = new zziN[0];
                }
            }
        }
        return zziN;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zziN))
            {
                return false;
            }
            obj = (zziN)obj;
            if (name == null)
            {
                if (((name) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((name) (obj)).name))
            {
                return false;
            }
            if (zziO == null)
            {
                if (((zziO) (obj)).zziO != null)
                {
                    return false;
                }
            } else
            if (!zziO.equals(((equals) (obj)).zziO))
            {
                return false;
            }
            if (zziP == null)
            {
                if (((zziP) (obj)).zziP != null)
                {
                    return false;
                }
            } else
            if (!zziP.equals(((equals) (obj)).zziP))
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
        int i1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        if (zziO == null)
        {
            j = 0;
        } else
        {
            j = zziO.hashCode();
        }
        if (zziP == null)
        {
            k = 0;
        } else
        {
            k = zziP.hashCode();
        }
        l = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                l = ((flag) ? 1 : 0);
            } else
            {
                l = zzbik.hashCode();
            }
        }
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + l;
    }

    protected final int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!name.equals(""))
        {
            i = j + zzrx.zzn(1, name);
        }
        j = i;
        if (zziO != null)
        {
            j = i + zzrx.zzc(2, zziO);
        }
        i = j;
        if (zziP != null)
        {
            i = j + zzrx.zzc(3, zziP);
        }
        return i;
    }

    public final zziP zzO()
    {
        name = "";
        zziO = null;
        zziP = null;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        if (!name.equals(""))
        {
            zzrx1.zzb(1, name);
        }
        if (zziO != null)
        {
            zzrx1.zza(2, zziO);
        }
        if (zziP != null)
        {
            zzrx1.zza(3, zziP);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzj(zzrw1);
    }

    public final zzj zzj(zzrw zzrw1)
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
                name = zzrw1.readString();
                break;

            case 18: // '\022'
                if (zziO == null)
                {
                    zziO = new <init>();
                }
                zzrw1.zza(zziO);
                break;

            case 26: // '\032'
                if (zziP == null)
                {
                    zziP = new <init>();
                }
                zzrw1.zza(zziP);
                break;
            }
        } while (true);
    }

    public ()
    {
        zzO();
    }
}
