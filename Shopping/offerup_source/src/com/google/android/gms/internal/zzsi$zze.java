// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzse

public final class zzFX extends zzry
{

    private static volatile zzK zzbjf[];
    public String key;
    public String value;

    public static zzFX[] zzFW()
    {
        if (zzbjf == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzbjf == null)
                {
                    zzbjf = new zzbjf[0];
                }
            }
        }
        return zzbjf;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzbjf))
            {
                return false;
            }
            obj = (zzbjf)obj;
            if (key == null)
            {
                if (((key) (obj)).key != null)
                {
                    return false;
                }
            } else
            if (!key.equals(((key) (obj)).key))
            {
                return false;
            }
            if (value == null)
            {
                if (((value) (obj)).value != null)
                {
                    return false;
                }
            } else
            if (!value.equals(((value) (obj)).value))
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
        if (key == null)
        {
            i = 0;
        } else
        {
            i = key.hashCode();
        }
        if (value == null)
        {
            j = 0;
        } else
        {
            j = value.hashCode();
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
        if (!key.equals(""))
        {
            i = j + zzrx.zzn(1, key);
        }
        j = i;
        if (!value.equals(""))
        {
            j = i + zzrx.zzn(2, value);
        }
        return j;
    }

    public final value zzFX()
    {
        key = "";
        value = "";
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final zzbiv zzK(zzrw zzrw1)
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
                key = zzrw1.readString();
                break;

            case 18: // '\022'
                value = zzrw1.readString();
                break;
            }
        } while (true);
    }

    public final void zza(zzrx zzrx1)
    {
        if (!key.equals(""))
        {
            zzrx1.zzb(1, key);
        }
        if (!value.equals(""))
        {
            zzrx1.zzb(2, value);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzK(zzrw1);
    }

    public ()
    {
        zzFX();
    }
}
