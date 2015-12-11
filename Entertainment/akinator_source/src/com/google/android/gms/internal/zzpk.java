// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzsc, zzrx, zzrw, 
//            zzsh

public interface zzpk
{
    public static final class zza extends zzse
    {

        private static volatile zza zzaOC[];
        public Integer count;
        public String name;
        public zzb zzaOD[];
        public Long zzaOE;
        public Long zzaOF;

        public static zza[] zzAx()
        {
            if (zzaOC == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzaOC == null)
                    {
                        zzaOC = new zza[0];
                    }
                }
            }
            return zzaOC;
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
            if (!(obj instanceof zza))
            {
                return false;
            }
            obj = (zza)obj;
            if (!zzsc.equals(zzaOD, ((zza) (obj)).zzaOD))
            {
                return false;
            }
            if (name == null)
            {
                if (((zza) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((zza) (obj)).name))
            {
                return false;
            }
            if (zzaOE == null)
            {
                if (((zza) (obj)).zzaOE != null)
                {
                    return false;
                }
            } else
            if (!zzaOE.equals(((zza) (obj)).zzaOE))
            {
                return false;
            }
            if (zzaOF == null)
            {
                if (((zza) (obj)).zzaOF != null)
                {
                    return false;
                }
            } else
            if (!zzaOF.equals(((zza) (obj)).zzaOF))
            {
                return false;
            }
            if (count != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zza) (obj)).count == null) goto _L1; else goto _L3
