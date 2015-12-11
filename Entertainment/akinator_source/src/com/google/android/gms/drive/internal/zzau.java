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

public final class zzau extends zzry
{

    public long zzalO;
    public long zzalR;

    public zzau()
    {
        zzru();
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
        if (!(obj instanceof zzau)) goto _L4; else goto _L3
_L3:
        obj = (zzau)obj;
        flag = flag1;
        if (zzalR != ((zzau) (obj)).zzalR) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (zzalO != ((zzau) (obj)).zzalO) goto _L4; else goto _L6
_L6:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (((zzau) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzau) (obj)).zzbik.isEmpty()) goto _L4; else goto _L7
_L7:
        return true;
        return zzbik.equals(((zzau) (obj)).zzbik);
    }

    public int hashCode()
    {
        int j = getClass().getName().hashCode();
        int k = (int)(zzalR ^ zzalR >>> 32);
        int l = (int)(zzalO ^ zzalO >>> 32);
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

    protected int zzB()
    {
        return super.zzB() + zzrx.zze(1, zzalR) + zzrx.zze(2, zzalO);
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        zzrx1.zzc(1, zzalR);
        zzrx1.zzc(2, zzalO);
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzo(zzrw1);
    }

    public zzau zzo(zzrw zzrw1)
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
                zzalR = zzrw1.zzFu();
                break;

            case 16: // '\020'
                zzalO = zzrw1.zzFu();
                break;
            }
        } while (true);
    }

    public zzau zzru()
    {
        zzalR = -1L;
        zzalO = -1L;
        zzbik = null;
        zzbiv = -1;
        return this;
    }
}
