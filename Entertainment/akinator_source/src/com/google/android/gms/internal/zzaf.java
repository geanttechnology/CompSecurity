// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsa, zzrx, zzrw, 
//            zzse, zzsc, zzsh, zzsd

public interface zzaf
{
    public static final class zza extends zzry
    {

        public int level;
        public int zzhN;
        public int zzhO;

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
            flag = flag1;
            if (level != ((zza) (obj)).level) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (zzhN != ((zza) (obj)).zzhN) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (zzhO != ((zza) (obj)).zzhO) goto _L4; else goto _L7
_L7:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_102;
            }
            if (((zza) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zza) (obj)).zzbik.isEmpty()) goto _L4; else goto _L8
_L8:
            return true;
            return zzbik.equals(((zza) (obj)).zzbik);
        }

        public int hashCode()
        {
            int j = getClass().getName().hashCode();
            int k = level;
            int l = zzhN;
            int i1 = zzhO;
            int i;
            if (zzbik == null || zzbik.isEmpty())
            {
                i = 0;
            } else
            {
                i = zzbik.hashCode();
            }
            return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
        }

        public zza zzA()
        {
            level = 1;
            zzhN = 0;
            zzhO = 0;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        protected int zzB()
        {
            int j = super.zzB();
            int i = j;
            if (level != 1)
            {
                i = j + zzrx.zzA(1, level);
            }
            j = i;
            if (zzhN != 0)
            {
                j = i + zzrx.zzA(2, zzhN);
            }
            i = j;
            if (zzhO != 0)
            {
                i = j + zzrx.zzA(3, zzhO);
            }
            return i;
        }

        public zza zza(zzrw zzrw1)
            throws IOException
        {
_L6:
            int i = zzrw1.zzFo();
            i;
            JVM INSTR lookupswitch 4: default 48
        //                       0: 57
        //                       8: 59
        //                       16: 103
        //                       24: 114;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            if (zza(zzrw1, i)) goto _L6; else goto _L2
_L2:
            return this;
_L3:
            int j = zzrw1.zzFr();
            switch (j)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                level = j;
                break;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            zzhN = zzrw1.zzFr();
            continue; /* Loop/switch isn't completed */
_L5:
            zzhO = zzrw1.zzFr();
            if (true) goto _L6; else goto _L7
_L7:
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            if (level != 1)
            {
                zzrx1.zzy(1, level);
            }
            if (zzhN != 0)
            {
                zzrx1.zzy(2, zzhN);
            }
            if (zzhO != 0)
            {
                zzrx1.zzy(3, zzhO);
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zza(zzrw1);
        }

        public zza()
        {
            zzA();
        }
    }

    public static final class zzb extends zzry
    {

        private static volatile zzb zzhP[];
        public int name;
        public int zzhQ[];
        public int zzhR;
        public boolean zzhS;
        public boolean zzhT;

        public static zzb[] zzC()
        {
            if (zzhP == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzhP == null)
                    {
                        zzhP = new zzb[0];
                    }
                }
            }
            return zzhP;
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
            flag = flag1;
            if (!zzsc.equals(zzhQ, ((zzb) (obj)).zzhQ)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (zzhR != ((zzb) (obj)).zzhR) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (name != ((zzb) (obj)).name) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (zzhS != ((zzb) (obj)).zzhS) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (zzhT != ((zzb) (obj)).zzhT) goto _L4; else goto _L9
_L9:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_131;
            }
            if (((zzb) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zzb) (obj)).zzbik.isEmpty()) goto _L4; else goto _L10
_L10:
            return true;
            return zzbik.equals(((zzb) (obj)).zzbik);
        }

        public int hashCode()
        {
            char c1 = '\u04CF';
            int j = getClass().getName().hashCode();
            int k = zzsc.hashCode(zzhQ);
            int l = zzhR;
            int i1 = name;
            char c;
            int i;
            if (zzhS)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            if (!zzhT)
            {
                c1 = '\u04D5';
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                i = 0;
            } else
            {
                i = zzbik.hashCode();
            }
            return i + ((c + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31) * 31 + c1) * 31;
        }

        protected int zzB()
        {
            int j = 0;
            int k = super.zzB();
            int i = k;
            if (zzhT)
            {
                i = k + zzrx.zzc(1, zzhT);
            }
            k = zzrx.zzA(2, zzhR) + i;
            if (zzhQ != null && zzhQ.length > 0)
            {
                for (i = 0; i < zzhQ.length; i++)
                {
                    j += zzrx.zzlJ(zzhQ[i]);
                }

                j = k + j + zzhQ.length * 1;
            } else
            {
                j = k;
            }
            i = j;
            if (name != 0)
            {
                i = j + zzrx.zzA(4, name);
            }
            j = i;
            if (zzhS)
            {
                j = i + zzrx.zzc(6, zzhS);
            }
            return j;
        }

        public zzb zzD()
        {
            zzhQ = zzsh.zzbix;
            zzhR = 0;
            name = 0;
            zzhS = false;
            zzhT = false;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            if (zzhT)
            {
                zzrx1.zzb(1, zzhT);
            }
            zzrx1.zzy(2, zzhR);
            if (zzhQ != null && zzhQ.length > 0)
            {
                for (int i = 0; i < zzhQ.length; i++)
                {
                    zzrx1.zzy(3, zzhQ[i]);
                }

            }
            if (name != 0)
            {
                zzrx1.zzy(4, name);
            }
            if (zzhS)
            {
                zzrx1.zzb(6, zzhS);
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzc(zzrw1);
        }

        public zzb zzc(zzrw zzrw1)
            throws IOException
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

                case 8: // '\b'
                    zzhT = zzrw1.zzFs();
                    break;

                case 16: // '\020'
                    zzhR = zzrw1.zzFr();
                    break;

                case 24: // '\030'
                    int l = zzsh.zzc(zzrw1, 24);
                    int ai[];
                    int j;
                    if (zzhQ == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzhQ.length;
                    }
                    ai = new int[l + j];
                    l = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzhQ, 0, ai, 0, j);
                        l = j;
                    }
                    for (; l < ai.length - 1; l++)
                    {
                        ai[l] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai[l] = zzrw1.zzFr();
                    zzhQ = ai;
                    break;

                case 26: // '\032'
                    int j1 = zzrw1.zzlC(zzrw1.zzFv());
                    int k = zzrw1.getPosition();
                    int i1;
                    for (i1 = 0; zzrw1.zzFA() > 0; i1++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(k);
                    int ai1[];
                    if (zzhQ == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zzhQ.length;
                    }
                    ai1 = new int[i1 + k];
                    i1 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zzhQ, 0, ai1, 0, k);
                        i1 = k;
                    }
                    for (; i1 < ai1.length; i1++)
                    {
                        ai1[i1] = zzrw1.zzFr();
                    }

                    zzhQ = ai1;
                    zzrw1.zzlD(j1);
                    break;

                case 32: // ' '
                    name = zzrw1.zzFr();
                    break;

                case 48: // '0'
                    zzhS = zzrw1.zzFs();
                    break;
                }
            } while (true);
        }

        public zzb()
        {
            zzD();
        }
    }

    public static final class zzc extends zzry
    {

        private static volatile zzc zzhU[];
        public String key;
        public long zzhV;
        public long zzhW;
        public boolean zzhX;
        public long zzhY;

        public static zzc[] zzE()
        {
            if (zzhU == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzhU == null)
                    {
                        zzhU = new zzc[0];
                    }
                }
            }
            return zzhU;
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
            if (!(obj instanceof zzc)) goto _L4; else goto _L3
_L3:
            obj = (zzc)obj;
            if (key != null)
            {
                break MISSING_BLOCK_LABEL_134;
            }
            flag = flag1;
            if (((zzc) (obj)).key != null) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (zzhV != ((zzc) (obj)).zzhV) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (zzhW != ((zzc) (obj)).zzhW) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (zzhX != ((zzc) (obj)).zzhX) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (zzhY != ((zzc) (obj)).zzhY) goto _L4; else goto _L9
_L9:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_150;
            }
            if (((zzc) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zzc) (obj)).zzbik.isEmpty()) goto _L4; else goto _L10
