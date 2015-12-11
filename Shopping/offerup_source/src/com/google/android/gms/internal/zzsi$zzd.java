// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsc, zzsa, zzrx, 
//            zzsh, zzrw, zzse

public final class zzFV extends zzry
{

    public String tag;
    public long zzbiO;
    public long zzbiP;
    public int zzbiQ;
    public int zzbiR;
    public boolean zzbiS;
    public zzJ zzbiT[];
    public zzJ zzbiU;
    public byte zzbiV[];
    public byte zzbiW[];
    public byte zzbiX[];
    public zzJ zzbiY;
    public String zzbiZ;
    public long zzbja;
    public zzJ zzbjb;
    public byte zzbjc[];
    public int zzbjd;
    public int zzbje[];

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzFV))
            {
                return false;
            }
            obj = (zzFV)obj;
            if (zzbiO != ((zzbiO) (obj)).zzbiO)
            {
                return false;
            }
            if (zzbiP != ((zzbiP) (obj)).zzbiP)
            {
                return false;
            }
            if (tag == null)
            {
                if (((tag) (obj)).tag != null)
                {
                    return false;
                }
            } else
            if (!tag.equals(((tag) (obj)).tag))
            {
                return false;
            }
            if (zzbiQ != ((zzbiQ) (obj)).zzbiQ)
            {
                return false;
            }
            if (zzbiR != ((zzbiR) (obj)).zzbiR)
            {
                return false;
            }
            if (zzbiS != ((zzbiS) (obj)).zzbiS)
            {
                return false;
            }
            if (!zzsc.equals(zzbiT, ((zzbiT) (obj)).zzbiT))
            {
                return false;
            }
            if (zzbiU == null)
            {
                if (((zzbiU) (obj)).zzbiU != null)
                {
                    return false;
                }
            } else
            if (!zzbiU.equals(((equals) (obj)).zzbiU))
            {
                return false;
            }
            if (!Arrays.equals(zzbiV, ((zzbiV) (obj)).zzbiV))
            {
                return false;
            }
            if (!Arrays.equals(zzbiW, ((zzbiW) (obj)).zzbiW))
            {
                return false;
            }
            if (!Arrays.equals(zzbiX, ((zzbiX) (obj)).zzbiX))
            {
                return false;
            }
            if (zzbiY == null)
            {
                if (((zzbiY) (obj)).zzbiY != null)
                {
                    return false;
                }
            } else
            if (!zzbiY.equals(((equals) (obj)).zzbiY))
            {
                return false;
            }
            if (zzbiZ == null)
            {
                if (((zzbiZ) (obj)).zzbiZ != null)
                {
                    return false;
                }
            } else
            if (!zzbiZ.equals(((zzbiZ) (obj)).zzbiZ))
            {
                return false;
            }
            if (zzbja != ((zzbja) (obj)).zzbja)
            {
                return false;
            }
            if (zzbjb == null)
            {
                if (((zzbjb) (obj)).zzbjb != null)
                {
                    return false;
                }
            } else
            if (!zzbjb.equals(((equals) (obj)).zzbjb))
            {
                return false;
            }
            if (!Arrays.equals(zzbjc, ((zzbjc) (obj)).zzbjc))
            {
                return false;
            }
            if (zzbjd != ((zzbjd) (obj)).zzbjd)
            {
                return false;
            }
            if (!zzsc.equals(zzbje, ((zzbje) (obj)).zzbje))
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
        int k1 = getClass().getName().hashCode();
        int l1 = (int)(zzbiO ^ zzbiO >>> 32);
        int i2 = (int)(zzbiP ^ zzbiP >>> 32);
        int i;
        char c;
        int j;
        int k;
        int l;
        int i1;
        int j1;
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
        if (tag == null)
        {
            i = 0;
        } else
        {
            i = tag.hashCode();
        }
        j2 = zzbiQ;
        k2 = zzbiR;
        if (zzbiS)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        l2 = zzsc.hashCode(zzbiT);
        if (zzbiU == null)
        {
            j = 0;
        } else
        {
            j = zzbiU.hashCode();
        }
        i3 = Arrays.hashCode(zzbiV);
        j3 = Arrays.hashCode(zzbiW);
        k3 = Arrays.hashCode(zzbiX);
        if (zzbiY == null)
        {
            k = 0;
        } else
        {
            k = zzbiY.hashCode();
        }
        if (zzbiZ == null)
        {
            l = 0;
        } else
        {
            l = zzbiZ.hashCode();
        }
        l3 = (int)(zzbja ^ zzbja >>> 32);
        if (zzbjb == null)
        {
            i1 = 0;
        } else
        {
            i1 = zzbjb.hashCode();
        }
        i4 = Arrays.hashCode(zzbjc);
        j4 = zzbjd;
        k4 = zzsc.hashCode(zzbje);
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
        return ((((i1 + ((l + (k + ((((j + ((c + (((i + (((k1 + 527) * 31 + l1) * 31 + i2) * 31) * 31 + j2) * 31 + k2) * 31) * 31 + l2) * 31) * 31 + i3) * 31 + j3) * 31 + k3) * 31) * 31) * 31 + l3) * 31) * 31 + i4) * 31 + j4) * 31 + k4) * 31 + j1;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int i = super.zzB();
        int j = i;
        if (zzbiO != 0L)
        {
            j = i + zzrx.zzd(1, zzbiO);
        }
        i = j;
        if (!tag.equals(""))
        {
            i = j + zzrx.zzn(2, tag);
        }
        j = i;
        if (zzbiT != null)
        {
            j = i;
            if (zzbiT.length > 0)
            {
                for (j = 0; j < zzbiT.length;)
                {
                    Code code = zzbiT[j];
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
        if (!Arrays.equals(zzbiV, zzsh.zzbiE))
        {
            i = j + zzrx.zzb(6, zzbiV);
        }
        j = i;
        if (zzbiY != null)
        {
            j = i + zzrx.zzc(7, zzbiY);
        }
        i = j;
        if (!Arrays.equals(zzbiW, zzsh.zzbiE))
        {
            i = j + zzrx.zzb(8, zzbiW);
        }
        j = i;
        if (zzbiU != null)
        {
            j = i + zzrx.zzc(9, zzbiU);
        }
        i = j;
        if (zzbiS)
        {
            i = j + zzrx.zzc(10, zzbiS);
        }
        j = i;
        if (zzbiQ != 0)
        {
            j = i + zzrx.zzA(11, zzbiQ);
        }
        i = j;
        if (zzbiR != 0)
        {
            i = j + zzrx.zzA(12, zzbiR);
        }
        j = i;
        if (!Arrays.equals(zzbiX, zzsh.zzbiE))
        {
            j = i + zzrx.zzb(13, zzbiX);
        }
        i = j;
        if (!zzbiZ.equals(""))
        {
            i = j + zzrx.zzn(14, zzbiZ);
        }
        j = i;
        if (zzbja != 0x2bf20L)
        {
            j = i + zzrx.zze(15, zzbja);
        }
        i = j;
        if (zzbjb != null)
        {
            i = j + zzrx.zzc(16, zzbjb);
        }
        j = i;
        if (zzbiP != 0L)
        {
            j = i + zzrx.zzd(17, zzbiP);
        }
        int l = j;
        if (!Arrays.equals(zzbjc, zzsh.zzbiE))
        {
            l = j + zzrx.zzb(18, zzbjc);
        }
        i = l;
        if (zzbjd != 0)
        {
            i = l + zzrx.zzA(19, zzbjd);
        }
        j = i;
        if (zzbje != null)
        {
            j = i;
            if (zzbje.length > 0)
            {
                int i1 = 0;
                for (j = ((flag) ? 1 : 0); j < zzbje.length; j++)
                {
                    i1 += zzrx.zzlJ(zzbje[j]);
                }

                j = i + i1 + zzbje.length * 2;
            }
        }
        return j;
    }

    public final zzbje zzFV()
    {
        zzbiO = 0L;
        zzbiP = 0L;
        tag = "";
        zzbiQ = 0;
        zzbiR = 0;
        zzbiS = false;
        zzbiT = zzFW();
        zzbiU = null;
        zzbiV = zzsh.zzbiE;
        zzbiW = zzsh.zzbiE;
        zzbiX = zzsh.zzbiE;
        zzbiY = null;
        zzbiZ = "";
        zzbja = 0x2bf20L;
        zzbjb = null;
        zzbjc = zzsh.zzbiE;
        zzbjd = 0;
        zzbje = zzsh.zzbix;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final zzbiv zzJ(zzrw zzrw1)
    {
_L22:
        int i = zzrw1.zzFo();
        i;
        JVM INSTR lookupswitch 20: default 176
    //                   0: 185
    //                   8: 187
    //                   18: 198
    //                   26: 209
    //                   50: 333
    //                   58: 344
    //                   66: 373
    //                   74: 384
    //                   80: 413
    //                   88: 424
    //                   96: 435
    //                   106: 446
    //                   114: 457
    //                   120: 468
    //                   130: 479
    //                   136: 508
    //                   146: 519
    //                   152: 530
    //                   160: 575
    //                   162: 677;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
        if (zza(zzrw1, i)) goto _L22; else goto _L2
_L2:
        return this;
_L3:
        zzbiO = zzrw1.zzFq();
          goto _L22
_L4:
        tag = zzrw1.readString();
          goto _L22
_L5:
        int j1 = zzsh.zzc(zzrw1, 26);
        zzbiv azzbiv[];
        int j;
        if (zzbiT == null)
        {
            j = 0;
        } else
        {
            j = zzbiT.length;
        }
        azzbiv = new zzbiT[j1 + j];
        j1 = j;
        if (j != 0)
        {
            System.arraycopy(zzbiT, 0, azzbiv, 0, j);
            j1 = j;
        }
        for (; j1 < azzbiv.length - 1; j1++)
        {
            azzbiv[j1] = new <init>();
            zzrw1.zza(azzbiv[j1]);
            zzrw1.zzFo();
        }

        azzbiv[j1] = new <init>();
        zzrw1.zza(azzbiv[j1]);
        zzbiT = azzbiv;
          goto _L22
_L6:
        zzbiV = zzrw1.readBytes();
          goto _L22
_L7:
        if (zzbiY == null)
        {
            zzbiY = new <init>();
        }
        zzrw1.zza(zzbiY);
          goto _L22
_L8:
        zzbiW = zzrw1.readBytes();
          goto _L22
_L9:
        if (zzbiU == null)
        {
            zzbiU = new <init>();
        }
        zzrw1.zza(zzbiU);
          goto _L22
_L10:
        zzbiS = zzrw1.zzFs();
          goto _L22
_L11:
        zzbiQ = zzrw1.zzFr();
          goto _L22
_L12:
        zzbiR = zzrw1.zzFr();
          goto _L22
_L13:
        zzbiX = zzrw1.readBytes();
          goto _L22
_L14:
        zzbiZ = zzrw1.readString();
          goto _L22
_L15:
        zzbja = zzrw1.zzFu();
          goto _L22
_L16:
        if (zzbjb == null)
        {
            zzbjb = new <init>();
        }
        zzrw1.zza(zzbjb);
          goto _L22
_L17:
        zzbiP = zzrw1.zzFq();
          goto _L22
_L18:
        zzbjc = zzrw1.readBytes();
          goto _L22
_L19:
        int k = zzrw1.zzFr();
        switch (k)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            zzbjd = k;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L20:
        int k1 = zzsh.zzc(zzrw1, 160);
        int ai[];
        int l;
        if (zzbje == null)
        {
            l = 0;
        } else
        {
            l = zzbje.length;
        }
        ai = new int[k1 + l];
        k1 = l;
        if (l != 0)
        {
            System.arraycopy(zzbje, 0, ai, 0, l);
            k1 = l;
        }
        for (; k1 < ai.length - 1; k1++)
        {
            ai[k1] = zzrw1.zzFr();
            zzrw1.zzFo();
        }

        ai[k1] = zzrw1.zzFr();
        zzbje = ai;
        continue; /* Loop/switch isn't completed */
_L21:
        int i2 = zzrw1.zzlC(zzrw1.zzFv());
        int i1 = zzrw1.getPosition();
        int l1;
        for (l1 = 0; zzrw1.zzFA() > 0; l1++)
        {
            zzrw1.zzFr();
        }

        zzrw1.zzlE(i1);
        int ai1[];
        if (zzbje == null)
        {
            i1 = 0;
        } else
        {
            i1 = zzbje.length;
        }
        ai1 = new int[l1 + i1];
        l1 = i1;
        if (i1 != 0)
        {
            System.arraycopy(zzbje, 0, ai1, 0, i1);
            l1 = i1;
        }
        for (; l1 < ai1.length; l1++)
        {
            ai1[l1] = zzrw1.zzFr();
        }

        zzbje = ai1;
        zzrw1.zzlD(i2);
        if (true) goto _L22; else goto _L23
_L23:
    }

    public final void zza(zzrx zzrx1)
    {
        boolean flag = false;
        if (zzbiO != 0L)
        {
            zzrx1.zzb(1, zzbiO);
        }
        if (!tag.equals(""))
        {
            zzrx1.zzb(2, tag);
        }
        if (zzbiT != null && zzbiT.length > 0)
        {
            for (int i = 0; i < zzbiT.length; i++)
            {
                  = zzbiT[i];
                if ( != null)
                {
                    zzrx1.zza(3, );
                }
            }

        }
        if (!Arrays.equals(zzbiV, zzsh.zzbiE))
        {
            zzrx1.zza(6, zzbiV);
        }
        if (zzbiY != null)
        {
            zzrx1.zza(7, zzbiY);
        }
        if (!Arrays.equals(zzbiW, zzsh.zzbiE))
        {
            zzrx1.zza(8, zzbiW);
        }
        if (zzbiU != null)
        {
            zzrx1.zza(9, zzbiU);
        }
        if (zzbiS)
        {
            zzrx1.zzb(10, zzbiS);
        }
        if (zzbiQ != 0)
        {
            zzrx1.zzy(11, zzbiQ);
        }
        if (zzbiR != 0)
        {
            zzrx1.zzy(12, zzbiR);
        }
        if (!Arrays.equals(zzbiX, zzsh.zzbiE))
        {
            zzrx1.zza(13, zzbiX);
        }
        if (!zzbiZ.equals(""))
        {
            zzrx1.zzb(14, zzbiZ);
        }
        if (zzbja != 0x2bf20L)
        {
            zzrx1.zzc(15, zzbja);
        }
        if (zzbjb != null)
        {
            zzrx1.zza(16, zzbjb);
        }
        if (zzbiP != 0L)
        {
            zzrx1.zzb(17, zzbiP);
        }
        if (!Arrays.equals(zzbjc, zzsh.zzbiE))
        {
            zzrx1.zza(18, zzbjc);
        }
        if (zzbjd != 0)
        {
            zzrx1.zzy(19, zzbjd);
        }
        if (zzbje != null && zzbje.length > 0)
        {
            for (int j = ((flag) ? 1 : 0); j < zzbje.length; j++)
            {
                zzrx1.zzy(20, zzbje[j]);
            }

        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzJ(zzrw1);
    }

    public ()
    {
        zzFV();
    }
}
