// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzpk, zzsc, zzrx, 
//            zzrw, zzsh

public static final class zzAF extends zzse
{

    private static volatile Float zzaPh[];
    public String name;
    public Float zzaOB;
    public Long zzaOH;
    public Long zzaPi;
    public String zzagS;

    public static zzAF[] zzAE()
    {
        if (zzaPh == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzaPh == null)
                {
                    zzaPh = new zzaPh[0];
                }
            }
        }
        return zzaPh;
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
        if (!(obj instanceof zzaPh))
        {
            return false;
        }
        obj = (zzaPh)obj;
        if (zzaPi == null)
        {
            if (((zzaPi) (obj)).zzaPi != null)
            {
                return false;
            }
        } else
        if (!zzaPi.equals(((zzaPi) (obj)).zzaPi))
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
        if (zzagS == null)
        {
            if (((zzagS) (obj)).zzagS != null)
            {
                return false;
            }
        } else
        if (!zzagS.equals(((zzagS) (obj)).zzagS))
        {
            return false;
        }
        if (zzaOH == null)
        {
            if (((zzaOH) (obj)).zzaOH != null)
            {
                return false;
            }
        } else
        if (!zzaOH.equals(((zzaOH) (obj)).zzaOH))
        {
            return false;
        }
        if (zzaOB != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((zzaOB) (obj)).zzaOB == null) goto _L1; else goto _L3
_L3:
        return false;
        if (zzaOB.equals(((zzaOB) (obj)).zzaOB)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int i1 = 0;
        int j1 = getClass().getName().hashCode();
        int i;
        int j;
        int k;
        int l;
        if (zzaPi == null)
        {
            i = 0;
        } else
        {
            i = zzaPi.hashCode();
        }
        if (name == null)
        {
            j = 0;
        } else
        {
            j = name.hashCode();
        }
        if (zzagS == null)
        {
            k = 0;
        } else
        {
            k = zzagS.hashCode();
        }
        if (zzaOH == null)
        {
            l = 0;
        } else
        {
            l = zzaOH.hashCode();
        }
        if (zzaOB != null)
        {
            i1 = zzaOB.hashCode();
        }
        return (l + (k + (j + (i + (j1 + 527) * 31) * 31) * 31) * 31) * 31 + i1;
    }

    public zzaOB zzAF()
    {
        zzaPi = null;
        name = null;
        zzagS = null;
        zzaOH = null;
        zzaOB = null;
        zzbiv = -1;
        return this;
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (zzaPi != null)
        {
            i = j + zzrx.zzd(1, zzaPi.longValue());
        }
        j = i;
        if (name != null)
        {
            j = i + zzrx.zzn(2, name);
        }
        i = j;
        if (zzagS != null)
        {
            i = j + zzrx.zzn(3, zzagS);
        }
        j = i;
        if (zzaOH != null)
        {
            j = i + zzrx.zzd(4, zzaOH.longValue());
        }
        i = j;
        if (zzaOB != null)
        {
            i = j + zzrx.zzc(5, zzaOB.floatValue());
        }
        return i;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        if (zzaPi != null)
        {
            zzrx1.zzb(1, zzaPi.longValue());
        }
        if (name != null)
        {
            zzrx1.zzb(2, name);
        }
        if (zzagS != null)
        {
            zzrx1.zzb(3, zzagS);
        }
        if (zzaOH != null)
        {
            zzrx1.zzb(4, zzaOH.longValue());
        }
        if (zzaOB != null)
        {
            zzrx1.zzb(5, zzaOB.floatValue());
        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzy(zzrw1);
    }

    public zzy zzy(zzrw zzrw1)
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

            case 8: // '\b'
                zzaPi = Long.valueOf(zzrw1.zzFq());
                break;

            case 18: // '\022'
                name = zzrw1.readString();
                break;

            case 26: // '\032'
                zzagS = zzrw1.readString();
                break;

            case 32: // ' '
                zzaOH = Long.valueOf(zzrw1.zzFq());
                break;

            case 45: // '-'
                zzaOB = Float.valueOf(zzrw1.readFloat());
                break;
            }
        } while (true);
    }

    public ()
    {
        zzAF();
    }
}