_L10:
            return true;
            if (!key.equals(((zzc) (obj)).key))
            {
                return false;
            }
              goto _L5
            return zzbik.equals(((zzc) (obj)).zzbik);
        }

        public int hashCode()
        {
            boolean flag = false;
            int k = getClass().getName().hashCode();
            int i;
            char c;
            int j;
            int l;
            int i1;
            int j1;
            if (key == null)
            {
                i = 0;
            } else
            {
                i = key.hashCode();
            }
            l = (int)(zzhV ^ zzhV >>> 32);
            i1 = (int)(zzhW ^ zzhW >>> 32);
            if (zzhX)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            j1 = (int)(zzhY ^ zzhY >>> 32);
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
            return ((c + (((i + (k + 527) * 31) * 31 + l) * 31 + i1) * 31) * 31 + j1) * 31 + j;
        }

        protected int zzB()
        {
            int j = super.zzB();
            int i = j;
            if (!key.equals(""))
            {
                i = j + zzrx.zzn(1, key);
            }
            j = i;
            if (zzhV != 0L)
            {
                j = i + zzrx.zzd(2, zzhV);
            }
            i = j;
            if (zzhW != 0x7fffffffL)
            {
                i = j + zzrx.zzd(3, zzhW);
            }
            j = i;
            if (zzhX)
            {
                j = i + zzrx.zzc(4, zzhX);
            }
            i = j;
            if (zzhY != 0L)
            {
                i = j + zzrx.zzd(5, zzhY);
            }
            return i;
        }

        public zzc zzF()
        {
            key = "";
            zzhV = 0L;
            zzhW = 0x7fffffffL;
            zzhX = false;
            zzhY = 0L;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            if (!key.equals(""))
            {
                zzrx1.zzb(1, key);
            }
            if (zzhV != 0L)
            {
                zzrx1.zzb(2, zzhV);
            }
            if (zzhW != 0x7fffffffL)
            {
                zzrx1.zzb(3, zzhW);
            }
            if (zzhX)
            {
                zzrx1.zzb(4, zzhX);
            }
            if (zzhY != 0L)
            {
                zzrx1.zzb(5, zzhY);
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzd(zzrw1);
        }

        public zzc zzd(zzrw zzrw1)
            throws IOException
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
                    key = zzrw1.readString();
                    break;

                case 16: // '\020'
                    zzhV = zzrw1.zzFq();
                    break;

                case 24: // '\030'
                    zzhW = zzrw1.zzFq();
                    break;

                case 32: // ' '
                    zzhX = zzrw1.zzFs();
                    break;

                case 40: // '('
                    zzhY = zzrw1.zzFq();
                    break;
                }
            } while (true);
        }

        public zzc()
        {
            zzF();
        }
    }

    public static final class zzd extends zzry
    {

        public zzag.zza zzhZ[];
        public zzag.zza zzia[];
        public zzc zzib[];

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
            if (!zzsc.equals(zzhZ, ((zzd) (obj)).zzhZ)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!zzsc.equals(zzia, ((zzd) (obj)).zzia)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!zzsc.equals(zzib, ((zzd) (obj)).zzib)) goto _L4; else goto _L7
_L7:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_111;
            }
            if (((zzd) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zzd) (obj)).zzbik.isEmpty()) goto _L4; else goto _L8
_L8:
            return true;
            return zzbik.equals(((zzd) (obj)).zzbik);
        }

        public int hashCode()
        {
            int j = getClass().getName().hashCode();
            int k = zzsc.hashCode(zzhZ);
            int l = zzsc.hashCode(zzia);
            int i1 = zzsc.hashCode(zzib);
            int i;
            if (zzbik == null || zzbik.isEmpty())
            {
                i = 0;
            } else
            {
                i = zzbik.hashCode();
            }
            return i + ((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31;
        }

        protected int zzB()
        {
            boolean flag = false;
            int i = super.zzB();
            int j = i;
            if (zzhZ != null)
            {
                j = i;
                if (zzhZ.length > 0)
                {
                    for (j = 0; j < zzhZ.length;)
                    {
                        zzag.zza zza1 = zzhZ[j];
                        int i1 = i;
                        if (zza1 != null)
                        {
                            i1 = i + zzrx.zzc(1, zza1);
                        }
                        j++;
                        i = i1;
                    }

                    j = i;
                }
            }
            i = j;
            if (zzia != null)
            {
                i = j;
                if (zzia.length > 0)
                {
                    i = j;
                    for (int k = 0; k < zzia.length;)
                    {
                        zzag.zza zza2 = zzia[k];
                        int j1 = i;
                        if (zza2 != null)
                        {
                            j1 = i + zzrx.zzc(2, zza2);
                        }
                        k++;
                        i = j1;
                    }

                }
            }
            int k1 = i;
            if (zzib != null)
            {
                k1 = i;
                if (zzib.length > 0)
                {
                    int l = ((flag) ? 1 : 0);
                    do
                    {
                        k1 = i;
                        if (l >= zzib.length)
                        {
                            break;
                        }
                        zzc zzc1 = zzib[l];
                        k1 = i;
                        if (zzc1 != null)
                        {
                            k1 = i + zzrx.zzc(3, zzc1);
                        }
                        l++;
                        i = k1;
                    } while (true);
                }
            }
            return k1;
        }

        public zzd zzG()
        {
            zzhZ = zzag.zza.zzQ();
            zzia = zzag.zza.zzQ();
            zzib = zzc.zzE();
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            boolean flag = false;
            if (zzhZ != null && zzhZ.length > 0)
            {
                for (int i = 0; i < zzhZ.length; i++)
                {
                    zzag.zza zza1 = zzhZ[i];
                    if (zza1 != null)
                    {
                        zzrx1.zza(1, zza1);
                    }
                }

            }
            if (zzia != null && zzia.length > 0)
            {
                for (int j = 0; j < zzia.length; j++)
                {
                    zzag.zza zza2 = zzia[j];
                    if (zza2 != null)
                    {
                        zzrx1.zza(2, zza2);
                    }
                }

            }
            if (zzib != null && zzib.length > 0)
            {
                for (int k = ((flag) ? 1 : 0); k < zzib.length; k++)
                {
                    zzc zzc1 = zzib[k];
                    if (zzc1 != null)
                    {
                        zzrx1.zza(3, zzc1);
                    }
                }

            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zze(zzrw1);
        }

        public zzd zze(zzrw zzrw1)
            throws IOException
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
                    int i1 = zzsh.zzc(zzrw1, 10);
                    zzag.zza azza[];
                    int j;
                    if (zzhZ == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzhZ.length;
                    }
                    azza = new zzag.zza[i1 + j];
                    i1 = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzhZ, 0, azza, 0, j);
                        i1 = j;
                    }
                    for (; i1 < azza.length - 1; i1++)
                    {
                        azza[i1] = new zzag.zza();
                        zzrw1.zza(azza[i1]);
                        zzrw1.zzFo();
                    }

                    azza[i1] = new zzag.zza();
                    zzrw1.zza(azza[i1]);
                    zzhZ = azza;
                    break;

                case 18: // '\022'
                    int j1 = zzsh.zzc(zzrw1, 18);
                    zzag.zza azza1[];
                    int k;
                    if (zzia == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zzia.length;
                    }
                    azza1 = new zzag.zza[j1 + k];
                    j1 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zzia, 0, azza1, 0, k);
                        j1 = k;
                    }
                    for (; j1 < azza1.length - 1; j1++)
                    {
                        azza1[j1] = new zzag.zza();
                        zzrw1.zza(azza1[j1]);
                        zzrw1.zzFo();
                    }

                    azza1[j1] = new zzag.zza();
                    zzrw1.zza(azza1[j1]);
                    zzia = azza1;
                    break;

                case 26: // '\032'
                    int k1 = zzsh.zzc(zzrw1, 26);
                    zzc azzc[];
                    int l;
                    if (zzib == null)
                    {
                        l = 0;
                    } else
                    {
                        l = zzib.length;
                    }
                    azzc = new zzc[k1 + l];
                    k1 = l;
                    if (l != 0)
                    {
                        System.arraycopy(zzib, 0, azzc, 0, l);
                        k1 = l;
                    }
                    for (; k1 < azzc.length - 1; k1++)
                    {
                        azzc[k1] = new zzc();
                        zzrw1.zza(azzc[k1]);
                        zzrw1.zzFo();
                    }

                    azzc[k1] = new zzc();
                    zzrw1.zza(azzc[k1]);
                    zzib = azzc;
                    break;
                }
            } while (true);
        }

        public zzd()
        {
            zzG();
        }
    }

    public static final class zze extends zzry
    {

        private static volatile zze zzic[];
        public int key;
        public int value;

        public static zze[] zzH()
        {
            if (zzic == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzic == null)
                    {
                        zzic = new zze[0];
                    }
                }
            }
            return zzic;
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
            if (!(obj instanceof zze)) goto _L4; else goto _L3
_L3:
            obj = (zze)obj;
            flag = flag1;
            if (key != ((zze) (obj)).key) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (value != ((zze) (obj)).value) goto _L4; else goto _L6
