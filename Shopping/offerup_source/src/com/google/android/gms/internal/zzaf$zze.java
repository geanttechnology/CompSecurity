// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzse

public final class zzI extends zzry
{

    private static volatile  zzic[];
    public int key;
    public int value;

    public static zzI[] zzH()
    {
        if (zzic == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzic == null)
                {
                    zzic = new zzic[0];
                }
            }
        }
        return zzic;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzic))
            {
                return false;
            }
            obj = (zzic)obj;
            if (key != ((key) (obj)).key)
            {
                return false;
            }
            if (value != ((value) (obj)).value)
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
        int k = key;
        int l = value;
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + (((j + 527) * 31 + k) * 31 + l) * 31;
    }

    protected final int zzB()
    {
        return super.zzB() + zzrx.zzA(1, key) + zzrx.zzA(2, value);
    }

    public final value zzI()
    {
        key = 0;
        value = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        zzrx1.zzy(1, key);
        zzrx1.zzy(2, value);
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzf(zzrw1);
    }

    public final zzf zzf(zzrw zzrw1)
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
                key = zzrw1.zzFr();
                break;

            case 16: // '\020'
                value = zzrw1.zzFr();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzI();
    }
}
