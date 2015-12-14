// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzrr, zzrv, zzrq, zzrp, 
//            zzsa, zzrx

public interface zznw
{
    public static final class zza extends zzrr
    {

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
                    if (zzrv.equals(zzaAm, ((zza) (obj)).zzaAm))
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

        public zza zzp(zzrp zzrp1)
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

        public zza zzvo()
        {
            zzaAm = zza.zzvp();
            zzbca = null;
            zzbcl = -1;
            return this;
        }

        public zza()
        {
            zzvo();
        }
    }

    public static final class zza.zza extends zzrr
    {

        private static volatile zza.zza zzaAn[];
        public int viewId;
        public String zzaAo;
        public String zzaAp;

        public static zza.zza[] zzvp()
        {
            if (zzaAn == null)
            {
                synchronized (zzrv.zzbck)
                {
                    if (zzaAn == null)
                    {
                        zzaAn = new zza.zza[0];
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
            if (!(obj instanceof zza.zza)) goto _L4; else goto _L3
_L3:
            obj = (zza.zza)obj;
            if (zzaAo != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zza.zza) (obj)).zzaAo != null) goto _L4; else goto _L7
_L7:
            if (zzaAp != null)
            {
                break MISSING_BLOCK_LABEL_92;
            }
            flag = flag1;
            if (((zza.zza) (obj)).zzaAp != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (viewId == ((zza.zza) (obj)).viewId)
            {
                return zza(((zzrr) (obj)));
            }
              goto _L4
_L6:
            if (!zzaAo.equals(((zza.zza) (obj)).zzaAo))
            {
                return false;
            }
              goto _L7
            if (!zzaAp.equals(((zza.zza) (obj)).zzaAp))
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

        public zza.zza zzq(zzrp zzrp1)
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

        public zza.zza zzvq()
        {
            zzaAo = "";
            zzaAp = "";
            viewId = 0;
            zzbca = null;
            zzbcl = -1;
            return this;
        }

        public zza.zza()
        {
            zzvq();
        }
    }

    public static final class zzb extends zzrr
    {

        private static volatile zzb zzaAq[];
        public String name;
        public zzd zzaAr;

        public static zzb[] zzvr()
        {
            if (zzaAq == null)
            {
                synchronized (zzrv.zzbck)
                {
                    if (zzaAq == null)
                    {
                        zzaAq = new zzb[0];
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
            if (!(obj instanceof zzb)) goto _L4; else goto _L3
_L3:
            obj = (zzb)obj;
            if (name != null) goto _L6; else goto _L5
_L5:
            flag = flag1;
            if (((zzb) (obj)).name != null) goto _L4; else goto _L7
_L7:
            if (zzaAr != null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            flag = flag1;
            if (((zzb) (obj)).zzaAr != null) goto _L4; else goto _L8
_L8:
            return zza(((zzrr) (obj)));
_L6:
            if (!name.equals(((zzb) (obj)).name))
            {
                return false;
            }
              goto _L7
            if (!zzaAr.equals(((zzb) (obj)).zzaAr))
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

        public zzb zzr(zzrp zzrp1)
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
                        zzaAr = new zzd();
                    }
                    zzrp1.zza(zzaAr);
                    break;
                }
            } while (true);
        }

        public zzb zzvs()
        {
            name = "";
            zzaAr = null;
            zzbca = null;
            zzbcl = -1;
            return this;
        }

        public zzb()
        {
            zzvs();
        }
    }

    public static final class zzc extends zzrr
    {

        public String type;
        public zzb zzaAs[];

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
            if (!(obj instanceof zzc))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = (zzc)obj;
            if (type != null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (((zzc) (obj)).type != null)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            flag = flag1;
            if (zzrv.equals(zzaAs, ((zzc) (obj)).zzaAs))
            {
                return zza(((zzrr) (obj)));
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (!type.equals(((zzc) (obj)).type))
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
                        zzb zzb1 = zzaAs[j];
                        int k = i;
                        if (zzb1 != null)
                        {
                            k = i + zzrq.zzc(2, zzb1);
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
                    zzb zzb1 = zzaAs[i];
                    if (zzb1 != null)
                    {
                        zzrq1.zza(2, zzb1);
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

        public zzc zzs(zzrp zzrp1)
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
                    zzb azzb[];
                    int j;
                    if (zzaAs == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaAs.length;
                    }
                    azzb = new zzb[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaAs, 0, azzb, 0, j);
                        k = j;
                    }
                    for (; k < azzb.length - 1; k++)
                    {
                        azzb[k] = new zzb();
                        zzrp1.zza(azzb[k]);
                        zzrp1.zzCT();
                    }

                    azzb[k] = new zzb();
                    zzrp1.zza(azzb[k]);
                    zzaAs = azzb;
                    break;
                }
            } while (true);
        }

        public zzc zzvt()
        {
            type = "";
            zzaAs = zzb.zzvr();
            zzbca = null;
            zzbcl = -1;
            return this;
        }

        public zzc()
        {
            zzvt();
        }
    }

    public static final class zzd extends zzrr
    {

        public boolean zzaAt;
        public long zzaAu;
        public double zzaAv;
        public zzc zzaAw;
        public String zzaeO;

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
            if (!(obj instanceof zzd)) goto _L4; else goto _L3
_L3:
            obj = (zzd)obj;
            flag = flag1;
            if (zzaAt != ((zzd) (obj)).zzaAt) goto _L4; else goto _L5
_L5:
            if (zzaeO != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zzd) (obj)).zzaeO != null) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (zzaAu != ((zzd) (obj)).zzaAu) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (Double.doubleToLongBits(zzaAv) != Double.doubleToLongBits(((zzd) (obj)).zzaAv)) goto _L4; else goto _L10
_L10:
            if (zzaAw != null)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            flag = flag1;
            if (((zzd) (obj)).zzaAw != null) goto _L4; else goto _L11
_L11:
            return zza(((zzrr) (obj)));
_L7:
            if (!zzaeO.equals(((zzd) (obj)).zzaeO))
            {
                return false;
            }
              goto _L8
            if (!zzaAw.equals(((zzd) (obj)).zzaAw))
            {
                return false;
            }
              goto _L11
        }

        public int hashCode()
        {
            int j = 0;
            char c;
            int i;
            int k;
            int l;
            long l1;
            if (zzaAt)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            if (zzaeO == null)
            {
                i = 0;
            } else
            {
                i = zzaeO.hashCode();
            }
            k = (int)(zzaAu ^ zzaAu >>> 32);
            l1 = Double.doubleToLongBits(zzaAv);
            l = (int)(l1 ^ l1 >>> 32);
            if (zzaAw != null)
            {
                j = zzaAw.hashCode();
            }
            return ((((i + (c + 527) * 31) * 31 + k) * 31 + l) * 31 + j) * 31 + zzDk();
        }

        protected int zzB()
        {
            int j = super.zzB();
            int i = j;
            if (zzaAt)
            {
                i = j + zzrq.zzc(1, zzaAt);
            }
            j = i;
            if (!zzaeO.equals(""))
            {
                j = i + zzrq.zzl(2, zzaeO);
            }
            i = j;
            if (zzaAu != 0L)
            {
                i = j + zzrq.zzd(3, zzaAu);
            }
            j = i;
            if (Double.doubleToLongBits(zzaAv) != Double.doubleToLongBits(0.0D))
            {
                j = i + zzrq.zzb(4, zzaAv);
            }
            i = j;
            if (zzaAw != null)
            {
                i = j + zzrq.zzc(5, zzaAw);
            }
            return i;
        }

        public void zza(zzrq zzrq1)
            throws IOException
        {
            if (zzaAt)
            {
                zzrq1.zzb(1, zzaAt);
            }
            if (!zzaeO.equals(""))
            {
                zzrq1.zzb(2, zzaeO);
            }
            if (zzaAu != 0L)
            {
                zzrq1.zzb(3, zzaAu);
            }
            if (Double.doubleToLongBits(zzaAv) != Double.doubleToLongBits(0.0D))
            {
                zzrq1.zza(4, zzaAv);
            }
            if (zzaAw != null)
            {
                zzrq1.zza(5, zzaAw);
            }
            super.zza(zzrq1);
        }

        public zzrx zzb(zzrp zzrp1)
            throws IOException
        {
            return zzt(zzrp1);
        }

        public zzd zzt(zzrp zzrp1)
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

                case 8: // '\b'
                    zzaAt = zzrp1.zzCX();
                    break;

                case 18: // '\022'
                    zzaeO = zzrp1.readString();
                    break;

                case 24: // '\030'
                    zzaAu = zzrp1.zzCV();
                    break;

                case 33: // '!'
                    zzaAv = zzrp1.readDouble();
                    break;

                case 42: // '*'
                    if (zzaAw == null)
                    {
                        zzaAw = new zzc();
                    }
                    zzrp1.zza(zzaAw);
                    break;
                }
            } while (true);
        }

        public zzd zzvu()
        {
            zzaAt = false;
            zzaeO = "";
            zzaAu = 0L;
            zzaAv = 0.0D;
            zzaAw = null;
            zzbca = null;
            zzbcl = -1;
            return this;
        }

        public zzd()
        {
            zzvu();
        }
    }

}
