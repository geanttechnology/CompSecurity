// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzrh, zzrl, zzrg, zzrf, 
//            zzrn

public final class zzF extends zzrh
{

    private static volatile  zzhR[];
    public String zzaC;
    public long zzhS;
    public long zzhT;
    public boolean zzhU;
    public long zzhV;

    public static zzF[] zzE()
    {
        if (zzhR == null)
        {
            synchronized (zzrl.zzaWe)
            {
                if (zzhR == null)
                {
                    zzhR = new zzhR[0];
                }
            }
        }
        return zzhR;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
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
        if (!(obj instanceof zzhR))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (zzhR)obj;
        if (zzaC != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((zzaC) (obj)).zzaC != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = flag1;
        if (zzhS == ((zzhS) (obj)).zzhS)
        {
            flag = flag1;
            if (zzhT == ((zzhT) (obj)).zzhT)
            {
                flag = flag1;
                if (zzhU == ((zzhU) (obj)).zzhU)
                {
                    flag = flag1;
                    if (zzhV == ((zzhV) (obj)).zzhV)
                    {
                        return zza(((zzrh) (obj)));
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!zzaC.equals(((zzaC) (obj)).zzaC))
        {
            return false;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int i;
        char c;
        int j;
        int k;
        if (zzaC == null)
        {
            i = 0;
        } else
        {
            i = zzaC.hashCode();
        }
        j = (int)(zzhS ^ zzhS >>> 32);
        k = (int)(zzhT ^ zzhT >>> 32);
        if (zzhU)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return ((c + (((i + 527) * 31 + j) * 31 + k) * 31) * 31 + (int)(zzhV ^ zzhV >>> 32)) * 31 + zzBI();
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!zzaC.equals(""))
        {
            i = j + zzrg.zzk(1, zzaC);
        }
        j = i;
        if (zzhS != 0L)
        {
            j = i + zzrg.zzd(2, zzhS);
        }
        i = j;
        if (zzhT != 0x7fffffffL)
        {
            i = j + zzrg.zzd(3, zzhT);
        }
        j = i;
        if (zzhU)
        {
            j = i + zzrg.zzc(4, zzhU);
        }
        i = j;
        if (zzhV != 0L)
        {
            i = j + zzrg.zzd(5, zzhV);
        }
        return i;
    }

    public zzhV zzF()
    {
        zzaC = "";
        zzhS = 0L;
        zzhT = 0x7fffffffL;
        zzhU = false;
        zzhV = 0L;
        zzaVU = null;
        zzaWf = -1;
        return this;
    }

    public void zza(zzrg zzrg1)
    {
        if (!zzaC.equals(""))
        {
            zzrg1.zzb(1, zzaC);
        }
        if (zzhS != 0L)
        {
            zzrg1.zzb(2, zzhS);
        }
        if (zzhT != 0x7fffffffL)
        {
            zzrg1.zzb(3, zzhT);
        }
        if (zzhU)
        {
            zzrg1.zzb(4, zzhU);
        }
        if (zzhV != 0L)
        {
            zzrg1.zzb(5, zzhV);
        }
        super.zza(zzrg1);
    }

    public zzrn zzb(zzrf zzrf1)
    {
        return zzd(zzrf1);
    }

    public zzd zzd(zzrf zzrf1)
    {
        do
        {
            int i = zzrf1.zzBr();
            switch (i)
            {
            default:
                if (zza(zzrf1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                zzaC = zzrf1.readString();
                break;

            case 16: // '\020'
                zzhS = zzrf1.zzBt();
                break;

            case 24: // '\030'
                zzhT = zzrf1.zzBt();
                break;

            case 32: // ' '
                zzhU = zzrf1.zzBv();
                break;

            case 40: // '('
                zzhV = zzrf1.zzBt();
                break;
            }
        } while (true);
    }

    public ()
    {
        zzF();
    }
}
