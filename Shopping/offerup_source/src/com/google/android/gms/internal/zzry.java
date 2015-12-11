// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzsa, zzsb, zzsc, 
//            zzrz, zzsh, zzrw, zzsg, 
//            zzrx

public abstract class zzry extends zzse
{

    protected zzsa zzbik;

    public zzry()
    {
    }

    public Object clone()
    {
        return zzFF();
    }

    protected int zzB()
    {
        int j = 0;
        int k;
        if (zzbik != null)
        {
            int i = 0;
            do
            {
                k = i;
                if (j >= zzbik.size())
                {
                    break;
                }
                i += zzbik.zzlS(j).zzB();
                j++;
            } while (true);
        } else
        {
            k = 0;
        }
        return k;
    }

    public zzry zzFF()
    {
        zzry zzry1 = (zzry)super.zzFG();
        zzsc.zza(this, zzry1);
        return zzry1;
    }

    public zzse zzFG()
    {
        return zzFF();
    }

    public final Object zza(zzrz zzrz1)
    {
        zzsb zzsb1;
        if (zzbik != null)
        {
            if ((zzsb1 = zzbik.zzlR(zzsh.zzlV(zzrz1.tag))) != null)
            {
                return zzsb1.zzb(zzrz1);
            }
        }
        return null;
    }

    public void zza(zzrx zzrx)
    {
        if (zzbik != null)
        {
            int i = 0;
            while (i < zzbik.size()) 
            {
                zzbik.zzlS(i).zza(zzrx);
                i++;
            }
        }
    }

    protected final boolean zza(zzrw zzrw1, int i)
    {
        int j = zzrw1.getPosition();
        if (!zzrw1.zzlA(i))
        {
            return false;
        }
        int k = zzsh.zzlV(i);
        zzsg zzsg1 = new zzsg(i, zzrw1.zzx(j, zzrw1.getPosition() - j));
        zzrw1 = null;
        Object obj;
        if (zzbik == null)
        {
            zzbik = new zzsa();
        } else
        {
            zzrw1 = zzbik.zzlR(k);
        }
        obj = zzrw1;
        if (zzrw1 == null)
        {
            obj = new zzsb();
            zzbik.zza(k, ((zzsb) (obj)));
        }
        ((zzsb) (obj)).zza(zzsg1);
        return true;
    }
}
