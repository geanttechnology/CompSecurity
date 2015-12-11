// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzse;
import java.io.IOException;

public final class zzas extends zzry
{

    public int versionCode;
    public long zzalN;
    public long zzalO;
    public long zzalP;

    public zzas()
    {
        zzrs();
    }

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
        if (!(obj instanceof zzas)) goto _L4; else goto _L3
_L3:
        obj = (zzas)obj;
        flag = flag1;
        if (versionCode != ((zzas) (obj)).versionCode) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (zzalN != ((zzas) (obj)).zzalN) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (zzalO != ((zzas) (obj)).zzalO) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (zzalP != ((zzas) (obj)).zzalP) goto _L4; else goto _L8
_L8:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (((zzas) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzas) (obj)).zzbik.isEmpty()) goto _L4; else goto _L9
_L9:
        return true;
        return zzbik.equals(((zzas) (obj)).zzbik);
    }

    public int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = versionCode;
        int l = (int)(zzalN ^ zzalN >>> 32);
        int i1 = (int)(zzalO ^ zzalO >>> 32);
        int j1 = (int)(zzalP ^ zzalP >>> 32);
        int i;
        if (zzbik == null || zzbik.isEmpty())
        {
            i = 0;
        } else
        {
            i = zzbik.hashCode();
        }
        return i + (((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31;
    }

    protected int zzB()
    {
        return super.zzB() + zzrx.zzA(1, versionCode) + zzrx.zze(2, zzalN) + zzrx.zze(3, zzalO) + zzrx.zze(4, zzalP);
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        zzrx1.zzy(1, versionCode);
        zzrx1.zzc(2, zzalN);
        zzrx1.zzc(3, zzalO);
        zzrx1.zzc(4, zzalP);
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzm(zzrw1);
    }

    public zzas zzm(zzrw zzrw1)
        throws IOException
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
                versionCode = zzrw1.zzFr();
                break;

            case 16: // '\020'
                zzalN = zzrw1.zzFu();
                break;

            case 24: // '\030'
                zzalO = zzrw1.zzFu();
                break;

            case 32: // ' '
                zzalP = zzrw1.zzFu();
                break;
            }
        } while (true);
    }

    public zzas zzrs()
    {
        versionCode = 1;
        zzalN = -1L;
        zzalO = -1L;
        zzalP = -1L;
        zzbik = null;
        zzbiv = -1;
        return this;
    }
}
