// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzaf, zzsa, zzrx, 
//            zzrw, zzse

public static final class zzA extends zzry
{

    public int level;
    public int zzhN;
    public int zzhO;

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (obj != this) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!(obj instanceof zzA)) goto _L4; else goto _L3
_L3:
        obj = (zzA)obj;
        flag = flag1;
        if (level != ((level) (obj)).level) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (zzhN != ((zzhN) (obj)).zzhN) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (zzhO != ((zzhO) (obj)).zzhO) goto _L4; else goto _L7
_L7:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (((pty) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzbik) (obj)).zzbik.isEmpty()) goto _L4; else goto _L8
_L8:
        return true;
        return zzbik.equals(((ls) (obj)).zzbik);
    }

    public int hashCode()
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

    public Code zzA()
    {
        level = 1;
        zzhN = 0;
        zzhO = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    protected int zzB()
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

    public zzhO zza(zzrw zzrw1)
        throws IOException
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

    public void zza(zzrx zzrx1)
        throws IOException
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

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zza(zzrw1);
    }

    public ()
    {
        zzA();
    }
}
