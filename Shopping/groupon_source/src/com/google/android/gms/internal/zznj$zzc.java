// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrh, zznj, zzrl, zzrg

public static final class zztZ extends zzrh
{

    public String type;
    public zzaWf zzawq[];

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
        if (!(obj instanceof zztZ))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (zztZ)obj;
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
        if (zzrl.equals(zzawq, ((zzawq) (obj)).zzawq))
        {
            return zza(((zzrh) (obj)));
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
        return ((i + 527) * 31 + zzrl.hashCode(zzawq)) * 31 + zzBI();
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!type.equals(""))
        {
            i = j + zzrg.zzk(1, type);
        }
        j = i;
        if (zzawq != null)
        {
            j = i;
            if (zzawq.length > 0)
            {
                for (j = 0; j < zzawq.length;)
                {
                    zzBI zzbi = zzawq[j];
                    int k = i;
                    if (zzbi != null)
                    {
                        k = i + zzrg.zzc(2, zzbi);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        return j;
    }

    public void zza(zzrg zzrg1)
        throws IOException
    {
        if (!type.equals(""))
        {
            zzrg1.zzb(1, type);
        }
        if (zzawq != null && zzawq.length > 0)
        {
            for (int i = 0; i < zzawq.length; i++)
            {
                zzawq zzawq1 = zzawq[i];
                if (zzawq1 != null)
                {
                    zzrg1.zza(2, zzawq1);
                }
            }

        }
        super.zza(zzrg1);
    }

    public zzawq zztZ()
    {
        type = "";
        zzawq = zztX();
        zzaVU = null;
        zzaWf = -1;
        return this;
    }

    public ()
    {
        zztZ();
    }
}
