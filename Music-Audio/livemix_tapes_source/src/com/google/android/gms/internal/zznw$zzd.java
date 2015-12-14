// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrr, zznw, zzrq, zzrp, 
//            zzrx

public static final class zzvu extends zzrr
{

    public boolean zzaAt;
    public long zzaAu;
    public double zzaAv;
    public zzbcl zzaAw;
    public String zzaeO;

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
        if (!(obj instanceof zzvu)) goto _L4; else goto _L3
_L3:
        obj = (zzvu)obj;
        flag = flag1;
        if (zzaAt != ((zzaAt) (obj)).zzaAt) goto _L4; else goto _L5
_L5:
        if (zzaeO != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((zzaeO) (obj)).zzaeO != null) goto _L4; else goto _L8
_L8:
        flag = flag1;
        if (zzaAu != ((zzaAu) (obj)).zzaAu) goto _L4; else goto _L9
_L9:
        flag = flag1;
        if (Double.doubleToLongBits(zzaAv) != Double.doubleToLongBits(((zzaAv) (obj)).zzaAv)) goto _L4; else goto _L10
_L10:
        if (zzaAw != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        flag = flag1;
        if (((zzaAw) (obj)).zzaAw != null) goto _L4; else goto _L11
_L11:
        return zza(((zzrr) (obj)));
_L7:
        if (!zzaeO.equals(((zzaeO) (obj)).zzaeO))
        {
            return false;
        }
          goto _L8
        if (!zzaAw.equals(((equals) (obj)).zzaAw))
        {
            return false;
        }
          goto _L11
    }

    public int hashCode()
    {
        int j = 0;
        char c;
        int i;
        int k;
        int l;
        long l1;
        if (zzaAt)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (zzaeO == null)
        {
            i = 0;
        } else
        {
            i = zzaeO.hashCode();
        }
        k = (int)(zzaAu ^ zzaAu >>> 32);
        l1 = Double.doubleToLongBits(zzaAv);
        l = (int)(l1 ^ l1 >>> 32);
        if (zzaAw != null)
        {
            j = zzaAw.hashCode();
        }
        return ((((i + (c + 527) * 31) * 31 + k) * 31 + l) * 31 + j) * 31 + zzDk();
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (zzaAt)
        {
            i = j + zzrq.zzc(1, zzaAt);
        }
        j = i;
        if (!zzaeO.equals(""))
        {
            j = i + zzrq.zzl(2, zzaeO);
        }
        i = j;
        if (zzaAu != 0L)
        {
            i = j + zzrq.zzd(3, zzaAu);
        }
        j = i;
        if (Double.doubleToLongBits(zzaAv) != Double.doubleToLongBits(0.0D))
        {
            j = i + zzrq.zzb(4, zzaAv);
        }
        i = j;
        if (zzaAw != null)
        {
            i = j + zzrq.zzc(5, zzaAw);
        }
        return i;
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        if (zzaAt)
        {
            zzrq1.zzb(1, zzaAt);
        }
        if (!zzaeO.equals(""))
        {
            zzrq1.zzb(2, zzaeO);
        }
        if (zzaAu != 0L)
        {
            zzrq1.zzb(3, zzaAu);
        }
        if (Double.doubleToLongBits(zzaAv) != Double.doubleToLongBits(0.0D))
        {
            zzrq1.zza(4, zzaAv);
        }
        if (zzaAw != null)
        {
            zzrq1.zza(5, zzaAw);
        }
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzt(zzrp1);
    }

    public zzt zzt(zzrp zzrp1)
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
                zzaAt = zzrp1.zzCX();
                break;

            case 18: // '\022'
                zzaeO = zzrp1.readString();
                break;

            case 24: // '\030'
                zzaAu = zzrp1.zzCV();
                break;

            case 33: // '!'
                zzaAv = zzrp1.readDouble();
                break;

            case 42: // '*'
                if (zzaAw == null)
                {
                    zzaAw = new <init>();
                }
                zzrp1.zza(zzaAw);
                break;
            }
        } while (true);
    }

    public zzaAw zzvu()
    {
        zzaAt = false;
        zzaeO = "";
        zzaAu = 0L;
        zzaAv = 0.0D;
        zzaAw = null;
        zzbca = null;
        zzbcl = -1;
        return this;
    }

    public ()
    {
        zzvu();
    }
}
