// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzns, zzny, zznr, zznq

public final class zzye extends zzns
{

    public long zzaGL;
    public zzaNT zzaGM;
    public zzaNT zzhh;

    public static zzye zzo(byte abyte0[])
    {
        return (zzye)zzny.zza(new <init>(), abyte0);
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
        if (!(obj instanceof <init>)) goto _L4; else goto _L3
_L3:
        obj = (<init>)obj;
        flag = flag1;
        if (zzaGL != ((zzaGL) (obj)).zzaGL) goto _L4; else goto _L5
_L5:
        if (zzhh != null) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (((zzhh) (obj)).zzhh != null) goto _L4; else goto _L8
_L8:
        if (zzaGM != null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        flag = flag1;
        if (((zzaGM) (obj)).zzaGM != null) goto _L4; else goto _L9
_L9:
        return zza(((zzns) (obj)));
_L7:
        if (!zzhh.quals(((quals) (obj)).zzhh))
        {
            return false;
        }
          goto _L8
        if (!zzaGM.quals(((quals) (obj)).zzaGM))
        {
            return false;
        }
          goto _L9
    }

    public int hashCode()
    {
        int j = 0;
        int k = (int)(zzaGL ^ zzaGL >>> 32);
        int i;
        if (zzhh == null)
        {
            i = 0;
        } else
        {
            i = zzhh.ashCode();
        }
        if (zzaGM != null)
        {
            j = zzaGM.ashCode();
        }
        return ((i + (k + 527) * 31) * 31 + j) * 31 + zzzP();
    }

    public void zza(zznr zznr1)
    {
        zznr1.zzb(1, zzaGL);
        if (zzhh != null)
        {
            zznr1.zza(2, zzhh);
        }
        if (zzaGM != null)
        {
            zznr1.zza(3, zzaGM);
        }
        super.zza(zznr1);
    }

    public zzny zzb(zznq zznq1)
    {
        return zzu(zznq1);
    }

    protected int zzc()
    {
        int j = super.zzc() + zznr.zzd(1, zzaGL);
        int i = j;
        if (zzhh != null)
        {
            i = j + zznr.zzc(2, zzhh);
        }
        j = i;
        if (zzaGM != null)
        {
            j = i + zznr.zzc(3, zzaGM);
        }
        return j;
    }

    public zzaGM zzu(zznq zznq1)
    {
        do
        {
            int i = zznq1.zzzy();
            switch (i)
            {
            default:
                if (zza(zznq1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                zzaGL = zznq1.zzzA();
                break;

            case 18: // '\022'
                if (zzhh == null)
                {
                    zzhh = new init>();
                }
                zznq1.zza(zzhh);
                break;

            case 26: // '\032'
                if (zzaGM == null)
                {
                    zzaGM = new init>();
                }
                zznq1.zza(zzaGM);
                break;
            }
        } while (true);
    }

    public zzaGM zzye()
    {
        zzaGL = 0L;
        zzhh = null;
        zzaGM = null;
        zzaNI = null;
        zzaNT = -1;
        return this;
    }

    public ()
    {
        zzye();
    }
}
