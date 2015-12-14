// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrx;
import java.io.IOException;

public final class zzat extends zzrr
{

    public long zzajC;
    public long zzajz;

    public zzat()
    {
        zzqM();
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
            if (obj instanceof zzat)
            {
                obj = (zzat)obj;
                flag = flag1;
                if (zzajC == ((zzat) (obj)).zzajC)
                {
                    flag = flag1;
                    if (zzajz == ((zzat) (obj)).zzajz)
                    {
                        return zza(((zzrr) (obj)));
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (((int)(zzajC ^ zzajC >>> 32) + 527) * 31 + (int)(zzajz ^ zzajz >>> 32)) * 31 + zzDk();
    }

    protected int zzB()
    {
        return super.zzB() + zzrq.zze(1, zzajC) + zzrq.zze(2, zzajz);
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        zzrq1.zzc(1, zzajC);
        zzrq1.zzc(2, zzajz);
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzo(zzrp1);
    }

    public zzat zzo(zzrp zzrp1)
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
                zzajC = zzrp1.zzCZ();
                break;

            case 16: // '\020'
                zzajz = zzrp1.zzCZ();
                break;
            }
        } while (true);
    }

    public zzat zzqM()
    {
        zzajC = -1L;
        zzajz = -1L;
        zzbca = null;
        zzbcl = -1;
        return this;
    }
}
