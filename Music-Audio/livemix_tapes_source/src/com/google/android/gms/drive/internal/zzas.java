// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import java.io.IOException;

public final class zzas extends zzrr
{

    public int versionCode;
    public String zzajB;
    public long zzajC;
    public int zzajD;
    public long zzajz;

    public zzas()
    {
        zzqL();
    }

    public static zzas zzl(byte abyte0[])
        throws zzrw
    {
        return (zzas)zzrx.zza(new zzas(), abyte0);
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
        if (!(obj instanceof zzas))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (zzas)obj;
        flag = flag1;
        if (versionCode != ((zzas) (obj)).versionCode)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (zzajB != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((zzas) (obj)).zzajB != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = flag1;
        if (zzajC == ((zzas) (obj)).zzajC)
        {
            flag = flag1;
            if (zzajz == ((zzas) (obj)).zzajz)
            {
                flag = flag1;
                if (zzajD == ((zzas) (obj)).zzajD)
                {
                    return zza(((zzrr) (obj)));
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!zzajB.equals(((zzas) (obj)).zzajB))
        {
            return false;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j = versionCode;
        int i;
        if (zzajB == null)
        {
            i = 0;
        } else
        {
            i = zzajB.hashCode();
        }
        return ((((i + (j + 527) * 31) * 31 + (int)(zzajC ^ zzajC >>> 32)) * 31 + (int)(zzajz ^ zzajz >>> 32)) * 31 + zzajD) * 31 + zzDk();
    }

    protected int zzB()
    {
        int j = super.zzB() + zzrq.zzB(1, versionCode) + zzrq.zzl(2, zzajB) + zzrq.zze(3, zzajC) + zzrq.zze(4, zzajz);
        int i = j;
        if (zzajD != -1)
        {
            i = j + zzrq.zzB(5, zzajD);
        }
        return i;
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        zzrq1.zzz(1, versionCode);
        zzrq1.zzb(2, zzajB);
        zzrq1.zzc(3, zzajC);
        zzrq1.zzc(4, zzajz);
        if (zzajD != -1)
        {
            zzrq1.zzz(5, zzajD);
        }
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzn(zzrp1);
    }

    public zzas zzn(zzrp zzrp1)
        throws IOException
    {
        do
        {
            int i = zzrp1.zzCT();
            switch (i)
            {
            default:
                if (zza(zzrp1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                versionCode = zzrp1.zzCW();
                break;

            case 18: // '\022'
                zzajB = zzrp1.readString();
                break;

            case 24: // '\030'
                zzajC = zzrp1.zzCZ();
                break;

            case 32: // ' '
                zzajz = zzrp1.zzCZ();
                break;

            case 40: // '('
                zzajD = zzrp1.zzCW();
                break;
            }
        } while (true);
    }

    public zzas zzqL()
    {
        versionCode = 1;
        zzajB = "";
        zzajC = -1L;
        zzajz = -1L;
        zzajD = -1;
        zzbca = null;
        zzbcl = -1;
        return this;
    }
}
