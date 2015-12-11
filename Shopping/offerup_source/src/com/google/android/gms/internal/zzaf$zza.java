// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsa, zzrx, zzrw, 
//            zzse

public final class zzA extends zzry
{

    public int level;
    public int zzhN;
    public int zzhO;

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzA))
            {
                return false;
            }
            obj = (zzA)obj;
            if (level != ((level) (obj)).level)
            {
                return false;
            }
            if (zzhN != ((zzhN) (obj)).zzhN)
            {
                return false;
            }
            if (zzhO != ((zzhO) (obj)).zzhO)
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
        int k = level;
        int l = zzhN;
        int i1 = zzhO;
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
    }

    public final Code zzA()
    {
        level = 1;
        zzhN = 0;
        zzhO = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    protected final int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (level != 1)
        {
            i = j + zzrx.zzA(1, level);
        }
        j = i;
        if (zzhN != 0)
        {
            j = i + zzrx.zzA(2, zzhN);
        }
        i = j;
        if (zzhO != 0)
        {
            i = j + zzrx.zzA(3, zzhO);
        }
        return i;
    }

    public final zzhO zza(zzrw zzrw1)
    {
_L6:
        int i = zzrw1.zzFo();
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   0: 57
    //                   8: 59
    //                   16: 103
    //                   24: 114;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (zza(zzrw1, i)) goto _L6; else goto _L2
_L2:
        return this;
_L3:
        int j = zzrw1.zzFr();
        switch (j)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            level = j;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        zzhN = zzrw1.zzFr();
        continue; /* Loop/switch isn't completed */
_L5:
        zzhO = zzrw1.zzFr();
        if (true) goto _L6; else goto _L7
_L7:
    }

    public final void zza(zzrx zzrx1)
    {
        if (level != 1)
        {
            zzrx1.zzy(1, level);
        }
        if (zzhN != 0)
        {
            zzrx1.zzy(2, zzhN);
        }
        if (zzhO != 0)
        {
            zzrx1.zzy(3, zzhO);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zza(zzrw1);
    }

    public ()
    {
        zzA();
    }
}
