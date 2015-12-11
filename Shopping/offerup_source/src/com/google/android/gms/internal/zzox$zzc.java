// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzrw, zzsh, zzse

public final class zzwh extends zzry
{

    public String type;
    public zzbiv zzaDa[];

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzwh))
            {
                return false;
            }
            obj = (zzwh)obj;
            if (type == null)
            {
                if (((type) (obj)).type != null)
                {
                    return false;
                }
            } else
            if (!type.equals(((type) (obj)).type))
            {
                return false;
            }
            if (!zzsc.equals(zzaDa, ((zzaDa) (obj)).zzaDa))
            {
                return false;
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                if (((pty) (obj)).zzbik != null && !((zzbik) (obj)).zzbik.isEmpty())
                {
                    return false;
                }
            } else
            {
                return zzbik.equals(((ls) (obj)).zzbik);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        boolean flag = false;
        int k = getClass().getName().hashCode();
        int i;
        int j;
        int l;
        if (type == null)
        {
            i = 0;
        } else
        {
            i = type.hashCode();
        }
        l = zzsc.hashCode(zzaDa);
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
        return ((i + (k + 527) * 31) * 31 + l) * 31 + j;
    }

    protected final int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!type.equals(""))
        {
            i = j + zzrx.zzn(1, type);
        }
        j = i;
        if (zzaDa != null)
        {
            j = i;
            if (zzaDa.length > 0)
            {
                for (j = 0; j < zzaDa.length;)
                {
                    Code code = zzaDa[j];
                    int k = i;
                    if (code != null)
                    {
                        k = i + zzrx.zzc(2, code);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        return j;
    }

    public final void zza(zzrx zzrx1)
    {
        if (!type.equals(""))
        {
            zzrx1.zzb(1, type);
        }
        if (zzaDa != null && zzaDa.length > 0)
        {
            for (int i = 0; i < zzaDa.length; i++)
            {
                zzaDa zzada = zzaDa[i];
                if (zzada != null)
                {
                    zzrx1.zza(2, zzada);
                }
            }

        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzs(zzrw1);
    }

    public final zzs zzs(zzrw zzrw1)
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

            case 10: // '\n'
                type = zzrw1.readString();
                break;

            case 18: // '\022'
                int k = zzsh.zzc(zzrw1, 18);
                zzs azzs[];
                int j;
                if (zzaDa == null)
                {
                    j = 0;
                } else
                {
                    j = zzaDa.length;
                }
                azzs = new zzaDa[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaDa, 0, azzs, 0, j);
                    k = j;
                }
                for (; k < azzs.length - 1; k++)
                {
                    azzs[k] = new <init>();
                    zzrw1.zza(azzs[k]);
                    zzrw1.zzFo();
                }

                azzs[k] = new <init>();
                zzrw1.zza(azzs[k]);
                zzaDa = azzs;
                break;
            }
        } while (true);
    }

    public final zzaDa zzwh()
    {
        type = "";
        zzaDa = zzwf();
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public ()
    {
        zzwh();
    }
}
