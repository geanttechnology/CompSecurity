// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzrh, zzrl, zzrg, zzrf, 
//            zzrn

public final class zzI extends zzrh
{

    private static volatile  zzhZ[];
    public int key;
    public int value;

    public static zzI[] zzH()
    {
        if (zzhZ == null)
        {
            synchronized (zzrl.zzaWe)
            {
                if (zzhZ == null)
                {
                    zzhZ = new zzhZ[0];
                }
            }
        }
        return zzhZ;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof zzhZ)
            {
                obj = (zzhZ)obj;
                flag = flag1;
                if (key == ((key) (obj)).key)
                {
                    flag = flag1;
                    if (value == ((value) (obj)).value)
                    {
                        return zza(((zzrh) (obj)));
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return ((key + 527) * 31 + value) * 31 + zzBI();
    }

    protected int zzB()
    {
        return super.zzB() + zzrg.zzA(1, key) + zzrg.zzA(2, value);
    }

    public value zzI()
    {
        key = 0;
        value = 0;
        zzaVU = null;
        zzaWf = -1;
        return this;
    }

    public void zza(zzrg zzrg1)
    {
        zzrg1.zzy(1, key);
        zzrg1.zzy(2, value);
        super.zza(zzrg1);
    }

    public zzrn zzb(zzrf zzrf1)
    {
        return zzf(zzrf1);
    }

    public zzf zzf(zzrf zzrf1)
    {
        do
        {
            int i = zzrf1.zzBr();
            switch (i)
            {
            default:
                if (zza(zzrf1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                key = zzrf1.zzBu();
                break;

            case 16: // '\020'
                value = zzrf1.zzBu();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzI();
    }
}
