// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzpk, zzsc, zzrx, 
//            zzrw, zzsh

public static final class zzAB extends zzse
{

    public zzaOI zzaOI[];

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzAB))
            {
                return false;
            }
            obj = (zzAB)obj;
            if (!zzsc.equals(zzaOI, ((zzaOI) (obj)).zzaOI))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (getClass().getName().hashCode() + 527) * 31 + zzsc.hashCode(zzaOI);
    }

    public zzaOI zzAB()
    {
        zzaOI = zzAC();
        zzbiv = -1;
        return this;
    }

    protected int zzB()
    {
        int i = super.zzB();
        int k = i;
        if (zzaOI != null)
        {
            k = i;
            if (zzaOI.length > 0)
            {
                int j = 0;
                do
                {
                    k = i;
                    if (j >= zzaOI.length)
                    {
                        break;
                    }
                    zzbiv zzbiv = zzaOI[j];
                    k = i;
                    if (zzbiv != null)
                    {
                        k = i + zzrx.zzc(1, zzbiv);
                    }
                    j++;
                    i = k;
                } while (true);
            }
        }
        return k;
    }

    public void zza(zzrx zzrx1)
        throws IOException
    {
        if (zzaOI != null && zzaOI.length > 0)
        {
            for (int i = 0; i < zzaOI.length; i++)
            {
                zzaOI zzaoi = zzaOI[i];
                if (zzaoi != null)
                {
                    zzrx1.zza(1, zzaoi);
                }
            }

        }
        super.zza(zzrx1);
    }

    public zzse zzb(zzrw zzrw1)
        throws IOException
    {
        return zzw(zzrw1);
    }

    public zzw zzw(zzrw zzrw1)
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
                zzw azzw[];
                int j;
                if (zzaOI == null)
                {
                    j = 0;
                } else
                {
                    j = zzaOI.length;
                }
                azzw = new zzaOI[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaOI, 0, azzw, 0, j);
                    k = j;
                }
                for (; k < azzw.length - 1; k++)
                {
                    azzw[k] = new <init>();
                    zzrw1.zza(azzw[k]);
                    zzrw1.zzFo();
                }

                azzw[k] = new <init>();
                zzrw1.zza(azzw[k]);
                zzaOI = azzw;
                break;
            }
        } while (true);
    }

    public ()
    {
        zzAB();
    }
}
