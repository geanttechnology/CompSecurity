// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrr, zznw, zzrv, zzrq, 
//            zzrp, zzrx

public static final class zzvs extends zzrr
{

    private static volatile zzbcl zzaAq[];
    public String name;
    public zzbcl zzaAr;

    public static zzvs[] zzvr()
    {
        if (zzaAq == null)
        {
            synchronized (zzrv.zzbck)
            {
                if (zzaAq == null)
                {
                    zzaAq = new zzaAq[0];
                }
            }
        }
        return zzaAq;
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
        if (!(obj instanceof zzaAq)) goto _L4; else goto _L3
_L3:
        obj = (zzaAq)obj;
        if (name != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((name) (obj)).name != null) goto _L4; else goto _L7
_L7:
        if (zzaAr != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        flag = flag1;
        if (((zzaAr) (obj)).zzaAr != null) goto _L4; else goto _L8
_L8:
        return zza(((zzrr) (obj)));
_L6:
        if (!name.equals(((name) (obj)).name))
        {
            return false;
        }
          goto _L7
        if (!zzaAr.equals(((equals) (obj)).zzaAr))
        {
            return false;
        }
          goto _L8
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (name == null)
        {
            i = 0;
        } else
        {
            i = name.hashCode();
        }
        if (zzaAr != null)
        {
            j = zzaAr.hashCode();
        }
        return ((i + 527) * 31 + j) * 31 + zzDk();
    }

    protected int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (!name.equals(""))
        {
            i = j + zzrq.zzl(1, name);
        }
        j = i;
        if (zzaAr != null)
        {
            j = i + zzrq.zzc(2, zzaAr);
        }
        return j;
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        if (!name.equals(""))
        {
            zzrq1.zzb(1, name);
        }
        if (zzaAr != null)
        {
            zzrq1.zza(2, zzaAr);
        }
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzr(zzrp1);
    }

    public zzr zzr(zzrp zzrp1)
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
                name = zzrp1.readString();
                break;

            case 18: // '\022'
                if (zzaAr == null)
                {
                    zzaAr = new <init>();
                }
                zzrp1.zza(zzaAr);
                break;
            }
        } while (true);
    }

    public zzaAr zzvs()
    {
        name = "";
        zzaAr = null;
        zzbca = null;
        zzbcl = -1;
        return this;
    }

    public ()
    {
        zzvs();
    }
}
