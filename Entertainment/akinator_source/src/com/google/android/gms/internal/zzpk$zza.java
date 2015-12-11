// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzpk, zzsc, zzrx, 
//            zzrw, zzsh

public static final class zzAy extends zzse
{

    private static volatile  zzaOC[];
    public Integer count;
    public String name;
    public  zzaOD[];
    public Long zzaOE;
    public Long zzaOF;

    public static zzAy[] zzAx()
    {
        if (zzaOC == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzaOC == null)
                {
                    zzaOC = new zzaOC[0];
                }
            }
        }
        return zzaOC;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof zzaOC))
        {
            return false;
        }
        obj = (zzaOC)obj;
        if (!zzsc.equals(zzaOD, ((zzaOD) (obj)).zzaOD))
        {
            return false;
        }
        if (name == null)
        {
            if (((name) (obj)).name != null)
            {
                return false;
            }
        } else
        if (!name.equals(((name) (obj)).name))
        {
            return false;
        }
        if (zzaOE == null)
        {
            if (((zzaOE) (obj)).zzaOE != null)
            {
                return false;
            }
        } else
        if (!zzaOE.equals(((zzaOE) (obj)).zzaOE))
        {
            return false;
        }
        if (zzaOF == null)
        {
            if (((zzaOF) (obj)).zzaOF != null)
            {
                return false;
            }
        } else
        if (!zzaOF.equals(((zzaOF) (obj)).zzaOF))
        {
            return false;
        }
        if (count != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((count) (obj)).count == null) goto _L1; else goto _L3
_L3:
        return false;
        if (count.equals(((count) (obj)).count)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int l = 0;
        int i1 = getClass().getName().hashCode();
        int j1 = zzsc.hashCode(zzaOD);
        int i;
        int j;
        int k;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        if (zzaOE == null)
        {
            j = 0;
        } else
        {
            j = zzaOE.hashCode();
        }
        if (zzaOF == null)
        {
            k = 0;
        } else
        {
            k = zzaOF.hashCode();
        }
        if (count != null)
        {
            l = count.hashCode();
        }
        return (k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31) * 31 + l;
    }

    public count zzAy()
    {
        zzaOD = zzAz();
        name = null;
        zzaOE = null;
        zzaOF = null;
        count = null;
        zzbiv = -1;
        return this;
    }

    protected int zzB()
    {
        int i = super.zzB();
        int j = i;
        if (zzaOD != null)
        {
            j = i;
            if (zzaOD.length > 0)
            {
                int k = 0;
                do
                {
                    j = i;
                    if (k >= zzaOD.length)
                    {
                        break;
                    }
                    zzbiv zzbiv = zzaOD[k];
                    j = i;
                    if (zzbiv != null)
                    {
                        j = i + zzrx.zzc(1, zzbiv);
                    }
                    k++;
                    i = j;
                } while (true);
            }
        }
        i = j;
        if (name != null)
        {
            i = j + zzrx.zzn(2, name);
        }
        j = i;
        if (zzaOE != null)
        {
            j = i + zzrx.zzd(3, zzaOE.longValue());
        }
        i = j;
        if (zzaOF != null)
        {
            i = j + zzrx.zzd(4, zzaOF.longValue());
        }
        j = i;
        if (count != null)
        {
            j = i + zzrx.zzA(5, count.intValue());
        }
        return j;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        if (zzaOD != null && zzaOD.length > 0)
        {
            for (int i = 0; i < zzaOD.length; i++)
            {
                count count1 = zzaOD[i];
                if (count1 != null)
                {
                    zzrx1.zza(1, count1);
                }
            }

        }
        if (name != null)
        {
            zzrx1.zzb(2, name);
        }
        if (zzaOE != null)
        {
            zzrx1.zzb(3, zzaOE.longValue());
        }
        if (zzaOF != null)
        {
            zzrx1.zzb(4, zzaOF.longValue());
        }
        if (count != null)
        {
            zzrx1.zzy(5, count.intValue());
        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzu(zzrw1);
    }

    public zzu zzu(zzrw zzrw1)
        throws IOException
    {
        do
        {
            int i = zzrw1.zzFo();
            switch (i)
            {
            default:
                if (zzsh.zzb(zzrw1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int k = zzsh.zzc(zzrw1, 10);
                zzu azzu[];
                int j;
                if (zzaOD == null)
                {
                    j = 0;
                } else
                {
                    j = zzaOD.length;
                }
                azzu = new zzaOD[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaOD, 0, azzu, 0, j);
                    k = j;
                }
                for (; k < azzu.length - 1; k++)
                {
                    azzu[k] = new <init>();
                    zzrw1.zza(azzu[k]);
                    zzrw1.zzFo();
                }

                azzu[k] = new <init>();
                zzrw1.zza(azzu[k]);
                zzaOD = azzu;
                break;

            case 18: // '\022'
                name = zzrw1.readString();
                break;

            case 24: // '\030'
                zzaOE = Long.valueOf(zzrw1.zzFq());
                break;

            case 32: // ' '
                zzaOF = Long.valueOf(zzrw1.zzFq());
                break;

            case 40: // '('
                count = Integer.valueOf(zzrw1.zzFr());
                break;
            }
        } while (true);
    }

    public ()
    {
        zzAy();
    }
}
