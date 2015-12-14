// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrx;
import java.io.IOException;

public final class zzar extends zzrr
{

    public int versionCode;
    public long zzajA;
    public long zzajy;
    public long zzajz;

    public zzar()
    {
        zzqK();
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
            if (obj instanceof zzar)
            {
                obj = (zzar)obj;
                flag = flag1;
                if (versionCode == ((zzar) (obj)).versionCode)
                {
                    flag = flag1;
                    if (zzajy == ((zzar) (obj)).zzajy)
                    {
                        flag = flag1;
                        if (zzajz == ((zzar) (obj)).zzajz)
                        {
                            flag = flag1;
                            if (zzajA == ((zzar) (obj)).zzajA)
                            {
                                return zza(((zzrr) (obj)));
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return ((((versionCode + 527) * 31 + (int)(zzajy ^ zzajy >>> 32)) * 31 + (int)(zzajz ^ zzajz >>> 32)) * 31 + (int)(zzajA ^ zzajA >>> 32)) * 31 + zzDk();
    }

    protected int zzB()
    {
        return super.zzB() + zzrq.zzB(1, versionCode) + zzrq.zze(2, zzajy) + zzrq.zze(3, zzajz) + zzrq.zze(4, zzajA);
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        zzrq1.zzz(1, versionCode);
        zzrq1.zzc(2, zzajy);
        zzrq1.zzc(3, zzajz);
        zzrq1.zzc(4, zzajA);
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzm(zzrp1);
    }

    public zzar zzm(zzrp zzrp1)
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

            case 16: // '\020'
                zzajy = zzrp1.zzCZ();
                break;

            case 24: // '\030'
                zzajz = zzrp1.zzCZ();
                break;

            case 32: // ' '
                zzajA = zzrp1.zzCZ();
                break;
            }
        } while (true);
    }

    public zzar zzqK()
    {
        versionCode = 1;
        zzajy = -1L;
        zzajz = -1L;
        zzajA = -1L;
        zzbca = null;
        zzbcl = -1;
        return this;
    }
}
