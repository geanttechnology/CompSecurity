// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzsh, zzrw, zzse

public final class zzR extends zzry
{

    private static volatile  zziT[];
    public int type;
    public String zziU;
    public  zziV[];
    public  zziW[];
    public  zziX[];
    public String zziY;
    public String zziZ;
    public long zzja;
    public boolean zzjb;
    public  zzjc[];
    public int zzjd[];
    public boolean zzje;

    public static zzR[] zzQ()
    {
        if (zziT == null)
        {
            synchronized (zzsc.zzbiu)
            {
                if (zziT == null)
                {
                    zziT = new zziT[0];
                }
            }
        }
        return zziT;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zziT))
            {
                return false;
            }
            obj = (zziT)obj;
            if (type != ((type) (obj)).type)
            {
                return false;
            }
            if (zziU == null)
            {
                if (((zziU) (obj)).zziU != null)
                {
                    return false;
                }
            } else
            if (!zziU.equals(((zziU) (obj)).zziU))
            {
                return false;
            }
            if (!zzsc.equals(zziV, ((zziV) (obj)).zziV))
            {
                return false;
            }
            if (!zzsc.equals(zziW, ((zziW) (obj)).zziW))
            {
                return false;
            }
            if (!zzsc.equals(zziX, ((zziX) (obj)).zziX))
            {
                return false;
            }
            if (zziY == null)
            {
                if (((zziY) (obj)).zziY != null)
                {
                    return false;
                }
            } else
            if (!zziY.equals(((zziY) (obj)).zziY))
            {
                return false;
            }
            if (zziZ == null)
            {
                if (((zziZ) (obj)).zziZ != null)
                {
                    return false;
                }
            } else
            if (!zziZ.equals(((zziZ) (obj)).zziZ))
            {
                return false;
            }
            if (zzja != ((zzja) (obj)).zzja)
            {
                return false;
            }
            if (zzjb != ((zzjb) (obj)).zzjb)
            {
                return false;
            }
            if (!zzsc.equals(zzjc, ((zzjc) (obj)).zzjc))
            {
                return false;
            }
            if (!zzsc.equals(zzjd, ((zzjd) (obj)).zzjd))
            {
                return false;
            }
            if (zzje != ((zzje) (obj)).zzje)
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
        char c1 = '\u04CF';
        boolean flag = false;
        int i1 = getClass().getName().hashCode();
        int j1 = type;
        int i;
        int j;
        int k;
        char c;
        int l;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (zziU == null)
        {
            i = 0;
        } else
        {
            i = zziU.hashCode();
        }
        k1 = zzsc.hashCode(zziV);
        l1 = zzsc.hashCode(zziW);
        i2 = zzsc.hashCode(zziX);
        if (zziY == null)
        {
            j = 0;
        } else
        {
            j = zziY.hashCode();
        }
        if (zziZ == null)
        {
            k = 0;
        } else
        {
            k = zziZ.hashCode();
        }
        j2 = (int)(zzja ^ zzja >>> 32);
        if (zzjb)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        k2 = zzsc.hashCode(zzjc);
        l2 = zzsc.hashCode(zzjd);
        if (!zzje)
        {
            c1 = '\u04D5';
        }
        l = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                l = ((flag) ? 1 : 0);
            } else
            {
                l = zzbik.hashCode();
            }
        }
        return ((((c + ((k + (j + ((((i + ((i1 + 527) * 31 + j1) * 31) * 31 + k1) * 31 + l1) * 31 + i2) * 31) * 31) * 31 + j2) * 31) * 31 + k2) * 31 + l2) * 31 + c1) * 31 + l;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int j = super.zzB() + zzrx.zzA(1, type);
        int i = j;
        if (!zziU.equals(""))
        {
            i = j + zzrx.zzn(2, zziU);
        }
        j = i;
        if (zziV != null)
        {
            j = i;
            if (zziV.length > 0)
            {
                for (j = 0; j < zziV.length;)
                {
                    Code code = zziV[j];
                    int k = i;
                    if (code != null)
                    {
                        k = i + zzrx.zzc(3, code);
                    }
                    j++;
                    i = k;
                }

                j = i;
            }
        }
        i = j;
        if (zziW != null)
        {
            i = j;
            if (zziW.length > 0)
            {
                i = j;
                for (j = 0; j < zziW.length;)
                {
                    Code code1 = zziW[j];
                    int l = i;
                    if (code1 != null)
                    {
                        l = i + zzrx.zzc(4, code1);
                    }
                    j++;
                    i = l;
                }

            }
        }
        j = i;
        if (zziX != null)
        {
            j = i;
            if (zziX.length > 0)
            {
                for (j = 0; j < zziX.length;)
                {
                    Code code2 = zziX[j];
                    int i1 = i;
                    if (code2 != null)
                    {
                        i1 = i + zzrx.zzc(5, code2);
                    }
                    j++;
                    i = i1;
                }

                j = i;
            }
        }
        i = j;
        if (!zziY.equals(""))
        {
            i = j + zzrx.zzn(6, zziY);
        }
        j = i;
        if (!zziZ.equals(""))
        {
            j = i + zzrx.zzn(7, zziZ);
        }
        i = j;
        if (zzja != 0L)
        {
            i = j + zzrx.zzd(8, zzja);
        }
        j = i;
        if (zzje)
        {
            j = i + zzrx.zzc(9, zzje);
        }
        i = j;
        if (zzjd != null)
        {
            i = j;
            if (zzjd.length > 0)
            {
                i = 0;
                int j1 = 0;
                for (; i < zzjd.length; i++)
                {
                    j1 += zzrx.zzlJ(zzjd[i]);
                }

                i = j + j1 + zzjd.length * 1;
            }
        }
        j = i;
        if (zzjc != null)
        {
            j = i;
            if (zzjc.length > 0)
            {
                int k1 = ((flag) ? 1 : 0);
                do
                {
                    j = i;
                    if (k1 >= zzjc.length)
                    {
                        break;
                    }
                    Code code3 = zzjc[k1];
                    j = i;
                    if (code3 != null)
                    {
                        j = i + zzrx.zzc(11, code3);
                    }
                    k1++;
                    i = j;
                } while (true);
            }
        }
        i = j;
        if (zzjb)
        {
            i = j + zzrx.zzc(12, zzjb);
        }
        return i;
    }

    public final zzjb zzR()
    {
        type = 1;
        zziU = "";
        zziV = zzQ();
        zziW = zzQ();
        zziX = zzQ();
        zziY = "";
        zziZ = "";
        zzja = 0L;
        zzjb = false;
        zzjc = zzQ();
        zzjd = zzsh.zzbix;
        zzje = false;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        boolean flag = false;
        zzrx1.zzy(1, type);
        if (!zziU.equals(""))
        {
            zzrx1.zzb(2, zziU);
        }
        if (zziV != null && zziV.length > 0)
        {
            for (int i = 0; i < zziV.length; i++)
            {
                zzbiv zzbiv = zziV[i];
                if (zzbiv != null)
                {
                    zzrx1.zza(3, zzbiv);
                }
            }

        }
        if (zziW != null && zziW.length > 0)
        {
            for (int j = 0; j < zziW.length; j++)
            {
                zzbiv zzbiv1 = zziW[j];
                if (zzbiv1 != null)
                {
                    zzrx1.zza(4, zzbiv1);
                }
            }

        }
        if (zziX != null && zziX.length > 0)
        {
            for (int k = 0; k < zziX.length; k++)
            {
                zzbiv zzbiv2 = zziX[k];
                if (zzbiv2 != null)
                {
                    zzrx1.zza(5, zzbiv2);
                }
            }

        }
        if (!zziY.equals(""))
        {
            zzrx1.zzb(6, zziY);
        }
        if (!zziZ.equals(""))
        {
            zzrx1.zzb(7, zziZ);
        }
        if (zzja != 0L)
        {
            zzrx1.zzb(8, zzja);
        }
        if (zzje)
        {
            zzrx1.zzb(9, zzje);
        }
        if (zzjd != null && zzjd.length > 0)
        {
            for (int l = 0; l < zzjd.length; l++)
            {
                zzrx1.zzy(10, zzjd[l]);
            }

        }
        if (zzjc != null && zzjc.length > 0)
        {
            for (int i1 = ((flag) ? 1 : 0); i1 < zzjc.length; i1++)
            {
                zzbiv zzbiv3 = zzjc[i1];
                if (zzbiv3 != null)
                {
                    zzrx1.zza(11, zzbiv3);
                }
            }

        }
        if (zzjb)
        {
            zzrx1.zzb(12, zzjb);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzl(zzrw1);
    }

    public final zzl zzl(zzrw zzrw1)
    {
_L16:
        int i = zzrw1.zzFo();
        i;
        JVM INSTR lookupswitch 14: default 132
    //                   0: 142
    //                   8: 144
    //                   18: 212
    //                   26: 223
    //                   34: 354
    //                   42: 485
    //                   50: 616
    //                   58: 627
    //                   64: 638
    //                   72: 649
    //                   80: 660
    //                   82: 904
    //                   90: 1222
    //                   96: 1353;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        if (zza(zzrw1, i)) goto _L16; else goto _L2
_L2:
        return this;
_L3:
        i = zzrw1.zzFr();
        switch (i)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            type = i;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        zziU = zzrw1.readString();
        continue; /* Loop/switch isn't completed */
_L5:
        int k = zzsh.zzc(zzrw1, 26);
        zzl azzl[];
        if (zziV == null)
        {
            i = 0;
        } else
        {
            i = zziV.length;
        }
        azzl = new zziV[k + i];
        k = i;
        if (i != 0)
        {
            System.arraycopy(zziV, 0, azzl, 0, i);
            k = i;
        }
        for (; k < azzl.length - 1; k++)
        {
            azzl[k] = new <init>();
            zzrw1.zza(azzl[k]);
            zzrw1.zzFo();
        }

        azzl[k] = new <init>();
        zzrw1.zza(azzl[k]);
        zziV = azzl;
        continue; /* Loop/switch isn't completed */
_L6:
        int l = zzsh.zzc(zzrw1, 34);
        zzl azzl1[];
        if (zziW == null)
        {
            i = 0;
        } else
        {
            i = zziW.length;
        }
        azzl1 = new zziW[l + i];
        l = i;
        if (i != 0)
        {
            System.arraycopy(zziW, 0, azzl1, 0, i);
            l = i;
        }
        for (; l < azzl1.length - 1; l++)
        {
            azzl1[l] = new <init>();
            zzrw1.zza(azzl1[l]);
            zzrw1.zzFo();
        }

        azzl1[l] = new <init>();
        zzrw1.zza(azzl1[l]);
        zziW = azzl1;
        continue; /* Loop/switch isn't completed */
_L7:
        int i1 = zzsh.zzc(zzrw1, 42);
        zzl azzl2[];
        if (zziX == null)
        {
            i = 0;
        } else
        {
            i = zziX.length;
        }
        azzl2 = new zziX[i1 + i];
        i1 = i;
        if (i != 0)
        {
            System.arraycopy(zziX, 0, azzl2, 0, i);
            i1 = i;
        }
        for (; i1 < azzl2.length - 1; i1++)
        {
            azzl2[i1] = new <init>();
            zzrw1.zza(azzl2[i1]);
            zzrw1.zzFo();
        }

        azzl2[i1] = new <init>();
        zzrw1.zza(azzl2[i1]);
        zziX = azzl2;
        continue; /* Loop/switch isn't completed */
_L8:
        zziY = zzrw1.readString();
        continue; /* Loop/switch isn't completed */
_L9:
        zziZ = zzrw1.readString();
        continue; /* Loop/switch isn't completed */
_L10:
        zzja = zzrw1.zzFq();
        continue; /* Loop/switch isn't completed */
_L11:
        zzje = zzrw1.zzFs();
        continue; /* Loop/switch isn't completed */
_L12:
        int ai[];
        int j1;
        int j2;
        j2 = zzsh.zzc(zzrw1, 80);
        ai = new int[j2];
        j1 = 0;
        i = 0;
_L22:
        if (j1 >= j2) goto _L18; else goto _L17
_L17:
        int k2;
        if (j1 != 0)
        {
            zzrw1.zzFo();
        }
        k2 = zzrw1.zzFr();
        k2;
        JVM INSTR tableswitch 1 17: default 788
    //                   1 797
    //                   2 797
    //                   3 797
    //                   4 797
    //                   5 797
    //                   6 797
    //                   7 797
    //                   8 797
    //                   9 797
    //                   10 797
    //                   11 797
    //                   12 797
    //                   13 797
    //                   14 797
    //                   15 797
    //                   16 797
    //                   17 797;
           goto _L19 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20 _L20
_L19:
        j1++;
        continue; /* Loop/switch isn't completed */
_L20:
        int l1 = i + 1;
        ai[i] = k2;
        i = l1;
        if (true) goto _L19; else goto _L18
_L18:
        if (i != 0)
        {
            if (zzjd == null)
            {
                j1 = 0;
            } else
            {
                j1 = zzjd.length;
            }
            if (j1 == 0 && i == j2)
            {
                zzjd = ai;
            } else
            {
                int ai1[] = new int[j1 + i];
                if (j1 != 0)
                {
                    System.arraycopy(zzjd, 0, ai1, 0, j1);
                }
                System.arraycopy(ai, 0, ai1, j1, i);
                zzjd = ai1;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L22; else goto _L21
_L21:
_L13:
        int i2;
        i2 = zzrw1.zzlC(zzrw1.zzFv());
        i = zzrw1.getPosition();
        j1 = 0;
_L28:
        if (zzrw1.zzFA() > 0)
        {
            switch (zzrw1.zzFr())
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
                j1++;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (j1 == 0) goto _L24; else goto _L23
_L23:
        zzrw1.zzlE(i);
        if (zzjd == null)
        {
            i = 0;
        } else
        {
            i = zzjd.length;
        }
        ai = new int[j1 + i];
        j1 = i;
        if (i != 0)
        {
            System.arraycopy(zzjd, 0, ai, 0, i);
            j1 = i;
        }
_L26:
        if (zzrw1.zzFA() > 0)
        {
            i = zzrw1.zzFr();
            switch (i)
            {
            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
                ai[j1] = i;
                j1++;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        zzjd = ai;
_L24:
        zzrw1.zzlD(i2);
        continue; /* Loop/switch isn't completed */
        if (true) goto _L26; else goto _L25
_L25:
        if (true) goto _L28; else goto _L27
_L27:
_L14:
        int k1 = zzsh.zzc(zzrw1, 90);
        zzl azzl3[];
        int j;
        if (zzjc == null)
        {
            j = 0;
        } else
        {
            j = zzjc.length;
        }
        azzl3 = new zzjc[k1 + j];
        k1 = j;
        if (j != 0)
        {
            System.arraycopy(zzjc, 0, azzl3, 0, j);
            k1 = j;
        }
        for (; k1 < azzl3.length - 1; k1++)
        {
            azzl3[k1] = new <init>();
            zzrw1.zza(azzl3[k1]);
            zzrw1.zzFo();
        }

        azzl3[k1] = new <init>();
        zzrw1.zza(azzl3[k1]);
        zzjc = azzl3;
        continue; /* Loop/switch isn't completed */
_L15:
        zzjb = zzrw1.zzFs();
        if (true) goto _L16; else goto _L29
_L29:
    }

    public ()
    {
        zzR();
    }
}
