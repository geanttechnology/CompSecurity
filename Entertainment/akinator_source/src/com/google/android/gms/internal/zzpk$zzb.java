// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzpk, zzsc, zzrx, 
//            zzrw, zzsh

public static final class zzAA extends zzse
{

    private static volatile Float zzaOG[];
    public String name;
    public Float zzaOB;
    public Long zzaOH;
    public String zzagS;

    public static zzAA[] zzAz()
    {
        if (zzaOG == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zzaOG == null)
                {
                    zzaOG = new zzaOG[0];
                }
            }
        }
        return zzaOG;
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
        if (!(obj instanceof zzaOG))
        {
            return false;
        }
        obj = (zzaOG)obj;
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
        int l = 0;
        int i1 = getClass().getName().hashCode();
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
        if (zzagS == null)
        {
            j = 0;
        } else
        {
            j = zzagS.hashCode();
        }
        if (zzaOH == null)
        {
            k = 0;
        } else
        {
            k = zzaOH.hashCode();
        }
        if (zzaOB != null)
        {
            l = zzaOB.hashCode();
        }
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + l;
    }

    public zzaOB zzAA()
    {
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
        if (name != null)
        {
            i = j + zzrx.zzn(1, name);
        }
        j = i;
        if (zzagS != null)
        {
            j = i + zzrx.zzn(2, zzagS);
        }
        i = j;
        if (zzaOH != null)
        {
            i = j + zzrx.zzd(3, zzaOH.longValue());
        }
        j = i;
        if (zzaOB != null)
        {
            j = i + zzrx.zzc(4, zzaOB.floatValue());
        }
        return j;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        if (name != null)
        {
            zzrx1.zzb(1, name);
        }
        if (zzagS != null)
        {
            zzrx1.zzb(2, zzagS);
        }
        if (zzaOH != null)
        {
            zzrx1.zzb(3, zzaOH.longValue());
        }
        if (zzaOB != null)
        {
            zzrx1.zzb(4, zzaOB.floatValue());
        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzv(zzrw1);
    }

    public zzv zzv(zzrw zzrw1)
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
                name = zzrw1.readString();
                break;

            case 18: // '\022'
                zzagS = zzrw1.readString();
                break;

            case 24: // '\030'
                zzaOH = Long.valueOf(zzrw1.zzFq());
                break;

            case 37: // '%'
                zzaOB = Float.valueOf(zzrw1.readFloat());
                break;
            }
        } while (true);
    }

    public ()
    {
        zzAA();
    }
}
