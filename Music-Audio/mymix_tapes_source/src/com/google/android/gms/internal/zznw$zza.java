// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrr, zznw, zzrv, zzrq, 
//            zzrp, zzsa, zzrx

public static final class zzvo extends zzrr
{
    public static final class zza extends zzrr
    {

        private static volatile zza zzaAn[];
        public int viewId;
        public String zzaAo;
        public String zzaAp;

        public static zza[] zzvp()
        {
            if (zzaAn == null)
            {
                synchronized (zzrv.zzbck)
                {
                    if (zzaAn == null)
                    {
                        zzaAn = new zza[0];
                    }
                }
            }
            return zzaAn;
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
            if (!(obj instanceof zza)) goto _L4; else goto _L3
_L3:
            obj = (zza)obj;
            if (zzaAo != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zza) (obj)).zzaAo != null) goto _L4; else goto _L7
_L7:
            if (zzaAp != null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            flag = flag1;
            if (((zza) (obj)).zzaAp != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (viewId == ((zza) (obj)).viewId)
            {
                return zza(((zzrr) (obj)));
            }
              goto _L4
_L6:
            if (!zzaAo.equals(((zza) (obj)).zzaAo))
            {
                return false;
            }
              goto _L7
            if (!zzaAp.equals(((zza) (obj)).zzaAp))
            {
                return false;
            }
              goto _L8
        }

        public int hashCode()
        {
            int j = 0;
            int i;
            if (zzaAo == null)
            {
                i = 0;
            } else
            {
                i = zzaAo.hashCode();
            }
            if (zzaAp != null)
            {
                j = zzaAp.hashCode();
            }
            return (((i + 527) * 31 + j) * 31 + viewId) * 31 + zzDk();
        }

        protected int zzB()
        {
            int j = super.zzB();
            int i = j;
            if (!zzaAo.equals(""))
            {
                i = j + zzrq.zzl(1, zzaAo);
            }
            j = i;
            if (!zzaAp.equals(""))
            {
                j = i + zzrq.zzl(2, zzaAp);
            }
            i = j;
            if (viewId != 0)
            {
                i = j + zzrq.zzB(3, viewId);
            }
            return i;
        }

        public void zza(zzrq zzrq1)
            throws IOException
        {
            if (!zzaAo.equals(""))
            {
                zzrq1.zzb(1, zzaAo);
            }
            if (!zzaAp.equals(""))
            {
                zzrq1.zzb(2, zzaAp);
            }
            if (viewId != 0)
            {
                zzrq1.zzz(3, viewId);
            }
            super.zza(zzrq1);
        }

        public zzrx zzb(zzrp zzrp1)
            throws IOException
        {
            return zzq(zzrp1);
        }

        public zza zzq(zzrp zzrp1)
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
                    zzaAo = zzrp1.readString();
                    break;

                case 18: // '\022'
                    zzaAp = zzrp1.readString();
                    break;

                case 24: // '\030'
                    viewId = zzrp1.zzCW();
                    break;
                }
            } while (true);
        }

        public zza zzvq()
        {
            zzaAo = "";
            zzaAp = "";
            viewId = 0;
            zzbca = null;
            zzbcl = -1;
            return this;
        }

        public zza()
        {
            zzvq();
        }
    }


    public zza zzaAm[];

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof zza)
            {
                obj = (zza)obj;
                flag = flag1;
                if (zzrv.equals(zzaAm, ((zzaAm) (obj)).zzaAm))
                {
                    return zza(((zzrr) (obj)));
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return (zzrv.hashCode(zzaAm) + 527) * 31 + zzDk();
    }

    protected int zzB()
    {
        int i = super.zzB();
        int k = i;
        if (zzaAm != null)
        {
            k = i;
            if (zzaAm.length > 0)
            {
                int j = 0;
                do
                {
                    k = i;
                    if (j >= zzaAm.length)
                    {
                        break;
                    }
                    zza zza1 = zzaAm[j];
                    k = i;
                    if (zza1 != null)
                    {
                        k = i + zzrq.zzc(1, zza1);
                    }
                    j++;
                    i = k;
                } while (true);
            }
        }
        return k;
    }

    public void zza(zzrq zzrq1)
        throws IOException
    {
        if (zzaAm != null && zzaAm.length > 0)
        {
            for (int i = 0; i < zzaAm.length; i++)
            {
                zza zza1 = zzaAm[i];
                if (zza1 != null)
                {
                    zzrq1.zza(1, zza1);
                }
            }

        }
        super.zza(zzrq1);
    }

    public zzrx zzb(zzrp zzrp1)
        throws IOException
    {
        return zzp(zzrp1);
    }

    public zzp zzp(zzrp zzrp1)
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
                int k = zzsa.zzb(zzrp1, 10);
                zza azza[];
                int j;
                if (zzaAm == null)
                {
                    j = 0;
                } else
                {
                    j = zzaAm.length;
                }
                azza = new zza[k + j];
                k = j;
                if (j != 0)
                {
                    System.arraycopy(zzaAm, 0, azza, 0, j);
                    k = j;
                }
                for (; k < azza.length - 1; k++)
                {
                    azza[k] = new zza();
                    zzrp1.zza(azza[k]);
                    zzrp1.zzCT();
                }

                azza[k] = new zza();
                zzrp1.zza(azza[k]);
                zzaAm = azza;
                break;
            }
        } while (true);
    }

    public zzaAm zzvo()
    {
        zzaAm = zza.zzvp();
        zzbca = null;
        zzbcl = -1;
        return this;
    }

    public zza.zzvq()
    {
        zzvo();
    }
}