_L6:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_89;
            }
            if (((zze) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zze) (obj)).zzbik.isEmpty()) goto _L4; else goto _L7
_L7:
            return true;
            return zzbik.equals(((zze) (obj)).zzbik);
        }

        public int hashCode()
        {
            int j = getClass().getName().hashCode();
            int k = key;
            int l = value;
            int i;
            if (zzbik == null || zzbik.isEmpty())
            {
                i = 0;
            } else
            {
                i = zzbik.hashCode();
            }
            return i + (((j + 527) * 31 + k) * 31 + l) * 31;
        }

        protected int zzB()
        {
            return super.zzB() + zzrx.zzA(1, key) + zzrx.zzA(2, value);
        }

        public zze zzI()
        {
            key = 0;
            value = 0;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            zzrx1.zzy(1, key);
            zzrx1.zzy(2, value);
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzf(zzrw1);
        }

        public zze zzf(zzrw zzrw1)
            throws IOException
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

                case 8: // '\b'
                    key = zzrw1.zzFr();
                    break;

                case 16: // '\020'
                    value = zzrw1.zzFr();
                    break;
                }
            } while (true);
        }

        public zze()
        {
            zzI();
        }
    }

    public static final class zzf extends zzry
    {

        public String version;
        public String zzid[];
        public String zzie[];
        public zzag.zza zzif[];
        public zze zzig[];
        public zzb zzih[];
        public zzb zzii[];
        public zzb zzij[];
        public zzg zzik[];
        public String zzil;
        public String zzim;
        public String zzin;
        public zza zzio;
        public float zzip;
        public boolean zziq;
        public String zzir[];
        public int zzis;

        public static zzf zzc(byte abyte0[])
            throws zzsd
        {
            return (zzf)zzse.zza(new zzf(), abyte0);
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
            if (!(obj instanceof zzf)) goto _L4; else goto _L3
_L3:
            obj = (zzf)obj;
            flag = flag1;
            if (!zzsc.equals(zzid, ((zzf) (obj)).zzid)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!zzsc.equals(zzie, ((zzf) (obj)).zzie)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!zzsc.equals(zzif, ((zzf) (obj)).zzif)) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (!zzsc.equals(zzig, ((zzf) (obj)).zzig)) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!zzsc.equals(zzih, ((zzf) (obj)).zzih)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!zzsc.equals(zzii, ((zzf) (obj)).zzii)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!zzsc.equals(zzij, ((zzf) (obj)).zzij)) goto _L4; else goto _L11
_L11:
            flag = flag1;
            if (!zzsc.equals(zzik, ((zzf) (obj)).zzik)) goto _L4; else goto _L12
_L12:
            if (zzil != null) goto _L14; else goto _L13
_L13:
            flag = flag1;
            if (((zzf) (obj)).zzil != null) goto _L4; else goto _L15
_L15:
            if (zzim != null) goto _L17; else goto _L16
_L16:
            flag = flag1;
            if (((zzf) (obj)).zzim != null) goto _L4; else goto _L18
_L18:
            if (zzin != null) goto _L20; else goto _L19
_L19:
            flag = flag1;
            if (((zzf) (obj)).zzin != null) goto _L4; else goto _L21
_L21:
            if (version != null) goto _L23; else goto _L22
_L22:
            flag = flag1;
            if (((zzf) (obj)).version != null) goto _L4; else goto _L24
_L24:
            if (zzio != null) goto _L26; else goto _L25
_L25:
            flag = flag1;
            if (((zzf) (obj)).zzio != null) goto _L4; else goto _L27
_L27:
            flag = flag1;
            if (Float.floatToIntBits(zzip) != Float.floatToIntBits(((zzf) (obj)).zzip)) goto _L4; else goto _L28
_L28:
            flag = flag1;
            if (zziq != ((zzf) (obj)).zziq) goto _L4; else goto _L29
_L29:
            flag = flag1;
            if (!zzsc.equals(zzir, ((zzf) (obj)).zzir)) goto _L4; else goto _L30
_L30:
            flag = flag1;
            if (zzis != ((zzf) (obj)).zzis) goto _L4; else goto _L31
_L31:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_412;
            }
            if (((zzf) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zzf) (obj)).zzbik.isEmpty()) goto _L4; else goto _L32
_L32:
            return true;
_L14:
            if (!zzil.equals(((zzf) (obj)).zzil))
            {
                return false;
            }
              goto _L15
_L17:
            if (!zzim.equals(((zzf) (obj)).zzim))
            {
                return false;
            }
              goto _L18
_L20:
            if (!zzin.equals(((zzf) (obj)).zzin))
            {
                return false;
            }
              goto _L21
_L23:
            if (!version.equals(((zzf) (obj)).version))
            {
                return false;
            }
              goto _L24
