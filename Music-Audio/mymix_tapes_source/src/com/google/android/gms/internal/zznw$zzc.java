// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrr, zznw, zzrv, zzrq, 
//            zzrp, zzsa, zzrx

public static final class zzvt extends zzrr
{

    public String type;
    public zzbcl zzaAs[];

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
        if (!(obj instanceof zzvt))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (zzvt)obj;
        if (type != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((type) (obj)).type != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        flag = flag1;
        if (zzrv.equals(zzaAs, ((zzaAs) (obj)).zzaAs))
        {
            return zza(((zzrr) (obj)));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!type.equals(((type) (obj)).type))
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
        if (type == null)
        {
            i = 0;
        } else
        {
            i = type.hashCode();
        }
        return ((i + 527) * 31 + zzrv.hashCode(zzaAs)) * 31 + zzDk();
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!type.equals(""))
        {
            i = j + zzrq.zzl(1, type);
        }
        j = i;
        if (zzaAs != null)
        {
            j = i;
            if (zzaAs.length > 0)
            {
                for (j = 0; j < zzaAs.length;)
                {
                    zzDk zzdk = zzaAs[j];
                    int k = i;
                    if (zzdk != null)
                    {
                        k = i + zzrq.zzc(2, zzdk);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        return j;
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        if (!type.equals(""))
        {
            zzrq1.zzb(1, type);
        }
        if (zzaAs != null && zzaAs.length > 0)
        {
            for (int i = 0; i < zzaAs.length; i++)
            {
                zzaAs zzaas = zzaAs[i];
                if (zzaas != null)
                {
                    zzrq1.zza(2, zzaas);
                }
            }

        }
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzs(zzrp1);
    }

    public zzs zzs(zzrp zzrp1)
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

            case 10: // '\n'
                type = zzrp1.readString();
                break;

            case 18: // '\022'
                int k = zzsa.zzb(zzrp1, 18);
                zzs azzs[];
                int j;
                if (zzaAs == null)
                {
                    j = 0;
                } else
                {
                    j = zzaAs.length;
                }
                azzs = new zzaAs[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaAs, 0, azzs, 0, j);
                    k = j;
                }
                for (; k < azzs.length - 1; k++)
                {
                    azzs[k] = new <init>();
                    zzrp1.zza(azzs[k]);
                    zzrp1.zzCT();
                }

                azzs[k] = new <init>();
                zzrp1.zza(azzs[k]);
                zzaAs = azzs;
                break;
            }
        } while (true);
    }

    public zzaAs zzvt()
    {
        type = "";
        zzaAs = zzvr();
        zzbca = null;
        zzbcl = -1;
        return this;
    }

    public ()
    {
        zzvt();
    }
}
