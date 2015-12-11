// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzse

public final class zzwg extends zzry
{

    private static volatile zzbiv zzaCY[];
    public String name;
    public zzbiv zzaCZ;

    public static zzwg[] zzwf()
    {
        if (zzaCY == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzaCY == null)
                {
                    zzaCY = new zzaCY[0];
                }
            }
        }
        return zzaCY;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzaCY))
            {
                return false;
            }
            obj = (zzaCY)obj;
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
            if (zzaCZ == null)
            {
                if (((zzaCZ) (obj)).zzaCZ != null)
                {
                    return false;
                }
            } else
            if (!zzaCZ.equals(((equals) (obj)).zzaCZ))
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
        int i;
        int j;
        int k;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        if (zzaCZ == null)
        {
            j = 0;
        } else
        {
            j = zzaCZ.hashCode();
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
        return (j + (i + (l + 527) * 31) * 31) * 31 + k;
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
        if (zzaCZ != null)
        {
            j = i + zzrx.zzc(2, zzaCZ);
        }
        return j;
    }

    public final void zza(zzrx zzrx1)
    {
        if (!name.equals(""))
        {
            zzrx1.zzb(1, name);
        }
        if (zzaCZ != null)
        {
            zzrx1.zza(2, zzaCZ);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzr(zzrw1);
    }

    public final zzr zzr(zzrw zzrw1)
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
                if (zzaCZ == null)
                {
                    zzaCZ = new <init>();
                }
                zzrw1.zza(zzaCZ);
                break;
            }
        } while (true);
    }

    public final zzaCZ zzwg()
    {
        name = "";
        zzaCZ = null;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public ()
    {
        zzwg();
    }
}