_L3:
            return false;
            if (count.equals(((zza) (obj)).count)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int l = 0;
            int i1 = getClass().getName().hashCode();
            int j1 = zzsc.hashCode(zzaOD);
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
            if (zzaOE == null)
            {
                j = 0;
            } else
            {
                j = zzaOE.hashCode();
            }
            if (zzaOF == null)
            {
                k = 0;
            } else
            {
                k = zzaOF.hashCode();
            }
            if (count != null)
            {
                l = count.hashCode();
            }
            return (k + (j + (i + ((i1 + 527) * 31 + j1) * 31) * 31) * 31) * 31 + l;
        }

        public zza zzAy()
        {
            zzaOD = zzb.zzAz();
            name = null;
            zzaOE = null;
            zzaOF = null;
            count = null;
            zzbiv = -1;
            return this;
        }

        protected int zzB()
        {
            int i = super.zzB();
            int j = i;
            if (zzaOD != null)
            {
                j = i;
                if (zzaOD.length > 0)
                {
                    int k = 0;
                    do
                    {
                        j = i;
                        if (k >= zzaOD.length)
                        {
                            break;
                        }
                        zzb zzb1 = zzaOD[k];
                        j = i;
                        if (zzb1 != null)
                        {
                            j = i + zzrx.zzc(1, zzb1);
                        }
                        k++;
                        i = j;
                    } while (true);
                }
            }
            i = j;
            if (name != null)
            {
                i = j + zzrx.zzn(2, name);
            }
            j = i;
            if (zzaOE != null)
            {
                j = i + zzrx.zzd(3, zzaOE.longValue());
            }
            i = j;
            if (zzaOF != null)
            {
                i = j + zzrx.zzd(4, zzaOF.longValue());
            }
            j = i;
            if (count != null)
            {
                j = i + zzrx.zzA(5, count.intValue());
            }
            return j;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            if (zzaOD != null && zzaOD.length > 0)
            {
                for (int i = 0; i < zzaOD.length; i++)
                {
                    zzb zzb1 = zzaOD[i];
                    if (zzb1 != null)
                    {
                        zzrx1.zza(1, zzb1);
                    }
                }

            }
            if (name != null)
            {
                zzrx1.zzb(2, name);
            }
            if (zzaOE != null)
            {
                zzrx1.zzb(3, zzaOE.longValue());
            }
            if (zzaOF != null)
            {
                zzrx1.zzb(4, zzaOF.longValue());
            }
            if (count != null)
            {
                zzrx1.zzy(5, count.intValue());
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzu(zzrw1);
        }

        public zza zzu(zzrw zzrw1)
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
                    zzb azzb[];
                    int j;
                    if (zzaOD == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaOD.length;
                    }
                    azzb = new zzb[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaOD, 0, azzb, 0, j);
                        k = j;
                    }
                    for (; k < azzb.length - 1; k++)
                    {
                        azzb[k] = new zzb();
                        zzrw1.zza(azzb[k]);
                        zzrw1.zzFo();
                    }

                    azzb[k] = new zzb();
                    zzrw1.zza(azzb[k]);
                    zzaOD = azzb;
                    break;

                case 18: // '\022'
                    name = zzrw1.readString();
                    break;

                case 24: // '\030'
                    zzaOE = Long.valueOf(zzrw1.zzFq());
                    break;

                case 32: // ' '
                    zzaOF = Long.valueOf(zzrw1.zzFq());
                    break;

                case 40: // '('
                    count = Integer.valueOf(zzrw1.zzFr());
                    break;
                }
            } while (true);
        }

        public zza()
        {
            zzAy();
        }
    }

    public static final class zzb extends zzse
    {

        private static volatile zzb zzaOG[];
        public String name;
        public Float zzaOB;
        public Long zzaOH;
        public String zzagS;

        public static zzb[] zzAz()
        {
            if (zzaOG == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzaOG == null)
                    {
                        zzaOG = new zzb[0];
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
            if (!(obj instanceof zzb))
            {
                return false;
            }
            obj = (zzb)obj;
            if (name == null)
            {
                if (((zzb) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((zzb) (obj)).name))
            {
                return false;
            }
            if (zzagS == null)
            {
                if (((zzb) (obj)).zzagS != null)
                {
                    return false;
                }
            } else
            if (!zzagS.equals(((zzb) (obj)).zzagS))
            {
                return false;
            }
            if (zzaOH == null)
            {
                if (((zzb) (obj)).zzaOH != null)
                {
                    return false;
                }
            } else
            if (!zzaOH.equals(((zzb) (obj)).zzaOH))
            {
                return false;
            }
            if (zzaOB != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zzb) (obj)).zzaOB == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaOB.equals(((zzb) (obj)).zzaOB)) goto _L1; else goto _L4
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

        public zzb zzAA()
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

        public zzb zzv(zzrw zzrw1)
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

        public zzb()
        {
            zzAA();
        }
    }

    public static final class zzc extends zzse
    {

        public zzd zzaOI[];

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (!(obj instanceof zzc))
                {
                    return false;
                }
                obj = (zzc)obj;
                if (!zzsc.equals(zzaOI, ((zzc) (obj)).zzaOI))
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

        public zzc zzAB()
        {
            zzaOI = zzd.zzAC();
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
                        zzd zzd1 = zzaOI[j];
                        k = i;
                        if (zzd1 != null)
                        {
                            k = i + zzrx.zzc(1, zzd1);
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
                    zzd zzd1 = zzaOI[i];
                    if (zzd1 != null)
                    {
                        zzrx1.zza(1, zzd1);
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

        public zzc zzw(zzrw zzrw1)
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
                    zzd azzd[];
                    int j;
                    if (zzaOI == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaOI.length;
                    }
                    azzd = new zzd[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaOI, 0, azzd, 0, j);
                        k = j;
                    }
                    for (; k < azzd.length - 1; k++)
                    {
                        azzd[k] = new zzd();
                        zzrw1.zza(azzd[k]);
                        zzrw1.zzFo();
                    }

                    azzd[k] = new zzd();
                    zzrw1.zza(azzd[k]);
                    zzaOI = azzd;
                    break;
                }
            } while (true);
        }

        public zzc()
        {
            zzAB();
        }
    }

    public static final class zzd extends zzse
    {

        private static volatile zzd zzaOJ[];
        public String zzaDC;
        public String zzaLP;
        public String zzaLQ;
        public Integer zzaOK;
        public zza zzaOL[];
        public zze zzaOM[];
        public Long zzaON;
        public Long zzaOO;
        public Long zzaOP;
        public Long zzaOQ;
        public Long zzaOR;
        public String zzaOS;
        public String zzaOT;
        public String zzaOU;
        public String zzaOV;
        public Integer zzaOW;
        public String zzaOX;
        public Long zzaOY;
        public Long zzaOZ;
        public String zzaPa;
        public Boolean zzaPb;
        public String zzaPc;
        public Long zzaPd;
        public Integer zzaPe;
        public String zzaPf;
        public Boolean zzaPg;

        public static zzd[] zzAC()
        {
            if (zzaOJ == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzaOJ == null)
                    {
                        zzaOJ = new zzd[0];
                    }
                }
            }
            return zzaOJ;
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
            if (!(obj instanceof zzd))
            {
                return false;
            }
            obj = (zzd)obj;
            if (zzaOK == null)
            {
                if (((zzd) (obj)).zzaOK != null)
                {
                    return false;
                }
            } else
            if (!zzaOK.equals(((zzd) (obj)).zzaOK))
            {
                return false;
            }
            if (!zzsc.equals(zzaOL, ((zzd) (obj)).zzaOL))
            {
                return false;
            }
            if (!zzsc.equals(zzaOM, ((zzd) (obj)).zzaOM))
            {
                return false;
            }
            if (zzaON == null)
            {
                if (((zzd) (obj)).zzaON != null)
                {
                    return false;
                }
            } else
            if (!zzaON.equals(((zzd) (obj)).zzaON))
            {
                return false;
            }
            if (zzaOO == null)
            {
                if (((zzd) (obj)).zzaOO != null)
                {
                    return false;
                }
            } else
            if (!zzaOO.equals(((zzd) (obj)).zzaOO))
            {
                return false;
            }
            if (zzaOP == null)
            {
                if (((zzd) (obj)).zzaOP != null)
                {
                    return false;
                }
            } else
            if (!zzaOP.equals(((zzd) (obj)).zzaOP))
            {
                return false;
            }
            if (zzaOQ == null)
            {
                if (((zzd) (obj)).zzaOQ != null)
                {
                    return false;
                }
            } else
            if (!zzaOQ.equals(((zzd) (obj)).zzaOQ))
            {
                return false;
            }
            if (zzaOR == null)
            {
                if (((zzd) (obj)).zzaOR != null)
                {
                    return false;
                }
            } else
            if (!zzaOR.equals(((zzd) (obj)).zzaOR))
            {
                return false;
            }
            if (zzaOS == null)
            {
                if (((zzd) (obj)).zzaOS != null)
                {
                    return false;
                }
            } else
            if (!zzaOS.equals(((zzd) (obj)).zzaOS))
            {
                return false;
            }
            if (zzaOT == null)
            {
                if (((zzd) (obj)).zzaOT != null)
                {
                    return false;
                }
            } else
            if (!zzaOT.equals(((zzd) (obj)).zzaOT))
            {
                return false;
            }
            if (zzaOU == null)
            {
                if (((zzd) (obj)).zzaOU != null)
                {
                    return false;
                }
            } else
            if (!zzaOU.equals(((zzd) (obj)).zzaOU))
            {
                return false;
            }
            if (zzaOV == null)
            {
                if (((zzd) (obj)).zzaOV != null)
                {
                    return false;
                }
            } else
            if (!zzaOV.equals(((zzd) (obj)).zzaOV))
            {
                return false;
            }
            if (zzaOW == null)
            {
                if (((zzd) (obj)).zzaOW != null)
                {
                    return false;
                }
            } else
            if (!zzaOW.equals(((zzd) (obj)).zzaOW))
            {
                return false;
            }
            if (zzaLQ == null)
            {
                if (((zzd) (obj)).zzaLQ != null)
                {
                    return false;
                }
            } else
            if (!zzaLQ.equals(((zzd) (obj)).zzaLQ))
            {
                return false;
            }
            if (zzaOX == null)
            {
                if (((zzd) (obj)).zzaOX != null)
                {
                    return false;
                }
            } else
            if (!zzaOX.equals(((zzd) (obj)).zzaOX))
            {
                return false;
            }
            if (zzaDC == null)
            {
                if (((zzd) (obj)).zzaDC != null)
                {
                    return false;
                }
            } else
            if (!zzaDC.equals(((zzd) (obj)).zzaDC))
            {
                return false;
            }
            if (zzaOY == null)
            {
                if (((zzd) (obj)).zzaOY != null)
                {
                    return false;
                }
            } else
            if (!zzaOY.equals(((zzd) (obj)).zzaOY))
            {
                return false;
            }
            if (zzaOZ == null)
            {
                if (((zzd) (obj)).zzaOZ != null)
                {
                    return false;
                }
            } else
            if (!zzaOZ.equals(((zzd) (obj)).zzaOZ))
            {
                return false;
            }
            if (zzaPa == null)
            {
                if (((zzd) (obj)).zzaPa != null)
                {
                    return false;
                }
            } else
            if (!zzaPa.equals(((zzd) (obj)).zzaPa))
            {
                return false;
            }
            if (zzaPb == null)
            {
                if (((zzd) (obj)).zzaPb != null)
                {
                    return false;
                }
            } else
            if (!zzaPb.equals(((zzd) (obj)).zzaPb))
            {
                return false;
            }
            if (zzaPc == null)
            {
                if (((zzd) (obj)).zzaPc != null)
                {
                    return false;
                }
            } else
            if (!zzaPc.equals(((zzd) (obj)).zzaPc))
            {
                return false;
            }
            if (zzaPd == null)
            {
                if (((zzd) (obj)).zzaPd != null)
                {
                    return false;
                }
            } else
            if (!zzaPd.equals(((zzd) (obj)).zzaPd))
            {
                return false;
            }
            if (zzaPe == null)
            {
                if (((zzd) (obj)).zzaPe != null)
                {
                    return false;
                }
            } else
            if (!zzaPe.equals(((zzd) (obj)).zzaPe))
            {
                return false;
            }
            if (zzaPf == null)
            {
                if (((zzd) (obj)).zzaPf != null)
                {
                    return false;
                }
            } else
            if (!zzaPf.equals(((zzd) (obj)).zzaPf))
            {
                return false;
            }
            if (zzaLP == null)
            {
                if (((zzd) (obj)).zzaLP != null)
                {
                    return false;
                }
            } else
            if (!zzaLP.equals(((zzd) (obj)).zzaLP))
            {
                return false;
            }
            if (zzaPg != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zzd) (obj)).zzaPg == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaPg.equals(((zzd) (obj)).zzaPg)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public int hashCode()
        {
            int l5 = 0;
            int i6 = getClass().getName().hashCode();
            int i;
            int j;
            int k;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            int k3;
            int l3;
            int i4;
            int j4;
            int k4;
            int l4;
            int i5;
            int j5;
            int k5;
            int j6;
            int k6;
            if (zzaOK == null)
            {
                i = 0;
            } else
            {
                i = zzaOK.hashCode();
            }
            j6 = zzsc.hashCode(zzaOL);
            k6 = zzsc.hashCode(zzaOM);
            if (zzaON == null)
            {
                j = 0;
            } else
            {
                j = zzaON.hashCode();
            }
            if (zzaOO == null)
            {
                k = 0;
            } else
            {
                k = zzaOO.hashCode();
            }
            if (zzaOP == null)
            {
                l = 0;
            } else
            {
                l = zzaOP.hashCode();
            }
            if (zzaOQ == null)
            {
                i1 = 0;
            } else
            {
                i1 = zzaOQ.hashCode();
            }
            if (zzaOR == null)
            {
                j1 = 0;
            } else
            {
                j1 = zzaOR.hashCode();
            }
            if (zzaOS == null)
            {
                k1 = 0;
            } else
            {
                k1 = zzaOS.hashCode();
            }
            if (zzaOT == null)
            {
                l1 = 0;
            } else
            {
                l1 = zzaOT.hashCode();
            }
            if (zzaOU == null)
            {
                i2 = 0;
            } else
            {
                i2 = zzaOU.hashCode();
            }
            if (zzaOV == null)
            {
                j2 = 0;
            } else
            {
                j2 = zzaOV.hashCode();
            }
            if (zzaOW == null)
            {
                k2 = 0;
            } else
            {
                k2 = zzaOW.hashCode();
            }
            if (zzaLQ == null)
            {
                l2 = 0;
            } else
            {
                l2 = zzaLQ.hashCode();
            }
            if (zzaOX == null)
            {
                i3 = 0;
            } else
            {
                i3 = zzaOX.hashCode();
            }
            if (zzaDC == null)
            {
                j3 = 0;
            } else
            {
                j3 = zzaDC.hashCode();
            }
            if (zzaOY == null)
            {
                k3 = 0;
            } else
            {
                k3 = zzaOY.hashCode();
            }
            if (zzaOZ == null)
            {
                l3 = 0;
            } else
            {
                l3 = zzaOZ.hashCode();
            }
            if (zzaPa == null)
            {
                i4 = 0;
            } else
            {
                i4 = zzaPa.hashCode();
            }
            if (zzaPb == null)
            {
                j4 = 0;
            } else
            {
                j4 = zzaPb.hashCode();
            }
            if (zzaPc == null)
            {
                k4 = 0;
            } else
            {
                k4 = zzaPc.hashCode();
            }
            if (zzaPd == null)
            {
                l4 = 0;
            } else
            {
                l4 = zzaPd.hashCode();
            }
            if (zzaPe == null)
            {
                i5 = 0;
            } else
            {
                i5 = zzaPe.hashCode();
            }
            if (zzaPf == null)
            {
                j5 = 0;
            } else
            {
                j5 = zzaPf.hashCode();
            }
            if (zzaLP == null)
            {
                k5 = 0;
            } else
            {
                k5 = zzaLP.hashCode();
            }
            if (zzaPg != null)
            {
                l5 = zzaPg.hashCode();
            }
            return (k5 + (j5 + (i5 + (l4 + (k4 + (j4 + (i4 + (l3 + (k3 + (j3 + (i3 + (l2 + (k2 + (j2 + (i2 + (l1 + (k1 + (j1 + (i1 + (l + (k + (j + (((i + (i6 + 527) * 31) * 31 + j6) * 31 + k6) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + l5;
        }

        public zzd zzAD()
        {
            zzaOK = null;
            zzaOL = zza.zzAx();
            zzaOM = zze.zzAE();
            zzaON = null;
            zzaOO = null;
            zzaOP = null;
            zzaOQ = null;
            zzaOR = null;
            zzaOS = null;
            zzaOT = null;
            zzaOU = null;
            zzaOV = null;
            zzaOW = null;
            zzaLQ = null;
            zzaOX = null;
            zzaDC = null;
            zzaOY = null;
            zzaOZ = null;
            zzaPa = null;
            zzaPb = null;
            zzaPc = null;
            zzaPd = null;
            zzaPe = null;
            zzaPf = null;
            zzaLP = null;
            zzaPg = null;
            zzbiv = -1;
            return this;
        }

        protected int zzB()
        {
            boolean flag = false;
            int i = super.zzB();
            int j = i;
            if (zzaOK != null)
            {
                j = i + zzrx.zzA(1, zzaOK.intValue());
            }
            i = j;
            if (zzaOL != null)
            {
                i = j;
                if (zzaOL.length > 0)
                {
                    i = j;
                    for (j = 0; j < zzaOL.length;)
                    {
                        zza zza1 = zzaOL[j];
                        int k = i;
                        if (zza1 != null)
                        {
                            k = i + zzrx.zzc(2, zza1);
                        }
                        j++;
                        i = k;
                    }

                }
            }
            j = i;
            if (zzaOM != null)
            {
                j = i;
                if (zzaOM.length > 0)
                {
                    int l = ((flag) ? 1 : 0);
                    do
                    {
                        j = i;
                        if (l >= zzaOM.length)
                        {
                            break;
                        }
                        zze zze1 = zzaOM[l];
                        j = i;
                        if (zze1 != null)
                        {
                            j = i + zzrx.zzc(3, zze1);
                        }
                        l++;
                        i = j;
                    } while (true);
                }
            }
            i = j;
            if (zzaON != null)
            {
                i = j + zzrx.zzd(4, zzaON.longValue());
            }
            j = i;
            if (zzaOO != null)
            {
                j = i + zzrx.zzd(5, zzaOO.longValue());
            }
            i = j;
            if (zzaOP != null)
            {
                i = j + zzrx.zzd(6, zzaOP.longValue());
            }
            j = i;
            if (zzaOR != null)
            {
                j = i + zzrx.zzd(7, zzaOR.longValue());
            }
            i = j;
            if (zzaOS != null)
            {
                i = j + zzrx.zzn(8, zzaOS);
            }
            j = i;
            if (zzaOT != null)
            {
                j = i + zzrx.zzn(9, zzaOT);
            }
            i = j;
            if (zzaOU != null)
            {
                i = j + zzrx.zzn(10, zzaOU);
            }
            j = i;
            if (zzaOV != null)
            {
                j = i + zzrx.zzn(11, zzaOV);
            }
            i = j;
            if (zzaOW != null)
            {
                i = j + zzrx.zzA(12, zzaOW.intValue());
            }
            j = i;
            if (zzaLQ != null)
            {
                j = i + zzrx.zzn(13, zzaLQ);
            }
            i = j;
            if (zzaOX != null)
            {
                i = j + zzrx.zzn(14, zzaOX);
            }
            j = i;
            if (zzaDC != null)
            {
                j = i + zzrx.zzn(16, zzaDC);
            }
            i = j;
            if (zzaOY != null)
            {
                i = j + zzrx.zzd(17, zzaOY.longValue());
            }
            j = i;
            if (zzaOZ != null)
            {
                j = i + zzrx.zzd(18, zzaOZ.longValue());
            }
            i = j;
            if (zzaPa != null)
            {
                i = j + zzrx.zzn(19, zzaPa);
            }
            j = i;
            if (zzaPb != null)
            {
                j = i + zzrx.zzc(20, zzaPb.booleanValue());
            }
            i = j;
            if (zzaPc != null)
            {
                i = j + zzrx.zzn(21, zzaPc);
            }
            j = i;
            if (zzaPd != null)
            {
                j = i + zzrx.zzd(22, zzaPd.longValue());
            }
            i = j;
            if (zzaPe != null)
            {
                i = j + zzrx.zzA(23, zzaPe.intValue());
            }
            j = i;
            if (zzaPf != null)
            {
                j = i + zzrx.zzn(24, zzaPf);
            }
            i = j;
            if (zzaLP != null)
            {
                i = j + zzrx.zzn(25, zzaLP);
            }
            j = i;
            if (zzaOQ != null)
            {
                j = i + zzrx.zzd(26, zzaOQ.longValue());
            }
            i = j;
            if (zzaPg != null)
            {
                i = j + zzrx.zzc(28, zzaPg.booleanValue());
            }
            return i;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            boolean flag = false;
            if (zzaOK != null)
            {
                zzrx1.zzy(1, zzaOK.intValue());
            }
            if (zzaOL != null && zzaOL.length > 0)
            {
                for (int i = 0; i < zzaOL.length; i++)
                {
                    zza zza1 = zzaOL[i];
                    if (zza1 != null)
                    {
                        zzrx1.zza(2, zza1);
                    }
                }

            }
            if (zzaOM != null && zzaOM.length > 0)
            {
                for (int j = ((flag) ? 1 : 0); j < zzaOM.length; j++)
                {
                    zze zze1 = zzaOM[j];
                    if (zze1 != null)
                    {
                        zzrx1.zza(3, zze1);
                    }
                }

            }
            if (zzaON != null)
            {
                zzrx1.zzb(4, zzaON.longValue());
            }
            if (zzaOO != null)
            {
                zzrx1.zzb(5, zzaOO.longValue());
            }
            if (zzaOP != null)
            {
                zzrx1.zzb(6, zzaOP.longValue());
            }
            if (zzaOR != null)
            {
                zzrx1.zzb(7, zzaOR.longValue());
            }
            if (zzaOS != null)
            {
                zzrx1.zzb(8, zzaOS);
            }
            if (zzaOT != null)
            {
                zzrx1.zzb(9, zzaOT);
            }
            if (zzaOU != null)
            {
                zzrx1.zzb(10, zzaOU);
            }
            if (zzaOV != null)
            {
                zzrx1.zzb(11, zzaOV);
            }
            if (zzaOW != null)
            {
                zzrx1.zzy(12, zzaOW.intValue());
            }
            if (zzaLQ != null)
            {
                zzrx1.zzb(13, zzaLQ);
            }
            if (zzaOX != null)
            {
                zzrx1.zzb(14, zzaOX);
            }
            if (zzaDC != null)
            {
                zzrx1.zzb(16, zzaDC);
            }
            if (zzaOY != null)
            {
                zzrx1.zzb(17, zzaOY.longValue());
            }
            if (zzaOZ != null)
            {
                zzrx1.zzb(18, zzaOZ.longValue());
            }
            if (zzaPa != null)
            {
                zzrx1.zzb(19, zzaPa);
            }
            if (zzaPb != null)
            {
                zzrx1.zzb(20, zzaPb.booleanValue());
            }
            if (zzaPc != null)
            {
                zzrx1.zzb(21, zzaPc);
            }
            if (zzaPd != null)
            {
                zzrx1.zzb(22, zzaPd.longValue());
            }
            if (zzaPe != null)
            {
                zzrx1.zzy(23, zzaPe.intValue());
            }
            if (zzaPf != null)
            {
                zzrx1.zzb(24, zzaPf);
            }
            if (zzaLP != null)
            {
                zzrx1.zzb(25, zzaLP);
            }
            if (zzaOQ != null)
            {
                zzrx1.zzb(26, zzaOQ.longValue());
            }
            if (zzaPg != null)
            {
                zzrx1.zzb(28, zzaPg.booleanValue());
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzx(zzrw1);
        }

        public zzd zzx(zzrw zzrw1)
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
                    zzaOK = Integer.valueOf(zzrw1.zzFr());
                    break;

                case 18: // '\022'
                    int l = zzsh.zzc(zzrw1, 18);
                    zza azza[];
                    int j;
                    if (zzaOL == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzaOL.length;
                    }
                    azza = new zza[l + j];
                    l = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzaOL, 0, azza, 0, j);
                        l = j;
                    }
                    for (; l < azza.length - 1; l++)
                    {
                        azza[l] = new zza();
                        zzrw1.zza(azza[l]);
                        zzrw1.zzFo();
                    }

                    azza[l] = new zza();
                    zzrw1.zza(azza[l]);
                    zzaOL = azza;
                    break;

                case 26: // '\032'
                    int i1 = zzsh.zzc(zzrw1, 26);
                    zze azze[];
                    int k;
                    if (zzaOM == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zzaOM.length;
                    }
                    azze = new zze[i1 + k];
                    i1 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zzaOM, 0, azze, 0, k);
                        i1 = k;
                    }
                    for (; i1 < azze.length - 1; i1++)
                    {
                        azze[i1] = new zze();
                        zzrw1.zza(azze[i1]);
                        zzrw1.zzFo();
                    }

                    azze[i1] = new zze();
                    zzrw1.zza(azze[i1]);
                    zzaOM = azze;
                    break;

                case 32: // ' '
                    zzaON = Long.valueOf(zzrw1.zzFq());
                    break;

                case 40: // '('
                    zzaOO = Long.valueOf(zzrw1.zzFq());
                    break;

                case 48: // '0'
                    zzaOP = Long.valueOf(zzrw1.zzFq());
                    break;

                case 56: // '8'
                    zzaOR = Long.valueOf(zzrw1.zzFq());
                    break;

                case 66: // 'B'
                    zzaOS = zzrw1.readString();
                    break;

                case 74: // 'J'
                    zzaOT = zzrw1.readString();
                    break;

                case 82: // 'R'
                    zzaOU = zzrw1.readString();
                    break;

                case 90: // 'Z'
                    zzaOV = zzrw1.readString();
                    break;

                case 96: // '`'
                    zzaOW = Integer.valueOf(zzrw1.zzFr());
                    break;

                case 106: // 'j'
                    zzaLQ = zzrw1.readString();
                    break;

                case 114: // 'r'
                    zzaOX = zzrw1.readString();
                    break;

                case 130: 
                    zzaDC = zzrw1.readString();
                    break;

                case 136: 
                    zzaOY = Long.valueOf(zzrw1.zzFq());
                    break;

                case 144: 
                    zzaOZ = Long.valueOf(zzrw1.zzFq());
                    break;

                case 154: 
                    zzaPa = zzrw1.readString();
                    break;

                case 160: 
                    zzaPb = Boolean.valueOf(zzrw1.zzFs());
                    break;

                case 170: 
                    zzaPc = zzrw1.readString();
                    break;

                case 176: 
                    zzaPd = Long.valueOf(zzrw1.zzFq());
                    break;

                case 184: 
                    zzaPe = Integer.valueOf(zzrw1.zzFr());
                    break;

                case 194: 
                    zzaPf = zzrw1.readString();
                    break;

                case 202: 
                    zzaLP = zzrw1.readString();
                    break;

                case 208: 
                    zzaOQ = Long.valueOf(zzrw1.zzFq());
                    break;

                case 224: 
                    zzaPg = Boolean.valueOf(zzrw1.zzFs());
                    break;
                }
            } while (true);
        }

        public zzd()
        {
            zzAD();
        }
    }

    public static final class zze extends zzse
    {

        private static volatile zze zzaPh[];
        public String name;
        public Float zzaOB;
        public Long zzaOH;
        public Long zzaPi;
        public String zzagS;

        public static zze[] zzAE()
        {
            if (zzaPh == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzaPh == null)
                    {
                        zzaPh = new zze[0];
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
            if (!(obj instanceof zze))
            {
                return false;
            }
            obj = (zze)obj;
            if (zzaPi == null)
            {
                if (((zze) (obj)).zzaPi != null)
                {
                    return false;
                }
            } else
            if (!zzaPi.equals(((zze) (obj)).zzaPi))
            {
                return false;
            }
            if (name == null)
            {
                if (((zze) (obj)).name != null)
                {
                    return false;
                }
            } else
            if (!name.equals(((zze) (obj)).name))
            {
                return false;
            }
            if (zzagS == null)
            {
                if (((zze) (obj)).zzagS != null)
                {
                    return false;
                }
            } else
            if (!zzagS.equals(((zze) (obj)).zzagS))
            {
                return false;
            }
            if (zzaOH == null)
            {
                if (((zze) (obj)).zzaOH != null)
                {
                    return false;
                }
            } else
            if (!zzaOH.equals(((zze) (obj)).zzaOH))
            {
                return false;
            }
            if (zzaOB != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((zze) (obj)).zzaOB == null) goto _L1; else goto _L3
_L3:
            return false;
            if (zzaOB.equals(((zze) (obj)).zzaOB)) goto _L1; else goto _L4
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

        public zze zzAF()
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

        public zze zzy(zzrw zzrw1)
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

        public zze()
        {
            zzAF();
        }
    }

}