_L26:
            if (!zzio.equals(((zzf) (obj)).zzio))
            {
                return false;
            }
              goto _L27
            return zzbik.equals(((zzf) (obj)).zzbik);
              goto _L15
        }

        public int hashCode()
        {
            boolean flag = false;
            int k1 = getClass().getName().hashCode();
            int l1 = zzsc.hashCode(zzid);
            int i2 = zzsc.hashCode(zzie);
            int j2 = zzsc.hashCode(zzif);
            int k2 = zzsc.hashCode(zzig);
            int l2 = zzsc.hashCode(zzih);
            int i3 = zzsc.hashCode(zzii);
            int j3 = zzsc.hashCode(zzij);
            int k3 = zzsc.hashCode(zzik);
            int i;
            int j;
            int k;
            int l;
            int i1;
            char c;
            int j1;
            int l3;
            int i4;
            int j4;
            if (zzil == null)
            {
                i = 0;
            } else
            {
                i = zzil.hashCode();
            }
            if (zzim == null)
            {
                j = 0;
            } else
            {
                j = zzim.hashCode();
            }
            if (zzin == null)
            {
                k = 0;
            } else
            {
                k = zzin.hashCode();
            }
            if (version == null)
            {
                l = 0;
            } else
            {
                l = version.hashCode();
            }
            if (zzio == null)
            {
                i1 = 0;
            } else
            {
                i1 = zzio.hashCode();
            }
            l3 = Float.floatToIntBits(zzip);
            if (zziq)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            i4 = zzsc.hashCode(zzir);
            j4 = zzis;
            j1 = ((flag) ? 1 : 0);
            if (zzbik != null)
            {
                if (zzbik.isEmpty())
                {
                    j1 = ((flag) ? 1 : 0);
                } else
                {
                    j1 = zzbik.hashCode();
                }
            }
            return (((c + ((i1 + (l + (k + (j + (i + (((((((((k1 + 527) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31 + l3) * 31) * 31 + i4) * 31 + j4) * 31 + j1;
        }

        protected int zzB()
        {
            boolean flag = false;
            int k4 = super.zzB();
            int j;
            int k;
            int k2;
            if (zzie != null && zzie.length > 0)
            {
                int i = 0;
                k = 0;
                int l;
                int i3;
                for (l = 0; i < zzie.length; l = i3)
                {
                    String s = zzie[i];
                    int l3 = k;
                    i3 = l;
                    if (s != null)
                    {
                        i3 = l + 1;
                        l3 = k + zzrx.zzfA(s);
                    }
                    i++;
                    k = l3;
                }

                k = k4 + k + l * 1;
            } else
            {
                k = k4;
            }
            j = k;
            if (zzif != null)
            {
                j = k;
                if (zzif.length > 0)
                {
                    j = k;
                    for (k = 0; k < zzif.length;)
                    {
                        zzag.zza zza1 = zzif[k];
                        int i1 = j;
                        if (zza1 != null)
                        {
                            i1 = j + zzrx.zzc(2, zza1);
                        }
                        k++;
                        j = i1;
                    }

                }
            }
            k = j;
            if (zzig != null)
            {
                k = j;
                if (zzig.length > 0)
                {
                    for (k = 0; k < zzig.length;)
                    {
                        zze zze1 = zzig[k];
                        int j1 = j;
                        if (zze1 != null)
                        {
                            j1 = j + zzrx.zzc(3, zze1);
                        }
                        k++;
                        j = j1;
                    }

                    k = j;
                }
            }
            j = k;
            if (zzih != null)
            {
                j = k;
                if (zzih.length > 0)
                {
                    j = k;
                    for (k = 0; k < zzih.length;)
                    {
                        zzb zzb1 = zzih[k];
                        int k1 = j;
                        if (zzb1 != null)
                        {
                            k1 = j + zzrx.zzc(4, zzb1);
                        }
                        k++;
                        j = k1;
                    }

                }
            }
            k = j;
            if (zzii != null)
            {
                k = j;
                if (zzii.length > 0)
                {
                    for (k = 0; k < zzii.length;)
                    {
                        zzb zzb2 = zzii[k];
                        int l1 = j;
                        if (zzb2 != null)
                        {
                            l1 = j + zzrx.zzc(5, zzb2);
                        }
                        k++;
                        j = l1;
                    }

                    k = j;
                }
            }
            j = k;
            if (zzij != null)
            {
                j = k;
                if (zzij.length > 0)
                {
                    j = k;
                    for (k = 0; k < zzij.length;)
                    {
                        zzb zzb3 = zzij[k];
                        int i2 = j;
                        if (zzb3 != null)
                        {
                            i2 = j + zzrx.zzc(6, zzb3);
                        }
                        k++;
                        j = i2;
                    }

                }
            }
            k = j;
            if (zzik != null)
            {
                k = j;
                if (zzik.length > 0)
                {
                    for (k = 0; k < zzik.length;)
                    {
                        zzg zzg1 = zzik[k];
                        int j2 = j;
                        if (zzg1 != null)
                        {
                            j2 = j + zzrx.zzc(7, zzg1);
                        }
                        k++;
                        j = j2;
                    }

                    k = j;
                }
            }
            j = k;
            if (!zzil.equals(""))
            {
                j = k + zzrx.zzn(9, zzil);
            }
            k = j;
            if (!zzim.equals(""))
            {
                k = j + zzrx.zzn(10, zzim);
            }
            j = k;
            if (!zzin.equals("0"))
            {
                j = k + zzrx.zzn(12, zzin);
            }
            k = j;
            if (!version.equals(""))
            {
                k = j + zzrx.zzn(13, version);
            }
            k2 = k;
            if (zzio != null)
            {
                k2 = k + zzrx.zzc(14, zzio);
            }
            j = k2;
            if (Float.floatToIntBits(zzip) != Float.floatToIntBits(0.0F))
            {
                j = k2 + zzrx.zzc(15, zzip);
            }
            k = j;
            if (zzir != null)
            {
                k = j;
                if (zzir.length > 0)
                {
                    k = 0;
                    k2 = 0;
                    int j3;
                    int i4;
                    for (j3 = 0; k < zzir.length; j3 = i4)
                    {
                        String s1 = zzir[k];
                        k4 = k2;
                        i4 = j3;
                        if (s1 != null)
                        {
                            i4 = j3 + 1;
                            k4 = k2 + zzrx.zzfA(s1);
                        }
                        k++;
                        k2 = k4;
                    }

                    k = j + k2 + j3 * 2;
                }
            }
            k2 = k;
            if (zzis != 0)
            {
                k2 = k + zzrx.zzA(17, zzis);
            }
            j = k2;
            if (zziq)
            {
                j = k2 + zzrx.zzc(18, zziq);
            }
            k = j;
            if (zzid != null)
            {
                k = j;
                if (zzid.length > 0)
                {
                    int l2 = 0;
                    int k3 = 0;
                    for (k = ((flag) ? 1 : 0); k < zzid.length;)
                    {
                        String s2 = zzid[k];
                        k4 = l2;
                        int j4 = k3;
                        if (s2 != null)
                        {
                            j4 = k3 + 1;
                            k4 = l2 + zzrx.zzfA(s2);
                        }
                        k++;
                        l2 = k4;
                        k3 = j4;
                    }

                    k = j + l2 + k3 * 2;
                }
            }
            return k;
        }

        public zzf zzJ()
        {
            zzid = zzsh.zzbiC;
            zzie = zzsh.zzbiC;
            zzif = zzag.zza.zzQ();
            zzig = zze.zzH();
            zzih = zzb.zzC();
            zzii = zzb.zzC();
            zzij = zzb.zzC();
            zzik = zzg.zzK();
            zzil = "";
            zzim = "";
            zzin = "0";
            version = "";
            zzio = null;
            zzip = 0.0F;
            zziq = false;
            zzir = zzsh.zzbiC;
            zzis = 0;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            boolean flag = false;
            if (zzie != null && zzie.length > 0)
            {
                for (int i = 0; i < zzie.length; i++)
                {
                    String s = zzie[i];
                    if (s != null)
                    {
                        zzrx1.zzb(1, s);
                    }
                }

            }
            if (zzif != null && zzif.length > 0)
            {
                for (int j = 0; j < zzif.length; j++)
                {
                    zzag.zza zza1 = zzif[j];
                    if (zza1 != null)
                    {
                        zzrx1.zza(2, zza1);
                    }
                }

            }
            if (zzig != null && zzig.length > 0)
            {
                for (int k = 0; k < zzig.length; k++)
                {
                    zze zze1 = zzig[k];
                    if (zze1 != null)
                    {
                        zzrx1.zza(3, zze1);
                    }
                }

            }
            if (zzih != null && zzih.length > 0)
            {
                for (int l = 0; l < zzih.length; l++)
                {
                    zzb zzb1 = zzih[l];
                    if (zzb1 != null)
                    {
                        zzrx1.zza(4, zzb1);
                    }
                }

            }
            if (zzii != null && zzii.length > 0)
            {
                for (int i1 = 0; i1 < zzii.length; i1++)
                {
                    zzb zzb2 = zzii[i1];
                    if (zzb2 != null)
                    {
                        zzrx1.zza(5, zzb2);
                    }
                }

            }
            if (zzij != null && zzij.length > 0)
            {
                for (int j1 = 0; j1 < zzij.length; j1++)
                {
                    zzb zzb3 = zzij[j1];
                    if (zzb3 != null)
                    {
                        zzrx1.zza(6, zzb3);
                    }
                }

            }
            if (zzik != null && zzik.length > 0)
            {
                for (int k1 = 0; k1 < zzik.length; k1++)
                {
                    zzg zzg1 = zzik[k1];
                    if (zzg1 != null)
                    {
                        zzrx1.zza(7, zzg1);
                    }
                }

            }
            if (!zzil.equals(""))
            {
                zzrx1.zzb(9, zzil);
            }
            if (!zzim.equals(""))
            {
                zzrx1.zzb(10, zzim);
            }
            if (!zzin.equals("0"))
            {
                zzrx1.zzb(12, zzin);
            }
            if (!version.equals(""))
            {
                zzrx1.zzb(13, version);
            }
            if (zzio != null)
            {
                zzrx1.zza(14, zzio);
            }
            if (Float.floatToIntBits(zzip) != Float.floatToIntBits(0.0F))
            {
                zzrx1.zzb(15, zzip);
            }
            if (zzir != null && zzir.length > 0)
            {
                for (int l1 = 0; l1 < zzir.length; l1++)
                {
                    String s1 = zzir[l1];
                    if (s1 != null)
                    {
                        zzrx1.zzb(16, s1);
                    }
                }

            }
            if (zzis != 0)
            {
                zzrx1.zzy(17, zzis);
            }
            if (zziq)
            {
                zzrx1.zzb(18, zziq);
            }
            if (zzid != null && zzid.length > 0)
            {
                for (int i2 = ((flag) ? 1 : 0); i2 < zzid.length; i2++)
                {
                    String s2 = zzid[i2];
                    if (s2 != null)
                    {
                        zzrx1.zzb(19, s2);
                    }
                }

            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzg(zzrw1);
        }

        public zzf zzg(zzrw zzrw1)
            throws IOException
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
                    int k2 = zzsh.zzc(zzrw1, 10);
                    String as[];
                    int j;
                    if (zzie == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zzie.length;
                    }
                    as = new String[k2 + j];
                    k2 = j;
                    if (j != 0)
                    {
                        System.arraycopy(zzie, 0, as, 0, j);
                        k2 = j;
                    }
                    for (; k2 < as.length - 1; k2++)
                    {
                        as[k2] = zzrw1.readString();
                        zzrw1.zzFo();
                    }

                    as[k2] = zzrw1.readString();
                    zzie = as;
                    break;

                case 18: // '\022'
                    int l2 = zzsh.zzc(zzrw1, 18);
                    zzag.zza azza[];
                    int k;
                    if (zzif == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zzif.length;
                    }
                    azza = new zzag.zza[l2 + k];
                    l2 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zzif, 0, azza, 0, k);
                        l2 = k;
                    }
                    for (; l2 < azza.length - 1; l2++)
                    {
                        azza[l2] = new zzag.zza();
                        zzrw1.zza(azza[l2]);
                        zzrw1.zzFo();
                    }

                    azza[l2] = new zzag.zza();
                    zzrw1.zza(azza[l2]);
                    zzif = azza;
                    break;

                case 26: // '\032'
                    int i3 = zzsh.zzc(zzrw1, 26);
                    zze azze[];
                    int l;
                    if (zzig == null)
                    {
                        l = 0;
                    } else
                    {
                        l = zzig.length;
                    }
                    azze = new zze[i3 + l];
                    i3 = l;
                    if (l != 0)
                    {
                        System.arraycopy(zzig, 0, azze, 0, l);
                        i3 = l;
                    }
                    for (; i3 < azze.length - 1; i3++)
                    {
                        azze[i3] = new zze();
                        zzrw1.zza(azze[i3]);
                        zzrw1.zzFo();
                    }

                    azze[i3] = new zze();
                    zzrw1.zza(azze[i3]);
                    zzig = azze;
                    break;

                case 34: // '"'
                    int j3 = zzsh.zzc(zzrw1, 34);
                    zzb azzb[];
                    int i1;
                    if (zzih == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = zzih.length;
                    }
                    azzb = new zzb[j3 + i1];
                    j3 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(zzih, 0, azzb, 0, i1);
                        j3 = i1;
                    }
                    for (; j3 < azzb.length - 1; j3++)
                    {
                        azzb[j3] = new zzb();
                        zzrw1.zza(azzb[j3]);
                        zzrw1.zzFo();
                    }

                    azzb[j3] = new zzb();
                    zzrw1.zza(azzb[j3]);
                    zzih = azzb;
                    break;

                case 42: // '*'
                    int k3 = zzsh.zzc(zzrw1, 42);
                    zzb azzb1[];
                    int j1;
                    if (zzii == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = zzii.length;
                    }
                    azzb1 = new zzb[k3 + j1];
                    k3 = j1;
                    if (j1 != 0)
                    {
                        System.arraycopy(zzii, 0, azzb1, 0, j1);
                        k3 = j1;
                    }
                    for (; k3 < azzb1.length - 1; k3++)
                    {
                        azzb1[k3] = new zzb();
                        zzrw1.zza(azzb1[k3]);
                        zzrw1.zzFo();
                    }

                    azzb1[k3] = new zzb();
                    zzrw1.zza(azzb1[k3]);
                    zzii = azzb1;
                    break;

                case 50: // '2'
                    int l3 = zzsh.zzc(zzrw1, 50);
                    zzb azzb2[];
                    int k1;
                    if (zzij == null)
                    {
                        k1 = 0;
                    } else
                    {
                        k1 = zzij.length;
                    }
                    azzb2 = new zzb[l3 + k1];
                    l3 = k1;
                    if (k1 != 0)
                    {
                        System.arraycopy(zzij, 0, azzb2, 0, k1);
                        l3 = k1;
                    }
                    for (; l3 < azzb2.length - 1; l3++)
                    {
                        azzb2[l3] = new zzb();
                        zzrw1.zza(azzb2[l3]);
                        zzrw1.zzFo();
                    }

                    azzb2[l3] = new zzb();
                    zzrw1.zza(azzb2[l3]);
                    zzij = azzb2;
                    break;

                case 58: // ':'
                    int i4 = zzsh.zzc(zzrw1, 58);
                    zzg azzg[];
                    int l1;
                    if (zzik == null)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = zzik.length;
                    }
                    azzg = new zzg[i4 + l1];
                    i4 = l1;
                    if (l1 != 0)
                    {
                        System.arraycopy(zzik, 0, azzg, 0, l1);
                        i4 = l1;
                    }
                    for (; i4 < azzg.length - 1; i4++)
                    {
                        azzg[i4] = new zzg();
                        zzrw1.zza(azzg[i4]);
                        zzrw1.zzFo();
                    }

                    azzg[i4] = new zzg();
                    zzrw1.zza(azzg[i4]);
                    zzik = azzg;
                    break;

                case 74: // 'J'
                    zzil = zzrw1.readString();
                    break;

                case 82: // 'R'
                    zzim = zzrw1.readString();
                    break;

                case 98: // 'b'
                    zzin = zzrw1.readString();
                    break;

                case 106: // 'j'
                    version = zzrw1.readString();
                    break;

                case 114: // 'r'
                    if (zzio == null)
                    {
                        zzio = new zza();
                    }
                    zzrw1.zza(zzio);
                    break;

                case 125: // '}'
                    zzip = zzrw1.readFloat();
                    break;

                case 130: 
                    int j4 = zzsh.zzc(zzrw1, 130);
                    String as1[];
                    int i2;
                    if (zzir == null)
                    {
                        i2 = 0;
                    } else
                    {
                        i2 = zzir.length;
                    }
                    as1 = new String[j4 + i2];
                    j4 = i2;
                    if (i2 != 0)
                    {
                        System.arraycopy(zzir, 0, as1, 0, i2);
                        j4 = i2;
                    }
                    for (; j4 < as1.length - 1; j4++)
                    {
                        as1[j4] = zzrw1.readString();
                        zzrw1.zzFo();
                    }

                    as1[j4] = zzrw1.readString();
                    zzir = as1;
                    break;

                case 136: 
                    zzis = zzrw1.zzFr();
                    break;

                case 144: 
                    zziq = zzrw1.zzFs();
                    break;

                case 154: 
                    int k4 = zzsh.zzc(zzrw1, 154);
                    String as2[];
                    int j2;
                    if (zzid == null)
                    {
                        j2 = 0;
                    } else
                    {
                        j2 = zzid.length;
                    }
                    as2 = new String[k4 + j2];
                    k4 = j2;
                    if (j2 != 0)
                    {
                        System.arraycopy(zzid, 0, as2, 0, j2);
                        k4 = j2;
                    }
                    for (; k4 < as2.length - 1; k4++)
                    {
                        as2[k4] = zzrw1.readString();
                        zzrw1.zzFo();
                    }

                    as2[k4] = zzrw1.readString();
                    zzid = as2;
                    break;
                }
            } while (true);
        }

        public zzf()
        {
            zzJ();
        }
    }

    public static final class zzg extends zzry
    {

        private static volatile zzg zzit[];
        public int zziA[];
        public int zziB[];
        public int zziC[];
        public int zziD[];
        public int zziu[];
        public int zziv[];
        public int zziw[];
        public int zzix[];
        public int zziy[];
        public int zziz[];

        public static zzg[] zzK()
        {
            if (zzit == null)
            {
                synchronized (zzsc.zzbiu)
                {
                    if (zzit == null)
                    {
                        zzit = new zzg[0];
                    }
                }
            }
            return zzit;
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
            if (!(obj instanceof zzg)) goto _L4; else goto _L3
_L3:
            obj = (zzg)obj;
            flag = flag1;
            if (!zzsc.equals(zziu, ((zzg) (obj)).zziu)) goto _L4; else goto _L5
_L5:
            flag = flag1;
            if (!zzsc.equals(zziv, ((zzg) (obj)).zziv)) goto _L4; else goto _L6
_L6:
            flag = flag1;
            if (!zzsc.equals(zziw, ((zzg) (obj)).zziw)) goto _L4; else goto _L7
_L7:
            flag = flag1;
            if (!zzsc.equals(zzix, ((zzg) (obj)).zzix)) goto _L4; else goto _L8
_L8:
            flag = flag1;
            if (!zzsc.equals(zziy, ((zzg) (obj)).zziy)) goto _L4; else goto _L9
_L9:
            flag = flag1;
            if (!zzsc.equals(zziz, ((zzg) (obj)).zziz)) goto _L4; else goto _L10
_L10:
            flag = flag1;
            if (!zzsc.equals(zziA, ((zzg) (obj)).zziA)) goto _L4; else goto _L11
_L11:
            flag = flag1;
            if (!zzsc.equals(zziB, ((zzg) (obj)).zziB)) goto _L4; else goto _L12
_L12:
            flag = flag1;
            if (!zzsc.equals(zziC, ((zzg) (obj)).zziC)) goto _L4; else goto _L13
_L13:
            flag = flag1;
            if (!zzsc.equals(zziD, ((zzg) (obj)).zziD)) goto _L4; else goto _L14
_L14:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_223;
            }
            if (((zzg) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zzg) (obj)).zzbik.isEmpty()) goto _L4; else goto _L15
_L15:
            return true;
            return zzbik.equals(((zzg) (obj)).zzbik);
        }

        public int hashCode()
        {
            int j = getClass().getName().hashCode();
            int k = zzsc.hashCode(zziu);
            int l = zzsc.hashCode(zziv);
            int i1 = zzsc.hashCode(zziw);
            int j1 = zzsc.hashCode(zzix);
            int k1 = zzsc.hashCode(zziy);
            int l1 = zzsc.hashCode(zziz);
            int i2 = zzsc.hashCode(zziA);
            int j2 = zzsc.hashCode(zziB);
            int k2 = zzsc.hashCode(zziC);
            int l2 = zzsc.hashCode(zziD);
            int i;
            if (zzbik == null || zzbik.isEmpty())
            {
                i = 0;
            } else
            {
                i = zzbik.hashCode();
            }
            return i + (((((((((((j + 527) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31;
        }

        protected int zzB()
        {
            boolean flag = false;
            int l = super.zzB();
            int j;
            int k;
            if (zziu != null && zziu.length > 0)
            {
                int i = 0;
                k = 0;
                for (; i < zziu.length; i++)
                {
                    k += zzrx.zzlJ(zziu[i]);
                }

                k = l + k + zziu.length * 1;
            } else
            {
                k = l;
            }
            j = k;
            if (zziv != null)
            {
                j = k;
                if (zziv.length > 0)
                {
                    j = 0;
                    l = 0;
                    for (; j < zziv.length; j++)
                    {
                        l += zzrx.zzlJ(zziv[j]);
                    }

                    j = k + l + zziv.length * 1;
                }
            }
            k = j;
            if (zziw != null)
            {
                k = j;
                if (zziw.length > 0)
                {
                    k = 0;
                    l = 0;
                    for (; k < zziw.length; k++)
                    {
                        l += zzrx.zzlJ(zziw[k]);
                    }

                    k = j + l + zziw.length * 1;
                }
            }
            j = k;
            if (zzix != null)
            {
                j = k;
                if (zzix.length > 0)
                {
                    j = 0;
                    l = 0;
                    for (; j < zzix.length; j++)
                    {
                        l += zzrx.zzlJ(zzix[j]);
                    }

                    j = k + l + zzix.length * 1;
                }
            }
            k = j;
            if (zziy != null)
            {
                k = j;
                if (zziy.length > 0)
                {
                    k = 0;
                    l = 0;
                    for (; k < zziy.length; k++)
                    {
                        l += zzrx.zzlJ(zziy[k]);
                    }

                    k = j + l + zziy.length * 1;
                }
            }
            j = k;
            if (zziz != null)
            {
                j = k;
                if (zziz.length > 0)
                {
                    j = 0;
                    l = 0;
                    for (; j < zziz.length; j++)
                    {
                        l += zzrx.zzlJ(zziz[j]);
                    }

                    j = k + l + zziz.length * 1;
                }
            }
            k = j;
            if (zziA != null)
            {
                k = j;
                if (zziA.length > 0)
                {
                    k = 0;
                    l = 0;
                    for (; k < zziA.length; k++)
                    {
                        l += zzrx.zzlJ(zziA[k]);
                    }

                    k = j + l + zziA.length * 1;
                }
            }
            j = k;
            if (zziB != null)
            {
                j = k;
                if (zziB.length > 0)
                {
                    j = 0;
                    l = 0;
                    for (; j < zziB.length; j++)
                    {
                        l += zzrx.zzlJ(zziB[j]);
                    }

                    j = k + l + zziB.length * 1;
                }
            }
            k = j;
            if (zziC != null)
            {
                k = j;
                if (zziC.length > 0)
                {
                    k = 0;
                    l = 0;
                    for (; k < zziC.length; k++)
                    {
                        l += zzrx.zzlJ(zziC[k]);
                    }

                    k = j + l + zziC.length * 1;
                }
            }
            j = k;
            if (zziD != null)
            {
                j = k;
                if (zziD.length > 0)
                {
                    l = 0;
                    for (j = ((flag) ? 1 : 0); j < zziD.length; j++)
                    {
                        l += zzrx.zzlJ(zziD[j]);
                    }

                    j = k + l + zziD.length * 1;
                }
            }
            return j;
        }

        public zzg zzL()
        {
            zziu = zzsh.zzbix;
            zziv = zzsh.zzbix;
            zziw = zzsh.zzbix;
            zzix = zzsh.zzbix;
            zziy = zzsh.zzbix;
            zziz = zzsh.zzbix;
            zziA = zzsh.zzbix;
            zziB = zzsh.zzbix;
            zziC = zzsh.zzbix;
            zziD = zzsh.zzbix;
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            boolean flag = false;
            if (zziu != null && zziu.length > 0)
            {
                for (int i = 0; i < zziu.length; i++)
                {
                    zzrx1.zzy(1, zziu[i]);
                }

            }
            if (zziv != null && zziv.length > 0)
            {
                for (int j = 0; j < zziv.length; j++)
                {
                    zzrx1.zzy(2, zziv[j]);
                }

            }
            if (zziw != null && zziw.length > 0)
            {
                for (int k = 0; k < zziw.length; k++)
                {
                    zzrx1.zzy(3, zziw[k]);
                }

            }
            if (zzix != null && zzix.length > 0)
            {
                for (int l = 0; l < zzix.length; l++)
                {
                    zzrx1.zzy(4, zzix[l]);
                }

            }
            if (zziy != null && zziy.length > 0)
            {
                for (int i1 = 0; i1 < zziy.length; i1++)
                {
                    zzrx1.zzy(5, zziy[i1]);
                }

            }
            if (zziz != null && zziz.length > 0)
            {
                for (int j1 = 0; j1 < zziz.length; j1++)
                {
                    zzrx1.zzy(6, zziz[j1]);
                }

            }
            if (zziA != null && zziA.length > 0)
            {
                for (int k1 = 0; k1 < zziA.length; k1++)
                {
                    zzrx1.zzy(7, zziA[k1]);
                }

            }
            if (zziB != null && zziB.length > 0)
            {
                for (int l1 = 0; l1 < zziB.length; l1++)
                {
                    zzrx1.zzy(8, zziB[l1]);
                }

            }
            if (zziC != null && zziC.length > 0)
            {
                for (int i2 = 0; i2 < zziC.length; i2++)
                {
                    zzrx1.zzy(9, zziC[i2]);
                }

            }
            if (zziD != null && zziD.length > 0)
            {
                for (int j2 = ((flag) ? 1 : 0); j2 < zziD.length; j2++)
                {
                    zzrx1.zzy(10, zziD[j2]);
                }

            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzh(zzrw1);
        }

        public zzg zzh(zzrw zzrw1)
            throws IOException
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

                case 8: // '\b'
                    int j5 = zzsh.zzc(zzrw1, 8);
                    int ai[];
                    int j;
                    if (zziu == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zziu.length;
                    }
                    ai = new int[j5 + j];
                    j5 = j;
                    if (j != 0)
                    {
                        System.arraycopy(zziu, 0, ai, 0, j);
                        j5 = j;
                    }
                    for (; j5 < ai.length - 1; j5++)
                    {
                        ai[j5] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai[j5] = zzrw1.zzFr();
                    zziu = ai;
                    break;

                case 10: // '\n'
                    int j10 = zzrw1.zzlC(zzrw1.zzFv());
                    int k = zzrw1.getPosition();
                    int k5;
                    for (k5 = 0; zzrw1.zzFA() > 0; k5++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(k);
                    int ai1[];
                    if (zziu == null)
                    {
                        k = 0;
                    } else
                    {
                        k = zziu.length;
                    }
                    ai1 = new int[k5 + k];
                    k5 = k;
                    if (k != 0)
                    {
                        System.arraycopy(zziu, 0, ai1, 0, k);
                        k5 = k;
                    }
                    for (; k5 < ai1.length; k5++)
                    {
                        ai1[k5] = zzrw1.zzFr();
                    }

                    zziu = ai1;
                    zzrw1.zzlD(j10);
                    break;

                case 16: // '\020'
                    int l5 = zzsh.zzc(zzrw1, 16);
                    int ai2[];
                    int l;
                    if (zziv == null)
                    {
                        l = 0;
                    } else
                    {
                        l = zziv.length;
                    }
                    ai2 = new int[l5 + l];
                    l5 = l;
                    if (l != 0)
                    {
                        System.arraycopy(zziv, 0, ai2, 0, l);
                        l5 = l;
                    }
                    for (; l5 < ai2.length - 1; l5++)
                    {
                        ai2[l5] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai2[l5] = zzrw1.zzFr();
                    zziv = ai2;
                    break;

                case 18: // '\022'
                    int k10 = zzrw1.zzlC(zzrw1.zzFv());
                    int i1 = zzrw1.getPosition();
                    int i6;
                    for (i6 = 0; zzrw1.zzFA() > 0; i6++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(i1);
                    int ai3[];
                    if (zziv == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = zziv.length;
                    }
                    ai3 = new int[i6 + i1];
                    i6 = i1;
                    if (i1 != 0)
                    {
                        System.arraycopy(zziv, 0, ai3, 0, i1);
                        i6 = i1;
                    }
                    for (; i6 < ai3.length; i6++)
                    {
                        ai3[i6] = zzrw1.zzFr();
                    }

                    zziv = ai3;
                    zzrw1.zzlD(k10);
                    break;

                case 24: // '\030'
                    int j6 = zzsh.zzc(zzrw1, 24);
                    int ai4[];
                    int j1;
                    if (zziw == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = zziw.length;
                    }
                    ai4 = new int[j6 + j1];
                    j6 = j1;
                    if (j1 != 0)
                    {
                        System.arraycopy(zziw, 0, ai4, 0, j1);
                        j6 = j1;
                    }
                    for (; j6 < ai4.length - 1; j6++)
                    {
                        ai4[j6] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai4[j6] = zzrw1.zzFr();
                    zziw = ai4;
                    break;

                case 26: // '\032'
                    int l10 = zzrw1.zzlC(zzrw1.zzFv());
                    int k1 = zzrw1.getPosition();
                    int k6;
                    for (k6 = 0; zzrw1.zzFA() > 0; k6++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(k1);
                    int ai5[];
                    if (zziw == null)
                    {
                        k1 = 0;
                    } else
                    {
                        k1 = zziw.length;
                    }
                    ai5 = new int[k6 + k1];
                    k6 = k1;
                    if (k1 != 0)
                    {
                        System.arraycopy(zziw, 0, ai5, 0, k1);
                        k6 = k1;
                    }
                    for (; k6 < ai5.length; k6++)
                    {
                        ai5[k6] = zzrw1.zzFr();
                    }

                    zziw = ai5;
                    zzrw1.zzlD(l10);
                    break;

                case 32: // ' '
                    int l6 = zzsh.zzc(zzrw1, 32);
                    int ai6[];
                    int l1;
                    if (zzix == null)
                    {
                        l1 = 0;
                    } else
                    {
                        l1 = zzix.length;
                    }
                    ai6 = new int[l6 + l1];
                    l6 = l1;
                    if (l1 != 0)
                    {
                        System.arraycopy(zzix, 0, ai6, 0, l1);
                        l6 = l1;
                    }
                    for (; l6 < ai6.length - 1; l6++)
                    {
                        ai6[l6] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai6[l6] = zzrw1.zzFr();
                    zzix = ai6;
                    break;

                case 34: // '"'
                    int i11 = zzrw1.zzlC(zzrw1.zzFv());
                    int i2 = zzrw1.getPosition();
                    int i7;
                    for (i7 = 0; zzrw1.zzFA() > 0; i7++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(i2);
                    int ai7[];
                    if (zzix == null)
                    {
                        i2 = 0;
                    } else
                    {
                        i2 = zzix.length;
                    }
                    ai7 = new int[i7 + i2];
                    i7 = i2;
                    if (i2 != 0)
                    {
                        System.arraycopy(zzix, 0, ai7, 0, i2);
                        i7 = i2;
                    }
                    for (; i7 < ai7.length; i7++)
                    {
                        ai7[i7] = zzrw1.zzFr();
                    }

                    zzix = ai7;
                    zzrw1.zzlD(i11);
                    break;

                case 40: // '('
                    int j7 = zzsh.zzc(zzrw1, 40);
                    int ai8[];
                    int j2;
                    if (zziy == null)
                    {
                        j2 = 0;
                    } else
                    {
                        j2 = zziy.length;
                    }
                    ai8 = new int[j7 + j2];
                    j7 = j2;
                    if (j2 != 0)
                    {
                        System.arraycopy(zziy, 0, ai8, 0, j2);
                        j7 = j2;
                    }
                    for (; j7 < ai8.length - 1; j7++)
                    {
                        ai8[j7] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai8[j7] = zzrw1.zzFr();
                    zziy = ai8;
                    break;

                case 42: // '*'
                    int j11 = zzrw1.zzlC(zzrw1.zzFv());
                    int k2 = zzrw1.getPosition();
                    int k7;
                    for (k7 = 0; zzrw1.zzFA() > 0; k7++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(k2);
                    int ai9[];
                    if (zziy == null)
                    {
                        k2 = 0;
                    } else
                    {
                        k2 = zziy.length;
                    }
                    ai9 = new int[k7 + k2];
                    k7 = k2;
                    if (k2 != 0)
                    {
                        System.arraycopy(zziy, 0, ai9, 0, k2);
                        k7 = k2;
                    }
                    for (; k7 < ai9.length; k7++)
                    {
                        ai9[k7] = zzrw1.zzFr();
                    }

                    zziy = ai9;
                    zzrw1.zzlD(j11);
                    break;

                case 48: // '0'
                    int l7 = zzsh.zzc(zzrw1, 48);
                    int ai10[];
                    int l2;
                    if (zziz == null)
                    {
                        l2 = 0;
                    } else
                    {
                        l2 = zziz.length;
                    }
                    ai10 = new int[l7 + l2];
                    l7 = l2;
                    if (l2 != 0)
                    {
                        System.arraycopy(zziz, 0, ai10, 0, l2);
                        l7 = l2;
                    }
                    for (; l7 < ai10.length - 1; l7++)
                    {
                        ai10[l7] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai10[l7] = zzrw1.zzFr();
                    zziz = ai10;
                    break;

                case 50: // '2'
                    int k11 = zzrw1.zzlC(zzrw1.zzFv());
                    int i3 = zzrw1.getPosition();
                    int i8;
                    for (i8 = 0; zzrw1.zzFA() > 0; i8++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(i3);
                    int ai11[];
                    if (zziz == null)
                    {
                        i3 = 0;
                    } else
                    {
                        i3 = zziz.length;
                    }
                    ai11 = new int[i8 + i3];
                    i8 = i3;
                    if (i3 != 0)
                    {
                        System.arraycopy(zziz, 0, ai11, 0, i3);
                        i8 = i3;
                    }
                    for (; i8 < ai11.length; i8++)
                    {
                        ai11[i8] = zzrw1.zzFr();
                    }

                    zziz = ai11;
                    zzrw1.zzlD(k11);
                    break;

                case 56: // '8'
                    int j8 = zzsh.zzc(zzrw1, 56);
                    int ai12[];
                    int j3;
                    if (zziA == null)
                    {
                        j3 = 0;
                    } else
                    {
                        j3 = zziA.length;
                    }
                    ai12 = new int[j8 + j3];
                    j8 = j3;
                    if (j3 != 0)
                    {
                        System.arraycopy(zziA, 0, ai12, 0, j3);
                        j8 = j3;
                    }
                    for (; j8 < ai12.length - 1; j8++)
                    {
                        ai12[j8] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai12[j8] = zzrw1.zzFr();
                    zziA = ai12;
                    break;

                case 58: // ':'
                    int l11 = zzrw1.zzlC(zzrw1.zzFv());
                    int k3 = zzrw1.getPosition();
                    int k8;
                    for (k8 = 0; zzrw1.zzFA() > 0; k8++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(k3);
                    int ai13[];
                    if (zziA == null)
                    {
                        k3 = 0;
                    } else
                    {
                        k3 = zziA.length;
                    }
                    ai13 = new int[k8 + k3];
                    k8 = k3;
                    if (k3 != 0)
                    {
                        System.arraycopy(zziA, 0, ai13, 0, k3);
                        k8 = k3;
                    }
                    for (; k8 < ai13.length; k8++)
                    {
                        ai13[k8] = zzrw1.zzFr();
                    }

                    zziA = ai13;
                    zzrw1.zzlD(l11);
                    break;

                case 64: // '@'
                    int l8 = zzsh.zzc(zzrw1, 64);
                    int ai14[];
                    int l3;
                    if (zziB == null)
                    {
                        l3 = 0;
                    } else
                    {
                        l3 = zziB.length;
                    }
                    ai14 = new int[l8 + l3];
                    l8 = l3;
                    if (l3 != 0)
                    {
                        System.arraycopy(zziB, 0, ai14, 0, l3);
                        l8 = l3;
                    }
                    for (; l8 < ai14.length - 1; l8++)
                    {
                        ai14[l8] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai14[l8] = zzrw1.zzFr();
                    zziB = ai14;
                    break;

                case 66: // 'B'
                    int i12 = zzrw1.zzlC(zzrw1.zzFv());
                    int i4 = zzrw1.getPosition();
                    int i9;
                    for (i9 = 0; zzrw1.zzFA() > 0; i9++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(i4);
                    int ai15[];
                    if (zziB == null)
                    {
                        i4 = 0;
                    } else
                    {
                        i4 = zziB.length;
                    }
                    ai15 = new int[i9 + i4];
                    i9 = i4;
                    if (i4 != 0)
                    {
                        System.arraycopy(zziB, 0, ai15, 0, i4);
                        i9 = i4;
                    }
                    for (; i9 < ai15.length; i9++)
                    {
                        ai15[i9] = zzrw1.zzFr();
                    }

                    zziB = ai15;
                    zzrw1.zzlD(i12);
                    break;

                case 72: // 'H'
                    int j9 = zzsh.zzc(zzrw1, 72);
                    int ai16[];
                    int j4;
                    if (zziC == null)
                    {
                        j4 = 0;
                    } else
                    {
                        j4 = zziC.length;
                    }
                    ai16 = new int[j9 + j4];
                    j9 = j4;
                    if (j4 != 0)
                    {
                        System.arraycopy(zziC, 0, ai16, 0, j4);
                        j9 = j4;
                    }
                    for (; j9 < ai16.length - 1; j9++)
                    {
                        ai16[j9] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai16[j9] = zzrw1.zzFr();
                    zziC = ai16;
                    break;

                case 74: // 'J'
                    int j12 = zzrw1.zzlC(zzrw1.zzFv());
                    int k4 = zzrw1.getPosition();
                    int k9;
                    for (k9 = 0; zzrw1.zzFA() > 0; k9++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(k4);
                    int ai17[];
                    if (zziC == null)
                    {
                        k4 = 0;
                    } else
                    {
                        k4 = zziC.length;
                    }
                    ai17 = new int[k9 + k4];
                    k9 = k4;
                    if (k4 != 0)
                    {
                        System.arraycopy(zziC, 0, ai17, 0, k4);
                        k9 = k4;
                    }
                    for (; k9 < ai17.length; k9++)
                    {
                        ai17[k9] = zzrw1.zzFr();
                    }

                    zziC = ai17;
                    zzrw1.zzlD(j12);
                    break;

                case 80: // 'P'
                    int l9 = zzsh.zzc(zzrw1, 80);
                    int ai18[];
                    int l4;
                    if (zziD == null)
                    {
                        l4 = 0;
                    } else
                    {
                        l4 = zziD.length;
                    }
                    ai18 = new int[l9 + l4];
                    l9 = l4;
                    if (l4 != 0)
                    {
                        System.arraycopy(zziD, 0, ai18, 0, l4);
                        l9 = l4;
                    }
                    for (; l9 < ai18.length - 1; l9++)
                    {
                        ai18[l9] = zzrw1.zzFr();
                        zzrw1.zzFo();
                    }

                    ai18[l9] = zzrw1.zzFr();
                    zziD = ai18;
                    break;

                case 82: // 'R'
                    int k12 = zzrw1.zzlC(zzrw1.zzFv());
                    int i5 = zzrw1.getPosition();
                    int i10;
                    for (i10 = 0; zzrw1.zzFA() > 0; i10++)
                    {
                        zzrw1.zzFr();
                    }

                    zzrw1.zzlE(i5);
                    int ai19[];
                    if (zziD == null)
                    {
                        i5 = 0;
                    } else
                    {
                        i5 = zziD.length;
                    }
                    ai19 = new int[i10 + i5];
                    i10 = i5;
                    if (i5 != 0)
                    {
                        System.arraycopy(zziD, 0, ai19, 0, i5);
                        i10 = i5;
                    }
                    for (; i10 < ai19.length; i10++)
                    {
                        ai19[i10] = zzrw1.zzFr();
                    }

                    zziD = ai19;
                    zzrw1.zzlD(k12);
                    break;
                }
            } while (true);
        }

        public zzg()
        {
            zzL();
        }
    }

    public static final class zzj extends zzry
    {

        public zzi zziQ[];
        public zzf zziR;
        public String zziS;

        public static zzj zzd(byte abyte0[])
            throws zzsd
        {
            return (zzj)zzse.zza(new zzj(), abyte0);
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
            if (!(obj instanceof zzj)) goto _L4; else goto _L3
_L3:
            obj = (zzj)obj;
            flag = flag1;
            if (!zzsc.equals(zziQ, ((zzj) (obj)).zziQ)) goto _L4; else goto _L5
_L5:
            if (zziR != null) goto _L7; else goto _L6
_L6:
            flag = flag1;
            if (((zzj) (obj)).zziR != null) goto _L4; else goto _L8
_L8:
            if (zziS != null) goto _L10; else goto _L9
_L9:
            flag = flag1;
            if (((zzj) (obj)).zziS != null) goto _L4; else goto _L11
_L11:
            if (zzbik != null && !zzbik.isEmpty())
            {
                break MISSING_BLOCK_LABEL_143;
            }
            if (((zzj) (obj)).zzbik == null)
            {
                break; /* Loop/switch isn't completed */
            }
            flag = flag1;
            if (!((zzj) (obj)).zzbik.isEmpty()) goto _L4; else goto _L12
_L12:
            return true;
_L7:
            if (!zziR.equals(((zzj) (obj)).zziR))
            {
                return false;
            }
              goto _L8
_L10:
            if (!zziS.equals(((zzj) (obj)).zziS))
            {
                return false;
            }
              goto _L11
            return zzbik.equals(((zzj) (obj)).zzbik);
              goto _L8
        }

        public int hashCode()
        {
            boolean flag = false;
            int l = getClass().getName().hashCode();
            int i1 = zzsc.hashCode(zziQ);
            int i;
            int j;
            int k;
            if (zziR == null)
            {
                i = 0;
            } else
            {
                i = zziR.hashCode();
            }
            if (zziS == null)
            {
                j = 0;
            } else
            {
                j = zziS.hashCode();
            }
            k = ((flag) ? 1 : 0);
            if (zzbik != null)
            {
                if (zzbik.isEmpty())
                {
                    k = ((flag) ? 1 : 0);
                } else
                {
                    k = zzbik.hashCode();
                }
            }
            return (j + (i + ((l + 527) * 31 + i1) * 31) * 31) * 31 + k;
        }

        protected int zzB()
        {
            int i = super.zzB();
            int j = i;
            if (zziQ != null)
            {
                j = i;
                if (zziQ.length > 0)
                {
                    int k = 0;
                    do
                    {
                        j = i;
                        if (k >= zziQ.length)
                        {
                            break;
                        }
                        zzi zzi1 = zziQ[k];
                        j = i;
                        if (zzi1 != null)
                        {
                            j = i + zzrx.zzc(1, zzi1);
                        }
                        k++;
                        i = j;
                    } while (true);
                }
            }
            i = j;
            if (zziR != null)
            {
                i = j + zzrx.zzc(2, zziR);
            }
            j = i;
            if (!zziS.equals(""))
            {
                j = i + zzrx.zzn(3, zziS);
            }
            return j;
        }

        public zzj zzP()
        {
        /* block-local class not found */
        class zzi {}

            zziQ = zzi.zzN();
            zziR = null;
            zziS = "";
            zzbik = null;
            zzbiv = -1;
            return this;
        }

        public void zza(zzrx zzrx1)
            throws IOException
        {
            if (zziQ != null && zziQ.length > 0)
            {
                for (int i = 0; i < zziQ.length; i++)
                {
                    zzi zzi1 = zziQ[i];
                    if (zzi1 != null)
                    {
                        zzrx1.zza(1, zzi1);
                    }
                }

            }
            if (zziR != null)
            {
                zzrx1.zza(2, zziR);
            }
            if (!zziS.equals(""))
            {
                zzrx1.zzb(3, zziS);
            }
            super.zza(zzrx1);
        }

        public zzse zzb(zzrw zzrw1)
            throws IOException
        {
            return zzk(zzrw1);
        }

        public zzj zzk(zzrw zzrw1)
            throws IOException
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
                    int k = zzsh.zzc(zzrw1, 10);
                    zzi azzi[];
                    int j;
                    if (zziQ == null)
                    {
                        j = 0;
                    } else
                    {
                        j = zziQ.length;
                    }
                    azzi = new zzi[k + j];
                    k = j;
                    if (j != 0)
                    {
                        System.arraycopy(zziQ, 0, azzi, 0, j);
                        k = j;
                    }
                    for (; k < azzi.length - 1; k++)
                    {
                        azzi[k] = new zzi();
                        zzrw1.zza(azzi[k]);
                        zzrw1.zzFo();
                    }

                    azzi[k] = new zzi();
                    zzrw1.zza(azzi[k]);
                    zziQ = azzi;
                    break;

                case 18: // '\022'
                    if (zziR == null)
                    {
                        zziR = new zzf();
                    }
                    zzrw1.zza(zziR);
                    break;

                case 26: // '\032'
                    zziS = zzrw1.readString();
                    break;
                }
            } while (true);
        }

        public zzj()
        {
            zzP();
        }
    }


    // Unreferenced inner class com/google/android/gms/internal/zzaf$zzh
    /* block-local class not found */
    class zzh {}

}
