// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import java.io.IOException;

public final class zzat extends zzry
{

    public int versionCode;
    public long zzalO;
    public String zzalQ;
    public long zzalR;
    public int zzalS;

    public zzat()
    {
        zzrt();
    }

    public static zzat zzl(byte abyte0[])
        throws zzsd
    {
        return (zzat)zzse.zza(new zzat(), abyte0);
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
        if (!(obj instanceof zzat)) goto _L4; else goto _L3
_L3:
        obj = (zzat)obj;
        flag = flag1;
        if (versionCode != ((zzat) (obj)).versionCode) goto _L4; else goto _L5
_L5:
        if (zzalQ != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        flag = flag1;
        if (((zzat) (obj)).zzalQ != null) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (zzalR != ((zzat) (obj)).zzalR) goto _L4; else goto _L7
_L7:
        flag = flag1;
        if (zzalO != ((zzat) (obj)).zzalO) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (zzalS != ((zzat) (obj)).zzalS) goto _L4; else goto _L9
_L9:
        if (zzbik != null && !zzbik.isEmpty())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (((zzat) (obj)).zzbik == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!((zzat) (obj)).zzbik.isEmpty()) goto _L4; else goto _L10
_L10:
        return true;
        if (!zzalQ.equals(((zzat) (obj)).zzalQ))
        {
            return false;
        }
          goto _L6
        return zzbik.equals(((zzat) (obj)).zzbik);
    }

    public int hashCode()
    {
        boolean flag = false;
        int k = getClass().getName().hashCode();
        int l = versionCode;
        int i;
        int j;
        int i1;
        int j1;
        int k1;
        if (zzalQ == null)
        {
            i = 0;
        } else
        {
            i = zzalQ.hashCode();
        }
        i1 = (int)(zzalR ^ zzalR >>> 32);
        j1 = (int)(zzalO ^ zzalO >>> 32);
        k1 = zzalS;
        j = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = zzbik.hashCode();
            }
        }
        return ((((i + ((k + 527) * 31 + l) * 31) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + j;
    }

    protected int zzB()
    {
        int j = super.zzB() + zzrx.zzA(1, versionCode) + zzrx.zzn(2, zzalQ) + zzrx.zze(3, zzalR) + zzrx.zze(4, zzalO);
        int i = j;
        if (zzalS != -1)
        {
            i = j + zzrx.zzA(5, zzalS);
        }
        return i;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        zzrx1.zzy(1, versionCode);
        zzrx1.zzb(2, zzalQ);
        zzrx1.zzc(3, zzalR);
        zzrx1.zzc(4, zzalO);
        if (zzalS != -1)
        {
            zzrx1.zzy(5, zzalS);
        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzn(zzrw1);
    }

    public zzat zzn(zzrw zzrw1)
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

            case 18: // '\022'
                zzalQ = zzrw1.readString();
                break;

            case 24: // '\030'
                zzalR = zzrw1.zzFu();
                break;

            case 32: // ' '
                zzalO = zzrw1.zzFu();
                break;

            case 40: // '('
                zzalS = zzrw1.zzFr();
                break;
            }
        } while (true);
    }

    public zzat zzrt()
    {
        versionCode = 1;
        zzalQ = "";
        zzalR = -1L;
        zzalO = -1L;
        zzalS = -1;
        zzbik = null;
        zzbiv = -1;
        return this;
    }
}
